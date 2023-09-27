@XmlSchema(
        elementFormDefault= XmlNsForm.UNQUALIFIED,
        namespace="http://training360.com/schemas/catalog",
            xmlns={@XmlNs(prefix="x",
            namespaceURI=Catalog.CATALOG_NS)}
)

package jaxb;

import jakarta.xml.bind.annotation.XmlNs;
import jakarta.xml.bind.annotation.XmlNsForm;
import jakarta.xml.bind.annotation.XmlSchema;