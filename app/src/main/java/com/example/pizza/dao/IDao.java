package com.example.pizza.dao;

import java.util.List;

public interface IDao <T>{

    boolean create (T o);
    T findById(int id);
    List<T> findAll();
    boolean delete (T o);
    boolean update (T o);
}