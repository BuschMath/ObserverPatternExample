// Client code
public class WeatherStation {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        CurrentConditionsDisplay currentDisplay = new CurrentConditionsDisplay();
        ForecastDisplay forecastDisplay = new ForecastDisplay();
        
        weatherData.registerObserver(currentDisplay);
        weatherData.registerObserver(forecastDisplay);
        
        weatherData.setTemperature(25.0f);
        weatherData.setTemperature(30.0f);
        
        weatherData.removeObserver(currentDisplay);
        
        weatherData.setTemperature(20.0f);
    }
}