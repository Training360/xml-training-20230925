package domparse;

import lombok.SneakyThrows;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilderFactory;
import java.nio.file.Path;
import java.util.ArrayList;

public class CatalogMain {

    @SneakyThrows
    public static void main(String[] args) {
        var factory = DocumentBuilderFactory.newInstance();
        var builder = factory.newDocumentBuilder();
        var books = new ArrayList<Book>();

        try (var inputStream = CatalogMain.class.getResourceAsStream("/catalog.xml")) {
            var document =
                    builder.parse(inputStream);
            var elements = document.getElementsByTagName("book");
            for (int i = 0; i < elements.getLength(); i++) {
                var element = (Element) elements.item(i);
                var isbn10 = element.getAttribute("isbn10");

                var title = element.getElementsByTagName("title").item(0).getTextContent();
                books.add(new Book(isbn10, title));

            }
            System.out.println(books);
        }
    }
}
