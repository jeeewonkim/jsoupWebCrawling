package Snacks.jsoupWebCrawling.lotteSnacks;


import com.sun.xml.bind.v2.TODO;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
@Service
public class ProductsService {

    private static String LOTTE_SNACK_URL = "https://www.lotteconf.co.kr/brand/product?searchType1=LC300";

    @PostConstruct
    public List<Products> getLotteProducts() throws IOException {
        List<Products> productsList = new ArrayList<>();
        Document doc = Jsoup.connect(LOTTE_SNACK_URL).get();

        Elements contents = doc.getElementsByClass("button-more");
        for (Element content : contents) {
            Products products = Products.builder()
                    .productName(content.select("span").text())
                    .productImage(content.select("img").attr("abs:src"))//.attr("abs:src"))
                    .productBrand("롯데")
                    .category("biscuit")
                    .build();
            productsList.add(products);

        }

        return productsList;
    }
}
