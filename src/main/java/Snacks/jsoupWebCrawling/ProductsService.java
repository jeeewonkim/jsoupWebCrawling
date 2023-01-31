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

    private static String CROWN_SNACK_URL = "http://www.crown.co.kr/product/pList.asp?catecode=1478063302";
    private static String CROWN_BISCUIT_URL = "http://www.crown.co.kr/product/pList.asp?catecode=1478063272";
    private final ProductsRepository productsRepository;
    @PostConstruct
    public List<CrownProducts> getCrownProducts() throws IOException {
        List<CrownProducts> productsList = new ArrayList<>();
        Document doc_snack = Jsoup.connect(CROWN_SNACK_URL).get();
        Elements contents_snack = doc_snack.getElementsByClass("links");
        for (Element content : contents_snack) {
            CrownProducts products = CrownProducts.builder()
                    .productName(content.select("p").text())
                    .productImage(content.select("img").attr("abs:src"))//.attr("abs:src"))
                    .build();
            productsList.add(products);

            productsRepository.save(products);
        }

        Document doc_biscuit = Jsoup.connect(CROWN_BISCUIT_URL).get();
        Elements contents_biscuit  = doc_biscuit.getElementsByClass("links");
        for (Element content : contents_biscuit) {
            CrownProducts products = CrownProducts.builder()
                    .productName(content.select("p").text())
                    .productImage(content.select("img").attr("abs:src"))//.attr("abs:src"))
                    .build();
            productsList.add(products);

            productsRepository.save(products);
        }

        return productsList;
    }


}
