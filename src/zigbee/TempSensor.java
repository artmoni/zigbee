package zigbee;

import com.rapplogic.xbee.api.XBeeAddress64;
import com.rapplogic.xbee.api.zigbee.ZNetRxIoSampleResponse;

public class TempSensor extends Sensor {

	public TempSensor(XBeeAddress64 address64R, String nameProbeR, ZNetRxIoSampleResponse samplesR) {
		super(address64R, nameProbeR, samplesR);
	}

	public int getTemp() {
		return samples.getAnalog1();
	}
}