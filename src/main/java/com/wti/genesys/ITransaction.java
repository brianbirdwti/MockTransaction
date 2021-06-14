package com.wti.genesys;

import java.util.Map;

public interface ITransaction {
	public enum Status {
		OK("Ok"),
		ERROR("Error"),
		FAILURE("Failure"),
		NODATA("Nodata");
		private String text;
		Status(String text) {
			this.text = text;
		}
		@Override
		public String toString() {
			return this.text;
		}
	}
	
	public void executeTransaction(Map<String, String> params);
	public Map<String, Object> getResult();
	public Status getTransactionStatus();
}
