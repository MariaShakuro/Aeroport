package com.aviation.core.format;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class XmlReader {
    public static TicketEntity readFromXml(String fileName) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(TicketEntity.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        return (TicketEntity) unmarshaller.unmarshal(new File(fileName));
    }
}
