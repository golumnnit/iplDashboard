package io.gaurav.ipldashboard.repository;

import org.springframework.data.repository.CrudRepository;

import io.gaurav.ipldashboard.model.Team;

public interface TeamRepository extends CrudRepository {

    Team findByName(String teamName);


}
