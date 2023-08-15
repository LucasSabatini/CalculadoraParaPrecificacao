package br.com.sabatini.model.entity;

import br.com.sabatini.model.dto.RawMaterialRequestDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

@Table(name = "raw_material")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RawMaterial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    @JsonIgnore
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

    public RawMaterial(User user, String nameRawMaterial, BigDecimal pricePaid, BigDecimal weightUsedInRecipe, BigDecimal weightPurchased) {
        this.setUser(user);
        this.setNameRawMaterial(nameRawMaterial);
        this.setPricePaid(pricePaid);
        this.setWeightUsedInRecipe(weightUsedInRecipe);
        this.setWeightPurchased(weightPurchased);
    }

    public RawMaterial(RawMaterialRequestDTO rawMaterialRequestDTO) {
        this.nameRawMaterial = rawMaterialRequestDTO.nameRawMaterial();
        this.pricePaid = rawMaterialRequestDTO.pricePaid();
        this.weightUsedInRecipe = rawMaterialRequestDTO.weightUsedInRecipe();
        this.weightPurchased = rawMaterialRequestDTO.weightPurchased();
    }

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getNameRawMaterial() {
        return nameRawMaterial;
    }

    public void setNameRawMaterial(String nameRawMaterial) {
        this.nameRawMaterial = nameRawMaterial;
    }

    public BigDecimal getPricePaid() {
        return pricePaid;
    }

    public void setPricePaid(BigDecimal pricePaid) {
        this.pricePaid = pricePaid;
    }

    public BigDecimal getWeightUsedInRecipe() {
        return weightUsedInRecipe;
    }

    public void setWeightUsedInRecipe(BigDecimal weightUsedInRecipe) {
        this.weightUsedInRecipe = weightUsedInRecipe;
    }

    public BigDecimal getWeightPurchased() {
        return weightPurchased;
    }

    public void setWeightPurchased(BigDecimal weightPurchased) {
        this.weightPurchased = weightPurchased;
    }

    public BigDecimal getFinalCost() {
        return finalCost;
    }

    public void setFinalCost() {
        this.finalCost = this.getPricePaid().multiply(this.getWeightUsedInRecipe())
                .divide(this.getWeightPurchased(), 2, RoundingMode.UP);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RawMaterial that = (RawMaterial) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}