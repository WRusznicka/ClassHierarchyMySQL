package com.solvd.laba;

import com.solvd.laba.dao.jdbc.AddressDAO;
import com.solvd.laba.dao.jdbc.BatteryDAO;
import com.solvd.laba.dao.jdbc.UserDAO;
import com.solvd.laba.model.Battery;
import com.solvd.laba.model.jaxb.*;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Main {
    public static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        //3 examples of CRUD operations with new DAO:
        /* UserDAO userDAO = new UserDAO();
        LOGGER.info("\nGet list of users: ");
        userDAO.getEntities().stream().forEach(e->LOGGER.info(e.toString()));

        LOGGER.info("\nInserting new user: ");
        User u = new User("user000", "user", "user@gmail.com", "user123", "+480000034521", "user");
        userDAO.insert(u);
        userDAO.getEntities().stream().forEach(e->System.out.println(e.toString()));

        LOGGER.info("\nGet entity with id=1: ");
        LOGGER.info(userDAO.getEntityById(1));

        LOGGER.info("\nUpdating new user:");
        User u2 = new User("user", "user", "user@gmail.com", "user123", "+48000000001", "user");
        userDAO.update(1, u2);
        userDAO.getEntities().stream().forEach(e->System.out.println(e.toString()));

        AddressDAO addressDAO = new AddressDAO();
        LOGGER.info("\nGet list of addresses: ");
        addressDAO.getEntities().stream().forEach(e->LOGGER.info(e.toString()));

        LOGGER.info("\nInserting new address: ");
        Address a = new Address("Poland", "Mazowieckie", "Warsaw", "Unknown", "00-000", 1);
        addressDAO.insert(a);
        addressDAO.getEntities().stream().forEach(e->System.out.println(e.toString()));

        LOGGER.info("\nGet entity: ");
        LOGGER.info(addressDAO.getEntityById(1));

        LOGGER.info("\nUpdating new address:");
        Address a2 = new Address("Poland", "Mazowieckie", "Warsaw", "Street 1", "00-000", 1);
        addressDAO.update(1, a2);
        addressDAO.getEntities().stream().forEach(e->System.out.println(e.toString()));

        LOGGER.info("\nAfter deleting of new address:");
        addressDAO.delete(1);
        addressDAO.getEntities().stream().forEach(e->System.out.println(e.toString()));

        LOGGER.info("\nAfter deleting of new user:");
        userDAO.delete(7);
        userDAO.getEntities().stream().forEach(e->System.out.println(e.toString()));

        LOGGER.info("\nGet entity: ");
        BatteryDAO batteryDAO = new BatteryDAO();
        LOGGER.info(batteryDAO.getEntityById(2));
        LOGGER.info("\nGet list of batteries: ");
        batteryDAO.getEntities().stream().forEach(e->LOGGER.info(e.toString()));

        LOGGER.info("\nInserting new battery: ");
        Battery b = new Battery("Nickel-Cadmium",4, 10, "", 10, 10, 1);
        batteryDAO.insert(b);
        batteryDAO.getEntities().stream().forEach(e->System.out.println(e.toString()));

        LOGGER.info("\nUpdating new battery:");
        Battery b2 = new Battery("Nickel-Cadmium",4, 60, null, 10, 100000, 1);
        batteryDAO.update(8, b2);
        batteryDAO.getEntities().stream().forEach(e->System.out.println(e.toString()));

        LOGGER.info("\nAfter deleting of new battery:");
        batteryDAO.delete(8);
        batteryDAO.getEntities().stream().forEach(e->System.out.println(e.toString()));
        */
        //xml validator using xsd schema and parser
        /*
        String xmlFile = "src/main/resources/db_xml_file.xml";
        String xsdFile = "src/main/resources/xsd_schema.xsd";

        try{
            Validator validator = initValidator(xsdFile);
            try {
                validator.validate(new StreamSource(new File(xmlFile)));
                LOGGER.info("XML file is valid!");
                //Parsing using DOM when valid:
                parseUsingDOM(xmlFile);
            } catch (SAXException e) {
                LOGGER.error("Exception caught. XML file is not valid!");
            }
        } catch (Exception e) {
            LOGGER.error("Exception caught.");
        }*/

        //JAXB
        try {
            Database database = unmarshal();
            LOGGER.info(database.toString());
            marshal();
        } catch (Exception e){
            LOGGER.error("Error caught.");
        }
    }

    public static Database unmarshal() throws JAXBException, IOException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Database.class);
        return (Database) jaxbContext.createUnmarshaller()
                .unmarshal(new FileReader("src/main/resources/db_jaxb.xml"));
    }

    public static void marshal() throws JAXBException, IOException {
        User u1 = new User(3,"Aleksandra", "Nowak", "alnowak@gmail.com", "12345678", "+48564935276", "seller", new Position("seller", "4500 zł", "part-time"));
        User u2 = new User(4,"Aleksander", "Pitt", "alpitt@gmail.com", "12345690", "+48585935276", "seller", new Position("seller", "3000 zł", "part-time"));
        Users users = new Users();
        List<User> list = new ArrayList<>();
        list.add(u1);
        list.add(u2);
        users.setUsers(list);

        Address a1 = new Address(3, "Poland", "Mazovian", "Warsaw", "Zieleniecka 3", "03-562", 3);
        Address a2 = new Address(4, "Poland", "Mazovian", "Warsaw", "Obwodowa 35", "02-562", 4);
        Addresses addresses = new Addresses();
        List<Address> l1 = new ArrayList<>();
        l1.add(a1);
        l1.add(a2);
        addresses.setAddresses(l1);

        Service s1 = new Service(3, "Selling", "Selling product", 0, "5 min");
        Service s2 = new Service(4, "Display repair", "Display repairing", 100, "5 hours");
        Services services = new Services();
        List<Service> l2 = new ArrayList<>();
        l2.add(s1);
        l2.add(s2);
        services.setServices(l2);

        Invoice i1 = new Invoice(3, 100, Date.from(LocalDate.of(2025, 1, 12).atStartOfDay(ZoneId.systemDefault()).toInstant()), 3);
        Invoice i2 = new Invoice(4, 100, Date.from(LocalDate.of(2024, 6, 30).atStartOfDay(ZoneId.systemDefault()).toInstant()), 4);
        Invoices invoices = new Invoices();
        List<Invoice> l3 = new ArrayList<>();
        l3.add(i1);
        l3.add(i2);
        invoices.setInvoices(l3);

        ServiceOnInvoice si1 = new ServiceOnInvoice(3, 4, 3);
        ServiceOnInvoice si2 = new ServiceOnInvoice(4, 4, 4);
        ServicesOnInvoice soi = new ServicesOnInvoice();
        List<ServiceOnInvoice> l4 = new ArrayList<>();
        l4.add(si1);
        l4.add(si2);
        soi.setServices(l4);

        Database database = new Database(users, addresses, services, invoices, soi);

        JAXBContext context = JAXBContext.newInstance(Database.class);
        Marshaller mar= context.createMarshaller();
        mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        mar.marshal(database, new File("src/main/resources/marshalled_database.xml"));
    }

    public static Validator initValidator(String xsdPath) throws SAXException{
        SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Schema schema = factory.newSchema(new File(xsdPath));
        return schema.newValidator();
    }

    public static void parseUsingDOM(String xmlFile){
        try{
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document document = builder.parse(new File(xmlFile));
            document.getDocumentElement().normalize();

            Node parentNode = document.getElementsByTagName("database").item(0);
            NodeList nodeList = parentNode.getChildNodes();
            int i=0;
            for(i=0; i< nodeList.getLength(); i++){
                Node current = nodeList.item(i);
                if(current.getNodeType()==Node.ELEMENT_NODE){
                    printTableElements(current.getNodeName(), document);
                }

            }
        } catch (Exception e) {
            LOGGER.error("Exception while parsing caught.");
        }
    }

    public static void printTableElements(String tableName, Document document){
        LOGGER.info("Table " + tableName);
        NodeList nodeList = document.getElementsByTagName(tableName).item(0).getChildNodes();
        for(int i=0; i< nodeList.getLength(); i++){
            Node current = nodeList.item(i);
            if(current.getNodeType()==Node.ELEMENT_NODE){
                LOGGER.info("\t" + current.getNodeName() + " " + current.getAttributes().item(0));
                NodeList elements = current.getChildNodes();
                for(int j=0; j<elements.getLength();j++){
                    Node currentEl = elements.item(j);
                    if(currentEl.getNodeType()==Node.ELEMENT_NODE) {
                        LOGGER.info("\t\t" + currentEl.getNodeName() + ": " + currentEl.getTextContent());
                    }
                }
            }
        }
    }
}