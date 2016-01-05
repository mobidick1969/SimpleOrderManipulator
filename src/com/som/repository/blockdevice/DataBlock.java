package com.som.repository.blockdevice;

import java.io.IOException;
import java.util.List;

/**
 * Created by mobidick on 2016. 1. 4..
 */

public interface DataBlock {

	List<String> fetchAll() throws IOException;
	void saveAll(List<String> lines) throws IOException;
	void save(String line) throws IOException;
}
