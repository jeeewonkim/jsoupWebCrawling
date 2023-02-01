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
@Table(name = "nongshimTBL")
@Entity
@NoArgsConstructor
public class NongshimProducts {
    @Id
    @Column(name = "productName")
    private String productName;

    @Column(name = "productImage")
    private String productImage;


    public NongshimProducts(String productName, String productImage){
        this.productName = productName;
        this.productImage = productImage;
    }
}
