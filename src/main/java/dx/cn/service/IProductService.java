package dx.cn.service;

import dx.cn.domain.Product;
import org.springframework.stereotype.Service;

import java.util.List;


public interface IProductService {

    List<Product> findAll(int page,int size) throws Exception;

    void save(Product product);

    void deleteProductById(int id);

    Product findById(int id);
}
