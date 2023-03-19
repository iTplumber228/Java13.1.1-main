package ru.netology.javaqamvn.services.domain;

public class NotFoundException extends RuntimeException {


    public NotFoundException(int id) {
        super("Element with id: " + id + " not found");
    }
}
