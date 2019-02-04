package com.cg.airline.dao;

public interface IQueryMapper {

	String INSERT_QUERY = "INSERT INTO BOOKINGINFORMATION VALUES(air_booking_id.nextval ,?,?,?,?,?,?,?,?,?)";
	String GET_FLIGHTS = "select * from FLIGHTINFORMATION where dep_city=? and arr_city=?";
	String GET_FIRST_SEAT_FARE = "select firstseatfare from FLIGHTINFORMATION where flightno=?";
	String GET_BUS_SEAT_FARE = "select busseatsfare from FLIGHTINFORMATION where flightno=?";
	String GET_BOOKINGID = "select air_booking_id.currval from dual";
	String GET_FIRST_SEATS = "select firstseats from flightinformation where flightno=?";
	String UPDATE_FIRST_SEATS = "update flightinformation set firstseats=? where flightno=?";
	String GET_BUS_SEATS = "select busseats from flightinformation where flightno=?";
	String UPDATE_BUS_SEATS = "update flightinformation set busseats=? where flightno=?";
	
}
