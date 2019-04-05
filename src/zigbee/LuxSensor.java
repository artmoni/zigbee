package zigbee;

import com.rapplogic.xbee.api.XBeeAddress64;
import com.rapplogic.xbee.api.zigbee.ZNetRxIoSampleResponse;

public class LuxSensor extends Sensor {

	/* Constants */

	public LuxSensor(XBeeAddress64 address64r, String nameProbeR, ZNetRxIoSampleResponse samplesR) {
		super(address64r, nameProbeR, samplesR);
	}

}
