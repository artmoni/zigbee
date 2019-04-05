package zigbee;

import com.rapplogic.xbee.api.XBeeAddress64;
import com.rapplogic.xbee.api.zigbee.ZNetRxIoSampleResponse;

abstract class Sensor extends Probe {

	public Sensor(XBeeAddress64 address64R, String nameProbeR, ZNetRxIoSampleResponse samplesR) {
		super(address64R, nameProbeR, samplesR);
	}

}
