//package com.appointment.appointment;
//
//import java.text.DateFormat;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.time.LocalDate;
//import java.time.format.DateTimeFormatter;
//import java.util.Date;
//
//public class sample {
//
//	public static void main(String[] args) throws ParseException {
//	 TODO Auto-generated method stub
//
//	String firstDate = "26/02/2019";
//		
//
//		String firstTime = "09:00";
//	String secondDate = "27/02/2019";
//		String secondTime = "12:00";
//
//		String format = "dd/MM/yyyy hh:mm";
//		LocalDate date = LocalDate.now(); 
//		System.out.println("Date End: "+date);
//
//		SimpleDateFormat sdf = new SimpleDateFormat(format);
//
//		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//		System.out.println(date.format(formatter));
//		Date dateObj1 = sdf.parse(formatter + " " + firstTime);
//		Date dateObj2 = sdf.parse(formatter + " " + secondTime);
//		System.out.println("Date Start: "+dateObj1);
//		System.out.println("Date End: "+dateObj2);
//
//		long dif = dateObj1.getTime(); 
//		while (dif < dateObj2.getTime()) {
//		    Date slot = new Date(dif);
//		    System.out.println("Hour Slot --->" + slot);
//		    dif += 3600000;
//		}
//	}
//
//}
