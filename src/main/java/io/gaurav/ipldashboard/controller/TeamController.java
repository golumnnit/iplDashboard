package io.gaurav.ipldashboard.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import io.gaurav.ipldashboard.model.Team;


@RestController
public class TeamController {

    @GetMapping("/team/{teamName}")
    public Team getTeam(@PathVariable String teamName) {
        
    }
    
}
