package controller;

import io.ConsoleIO;
import kayttoliittyma.UserInterface;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import tietokanta.BookDao;


@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        System.out.println("Hello Lukuvinkkikirjasto!");
        ApplicationContext context = SpringApplication.run(Main.class, args);
        JdbcTemplate jdbcTemplate = context.getBean("jdbcTemplate", JdbcTemplate.class);
        BookDao bookDao = new BookDao(jdbcTemplate);
        UserInterface kl = new UserInterface(bookDao, new ConsoleIO());
        kl.run();
    }

}
