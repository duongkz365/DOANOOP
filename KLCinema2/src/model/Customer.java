package model;

import java.time.LocalDate;

public class Customer extends User{

    private int level;
    private int experience;
    private double wallet;
    public Customer(){

    }
    public Customer(String id, String lastName, String firstName, String userName, String password, LocalDate birthDay, String email,int level,int experience,double wallet){
        super(id,lastName,firstName,userName,password,birthDay,email);
        this.level = level;
        this.experience = experience;
        this.wallet = wallet;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public double getWallet() {
        return wallet;
    }

    public void setWallet(double wallet) {
        this.wallet = wallet;
    }

    @Override
    public void display() {
        System.out.println("");
        System.out.println("Thông tin khác hàng: ");
        System.out.println("   Mã Khách Hàng: " + getId());
        System.out.println("       Họ và Tên: " + getLastName() + " " + getFirstName());
        System.out.println("   Tên Đăng Nhập: " + getUserName());
        System.out.println("        Mật Khẩu: " + getPassword());
        if(getEmail()==null){
            System.out.println("           Email: " + "Bạn chưa cập nhật email");
        }else {
            System.out.println("           Email: " + getEmail());
        }
        if(!getBirthDay().equals("")){
            System.out.println("       Ngày sinh: " + getBirthDay());
        }else {
            System.out.println("       Ngày Sinh: " + "Bạn chưa cập nhật ngày sinh");
        }
        System.out.println("          Cấp độ: " + getLevel());
        System.out.println("Điểm Kinh nghiệm: " + getExperience() + " EXP");
        System.out.println("         Ví Tiền: " + getWallet() + " VND");
        System.out.println();

    }
}
