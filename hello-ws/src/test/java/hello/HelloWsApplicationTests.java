package hello;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class HelloWsApplicationTests {

	@Autowired
	WebTestClient webTestClient;

	@Test
	void contextLoads() throws Exception {
		webTestClient
				.get()
				.uri("/api/hello")
				.exchange()
				.expectStatus().isOk()
				.expectBody(HelloResource.class)
				.value(resource -> assertThat(resource.getMessage()).startsWith("Hello"));
	}

	@Test
	void soap() {
		String request = """
				<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:hel="https://training360.com/hello">
				                      <soapenv:Header/>
				                      <soapenv:Body>
				                         <hel:HelloRequest>
				                            <!--Optional:-->
				                            <hel:Name>John</hel:Name>
				                         </hel:HelloRequest>
				                      </soapenv:Body>
				                   </soapenv:Envelope>
				            """;

		String response = "<soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">\n" +
                          "                   <soap:Body>\n" +
                          "                      <h:HelloResponse xmlns:h=\"https://training360.com/hello\">\n" +
                          "                         <h:Message>Hello John!</h:Message>\n" +
                          "                      </h:HelloResponse>\n" +
                          "                   </soap:Body>\n" +
                          "                </soap:Envelope>\n";

		webTestClient
				.post()
				.uri("/services/hello")
				.contentType(MediaType.APPLICATION_XML)
				.header("SOAPAction", "")
				.bodyValue(request)
				.exchange()
				.expectStatus().isOk()
				.expectBody().xml(response);

	}

}
