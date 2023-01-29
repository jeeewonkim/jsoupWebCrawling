package Snacks.jsoupWebCrawling.lotteSnacks;

import groovy.transform.ToString;
import lombok.Builder;
import lombok.Getter;

@ToString
@Builder
@Getter
public class Products {

    private String productName;
    private String category;
    private String productBrand;
    private String productImage;

}
