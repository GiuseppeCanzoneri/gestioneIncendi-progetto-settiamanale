package giuseppecanzoneri.gestioneIncendiprogettosettiamanale.fire_detection.control;

import org.springframework.stereotype.Component;

@Component
public class ControlCenterProxy implements ControlCenter {
	private ControlCenter controlCenter;

	@Override
	public void notifyPersonnel(int sensorId, double smokeLevel) {
		if (controlCenter == null) {
			controlCenter = new ControlCenterImpl();
		}

		controlCenter.notifyPersonnel(sensorId, smokeLevel);
	}
}