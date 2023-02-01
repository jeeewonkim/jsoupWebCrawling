package Snacks.jsoupWebCrawling.Repository;

import Snacks.jsoupWebCrawling.Snacks.HaiTaiProducts;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface HaiTaiRepository extends JpaRepository<HaiTaiProducts, Long> {
}
