package postalAdresses;
//-------------------------------------------------------------------------------
//Part: One
//Written by: Omar Ihab Mohammed Aboubakr Abdalla Shehata (Student ID: 40164193)
//-------------------------------------------------------------------------------
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import baseAddress.Address;

public class PostOfficeBoxAddress extends GeographicAddress {

int boxLobbyDoorCode;	
/**
 *Default Constructor 		
*/
public PostOfficeBoxAddress()
{
	super();
	boxLobbyDoorCode = 0;
}
/**
 *Parameterized Constructor 		
*/
public PostOfficeBoxAddress(int boxLobbyDoorCode, String addressLine, String city, String regionOrState, String zipOrPostCode, Locale locale, String validFrom, String validTo)
{
	super(addressLine, city, regionOrState, zipOrPostCode, locale, validFrom, validTo);
	this.boxLobbyDoorCode = boxLobbyDoorCode;
}
/**
 *Copy Constructor 		
*/
public PostOfficeBoxAddress(PostOfficeBoxAddress postOfficeBoxAddress, GeographicAddress geographicAddress, Address address)
{
	super(geographicAddress, address);
	this.boxLobbyDoorCode = postOfficeBoxAddress.boxLobbyDoorCode;
}
/**
 * Returns a description of the object 
 */
public String toString()
{
	DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
	Calendar cal = Calendar.getInstance();
	if((sdf.format(cal.getTime()).compareTo(validFrom)==-1)||((sdf.format(cal.getTime()).compareTo(validTo)==1)))
		return "This post office box address has an address line of "+addressLine+" and is in the city of "+city+", in the region/state of "+regionOrState+" and has the zip/post Code of "+zipOrPostCode+" and has a locale of "+locale.getLocale()+" and has a box lobby door code of "+boxLobbyDoorCode+" valid from "+validFrom+" and valid to "+validTo+" and therefore unusable today as it's obsolete.";
	else
		return "This geographic address has an address line of "+addressLine+" and is in the city of "+city+", in the region/state of "+regionOrState+" and has the zip/post Cod of "+zipOrPostCode+" and has a locale of "+locale.getLocale()+" valid from "+validFrom+" and valid to "+validTo+" and therefore usable today.";
}
/**
 * Compares an object of this class with another object of the same class
 * If object is null or not of this class it returns false
 * If it is not null and is of this class and the two objects are identical it returns true
 * @param postOfficeBoxAddress
 * @return boolean value
 */
public boolean equals(PostOfficeBoxAddress postOfficeBoxAddress)
{
	if((postOfficeBoxAddress == null)|| !(postOfficeBoxAddress instanceof GeographicAddress))
		return false;
	else if((this.validTo == postOfficeBoxAddress.validTo)&&(this.validFrom == postOfficeBoxAddress.validFrom)&&(this.addressLine == postOfficeBoxAddress.addressLine)&&(this.city==postOfficeBoxAddress.city)&&(this.regionOrState==postOfficeBoxAddress.regionOrState)&&(this.zipOrPostCode==postOfficeBoxAddress.zipOrPostCode)&&(this.locale.equals(postOfficeBoxAddress.locale))&&(this.boxLobbyDoorCode==postOfficeBoxAddress.boxLobbyDoorCode))
		return true;
	return false;
}
public int getBoxLobbyDoorCode()
{
	return boxLobbyDoorCode;
}
public void setBoxLobbyDoorCode(int boxLobbyDoorCode)
{
	this.boxLobbyDoorCode = boxLobbyDoorCode;
}
}

