package hello;

import jakarta.xml.ws.Endpoint;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebServiceConfig {

    @Bean
    public Endpoint helloEndpointImpl(Bus bus) {
        var endpoint = new EndpointImpl(bus, new HelloEndpoint());
        endpoint.publish("/hello");
        return endpoint;
    }
}
