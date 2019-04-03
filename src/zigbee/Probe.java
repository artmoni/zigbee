package zigbee;

import com.rapplogic.xbee.api.XBee;
import com.rapplogic.xbee.api.XBeeAddress64;
import com.rapplogic.xbee.api.zigbee.ZNetRxIoSampleResponse;

public class Probe {
	private XBeeAddress64 address64;
	private String nameProbe;
	private ZNetRxIoSampleResponse pinProbe;

	XBee xbee = new XBee();

	public Probe(XBeeAddress64 address64R, String nameProbeR, ZNetRxIoSampleResponse pinProbeR) {
		address64 = address64R;
		nameProbe = nameProbeR;
		pinProbe = pinProbeR;
	}

	public ZNetRxIoSampleResponse getPinProbe() {
		return pinProbe;
	}

	public String getNameProbe() {
		return nameProbe;
	}

	public void setNameProbe(String nameSensor) {
		this.nameProbe = nameSensor;
	}

	public XBeeAddress64 getAddress64() {
		return address64;
	}

	public void setAddress64(XBeeAddress64 address64) {
		this.address64 = address64;
	}

}
