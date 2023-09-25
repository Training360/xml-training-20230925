package domparse;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.w3c.dom.Element;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Source;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class BooksXmlDocument {

    @SneakyThrows
    public List<Book> getBooks(Reader reader) {
        var factory = DocumentBuilderFactory.newInstance();
        var builder = factory.newDocumentBuilder();
        var books = new ArrayList<Book>();

        var document =
                builder.parse(new InputSource(reader));
        var elements = document.getElementsByTagName("book");
        for (int i = 0; i < elements.getLength(); i++) {
            var element = (Element) elements.item(i);
            var isbn10 = element.getAttribute("isbn10");

            var title = element.getElementsByTagName("title").item(0).getTextContent();
            books.add(new Book(isbn10, title));

        }
        log.info("Books read from file: {}", books);
        return books;
    }
}
