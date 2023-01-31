package Snacks.jsoupWebCrawling;

import Snacks.jsoupWebCrawling.Snacks.CrownProducts;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ProductsController {

    private final ProductsService productsService;

    public ProductsController(ProductsService productsService){
        this.productsService = productsService;
    }

    @GetMapping("/products.do")
    public String news(Model model) throws Exception{
        List<CrownProducts> productsList = productsService.getCrownProducts();
        model.addAttribute("products", productsList);

        return "products";
    }



}
