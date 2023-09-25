package domparse;

import lombok.Getter;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.w3c.dom.Element;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilderFactory;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Getter
public class BooksXmlDocument {

    private List<Book> books;

    @SneakyThrows
    public void read(Reader reader) {
        var factory = DocumentBuilderFactory.newInstance();
        var builder = factory.newDocumentBuilder();
        books = new ArrayList<>();

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
    }

    public void setTitleWithIsbn(String isbn, String newTitle) {
        books
                .stream()
                .filter(book -> book.getIsbn10().equals(isbn))
                .findFirst()
                .orElseThrow()
                .setTitle(newTitle);
    }


}
