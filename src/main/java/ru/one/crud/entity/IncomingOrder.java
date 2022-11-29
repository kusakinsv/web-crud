package ru.one.crud.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Data
@Entity
@NoArgsConstructor
public class IncomingOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private byte[] reciviedOrder;

    private String convertedOrder;






}
