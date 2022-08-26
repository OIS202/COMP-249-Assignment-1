//-------------------------------------------------------------------------------
//Part: End of One and  All of Two
//Written by: Omar Ihab Mohammed Aboubakr Abdalla Shehata (Student ID: 40164193)
//-------------------------------------------------------------------------------
import baseAddress.Address;
import nonPostalAdresses.EmailAddress;
import nonPostalAdresses.TelecomAddress;
import nonPostalAdresses.WebPageAddress;
import postalAdresses.GeneralDeliveryAddress;
import postalAdresses.GeographicAddress;
import postalAdresses.Locale;
import postalAdresses.PostOfficeBoxAddress;
public class Driver {
	/**
	 * Takes an array of addresses and returns a copy of it
	 * @param array
	 * @return copyArray
	 */
	public static Address[] copyAddresses(Address[] array) 
	{
		Address[] copyArray = new Address[array.length];
		for(int i = 0;i<array.length;i++)
		{
			if(array[i] != null)
				copyArray[i] = new Address(array[i]);
		}
		return copyArray;
	}
	public static void main(String[] args) {
		Address baseAddress = new Address("2012-05-15","2020-07-21");
		System.out.println(baseAddress);
		Address baseAddress2 = new Address("2013-07-25","2020-11-21");
		System.out.println(baseAddress2);
		Address baseAddress3 = new Address("2012-05-15","2020-07-21");
		System.out.println(baseAddress3);
		EmailAddress emailAddress = new EmailAddress("barco","university","org","2015-09-19","2021-19-04");
		System.out.println(emailAddress);
		EmailAddress emailAddress2 = new EmailAddress("bervee","store","org","2015-12-19","2025-11-04");
		System.out.println(emailAddress2);
		WebPageAddress webpage = new WebPageAddress("wizno","app","2022-01-05","2025-09-08");
		System.out.println(webpage);
		WebPageAddress webpage2 = new WebPageAddress("fronpring","clothing","2021-01-05","2030-09-08");
		System.out.println(webpage2);
		TelecomAddress telecom = new TelecomAddress("1","0",208,789,1234567,"mobile","2020-01-06","2025-07-08");
		System.out.println(telecom);
		TelecomAddress telecom2 = new TelecomAddress("5","6",345,999,4569874,"mobile","2045-01-06","2055-07-08");
		System.out.println(telecom2);
		Locale locale = new Locale("US",840,"the united states of america","2025-01-06","2025-10-28");
		System.out.println(locale);
		Locale locale2 = new Locale("CA",124,"canada","2015-11-06","2017-10-30");
		System.out.println(locale2);
		GeographicAddress geo = new GeographicAddress("Doughnut Street","Manhattan","New York","963258",locale,"2025-01-06","2025-10-28");
		System.out.println(geo);
		GeographicAddress geo2 = new GeographicAddress("Bannana Street","Los Angeles","California","785412",locale2,"2005-01-06","2007-12-28");
		System.out.println(geo2);
		GeneralDeliveryAddress gen = new GeneralDeliveryAddress("Doughnut Steet","Manhattan","New York","963258",telecom,"2025-01-06","2025-10-28");
		System.out.println(gen);
		GeneralDeliveryAddress gen2 = new GeneralDeliveryAddress("Bannana Street","Los Angeles","California","785412",telecom2,"2005-01-06","2007-12-28");
		System.out.println(gen2);
		PostOfficeBoxAddress post = new PostOfficeBoxAddress(10001,"Doughnut Street","Manhattan","New York","963258",locale,"2025-01-06","2025-10-28");
		System.out.println(post);
		PostOfficeBoxAddress post2 = new PostOfficeBoxAddress(10001,"Doughnut Street","Manhattan","New York","963258",locale2,"2025-01-06","2025-10-28");
		System.out.println(post2);
		System.out.println(post.equals(post2));
		System.out.println(baseAddress.equals(baseAddress3));
		System.out.println(locale.equals(locale2));
		System.out.println(post.equals(locale2));
		Address[] array = new Address[15];
		array[0] = new Address("2014-07-25","2023-07-21");
		array[1] = new Address("2024-08-25","2033-07-30");
		array[2] = new EmailAddress("srava","cleaningcompany","com","2015-11-19","2022-11-04");
		array[3] = new EmailAddress("oleo","frenchfries","com","2010-12-19","2025-09-04");
		array[4] = new WebPageAddress("cosno","calculators","2025-02-05","2025-09-08");
		array[5] = new WebPageAddress("mama","burgers","2017-04-05","2022-11-08");
		array[6] = new TelecomAddress("9","5",118,700,5691347,"mobile","2010-01-06","2015-07-08");
		array[7] = new TelecomAddress("11","4",889,600,7895236,"mobile","2009-05-06","2015-07-08");
		array[8] = new Locale("SA",755,"Saudi Arabia","2055-01-06","2065-10-28");
		array[9] = new Locale("EG",555,"Egypt","2005-01-06","2015-10-28");
		array[10] = new GeographicAddress("Slime Street","Queens","New York","789654",locale,"2018-01-06","2025-10-28");
		array[11] = new GeographicAddress("Computer Street","Brooklyn","New York","741258",locale,"2008-01-06","2025-10-28");
		array[12] = new GeneralDeliveryAddress("Doughnut Steet","Manhattan","New York","963258",telecom2,"2025-01-06","2025-10-28");
		array[13] = new GeneralDeliveryAddress("Love Steet","Manhattan","New York","963258",telecom2,"2015-01-06","2025-10-28");
		array[14] = new PostOfficeBoxAddress(12332,"Love Street","Manhattan","New York","963258",locale,"2015-01-06","2025-10-28");
		traceObseleteAddresses(array, 2021, 11, 11);
		Address[] copyArray = copyAddresses(array);
		for(int i = 0;i<array.length;i++)
			System.out.println(array[i]);
		for(int i = 0;i<copyArray.length;i++)
			System.out.println(copyArray[i]);
		System.out.println("The copying was not correct beacuse of the limitation of using the copy constructors when there are child classes.");
		System.out.println("If we would have used the clone method or used the equals() method before copying to check the exact object tupe the copying would have beem correct.");
	}
	/**
	 * Takes a date(split up into a year variable a month variable and a day variable)
	 * It loops through the array of addresses to check which address is obselete in comparison with the passed date
	 * @param array
	 * @param year
	 * @param month
	 * @param day
	 */
	public static void traceObseleteAddresses(Address[] array, int year, int month, int day)
	{
		for(int i = 0;i < array.length;i++)
		{
			if((String.valueOf(year).compareTo(array[i].getValidFrom().substring(0, 4))==-1)||(String.valueOf(year).compareTo(array[i].getValidTo().substring(0, 4))==1))
				System.out.println(array[i]+". This address is obselte in comparison with passed address. There location in the array is "+i+".");
			else if((String.valueOf(year).compareTo(array[i].getValidFrom().substring(0, 4))==0)&&(String.valueOf(year).compareTo(array[i].getValidTo().substring(0, 4))==0))
			{
				if((String.valueOf(month).compareTo(array[i].getValidFrom().substring(5, 7))==-1)||(String.valueOf(month).compareTo(array[i].getValidTo().substring(5, 7))==1))
					System.out.println(array[i]+". This address is obselte in comparison with passed address. There location in the array is "+i+".");
				else if((String.valueOf(month).compareTo(array[i].getValidFrom().substring(5, 7))==0)&&(String.valueOf(month).compareTo(array[i].getValidTo().substring(5, 7))==0))
				{
					if((String.valueOf(day).compareTo(array[i].getValidFrom().substring(8))==-1)||(String.valueOf(day).compareTo(array[i].getValidTo().substring(8))==1))
						System.out.println(array[i]+". This address is obselte in comparison with passed address. There location in the array is "+i+".");
				}
			}
		}	
	}
}
