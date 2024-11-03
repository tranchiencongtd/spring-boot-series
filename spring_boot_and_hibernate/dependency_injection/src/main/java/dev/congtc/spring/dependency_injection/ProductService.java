package dev.congtc.spring.dependency_injection;

import org.springframework.stereotype.Component;

@Component
public class ProductService implements IProduct{
    @Override
    public String FindProductById(int id) {
        return "Product" + id;
    }
}
