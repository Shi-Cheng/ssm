package dx.cn.service;

import dx.cn.domain.Product;
import org.springframework.stereotype.Service;

import java.util.List;


public interface IProductService {

    List<Product> findAll() throws Exception;
}
