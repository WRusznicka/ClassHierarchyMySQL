package com.solvd.laba;

import com.solvd.laba.dao.jdbc.AddressDAO;
import com.solvd.laba.dao.jdbc.BatteryDAO;
import com.solvd.laba.dao.jdbc.UserDAO;
import com.solvd.laba.model.Address;
import com.solvd.laba.model.Battery;
import com.solvd.laba.model.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    public static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        //3 examples of CRUD operations with new DAO:
        UserDAO userDAO = new UserDAO();
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
    }
}