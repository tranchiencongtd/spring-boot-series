package dev.congtc.spring.dependency_injection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DependencyInjectionController {

//    @Autowired
    private IProduct productService;

    @Autowired
    public DependencyInjectionController(ProductService productService) {
        this.productService = productService;
    }

//    @Autowired
//    public void setProductService(ProductService productService) {
//        this.productService = productService;
//    }

    @GetMapping("/get-product")
    public String getProduct() {
        return this.productService.FindProductById(3);
    }
}
