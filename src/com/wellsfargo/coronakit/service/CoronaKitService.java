package com.wellsfargo.coronakit.service;

import java.util.List;

import com.wellsfargo.coronakit.entity.CoronaKit;
import com.wellsfargo.coronakit.exception.CoronaException;

public interface CoronaKitService {

	CoronaKit validateAndAdd(CoronaKit coronaKit) throws CoronaException;
	CoronaKit validateAndEdit(CoronaKit coronaKit) throws CoronaException;
	boolean deleteCoronaKit(int coronaKitId) throws CoronaException;
	List<CoronaKit> getAllCoronaKits() throws CoronaException;
	CoronaKit getItem(int coronaKitId) throws CoronaException;
}
