package com.wellsfargo.coronakit.dao;

import java.util.List;

import com.wellsfargo.coronakit.entity.CoronaKit;
import com.wellsfargo.coronakit.exception.CoronaException;

public interface CoronaKitDao {

	CoronaKit add(CoronaKit coronaKit) throws CoronaException;
	CoronaKit Edit(CoronaKit coronaKit) throws CoronaException;
	boolean deleteById(int coronaKitId) throws CoronaException;
	List<CoronaKit> getAll() throws CoronaException;
	CoronaKit getById(int id) throws CoronaException;
}
