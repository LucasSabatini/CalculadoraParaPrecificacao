package br.com.sabatini.model.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.Objects;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_name", nullable = false, length = 40, unique = true)
    @NotBlank
    @Size(min = 4, max = 40)
    private String userName;

    @Column(name = "user_email", nullable = false, length = 40, unique = true)
    @NotBlank
    @Size(min = 4, max = 40)
    private String userEmail;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(name = "user_password", nullable = false, length = 40)
    @NotBlank
    @Size(min = 4, max = 40)
    private String userPassword;

    //private List<RawMaterial> rawMaterialList = new ArrayList<>();

    public User() {
    }

    public User(String userName, String userEmail, String userPassword) {
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
    }

    public Long getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id.equals(user.id)
                && userName.equals(user.userName)
                && userEmail.equals(user.userEmail)
                && userPassword.equals(user.userPassword);
                //&& Objects.equals(rawMaterialList, user.rawMaterialList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userName, userEmail, userPassword); //rawMaterialList);
    }
}
