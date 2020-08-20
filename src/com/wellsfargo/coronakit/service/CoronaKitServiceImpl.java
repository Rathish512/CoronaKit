package com.wellsfargo.coronakit.service;

import java.util.ArrayList;
import java.util.List;

import com.wellsfargo.coronakit.dao.CoronaKitDao;
import com.wellsfargo.coronakit.dao.CoronaKitDaoJDBCImpl;
import com.wellsfargo.coronakit.entity.CoronaKit;
import com.wellsfargo.coronakit.exception.CoronaException;

public class CoronaKitServiceImpl implements CoronaKitService{
	
	CoronaKitDao coronaKitDao;
	public CoronaKitServiceImpl()
	{
		coronaKitDao = new CoronaKitDaoJDBCImpl();
	}
	
	private boolean isValidId(Integer id)
	{
		return id!=null && id>0;
	}
	
	private boolean isValidName(String name)
	{
		return name!=null && (name.length()>3 && name.length()<30);
	}
	
	private boolean isValidDescription(String description)
	{
		return description!=null && (description.length()>3 && description.length()<500);
	}
	
	private boolean isValidCost(Double cost)
	{
		return cost!=null && cost>0;
	}
	
	private boolean isValidKitDetails(CoronaKit coronaKit) throws CoronaException
	{
		boolean isValid=true;
		List<String> errMsgs=new ArrayList<>();
		if(coronaKit!=null)
		{
			if(!isValidId(coronaKit.getId()))
			{
				isValid=false;
				errMsgs.add("Id must be positive non-repetative number");
			}
			if(!isValidName(coronaKit.getName()))
			{
				isValid=false;
				errMsgs.add("Name must be 3 to 30 characters in length");
			}
			if(!isValidDescription(coronaKit.getDescription()))
			{
				isValid=false;
				errMsgs.add("Description must be 3 to 500 characters in length");
			}
			if(!isValidCost(coronaKit.getCost()))
			{
				isValid=false;
				errMsgs.add("Cost must be positive number");
			}
			if(!errMsgs.isEmpty())
			{
				throw new CoronaException(errMsgs.toString());
			}
		}
		else
		{
			isValid=false;
		}
		return isValid;
	}
	
	@Override
	public CoronaKit validateAndAdd(CoronaKit coronaKit) throws CoronaException {
		if(isValidKitDetails(coronaKit))
		{
			coronaKitDao.add(coronaKit);
		}
		return coronaKit;
	}
	@Override
	public CoronaKit validateAndEdit(CoronaKit coronaKit) throws CoronaException {
		if(isValidKitDetails(coronaKit))
		{
			coronaKitDao.Edit(coronaKit);
		}
		return coronaKit;
	}
	@Override
	public boolean deleteCoronaKit(int coronaKitId) throws CoronaException {
		return coronaKitDao.deleteById(coronaKitId);
	}
	@Override
	public List<CoronaKit> getAllCoronaKits() throws CoronaException {
		
		return coronaKitDao.getAll();
	}

	@Override
	public CoronaKit getItem(int coronaKitId) throws CoronaException {
		return coronaKitDao.getById(coronaKitId);
	}
	
	

}
