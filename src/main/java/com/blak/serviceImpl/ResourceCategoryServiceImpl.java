package com.blak.serviceImpl;

import com.blak.csvgenerator.ResCat.ResCatCsvWriter;
import com.blak.dao.ResourceCategoryDAO;
import com.blak.model.ResourceCategory;
import com.blak.service.ResourceCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.nio.file.Path;
import java.util.List;

@Service
public class ResourceCategoryServiceImpl implements ResourceCategoryService {

    @Autowired
    private ResourceCategoryDAO resourceCategoryDAO;

    @Autowired
    private ResCatCsvWriter resCatCsvWriter;

    @Override
    @Transactional
    public void getCSVResCat(Path path) throws Exception {
        this.resCatCsvWriter.writeCsv(path);
    }

    @Override
    public List<ResourceCategory> getResourceCategories() {
        return resourceCategoryDAO.getResourceCategories();
    }


}
