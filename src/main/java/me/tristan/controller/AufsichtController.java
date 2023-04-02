package me.tristan.controller;

import me.tristan.*;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class AufsichtController {

    @MessageMapping("/aufsichtSetA")
    @SendTo("/anClient/updateOnA")
    public BahnDTO setCounterA(MessageDTO message) {
        try {
            YamlHandler.setA(Integer.parseInt(message.getMessage()));
        } catch (NumberFormatException e) {
            throw new RuntimeException(e);
        }

        return BahnState.getADTO(false);
    }

    @MessageMapping("/aufsichtSetB")
    @SendTo("/anClient/updateOnB")
    public BahnDTO setCounterB(MessageDTO message) {
        try {
            YamlHandler.setB(Integer.parseInt(message.getMessage()));
        } catch (NumberFormatException e) {
            throw new RuntimeException(e);
        }

        return BahnState.getBDTO(false);
    }

    @MessageMapping("/aufsichtSetC")
    @SendTo("/anClient/updateOnC")
    public BahnDTO setCounterC(MessageDTO message) {
        try {
            YamlHandler.setC(Integer.parseInt(message.getMessage()));
        } catch (NumberFormatException e) {
            throw new RuntimeException(e);
        }

        return BahnState.getCDTO(false);
    }

    @MessageMapping("/refreshAufsicht")
    @SendTo("/anClient/refreshAufsicht")
    public AufsichtDTO refresh(MessageDTO message) {
        return new AufsichtDTO(
                YamlHandler.getA(),
                YamlHandler.getB(),
                YamlHandler.getC()
        );
    }
}
