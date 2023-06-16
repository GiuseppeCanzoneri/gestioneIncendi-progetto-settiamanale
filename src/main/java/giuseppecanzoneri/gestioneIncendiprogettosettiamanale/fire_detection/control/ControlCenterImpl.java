package giuseppecanzoneri.gestioneIncendiprogettosettiamanale.fire_detection.control;

import giuseppecanzoneri.gestioneIncendiprogettosettiamanale.factory.Notification;
import giuseppecanzoneri.gestioneIncendiprogettosettiamanale.factory.NotificationFactory;

public class ControlCenterImpl implements ControlCenter {
	@Override
	public void notifyPersonnel(int sensorId, double smokeLevel) {
		NotificationFactory factory = new NotificationFactory();
		Notification notification = factory.createNotification(sensorId, smokeLevel);
		String message = notification.getMessage();
		System.out.println();
		System.out.println("Sending notification ALARM!: " + message);
	}
}