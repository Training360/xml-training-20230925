package performance;

import lombok.extern.slf4j.Slf4j;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.function.Consumer;

@Slf4j
public class BookSaxHandler extends DefaultHandler {

    private String isbn10;

    private boolean acceptedBook;

    private Consumer<String> callback;

    public BookSaxHandler(Consumer<String> callback) {
        this.callback = callback;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.println(qName);
        if (qName.equals("book")) {
            isbn10 = attributes.getValue("isbn10");

        }
        if (qName.equals("title") ) {
            System.out.println(isbn10);
            acceptedBook = Character.isDigit(isbn10.charAt(0));
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        var title = new String(ch, start, length);
        if (acceptedBook) {
            callback.accept(title);
        }
    }

}
