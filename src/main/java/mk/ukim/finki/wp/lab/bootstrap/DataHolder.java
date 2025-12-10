package mk.ukim.finki.wp.lab.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.ukim.finki.wp.lab.model.Chef;
import mk.ukim.finki.wp.lab.model.Dish;
import mk.ukim.finki.wp.lab.repository.jpa.ChefRepository;
import mk.ukim.finki.wp.lab.repository.jpa.DishRepository;
import org.springframework.stereotype.Component;

@Component
public class DataHolder {

    private final ChefRepository chefRepository;
    private final DishRepository dishRepository;

    public DataHolder(ChefRepository chefRepository, DishRepository dishRepository) {
        this.chefRepository = chefRepository;
        this.dishRepository = dishRepository;
    }

    @PostConstruct
    public void init() {

        // ако веќе има податоци → немој да прешиш
        if (chefRepository.count() > 0 || dishRepository.count() > 0) {
            return;
        }

        // КРЕИРАЊЕ ЈАДЕЊА
        Dish d1 = new Dish("d1", "Pasta Carbonara", "Italian", 20);
        Dish d2 = new Dish("d2", "Beef Wellington", "British", 45);
        Dish d3 = new Dish("d3", "Chicken Tikka Masala", "Indian", 35);
        Dish d4 = new Dish("d4", "Sushi Set", "Japanese", 25);
        Dish d5 = new Dish("d5", "Tacos al Pastor", "Mexican", 30);

        // КРЕИРАЊЕ ГОТВАЧИ
        Chef c1 = new Chef("Gordon", "Ramsay", "Michelin-starred chef and TV host.");
        Chef c2 = new Chef("Massimo", "Bottura", "Italian cuisine innovator.");
        Chef c3 = new Chef("Asma", "Khan", "Indian home-style cooking advocate.");
        Chef c4 = new Chef("Nobu", "Matsuhisa", "Peruvian-Japanese fusion pioneer.");
        Chef c5 = new Chef("Enrique", "Olvera", "Modern Mexican cuisine leader.");

        // ЗАПИШИ ГОТВАЧИ ПРВО (без јадења)
        chefRepository.save(c1);
        chefRepository.save(c2);
        chefRepository.save(c3);
        chefRepository.save(c4);
        chefRepository.save(c5);

        // ДОДЕЛИ ГОТВАЧИ НА ЈАДЕЊА
        d2.setChef(c1);
        d1.setChef(c2);
        d3.setChef(c3);
        d4.setChef(c4);
        d5.setChef(c5);

        // ЗАПИШИ ЈАДЕЊА
        dishRepository.save(d1);
        dishRepository.save(d2);
        dishRepository.save(d3);
        dishRepository.save(d4);
        dishRepository.save(d5);
    }
}
