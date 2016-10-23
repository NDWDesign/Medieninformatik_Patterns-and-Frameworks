import java.util.Observable;
import java.util.Observer;

public class Heating extends Observable implements Runnable {
	private double temperature;
	private boolean on = false;

	public Heating(double temperature) {
		this.temperature = temperature;
	}

	public void turnOn() {
		on = true;
	}

	public void turnOff() {
		on = false;
	}

	public void run() {
		while (true) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			if (on) {
				temperature += Math.random() * 0.4;
			} else {
				temperature -= Math.random() * 0.2;
			}
			System.out.println("Aktuelle Temperatur: " + String.format( "%.2f", temperature ));

			setChanged();
			notifyObservers(temperature);
		}
	}


	public static void main(String[] args) {
		// Heizung, Starttemperatur 25 Grad
		Heating heating = new Heating(25);

		// Beispiel: Observer hinzufügen
		// heating.addObserver( ... );

		// Temperaturmessung läuft
		new Thread(heating).run();
	}
}