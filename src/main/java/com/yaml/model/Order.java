package com.yaml.model;


import java.util.Date;
import java.util.List;

public class Order {
	/**
	 * private: phải dùng Getter/setter nếu ko sẽ báo lỗi
	 */
    private String orderNo;
    /**
     * dùng Date. 
     * LocalDate sẽ báo lỗi thư viện Jackson ko hỗ trợ chuyển đổi
     */
    private Date date;
    private String customerName;
    private List<OrderLine> orderLines;
    
	/**
	 * private: phải dùng Getter/setter nếu ko sẽ báo lỗi
	 */
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public List<OrderLine> getOrderLines() {
		return orderLines;
	}
	public void setOrderLines(List<OrderLine> orderLines) {
		this.orderLines = orderLines;
	}

    // Constructors, Getters, Setters and toString
    
}
