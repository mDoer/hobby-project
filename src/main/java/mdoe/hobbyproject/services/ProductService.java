package mdoe.hobbyproject.services;


import mdoe.hobbyproject.domain.Product;

public interface ProductService {
    Iterable<Product> listAllProducts();

    Product getProductById(Integer id);

    Product saveProduct(Product product);
}
