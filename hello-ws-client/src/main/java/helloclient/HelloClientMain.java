package helloclient;

import https.training360_com.hello.HelloRequest;
import https.training360_com.hello.HelloWebService;

public class HelloClientMain {

    public static void main(String[] args) {
        var service = new HelloWebService();
        var port = service.getHelloEndpointPort();
        var request = new HelloRequest();
        request.setName("Trainer");

        var response = port.sayHello(request);
        System.out.println(response.getMessage());
    }
}
