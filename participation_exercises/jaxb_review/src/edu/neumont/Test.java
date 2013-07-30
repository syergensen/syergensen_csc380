package edu.neumont;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import edu.neumont.jaxb.Author;
import edu.neumont.jaxb.Book;
import edu.neumont.jaxb.Library;

/**
 * User: seanyerg
 * Date: 7/22/13
 * Time: 11:26 AM
 */
public class Test {
	public static void main(String[] args) {
		new Test().run();
	}

	public void run() {
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance("edu.neumont.jaxb");
			Marshaller marshaller = jaxbContext.createMarshaller();
			Library library = new Library();
			Book book1 = new Book();
			Author author1 = new Author();
			author1.setName("Orson Scott Card");
			author1.setPhone(12345);
			book1.setAuthor(author1);
			book1.setTitle("Ender's Game");

			Book book2 = new Book();
			Author author2 = new Author();
			author2.setName("Mark Twain");
			author2.setPhone(6789);
			book2.setAuthor(author2);
			book2.setTitle("Huck Finn");

			library.getBook().add(book1);
			library.getBook().add(book2);

			File xml = new File("library.xml");
			marshaller.marshal(library, xml);

			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			library = (Library) unmarshaller.unmarshal(xml);
			System.out.println(library.getBook().get(0).getTitle());
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
