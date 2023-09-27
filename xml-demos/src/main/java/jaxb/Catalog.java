package jaxb;

import jakarta.xml.bind.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Catalog {

    public static final String CATALOG_NS = "http://training360.com/schemas/catalog";

//    @XmlElementWrapper(name = "books")
    @XmlElement(name = "book")
    private List<Book> books;
}
