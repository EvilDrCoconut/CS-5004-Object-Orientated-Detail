package cs5004.temperature;

/** This is the celsius temperature class.
 */
public class CelsiusTemperature extends AbstractTemperature {

  private double celsiusTemperature;

  /** This is a constructor for celsius if given a celsius temperature.
   * @param celsius a double that is a celsius temperature.
   */
  public CelsiusTemperature(double celsius) {

    if (celsius < ABS_ZERO_C) {
      throw new IllegalArgumentException();
    }
    this.celsiusTemperature = celsius;
  }

  /** This is a constructor for celsius if given a fahrenheit temperature.
   * @param fahrenheit a doulbe of a temperature given in fahrenheit.
   * @param bool       a boolean parameter to overload the method.
   */
  public CelsiusTemperature(double fahrenheit, boolean bool) {


    if ((((fahrenheit - 32) * 5) / 9) < ABS_ZERO_C) {
      throw new IllegalArgumentException();
    }

    this.celsiusTemperature = ((fahrenheit - 32) * (5.0 / 9.0));
    boolean boole = bool;
  }

  /** This is a method from the abstract class.
   * @return the double of the temperature in celsius.
   */
  public double inCelsius() {
    return this.celsiusTemperature;
  }

  /** This is a method from the abstract class.
   * @return the double of the temperature in fahrenheit.
   */
  public double inFahrenheit() {
    return super.inFahrenheit();
  }

  /** This is a method from the abstract class.
   * @return a string of the temperature in celsius.
   */
  @Override
  public String toString() {
    String temperature = String.format("%.1f°", this.celsiusTemperature) + " Celsius";
    return temperature;
  }

  /** This is a method from the abstract class.
   * @return a double for the temperature in kelvin.
   */
  @Override
  public double inKelvin() {
    return super.inKelvin();
  }

  /** This is a method from the abstract class.
   * @param t another temperature object.
   * @return CelsiusTemperature object with the new combined value.
   */
  @Override
  public cs5004.temperature.Temperature add(cs5004.temperature.Temperature t) {
    return super.add(t);
  }

  /** A method from the abstract class.
   * @param temperature an object with a temperature value.
   * @return int that tells if the compared item is greater than, equal to, or less than the item
   *     being compared.
   */
  @Override
  public int compareTo(Temperature temperature) {
    return super.compareTo(temperature);
  }
}
