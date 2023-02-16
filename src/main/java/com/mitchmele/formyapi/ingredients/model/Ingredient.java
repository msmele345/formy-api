package com.mitchmele.formyapi.ingredients.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ingredients")
public class Ingredient {

    @Id
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "amount")
    private double amount;

    @CreationTimestamp
    @Column(name = "CREATED_TS", updatable = false)
    private Date createdAt;

}
