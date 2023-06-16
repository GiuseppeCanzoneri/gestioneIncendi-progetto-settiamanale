package giuseppecanzoneri.gestioneIncendiprogettosettiamanale.factory;

public class NotificationFactory {
	public Notification createNotification(int sensorId, double smokeLevel) {
		Coordinates coordinates = new Coordinates(10, 15); // Ottenere le coordinate reali
		SmokeLevel smoke = new SmokeLevel(smokeLevel);
		return new Notification(sensorId, coordinates, smoke);
	}
}