package foo.bar.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "product")
@Inheritance(strategy=InheritanceType.JOINED)
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "serial_number")
    protected Integer serialNumber;
    protected String manufacturer;
    protected Integer price;
    protected  Integer amount;

    public Product() {
    }
}
