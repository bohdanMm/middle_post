package nulp.middlepost.repository;

import nulp.middlepost.domain.Locality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocalityRepository extends JpaRepository<Locality, Long> {

    List<Locality> findByDistrictId(Long districtId);
}
