package com.cg.airline.service;

import java.util.ArrayList;

import com.cg.airline.beans.AirLineBookInfoDTO;
import com.cg.airline.beans.AirLineFlightInfoDTO;
import com.cg.airline.dao.AirLineDAOImpl;
import com.cg.airline.exception.AirLineException;

public class AirLineServiceImpl implements IAirLineService{
	AirLineDAOImpl dao;
	
	
	public AirLineServiceImpl() {
		dao =new AirLineDAOImpl();
	}
	
	@Override
	public void bookTicket(AirLineBookInfoDTO dto) throws AirLineException{
		dao.bookTicket(dto);
	}
	
	@Override
	public ArrayList<AirLineFlightInfoDTO> showFlights(String src_city, String dest_city) throws AirLineException{
		return dao.showFlights(src_city, dest_city);
	}
	
	@Override
	public Double findFirstSeatFare(String flightno) throws AirLineException{
		return dao.findFirstSeatFare(flightno);
	}
	@Override
	public Double findBusSeatFare(String flightno) throws AirLineException{
		return dao.findBusSeatFare(flightno);
	}

}
