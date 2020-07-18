package designpattern.observer;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AvergeDisplay implements Display, Observer {
	private static final SimpleDateFormat FORMAT = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	public AvergeDisplay(Subject subject) {
		subject.registerObserver(this);
	}
	@Override
	public void update(Object data) {
		display(data);
	}

	@Override
	public void display(Object object) {
		System.out.println(FORMAT.format(new Date()) + " : " + object.toString() + this.hashCode());
	}

}
