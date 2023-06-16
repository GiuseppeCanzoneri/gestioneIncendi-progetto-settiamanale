package giuseppecanzoneri.gestioneIncendiprogettosettiamanale.fire_detection.control;

public interface ControlCenter {
	void notifyPersonnel(int sensorId, double smokeLevel);
}