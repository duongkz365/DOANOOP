package view;

import controller.CinemaFile;
import controller.Management;
import model.*;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CinemaView {
    public Scanner scanner = new Scanner(System.in);
    private CinemaFile cinemaFile;
    private Management management;
    private List<Customer> customers;
    private List<Employee> employees;
    private List<Films> films;
    private List<FastFoods> fastFoods;
    private List<Drinks> drinks;
    private List<CinemaTickets> cinemaTickets;
    private List<ParkingTickets> parkingTickets;
    public CinemaView(){
        System.out.println("Chương trình quản lý rạp chiếu phim");
        this.cinemaFile = new CinemaFile();
        this.management = new Management();
        this.cinemaTickets = cinemaFile.readCinemaTicketFile();
        this.parkingTickets = cinemaFile.readParkingTicket();
        this.films = cinemaFile.readFilm();
        this.fastFoods = cinemaFile.readFastFood();
        this.drinks = cinemaFile.readDrinks();
        this.customers = cinemaFile.readCustomer();
        this.employees = cinemaFile.readEmployee();
        init();

    }

    // hàm khởi tạo giao diện
    public  void init(){
            Management m = new Management();
            String choose = null;
            boolean exit = false;
            while(true){
                showMenuMain();
                System.out.println("Vui lòng chọn: ");
                choose = scanner.next();
                switch (choose){
                    case "1":
                        quickViewCinemaTicket();
                        break;
                    case "2":
                        quickViewParkingTicket();
                        break;
                    case "3":
                        viewCurrentFilm();
                        break;
                    case "4":
                        viewFood();
                        break;
                    case "5":
                        viewDrink();
                        break;
                    case "6":
                        m.resgisterAccount();
                        this.customers = cinemaFile.readCustomer();  // đọc lại danh sách khách hàng khi đã đăng ký
                        break;
                    case "7":
                        customerLogin();
                        break;
                    case "8":
                        employeeLogin();
                        break;
                    case "9":

                        break;
                    case "0":
                        exit = true;
                        break;
                    default:
                        showMenuMain();
                        break;
                }
                if(exit){
                    break;
                }
            }
    }




    // hàm xem vé xem phim (case 1)
    public void quickViewCinemaTicket(){
        System.out.println("Vui lòng nhập mã vé xem phim:");
        boolean checkID = false;
        String IDCinemaTicket = scanner.next();
        for(int i = 0;i<cinemaTickets.size();i++){
            if(cinemaTickets.get(i).getID().equals(IDCinemaTicket)){
                cinemaTickets.get(i).display();
                checkID = true;
                break;
            }
        }
        if(!checkID){
            System.out.println("Không tìm thấy mã vừa nhập");
        }
        System.out.println("\nNhập phím bất kỳ để tiếp tục!");
        String next = scanner.next();
    } // done
    // hàm xem vé gửi xe (case 2)
    public void quickViewParkingTicket(){
        System.out.println("Vui lòng nhập mã giữ xe");
        boolean checkID = false;
        String IDParkingTicket  = scanner.next();
        for(int i = 0;i<parkingTickets.size();i++){
            if(parkingTickets.get(i).getIdTicket().equals(IDParkingTicket)){
                parkingTickets.get(i).display();
                checkID = true;
                break;
            }
        }
        if(!checkID){
            System.out.println("Không tìm thấy!");
        }
        System.out.println("\nNhập phím bất kỳ để tiếp tục!");
        String next = scanner.next();
    } //done
    // hàm xem các phim hiện có (case 3)
    public void viewCurrentFilm(){
        System.out.println("Các phim hiện có:");
        if(films.size() == 0){
            System.out.println("Hiện chưa có phim nào");
        } else {
            for(int i = 0;i<films.size();i++){
                System.out.println("Phim thứ "+(i+1));
                films.get(i).display();
            }
        }
        System.out.println("\nNhập phím bất kỳ để tiếp tục!");
        String next = scanner.next();
    }  //done
    // hàm xem thức ăn hiện có (case 4)
    public void viewFood(){
        System.out.println("xem thức ăn");
        for(int i = 0;i<fastFoods.size();i++){
            System.out.println("Món thứ " +(i+1));
            System.out.println("  Tên thức ăn nhanh: " + fastFoods.get(i).getFoodName());
            System.out.println("         Kích thước: " + fastFoods.get(i).getSize());
            System.out.println("           Giá tiền: " + fastFoods.get(i).getPrice());
        }
        System.out.println("\nNhập phím bất kỳ để tiếp tục!");
        String next = scanner.next();
    }
    // hàm xem nước uống hiện có (case 5)
    public void viewDrink(){
        System.out.println("Xem nước");
        for (int i = 0;i<drinks.size();i++){
            System.out.println("    Loại nước thứ: " + (i+1));
            System.out.println("         Tên nước: " + drinks.get(i).getFoodName());
            System.out.println("             Loại: " + drinks.get(i).getVolume());
            System.out.println("         Giá tiền: "+ drinks.get(i).getPrice());
        }
        System.out.println("\nNhập phím bất kỳ để tiếp tục!");
        String next = scanner.next();
    }  // done




        //    customer customer customer customer customer customer customer customer customer
    // khách hàng đăng ký ở file Managerment
    // khách hàng đăng nhập tài khoản (case 7)
    public void customerLogin(){
        Management m = new Management();
        String choose = null;
        boolean logout = false;
        boolean checkLogin = false;
        String IDCustomer = null;
        System.out.println("Khách hàng đăng nhập tài khoản");
        System.out.println("Nhập tên đăng nhập: ");
        String userName = scanner.next();
        System.out.println("Nhập mật khẩu: ");
        String password = scanner.next();

        for(int i = 0;i<customers.size();i++){
            if(customers.get(i).getUserName().equals(userName) && customers.get(i).getPassword().equals(password)){
                IDCustomer = customers.get(i).getId();
                checkLogin = true;
                break;
            }
        }
        if(checkLogin){
            boolean exit2 = false;
            while (true){
                showMenuMainCustomer();
                System.out.println("Vui lòng chọn: ");
                choose = scanner.next();
                switch (choose){
                    case "1":
                        m.showInfo(IDCustomer,"customer");
                        break;
                    case "2":
                        editMyCustomer(IDCustomer);
                        break;
                    case "3":
                        m.showMyCinemaTicket(IDCustomer);
                        break;
                    case "4":
                        m.buyFood(IDCustomer);
                        break;
                    case "5":
                        m.buyDrinks(IDCustomer);
                        break;
                    case "6":
                        m.buyMovieTicket(IDCustomer);
                        break;
                    case "0":
                        exit2 = true;
                        break;
                    default:
                        break;
                }
                if(exit2){
                    System.out.println("Đang đăng xuất....");
                    break;
                }
            }
        }else {
            System.out.println("\nTên đăng nhập hoặc mật khẩu không chính xác !");
        }
        System.out.println("\nNhập phím bất kỳ để tiếp tục!");
        String next = scanner.next();
    }
    // hàm dùng để chỉnh sửa thông tin cá nhân.
    public void editMyCustomer(String id){
        Management m  = new Management();
        System.out.println("Chỉnh sửa thông tin cá nhân");
        String chooses = null;
        boolean exit2 = false;
        while (true){
            showMenuEditCustomer();
            chooses = scanner.next();
            switch (chooses){
                case "1":
                    System.out.println("Chỉnh sửa thông tin");
                    m.editInfo(id,"customer");
                    break;
                case "2":
                    System.out.println("Đổi mật khẩu");
                    m.editPassword(id,"customer");
                    break;
                case "0":
                    exit2 = true;
                    break;
                default:
                    break;
            }
            if(exit2){
                break;
            }
        }
        System.out.println("\nNhập phím bất kỳ để tiếp tục!");
        String next = scanner.next();
    }




    //employee employee employee employee employee employee employee employee employee employee employee employee
    public void employeeLogin(){
        Management m = new Management();
        boolean checkLogin = false;
        String IDEmployee = null;
        String position = null;
        System.out.println("Nhân viên đăng nhập tài khoản");
        System.out.println("Nhập tên đăng nhập: ");
        String userName = scanner.next();
        System.out.println("Nhập mật khẩu: ");
        String password = scanner.next();

        for(int i = 0;i<employees.size();i++){
            if(employees.get(i).getUserName().equals(userName) && employees.get(i).getPassword().equals(password)){
                IDEmployee = employees.get(i).getId();
                position = employees.get(i).getPosition();
                checkLogin = true;
                break;
            }
        }
        // nếu đăng nhập thành công thì tiếp tục
        if(checkLogin){
            // nếu là quản trị viên
            if(position.equals("admin")){
                boolean exit = false;
                String choose = null;
                while(true){
                    showMenuAdmin();
                    System.out.println("Vui lòng chọn chức năng");
                    choose = scanner.next();
                    switch (choose){
                        case "1":
                            m.showInfo(IDEmployee,"employee");   // xuất ra thông tin cá nhân
                            break;
                        case "2":
                            editMyEmployee(IDEmployee);    // chỉnh sửa thông tin cá nhân
                            break;
                        case "3":
                            m.addEmployeeByAdmin();   // thêm nhân viên
                            this.employees = cinemaFile.readEmployee();  // đọc lại danh sách nhân viên sau khi thêm
                            break;
                        case "4":
                            m.editEmployeeByAdmin();    // chỉnh sửa nhân viên
                            this.employees = cinemaFile.readEmployee(); // đọc lại danh sách nhân viên sau khi sửa
                            break;
                        case "5":
                            m.deleteEmployeeByAdmin();    // xóa nhân viên
                            this.employees = cinemaFile.readEmployee();  // đọc lại danh sách nhân viên sau khi xóa
                            break;
                        case "6":
                            m.addCustomerByEmployee();    // thêm khách hàng
                            this.customers = cinemaFile.readCustomer();  // đọc lại danh sách khách hàng khi đã thêm mới
                            break;
                        case "7":
                            m.deleteCustomerByEmployee();  // xóa khách hàng
                            break;
                        case "8":
                            StatisticalCinemaTicket();  // thống kê vé xem phim
                            break;
                        case "9":
                            StatisticalFastFood();  // thống kê thức ăn nhanh
                            break;
                        case "10":
                            StatisticalDrinks();  // thống kê nước uống
                            break;
                        case "0":
                            exit = true;
                            break;
                        default:
                            break;
                    }
                    if(exit){
                        break;
                    }
                }

            }
            // nếu là nhân viên giữ xe
            if(position.equals("carkeeper")){
                boolean exit = false;
                String choose = null;
                while(true){
                    showMenuCarKeeper();
                    System.out.println("Vui lòng chọn chức năng");
                    choose = scanner.next();
                    switch (choose){
                        case "1":
                            m.showInfo(IDEmployee,"employee");  // xuất ra thông tin cá nhân
                            break;
                        case "2":
                            editMyEmployee(IDEmployee);   // chỉnh sửa thông tin cá nhân
                            break;
                        case "3":
                            m.sellParkingTicketByEmployee();  // bán vé giữ xe
                            break;
                        case "0":
                            exit = true;
                            break;
                        default:
                            break;
                    }
                    if(exit){
                        break;
                    }
                }
            }
            // nếu là nhân viên bán hàng
            if(position.equals("salesman")){
                boolean exit = false;
                String choose = null;
                while(true){
                    showMenuSalesman();
                    System.out.println("Vui lòng chọn chức năng");
                    choose = scanner.next();
                    switch (choose){
                        case "1":
                            m.showInfo(IDEmployee,"employee"); // xuất thông tin cá nhân nhân viên
                            break;
                        case "2":
                            editMyEmployee(IDEmployee);  // chỉnh sửa thông tin cá nhân
                            break;
                        case "3":
                            m.depositMoneyIntoAccount();  // nạp tiền vào tài khoản cho khách hàng
                            break;
                        case "4":
                            m.sellCinemaTicketByEmployee();   // bán vé xem phim
                            break;
                        case "5":
                            m.sellFoodByEmployee();  // bán thức ăn nhanh
                            break;
                        case "6":
                            m.sellDrinksByEmployee();  // bán nước ống
                            break;
                        case "7":
                            m.addCustomerByEmployee();  // thêm khách hàng mới
                            this.customers = cinemaFile.readCustomer();
                            break;
                        case "8":
                            m.deleteCustomerByEmployee();  // xóa khách hàng
                            break;
                        case "9":
                            m.addCinemaRoom();   // thêm phòng phim mới
                            break;
                        case "10":
                            m.addFilmByEmployee();
                            this.films = cinemaFile.readFilm();  // thêm phim mới (khung giờ, phòng chiếu, ngày chiếu, tên phim)
                            break;
                        case "11":
                            m.editFilmByEmployee();   // chỉnh sửa phim
                            break;
                        case "12":
                            m.deleteFilmByEmployee();  // xóa phim
                            break;
                        case "13":
                            m.addFastFoodByEmployee();
                            this.fastFoods = cinemaFile.readFastFood(); // thêm thưc ăn
                            break;
                        case "14":
                            m.editFastFoodByEmployee();  // chỉnh sửa thức ăn
                            break;
                        case "15":
                            m.deleteFastFoodByEmployee();  // xóa thức ăn
                            break;
                        case "16":
                            m.addDrinksByEmployee();
                            this.drinks = cinemaFile.readDrinks() ;// thêm nước uống
                            break;
                        case "17":
                            m.editDrinksByEmployee();   // chỉnh sửa nước uống
                            break;
                        case "18":
                            m.deleteDrinksByEmployee();  // xóa nước uống
                            break;
                        case "0":
                            exit = true;
                            break;
                        default:
                            break;
                    }

                    if(exit){
                        break;
                    }
                }
            }
        }else {
            System.out.println("\nTên đăng nhập hoặc mật khẩu không chính xác !");
        }
        System.out.println("\nNhập phím bất kỳ để tiếp tục!");
        String next = scanner.next();
    }    // nhân viên đăng nhập
    public void editMyEmployee(String id){
        Management m  = new Management();
        System.out.println("Chỉnh sửa thông tin cá nhân");
        String chooses = null;
        boolean exit2 = false;
        while (true){
            showMenuEditCustomer();
            chooses = scanner.next();
            switch (chooses){
                case "1":
                    System.out.println("Chỉnh sửa thông tin");
                    m.editInfo(id,"employee");
                    break;
                case "2":
                    System.out.println("Đổi mật khẩu");
                    m.editPassword(id,"employee");
                    break;
                case "0":
                    exit2 = true;
                    break;
                default:
                    break;
            }
            if(exit2){
                break;
            }
        }
        System.out.println("\nNhập phím bất kỳ để tiếp tục!");
        String next = scanner.next();
    } // chỉnh sửa thông tin nhân viên
    //statistical
    public void StatisticalCinemaTicket(){
        StatisticalCinemaTicket s = new StatisticalCinemaTicket();
        String choose = null;
        boolean exit =false;
        while (true){
            showMenuStatistical();
            System.out.println("Vui lòng chọn: ");
            choose = scanner.next();
            switch (choose){
                case "1":
                    s.StatisticalDay();
                    break;
                case "2":
                    s.StatisticalMonth();
                    break;
                case "3":
                    s.StatisticalYear();
                    break;
                case "0":
                    exit = true;
                    break;
                default:
                    break;
            }
            if(exit){
                break;
            }
        }
    }
    public void StatisticalDrinks(){
        StatisticalDrinks s = new StatisticalDrinks();
        String choose = null;
        boolean exit =false;
        while (true){
            showMenuStatistical();
            System.out.println("Vui lòng chọn: ");
            choose = scanner.next();
            switch (choose){
                case "1":
                    s.StatisticalDay();
                    break;
                case "2":
                    s.StatisticalMonth();
                    break;
                case "3":
                    s.StatisticalYear();
                    break;
                case "0":
                    exit = true;
                    break;
                default:
                    break;
            }
            if(exit){
                break;
            }
        }
    }
    public void StatisticalFastFood(){
        StatisticalFastFood s = new StatisticalFastFood();
        String choose = null;
        boolean exit =false;
        while (true){
            showMenuStatistical();
            System.out.println("Vui lòng chọn: ");
            choose = scanner.next();
            switch (choose){
                case "1":
                    s.StatisticalDay();
                    break;
                case "2":
                    s.StatisticalMonth();
                    break;
                case "3":
                    s.StatisticalYear();
                    break;
                case "0":
                    exit = true;
                    break;
                default:
                    break;
            }
            if(exit){
                break;
            }
        }
    }
    // phần các hàm menu chức năng cho chương trình quản lý rạp chiếu phim
    // menu ở màn hình chính
    public void showMenuMain(){
        System.out.println("Chào mừng đến với KL Cinema");
        System.out.println("Vui lòng chọn: ");
        System.out.println("1. Xem nhanh thông tin vé xem phim");
        System.out.println("2. Xem nhanh thông tin vé giữ xe");
        System.out.println("3. Xem các phim hiện có");
        System.out.println("4. Xem thức ăn hiện có");
        System.out.println("5. Xem nước hiện có");
        System.out.println("6. Khách hàng đăng ký tài khoản");
        System.out.println("7. Khách hàng đăng nhập");
        System.out.println("8. Nhân viên đăng nhập");
        System.out.println("0. Thoát chương trình");
        System.out.println("-------KL Cinema------");
    }
    //menu nhân viên bán hàng
    public void showMenuSalesman(){
        System.out.println("*********************************************************************");
        System.out.println(" 1.  Xem thông tin cá nhân");
        System.out.println(" 2.  Chỉnh sửa thông tin cá nhân");
        System.out.println("*********************************************************************");
        System.out.println(" 3.  Nạp tiền vào tài khoản cho khách hàng");
        System.out.println(" 4.  Bán vé xem phim     5. Bán thức ăn nhanh    6. Bán nước uống");
        System.out.println("*********************************************************************");
        System.out.println(" 7.  Thêm khách hàng     8. Xóa Khách Hàng");
        System.out.println("*********************************************************************");
        System.out.println(" 9.  Thêm phòng phim mới");
        System.out.println("10. Thêm phim mới (cần có phòng chiếu trước khi thêm");
        System.out.println("11. Chỉnh sửa phim      12. Xóa Phim");
        System.out.println("*********************************************************************");
        System.out.println("13. Thêm thức ăn   14. Chỉnh sửa thức ăn    15. Xóa thức ăn");
        System.out.println("16. Thêm nước mới   17. Chỉnh sửa nước      18. Xóa nước");
        System.out.println(" 0. Đăng xuất");
    }
    // menu quản trị viên
    public void showMenuAdmin(){
        System.out.println("1. Xem thông tin cá nhân");
        System.out.println("2. Chỉnh sửa thông tin cá nhân");
        System.out.println("3. Thêm nhân viên mới");
        System.out.println("4. Chỉnh sửa nhân viên");
        System.out.println("5. Xóa nhân viên");
        System.out.println("6. Thêm khách hàng");
        System.out.println("7. Xóa Khách hàng");
        System.out.println("8. Thống kê vé xem phim");
        System.out.println("9. Thống kê thức ăn nhanh");
        System.out.println("10. Thống kê nước uống");
        System.out.println("0. Đăng xuất");
    }
    // menu nhân viên giữ xe
    public void showMenuCarKeeper(){
        System.out.println("1. Xem thông tin cá nhân");
        System.out.println("2. Chỉnh sửa thông tin cá nhân");
        System.out.println("3. Bán vé xe");
        System.out.println("0. Đăng xuất");
    }
    // menu chức năng thống kê
    public void showMenuStatistical(){
        System.out.println("1. Thống kê theo ngày");
        System.out.println("2. Thống kê theo tháng");
        System.out.println("3. Thống kê theo năm");
        System.out.println("0. Quay lại");
    }
    // menu chức năng của khách hàng
    public void showMenuMainCustomer(){
        System.out.println("1. Xem thông tin cá nhân");
        System.out.println("2. Chỉnh sửa thông tin");
        System.out.println("3. Xem vé xem phim đã mua");
        System.out.println("4. Mua đồ ăn");
        System.out.println("5. Mua nước uống");
        System.out.println("6. Mua vé xem phim");
        System.out.println("0. Đăng xuất");
    }
    //menu edit customer
    public void showMenuEditCustomer(){
        System.out.println("1. Chỉnh sửa thông tin cá nhân");
        System.out.println("2. Đổi mật khẩu");
        System.out.println("0. Quay lại");
    }
    // nhằm giúp đọc dễ hiểu code nên nhóm comment kỹ
    // Quản lý Rạp Chiếu Phim
    // 3120560050 Đinh Dương Kỳ
    // 3120560056 Nguyễn Bá Lợi
}
