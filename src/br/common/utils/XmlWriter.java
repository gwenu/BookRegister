package br.common.utils;

import br.common.models.Books;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

public class XmlWriter<T> {
    private T obj;

    public XmlWriter(T obj) {
        this.obj = obj;
    }

    public OutputStream writeToXml() {
        ByteArrayOutputStream os = new ByteArrayOutputStream();

        try {
            JAXBContext jaxbContext;
            jaxbContext = JAXBContext.newInstance(Books.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(obj, os);
        } catch (JAXBException e) {
            e.printStackTrace();
        }

        return os;
    }
}
