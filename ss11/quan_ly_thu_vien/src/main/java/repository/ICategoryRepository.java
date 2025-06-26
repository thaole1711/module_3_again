package repository;

import entity.Category;

import java.util.List;

public interface ICategoryRepository {
    List<Category> findAll();
}
