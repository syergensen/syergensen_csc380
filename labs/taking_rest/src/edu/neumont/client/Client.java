package edu.neumont.client;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringReader;
import java.net.Socket;
import java.util.List;
import java.util.Scanner;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import edu.neumont.jaxb.Catering;
import edu.neumont.jaxb.Menu;
import edu.neumont.jaxb.Restaurant;

/**
 * User: seanyerg
 * Date: 7/26/13
 * Time: 6:15 PM
 */
public class Client {
	public static void main(String[] args) {
		new Client().run();
	}

	private static final String HOST = "localhost";
	private static final int PORT = 8080;
	private static final String CONTEXT_PATH = "catering";

	private JAXBContext context;
	Socket socket;

	public Client() {
		try {
			this.context = JAXBContext.newInstance(Catering.class);
			this.socket = new Socket(HOST, PORT);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void run() {
		try {

			List<Restaurant> restaurants = getRestaurants();

			for(Restaurant restaurant : restaurants) {
				System.out.println(restaurant.getId() + ": " + restaurant.getName());
			}
			Scanner scanner = new Scanner(new BufferedInputStream(System.in));

			System.out.print("Which restaurant would you like to order from: ");
			if(scanner.hasNext()) {
				Integer restaurantId = Integer.parseInt(scanner.nextLine());
				// implies that restaurant data is in order starting with id=1 and onward
				List<Menu> menus = getMenus(restaurantId);
				for(Menu menu : menus) {
					System.out.println(menu.getType());
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	private String getXmlResponse(String method, String restURL) throws Exception {
		PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

		writer.write(method + " http://" + HOST + ":" + PORT + "/" + CONTEXT_PATH + "/" + restURL + " HTTP/1.1\n\n");

		BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		String line;
		String xml = null;
		while((line = reader.readLine()) != null) {
			// response body is found after the new line
			if("".equals(line)) {
				xml = reader.readLine();
			}
		}
		return xml;
	}

	private List<Restaurant> getRestaurants() throws Exception {
		Catering catering = (Catering) context.createUnmarshaller().unmarshal(new StringReader(getXmlResponse("GET", "restaurant")));
		return catering.getRestaurants();
	}

	private List<Menu> getMenus(Integer restaurantId) throws Exception {
		Restaurant restaurant = (Restaurant) context.createUnmarshaller().unmarshal(new StringReader(getXmlResponse("GET", "restaurant/" + restaurantId)));
		return restaurant.getMenus();
	}

}
