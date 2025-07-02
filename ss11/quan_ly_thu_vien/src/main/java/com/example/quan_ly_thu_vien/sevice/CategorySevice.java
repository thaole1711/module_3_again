package com.example.quan_ly_thu_vien.sevice;

import com.example.quan_ly_thu_vien.entity.Category;
import com.example.quan_ly_thu_vien.repository.CategoryRepository;
import com.example.quan_ly_thu_vien.repository.ICategoryRepository;

import java.util.List;

public class CategorySevice implements ICategorySevice {
    private ICategoryRepository iCategoryRepository= new CategoryRepository();
    @Override
    public List<Category> findAll() {
        return iCategoryRepository.findAll();
    }
}
