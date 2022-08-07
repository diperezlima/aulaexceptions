/*Fazer um programa para ler os dados de uma reserva de hotel (n�mero do quarto, data
 * de entrada e data de sa�da) e mostrar os dados da reserva, inclusive sua dura��o	 em dias.
 * Em seguida, ler novas datas de entrada e sa�da, atualizar a reserva, e mostrar novamente a
 * reserva com os dados atualizados. O programa n�o deve aceitar dados inv�lidos para a reserva,
 * conforme as seguintes regras:
 * - Altera��es de reserva s� podem ocorrer para datas futuras;
 * - A data de sa�da deve ser maior que a data de entrada.
 */
//solu��o MUITO RUIM do tratamento de erros
//L�gica de solu��o de erros no programa principal e n�o na classe reservation
package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entities.Reservation;

public class Program {
	
	public static void main(String[] args) throws ParseException {
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Room number: ");
		int number = sc.nextInt();
		
		System.out.print("Check-in date (DD/MM/YYYY): ");
		Date checkIn = sdf.parse(sc.next());
		
		System.out.print("Check-out date (DD/MM/YYYY): ");
		Date checkOut = sdf.parse(sc.next());
		
		if (!checkOut.after(checkIn)) {
			System.out.println("Error in reservation: Check-out date must be after check-in date");
		} else {
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("Reservation: " + reservation);
		
			System.out.println();
			System.out.println("Enter data to update the reservation:");
			
			System.out.print("Check-in date (DD/MM/YYYY): ");
			checkIn = sdf.parse(sc.next());
			
			System.out.print("Check-out date (DD/MM/YYYY): ");
			checkOut = sdf.parse(sc.next());
			
			Date now = new Date();
			if (checkIn.before(now) || checkOut.before(now)) {
				System.out.println("Error in reservation: Reservation dates for updates must be future dates");
			}
			else if (!checkOut.after(checkIn)) {
				System.out.println("Error in reservation: Check-out date must be after check-in date");
			}
			else {
				reservation.updateDate(checkIn, checkOut);
				System.out.println("Reservation: " + reservation);
			}
			
		}
		
		
		sc.close();
		
	}

}
