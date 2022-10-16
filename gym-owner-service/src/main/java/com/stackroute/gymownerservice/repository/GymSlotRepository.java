package com.stackroute.gymownerservice.repository;

import com.stackroute.gymownerservice.model.GymSlot;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GymSlotRepository extends ElasticsearchRepository<GymSlot,Integer> {

    Iterable<GymSlot> findGymBySlotId(Integer sid);
}
