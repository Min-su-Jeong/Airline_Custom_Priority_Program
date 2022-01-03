package Airline_Custom_Priority;

public class Data {
	private int reg;
	private String name;
	private int mileage;
	private String date;
	private long use_date;
	
	// °í°´ µ¥ÀÌÅÍ
	public Data(int reg, String name, int mileage, String date, long use_date) {
		this.reg = reg;
		this.name = name;
		this.mileage = mileage;
		this.date = date;
		this.use_date = use_date;
	}
	// setter
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
	public long getUsedate() {
		return use_date;
	}
}
