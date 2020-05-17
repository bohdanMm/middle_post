package nulp.middlepost;

import nulp.middlepost.domain.District;
import nulp.middlepost.domain.Locality;
import nulp.middlepost.domain.Region;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;

@Service
public class GovnoService
{
    @PersistenceUnit
    private EntityManagerFactory entityManagerFactory;

    @PostConstruct
    public void xyu()
    {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Region region = new Region();
        region.setName("reg1");
        District district = new District();
        district.setName("dist1");;
        district.setRegion(region);
        Locality locality = new Locality();
        locality.setDistrict(district);
        locality.setName("locality1");
        entityManager.getTransaction().begin();
        entityManager.persist(region);
        entityManager.getTransaction().commit();
        entityManager.getTransaction().begin();
        entityManager.persist(district);
        entityManager.getTransaction().commit();
        entityManager.getTransaction().begin();
        entityManager.persist(locality);
        entityManager.getTransaction().commit();
    }
}
