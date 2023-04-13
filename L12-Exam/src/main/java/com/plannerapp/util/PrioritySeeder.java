package com.plannerapp.util;

import com.plannerapp.model.entity.PriorityEntity;
import com.plannerapp.model.entity.PriorityType;
import com.plannerapp.repo.PriorityRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class PrioritySeeder implements CommandLineRunner {

    private PriorityRepository priorityRepository;

    public PrioritySeeder(PriorityRepository priorityRepository) {
        this.priorityRepository = priorityRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (priorityRepository.count() == 0) {
            List<PriorityEntity> priorities = Arrays.stream(PriorityType.values())
                    .map(priorityType -> {
                        if (priorityType.toString().equals("URGENT")){
                            return new PriorityEntity(priorityType,
                                    "An urgent problem that blocks the system use until the issue is resolved.");
                        } else if (priorityType.toString().equals("IMPORTANT")) {
                            return new PriorityEntity(priorityType,
                                    "A core functionality that your product is explicitly supposed to perform is compromised.");
                        } else {
                            return new PriorityEntity(priorityType,
                                    "Should be fixed if time permits but can be postponed.");
                        }
                    })
                    .collect(Collectors.toList());

            this.priorityRepository.saveAll(priorities);
        }
    }
}
