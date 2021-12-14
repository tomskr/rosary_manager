package pl.tomskr.rosary_manager.domain;



import javax.persistence.*;
import java.util.List;
import java.util.Map;

@Entity
public class RosarySecret {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long secretId;

    private String firstName;
    private String lastName;

    @OneToMany
    private List<Secret> secretCalendar;

    public RosarySecret() {
    }

    public RosarySecret(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public RosarySecret(String firstName, String lastName, List<Secret> secretCalendar) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.secretCalendar = secretCalendar;
    }



    public Long getSecretId() {
        return secretId;
    }

    public void setSecretId(Long secretId) {
        this.secretId = secretId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Secret> getSecretCalendar() {
        return secretCalendar;
    }

    public void setSecretCalendar(List<Secret> secretCalendar) {
        this.secretCalendar = secretCalendar;
    }
}
