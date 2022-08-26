package nonPostalAdresses;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import baseAddress.Address;
//-------------------------------------------------------------------------------
//Part: One
//Written by: Omar Ihab Mohammed Aboubakr Abdalla Shehata (Student ID: 40164193)
//-------------------------------------------------------------------------------
/**
 *Email Address in the form: username@domainName.TLD 
 */
public class EmailAddress extends Address {

private String userName;
private String domainName;
private String tld;
/**
 *Default Constructor
 */
public EmailAddress()
{
	super();
	userName = "";
	domainName = "";
	tld = "";
}
/**
 *Parameterized Constructor
 */
public EmailAddress(String userName, String domainName, String tld, String validFrom, String validTo)
{
	super(validFrom, validTo);
	this.userName = userName;
	this.domainName = domainName;
	this.tld = tld;
}
/**
 *Copy Constructor
 */
public EmailAddress(EmailAddress emailAddress, Address address)
{
	super(address);
	this.userName = emailAddress.userName;
	this.domainName = emailAddress.domainName;
	this.tld = emailAddress.tld;
}
/**
 * Returns a description of the object 
 */
public String toString()
{
	DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
	Calendar cal = Calendar.getInstance();
	if((sdf.format(cal.getTime()).compareTo(validFrom)==-1)||((sdf.format(cal.getTime()).compareTo(validTo)==1)))
		return "This email address is "+(userName+"@"+domainName+"."+tld)+" valid from "+validFrom+" and valid to "+validTo+" and therefore unusable today as it's obsolete.";
	else
		return "This address is "+(userName+"@"+domainName+"."+tld)+" valid from "+validFrom+" and valid to "+validTo+" and therefore usable today.";
}
/**
 * Compares an object of this class with another object of the same class
 * If object is null or not of this class it returns false
 * If it is not null and is of this class and the two objects are identical it returns true
 * @param email
 * @return boolean value
 */
public boolean equals(EmailAddress email)
{
	if((email == null)|| !(email instanceof EmailAddress))
		return false;
	else if((this.validTo == email.validTo)&&(this.validFrom == email.validFrom)&&(this.userName == email.userName)&&(this.domainName==email.domainName)&&(this.tld==email.tld))
		return true;
	return false;
}
public void setUserName(String userName)
{
	this.userName = userName;
}
public void setDoaminName(String domainName)
{
	this.domainName = domainName;
}
public void setTLD(String tld)
{
	this.tld = tld;
}
public String getUserName()
{
	return userName;
}
public String getDoaminName()
{
	return domainName;
}
public String getTLD()
{
	return tld;
}
}
