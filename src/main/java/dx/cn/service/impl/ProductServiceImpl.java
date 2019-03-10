package dx.cn.service.impl;

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
    public List<Product> findAll() throws Exception {
        System.out.println("====service====");
        return productDao.findAll();
    }
}
