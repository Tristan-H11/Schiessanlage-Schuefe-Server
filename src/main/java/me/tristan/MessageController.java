package me.tristan;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class MessageController {

    @MessageMapping("/message")
    @SendTo("/anClient/message")
    public String addMessage(MessageDTO message) {
        YamlHandler.increaseA();
        return Integer.toString(YamlHandler.getA());
    }

    // ^^^^ Default, stehen lassen, bis fertig

    @MessageMapping("/shotOnA")
    @SendTo("/anClient/updateOnA")
    public Integer shotOnA(MessageDTO message) {
        YamlHandler.increaseA();
        return YamlHandler.getA();
    }

    @MessageMapping("/shotOnB")
    @SendTo("/anClient/updateOnB")
    public Integer shotOnB(MessageDTO message) {
        YamlHandler.increaseB();
        return YamlHandler.getB();
    }

    @MessageMapping("/shotOnC")
    @SendTo("/anClient/updateOnC")
    public Integer shotOnC(MessageDTO message) {
        YamlHandler.increaseC();
        return YamlHandler.getC();
    }


}

