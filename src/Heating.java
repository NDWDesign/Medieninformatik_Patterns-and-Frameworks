import java.util.Observable;

public class Heating extends Observable implements Runnable {
	private double temperature;
	private boolean on = false;

	private Heating(double temperature) {
		this.temperature = temperature;
	}

	void turnOn() {
		on = true;
	}

	void turnOff() {
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

		// Observer für niedrige Temperatur hinzufügen.
		heating.addObserver(new LowTemperatureObserver(21));

		// Observer für hohe Temperatur hinzufügen.
		heating.addObserver(new HighTemperatureObserver(25));

		// Temperaturmessung läuft
		new Thread(heating).run();
	}
}