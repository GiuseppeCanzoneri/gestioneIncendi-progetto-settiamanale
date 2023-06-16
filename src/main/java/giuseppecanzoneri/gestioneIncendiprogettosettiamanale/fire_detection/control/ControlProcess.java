package giuseppecanzoneri.gestioneIncendiprogettosettiamanale.fire_detection.control;

import org.springframework.stereotype.Component;

import giuseppecanzoneri.gestioneIncendiprogettosettiamanale.fire_detection.sensor.FireSensorListener;

@Component
public class ControlProcess implements FireSensorListener {
	private ControlCenter controlCenter;

	public ControlProcess() {
	}

	public void setControlCenter(ControlCenter controlCenter) {
		this.controlCenter = controlCenter;
	}

	@Override
	public void onFireDetected(int sensorId, double smokeLevel) {
		if (smokeLevel >= 5) {
			System.out.println();
			System.out.println("***********SEGNALAZIONE INCENDII******************");
			System.out.println();
			controlCenter.notifyPersonnel(sensorId, smokeLevel);
		} else {
			System.out.println();
			System.out.println("***********SEGNALAZIONE INCENDII******************");

			System.out.println("Nessun allarme");
		}
	}
}
