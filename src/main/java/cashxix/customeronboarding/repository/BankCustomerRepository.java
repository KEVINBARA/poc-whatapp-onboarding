package cashxix.customeronboarding.repository;


import cashxix.customeronboarding.entities.BankCustomer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Component
@Repository
public interface BankCustomerRepository extends JpaRepository<BankCustomer, UUID> {

    boolean existsByPhoneNumber(String phoneNumber);

}
