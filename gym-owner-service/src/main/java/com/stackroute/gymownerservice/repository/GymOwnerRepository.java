package com.stackroute.gymownerservice.repository;

import com.stackroute.gymownerservice.model.GymOwner;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GymOwnerRepository extends ElasticsearchRepository<GymOwner,Integer> {

    Iterable<GymOwner> findGymByCity(String name);

    GymOwner findGymByGymName(String name);

}
