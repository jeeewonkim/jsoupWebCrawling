package Snacks.jsoupWebCrawling;

import Snacks.jsoupWebCrawling.Snacks.CrownProducts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductsRepository extends JpaRepository<CrownProducts, Long> {


}
