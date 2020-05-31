package nulp.middlepost.repository;

import nulp.middlepost.domain.Package;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PackageRepository extends JpaRepository<Package, Long> {

    @Query("select p from Package p join p.owner o " +
            "join p.packageReceiving pr join pr.receiver r " +
            "where  o.id = :userId or r.id = :userId")
    List<Package> findByUser(Long userId);
}
