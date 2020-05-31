package nulp.middlepost.service.pack.specification;

import nulp.middlepost.domain.Package;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class PackageSpecificationService {

    public Specification<Package> createSpecification(PackageCriteria packageCriteria) {
        if (Objects.isNull(packageCriteria)) {
            return null;
        }
        Specification<Package> specification = null;
//        specification = specification.;
    }
}
