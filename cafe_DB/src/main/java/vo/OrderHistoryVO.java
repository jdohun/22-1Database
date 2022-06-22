package vo;

import java.sql.Timestamp;

public class OrderHistoryVO {
	private String odNum;// char(13) not null,
	private String consumer;// char(11) not null,
	private int totalPrice;// int not null,
	private Timestamp odTime;// timestamp default current_timestamp not null,
    /*
    foreign key(consumer) references membership(phoneNumber),
    primary key(odNum)
    */
	public String getOdNum() {
		return odNum;
	}
	public void setOdNum(String odNum) {
		this.odNum = odNum;
	}
	
	public String getConsumer() {
		return consumer;
	}
	public void setConsumer(String consumer) {
		this.consumer = consumer;
	}
	
	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	public Timestamp getOdTime() {
		return odTime;
	}
	public void setOdTime(Timestamp odTime) {
		this.odTime = odTime;
	}
}
