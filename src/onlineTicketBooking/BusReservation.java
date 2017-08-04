package onlineTicketBooking;
/**
 * Program to reserve tickets in an online bus reservation system using synchronization.
 * 
 * This program have option for single thread to book multiple seats. 
 * For each seat, the program takes passenger name and age.
 */

import java.util.Scanner;

public class BusReservation extends Thread { // Creating class and extend it
												// from Thread class

	public void run() { // Creating run method

		// Declaring variables
		int totalSeats;
		String[] name;
		int[] age;

		Scanner sc = new Scanner(System.in); // Scanner class to take input from
												// user

		/**
		 * Synchronized block is used to synchronized on the same object and
		 * only have one thread executing inside them at the same time.
		 **/
		synchronized (this) { // Creating Synchronized block

			System.out.print("Enter total number of seats: ");
			totalSeats = sc.nextInt(); // Taking input from user for no. of
										// seats
			/**
			 * Initializing integer and string arrays to store name and age of
			 * the passengers.
			 * 
			 */
			name = new String[totalSeats];
			age = new int[totalSeats];

			for (int i = 0; i < totalSeats; i++) { // For loop
				// It will print name and age of passenger according to the
				// total number of tickets .

				System.out.print("\nPassenger " + (i + 1));
				System.out.print("\nName: ");
				name[i] = sc.next();

				System.out.print("Age:");
				age[i] = sc.nextInt();
			}

			// Printing final details
			System.out.println("\n!! Booking Details !!");
			System.out.println("Number of seats: " + totalSeats); //Prints total number of seats 
			for (int i = 0; i < totalSeats; i++) {
				//Prints each passenger names with age as a final detail. 
				System.out.println((i + 1) + "." + name[i] + "(" + age[i] + ")");
				try {
					Thread.sleep(1000); // Put thread to sleep
				} catch (Exception e) {
				}
			}
		}
	}

	
	public static void main(String[] args) { // Main method 
		System.err.println("Red Bus service \n"); // Prints the Bus service name 
		
		Thread t = new Thread ( new BusReservation()); // Creating thread 
		t.start(); // Thread starts 
	}

}
