package Snacks.jsoupWebCrawling.Snacks;

import groovy.transform.ToString;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@ToString
@Builder
@Getter
@Table(name = "crownTBL")
@Entity
@NoArgsConstructor
public class CrownProducts {

    @Id
    @Column(name = "productName")
    private String productName;

    @Column(name = "productImage")
    private String productImage;

    @Column(name = "brand")
    private String brand;

    public CrownProducts(String productName, String productImage, String brand){
        this.productName = productName;
        this.productImage = productImage;
        this.brand = brand;
    }
}
