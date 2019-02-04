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

public class AirLineDAOImpl implements IAirLineDAO {

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
			insertStmt.setDate(4, new java.sql.Date(dto.getBooking_date()
					.getTime()));

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
			preparedStatement = conn.prepareStatement(IQueryMapper.GET_FLIGHTS);
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
				bn.setDept_time(resultSet.getString(7));
				bn.setArr_time(resultSet.getString(8));
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
	public Double findFirstSeatFare(String flightno) throws AirLineException {
		Double id = 0.0;
		Connection conn;
		PreparedStatement getid;

		try {
			conn = DBconnection.getConnection();
			getid = conn.prepareStatement(IQueryMapper.GET_FIRST_SEAT_FARE);
			getid.setString(1, flightno);
			ResultSet id1 = getid.executeQuery();
			while (id1.next()) {
				id = id1.getDouble(1);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return id;
	}

	@Override
	public Double findBusSeatFare(String flightno) throws AirLineException {
		Double id = 0.0;
		Connection conn;
		PreparedStatement getid;

		try {
			conn = DBconnection.getConnection();
			getid = conn.prepareStatement(IQueryMapper.GET_BUS_SEAT_FARE);
			getid.setString(1, flightno);
			ResultSet id1 = getid.executeQuery();
			while (id1.next()) {
				id = id1.getDouble(1);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return id;
	}

	@Override
	public int getBookingid() throws AirLineException {
		int id = 0;
		Connection conn;
		PreparedStatement getid;

		try {
			conn = DBconnection.getConnection();
			getid = conn.prepareStatement(IQueryMapper.GET_BOOKINGID);
			ResultSet id1 = getid.executeQuery();
			while (id1.next()) {
				id = id1.getInt(1);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return id;
	}

	@Override
	public void updateSeats(String string, String class_type,
			int no_of_passengers) throws AirLineException {
		Connection conn;
		PreparedStatement getSTMNT;
		PreparedStatement getSTMNT1;
		int value = 0;
		int value2 = 0;
		int setResult = 0;
		try {
			conn = DBconnection.getConnection();
			if (string.equals("First Seat")) {

				getSTMNT = conn.prepareStatement(IQueryMapper.GET_FIRST_SEATS);
				getSTMNT.setString(1, string);
				ResultSet set = getSTMNT.executeQuery();
				while (set.next()) {
					value = set.getInt(1);
				}
				value2 = value - no_of_passengers;
				getSTMNT1 = conn
						.prepareStatement(IQueryMapper.UPDATE_FIRST_SEATS);
				getSTMNT1.setString(2, string);
				getSTMNT1.setInt(1, value2);
				setResult = getSTMNT1.executeUpdate();
				getSTMNT.close();
				getSTMNT1.close();
			} else if (string.equals("Bus Seat")) {
				getSTMNT = conn.prepareStatement(IQueryMapper.GET_BUS_SEATS);
				getSTMNT.setString(1, string);
				ResultSet set = getSTMNT.executeQuery();
				while (set.next()) {
					value = set.getInt(1);
				}
				value2 = value - no_of_passengers;
				getSTMNT1 = conn
						.prepareStatement(IQueryMapper.UPDATE_BUS_SEATS);
				getSTMNT1.setString(2, string);
				getSTMNT1.setInt(1, value2);
				setResult = getSTMNT1.executeUpdate();
				getSTMNT.close();
				getSTMNT1.close();
			}
			if (setResult != 1) {
				throw new AirLineException(
						"Sorry can not proccess your request");
			} else {

				conn.commit();
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
}
