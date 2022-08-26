package baseAddress;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
//-------------------------------------------------------------------------------
//Part: One
//Written by: Omar Ihab Mohammed Aboubakr Abdalla Shehata (Student ID: 40164193)
//-------------------------------------------------------------------------------
/**
 * validFrom: in format "YYYY-MM-DD"
 *	validTo: in format "YYYY-MM-DD"
 */
public class Address {
protected String validFrom;
protected String validTo;
/**
 *Default Constructor
 */
public Address()
{
	validFrom = "";
	validTo = "";
}
/**
 *Parameterized Constructor
 */
public Address(String validFrom, String validTo)
{
	this.validFrom = validFrom;
	this.validTo = validTo;
}
/**
 *Copy Constructor
 */
public Address(Address address)
{
	this.validFrom = address.validFrom;
	this.validTo = address.validTo;
}
/**
 * Returns a description of the object 
 */
public String toString()
{
	DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
	Calendar cal = Calendar.getInstance();
	if((sdf.format(cal.getTime()).compareTo(validFrom)==-1)||((sdf.format(cal.getTime()).compareTo(validTo)==1)))
		return "This address is valid from "+validFrom+" and valid to "+validTo+" and therefore unusable today as it's obsolete.";
	else
		return "This address is valid from "+validFrom+" and valid to "+validTo+" and therefore usable today.";
}
public void setValidFrom(String validFrom)
{
	this.validFrom = validFrom;
}
public void setValidTo(String validTo)
{
	this.validTo = validTo;
}
public String getValidFrom()
{
	return validFrom;
}
public String getValidTo()
{
	return validTo;
}
/**
 * Compares an object of this class with another object of the same class
 * If object is null or not of this class it returns false
 * If it is not null and is of this class and the two objects are identical it returns true
 * @param address
 * @return boolean value
 */
public boolean equals(Address address)
{
	if((address == null)|| !(address instanceof Address))
		return false;
	else if((this.validTo == address.validTo)&&(this.validFrom == address.validFrom))
		return true;
	return false;
}
}
