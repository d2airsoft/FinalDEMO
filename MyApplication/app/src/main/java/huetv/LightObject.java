package huetv;

public class LightObject {
	private int timeSeconds;
	private boolean isOn;
	private int hue;
	private int saturation;
	private int brightness;
	private String alert;
	private boolean isFiller;
	private int lightNumber;

	public LightObject(int valueTotalSeconds) {
		this.timeSeconds = valueTotalSeconds;
		this.isOn = false;
		this.hue = 0;
		this.saturation = 0;
		this.brightness = 0;
		this.alert = "null";
	}

	public LightObject(int valueTotalSeconds, boolean valueIsOn, int valueHue,
			int valueSaturation, int valueBrightness, String alertString) {
		this.setTimeSeconds(valueTotalSeconds);
		this.setOn(valueIsOn);
		this.setHue(valueHue);
		this.setSaturation(valueSaturation);
		this.setBrightness(valueBrightness);
		this.setAlert(alertString);
	}

	public boolean getOn() {
		return isOn;
	}

	public void setOn(boolean isOn) {
		this.isOn = isOn;
	}

	public int getHue() {
		return hue;
	}

	public void setHue(int hue) {
		this.hue = hue;
	}

	public int getSaturation() {
		return saturation;
	}

	public void setSaturation(int saturation) {
		this.saturation = saturation;
	}

	public int getBrightness() {
		return brightness;
	}

	public void setBrightness(int brightness) {
		this.brightness = brightness;
	}

	public String getAlert() {
		return alert;
	}

	public void setAlert(String alert) {
		this.alert = alert;
	}

	public String toString() {
		String objectString = "Light # " + lightNumber + " Time: " + timeSeconds + " isOn: " + this.isOn
				+ " hue: " + hue + " saturation: " + saturation
				+ " brightness: " + brightness + " alert: " + alert;
		return objectString;
	}

	public int getTimeSeconds() {
		return timeSeconds;
	}

	public void setTimeSeconds(int timeSeconds) {
		this.timeSeconds = timeSeconds;
	}

	public boolean isFiller() {
		return isFiller;
	}

	public void setFiller(boolean isFiller) {
		this.isFiller = isFiller;
	}
	
	public int getLightNumber() {
		return lightNumber;
	}

	public void setLightNumber(int lightNumber) {
		this.lightNumber = lightNumber;
	}
}
