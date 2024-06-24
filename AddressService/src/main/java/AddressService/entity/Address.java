package AddressService.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "address")
public class Address {

    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer addressId;

    @Column
    private Integer empId;

    @Column
    private String village;

    @Column
    private String city;

    @Column
    private String state;

    @Column
    private Integer pincode;
}
