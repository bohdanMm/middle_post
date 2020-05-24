package nulp.middlepost.repository;

import nulp.middlepost.domain.PackageReceiving;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PackageReceivingRepository extends JpaRepository<PackageReceiving, Long> {
}
