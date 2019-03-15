package dx.cn.service.impl;

import com.github.pagehelper.PageHelper;
import dx.cn.dao.IProductDao;
import dx.cn.domain.Product;
import dx.cn.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("productService")
@Transactional
public class ProductServiceImpl implements IProductService {

    @Autowired
    private IProductDao productDao;

    @Override
    public List<Product> findAll(int page,int size) throws Exception {
        System.out.println("====service====");
        //参数pageNum是页码值  参数pageSize代表是每页显示条数
        PageHelper.startPage(page,size);
        return productDao.findAll();
    }

    @Override
    public void save(Product product) {
        productDao.save(product);
    }

    @Override
    public void deleteProductById(int id) {
        productDao.deleteProductById(id);
    }

    @Override
    public Product findById(int id) {
        return productDao.findById(id);
    }
}
