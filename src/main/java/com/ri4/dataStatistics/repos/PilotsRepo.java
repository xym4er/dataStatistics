package com.ri4.dataStatistics.repos;


import com.ri4.dataStatistics.domain.Pilot;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PilotsRepo extends JpaRepository<Pilot, Long> {

    Pilot findByNameIs (String pilotName);
    List<Pilot> findAllByMainIdAndMain(Integer mainId, boolean main);

}
