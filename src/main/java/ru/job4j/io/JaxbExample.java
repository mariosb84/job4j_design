package ru.job4j.io;

import java.io.IOException;
import java.io.StringReader;
import java.util.Arrays;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.*;
import java.io.StringWriter;

@XmlRootElement(name = "jaxbExample")
@XmlAccessorType(XmlAccessType.FIELD)

public class JaxbExample {
    @XmlAttribute
    private  boolean onSale;
    @XmlAttribute
    private  int price;
    @XmlAttribute
    private  String name;
    private  CarJaxb carJaxb;
    @XmlElementWrapper(name = "historys")
    @XmlElement(name = "history")
    private  String[] historys;

    public JaxbExample() {}

    public JaxbExample(boolean onSale, int price,String name, CarJaxb car, String... historys) {
        this.onSale = onSale;
        this.price = price;
        this.name = name;
        this.carJaxb = car;
        this.historys = historys;
    }

    @Override
    public String toString() {
        return "JaxbExample {"
                + "onSale=" + onSale
                + ", price=" + price
                + ", name=" + name
                + ", car=" + carJaxb
                + ", historys=" + Arrays.toString(historys)
                + '}';
    }
    public static void main(String[] args) throws JAXBException, IOException {
        final JaxbExample jaxbExample = new JaxbExample(true, 200000,
                "chevrolet",
                new CarJaxb(2001, "black"),
                "Not broken", "One owner");
        // Получаем контекст для доступа к АПИ
        JAXBContext context = JAXBContext.newInstance(JaxbExample.class);
        // Создаем сериализатор
        Marshaller marshaller = context.createMarshaller();
        // Указываем, что нам нужно форматирование
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        String xml = "";
        try (StringWriter writer = new StringWriter()) {
            // Сериализуем
            marshaller.marshal(jaxbExample, writer);
            xml = writer.getBuffer().toString();
            System.out.println("сериализуем:");
            System.out.println(xml);
        }
        // Для десериализации нам нужно создать десериализатор
        Unmarshaller unmarshaller = context.createUnmarshaller();
        try (StringReader reader = new StringReader(xml)) {
            // десериализуем
            JaxbExample result = (JaxbExample) unmarshaller.unmarshal(reader);
            System.out.println("десериализуем:");
            System.out.println(result);
        }
    }
}
