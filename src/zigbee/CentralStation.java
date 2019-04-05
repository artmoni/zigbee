package zigbee;

import java.util.HashMap;

import com.rapplogic.xbee.api.ApiId;
import com.rapplogic.xbee.api.AtCommand;
import com.rapplogic.xbee.api.XBee;
import com.rapplogic.xbee.api.XBeeAddress64;
import com.rapplogic.xbee.api.XBeeException;
import com.rapplogic.xbee.api.XBeeResponse;
import com.rapplogic.xbee.api.XBeeTimeoutException;
import com.rapplogic.xbee.api.zigbee.ZNetRxIoSampleResponse;

public class CentralStation {

	/* Constants */

	// TODO Replace with the serial port where your receiver module is connected.
	private static final String PORT = "/dev/ttyUSB0";
	// TODO Replace with the baud rate of you receiver module.
	private static final int BAUD_RATE = 9600;
	private int Lumens = 0;

	HashMap<XBeeAddress64, Probe> myProbes = new HashMap<XBeeAddress64, Probe>();

	XBee xbee = new XBee();

	public CentralStation() {

	}

	public void initialize() {
		try {
			xbee.open(PORT, BAUD_RATE);
			while (true) {
				try {
					XBeeResponse response = xbee.getResponse();
					if (response.getApiId() == ApiId.ZNET_IO_SAMPLE_RESPONSE) {
						ZNetRxIoSampleResponse ioSample = (ZNetRxIoSampleResponse) response;
						XBeeAddress64 remoteAddress64 = ioSample.getRemoteAddress64();
						if (!myProbes.containsKey(remoteAddress64)) {
							myProbes.put(remoteAddress64, new Probe(remoteAddress64, "Probe", ioSample));
						}

						Probe currentProbe = myProbes.get(remoteAddress64);
						currentProbe.update(ioSample);
						Lumens = currentProbe.getLumens();
						if (Lumens == 500) {
							System.out.println("La luminosité ambiante est moyenne.");
						} else if (Lumens == 10000) {
							System.out.println("La luminosité ambiante est élevée.");
						} else {
							System.out.println("La luminosité ambiante est basse.");
						}
						System.out.println("Analog D1 (pin 20) 10-bit reading is " + currentProbe.getTemp());
						if (currentProbe.getTemp() > 10)
						{
							xbee.sendAsynchronous(new AtCommand("D0", 5));
							xbee.sendAsynchronous(new AtCommand("D2", 4));
						}
						else
						{
							xbee.sendAsynchronous(new AtCommand("D0", 4));
							xbee.sendAsynchronous(new AtCommand("D2", 5));
						}
					}
				} catch (XBeeTimeoutException ex) {
					System.out.println("RESPONSE ERROR");
				}
			}
		} catch (XBeeException ex) {
			System.out.println("CONNECTION ERROR");
		}
	}

}
