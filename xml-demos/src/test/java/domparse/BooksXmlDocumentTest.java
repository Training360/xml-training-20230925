package domparse;

import org.junit.jupiter.api.Test;

import java.io.StringReader;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;

class BooksXmlDocumentTest {

    String input = """
                <?xml version="1.0" encoding="UTF-8" standalone="no"?>
                <catalog>
                    <book isbn10="059610149X">
                        <title>Java and XML</title>
                    </book>
                    <book isbn10="1590597060">
                        <title>Pro XML Development with Java Technology</title>
                    </book>
                    <book isbn10="059610149X">
                        <title>Java and XML: Solutions to Real-World Problems</title>
                    </book>
                </catalog>
                """;


    @Test
    void getBooks() {
        var document = new BooksXmlDocument();
        document.read(new StringReader(input));

        assertThat(document.getBooks())
                .extracting(Book::getIsbn10, Book::getTitle)
                .containsExactly(
                        tuple("059610149X", "Java and XML"),
                        tuple("1590597060", "Pro XML Development with Java Technology"),
                        tuple("059610149X", "Java and XML: Solutions to Real-World Problems"));
    }

    @Test
    void readThanSetThenWrite() {
        var document = new BooksXmlDocument();
        document.read(new StringReader(input));

        document.setTitleWithIsbn("1590597060", "Pro XML Development");
        System.out.println(document.getBooks());


    }
}