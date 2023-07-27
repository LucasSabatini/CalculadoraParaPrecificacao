package br.com.sabatini.model.entity;

import br.com.sabatini.model.dto.RawMaterialResponseDTO;
import br.com.sabatini.model.dto.RawMaterialRequestDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Objects;

@Table(name = "raw_material")
@Entity
public class RawMaterial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false, updatable = false)
    private User user;

    @Column(name = "name", nullable = false, length = 40)
    @NotBlank
    @Size(min = 2, max = 40)
    private String nameRawMaterial; //Nome da matéria-prima

    @Column(name = "price_paid")
    private BigDecimal pricePaid; //Preço pago na matéria-prima

    @Column(name = "weight_used")
    private BigDecimal weightUsedInRecipe; //Peso da matéria-prima usada na formulação

    @Column(name = "weight_purchased")
    private BigDecimal weightPurchased; //Peso comprado de matéria-prima

    @Column(name = "final_cost")
    private BigDecimal finalCost; //Gasto final da matéria-prima na formulação

    public RawMaterial() {
    }

    public RawMaterial(RawMaterialRequestDTO rawMaterialRequestDTO) {
        this.nameRawMaterial = rawMaterialRequestDTO.nameRawMaterial();
        this.pricePaid = rawMaterialRequestDTO.pricePaid();
        this.weightUsedInRecipe = rawMaterialRequestDTO.weightUsedInRecipe();
        this.weightPurchased = rawMaterialRequestDTO.weightPurchased();
        this.user = rawMaterialRequestDTO.user();
    }

    public Long getId() {
        return id;
    }

    public String getNameRawMaterial() {
        return nameRawMaterial;
    }

    public void setNameRawMaterial(String nameRawMaterial) {
        this.nameRawMaterial = nameRawMaterial;
    }

    public BigDecimal getPricePaid(){
        return pricePaid;
    }

    public void setPricePaid(BigDecimal pricePaid){
        this.pricePaid = pricePaid;
    }

    public BigDecimal getWeightUsedInRecipe(){
        return weightUsedInRecipe;
    }

    public void setWeightUsedInRecipe(BigDecimal weightUsedInRecipe){
        this.weightUsedInRecipe = weightUsedInRecipe;
    }

    public BigDecimal getWeightPurchased(){
        return weightPurchased;
    }

    public void setWeightPurchased(BigDecimal weightPurchased){
        this.weightPurchased = weightPurchased;
    }

    public BigDecimal getFinalCost(){
        return finalCost;
    }

    public void setFinalCost() {
        this.finalCost = this.getPricePaid().multiply(this.getWeightUsedInRecipe())
                .divide(this.getWeightPurchased(), 2, RoundingMode.UP);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        return "\nRawMaterial{" +
                "id=" + id +
                ", nameRawMaterial='" + nameRawMaterial + '\'' +
                ", pricePaid=" + decimalFormat.format(pricePaid) +
                ", weightUsedInRecipe=" + decimalFormat.format(weightUsedInRecipe) +
                ", weightPurchased=" + decimalFormat.format(weightPurchased) +
                ", finalCost=" + decimalFormat.format(finalCost) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RawMaterial that = (RawMaterial) o;
        return Objects.equals(id, that.id)
                && Objects.equals(nameRawMaterial, that.nameRawMaterial)
                && Objects.equals(pricePaid, that.pricePaid)
                && Objects.equals(weightUsedInRecipe, that.weightUsedInRecipe)
                && Objects.equals(weightPurchased, that.weightPurchased)
                && Objects.equals(finalCost, that.finalCost)
                && Objects.equals(user, that.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nameRawMaterial, pricePaid, weightUsedInRecipe, weightPurchased, finalCost, user);
    }
}