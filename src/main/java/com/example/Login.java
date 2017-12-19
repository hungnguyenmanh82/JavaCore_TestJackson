package com.example;

/**
 * Class này sẽ đc convert thành Json string
 * */
public class Login {
    public  String user;
    public  String pass;
    public  long appVersion;
    public  long xemqueVersion;
    public  String phoneID;
    public  String ipAdress;
    public  String location;
    public  boolean wifi;
    
    /*
     * default structure rất quan trọng, nếu ko chương trình sẽ báo lỗi
     * */
    public Login(){
    	
    }
    
	public Login(String user, String pass, long appVersion, long xemqueVersion, String phoneID, String ipAdress,
			String location, boolean wifi) {
		super();
		this.user = user;
		this.pass = pass;
		this.appVersion = appVersion;
		this.xemqueVersion = xemqueVersion;
		this.phoneID = phoneID;
		this.ipAdress = ipAdress;
		this.location = location;
		this.wifi = wifi;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public long getAppVersion() {
		return appVersion;
	}
	public void setAppVersion(long appVersion) {
		this.appVersion = appVersion;
	}
	public long getXemqueVersion() {
		return xemqueVersion;
	}
	public void setXemqueVersion(long xemqueVersion) {
		this.xemqueVersion = xemqueVersion;
	}
	public String getPhoneID() {
		return phoneID;
	}
	public void setPhoneID(String phoneID) {
		this.phoneID = phoneID;
	}
	public String getIpAdress() {
		return ipAdress;
	}
	public void setIpAdress(String ipAdress) {
		this.ipAdress = ipAdress;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public boolean isWifi() {
		return wifi;
	}
	public void setWifi(boolean wifi) {
		this.wifi = wifi;
	}


}