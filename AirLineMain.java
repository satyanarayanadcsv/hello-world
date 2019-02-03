package com.cg.airline.presentation;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import com.cg.airline.beans.AirLineBookInfoDTO;
import com.cg.airline.exception.AirLineException;
import com.cg.airline.service.AirLineServiceImpl;
import com.cg.airline.beans.AirLineFlightInfoDTO;

public class AirLineMain {
	public static Scanner in;
	public static AirLineServiceImpl service = new AirLineServiceImpl();

	public static void main(String[] args) throws AirLineException {
		in = new Scanner(System.in);
		System.out
				.println("------:Welcome to The AirLine Reservation System:-------");
		String choice = "initial";
		while (!choice.equals("4")) {
			System.out.println("Enter Your choice: ");
			System.out.println("1. User/ customer");
			System.out.println("2. Admin");
			System.out.println("3. Airline Executive");
			System.out.println("4. Exit");
			choice = in.next().trim();
			switch (choice) {
			case "1":
				getUser();
				break;
			case "2":

				break;
			case "3":

				break;
			case "4":
				System.out.println("Thank You!");
				System.exit(0);
				break;
			default:
				System.out.println("Please Select valid choice");
				break;
			}
		}
	}

	static Boolean getUser() throws AirLineException {

		in = new Scanner(System.in);
		String choice = "initial";
		while (!choice.equals("4")) {
			System.out.println("1. Book Ticket");
			System.out.println("2. View Flight Schedule");
			System.out.println("3. View Ticket");
			System.out.println("4. Return to Main Menu");
			choice = in.next().trim();
			switch (choice) {
			case "1":
				bookTicket();
				break;
			case "2":

				break;
			case "3":

				break;
			case "4":
				return false;
			default:
				System.out.println("Please Select valid choice");
				break;
			}
		}
		return true;
	}

	static void bookTicket() throws AirLineException {

		int no_of_passengers;
		String class_type;
		double total_fare;
		String seat_number;
		String creditcard_info;
		String src_city;
		String dest_city;
		String flightno;
		String custMail;
		Double firstSeatFare;
		Double busSeatFare;
		AirLineBookInfoDTO dto = new AirLineBookInfoDTO();

		System.out.println("Enter Source city");
		src_city = in.next();
		System.out.println("Enter Destination city");
		dest_city = in.next();

		ArrayList<AirLineFlightInfoDTO> airDto = new ArrayList<AirLineFlightInfoDTO>();
		airDto = service.showFlights(src_city, dest_city);
		System.out.println("FlightNo  AirLine  DeptCity  ArrCity  DeptDate  ArrDate  DeptTime  ArrTime  FirstFare  BusFare");
		if(airDto != null){
			
			Iterator<AirLineFlightInfoDTO> i = airDto.iterator();
			while(i.hasNext()){
				AirLineFlightInfoDTO obj=(AirLineFlightInfoDTO)i.next();
				System.out.print(obj.getFlightNo()+"	");
				System.out.print(obj.getAirLine()+"	 ");
				System.out.print(obj.getDept_city()+"	");
				System.out.print(obj.getArr_city()+"	");
				System.out.print(obj.getDept_date()+"	");
				System.out.print(obj.getArr_date()+"	");
				System.out.print(obj.getDept_time()+"	");
				System.out.print(obj.getArr_time()+"	");
				System.out.print(obj.getFirst_seats_fare()+"	");
				System.out.print(obj.getBus_seats_fare()+"\n");
			}
			System.out.println();
		}else
		{
			System.out.println("Not Available");
		}
		
		System.out.println("Enter  flight Number");
		flightno = in.next();
		firstSeatFare=service.findFirstSeatFare(flightno);
		busSeatFare=service.findBusSeatFare(flightno);
		
		System.out.println("Enter email");
		custMail = in.next();

		System.out.println("Enter no of passenegers");
		no_of_passengers = in.nextInt();

		String choice = "initial";
		while (true) {
			System.out.println("Enter Class Type");
			System.out.println("1.First Seat");
			System.out.println("2.Bus Seat");
			choice = in.next();
			if (choice.equals("1")) {
				class_type = "First Seat";
				total_fare = no_of_passengers * firstSeatFare;
				break;
			} else if (choice.equals("2")) {
				class_type = "Bus Seat";
				total_fare = no_of_passengers * busSeatFare;
				break;
			} else {
				System.out.println("Invalid choice");
			}
		}

		System.out.println("Enter Seat Numbers");
		seat_number = in.next();


		System.out.println("Enter creditcard info");
		creditcard_info = in.next();

		dto.setCust_email(custMail);
		dto.setClass_type(class_type);
		dto.setCreditcard_info(creditcard_info);
		dto.setDest_city(dest_city);
		dto.setSrc_city(src_city);
		dto.setFlightno(flightno);
		dto.setNo_of_passengers(no_of_passengers);
		dto.setTotal_fare(total_fare);
		dto.setSeat_number(seat_number);
		service.bookTicket(dto);
	}
}
