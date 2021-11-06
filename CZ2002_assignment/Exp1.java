package CZ2002_assignment;

import java.time.LocalDateTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.time.format.DateTimeFormatter;

public class Exp1 {
	private static int x = 10;

	public static void main(String[] args) {
		//Get current instance of Date/Time 
		LocalDateTime now1 = LocalDateTime.now();
		//Format into something more readable
		DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		String formattedDateTime1 = now1.format(formatter1);
		//Print out current Date/Time
		System.out.println("Time now is " + formattedDateTime1);
		//Set delay, I want it to run at every even minute, so initial delay is the nearest minute % 2
		int initialDelay = 2 - (LocalDateTime.now().getMinute() % 2);
		System.out.println("Initial Delay is " + initialDelay + " minutes.");
		//Scheduled execution
		ScheduledExecutorService timedExe = Executors.newSingleThreadScheduledExecutor();
		//Specify the initial delay to sync up to nearest even minute, then set delay interval to run every 2 minutes
		timedExe.scheduleAtFixedRate(Exp1::run, initialDelay, 2, TimeUnit.MINUTES);
	}
	
	public static void run() {
		LocalDateTime now2 = LocalDateTime.now();
		DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		String formattedDateTime2 = now2.format(formatter2);
		System.out.println("I've executed at: " + formattedDateTime2 + " and x = " + --x);
	}

}
