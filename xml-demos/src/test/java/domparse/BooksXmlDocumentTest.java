package domparse;

import org.junit.jupiter.api.Test;

import java.io.StringReader;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;
import static org.junit.jupiter.api.Assertions.*;

class BooksXmlDocumentTest {

    @Test
    void getBooks() {
        var input = """
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

        var books = new BooksXmlDocument().getBooks(new StringReader(input));

        assertThat(books)
                .extracting(Book::getIsbn10, Book::getTitle)
                .containsExactly(
                        tuple("059610149X", "Java and XML"),
                        tuple("1590597060", "Pro XML Development with Java Technology"),
                        tuple("059610149X", "Java and XML: Solutions to Real-World Problems"));

    }
}