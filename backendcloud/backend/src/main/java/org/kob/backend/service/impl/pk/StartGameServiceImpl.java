package org.kob.backend.service.impl.pk;

import org.kob.backend.service.pk.StartGameService;
import org.kob.backend.consumer.WebSocketServer;

public class StartGameServiceImpl implements StartGameService {
    @Override
    public String startGame(Integer aId, Integer bId) {
        System.out.println("start game: " + aId + " " + bId);
        WebSocketServer.startGame(aId, bId);
        return "start game success";

    }
}
