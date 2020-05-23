package nulp.middlepost.repository;

import nulp.middlepost.domain.Customer;
import nulp.middlepost.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<Customer> findByEmailAndPassword(String email, String password);
}
