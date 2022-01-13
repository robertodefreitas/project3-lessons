package my.solution.project3.lesson4.model;

import javax.persistence.Entity;

@Entity
public class Shrub extends Plant {
    private int heightCm; //any reasonable unit of measurement is fine
    private int widthCm;

    /* getters and setters*/

    public int getHeightCm() {
        return heightCm;
    }

    public void setHeightCm(int heightCm) {
        this.heightCm = heightCm;
    }

    public int getWidthCm() {
        return widthCm;
    }

    public void setWidthCm(int widthCm) {
        this.widthCm = widthCm;
    }
}
