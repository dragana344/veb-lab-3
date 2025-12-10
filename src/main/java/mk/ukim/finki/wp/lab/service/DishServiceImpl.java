package mk.ukim.finki.wp.lab.service;

import mk.ukim.finki.wp.lab.model.Chef;
import mk.ukim.finki.wp.lab.model.Dish;
import mk.ukim.finki.wp.lab.repository.jpa.ChefRepository;
import mk.ukim.finki.wp.lab.repository.jpa.DishRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DishServiceImpl implements DishService{

    private final DishRepository dishRepository;
    private final ChefRepository chefRepository;

    public DishServiceImpl(DishRepository dishRepository, ChefRepository chefRepository) {
        this.dishRepository = dishRepository;
        this.chefRepository = chefRepository;
    }

    @Override
    public List<Dish> listAll() {
        return dishRepository.findAll();
    }

//    @Override
//    public Dish findByDishId(String dishId) {
//        return dishRepository.findByDishId(dishId);
//    }

    @Override
    public Dish findById(Long id) {
        return dishRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Dish not found"));
    }

    @Override
    public Dish create(String dishId, String name, String cuisine, int preparationTime, Long chefId) {
        Dish dish = new Dish(dishId, name, cuisine, preparationTime);
        Chef chef = chefRepository.findById(chefId)
                .orElseThrow(() -> new RuntimeException("Chef not found"));
        dish.setChef(chef);

        return dishRepository.save(dish);
    }

//    @Override
//    public Dish update(Long id, String dishId, String name, String cuisine, int preparationTime) {
//        Dish dish = this.findById(id);
//
//        if(dish==null) return null;
//        dish.setDishId(dishId);
//        dish.setName(name);
//        dish.setCuisine(cuisine);
//        dish.setPreparationTime(preparationTime);
//
//        return dishRepository.save(dish);
//    }

    @Override
    public Dish update(Long id, String dishId, String name, String cuisine, int preparationTime, Long chefId) {
        Dish dish = dishRepository.findById(id)
                .orElse(null);
        if(dish==null) return null;
        dish.setDishId(dishId);
        dish.setName(name);
        dish.setCuisine(cuisine);
        dish.setPreparationTime(preparationTime);

        Chef chef = chefRepository.findById(chefId)
                .orElseThrow(() -> new RuntimeException("Chef not found"));
        dish.setChef(chef);

        return dishRepository.save(dish);
    }


    @Override
    public void delete(Long id) {
        dishRepository.deleteById(id);
    }

    @Override
    public void like(Long id) {
        Dish dish = this.findById(id);
        dish.setLikes(dish.getLikes()+1);
        dishRepository.save(dish);
    }

    @Override
    public List<Dish> listByChef(Long chefId) {
        return dishRepository.findAllByChef_Id(chefId);
    }

}
