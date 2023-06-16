package giuseppecanzoneri.gestioneIncendiprogettosettiamanale.fire_detection.sensor;

public interface FireSensorListener {
	void onFireDetected(int sensorId, double smokeLevel);
}