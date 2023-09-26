package saxparse;

import lombok.SneakyThrows;

import javax.xml.parsers.SAXParserFactory;

public class BooksMain {

    @SneakyThrows
    public static void main(String[] args) {
        var factory = SAXParserFactory.newInstance();
        var saxParser = factory.newSAXParser();
        var handler = new BookSaxHandler();
        saxParser.parse(BooksMain.class.getResourceAsStream("/catalog.xml"), handler);
    }
}
