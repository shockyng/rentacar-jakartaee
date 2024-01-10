package me.shockyng.rentacarjakartaee.data.models;

import jakarta.persistence.*;

@Entity
@Table(name = "CARS")
public class Car {

    @Id
    @Column(name = "CAR_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "CAR_NAME")
    private String name;

    @Column(name = "CAR_YEAR")
    private Long year;

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

    public Long getYear() {
        return year;
    }

    public void setYear(Long year) {
        this.year = year;
    }

}
