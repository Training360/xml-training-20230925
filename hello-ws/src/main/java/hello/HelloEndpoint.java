package hello;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;
import jakarta.jws.soap.SOAPBinding;
import lombok.extern.slf4j.Slf4j;

@WebService(serviceName = "HelloWebService", targetNamespace = HelloEndpoint.HELLO_NS)
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@Slf4j
public class HelloEndpoint {

    public static final String HELLO_NS = "https://training360.com/hello";

    @WebMethod(operationName = "sayHello")
    @WebResult(name = "HelloResponse")
    public HelloResp hello(@WebParam(name = "HelloRequest") HelloRequest request) {
      log.debug("hello()");
      return new HelloResp("Hello %s!".formatted(request.getName()));
    }
}
