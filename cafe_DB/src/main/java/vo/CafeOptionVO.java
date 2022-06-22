package vo;

public class CafeOptionVO {
	private String opNum;	 // char(4) not null primary key,
	private String opName;	 // varchar(10) not null,
	private int opPrice;	 // int not null,
	private String required; // char(1) not null
	
	public String getOpNum() {
		return opNum;
	}
	public void setOpNum(String opNum) {
		this.opNum = opNum;
	}
	
	public String getOpName() {
		return opName;
	}
	public void setOpName(String opName) {
		this.opName = opName;
	}
	
	public int getOpPrice() {
		return opPrice;
	}
	public void setOpPrice(int opPrice) {
		this.opPrice = opPrice;
	}
	
	public String getRequired() {
		return required;
	}
	public void setRequired(String required) {
		this.required = required;
	}
}
