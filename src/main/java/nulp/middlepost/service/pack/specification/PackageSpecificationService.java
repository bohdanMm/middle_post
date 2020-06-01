package nulp.middlepost.service.pack.specification;

import nulp.middlepost.domain.Package;
import nulp.middlepost.domain.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Predicate;
import java.util.Objects;

@Service
public class PackageSpecificationService {

    public Specification<Package> createSpecification(PackageCriteria criteria) {
        Specification<Package> specification = Specification.where(null);
        if (Objects.nonNull(criteria)) {
            if (Objects.nonNull(criteria.getUserId())) {
                specification = specification.and(createUserSpecification(criteria));
            }
            if (Objects.nonNull(criteria.getPackageType())) {
                specification = specification.and(createPackageTypeSpecification(criteria));
            }
            if (Objects.nonNull(criteria.getPackaging())){
                specification = specification.and(createPackagingSpecification(criteria));
            }
        }

        return specification;
    }

    private Specification<Package> createUserSpecification(PackageCriteria criteria) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            Predicate owner = criteriaBuilder.equal(root.join(Package_.owner).get(Customer_.id), criteria.getUserId());
            Predicate receiver = criteriaBuilder.equal(
                    root.join(Package_.packageReceiving).join(PackageReceiving_.receiver).get(Customer_.id),
                    criteria.getUserId());
            return criteriaBuilder.or(owner, receiver);
        };
    }

    private Specification<Package> createPackageTypeSpecification(PackageCriteria criteria) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(
                root.join(Package_.packageType).get(PackageType_.id),
                criteria.getPackageType()
        );
    }

    private Specification<Package> createPackagingSpecification(PackageCriteria criteria){
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(
                root.join(Package_.packageReceiving).join(PackageReceiving_.packaging).get(Packaging_.id),
                criteria.getPackaging()
        );
    }
}
