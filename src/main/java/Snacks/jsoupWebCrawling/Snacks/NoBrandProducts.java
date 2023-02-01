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
@Table(name = "nobrandTBL")
@Entity
@NoArgsConstructor
public class NoBrandProducts {
    @Id
    @Column(name = "productName")
    private String productName;

    @Column(name = "productImage")
    private String productImage;


    public NoBrandProducts(String productName, String productImage){
        this.productName = productName;
        this.productImage = productImage;
    }
}
