package ProjectCode.Entities;


import ProjectCode.models.ClientRequest;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;


@Entity
@Table(name = "client")
@Getter
@Setter
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String username;
    private String password;
    private String email;
    private Integer age;
    private String address;
    private String phoneNumber;
    private String accountBalance;
    @OneToMany
    private List<CreditCard> creditCards;

    public Client() {

    }

    public Client(String username) {
        setUsername(username);
    }

    public Client(ClientRequest clientRequest)
    {
        setAddress(clientRequest.getAddress());
        setAge(clientRequest.getAge());
        setEmail(clientRequest.getEmail());
        setPhoneNumber(clientRequest.getPhoneNumber());
        setPassword(clientRequest.getPassword());
        setId(clientRequest.getId());
        setUsername(clientRequest.getUsername());
        setAccountBalance(clientRequest.getAccountBalance());
    }
    /*
    public String getPassword() {

        return password;
    }

    public void setPassword(
            final String password) {
        this.password = password;
    }

    public Integer getAge() {

        return age;
    }

    public void setAge(final Integer age) {
        this.age = age;
    }

    public String getUsername() {

        return username;
    }

    public void setUsername(final String username) {

        this.username = username;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(String accountBalance) {
        this.accountBalance = accountBalance;
    }*/

    @Override public String toString() {
        return "User{" + "username='" + username + '\''
                + ", age=" + age + '}';
    }

}
