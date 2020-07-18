package designpattern.observer;
import java.util.*;
public class WeatherData implements Subject {
	private Integer data;
	private List<Observer> observers = new ArrayList<>();
	@Override
	public void registerObserver(Observer o) {
		if (!observers.contains(o)) {
			observers.add(o);
		}
	}

	@Override
	public void removeObserver(Observer o) {
		if (!observers.isEmpty()) {
			if (observers.contains(o)) {
				observers.remove(o);
			}
		}
	}

	@Override
	public void notifyObservers() {
		observers.forEach(observer -> observer.update(data));
	}
	
	public void setData(int data) {
		this.data = data;
	}

	public int getData() {
		return data;
	}
}
