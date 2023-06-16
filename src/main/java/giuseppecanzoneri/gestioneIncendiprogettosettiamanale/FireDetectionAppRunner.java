package giuseppecanzoneri.gestioneIncendiprogettosettiamanale;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import giuseppecanzoneri.gestioneIncendiprogettosettiamanale.fire_detection.control.ControlCenter;
import giuseppecanzoneri.gestioneIncendiprogettosettiamanale.fire_detection.control.ControlCenterImpl;
import giuseppecanzoneri.gestioneIncendiprogettosettiamanale.fire_detection.control.ControlCenterProxy;
import giuseppecanzoneri.gestioneIncendiprogettosettiamanale.fire_detection.control.ControlProcess;
import giuseppecanzoneri.gestioneIncendiprogettosettiamanale.fire_detection.sensor.FireSensor;

@SpringBootApplication
@ComponentScan({ "giuseppecanzoneri.gestioneIncendiprogettosettiamanale.fire_detection.sensor",
		"giuseppecanzoneri.gestioneIncendiprogettosettiamanale.fire_detection.process",
		"giuseppecanzoneri.gestioneIncendiprogettosettiamanale.fire_detection.control" })
public class FireDetectionAppRunner implements CommandLineRunner {

	private final FireSensor fireSensor;
	private final ControlProcess controlProcess;

	public FireDetectionAppRunner(FireSensor fireSensor, ControlProcess controlProcess,
			ControlCenterProxy controlCenterProxy) {
		this.fireSensor = fireSensor;
		this.controlProcess = controlProcess;

	}

	public static void main(String[] args) {
		SpringApplication.run(FireDetectionAppRunner.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		ControlCenter controlCenter = new ControlCenterImpl(); // Creazione dell'oggetto ControlCenterImpl
		controlProcess.setControlCenter(controlCenter);
		fireSensor.addListener(controlProcess);

		fireSensor.setSmokeLevel(5.0);
	}
}
