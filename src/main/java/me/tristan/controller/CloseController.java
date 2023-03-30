package me.tristan.controller;

import me.tristan.BahnDTO;
import me.tristan.BahnState;
import me.tristan.MessageDTO;
import me.tristan.YamlHandler;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class CloseController {

    @MessageMapping("/openA")
    @SendTo("/anClient/updateOnA")
    public BahnDTO openA(MessageDTO message) {
        BahnState.BAHN_A.setClosed(false);
        BahnDTO result = new BahnDTO();
        result.setCounter(YamlHandler.getA());
        result.setAlert(BahnState.BAHN_A.isAlert());
        result.setClosed(BahnState.BAHN_A.isClosed());
        result.setShot("");
        return result;
    }

    @MessageMapping("/openB")
    @SendTo("/anClient/updateOnB")
    public BahnDTO openB(MessageDTO message) {
        BahnState.BAHN_B.setClosed(false);
        BahnDTO result = new BahnDTO();
        result.setCounter(YamlHandler.getB());
        result.setAlert(BahnState.BAHN_B.isAlert());
        result.setClosed(BahnState.BAHN_B.isClosed());
        result.setShot("");
        return result;
    }

    @MessageMapping("/openC")
    @SendTo("/anClient/updateOnC")
    public BahnDTO openC(MessageDTO message) {
        BahnState.BAHN_C.setClosed(false);
        BahnDTO result = new BahnDTO();
        result.setCounter(YamlHandler.getC());
        result.setAlert(BahnState.BAHN_C.isAlert());
        result.setClosed(BahnState.BAHN_C.isClosed());
        result.setShot("");
        return result;
    }

    @MessageMapping("/closeA")
    @SendTo("/anClient/updateOnA")
    public BahnDTO closeA(MessageDTO message) {
        BahnState.BAHN_A.setClosed(true);
        BahnDTO result = new BahnDTO();
        result.setCounter(YamlHandler.getA());
        result.setAlert(BahnState.BAHN_A.isAlert());
        result.setClosed(BahnState.BAHN_A.isClosed());
        result.setShot("");
        return result;
    }

    @MessageMapping("/closeB")
    @SendTo("/anClient/updateOnB")
    public BahnDTO closeB(MessageDTO message) {
        BahnState.BAHN_B.setClosed(true);
        BahnDTO result = new BahnDTO();
        result.setCounter(YamlHandler.getB());
        result.setAlert(BahnState.BAHN_B.isAlert());
        result.setClosed(BahnState.BAHN_B.isClosed());
        result.setShot("");
        return result;
    }

    @MessageMapping("/closeC")
    @SendTo("/anClient/updateOnC")
    public BahnDTO closeC(MessageDTO message) {
        BahnState.BAHN_C.setClosed(true);
        BahnDTO result = new BahnDTO();
        result.setCounter(YamlHandler.getC());
        result.setAlert(BahnState.BAHN_C.isAlert());
        result.setClosed(BahnState.BAHN_C.isClosed());
        result.setShot("");
        return result;
    }
}
