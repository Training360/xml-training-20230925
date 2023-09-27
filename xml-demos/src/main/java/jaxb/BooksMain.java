package jaxb;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;
import lombok.SneakyThrows;

import java.util.List;

public class BooksMain {

    @SneakyThrows
    public static void main(String[] args) {
        var catalog = new Catalog(
                List.of(
                        new Book("12341", "Hello World"),
                        new Book("12342", "Hello Java"),
                        new Book("12343", "Hello Python")
                )
        );

        var context = JAXBContext.newInstance(Catalog.class);
        var marshaller = context.createMarshaller();

        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        marshaller.marshal(catalog, System.out);
    }
}
