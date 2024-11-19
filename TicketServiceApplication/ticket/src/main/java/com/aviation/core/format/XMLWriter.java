package com.aviation.core.format;
import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class XmlWriter {
    public static void writeToXml(TicketEntity ticket, String fileName) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(TicketEntity.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        marshaller.marshal(ticket, new File(fileName));
    }
}

