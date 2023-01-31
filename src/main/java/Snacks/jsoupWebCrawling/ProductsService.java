package Snacks.jsoupWebCrawling;


import Snacks.jsoupWebCrawling.Snacks.CrownProducts;
import lombok.RequiredArgsConstructor;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
@Service
@RequiredArgsConstructor
public class ProductsService {

    private final ProductsRepository productsRepository;

    @PostConstruct
    public List<CrownProducts> getCrownProducts() throws IOException {
        List<CrownProducts> productsList = new ArrayList<>();
        for (int i = 272; i < 303; i++) {
            String url = "http://www.crown.co.kr/product/pList.asp?catecode=1478063" + String.valueOf(i);

            if (i == 272 || i == 299 || i == 302) {

                Document doc = Jsoup.connect(url).get();
                Elements contents = doc.getElementsByClass("links");
                for (Element content : contents) {
                    CrownProducts products = CrownProducts.builder()
                            .productName(content.select("p").text())
                            .productImage(content.select("img").attr("abs:src"))//.attr("abs:src"))
                            .build();
                    productsList.add(products);

                    productsRepository.save(products);
                }
            }
        }
        return productsList;
    }
}
