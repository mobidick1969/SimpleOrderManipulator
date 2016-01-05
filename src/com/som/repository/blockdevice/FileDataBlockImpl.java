package com.som.repository.blockdevice;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by mobidick on 2016. 1. 4..
 */
public class FileDataBlockImpl implements DataBlock {

	private String filename = null;
	public FileDataBlockImpl(String filename)
	{
		this.filename = filename;
	}


	@Override public List<String> fetchAll() throws IOException {
		assert filename != null;
		List<String> result = new LinkedList<>();
		BufferedReader bufferedReader = new BufferedReader(new FileReader(filename));
		while( true )
		{
			String line = bufferedReader.readLine();
			if( line==null ) break;
			result.add(line);
		}
		bufferedReader.close();
		return result;
	}

	@Override public void saveAll(List<String> lines) throws IOException {
		FileWriter fileWriter = new FileWriter(filename,true);
		for( String line : lines )
			fileWriter.write(line);
		fileWriter.flush();
		fileWriter.close();
	}

	@Override public void save(String line) throws IOException {
		FileWriter fileWriter = new FileWriter(filename,true);
		fileWriter.write(line);
		fileWriter.flush();
		fileWriter.close();
	}
}
