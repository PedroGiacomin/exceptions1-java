package application;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;


public class Program {

	//Primeira solu��o : muito ruim, tudo na clase do prog principal
	//Segunda solu��o : ruim, delega a fun�ao de retornar erro � classe
	//reservation, mas n�o usa o tratamento de exce��es
	//Terceira solu��o : boa, usa o tratamento de exce��es
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			System.out.print("Rooom number: ");
			int number = sc.nextInt();
			System.out.println("Check-in date (dd/mm/yyyy): ");
			Date checkIn = sdf.parse(sc.next());
			System.out.println("Check-out date (dd/mm/yyyy): ");
			Date checkOut = sdf.parse(sc.next());
			
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("Reservation: " + reservation);
			
			System.out.println();
			System.out.println("Enter data to update the reservation: ");
			System.out.println("Check-in date (dd/mm/yyyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.println("Check-out date (dd/mm/yyyy): ");
			checkOut = sdf.parse(sc.next());
			
			reservation.updateDates(checkIn, checkOut);
			System.out.println("Reservation: " + reservation);
		}
		catch (ParseException e) {
			System.out.println("Invalid date format");
		}
		catch (DomainException e) {
			System.out.println("Error in reservation: " + e.getMessage());
		}	
		catch (RuntimeException e) {
			System.out.println("Unexpected error");
		}
		
		sc.close();
	}
}
