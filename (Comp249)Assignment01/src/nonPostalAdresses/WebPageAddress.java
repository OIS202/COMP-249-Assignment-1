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
 *URL in form: www.domainName/resourceName
 */
public class WebPageAddress extends Address {

private String domainName;	
private String resourceName;
/**
 *Default Constructor
 */
public WebPageAddress()
{
	super();
	domainName = "";
	resourceName = "";
}
/**
 *Parameterized Constructor
 */
public WebPageAddress(String domainName, String resourceName, String validFrom, String validTo)
{
	super(validFrom, validTo);
	this.domainName = domainName;
	this.resourceName = resourceName;
}
public WebPageAddress(String domainName, String validFrom, String validTo)
{
	super(validFrom, validTo);
	this.domainName = domainName;
}
/**
 *Copy Constructor
 */
public WebPageAddress(WebPageAddress webPageAddress, Address address)
{
	super(address);
	this.domainName = webPageAddress.domainName;
	this.resourceName = webPageAddress.resourceName;
}
/**
 * Returns a description of the object 
 */
public String toString()
{
	DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
	Calendar cal = Calendar.getInstance();
	if((sdf.format(cal.getTime()).compareTo(validFrom)==-1)||((sdf.format(cal.getTime()).compareTo(validTo)==1)))
		return "This web page address is "+("www."+domainName+"/"+resourceName)+" valid from "+validFrom+" and valid to "+validTo+" and therefore unusable today as it's obsolete.";
	else
		return "This web page address is "+("www."+domainName+"/"+resourceName)+" valid from "+validFrom+" and valid to "+validTo+" and therefore usable today.";
}
/**
 * Compares an object of this class with another object of the same class
 * If object is null or not of this class it returns false
 * If it is not null and is of this class and the two objects are identical it returns true
 * @param webpage
 * @return boolean value
 */
public boolean equals(WebPageAddress webPage)
{
	if((webPage == null)|| !(webPage instanceof WebPageAddress))
		return false;
	else if((this.validTo == webPage.validTo)&&(this.validFrom == webPage.validFrom)&&(this.domainName == webPage.domainName)&&(this.resourceName==webPage.resourceName))
		return true;
	return false;
}
public String getDomainName()
{
	return domainName;
}
public String getResourceName()
{
	return resourceName;
}
public void setDomainName(String domainName)
{
	this.domainName = domainName;
}
public void setResourceName(String resourceName)
{
	this.resourceName = resourceName;
}
}
