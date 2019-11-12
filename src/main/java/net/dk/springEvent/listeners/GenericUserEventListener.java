package net.dk.springEvent.listeners;

import net.dk.springEvent.event.UserEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class GenericUserEventListener implements ApplicationListener<UserEvent> {

    /***
     * implements ApplicationListener
     * @param userEvent
     */
    @Override
    public void onApplicationEvent(UserEvent userEvent) {
        System.out.println(GenericUserEventListener.class.getName()+": "+userEvent.getUser().toString());

    }
}
