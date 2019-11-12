package net.dk.springEvent.controller;

import net.dk.springEvent.event.UserEvent;
import net.dk.springEvent.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {

    @Autowired
    private ApplicationEventPublisher publisher;


    /***
     *
     * @param firstName
     * @param lastName
     * @return user.toString()
     */
    @RequestMapping(value = "/{name}-{lastName}", method = RequestMethod.GET)
    @ResponseBody
    public String print(@PathVariable("name") String firstName, @PathVariable("lastName") String lastName) {
        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        UserEvent event = new UserEvent(this, user);
        publisher.publishEvent(event);
        return user.toString();
    }

}
