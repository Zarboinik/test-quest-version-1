package foo.bar.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "laptop")
@PrimaryKeyJoinColumn(name = "laptop_id", referencedColumnName = "id")
public class Laptop  extends Product{
    @Column(name = "scale")
    private Integer scale;

    public Laptop() {
    }

    public Laptop(Integer scale, Integer serialNumber,String manufacturer, Integer price, Integer amount) {
        this.scale = scale;
        this.serialNumber = serialNumber;
        this.manufacturer = manufacturer;
        this.price = price;
        this.amount = amount;
    }
}
