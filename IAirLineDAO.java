package com.cg.airline.dao;

import java.util.ArrayList;

import com.cg.airline.beans.AirLineBookInfoDTO;
import com.cg.airline.beans.AirLineFlightInfoDTO;
import com.cg.airline.exception.AirLineException;

public interface IAirLineDAO {
	public void bookTicket(AirLineBookInfoDTO dto) throws AirLineException;
	public ArrayList<AirLineFlightInfoDTO> showFlights(String src_city, String dest_city) throws AirLineException;
	public Double findFirstSeatFare(String flightno) throws AirLineException;
	public Double findBusSeatFare(String flightno) throws AirLineException;
	public int getBookingid() throws AirLineException;
	public void updateSeats(String string,String class_type,int no_of_passengers)
			throws AirLineException;
}
