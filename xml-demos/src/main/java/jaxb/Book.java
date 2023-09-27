package jaxb;

import com.sun.xml.txw2.annotation.XmlElement;
import jakarta.xml.bind.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
//@XmlType(propOrder = {"author", "title"})
public class Book {

    @XmlAttribute
    private String isbn10;

    private String title;

//    @XmlTransient
//    private String author;
}
