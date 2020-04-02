package project.mpp.foodservice.rest;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import project.mpp.foodservice.domain.Food;

import project.mpp.foodservice.persistence.FoodRepository;
import project.mpp.foodservice.service.FoodService;

@RestController
public class GetFood {

    @Autowired
    private FoodService service;

    @GetMapping("/foods")
    public Food getFood(@RequestParam(value = "id") Long id) {
        Food foodById = service.findById((long)id);
        return new Food(foodById.getId(), foodById.getName(), foodById.getPrice(), foodById.getDescription(), foodById.getImageUrl(), foodById.getRestaurantId());
    }
}
