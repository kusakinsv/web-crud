package ru.one.crud.entity;

import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
public class IncomingOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private byte[] reciviedOrder;

    private String convertedOrder;






}
