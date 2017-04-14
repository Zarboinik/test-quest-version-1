package foo.bar.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "hdd")
@PrimaryKeyJoinColumn(name= "hdd_id", referencedColumnName = "id")
public class Hdd  extends Product{
    @Column(name = "size")
    private Integer size;

    public Hdd() {
    }
    public Hdd(Integer size, Integer serialNumber,String manufacturer, Integer price, Integer amount) {
        this.size = size;
        this.serialNumber = serialNumber;
        this.manufacturer = manufacturer;
        this.price = price;
        this.amount = amount;
    }
}
