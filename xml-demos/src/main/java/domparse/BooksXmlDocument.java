package domparse;

import lombok.Getter;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.w3c.dom.Element;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Getter
public class BooksXmlDocument {

    private List<Book> books;

    @SneakyThrows
    public void read(Reader reader) {
//        var factory = DocumentBuilderFactory.newInstance();
//        var builder = factory.newDocumentBuilder();

        var builder = DocumentBuilderFactory
                .newInstance()
                .newDocumentBuilder();

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

    @SneakyThrows
    public void write(Writer writer) {
        var factory = DocumentBuilderFactory.newInstance();
        var builder = factory.newDocumentBuilder();

        var document = builder.newDocument();
        var catalogElement = document.createElement("catalog");
        document.appendChild(catalogElement);

        for (var book: books) {
            var bookElement = document.createElement("book");
            catalogElement.appendChild(bookElement);

            bookElement.setAttribute("isbn10", book.getIsbn10());

            var titleElement = document.createElement("title");
            bookElement.appendChild(titleElement);
            titleElement.setTextContent(book.getTitle());
        }

        var transformerFactory = TransformerFactory.newInstance();
        var transformer = transformerFactory.newTransformer();
        var source = new DOMSource(document);

        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");

        transformer.transform(source, new StreamResult(writer));
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
