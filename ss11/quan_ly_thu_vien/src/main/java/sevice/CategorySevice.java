package sevice;

import entity.Category;
import repository.CategoryRepository;
import repository.ICategoryRepository;

import java.util.List;

public class CategorySevice implements ICategorySevice {
    private ICategoryRepository iCategoryRepository= new CategoryRepository();
    @Override
    public List<Category> findAll() {
        return iCategoryRepository.findAll();
    }
}
