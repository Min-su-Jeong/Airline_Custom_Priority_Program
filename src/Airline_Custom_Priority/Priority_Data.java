package Airline_Custom_Priority;

public class Priority_Data {
	double priority;
	private int reg;
	private String name;
	private int mileage;
	private String date;
	
	// 우선순위 고객 데이터
	public Priority_Data(double priority ,int reg, String name, int mileage, String date) {
		this.priority = priority;
		this.reg = reg;
		this.name = name;
		this.mileage = mileage;
		this.date = date;
	}
	// setter
	public void setPriority(double priority) {
		this.priority = priority;
	}
	public void setReg(int reg) {
		this.reg = reg;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setMileage(int mileage) {
		this.mileage = mileage;
	}
	public void setDate(String date) {
		this.date = date;
	}
	// getter
	public double getPriority() {
		return priority;
	}
	public int getReg() {
		return reg;
	}
	public String getName() {
		return name;
	}
	public int getMileage() {
		return mileage;
	}
	public String getDate() {
		return date;
	}
}
