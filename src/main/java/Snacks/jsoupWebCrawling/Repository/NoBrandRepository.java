package Snacks.jsoupWebCrawling.Repository;

import Snacks.jsoupWebCrawling.Snacks.NoBrandProducts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoBrandRepository extends JpaRepository<NoBrandProducts, Long> {
}
