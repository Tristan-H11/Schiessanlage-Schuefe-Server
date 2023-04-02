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

    @MessageMapping("/schreiberOpenA")
    @SendTo("/anClient/updateOnA")
    public BahnDTO schreiberOpenA(MessageDTO message) {
        if (BahnState.BAHN_A.isClosed() == 1)
            BahnState.BAHN_A.setClosed(0);
        return BahnState.getADTO(false);
    }

    @MessageMapping("/schreiberOpenB")
    @SendTo("/anClient/updateOnB")
    public BahnDTO schreiberOpenB(MessageDTO message) {
        if (BahnState.BAHN_B.isClosed() == 1)
            BahnState.BAHN_B.setClosed(0);
        return BahnState.getBDTO(false);
    }

    @MessageMapping("/schreiberOpenC")
    @SendTo("/anClient/updateOnC")
    public BahnDTO schreiberOpenC(MessageDTO message) {
        if (BahnState.BAHN_C.isClosed() == 1)
            BahnState.BAHN_C.setClosed(0);
        return BahnState.getCDTO(false);
    }

    @MessageMapping("/schreiberCloseA")
    @SendTo("/anClient/updateOnA")
    public BahnDTO schreiberCloseA(MessageDTO message) {
        if (BahnState.BAHN_A.isClosed() == 0)
            BahnState.BAHN_A.setClosed(1);
        return BahnState.getADTO(false);
    }

    @MessageMapping("/schreiberCloseB")
    @SendTo("/anClient/updateOnB")
    public BahnDTO schreiberCloseB(MessageDTO message) {
        if (BahnState.BAHN_B.isClosed() == 0)
            BahnState.BAHN_B.setClosed(1);
        return BahnState.getBDTO(false);
    }

    @MessageMapping("/schreiberCloseC")
    @SendTo("/anClient/updateOnC")
    public BahnDTO schreiberCloseC(MessageDTO message) {
        if (BahnState.BAHN_C.isClosed() == 0)
            BahnState.BAHN_C.setClosed(1);
        return BahnState.getCDTO(false);
    }

    @MessageMapping("/deckungOpenA")
    @SendTo("/anClient/updateOnA")
    public BahnDTO deckungOpenA(MessageDTO message) {
        if (BahnState.BAHN_A.isClosed() == 2)
            BahnState.BAHN_A.setClosed(0);
        return BahnState.getADTO(false);
    }

    @MessageMapping("/deckungOpenB")
    @SendTo("/anClient/updateOnB")
    public BahnDTO deckungOpenB(MessageDTO message) {
        if (BahnState.BAHN_B.isClosed() == 2)
            BahnState.BAHN_B.setClosed(0);
        return BahnState.getBDTO(false);
    }

    @MessageMapping("/deckungOpenC")
    @SendTo("/anClient/updateOnC")
    public BahnDTO deckungOpenC(MessageDTO message) {
        if (BahnState.BAHN_C.isClosed() == 2)
            BahnState.BAHN_C.setClosed(0);
        return BahnState.getCDTO(false);
    }

    @MessageMapping("/deckungCloseA")
    @SendTo("/anClient/updateOnA")
    public BahnDTO deckungCloseA(MessageDTO message) {
        if (BahnState.BAHN_A.isClosed() == 0)
            BahnState.BAHN_A.setClosed(2);
        return BahnState.getADTO(false);
    }

    @MessageMapping("/deckungCloseB")
    @SendTo("/anClient/updateOnB")
    public BahnDTO deckungCloseB(MessageDTO message) {
        if (BahnState.BAHN_B.isClosed() == 0)
            BahnState.BAHN_B.setClosed(2);
        return BahnState.getBDTO(false);
    }

    @MessageMapping("/deckungCloseC")
    @SendTo("/anClient/updateOnC")
    public BahnDTO deckungCloseC(MessageDTO message) {
        if (BahnState.BAHN_C.isClosed() == 0)
            BahnState.BAHN_C.setClosed(2);
        return BahnState.getCDTO(false);
    }
}
