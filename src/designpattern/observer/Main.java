package designpattern.observer;

public class Main {

	public static void main(String[] args) throws Exception{
		WeatherData subject = new WeatherData();
		new AvergeDisplay(subject);
		new AvergeDisplay(subject);
		new AvergeDisplay(subject);
		for (int i = 0; i < 10 ; i++) {
			subject.setData(i);
			subject.notifyObservers();
			Thread.sleep(1000);
		}
	}

}
