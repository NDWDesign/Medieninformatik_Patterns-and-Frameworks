import java.util.Observable;
import java.util.Observer;

/**
 * HighTemperatureObserver
 *
 * @author Nils Daniel Wittwer
 * @date 2016-10-26
 * @version 1.0
 */
class HighTemperatureObserver implements Observer {

	/**
	 * Temperatur bei der die Heizung eingeschaltet werden soll.
	 **/
	private double maxTemperature;

	/**
	 * @param maxTemperature - Temperatur oberhalb der die Heizung eingeschaltet werden soll.
	 */
	HighTemperatureObserver(double maxTemperature) {

		this.maxTemperature = maxTemperature;
	}

	@Override
	public void update(Observable observable, Object temperature) {

		Heating heating = (Heating) observable;

		if ((double) temperature > this.maxTemperature) {
			System.out.println("Hohe Temperatur! Temperaturlimit (" + this.maxTemperature + ") erreicht. Heizung wird ausgeschaltet.");
			heating.turnOff();
		}
	}
}
