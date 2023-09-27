@XmlSchema(elementFormDefault = XmlNsForm.QUALIFIED,
    namespace = HelloEndpoint.HELLO_NS,
    xmlns = @XmlNs(prefix = "h", namespaceURI = HelloEndpoint.HELLO_NS))
package hello;

import jakarta.xml.bind.annotation.XmlNs;
import jakarta.xml.bind.annotation.XmlNsForm;
import jakarta.xml.bind.annotation.XmlSchema;