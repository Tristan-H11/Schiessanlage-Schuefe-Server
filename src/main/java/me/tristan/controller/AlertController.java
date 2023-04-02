package me.tristan.controller;

import me.tristan.BahnDTO;
import me.tristan.BahnState;
import me.tristan.MessageDTO;
import me.tristan.YamlHandler;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class AlertController {

    @MessageMapping("/alertOnA")
    @SendTo("/anClient/updateOnA")
    public BahnDTO alertOnA(MessageDTO message) {
        BahnState.BAHN_A.setAlert(true);
        return BahnState.getADTO(false);
    }

    @MessageMapping("/alertOnB")
    @SendTo("/anClient/updateOnB")
    public BahnDTO alertOnB(MessageDTO message) {
        BahnState.BAHN_B.setAlert(true);
        return BahnState.getBDTO(false);
    }

    @MessageMapping("/alertOnC")
    @SendTo("/anClient/updateOnC")
    public BahnDTO alertOnC(MessageDTO message) {
        BahnState.BAHN_C.setAlert(true);
        return BahnState.getCDTO(false);
    }

    @MessageMapping("/alertOffA")
    @SendTo("/anClient/updateOnA")
    public BahnDTO alertOffA(MessageDTO message) {
        BahnState.BAHN_A.setAlert(false);
        return BahnState.getADTO(false);
    }

    @MessageMapping("/alertOffB")
    @SendTo("/anClient/updateOnB")
    public BahnDTO alertOffB(MessageDTO message) {
        BahnState.BAHN_B.setAlert(false);
        return BahnState.getBDTO(false);
    }

    @MessageMapping("/alertOffC")
    @SendTo("/anClient/updateOnC")
    public BahnDTO alertOffC(MessageDTO message) {
        BahnState.BAHN_C.setAlert(false);
        return BahnState.getCDTO(false);
    }
}
