package me.tristan.controller;

import me.tristan.BahnDTO;
import me.tristan.BahnState;
import me.tristan.MessageDTO;
import me.tristan.YamlHandler;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class ShotController {

    @MessageMapping("/shotOnA")
    @SendTo("/anClient/updateOnA")
    public BahnDTO shotOnA(MessageDTO message) {
        BahnDTO result = new BahnDTO();
        switch (message.getMessage()) {
            case "kleiner":
                YamlHandler.increaseA();
                result.setShot("kleiner");
                break;
            case "großer":
                result.setShot("großer");
                break;
            case "treffer":
                result.setShot("treffer");
                break;
            default:
                throw new RuntimeException("unknown shot-type on shotOnA");
        }
        result.setClosed(BahnState.BAHN_A.isClosed());
        result.setAlert(BahnState.BAHN_A.isAlert());
        result.setCounter(YamlHandler.getA());
        return result;
    }

    @MessageMapping("/shotOnB")
    @SendTo("/anClient/updateOnB")
    public BahnDTO shotOnB(MessageDTO message) {
        BahnDTO result = new BahnDTO();
        switch (message.getMessage()) {
            case "kleiner":
                YamlHandler.increaseB();
                result.setShot("kleiner");
                break;
            case "großer":
                result.setShot("großer");
                break;
            case "treffer":
                result.setShot("treffer");
                break;
            default:
                throw new RuntimeException("unknown shot-type on shotOnB");
        }
        result.setClosed(BahnState.BAHN_B.isClosed());
        result.setAlert(BahnState.BAHN_B.isAlert());
        result.setCounter(YamlHandler.getB());
        return result;
    }

    @MessageMapping("/shotOnC")
    @SendTo("/anClient/updateOnC")
    public BahnDTO shotOnC(MessageDTO message) {
        BahnDTO result = new BahnDTO();
        switch (message.getMessage()) {
            case "kleiner":
                YamlHandler.increaseC();
                result.setShot("kleiner");
                break;
            case "großer":
                result.setShot("großer");
                break;
            case "treffer":
                result.setShot("treffer");
                break;
            default:
                throw new RuntimeException("unknown shot-type on shotOnC");
        }
        result.setClosed(BahnState.BAHN_C.isClosed());
        result.setAlert(BahnState.BAHN_C.isAlert());
        result.setCounter(YamlHandler.getC());
        return result;
    }
}
