package mk.ukim.finki.wp.lab.model;

import jakarta.persistence.*;

@Entity
public class Dish {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String dishId;
    private String name;
    private String cuisine;
    private int preparationTime;
    private int likes;
    private Double rejting;

    @ManyToOne
    private Chef chef;

    public Dish() {}

    public Dish(String dishId, String name, String cuisine, int preparationTime, Double rejting) {
        this.dishId = dishId;
        this.name = name;
        this.cuisine = cuisine;
        this.preparationTime = preparationTime;
        this.likes = 0;
        this.rejting = rejting;
    }

    public Long getId() { return id; }

    public String getDishId() { return dishId; }

    public String getName() { return name; }

    public String getCuisine() { return cuisine; }

    public int getPreparationTime() { return preparationTime; }

    public int getLikes() { return likes; }

    public Double getRejting() { return rejting; }

    public Chef getChef() { return chef; }

    public void setDishId(String dishId) { this.dishId = dishId; }

    public void setName(String name) { this.name = name; }

    public void setCuisine(String cuisine) { this.cuisine = cuisine; }

    public void setPreparationTime(int preparationTime) { this.preparationTime = preparationTime; }

    public void setLikes(int likes) { this.likes = likes; }

    public void setChef(Chef chef) { this.chef = chef; }

    public void setId(Long id) {
        this.id = id;
    }

    public void setRejting(Double rejting) { this.rejting = rejting; }
}
