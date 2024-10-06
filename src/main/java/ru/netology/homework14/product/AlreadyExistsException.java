package ru.netology.homework14.product;

public class AlreadyExistsException extends RuntimeException{
    public AlreadyExistsException(String s){
        super(s);
    }
}
