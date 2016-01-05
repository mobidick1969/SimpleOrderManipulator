package com.som.repository;

import java.io.IOException;
import java.util.List;

/**
 * Created by mobidick on 2016. 1. 4..
 */
public interface Repository<E> {


	List<E> findAll() throws IOException;
	List<E> findByOrderID(String orderID) throws IOException;
	void SaveAll(List<E> l) throws IOException;
}
