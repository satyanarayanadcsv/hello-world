package com.cg.airline.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.cg.airline.beans.AirLineBookInfoDTO;
import com.cg.airline.beans.AirLineFlightInfoDTO;
import com.cg.airline.exception.AirLineException;
import com.cg.airline.util.DBconnection;



public class AirLineDAOImpl implements IAirLineDAO{


	@Override
	public void bookTicket(AirLineBookInfoDTO dto) throws AirLineException {
		
		Connection conn;
		PreparedStatement insertStmt;
		try {
			
			conn = DBconnection.getConnection();
			insertStmt = conn.prepareStatement(IQueryMapper.INSERT_QUERY);
			insertStmt.setString(1, dto.getCust_email());
			insertStmt.setInt(2, dto.getNo_of_passengers());
			insertStmt.setString(3, dto.getClass_type());
			insertStmt.setDouble(4, dto.getTotal_fare());
			insertStmt.setString(5, dto.getSeat_number());
			insertStmt.setString(6, dto.getCreditcard_info());
			insertStmt.setString(7, dto.getSrc_city());
			insertStmt.setString(8, dto.getDest_city());
			insertStmt.setString(9, dto.getFlightno());

			int set = insertStmt.executeUpdate();
			if (set != 1) {
				throw new AirLineException(
						"Sorry can not proccess your request");
			} else {
				System.out.println("Successfully Saved Booking Details");
				conn.commit();
				insertStmt.close();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public ArrayList<AirLineFlightInfoDTO> showFlights(String src_city,
			String dest_city) throws AirLineException {
		Connection conn;
		ResultSet resultSet = null;
		PreparedStatement preparedStatement = null;
		ArrayList<AirLineFlightInfoDTO> airDto = new ArrayList<AirLineFlightInfoDTO>();
		try {
			conn = DBconnection.getConnection();
			preparedStatement = conn
					.prepareStatement(IQueryMapper.GET_FLIGHTS);
			preparedStatement.setString(1, src_city);
			preparedStatement.setString(2, dest_city);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				AirLineFlightInfoDTO bn = new AirLineFlightInfoDTO();
				bn.setFlightNo(resultSet.getString(1));
				bn.setAirLine(resultSet.getString(2));
				bn.setDept_city(resultSet.getString(3));
				bn.setArr_city(resultSet.getString(4));
				bn.setDept_date(resultSet.getDate(5));
				bn.setArr_date(resultSet.getDate(6));
				bn.setDept_time(resultSet.getDate(7));
				bn.setArr_time(resultSet.getDate(8));
				bn.setFirst_seats_fare(resultSet.getDouble(10));
				bn.setBus_seats_fare(resultSet.getDouble(12));
				airDto.add(bn);
			}
		} catch (AirLineException e) {
			throw new AirLineException("sorry not updated");
		} catch (SQLException e) {
			throw new AirLineException("sorry not updated");
		}
		return airDto;
	}
	
	@Override
	public Double findFirstSeatFare(String flightno) throws AirLineException{
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Double findBusSeatFare(String flightno) throws AirLineException{
		// TODO Auto-generated method stub
		return null;
	}
	
}
