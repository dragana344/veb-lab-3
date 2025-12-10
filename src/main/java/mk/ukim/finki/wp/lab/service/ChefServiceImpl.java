package mk.ukim.finki.wp.lab.service;

import mk.ukim.finki.wp.lab.model.Chef;
import mk.ukim.finki.wp.lab.repository.jpa.ChefRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChefServiceImpl implements ChefService{

    private final ChefRepository chefRepository;

    public ChefServiceImpl(ChefRepository chefRepository) {
        this.chefRepository = chefRepository;
    }


    @Override
    public List<Chef> listAll() {
        return chefRepository.findAll();
    }

    @Override
    public Chef findById(Long id) {
        return chefRepository.findById(id).orElse(null);
    }

//    @Override
//    public Chef addDishToChef(Long chefId, Long dishId) {
//        Chef chef = findById(chefId);
//        Dish dish = dishRepository.findById(dishId).orElse(null);
//
//        if (chef == null || dish == null) {
//            return null;
//        }
//
//        chef.setDishes(dish);
//        return chefRepository.save(chef);
//    }

}