package postalAdresses;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import baseAddress.Address;
import nonPostalAdresses.TelecomAddress;
//-------------------------------------------------------------------------------
//Part: One
//Written by: Omar Ihab Mohammed Aboubakr Abdalla Shehata (Student ID: 40164193)
//-------------------------------------------------------------------------------
public class GeneralDeliveryAddress extends Address {

String addressLine;
String city;
String regionOrState;
String zipOrPostCode;
TelecomAddress telecomAddress;	
/**
 *Default Constructor
 */
public GeneralDeliveryAddress() 
{
	super();
	addressLine="";
	city="";
	regionOrState="";
	zipOrPostCode="";
	this.telecomAddress =  new TelecomAddress();
}
/**
 *Parameterized Constructor
 */
public GeneralDeliveryAddress(String addressLine, String city, String regionOrState, String zipOrPostCode, TelecomAddress telecomeAddress, String validFrom, String validTo) 
{
	super(validFrom, validTo);
	this.addressLine=addressLine;
	this.city=city;
	this.regionOrState=regionOrState;
	this.zipOrPostCode=zipOrPostCode;
	this.telecomAddress =  new TelecomAddress(telecomeAddress, validFrom, validTo);
}
/**
 *Copy Constructor
 */
public GeneralDeliveryAddress(GeneralDeliveryAddress generalDeliveryAddress, Address address) 
{
	super(address);
	this.addressLine=generalDeliveryAddress.addressLine;
	this.city=generalDeliveryAddress.city;
	this.regionOrState=generalDeliveryAddress.regionOrState;
	this.zipOrPostCode=generalDeliveryAddress.zipOrPostCode;
	this.telecomAddress =  new TelecomAddress(generalDeliveryAddress.telecomAddress, address);
}
/**
 * Returns a description of the object 
 */
public String toString()
{
	DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
	Calendar cal = Calendar.getInstance();
	if((sdf.format(cal.getTime()).compareTo(validFrom)==-1)||((sdf.format(cal.getTime()).compareTo(validTo)==1)))
		return "This general delivery address has an address line of "+addressLine+" and is in the city of "+city+", in the state/region of "+regionOrState+" and has a zip/post code of "+zipOrPostCode+" and has a telecom address of "+telecomAddress.getTelecomAddress()+" valid from "+validFrom+" and valid to "+validTo+" and therefore unusable today as it's obsolete.";
	else
		return "This general delivery address has an address line of "+addressLine+" and is in the city of "+city+", in the state/region of "+regionOrState+" and has a zip/post code of "+zipOrPostCode+" and has a telecom address of "+telecomAddress.getTelecomAddress()+" valid from "+validFrom+" and valid to "+validTo+" and therefore usable today.";
}
/**
 * Compares an object of this class with another object of the same class
 * If object is null or not of this class it returns false
 * If it is not null and is of this class and the two objects are identical it returns true
 * @param generalDeliveryAddress
 * @return boolean value
 */
public boolean equals(GeneralDeliveryAddress generalDeliveryAddress)
{
	if((generalDeliveryAddress == null)|| !(generalDeliveryAddress instanceof GeneralDeliveryAddress))
		return false;
	else if((this.validTo == generalDeliveryAddress.validTo)&&(this.validFrom == generalDeliveryAddress.validFrom)&&(this.addressLine == generalDeliveryAddress.addressLine)&&(this.city==generalDeliveryAddress.city)&&(this.regionOrState==generalDeliveryAddress.regionOrState)&&(this.zipOrPostCode==generalDeliveryAddress.zipOrPostCode)&&this.telecomAddress.equals(generalDeliveryAddress.telecomAddress))
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
	return telecomAddress.getTelecomAddress();
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
