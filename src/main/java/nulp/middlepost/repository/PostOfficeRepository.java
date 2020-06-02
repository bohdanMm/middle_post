package nulp.middlepost.repository;

import nulp.middlepost.domain.PostOffice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostOfficeRepository extends JpaRepository<PostOffice, Long> {

    List<PostOffice> findByLocalityId(Long localityId);
}
