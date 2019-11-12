package net.dk.springEvent;

import net.dk.springEvent.event.UserEvent;
import net.dk.springEvent.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationListener;

@SpringBootApplication
public class SpringEventApplication implements CommandLineRunner {

    @Autowired
    private ApplicationEventPublisher publisher;

    public static void main(String[] args) {
        SpringApplication.run(SpringEventApplication.class, args);
    }

    /***
     *  CommandLineRunner implementation
     * @param args
     * @throws Exception
     */
    @Override
    public void run(String... args) throws Exception {
        User user = new User();
        user.setFirstName("Dursun");
        user.setLastName("Kurt");
        UserEvent event = new UserEvent(this, user);

        publisher.publishEvent(event);
    }
}
