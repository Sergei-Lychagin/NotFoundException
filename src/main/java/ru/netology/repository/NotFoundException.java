package ru.netology.repository;


public class NotFoundException extends RuntimeException {


    public static String message = "Not found product with id: ";

    public NotFoundException(int id) {
        super(message + id);

    }

}
