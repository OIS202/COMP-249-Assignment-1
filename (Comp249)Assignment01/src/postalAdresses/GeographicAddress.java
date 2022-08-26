package postalAdresses;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import baseAddress.Address;
//-------------------------------------------------------------------------------
//Part: One
//Written by: Omar Ihab Mohammed Aboubakr Abdalla Shehata (Student ID: 40164193)
//-------------------------------------------------------------------------------
public class GeographicAddress extends Address {

String addressLine;
String city;
String regionOrState;
String zipOrPostCode;
Locale locale;
/**
* Default Constructor
*/
public	GeographicAddress()
{
	super();
	addressLine = "";
	city = "";
	regionOrState = "";
	zipOrPostCode = "";
	this.locale = new Locale();
}
/**
*Parameterized Constructor
*/
public GeographicAddress(String addressLine, String city, String regionOrState, String zipOrPostCode, Locale locale, String validFrom, String validTo)
{
	super(validFrom, validTo);
	this.addressLine = addressLine;
	this.city = city;
	this.regionOrState = regionOrState;
	this.zipOrPostCode = zipOrPostCode;
	this.locale = new Locale(locale, validFrom, validTo);
}
/**
*Copy Constructor
*/
public GeographicAddress(GeographicAddress geographicAddress, Address address)
{
	super(address);
	this.addressLine = geographicAddress.addressLine;
	this.city = geographicAddress.city;
	this.regionOrState = geographicAddress.regionOrState;
	this.zipOrPostCode = geographicAddress.zipOrPostCode;
	this.locale = new Locale(geographicAddress.locale, address);
}
/**
 * Returns a description of the object 
 */
public String toString()
{
	DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
	Calendar cal = Calendar.getInstance();
	if((sdf.format(cal.getTime()).compareTo(validFrom)==-1)||((sdf.format(cal.getTime()).compareTo(validTo)==1)))
		return "This geographic address has an address line of "+addressLine+" and is in the city of "+city+", in the region/state of "+regionOrState+" and has the zip/post Cod of "+zipOrPostCode+" and has a locale of "+locale.getLocale()+" valid from "+validFrom+" and valid to "+validTo+" and therefore unusable today as it's obsolete.";
	else
		return "This geographic address has an address line of "+addressLine+" and is in the city of "+city+", in the region/state of "+regionOrState+" and has the zip/post Cod of "+zipOrPostCode+" and has a locale of "+locale.toString()+" valid from "+validFrom+" and valid to "+validTo+" and therefore usable today.";
}
/**
 * Compares an object of this class with another object of the same class
 * If object is null or not of this class it returns false
 * If it is not null and is of this class and the two objects are identical it returns true
 * @param geographicAddress
 * @return boolean value
 */
public boolean equals(GeographicAddress geographicAddress)
{
	if((geographicAddress == null)|| !(geographicAddress instanceof GeographicAddress))
		return false;
	else if((this.validTo == geographicAddress.validTo)&&(this.validFrom == geographicAddress.validFrom)&&(this.addressLine == geographicAddress.addressLine)&&(this.city==geographicAddress.city)&&(this.regionOrState==geographicAddress.regionOrState)&&(this.zipOrPostCode==geographicAddress.zipOrPostCode)&&(this.locale.equals(geographicAddress.locale)))
		return true;
	return false;
}
public String getAddressLine()
{
	return addressLine;
}
public String getCity()
{
	return city;
}
public String getRegionOrState()
{
	return regionOrState;
}
public String getZipOrPostCode()
{
	return zipOrPostCode;
}
public String getLocale()
{
	return locale.getLocale();
}
public void setAddressLine(String addressLine)
{
	this.addressLine = addressLine;
}
public void setCity(String city)
{
	this.city = city;
}
public void setRegionOrState(String regionOrState)
{
	this.regionOrState = regionOrState;
}
public void setZipOrPostCode(String zipOrPostCode)
{
	this.zipOrPostCode = zipOrPostCode;
}
}
