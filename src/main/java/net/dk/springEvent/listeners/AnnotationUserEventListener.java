package net.dk.springEvent.listeners;

import net.dk.springEvent.event.UserEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class AnnotationUserEventListener {

    /***
     * eventListener with Annotation
     * @param event
     * print event tostring method
     */
    @EventListener
    public void getUserProps(UserEvent event) {
        System.out.println( AnnotationUserEventListener.class.getName()+": "+event.getUser().toString());
    }
}
