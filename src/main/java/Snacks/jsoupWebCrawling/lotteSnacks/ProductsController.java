package Snacks.jsoupWebCrawling.lotteSnacks;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashSet;
import java.util.List;

@Controller
public class ProductsController {

    private final ProductsService productsService;

    public ProductsController(ProductsService productsService){
        this.productsService = productsService;
    }

    @GetMapping("/products.do")
    public String news(Model model) throws Exception{
        List<Products> productsList = productsService.getLotteProducts();
        model.addAttribute("products", productsList);

        return "products";
    }



}
