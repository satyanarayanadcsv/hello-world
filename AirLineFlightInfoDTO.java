package com.cg.airline.beans;

import java.util.Date;

public class AirLineFlightInfoDTO {
	public String getFlightNo() {
		return flightNo;
	}

	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}

	public String getAirLine() {
		return AirLine;
	}

	public void setAirLine(String airLine) {
		AirLine = airLine;
	}

	public String getDept_city() {
		return dept_city;
	}

	public void setDept_city(String dept_city) {
		this.dept_city = dept_city;
	}

	public String getArr_city() {
		return arr_city;
	}

	public void setArr_city(String arr_city) {
		this.arr_city = arr_city;
	}

	public Date getDept_date() {
		return dept_date;
	}

	public void setDept_date(Date dept_date) {
		this.dept_date = dept_date;
	}

	public Date getArr_date() {
		return arr_date;
	}

	public void setArr_date(Date arr_date) {
		this.arr_date = arr_date;
	}

	public Date getDept_time() {
		return dept_time;
	}

	public void setDept_time(Date dept_time) {
		this.dept_time = dept_time;
	}

	public Date getArr_time() {
		return arr_time;
	}

	public void setArr_time(Date arr_time) {
		this.arr_time = arr_time;
	}

	public int getFirst_seats() {
		return first_seats;
	}

	public void setFirst_seats(int first_seats) {
		this.first_seats = first_seats;
	}

	public double getFirst_seats_fare() {
		return first_seats_fare;
	}

	public void setFirst_seats_fare(double d) {
		this.first_seats_fare = d;
	}

	public int getBus_seats() {
		return bus_seats;
	}

	public void setBus_seats(int bus_seats) {
		this.bus_seats = bus_seats;
	}

	public double getBus_seats_fare() {
		return bus_seats_fare;
	}

	public void setBus_seats_fare(double d) {
		this.bus_seats_fare = d;
	}

	private String flightNo;
	private String AirLine;
	private String dept_city;
	private String arr_city;
	private Date dept_date;
	private Date arr_date;
	private Date dept_time;
	private Date arr_time;
	private int first_seats;
	private double first_seats_fare;
	private int bus_seats;
	private double bus_seats_fare;

}
