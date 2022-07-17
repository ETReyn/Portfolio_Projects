package com.techelevator.services;

import com.techelevator.model.Hotel;
import com.techelevator.model.Reservation;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import java.util.Random;

public class HotelService {

	private final String API_BASE_URL;
	private final String API_KEY;
	private final ConsoleService console = new ConsoleService();
	private RestTemplate restTemplate = new RestTemplate();

	public HotelService(String apiURL, String apiKey) {
		API_BASE_URL = apiURL;
		API_KEY = apiKey;
	}

	/**
	 * Create a new reservation in the hotel reservation system
	 *
	 * @param newReservation
	 * @return Reservation
	 */
	public Reservation addReservation(String newReservation) {

		Reservation newReservationObject = makeReservationObjectFromString(newReservation);

		if (newReservationObject == null) {
			return null;
		}

		// Create headers object for use in request
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		// Create Java request object by adding in Body and Headers
		HttpEntity<Reservation> request = new HttpEntity<Reservation>(newReservationObject, headers);

		// Send the request out
		Reservation completedReservation = null;
		try {
			completedReservation = restTemplate.postForObject(API_BASE_URL + "reservations?apikey=" + API_KEY, request, Reservation.class);
		} catch (RestClientResponseException e) {
			// Get back a 4xx or 5xx server response status code
			System.out.println(e.getRawStatusCode() + " error!");
			System.out.println(e.getStatusText());
		} catch (ResourceAccessException e) {
			// Couldn't find the server
			System.out.println("could not reach server! Please check the URL:");
			System.out.println(API_BASE_URL);
		}

		return completedReservation;

	}

	/**
	 * Updates an existing reservation by replacing the old one with a new
	 * reservation
	 *
	 * @param CSV
	 * @return
	 */
	public Reservation updateReservation(String CSV) {
		Reservation reservationToChange = makeReservationObjectFromString(CSV);

		if (reservationToChange == null) {
			return null;
		}

		HttpHeaders headersForPutRequest = new HttpHeaders();
		headersForPutRequest.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity<Reservation> putRequest = new HttpEntity<>(reservationToChange, headersForPutRequest);

		String url = API_BASE_URL + "reservations/" + reservationToChange.getId() + "?apikey=" + API_KEY;

		try {
			restTemplate.put(url, putRequest);
			return reservationToChange;
		} catch (RestClientResponseException e) {
			System.out.println("Update failed!");
			System.out.println(e.getRawStatusCode() + " -- " + e.getStatusText());
		} catch (ResourceAccessException e) {
			System.out.println("SYSTEM IS DOWN!");
		}

		return null;
	}

	/**
	 * Delete an existing reservation
	 *
	 * @param id
	 */
	public void deleteReservation(int id) {
		String url = API_BASE_URL + "reservations/" + id + "?apikey=" + API_KEY;

		try {
			restTemplate.delete(url);
		} catch (RestClientResponseException e) {
			System.out.println("Couldn't delete reservation " + id + "!");
			System.out.println(e.getRawStatusCode());
		} catch (ResourceAccessException e) {
			System.out.println("Couldn't reach the server!");
		}

	}

	/* DON'T MODIFY ANY METHODS BELOW */

	/**
	 * List all hotels in the system
	 *
	 * @return
	 */
	public Hotel[] listHotels() {
		Hotel[] hotels = null;
		try {
			hotels = restTemplate.getForObject(API_BASE_URL + "hotels?apikey=" + API_KEY, Hotel[].class);
		} catch (RestClientResponseException ex) {
			// handles exceptions thrown by rest template and contains status codes
			console.printError(ex.getRawStatusCode() + " : " + ex.getStatusText());
		} catch (ResourceAccessException ex) {
			// i/o error, ex: the server isn't running
			console.printError(ex.getMessage());
		}
		return hotels;
	}

	/**
	 * Get the details for a single hotel by id
	 *
	 * @param id
	 * @return Hotel
	 */
	public Hotel getHotel(int id) {
		Hotel hotel = null;
		try {
			hotel = restTemplate.getForObject(API_BASE_URL + "hotels/" + id + "?apikey=" + API_KEY, Hotel.class);
		} catch (RestClientResponseException ex) {
			console.printError(ex.getRawStatusCode() + " : " + ex.getStatusText());
		} catch (ResourceAccessException ex) {
			console.printError(ex.getMessage());
		}
		return hotel;
	}

	/**
	 * List all reservations in the hotel reservation system
	 *
	 * @return Reservation[]
	 */
	public Reservation[] listReservations() {
		Reservation[] reservations = null;
		try {
			reservations = restTemplate.getForObject(API_BASE_URL + "reservations?apikey=" + API_KEY, Reservation[].class);
		} catch (RestClientResponseException ex) {
			console.printError(ex.getRawStatusCode() + " : " + ex.getStatusText());
		} catch (ResourceAccessException ex) {
			console.printError(ex.getMessage());
		}
		return reservations;
	}

	/**
	 * List all reservations by hotel id.
	 *
	 * @param hotelId
	 * @return Reservation[]
	 */
	public Reservation[] listReservationsByHotel(int hotelId) {
		Reservation[] reservations = null;
		try {
			reservations = restTemplate.getForObject(API_BASE_URL + "/hotels/" + hotelId + "/reservations?apikey=" + API_KEY,
					Reservation[].class);
		} catch (RestClientResponseException ex) {
			console.printError(ex.getRawStatusCode() + " : " + ex.getStatusText());
		} catch (ResourceAccessException ex) {
			console.printError(ex.getMessage());
		}
		return reservations;
	}

	/**
	 * Find a single reservation by the reservationId
	 *
	 * @param reservationId
	 * @return Reservation
	 */
	public Reservation getReservation(int reservationId) {
		Reservation reservation = null;
		try {
			reservation = restTemplate.getForObject(API_BASE_URL + "reservations/" + reservationId + "?apikey=" + API_KEY, Reservation.class);
		} catch (RestClientResponseException ex) {
			console.printError(ex.getRawStatusCode() + " : " + ex.getStatusText());
		} catch (ResourceAccessException ex) {
			console.printError(ex.getMessage());
		}
		return reservation;
	}

	private Reservation makeReservationObjectFromString(String CSV) {
		String[] parsed = CSV.split(",");

		// invalid input (
		if (parsed.length < 5 || parsed.length > 6) {
			return null;
		}

		// Add method does not include an id and only has 5 strings
		if (parsed.length == 5) {
			// Create a string version of the id and place into an array to be concatenated
			String[] withId = new String[6];
			String[] idArray = new String[] { new Random().nextInt(1000) + "" };
			// place the id into the first position of the data array
			System.arraycopy(idArray, 0, withId, 0, 1);
			System.arraycopy(parsed, 0, withId, 1, 5);
			parsed = withId;
		}

		return new Reservation(Integer.parseInt(parsed[0].trim()), Integer.parseInt(parsed[1].trim()), parsed[2].trim(),
				parsed[3].trim(), parsed[4].trim(), Integer.parseInt(parsed[5].trim()));
	}

}
