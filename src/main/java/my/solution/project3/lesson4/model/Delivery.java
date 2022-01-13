package my.solution.project3.lesson4.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.NamedQuery;
import org.hibernate.annotations.Nationalized;
import org.hibernate.annotations.Type;

@NamedQuery(name = "Delivery.findByName",
        query = "select d from Delivery d where d.name = :name")

@Entity
public class Delivery {
    // jdbc:postgresql
    // https://stackoverflow.com/questions/29771730/postgres-error-in-batch-insert-relation-hibernate-sequence-does-not-exist-po
    // org.postgresql.util.PSQLException: FEHLER: Relation »hibernate_sequence« existiert nicht
    // at my.solution.project3.lesson4.model.repository.DeliveryRepository.persist(DeliveryRepository.java:26) ~[classes/:na]
    //@GeneratedValue(strategy = GenerationType.IDENTITY) // because of postgresql
    @Id
    @GeneratedValue
    private Long id;

    @Nationalized
    private String name;
    @Column(name = "address_full", length = 500)
    private String address;
    private LocalDateTime deliveryTime; // includes both date and time - simpler than having two separate fields
    @Type(type = "yes_no")
    private Boolean completed;

/*
    // lesson2
    //make sure to specify mappedBy. Lazy fetch optional,
    //  but often a good idea for collection attributes
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "delivery")
    private List<Plant> plants;
*/
/*
    // lesson3 Part 06
    // added CascadeType.REMOVE to automatically clear any associated plants when removed
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "delivery", cascade = CascadeType.REMOVE)
    private List<Plant> plants;
*/

    // added CascadeType.REMOVE to automatically clear any associated plants when removed
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "delivery", cascade = CascadeType.ALL)
    private List<Plant> plants;

    /* getters and setters */

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDateTime getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(LocalDateTime deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    public List<Plant> getPlants() {
        return plants;
    }

    public void setPlants(List<Plant> plants) {
        this.plants = plants;
    }
}
