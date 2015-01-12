package fr.uds.info907.control;

import java.util.Scanner;

import fr.uds.info907.view.Home;

public class STDINControler {
	public static void main (String[] args){
		Home home = new Home();
		Scanner scanner = new Scanner(System.in);
		String order = scanner.nextLine();
		while(!order.equals("exit")){
			home.proceedComande(order);
			order = scanner.nextLine();
		}
		scanner.close();
	}
	
	
}
