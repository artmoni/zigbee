package zigbee;

import com.rapplogic.xbee.api.XBeeAddress64;
import com.rapplogic.xbee.api.zigbee.ZNetRxIoSampleResponse;

public class LuxSensor extends Sensor {

	/* Constants */

	public LuxSensor(XBeeAddress64 address64r, String nameProbeR, ZNetRxIoSampleResponse samplesR) {
		super(address64r, nameProbeR, samplesR);
	}

	public int getVolts() {
		return super.getVolts();
	}

	public int getLumens() {
		if (getVolts() != 0) {
			if (getVolts() > 800) {
				return 50;
			} else if (getVolts() < 400) {
				return 10000;
			} else {
				return 500;
			}
		}
		return 0;
	}
}
