package com.cg.airline.beans;

public class AirLineBookInfoDTO {
	public int getBooking_id() {
		return booking_id;
	}

	public void setBooking_id(int booking_id) {
		this.booking_id = booking_id;
	}

	public int getNo_of_passengers() {
		return no_of_passengers;
	}

	public void setNo_of_passengers(int no_of_passengers) {
		this.no_of_passengers = no_of_passengers;
	}

	public String getClass_type() {
		return class_type;
	}

	public void setClass_type(String class_type) {
		this.class_type = class_type;
	}

	public double getTotal_fare() {
		return total_fare;
	}

	public void setTotal_fare(double total_fare) {
		this.total_fare = total_fare;
	}

	public String getSeat_number() {
		return seat_number;
	}

	public void setSeat_number(String seat_number) {
		this.seat_number = seat_number;
	}

	public String getCreditcard_info() {
		return creditcard_info;
	}

	public void setCreditcard_info(String creditcard_info) {
		this.creditcard_info = creditcard_info;
	}

	public String getSrc_city() {
		return src_city;
	}

	public void setSrc_city(String src_city) {
		this.src_city = src_city;
	}

	public String getDest_city() {
		return dest_city;
	}

	public void setDest_city(String dest_city) {
		this.dest_city = dest_city;
	}

	public String getFlightno() {
		return flightno;
	}

	public void setFlightno(String flightno) {
		this.flightno = flightno;
	}

	public String getCust_email() {
		return cust_email;
	}

	public void setCust_email(String cust_email) {
		this.cust_email = cust_email;
	}

	private int booking_id;
	private int no_of_passengers;
	private String class_type;
	private double total_fare;
	private String seat_number;
	private String creditcard_info;
	private String src_city;
	private String dest_city;
	private String flightno;
	private String cust_email;

}
