package Snacks.jsoupWebCrawling;


import Snacks.jsoupWebCrawling.Repository.CrownRepository;
import Snacks.jsoupWebCrawling.Repository.HaiTaiRepository;
import Snacks.jsoupWebCrawling.Repository.NoBrandRepository;
import Snacks.jsoupWebCrawling.Repository.NongshimRepository;
import Snacks.jsoupWebCrawling.Snacks.CrownProducts;
import Snacks.jsoupWebCrawling.Snacks.HaiTaiProducts;
import Snacks.jsoupWebCrawling.Snacks.NoBrandProducts;
import Snacks.jsoupWebCrawling.Snacks.NongshimProducts;
import lombok.RequiredArgsConstructor;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
public class ProductsService {

    private final CrownRepository crownRepository;
    private final NoBrandRepository noBrandRepository;

    private final HaiTaiRepository haiTaiRepository;
    private final NongshimRepository nongshimRepository;

    public List<HaiTaiProducts> getHaiTai() throws IOException {


        List<HaiTaiProducts> haiTaiProductsList = new ArrayList<>();

        for (int i = 65; i < 67; i++) {
            for (int j = 1; j < 5; j++) {
                String url = "http://www.ht.co.kr/product/list?searchProductCode=" + String.valueOf((char) i) + "00000&pageNum=" + String.valueOf(j);

                Document doc = Jsoup.connect(url).get();
                Elements contents = doc.select("dl");

                System.out.println(i + " : " + contents);
                for (Element content : contents) {
                    HaiTaiProducts products = HaiTaiProducts.builder()
                            .productName(content.select("dd").text())
                            .productImage(content.select("dt img").attr("abs:src"))
                            .brand("HAITAI")
                            .build();
                    haiTaiProductsList.add(products);
                    haiTaiRepository.save(products);
                    System.out.println(content.select("dd").text());
                }
            }
        }
            return haiTaiProductsList;
        }


    @PostConstruct
    public List<CrownProducts> getCrown() throws IOException {
        List<CrownProducts> productsList = new ArrayList<>();
        for (int i = 272; i < 303; i++) {
            String url = "http://www.crown.co.kr/product/pList.asp?catecode=1478063" + String.valueOf(i);

            if (i == 272 || i == 299 || i == 302) {

                Document doc = Jsoup.connect(url).get();
                Elements contents = doc.getElementsByClass("links");
                for (Element content : contents) {
                    CrownProducts products = CrownProducts.builder()
                            .productName(content.select("p").text())
                            .productImage(content.select("img").attr("abs:src"))
                            .brand("CROWN")
                            .build();
                    productsList.add(products);

                    crownRepository.save(products);
                }
            }
        }
        return productsList;
    }

  /*  public List<NoBrandProducts> getNoBrand() throws IOException{
        List<NoBrandProducts> nobrandProductsList = new ArrayList<>();
        String url = "https://emart24.co.kr/product/emart24.asp#S18";

        Document doc = Jsoup.connect(url).get();
        Elements contents = doc.getElementsByClass("sorting goodsSort");
        for(Element content : contents){
            NoBrandProducts products = NoBrandProducts.builder()
                    .productName(content.select("p").text())
                    .productImage(content.select("img").attr("abs:src"))
                    .build();

            System.out.println(doc.getElementsByClass("sorting goodsSort"));

            nobrandProductsList.add(products);
            for(Element javascript: contents) {
                System.out.println(javascript.select("a").attr("data-stype").getClass().getName());
                System.out.println(javascript.select("a").attr("data-stype"));
                if (javascript.attr("data-stype") == "S18") {
                    System.out.println(javascript.attr("data-stype"));
                }
            }

            *//*
            "#skipCont > div.section > div.sorting.goodsSort > a:nth-child(4)" //<a href="#" data-stype="S18">과자&amp;빵</a>
            "#skipCont > div.section > div.sorting.goodsSort > a:nth-child(4).atttr("data-stype")" // S18
             *//*

            noBrandRepository.save(products);

        }
        return nobrandProductsList;
         }
*/
/*

    public List<NoBrandProducts> getNoBrand() throws IOException {
        List<NoBrandProducts> nobrandProductsList = new ArrayList<>();
        String url = "https://emart.ssg.com/specialStore/nobrand/sub.ssg?ctgId=6000229703";


        Document doc = Jsoup.connect(url).get();
        Elements contents = doc.getElementsByClass("box");
        for (Element content : contents) {
            NoBrandProducts products = NoBrandProducts.builder()
                    .productName(content.select("p").text())
                    .productImage(content.select("img").attr("abs:src"))
                    .build();
            nobrandProductsList.add(products);

        //    System.out.println(contents.get(0));
           // System.out.println(doc.select("#container #stpye").attr("value","S18"));
            noBrandRepository.save(products);
        }
        return nobrandProductsList;
    }
*/

    /*
	$(".goodsSort a").each(function(){
				var _this = $(this);
				_this.click(function(){
					var stype = $(this).data("stype");
					$("input[name=stype]").val(stype);
					seAction();
					return false;
				});
			});
		});
*/

/*
    public List<NongshimProducts> getNongShim() throws IOException {
        List<NongshimProducts> nongshimProductlists = new ArrayList<>();
        String url = "http://brand.nongshim.com/all_product/index?catCd=B00";


        Document doc = Jsoup.connect(url).get();
        Elements contents = doc.select("#topContent > div.contents > div > div.contlist > ul > li");

        for (Element content : contents) {
            NongshimProducts products = NongshimProducts.builder()
                    .productName(content.select("span").text())
                    .productImage(content.select("img").attr("abs:src"))
                    .build();
            nongshimProductlists.add(products);

            nongshimRepository.save(products);
        }


        return nongshimProductlists;
    }
*/




}

