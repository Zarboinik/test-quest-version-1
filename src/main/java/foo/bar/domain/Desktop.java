package foo.bar.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "desktop")
@PrimaryKeyJoinColumn(name = "desktop_id", referencedColumnName = "id")
public class Desktop extends Product {
    @Column(name = "form_factor")
    private String formFactor;

    public Desktop() {
    }

    public Desktop(String formFactor, Integer serialNumber,String manufacturer, Integer price, Integer amount) {
        this.formFactor = formFactor;
        this.serialNumber = serialNumber;
        this.manufacturer = manufacturer;
        this.price = price;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Desktop{" +
                " formFactor='" + formFactor + '\'' +
                " manufacturer'"+ getManufacturer()+ '\''+
                " price'" + getPrice()+ '\''+
                '}';
    }
}
