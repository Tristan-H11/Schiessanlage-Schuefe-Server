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

        BahnDTO result = new BahnDTO();
        result.setCounter(YamlHandler.getA());
        result.setAlert(BahnState.BAHN_A.isAlert());
        result.setClosed(BahnState.BAHN_A.isClosed());
        result.setShot("");
        return result;
    }

    @MessageMapping("/aufsichtSetB")
    @SendTo("/anClient/updateOnB")
    public BahnDTO setCounterB(MessageDTO message) {
        try {
            YamlHandler.setB(Integer.parseInt(message.getMessage()));
        } catch (NumberFormatException e) {
            throw new RuntimeException(e);
        }

        BahnDTO result = new BahnDTO();
        result.setCounter(YamlHandler.getB());
        result.setAlert(BahnState.BAHN_B.isAlert());
        result.setClosed(BahnState.BAHN_B.isClosed());
        result.setShot("");
        return result;
    }

    @MessageMapping("/aufsichtSetC")
    @SendTo("/anClient/updateOnC")
    public BahnDTO setCounterC(MessageDTO message) {
        try {
            YamlHandler.setC(Integer.parseInt(message.getMessage()));
        } catch (NumberFormatException e) {
            throw new RuntimeException(e);
        }

        BahnDTO result = new BahnDTO();
        result.setCounter(YamlHandler.getC());
        result.setAlert(BahnState.BAHN_C.isAlert());
        result.setClosed(BahnState.BAHN_C.isClosed());
        result.setShot("");
        return result;
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
