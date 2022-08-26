package postalAdresses;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import baseAddress.Address;
import nonPostalAdresses.EmailAddress;
//-------------------------------------------------------------------------------
//Part: One
//Written by: Omar Ihab Mohammed Aboubakr Abdalla Shehata (Student ID: 40164193)
//-------------------------------------------------------------------------------
/**
 *Locale in form of: countryCodeintgerCountryCodecountryName
 */
public class Locale extends Address {

String countryCode;
int integerCountryCode;
String countryName;
/**
* Default Constructor	
*/
public Locale()
{
	super();
	countryCode = "";
	integerCountryCode = 0;
	countryName = "";
}
/**
* Parameterized Constructor	
*/
public Locale(String countryCode, int integerCountryCode, String countryName, String validFrom, String validTo)
{
	super(validFrom, validTo);
	this.countryCode = countryCode;
	this.integerCountryCode = integerCountryCode;
	this.countryName = countryName;
}
/**
* Copy Constructor	
*/
public Locale(Locale locale, Address address)
{
	super(address);
	this.countryCode = locale.countryCode;
	this.integerCountryCode = locale.integerCountryCode;
	this.countryName = locale.countryName;
}/**
* Copy/Parameterized Constructor	
*/
public Locale(Locale locale, String validFrom, String validTo)
{
	super(validFrom, validTo);
	this.countryCode = locale.countryCode;
	this.integerCountryCode = locale.integerCountryCode;
	this.countryName = locale.countryName;
}	
/**
 * Returns a description of the object 
 */
public String toString()
{
	DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
	Calendar cal = Calendar.getInstance();
	if((sdf.format(cal.getTime()).compareTo(validFrom)==-1)||((sdf.format(cal.getTime()).compareTo(validTo)==1)))
		return "This locale is "+(countryCode+" "+integerCountryCode+" "+countryName)+" valid from "+validFrom+" and valid to "+validTo+" and therefore unusable today as it's obsolete.";
	else
		return "This locale is "+(countryCode+" "+integerCountryCode+" "+countryName)+" valid from "+validFrom+" and valid to "+validTo+" and therefore usable today.";
}
/**
 * Compares an object of this class with another object of the same class
 * If object is null or not of this class it returns false
 * If it is not null and is of this class and the two objects are identical it returns true
 * @param telecom
 * @return boolean value
 */
public boolean equals(Locale locale)
{
	if((locale == null)|| !(locale instanceof Locale))
		return false;
	else if((this.validTo == locale.validTo)&&(this.validFrom == locale.validFrom)&&(this.countryCode == locale.countryCode)&&(this.integerCountryCode==locale.integerCountryCode)&&(this.countryName==locale.countryName))
		return true;
	return false;
}
public String getCountryCode()
{
	return countryCode;
}
public int getIntegerCountryCode()
{
	return integerCountryCode;
}
public String getCountryName()
{
	return countryName;
}
public void setCountryCode(String countryCode)
{
	this.countryCode = countryCode;
}
public void setIntegerCountryCode(int integerCountryCode)
{
	this.integerCountryCode = integerCountryCode;
}
public void setCountryName(String countryName)
{
	this.countryName = countryName;
}
public String getLocale()
{
	return (countryCode+String.valueOf(integerCountryCode)+countryName);
}
}
