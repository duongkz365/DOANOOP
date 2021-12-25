package model;

import java.time.LocalDate;

public class Employee extends User{
    private String position;
    private double salary;
    private LocalDate startDate;

    public Employee(){

    }
    public Employee(String id, String lastName,String firstName,String userName,String password,LocalDate birthDay,String email,String position,double salary,LocalDate startDate){
        super(id,lastName,firstName,userName,password,birthDay,email);
        this.position = position;
        this.startDate = startDate;
        this.salary = salary;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    @Override
    public void display() {
        System.out.println(" Mã Nhân Viên: " + getId());
        System.out.println("    Họ và tên: " + getLastName() + " " + getFirstName());
        System.out.println("Tên Đăng Nhập: " + getUserName());
        System.out.println("     Mật Khẩu: " + getPassword());
        System.out.println("        Email: " + getEmail());
        System.out.println("    Ngày sinh: " + getBirthDay());
        System.out.println(" Ngày vào làm: + " + getStartDate());
        if(getPosition() == null){
            System.out.println("      Chức vụ: " + "Người quản lý chưa cập nhật chức vụ cho bạn");
        }else {
            System.out.println("      Chức vụ: " + getPosition());
        }
        if(getSalary() == 0) {
            System.out.println("    Mức lương: " + "Người quản lý chưa cập nhật mức lương của bạn");
        }else {
            System.out.println("    Mức lương: " + getSalary()+" $");
        }
    }
}
