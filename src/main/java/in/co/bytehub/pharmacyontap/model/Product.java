package in.co.bytehub.pharmacyontap.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Product {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String salts;
    private String batch;
    private Double cp; // cost price
    private Double mp; // marked price
    private LocalDate expDate;
    private ProductType type;
    private Integer quantity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSalts() {
        return salts;
    }

    public void setSalts(String salts) {
        this.salts = salts;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public Double getCp() {
        return cp;
    }

    public void setCp(Double cp) {
        this.cp = cp;
    }

    public Double getMp() {
        return mp;
    }

    public void setMp(Double mp) {
        this.mp = mp;
    }

    public LocalDate getExpDate() {
        return expDate;
    }

    public void setExpDate(LocalDate expDate) {
        this.expDate = expDate;
    }

    public ProductType getType() {
        return type;
    }

    public void setType(ProductType type) {
        this.type = type;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Product setQuantity(Integer quantity) {
        this.quantity = quantity;
        return this;
    }
}
