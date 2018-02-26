package ups.sysadmin.model;

import java.util.Date;

public class User {
	
	private String firstName;
    private String lastName;
	private Long userSysNumber;
	private Long userManagerSysNumber;
	private String userNumber;
	private String userStatusCode;
	private String countryCode;
	private Long userRoleSysNr;
	private Long userRoleCategorySysNr;
	private Date recodeEffEndDate;
	private String arWRKGrpSysNumber;
	private String transLangCode;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
	public Long getUserRoleSysNr() {
		return userRoleSysNr;
	}
	public void setUserRoleSysNr(Long userRoleSysNr) {
		this.userRoleSysNr = userRoleSysNr;
	}
	
	
	
	public Long getUserSysNumber() {
		return userSysNumber;
	}
	public void setUserSysNumber(Long userSysNumber) {
		this.userSysNumber = userSysNumber;
	}
	public Long getUserManagerSysNumber() {
		return userManagerSysNumber;
	}
	public void setUserManagerSysNumber(Long userManagerSysNumber) {
		this.userManagerSysNumber = userManagerSysNumber;
	}
	public String getUserNumber() {
		return userNumber;
	}
	public void setUserNumber(String userNumber) {
		this.userNumber = userNumber;
	}
	public String getUserStatusCode() {
		return userStatusCode;
	}
	public void setUserStatusCode(String userStatusCode) {
		this.userStatusCode = userStatusCode;
	}
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	
	public Long getUserRoleCategorySysNr() {
		return userRoleCategorySysNr;
	}
	public void setUserRoleCategorySysNr(Long userRoleCategorySysNr) {
		this.userRoleCategorySysNr = userRoleCategorySysNr;
	}
	public Date getRecodeEffEndDate() {
		return recodeEffEndDate;
	}
	public void setRecodeEffEndDate(Date recodeEffEndDate) {
		this.recodeEffEndDate = recodeEffEndDate;
	}
	public String getArWRKGrpSysNumber() {
		return arWRKGrpSysNumber;
	}
	public void setArWRKGrpSysNumber(String arWRKGrpSysNumber) {
		this.arWRKGrpSysNumber = arWRKGrpSysNumber;
	}
	public String getTransLangCode() {
		return transLangCode;
	}
	public void setTransLangCode(String transLangCode) {
		this.transLangCode = transLangCode;
	}
	
	
}