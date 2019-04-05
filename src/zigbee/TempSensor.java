package zigbee;

import com.rapplogic.xbee.api.XBeeAddress64;
import com.rapplogic.xbee.api.zigbee.ZNetRxIoSampleResponse;

public class TempSensor extends Sensor {
	public int temp;

	public TempSensor(XBeeAddress64 address64R, String nameProbeR, ZNetRxIoSampleResponse samplesR) {
		super(address64R, nameProbeR, samplesR);
		temp = 0;
	}

	public int getTemp() {
		return temp;
	}

	public void setTemp(int tempR) {
		temp = tempR;
	}
}