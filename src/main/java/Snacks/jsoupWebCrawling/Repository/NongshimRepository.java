package Snacks.jsoupWebCrawling.Repository;

import Snacks.jsoupWebCrawling.Snacks.NoBrandProducts;
import Snacks.jsoupWebCrawling.Snacks.NongshimProducts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NongshimRepository extends JpaRepository<NongshimProducts, Long> {
}
