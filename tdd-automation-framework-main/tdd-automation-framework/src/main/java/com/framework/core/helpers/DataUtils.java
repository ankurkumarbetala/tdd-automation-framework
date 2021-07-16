package com.framework.core.helpers;

import com.github.javafaker.Faker;

public class DataUtils {

	public static String getFirstName() {
		return new Faker().address().firstName();
	}

	public static String getLastName() {
		return new Faker().address().lastName();
	}

	public static String getCountry() {
		return new Faker().address().country();
	}

	public static String getCity() {
		return new Faker().address().city();
	}

	public static String getCountryCode() {
		return new Faker().address().countryCode();
	}

	public static String getBuildingNumber() {
		return new Faker().address().buildingNumber();
	}

	public static String getCityName() {
		return new Faker().address().cityName();
	}

	public static String getState() {
		return new Faker().address().state();
	}

	public static String getStreetName() {
		return new Faker().address().streetName();
	}

	public static String getStreetAddress() {
		return new Faker().address().streetAddress();
	}

	public static void main(String[] args) {
		System.out.println(getUniqueSSN());
	}

	public static String getFullAddress() {
		return new Faker().address().fullAddress();
	}

	public static String getUniquePassword() {
		String password = new Faker().lorem().characters(5, 12);
		String specialChars = "@!#$%*";
		password = password.replace(
				password.charAt(new Faker().random().nextInt(password.length())),
				specialChars.charAt(new Faker().random().nextInt(specialChars.length())));
		return password;
	}

	public static String getUniqueSSN() {
		String ssn =new Faker().idNumber().ssnValid();
		System.out.println(ssn);
		return ssn;
	}
	
	public static String getEmailAddress() {
		return new Faker().internet().safeEmailAddress();
	}

	public static String getIPAddress() {
		return new Faker().internet().ipV4Address();
	}

	public static String getUUID() {
		return new Faker().internet().uuid();
	}
	

	

}
