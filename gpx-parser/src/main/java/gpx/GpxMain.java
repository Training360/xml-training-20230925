package gpx;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBElement;

public class GpxMain {


    public static void main(String[] args) throws Exception {
        var context = JAXBContext.newInstance(GpxType.class);
        var unmarshaller = context.createUnmarshaller();
        var gpx = (JAXBElement<GpxType>) unmarshaller
                .unmarshal(GpxMain.class.getResourceAsStream("/xml/2023_09_16_Helka_kor_Tihany.gpx"));
        var points = gpx.getValue().getTrk().get(0).getTrkseg().get(0).getTrkpt();
        for (var point: points) {
            System.out.println("%f, %f".formatted(point.getLat(), point.getLon()));
        }
    }
}
