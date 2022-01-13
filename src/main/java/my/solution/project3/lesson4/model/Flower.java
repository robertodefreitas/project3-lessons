package my.solution.project3.lesson4.model;

import javax.persistence.Entity;

@Entity
public class Flower extends Plant {
    private String color;

    /* getters and setters*/

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
