package foo.bar.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "display")
@Data
@PrimaryKeyJoinColumn(name = "display_id", referencedColumnName = "id")
public class Display extends Product{
    @Column(name = "diagonal")
    private Integer diagonal;

    public Display() {
    }
    public Display(Integer diagonal, Integer serialNumber,String manufacturer, Integer price, Integer amount) {
        this.diagonal = diagonal;
        this.serialNumber = serialNumber;
        this.manufacturer = manufacturer;
        this.price = price;
        this.amount = amount;
    }
}
