package model;


import java.time.LocalDate;

public abstract class User {
    private String id;
    private String lastName;
    private String firstName;
    private String userName;
    private String password;
    private LocalDate birthDay;
    private String email;

    public User(){

    }
    public User(String id,String lastName,String firstName,String userName,String password,LocalDate birthDay,String email){
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.userName = userName;
        this.password = password;
        this.birthDay = birthDay;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public String getEmail() {
        return email;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public abstract void display();
}
