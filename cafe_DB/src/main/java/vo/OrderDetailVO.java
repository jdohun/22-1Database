package vo;

public class OrderDetailVO {
	private String odNum;// char(13) not null,
	private String mNum;// char(4) not null,
	private String cOptions;// varchar(40) not null,
	private int odQuantity;// int not null,
	private int odPrice;// int not null,
	
	public String getOdNum() {
		return odNum;
	}
	public void setOdNum(String odNum) {
		this.odNum = odNum;
	}
	
	public String getmNum() {
		return mNum;
	}
	public void setmNum(String mNum) {
		this.mNum = mNum;
	}
	
	public String getcOptions() {
		return cOptions;
	}
	public void setcOptions(String cOptions) {
		this.cOptions = cOptions;
	}
	
	public int getOdQuantity() {
		return odQuantity;
	}
	public void setOdQuantity(int odQuantity) {
		this.odQuantity = odQuantity;
	}
	
	public int getOdPrice() {
		return odPrice;
	}
	public void setOdPrice(int odPrice) {
		this.odPrice = odPrice;
	}
	
	/*
    foreign key(mNum) references cafeMenus(mNum),
    foreign key(odNum) references orderHistory(odNum),
    primary key(odNum, mNum)
    */
}
