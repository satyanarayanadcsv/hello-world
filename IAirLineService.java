package com.cg.airline.service;

import java.util.ArrayList;

import com.cg.airline.beans.AirLineBookInfoDTO;
import com.cg.airline.beans.AirLineFlightInfoDTO;
import com.cg.airline.exception.AirLineException;

public interface IAirLineService {
	public void bookTicket(AirLineBookInfoDTO dto) throws AirLineException;
	public ArrayList<AirLineFlightInfoDTO> showFlights(String src_city, String dest_city) throws AirLineException;
	public Double findFirstSeatFare(String flightno) throws AirLineException;
	public Double findBusSeatFare(String flightno) throws AirLineException;
}
