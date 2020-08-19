package com.wellsfargo.coronakit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.wellsfargo.coronakit.entity.CoronaKit;
import com.wellsfargo.coronakit.exception.CoronaException;

public class CoronaKitDaoJDBCImpl implements CoronaKitDao {
	
	public static final String INS_QRY="INSERT INTO coronakit(id,name,description,cost)VALUES(?,?,?,?)";
	public static final String UPD_QRY = "UPDATE coronakit SET name=?,description=?,cost=? WHERE id=?";
	public static final String DEL_QRY = "DELETE FROM coronakit WHERE id=?";
	public static final String GET_ALL_QRY = "SELECT id,name,description,cost FROM coronakit";
	public static final String GET_BYID_QRY= "SELECT id,name,description,cost FROM coronakit WHERE id=?";

	@Override
	public CoronaKit add(CoronaKit coronaKit) throws CoronaException {
		if(coronaKit!=null)
		{
			try (Connection con = ConnectionFactory.getConnection();
					PreparedStatement pst = con.prepareStatement(INS_QRY);) {
				
				pst.setInt(1, coronaKit.getId());
				pst.setString(2, coronaKit.getName());
				pst.setString(3, coronaKit.getDescription());
				pst.setDouble(4, coronaKit.getCost());
				pst.executeUpdate();
				
			}
			catch(SQLException exp)
			{
				throw new CoronaException("An error occurred, could not Add!");
			}
		}
		return coronaKit;
	}

	@Override
	public CoronaKit Edit(CoronaKit coronaKit) throws CoronaException {
		if(coronaKit!=null)
		{
			try (Connection con = ConnectionFactory.getConnection();
					PreparedStatement pst = con.prepareStatement(UPD_QRY);) {
				
				pst.setString(1, coronaKit.getName());
				pst.setString(2, coronaKit.getDescription());
				pst.setDouble(3, coronaKit.getCost());
				pst.setInt(4, coronaKit.getId());
				pst.executeUpdate();
				
			}
			catch(SQLException exp)
			{
				throw new CoronaException("An error occurred, could not Edit!");
			}
		}
		return coronaKit;
	}

	@Override
	public boolean deleteById(int coronaKitId) throws CoronaException {
		boolean isDeleted=false;
		
		try (Connection con = ConnectionFactory.getConnection();
				PreparedStatement pst = con.prepareStatement(DEL_QRY);) {
			
			pst.setInt(1, coronaKitId);
			int rowsCount=pst.executeUpdate();
			isDeleted=rowsCount>0;
			
		}
		catch(SQLException exp)
		{
			throw new CoronaException("An error occurred, could not Delete!");
		}
		
		return isDeleted;
	}

	@Override
	public List<CoronaKit> getAll() throws CoronaException {
		List<CoronaKit> coronaKits=new ArrayList<>();
		
		try (Connection con = ConnectionFactory.getConnection();
				PreparedStatement pst = con.prepareStatement(GET_ALL_QRY);) {
			
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				CoronaKit coronaKit = new CoronaKit();
				coronaKit.setId(rs.getInt(1));
				coronaKit.setName(rs.getString(2));
				coronaKit.setDescription(rs.getString(3));
				coronaKit.setCost(rs.getDouble(4));
				coronaKits.add(coronaKit);
			}
			
			if(coronaKits.isEmpty())
			{
				coronaKits=null;
			}
			
		}
		
		catch(SQLException exp)
		{
			throw new CoronaException("An error occurred, could not retrieve!");
		}
		
		return coronaKits;
	}

	@Override
	public CoronaKit getById(int coronaKitId) throws CoronaException {
		CoronaKit coronaKit = null;
		try (Connection con = ConnectionFactory.getConnection();
				PreparedStatement pst = con.prepareStatement(GET_BYID_QRY);) {
			
			pst.setInt(1, coronaKitId);
			ResultSet rs = pst.executeQuery();
			if(rs.next())
			{
				coronaKit = new CoronaKit();
				coronaKit.setId(rs.getInt(1));
				coronaKit.setName(rs.getString(2));
				coronaKit.setDescription(rs.getString(3));
				coronaKit.setCost(rs.getDouble(4));
			}
			
		}
		
		catch(SQLException exp)
		{
			throw new CoronaException("An error occurred, could not retrieve!");
		}
		
		return coronaKit;
	}

}
