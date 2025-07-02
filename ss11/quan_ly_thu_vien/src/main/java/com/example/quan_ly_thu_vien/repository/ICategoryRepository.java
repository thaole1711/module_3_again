package com.example.quan_ly_thu_vien.repository;

import com.example.quan_ly_thu_vien.entity.Category;

import java.util.List;

public interface ICategoryRepository {
    List<Category> findAll();
}
