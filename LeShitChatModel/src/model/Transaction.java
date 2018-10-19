package model;

public class Transaction {
	
	private Action action;
	private ValueObject workdata;
	private String workdataType;
	
	public Transaction(Action action, ValueObject workdata) {
		this.action = action;
		this.workdata = workdata;
		this.workdataType = workdata.getClass().getName();
	}

	public Action getAction() {
		return action;
	}

	public void setAction(Action action) {
		this.action = action;
	}

	public ValueObject getWorkdata() {
		return workdata;
	}
	
	public String getWorkdataType() {
		return workdataType;
	}
}
