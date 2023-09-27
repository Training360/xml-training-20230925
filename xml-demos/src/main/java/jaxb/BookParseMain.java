package jaxb;

import jakarta.xml.bind.JAXBContext;
import lombok.SneakyThrows;

import java.io.StringReader;

public class BookParseMain {

    @SneakyThrows
    public static void main(String[] args) {
        var xml = """
                <c:catalog xmlns:c="http://training360.com/schemas/catalog">
                    <c:book isbn10="12341">
                        <c:title>Hello World</c:title>
                    </c:book>
                    <c:book isbn10="12342">
                        <c:title>Hello Java</c:title>
                    </c:book>
                    <c:book isbn10="12343">
                        <c:title>Hello Python</c:title>
                    </c:book>
                </c:catalog>
                """;

        var context = JAXBContext.newInstance(Catalog.class);
        var unmarshaller= context.createUnmarshaller();
        var catalog = (Catalog) unmarshaller.unmarshal(new StringReader(xml));

        System.out.println(catalog);

    }
}
