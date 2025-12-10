package mk.ukim.finki.wp.lab.model;


import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.*;

@Entity
public class Chef {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String bio;

    @OneToMany(mappedBy = "chef", cascade = CascadeType.ALL)
    private List<Dish> dishes = new ArrayList<>();

    public Chef() {}

    public Chef(String firstName, String lastName, String bio) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.bio = bio;
    }

    public Long getId() { return id; }

    public String getFirstName() { return firstName; }

    public String getLastName() { return lastName; }

    public String getBio() { return bio; }

    public List<Dish> getDishes() { return dishes; }

    public void setId(long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) { this.firstName = firstName; }

    public void setLastName(String lastName) { this.lastName = lastName; }

    public void setBio(String bio) { this.bio = bio; }

    public void addDish(Dish dish) {
        if (dish == null) return;
        dishes.add(dish);
        dish.setChef(this);
    }
}

