package saxparse;

import lombok.extern.slf4j.Slf4j;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayDeque;
import java.util.Deque;

@Slf4j
public class BookSaxHandler extends DefaultHandler {

    private Deque<String> stack = new ArrayDeque<>();

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        log.info("Start element: {}, {}, {}", uri, localName, qName);
        stack.push(qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        log.info("End: {}, {}, {}", uri, localName, qName);
        stack.pop();
        log.info("Stack: {}", stack);
    }
}
