package ru.parhomych.restfulwebservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "customer")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private int customer_id;

    @Column(name = "lastname", nullable = false)
    private String lastname;

    @Column(name = "district", nullable = false)
    private String district;

    @Column(name = "discount")
    private double discount;


    @Override
    public String toString() {
        return "Customer{" +
                "customer_id=" + customer_id +
                ", lastname='" + lastname + '\'' +
                ", district='" + district + '\'' +
                ", discount=" + discount +
                '}';
    }
}
