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
 * Telecom address in from countryCode NDDnumber extension physicalType
 */
public class TelecomAddress extends Address {

private String countryCode;// this is the IDD
private String nationalDirectDailingPrefix;
private int areaCode;
private int extension;
private long number;
private String physicalType;
/**
 *Default Constructor
 */
public TelecomAddress()
{
	super();
	countryCode= "";
	nationalDirectDailingPrefix = "";
	areaCode = 0;
	extension = 0;
	number = 0;
	physicalType = "";
}
/**
 *Parameterized Constructor
 */
public TelecomAddress(String countryCode, String nDD,int areaCode, int extension, long number, String physicalType, String validFrom, String validTo)
{
	super(validFrom, validTo);
	this.countryCode= countryCode;
	nationalDirectDailingPrefix = nDD;
	this.areaCode = areaCode;
	this.extension = extension;
	this.number = number;
	this.physicalType = physicalType;
}
/**
 *Copy Constructor
 */
public TelecomAddress(TelecomAddress telecomAddress, Address address)
{
	super(address);
	this.countryCode= telecomAddress.countryCode;
	this.nationalDirectDailingPrefix = telecomAddress.nationalDirectDailingPrefix;
	this.areaCode = telecomAddress.areaCode;
	this.extension = telecomAddress.extension;
	this.number = telecomAddress.number;
	this.physicalType = telecomAddress.physicalType;
}
/**
 *Copy/Parameterized Constructor
 */
public TelecomAddress(TelecomAddress telecomAddress, String validFrom, String validTo)
{
	super(validFrom, validTo);
	this.countryCode= telecomAddress.countryCode;
	this.nationalDirectDailingPrefix = telecomAddress.nationalDirectDailingPrefix;
	this.areaCode = telecomAddress.areaCode;
	this.extension = telecomAddress.extension;
	this.number = telecomAddress.number;
	this.physicalType = telecomAddress.physicalType;
}
/**
 * Returns a description of the object 
 */
public String toString()
{
	DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
	Calendar cal = Calendar.getInstance();
	if((sdf.format(cal.getTime()).compareTo(validFrom)==-1)||((sdf.format(cal.getTime()).compareTo(validTo)==1)))
		return "This telecom address is "+("+"+countryCode+" "+"("+nationalDirectDailingPrefix+")"+String.valueOf(areaCode)+" "+String.valueOf(number)+" "+"ext."+String.valueOf(extension)+" "+physicalType)+" valid from "+validFrom+" and valid to "+validTo+" and therefore unusable today as it's obsolete.";
	else
		return "This telecom address is "+("+"+countryCode+" "+"("+nationalDirectDailingPrefix+")"+String.valueOf(areaCode)+" "+String.valueOf(number)+" "+"ext."+String.valueOf(extension)+" "+physicalType)+" valid from "+validFrom+" and valid to "+validTo+" and therefore usable today.";
}
/**
 * Compares an object of this class with another object of the same class
 * If object is null or not of this class it returns false
 * If it is not null and is of this class and the two objects are identical it returns true
 * @param telecom
 * @return boolean value
 */
public boolean equals(TelecomAddress telecom)
{
	if((telecom == null)|| !(telecom instanceof TelecomAddress))
		return false;
	else if((this.validTo == telecom.validTo)&&(this.validFrom == telecom.validFrom)&&(this.countryCode == telecom.countryCode)&&(this.nationalDirectDailingPrefix==telecom.nationalDirectDailingPrefix)&&(this.areaCode==telecom.areaCode)&&(this.extension==telecom.extension)&&(this.number==telecom.number)&&(this.physicalType==telecom.physicalType))
		return true;
	return false;
}
public String getCountryCode()
{
	return countryCode;
}
public String getnDD()
{
	return nationalDirectDailingPrefix;
}
public int getareaCode()
{
	return areaCode;
}
public int getExtension()
{
	return extension;
}
public long getNumber()
{
	return number;
}
public String getPhysicalType()
{
	return physicalType;
}
public void setCountryCode(String countryCode)
{
	this.countryCode = countryCode;
}
public void setnDD(String nDD)
{
	nationalDirectDailingPrefix = nDD;
}
public void setAreaCode(int areaCode)
{
	this.areaCode = areaCode;
}
public void setExtension(int extension)
{
	this.extension = extension;
}
public void setNumber(long number)
{
	this.number = number;
}
public void setPhysicalType(String physicalType)
{
	this.physicalType = physicalType;
}
public String getTelecomAddress()
{
	return (countryCode+nationalDirectDailingPrefix+String.valueOf(areaCode)+String.valueOf(number)+String.valueOf(extension)+physicalType);
}
}
