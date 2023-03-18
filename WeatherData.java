import java.util.ArrayList;
import java.util.List;

// Observer interface
interface Observer {
    void update(float temperature);
}

// Subject interface
interface Subject {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}

// Concrete Subject class
class WeatherData implements Subject {
    private List<Observer> observers;
    private float temperature;
    
    public WeatherData() {
        observers = new ArrayList<>();
    }
    
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }
    
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }
    
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(temperature);
        }
    }
    
    public void setTemperature(float temperature) {
        this.temperature = temperature;
        notifyObservers();
    }
}

// Concrete Observer classes
class CurrentConditionsDisplay implements Observer {
    private float temperature;
    
    public void update(float temperature) {
        this.temperature = temperature;
        display();
    }
    
    public void display() {
        System.out.println("Current temperature: " + temperature);
    }
}

class ForecastDisplay implements Observer {
    private float temperature;
    
    public void update(float temperature) {
        this.temperature = temperature;
        display();
    }
    
    public void display() {
        System.out.println("Temperature forecast: " + (temperature + 2));
    }
}
