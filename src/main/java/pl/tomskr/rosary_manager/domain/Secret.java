package pl.tomskr.rosary_manager.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Secret {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long secretId;

    private String name;
    private String color;
    public Secret() {
    }

    public Secret(String name) {
        this.name = name;
    }

    public Long getSecretId() {
        return secretId;
    }

    public void setSecretId(Long secretId) {
        this.secretId = secretId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
