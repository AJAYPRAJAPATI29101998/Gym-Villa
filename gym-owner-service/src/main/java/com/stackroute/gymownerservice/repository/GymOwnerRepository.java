package com.stackroute.gymownerservice.repository;

import com.stackroute.gymownerservice.model.GymOwner;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GymOwnerRepository extends ElasticsearchRepository<GymOwner,Integer> {


    Iterable<GymOwner> findGymByCity(String name);
}
