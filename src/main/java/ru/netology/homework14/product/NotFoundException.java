package ru.netology.homework14.product;

public class NotFoundException extends RuntimeException{
    public NotFoundException(String s) {
		super(s);
	}
}
