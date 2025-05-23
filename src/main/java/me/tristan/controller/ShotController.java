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
        switch (message.getMessage()) {
            case "kleiner":
                YamlHandler.increaseA();
                BahnState.BAHN_A.setLastShot("kleiner");
                break;
            case "grosser":
                BahnState.BAHN_A.setLastShot("grosser");
                break;
            case "treffer":
                BahnState.BAHN_A.setLastShot("treffer");
                break;
            default:
                throw new RuntimeException("unknown shot-type on shotOnA");
        }
        return BahnState.getADTO(true);
    }

    @MessageMapping("/shotOnB")
    @SendTo("/anClient/updateOnB")
    public BahnDTO shotOnB(MessageDTO message) {
        switch (message.getMessage()) {
            case "kleiner":
                YamlHandler.increaseB();
                BahnState.BAHN_B.setLastShot("kleiner");
                break;
            case "grosser":
                BahnState.BAHN_B.setLastShot("grosser");
                break;
            case "treffer":
                BahnState.BAHN_B.setLastShot("treffer");
                break;
            default:
                throw new RuntimeException("unknown shot-type on shotOnB");
        }
        return BahnState.getBDTO(true);
    }

    @MessageMapping("/shotOnC")
    @SendTo("/anClient/updateOnC")
    public BahnDTO shotOnC(MessageDTO message) {
        switch (message.getMessage()) {
            case "kleiner":
                YamlHandler.increaseC();
                BahnState.BAHN_C.setLastShot("kleiner");
                break;
            case "grosser":
                BahnState.BAHN_C.setLastShot("grosser");
                break;
            case "treffer":
                BahnState.BAHN_C.setLastShot("treffer");
                break;
            default:
                throw new RuntimeException("unknown shot-type on shotOnC");
        }
        return BahnState.getCDTO(true);
    }
}
