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
        return BahnState.getADTO();
    }

    @MessageMapping("/openB")
    @SendTo("/anClient/updateOnB")
    public BahnDTO openB(MessageDTO message) {
        BahnState.BAHN_B.setClosed(false);
        return BahnState.getBDTO();
    }

    @MessageMapping("/openC")
    @SendTo("/anClient/updateOnC")
    public BahnDTO openC(MessageDTO message) {
        BahnState.BAHN_C.setClosed(false);
        return BahnState.getCDTO();
    }

    @MessageMapping("/closeA")
    @SendTo("/anClient/updateOnA")
    public BahnDTO closeA(MessageDTO message) {
        BahnState.BAHN_A.setClosed(true);
        return BahnState.getADTO();
    }

    @MessageMapping("/closeB")
    @SendTo("/anClient/updateOnB")
    public BahnDTO closeB(MessageDTO message) {
        BahnState.BAHN_B.setClosed(true);
        return BahnState.getBDTO();
    }

    @MessageMapping("/closeC")
    @SendTo("/anClient/updateOnC")
    public BahnDTO closeC(MessageDTO message) {
        BahnState.BAHN_C.setClosed(true);
        return BahnState.getCDTO();
    }
}
