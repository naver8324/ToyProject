package com.dusk.toyproject.domain.player;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/player")
@RequiredArgsConstructor
public class PlayerController {
    private final PlayerService playerService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("players", playerService.getPlayers());
        return "player/index";
    }

    @PostMapping("/add")
    public String addPlayer(@RequestParam String nickname, @RequestParam int score) {
        playerService.addPlayer(nickname, score);
        return "redirect:/player/";
    }

    @GetMapping("/teams")
    public String teams(@RequestParam int teamCount, Model model) {
        List<List<PlayerDto>> teams = playerService.divideTeams(teamCount);

        model.addAttribute("teams", teams);

        return "player/teams";
    }
}
