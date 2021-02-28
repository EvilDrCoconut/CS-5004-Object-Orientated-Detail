package cs5004.temperature;

/** A class for the fahrenheit temperature.
 */
public class FahrenheitTemperature extends AbstractTemperature {

  private double fahrenheitTemperature;

  /** This is a constructor for fahrenheit if given a fahrenheit temperature.
   * @param fahrenheit a double that is a fahrenheit temperature.
   */
  public FahrenheitTemperature(double fahrenheit) {

    if ((((fahrenheit - 32) * 5) / 9) < ABS_ZERO_C) {
      throw new IllegalArgumentException();
    }
    this.fahrenheitTemperature = fahrenheit;

  }

  /** This is a constructor for fahrenheit if given a celsius temperature.
   * @param celsius doulbe turned in by user for temperature in celsius
   * @param bool parameter used to help overload the constructor method
   */
  public FahrenheitTemperature(double celsius, boolean bool) {


    if (celsius < ABS_ZERO_C) {
      throw new IllegalArgumentException();
    }
    this.fahrenheitTemperature = (celsius * (9.0 / 5.0)) + 32;
    boolean boole = bool;
  }

  /** This is a method from the abstract class.
   * @return the double of the temperature in celsius.
   */
  public double inCelsius() {
    return super.inCelsius();
  }

  /** This is a method from the abstract class.
   * @return the double of the temperature in fahrenheit.
   */
  public double inFahrenheit() {
    return fahrenheitTemperature;
  }

  /** This is a method from the abstract class.
   * @return a string of the temperature in celsius.
   */
  @Override
  public String toString() {
    String temperature = String.format("%.1f°", fahrenheitTemperature) + " Fahrenheit";
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
   * @return CelsiusTemperature object with the added value in celsius.
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
