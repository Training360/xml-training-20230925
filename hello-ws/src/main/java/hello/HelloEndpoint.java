package hello;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;
import jakarta.jws.soap.SOAPBinding;

@WebService(serviceName = "HelloWebService", targetNamespace = HelloEndpoint.HELLO_NS)
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public class HelloEndpoint {

    public static final String HELLO_NS = "https://training360.com/hello";

    @WebMethod(operationName = "sayHello")
    @WebResult(name = "HelloResponse")
    public HelloResp hello(@WebParam(name = "HelloRequest") HelloRequest request) {
      return new HelloResp("Hello %s!".formatted(request.getName()));
    }
}
