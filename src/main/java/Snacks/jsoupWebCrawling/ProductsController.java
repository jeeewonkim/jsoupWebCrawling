package Snacks.jsoupWebCrawling;

import Snacks.jsoupWebCrawling.Snacks.CrownProducts;
import Snacks.jsoupWebCrawling.Snacks.HaiTaiProducts;
import Snacks.jsoupWebCrawling.Snacks.NoBrandProducts;
import Snacks.jsoupWebCrawling.Snacks.NongshimProducts;
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
       List<CrownProducts> productsList = productsService.getCrown();
        //List<NoBrandProducts> productsList2 = productsService.getNoBrand();
       // List<NongshimProducts> productsList3 = productsService.getNongShim();
       // List<HaiTaiProducts> productsList4 = productsService.getHaiTai();
        productsService.getHaiTai();

        //  model.addAttribute("products", productsList);


        return "products";
    }



}
