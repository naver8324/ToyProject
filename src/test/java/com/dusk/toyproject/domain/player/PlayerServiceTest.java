package com.dusk.toyproject.domain.player;

import org.junit.jupiter.api.Test;

import java.util.List;

public class PlayerServiceTest {

    @Test
    void divideTeamsTest(){
        PlayerService service = new PlayerService();
        service.addPlayer("A", 100);
        service.addPlayer("B", 10);
        service.addPlayer("C", 10);
        service.addPlayer("D", 10);
        service.addPlayer("E", 10);

        List<List<PlayerDto>> teams = service.divideTeams(2);

        for (int i = 0; i < teams.size(); i++) {
            System.out.println("Team " + (i + 1) + ": " + teams.get(i));
        }
    }
}
