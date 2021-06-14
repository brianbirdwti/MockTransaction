package com.wti.genesys;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Transaction implements ITransaction {

	static Logger LOGGER = LogManager.getLogger(Transaction.class);
	private Map<String, Object> result;
	private Status status = Status.ERROR; 
	
	@Override
	public void executeTransaction(Map<String, String> params) {
		LOGGER.info(">> executeTransaction");
		LOGGER.info("Fake some results and return");
		this.status = Status.OK;
		this.result = new HashMap<String, Object>();
		HashMap<String, Object> dataMap = new HashMap<>();
		List<String> dataArray = Arrays.asList("red", "blue", "green");
		dataMap.put("records", dataArray);
		dataMap.put("ticket", "123456");
		this.result.put("Data", dataMap);
		LOGGER.info("<< executeTransaction");
	}

	@Override
	public Map<String, Object> getResult() {
		if (this.result == null ) {
			this.result = new HashMap<String, Object>();
		}
		return this.result;
	}

	@Override
	public Status getTransactionStatus() {
		return this.status;
	}

	
	
}
