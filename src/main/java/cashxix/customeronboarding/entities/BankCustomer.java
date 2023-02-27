package cashxix.customeronboarding.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.util.UUID;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="bankCustomer")
public class BankCustomer {

    @Id
    @GeneratedValue
    private UUID id;

    private String phoneNumber;

    private String firstName;

    private String lastName;

    private String dateOfBirth;

    private String maritalStatus;



}
