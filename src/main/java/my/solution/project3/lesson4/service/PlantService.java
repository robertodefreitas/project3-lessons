package my.solution.project3.lesson4.service;

import java.math.BigDecimal;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import my.solution.project3.lesson4.controller.DeliveryController;
import my.solution.project3.lesson4.model.Plant;
import my.solution.project3.lesson4.model.repository.PlantRepository;

@Service
public class PlantService {

    private static final Logger logger = LoggerFactory.getLogger(PlantService.class);

    @Autowired
    PlantRepository plantRepository;

    public Long save(Plant plant){
        return plantRepository.save(plant).getId();
    }

    public Boolean delivered(Long id){
        return plantRepository.deliveryCompleted(id);
        //return plantRepository.existsPlantByIdAndDeliveryCompleted(id, true);
    }

    public List<Plant> findPlantsBelowPrice(BigDecimal price) {
        return plantRepository.findByPriceLessThan(price);
    }

    public Plant getPlantByName(String name){
        return new Plant();
    }
}

