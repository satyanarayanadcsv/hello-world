package com.cg.airline.dao;

public interface IQueryMapper {

	String INSERT_QUERY = "INSERT INTO BOOKINGINFORMATION VALUES(air_booking_id.nextval ,?,?,?,?,?,?,?,?,?)";
	String GET_FLIGHTS = "select * from FLIGHTINFORMATION where dep_city=? and arr_city=?";
	String GET_FIRST_SEAT_FARE = "select firstseatfare from FLIGHTINFORMATION where flightno=?";
	String GET_BUS_SEAT_FARE = "select busseatsfare from FLIGHTINFORMATION where flightno=?";
	
}
