package giuseppecanzoneri.gestioneIncendiprogettosettiamanale.factory;

public class Notification {
	private int sensorId;
	private Coordinates coordinates;
	private SmokeLevel smokeLevel;

	public Notification(int sensorId, Coordinates coordinates, SmokeLevel smokeLevel) {
		this.sensorId = sensorId;
		this.coordinates = coordinates;
		this.smokeLevel = smokeLevel;
	}

	public String getMessage() {
//		return "Alarm: Sensor ID - " + "" + "" + sensorId + "" + "" + ", Latitude - " + coordinates.getLatitude() + ""
//				+ "" + ", Longitude - " + coordinates.getLongitude() + ", Smoke Level - " + smokeLevel.getLevel();
		return "http://host/alarm?idSonda=" + sensorId + "&lat=" + coordinates.getLatitude() + "&lon="
				+ coordinates.getLongitude() + "&smokelevel=" + smokeLevel.getLevel();

	}
}