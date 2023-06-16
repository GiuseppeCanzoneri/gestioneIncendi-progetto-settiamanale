package giuseppecanzoneri.gestioneIncendiprogettosettiamanale.fire_detection.sensor;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class FireSensor {
	private int sensorId;
	private double smokeLevel;
	private List<FireSensorListener> listeners;

	public FireSensor(@Value("${fire.sensor.id}") int sensorId) {
		this.sensorId = sensorId;
		this.smokeLevel = 0.0;
		this.listeners = new ArrayList<>();
	}

	public void addListener(FireSensorListener listener) {
		listeners.add(listener);
	}

	public void removeListener(FireSensorListener listener) {
		listeners.remove(listener);
	}

	public void setSmokeLevel(double smokeLevel) {
		this.smokeLevel = smokeLevel;
		notifyListeners();
	}

	private void notifyListeners() {
		for (FireSensorListener listener : listeners) {
			listener.onFireDetected(sensorId, smokeLevel);
		}
	}
}