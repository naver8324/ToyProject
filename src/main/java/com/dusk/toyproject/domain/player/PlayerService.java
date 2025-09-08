package com.dusk.toyproject.domain.player;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlayerService {
    private final List<PlayerDto> players = new ArrayList<>();

    public void addPlayer(String nickname, int score) {
        players.add(PlayerDto.of(nickname, score));
    }

    public List<PlayerDto> getPlayers() {
        return players;
    }

    public List<List<PlayerDto>> divideTeams(int teamCount){
        List<List<PlayerDto>> teams = new ArrayList<>();

        for (int i = 0; i < teamCount; i++) {
            teams.add(new ArrayList<>());
        }

        for (int i = 0; i < players.size(); i++) {
            teams.get(i % teamCount).add(players.get(i));
        }

        return teams;
    }

}
