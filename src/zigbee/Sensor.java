package zigbee;

import com.rapplogic.xbee.api.XBeeAddress64;
import com.rapplogic.xbee.api.zigbee.ZNetRxIoSampleResponse;

abstract class Sensor extends Probe {
	
	public Sensor(XBeeAddress64 address64R, String nameProbeR, ZNetRxIoSampleResponse pinProbeR)
	{
		super(address64R, nameProbeR, pinProbeR);
	}
	
}
