package edu.neumont.servlet;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import edu.neumont.jaxb.Catering;
import edu.neumont.jaxb.Item;
import edu.neumont.jaxb.MenuType;
import edu.neumont.jaxb.Restaurant;

/**
 * User: seanyerg
 * Date: 7/23/13
 * Time: 6:09 PM
 */
@WebServlet(name = "CateringServlet", urlPatterns = {"/restaurant/*", "/restaurant/*/menu/*", "/restaurant/*/menu/*/order/*"})
public class CateringServlet extends HttpServlet {

	private static Pattern RESTAURANT_PATTERN = Pattern.compile("(?<contextPath>.*)/restaurant/(?<restaurant>\\d+)");
	private static Pattern MENU_PATTERN = Pattern.compile("(?<contextPath>.*)/restaurant/(?<restaurant>\\d+)/menu/(?<menuType>breakfast|lunch|dinner)");
	private static Pattern ORDER_PATTERN = Pattern.compile("(?<contextPath>.*)/restaurant/(?<restaurant>\\d+)/menu/(?<menuType>breakfast|lunch|dinner)/order/(?<itemId>\\d+)");

	private JAXBContext context;
	private Catering cateringData;
	private Marshaller marshaller;
	private Unmarshaller unmarshaller;

	public CateringServlet() {
		try {
			this.context = JAXBContext.newInstance(Catering.class);
			this.cateringData = (Catering) context.createUnmarshaller().unmarshal(this.getClass().getClassLoader().getResource("catering.xml"));
			this.marshaller = context.createMarshaller();
			this.unmarshaller = context.createUnmarshaller();
		} catch(JAXBException e) {
			e.printStackTrace();
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Matcher matcher;
		Catering catering = new Catering();
		StringWriter writer = new StringWriter();
		try {
			if((matcher = MENU_PATTERN.matcher(request.getRequestURI())).find()) {
				Integer restaurantId = Integer.parseInt(matcher.group("restaurantId"));
				MenuType menuType = MenuType.fromValue(matcher.group("menuType"));
			}
			else if((matcher = RESTAURANT_PATTERN.matcher(request.getRequestURI())).find()) {
				Integer restaurantId = Integer.parseInt(matcher.group("restaurantId"));

			}
			else {
				List<Restaurant> restaurants = getRestaurants();
				catering.getRestaurants().addAll(restaurants);
				marshaller.marshal(catering, writer);
			}
			response.setContentType("text/xml");
			response.setContentLength(writer.toString().length());
			response.getWriter().write(writer.toString());
		} catch(JAXBException e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Matcher matcher;
		if((matcher = ORDER_PATTERN.matcher(request.getRequestURI())).find()) {
			Integer restaurantId = Integer.parseInt(matcher.group("restaurantId"));
			MenuType menuType = MenuType.fromValue(matcher.group("menuType"));
			Integer itemId = Integer.parseInt(matcher.group("itemId"));
		}
	}

	private List<Restaurant> getRestaurants() {
		List<Restaurant> restaurants = null;
		if(cateringData.getRestaurants() != null && cateringData.getRestaurants().size() > 0) {
			restaurants = new ArrayList<>();
			for(Restaurant restaurant : restaurants) {
				// create a copy without menus to send the minimal amount across the wire
				Restaurant newRestaurant = new Restaurant();
				newRestaurant.setId(restaurant.getId());
				newRestaurant.setName(restaurant.getName());
				restaurants.add(newRestaurant);
			}
		}
		return restaurants;
	}

	private List<Restaurant> getMenus(Integer restaurantId) {
		return null;
	}

	private List<Restaurant> getItems(Integer restaurantId, MenuType menuType) {
		return null;
	}

	private Item getItem(Integer restaurantId, MenuType menuType, Integer itemId) {
		return null;
	}
}
