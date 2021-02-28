package cs5004.temperature;

/** This is an abstract class for Temperature.
 */
public abstract class AbstractTemperature implements cs5004.temperature.Temperature {

  /** This is a abstract toString method for temperature.
   * @return a string for celsius or fahrenheit.
   */
  @Override
  public String toString() {
    String temperature = String.format("%.1f°");
    return temperature;
  }

  /** This is a method to convert temperature into celsius.
   * @return a double of the temperature in celsius.
   */
  @Override
  public double inCelsius() {
    double temp = ((inFahrenheit() - 32) * (5.0 / 9.0));
    return temp;
  }


  /** This is a method to convert temperature into fahrenheit.
   * @return a double of the temperature in fahrenheit.
   */
  @Override
  public double inFahrenheit() {
    double temp = ((inCelsius() * (9.0 / 5.0)) + 32);
    return temp;
  }

  /** This method helps convert temperature into kelvin.
   * @return a double of the temperature in kelvin.
   */
  @Override
  public double inKelvin() {
    double temperature = inCelsius() - ABS_ZERO_C;
    return temperature;
  }

  /** This is a method that adds two different temperatures together.
   * @param t another temperature object.
   * @return a temperature object in celsius with the added temperatures.
   */
  @Override
  public cs5004.temperature.Temperature add(cs5004.temperature.Temperature t) {
    double celTemp = inCelsius();
    double temp = celTemp + t.inCelsius();
    cs5004.temperature.Temperature temperature = new CelsiusTemperature(temp);
    return temperature;
  }


  /** This is a method to compare two temperatures against each other.
   * @param temperature an object with a temperature value.
   * @return int that tells if the compared item is greater than, equal to, or less than the item
   *     being compared.
   */
  @Override
  public int compareTo(cs5004.temperature.Temperature temperature) {
    return Double.compare(inCelsius(), temperature.inCelsius());
  }


}
