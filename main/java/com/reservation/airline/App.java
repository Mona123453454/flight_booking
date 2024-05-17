package com.reservation.airline;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;

import com.reservation.airline.service.AirlineInfoService;
import com.reservation.airline.service.BookingService;
import com.reservation.airline.service.FlightService;
import com.reservation.airline.service.PassengerService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.reservation.airline.entity.AirlineInfo;
import com.reservation.airline.entity.Fare;
import com.reservation.airline.entity.Flight;
import com.reservation.airline.entity.FlightInfo;
import com.reservation.airline.entity.Inventory;

@SpringBootApplication
public class App {

	public static void main(String[] args) throws ParseException {

		ApplicationContext ac = SpringApplication.run(App.class, args);
		FlightService flightService = ac.getBean(FlightService.class);
		BookingService bookingService = ac.getBean(BookingService.class);
		PassengerService passengerService = ac.getBean(PassengerService.class);
		AirlineInfoService airlineInfoService = ac.getBean(AirlineInfoService.class);


		Flight flight = flightService.findByFlightNumberAndFlightDateAndFlightTime("SG-434", LocalDate.of(2020, 8, 21),
				LocalTime.of(11, 45, 00));


		AirlineInfo airlineInfo = airlineInfoService.findByNameOfAirline("Spicejet");
		Flight flight1 = new Flight("CHENNAI", "1hrs 30mins", LocalDate.of(2024, 03, 25), "SG-101",
				LocalTime.of(01, 00, 00), "PUNE", new Fare("INR", 1000),
				new FlightInfo("SG-101", "Airbus", 200, airlineInfo), new Inventory(500));

		Flight flight2 = new Flight("CHENNAI", "1hrs 10mins", LocalDate.of(2024, 03, 25), "SG-102",
				LocalTime.of(5, 00, 00), "PUNE", new Fare("INR", 1300),
				new FlightInfo("SG-102", "Airbus", 200, airlineInfo), new Inventory(500));
		
		Flight flight3 = new Flight("CHENNAI", "1hrs 05mins", LocalDate.of(2024, 03, 25), "SG-103",
				LocalTime.of(2, 10, 00), "PUNE", new Fare("INR", 900),
				new FlightInfo("SG-103", "Airbus", 200, airlineInfo), new Inventory(500));
		
		Flight flight4 = new Flight("CHENNAI", "2hrs 20mins", LocalDate.of(2024, 03, 25), "SG-104",
				LocalTime.of(3, 15, 00), "PUNE", new Fare("INR", 2000),
				new FlightInfo("SG-104", "Airbus", 200, airlineInfo), new Inventory(500));
		
		Flight flight5 = new Flight("CHENNAI", "3hrs 30mins", LocalDate.of(2024, 03, 25), "SG-105",
				LocalTime.of(5, 40, 00), "PUNE", new Fare("INR", 2300),
				new FlightInfo("SG-105", "Airbus", 200, airlineInfo), new Inventory(500));
		
		Flight flight6 = new Flight("CHENNAI", "2hrs 50mins", LocalDate.of(2024, 03, 25), "SG-106",
				LocalTime.of(10, 45, 00), "PUNE", new Fare("INR", 3000),
				new FlightInfo("SG-106", "Airbus", 200, airlineInfo), new Inventory(500));

		flightService.saveAll(Arrays.asList(flight1, flight2, flight3, flight4, flight5, flight6)).forEach(System.out::println);
		
		AirlineInfo indigoAirlineInfo = airlineInfoService.findByNameOfAirline("Indigo");
		AirlineInfo airAsiaAirlineInfo = airlineInfoService.findByNameOfAirline("Air Asia");
		AirlineInfo vistaraAirlineInfo = airlineInfoService.findByNameOfAirline("Vistara");
		AirlineInfo airIndiaAirlineInfo = airlineInfoService.findByNameOfAirline("Air India");
		Flight indigoFlight= new Flight("PUNE", "1hrs 30mins", LocalDate.of(2024, 03, 25), "6E-193",
				LocalTime.of(01, 00, 00), "DELHI", new Fare("INR", 1000),
				new FlightInfo("6E-193", "Airbus", 200, indigoAirlineInfo), new Inventory(500));

		Flight airAsiaFlight = new Flight("PUNE", "1hrs 10mins", LocalDate.of(2024, 03, 25), "I5-193",
				LocalTime.of(5, 00, 00), "DELHI", new Fare("INR", 1300),
				new FlightInfo("I5-193", "Airbus", 200, airAsiaAirlineInfo), new Inventory(500));
		
		Flight vistaraFlight = new Flight("PUNE", "1hrs 05mins", LocalDate.of(2024, 03, 25), "UK-193",
				LocalTime.of(2, 10, 00), "DELHI", new Fare("INR", 900),
				new FlightInfo("UK-193", "Airbus", 200, vistaraAirlineInfo), new Inventory(500));
		
		Flight airIndiaFlight = new Flight("PUNE", "2hrs 20mins", LocalDate.of(2024, 03, 25), "AI-193",
				LocalTime.of(3, 15, 00), "DELHI", new Fare("INR", 2000),
				new FlightInfo("AI-193", "Airbus", 200, airIndiaAirlineInfo), new Inventory(500));

		flightService.saveAll(Arrays.asList(indigoFlight, airAsiaFlight, vistaraFlight, airIndiaFlight)).forEach(System.out::println);

	}
}
