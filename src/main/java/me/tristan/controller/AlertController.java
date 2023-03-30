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
        BahnDTO result = new BahnDTO();
        result.setCounter(YamlHandler.getB());
        result.setAlert(BahnState.BAHN_A.isAlert());
        result.setClosed(BahnState.BAHN_A.isClosed());
        result.setShot("");
        return result;
    }

    @MessageMapping("/alertOnB")
    @SendTo("/anClient/updateOnB")
    public BahnDTO alertOnB(MessageDTO message) {
        BahnState.BAHN_B.setAlert(true);
        BahnDTO result = new BahnDTO();
        result.setCounter(YamlHandler.getB());
        result.setAlert(BahnState.BAHN_B.isAlert());
        result.setClosed(BahnState.BAHN_B.isClosed());
        result.setShot("");
        return result;
    }

    @MessageMapping("/alertOnC")
    @SendTo("/anClient/updateOnC")
    public BahnDTO alertOnC(MessageDTO message) {
        BahnState.BAHN_C.setAlert(true);
        BahnDTO result = new BahnDTO();
        result.setCounter(YamlHandler.getC());
        result.setAlert(BahnState.BAHN_C.isAlert());
        result.setClosed(BahnState.BAHN_C.isClosed());
        result.setShot("");
        return result;
    }

    @MessageMapping("/alertOffA")
    @SendTo("/anClient/updateOnA")
    public BahnDTO alertOffA(MessageDTO message) {
        BahnState.BAHN_A.setAlert(false);
        BahnDTO result = new BahnDTO();
        result.setCounter(YamlHandler.getB());
        result.setAlert(BahnState.BAHN_A.isAlert());
        result.setClosed(BahnState.BAHN_A.isClosed());
        result.setShot("");
        return result;
    }

    @MessageMapping("/alertOffB")
    @SendTo("/anClient/updateOnB")
    public BahnDTO alertOffB(MessageDTO message) {
        BahnState.BAHN_B.setAlert(false);
        BahnDTO result = new BahnDTO();
        result.setCounter(YamlHandler.getB());
        result.setAlert(BahnState.BAHN_B.isAlert());
        result.setClosed(BahnState.BAHN_B.isClosed());
        result.setShot("");
        return result;
    }

    @MessageMapping("/alertOffC")
    @SendTo("/anClient/updateOnC")
    public BahnDTO alertOffC(MessageDTO message) {
        BahnState.BAHN_C.setAlert(false);
        BahnDTO result = new BahnDTO();
        result.setCounter(YamlHandler.getC());
        result.setAlert(BahnState.BAHN_C.isAlert());
        result.setClosed(BahnState.BAHN_C.isClosed());
        result.setShot("");
        return result;
    }
}
