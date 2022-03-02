package vn.ithcmute.model;

public class StatisticsModel {
	private String label;
	private int data;
	public StatisticsModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public StatisticsModel(String labels, int data) {
		super();
		this.label = labels;
		this.data = data;
	}
	public String getLabels() {
		return label;
	}
	@Override
	public String toString() {
		return "StatisticsModel [labels=" + label + ", data=" + data + "]";
	}
	public void setLabels(String labels) {
		this.label = labels;
	}
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	
}
