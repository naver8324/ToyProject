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

    public List<List<PlayerDto>> divideTeams(int teamCount) {
        List<List<PlayerDto>> teams = new ArrayList<>();
        for (int i = 0; i < teamCount; i++) {
            teams.add(new ArrayList<>());
        }

        players.sort((a, b) -> Integer.compare(b.getScore(), a.getScore()));

        int[] teamScores = new int[teamCount];

        for (PlayerDto player : players) {
            int targetTeam = 0;
            int minScore = Integer.MAX_VALUE;

            for (int i = 0; i < teamCount; i++) {
                int maxSize = players.size() / teamCount + (i < players.size() % teamCount ? 1 : 0);

                if (teams.get(i).size() >= maxSize) {
                    continue;
                }

                if (teamScores[i] < minScore) {
                    minScore = teamScores[i];
                    targetTeam = i;
                }
            }

            teams.get(targetTeam).add(player);
            teamScores[targetTeam] += player.getScore();
        }

        return teams;
    }


}
