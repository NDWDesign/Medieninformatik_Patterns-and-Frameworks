import java.util.Observable;
import java.util.Observer;

/**
 * LowTemperatureObserver
 *
 * @author Nils Daniel Wittwer
 * @date 2016-10-26
 * @version 1.0
 */
class LowTemperatureObserver implements Observer {

	/**
	 * Temperatur bei der die Heizung eingeschaltet werden soll.
	 **/
	private double minTemperature;

	/**
	 * @param minTemperature - Temperatur unterhalb der die Heizung eingeschaltet werden soll.
	 */
	LowTemperatureObserver(double minTemperature) {

		this.minTemperature = minTemperature;
	}

	@Override
	public void update(Observable observable, Object temperature) {

		Heating heating = (Heating) observable;

		if ((double) temperature < this.minTemperature) {
			System.out.println("Niedrige Temperatur! Temperaturlimit (" + this.minTemperature + ") erreicht. Heizung wird eingeschaltet.");
			heating.turnOn();
		}
	}
}
