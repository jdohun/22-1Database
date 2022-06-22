package vo;

public class CartVO {
	private String mNum;	// char(4) not null,
	private String cOptions;// varchar(40) not null, /* choiced Options */
	private int cQuantity;	// int not null, /* cart Quantity */
	private int cPrice;		//int not null, /* cart Price */
	/*
	foreign key(mNum) references cafeMenus(mNum),
	primary key(mNum, cOptions)
	*/
	
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
	
	public int getcQuantity() {
		return cQuantity;
	}
	public void setcQuantity(int cQuantity) {
		this.cQuantity = cQuantity;
	}
	
	public int getcPrice() {
		return cPrice;
	}
	public void setcPrice(int cPrice) {
		this.cPrice = cPrice;
	}
	
}
