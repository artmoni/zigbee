package zigbee;

import com.rapplogic.xbee.api.XBeeAddress64;
import com.rapplogic.xbee.api.wpan.IoSample;

abstract class Sensor {
	private XBeeAddress64 address64;
	private String nameSensor;
	private IoSample pinSonde;

	public IoSample getPinSonde() {
		return pinSonde;
	}

	public String getNameSensor() {
		return nameSensor;
	}

	public void setNameSensor(String nameSensor) {
		this.nameSensor = nameSensor;
	}

	public XBeeAddress64 getAddress64() {
		return address64;
	}

	public void setAddress64(XBeeAddress64 address64) {
		this.address64 = address64;
	}

}
