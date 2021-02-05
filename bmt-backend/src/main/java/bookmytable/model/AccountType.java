package bookmytable.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public abstract class AccountType{
   private String name;

public void setName(String value) {
    this.name = value;
}
public String getName() {
    return this.name;
}
private String password;

public void setPassword(String value) {
    this.password = value;
}
public String getPassword() {
    return this.password;
}

private long id;

public void setId(long value) {
    this.id = value;
}

@Id
public long getId() {
    return this.id;
}
private String email;

public void setEmail(String value) {
    this.email = value;
}
public String getEmail() {
    return this.email;
}
}
