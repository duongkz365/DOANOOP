package controller;

import model.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Scanner;

public class Management {
    public Scanner scanner = new Scanner(System.in);
    private CinemaFile cinemaFile;

    private List<Customer> customers;
    private List<Employee> employees;
    private List<Films> films;
    private List<FastFoods> fastFoods;
    private List<Drinks> drinks;
    private List<CinemaTickets> cinemaTickets;
    private List<ParkingTickets> parkingTickets;
    private List<StatisticalFastFood> statisticalFastFoods;
    private List<StatisticalDrinks> statisticalDrinks;
    private List<CinemaRoom> cinemaRooms;
    private List<MovieChair> movieChairs;

    public Management(){
        this.cinemaFile = new CinemaFile();
        this.customers = cinemaFile.readCustomer();
        this.employees = cinemaFile.readEmployee();
        this.films = cinemaFile.readFilm();
        this.fastFoods = cinemaFile.readFastFood();
        this.drinks = cinemaFile.readDrinks();
        this.cinemaTickets = cinemaFile.readCinemaTicketFile();
        this.parkingTickets = cinemaFile.readParkingTicket();
        this.statisticalFastFoods = cinemaFile.readStatisticalFastFood();
        this.statisticalDrinks = cinemaFile.readStatisticalDrinks();
        this.cinemaRooms  = cinemaFile.readCinemaRoom();
        this.movieChairs = cinemaFile.readListMovieChar();
    }

    public String createID(){

        double rand = Math.random();
        double rand2 = Math.random();
        double rand3 = Math.random();
        rand = rand*1000;
        rand2 = rand2*1000;
        rand3 = rand3*1000;
        int randInt = (int)rand;
        int randInt2 = (int)rand2;
        int randInt3 = (int)rand3;
        return "" + randInt+"_"+randInt2+"_"+randInt3;
    }  // done
    public void resgisterAccount(){
        System.out.println("Khách hàng đăng ký tài khoản");
        String id = null,userName = null,email = null,password = null, repassword = null,birthday = null;
        String lastName,firstName;
        boolean checkID = false;
        System.out.println("Nhập họ của bạn: ");
        lastName = scanner.nextLine();
        System.out.println("Nhập tên của bạn: ");
        firstName = scanner.nextLine();
        while (true){
            id = "c"+createID();
            for(int i = 0;i<customers.size();i++){
                if(customers.get(i).getId().equals(id)){
                    checkID = true;
                    break;
                }
            }
            if(!checkID){
                break;
            }
        }
        while(true){
            System.out.println("Nhập tên đăng nhập của bạn:");
            boolean checkUserName = false;
            userName = scanner.next();
            for(int i = 0;i<customers.size();i++){
                if(customers.get(i).getUserName().equals(userName)){
                    System.out.println("Tên đăng nhập đã tồn tại trong hệ thống !");
                    checkUserName = true;
                    break;
                }
            }
           if(!checkUserName){
               break;
           }
        }
        while(true){
            System.out.println("Nhập email của bạn: ");
            email = scanner.next();
            boolean checkEmail = false;
            for(int i = 0;i<customers.size();i++){
                if(customers.get(i).getEmail().equals(email)){
                    System.out.println("Email đã tồn tại trong hệ thống !");
                    checkEmail = true;
                    break;
                }
            }
            if(!checkEmail){
                break;
            }
        }
        System.out.println("Nhập mật khẩu của bạn: ");
         password = scanner.next();
        while(true){
            System.out.println("Nhập lại mật khẩu của bạn:");
             repassword = scanner.next();
            if(repassword.equals(password)){
                break;
            }else {
                System.out.println("Mật khẩu nhập lại không đúng, vui lòng nhập lại!");
            }
        }
        while(true){
            System.out.println("Nhập ngày sinh của bạn: (định dạng yyyy-mm-dd)");
             birthday = scanner.next();
            if(birthday.length()<10){
                System.out.println("Sai Định Dạng");
            }else {
                String [] b= birthday.split("");
                if(!b[4].equals("-") && !b[7].equals("-")){
                    System.out.println("Sai định dạng s");
                    System.out.println(b[4]);
                }else {
                    break;
                }
            }
        }
        LocalDate newLocalDate = LocalDate.parse(birthday);
        int level = 1,exp = 0;
        double wallet = 0;
        Customer customer = new Customer(id,lastName,firstName,userName,password,newLocalDate,email,level,exp,wallet);
        customers.add(customer);
        cinemaFile.writeListCustomer(customers);
        System.out.println("Đăng ký thành công! Hãy xem lại thông tin của bạn");
        customer.display();
        System.out.println("Nhập vào bất kỳ để tiếp tục! ");
        String next = scanner.next();
    }  // done
    public void addCinemaRoom(){
        System.out.println("Thêm Phòng Phim mới! ");
        System.out.println("Vui lòng chọn ngày: ");
        String date;
        int count = 0;
        while(true){
            System.out.println("Nhập ngày cần thêm (định dạng yyyy-mm-dd)");
            date = scanner.next();
            if(date.length()<10){
                System.out.println("Sai Định Dạng");
            }else {
                String [] b= date.split("");
                if(!b[4].equals("-") && !b[7].equals("-")){
                    System.out.println("Sai định dạng s");
                }else {
                    break;
                }
            }
        }
        System.out.println("Số phòng của rạp (4): room 1, room 2, room 3, room 4");
        System.out.println("Số phòng đã sử dụng trong ngày " + date+":");
        int countRoom = 0;
        for(int i = 0;i<cinemaRooms.size();i++){
            if(cinemaRooms.get(i).getDate().equals(LocalDate.parse(date))){
                System.out.print(cinemaRooms.get(i).getRoomName()+ " ");
                countRoom++;
                count++;
            }
        }
        if(countRoom==0){
            System.out.println("Chưa có phòng nào được sử dụng trong ngày "+ date);
        }
        System.out.println();
        if(count==4){
            System.out.println("Không có phòng trống trong ngày này");
        }else {
            System.out.println("Số phòng còn lại: " +(4-count));
            System.out.println("Vui lòng chọn phòng!(1)(2)(3)(4)");
            String chooseRoom = scanner.next();
            boolean write= false;
            if(chooseRoom.equals("1")){
                chooseRoom = "Phòng 1";
                write = true;
            }else if(chooseRoom.equals("2")){
                chooseRoom = "Phòng 2";
                write = true;
            }else if(chooseRoom.equals("3")){
                chooseRoom = "Phòng 3";
                write = true;
            } else if(chooseRoom.equals("4")){
                chooseRoom = "Phòng 4";
                write = true;
            } else {
                System.out.println("Chọn phòng không hợp lệ");
            }
            if(write){
                String id = "r"+createID();
                CinemaRoom cinemaRoom = new CinemaRoom(id,chooseRoom," "," "," "," "," "," ",LocalDate.parse(date));
                cinemaRooms.add(cinemaRoom);
                cinemaFile.writeListRoom(cinemaRooms);
            }

        }
        System.out.println("Nhập vào bất kỳ để tiếp tục");
        String next = scanner.next();
    }

    public void showInfo(String id, String choose){
        if(choose.equals("customer")){
            for(int i = 0;i< customers.size();i++){
                if(customers.get(i).getId().equals(id)){
                    customers.get(i).display();
                }
            }
        }else if(choose.equals("employee")){
            for(int i = 0;i<employees.size();i++){
                if(employees.get(i).getId().equals(id)){
                    employees.get(i).display();
                }
            }
        }
        System.out.println("\nNhập phím bất kỳ để tiếp tục!");
        String next = scanner.next();
    } // done
    public void editPassword(String id,String choose){
        if(choose.equals("employee")){
            System.out.println("Nhập mật khẩu cũ: ");
            String oldPass = scanner.next();
            System.out.println("Nhập mật khẩu mới: ");
            String newPass = scanner.next();
            System.out.println("Nhập lại mật khẩu mới: ");
            String reNewPass = scanner.next();
            for(int i = 0;i<employees.size();i++){
                if(employees.get(i).getId().equals(id)){

                    if(employees.get(i).getPassword().equals(oldPass)){
                        if(newPass.equals(reNewPass)){
                            employees.get(i).setPassword(newPass);
                            System.out.println("Đổi mật khẩu thành công");
                            cinemaFile.writeListEmployee(employees);

                        }else {
                            System.out.println("Mật khẩu nhập lại không đúng");
                        }
                    }else {
                        System.out.println("Mật khẩu cũ không đúng");
                    }
                    break;
                }
            }
        }else if(choose.equals("customer")){
            System.out.println("Nhập mật khẩu cũ: ");
            String oldPass = scanner.next();
            System.out.println("Nhập mật khẩu mới: ");
            String newPass = scanner.next();
            System.out.println("Nhập lại mật khẩu mới: ");
            String reNewPass = scanner.next();
            for(int i = 0;i<customers.size();i++){
                if(customers.get(i).getId().equals(id)){

                    if(customers.get(i).getPassword().equals(oldPass)){
                        if(newPass.equals(reNewPass)){
                            customers.get(i).setPassword(newPass);
                            System.out.println("Đổi mật khẩu thành công");
                            cinemaFile.writeListCustomer(customers);
                        }else {
                            System.out.println("Mật khẩu nhập lại không đúng");
                        }
                    }else {
                        System.out.println("Mật khẩu cũ không đúng");
                    }
                    break;
                }
            }
        }
    }  // done
    public void editInfo(String id,String choose){
        if(choose.equals("employee")){
            System.out.println("Nhập họ: ");
            String lastName = scanner.nextLine();
            System.out.println("Nhập tên: ");
            String firstName = scanner.nextLine();
            System.out.println("Nhập email: ");
            String email = scanner.nextLine();
            String birthday;
            while(true){
                System.out.println("Nhập ngày tháng năm sinh: (định dạng yyyy-mm-dd)");
                 birthday = scanner.nextLine();
                String [] kt = birthday.split("");
                if(kt[4].equals("-") && kt[7].equals("-")){
                   break;
                }else {
                    System.out.println("Nhập sai định dạng");
                }
            }
            for (int i = 0;i<employees.size();i++){
                if(employees.get(i).getId().equals(id)){
                    employees.get(i).setLastName(lastName);
                    employees.get(i).setFirstName(firstName);
                    employees.get(i).setEmail(email);
                    employees.get(i).setBirthDay(LocalDate.parse(birthday));
                    cinemaFile.writeListEmployee(employees);
                    System.out.println("Đổi thông tin thành công");
                    break;
                }
            }

        }else  if(choose.equals("customer")){
            System.out.println("Nhập họ: ");
            String lastName = scanner.nextLine();
            System.out.println("Nhập tên: ");
            String firstName = scanner.nextLine();
            System.out.println("Nhập email: ");
            String email = scanner.nextLine();
            String birthday;
            while(true){
                System.out.println("Nhập ngày tháng năm sinh: (định dạng yyyy-mm-dd)");
                birthday = scanner.nextLine();
                String [] kt = birthday.split("");
                if(kt[4].equals("-") && kt[7].equals("-")){
                    break;
                }else {
                    System.out.println("Nhập sai định dạng");
                }
            }
            for (int i = 0;i<customers.size();i++){
                if(customers.get(i).getId().equals(id)){
                    customers.get(i).setLastName(lastName);
                    customers.get(i).setFirstName(firstName);
                    customers.get(i).setEmail(email);
                    customers.get(i).setBirthDay(LocalDate.parse(birthday));
                    cinemaFile.writeListCustomer(customers);
                    System.out.println("Đổi thông tin thành công");
                    break;
                }
            }
        }
    }  // done
    public void showBought(String id){
        int count = 0;
        for(int i = 0;i<cinemaTickets.size();i++){
            if(cinemaTickets.get(i).getIDCustomer().equals(id)){
                cinemaTickets.get(i).display();
                count++;
            }
        }
        if(count == 0){
            System.out.println("Không tìm thấy vé đã mua");
        }
    }  //done
    public void buyFood(String id){
        System.out.println("Mua thức ăn nhanh:");
        for(int i = 0;i<fastFoods.size();i++){
            System.out.println("Mã thức ăn nhanh: " + fastFoods.get(i).getID() +
                    " tên: " + fastFoods.get(i).getFoodName() +
                    " Kích thước " + fastFoods.get(i).getSize() +
                    " Giá tiền: " + fastFoods.get(i).getPrice());
        }
        System.out.println("Vui lòng chọn mã thức ăn nhanh");
        String code = scanner.next();
        boolean checkLook = false;
        for(int i = 0;i<fastFoods.size();i++){
            if(fastFoods.get(i).getID().equals(code)){
                for(int j = 0;j<customers.size();j++){
                    if(customers.get(j).getId().equals(id)){
                        if(customers.get(j).getWallet()< fastFoods.get(i).getPrice()){
                            System.out.println("Tài Khoản không đủ tiền, vui lòng đến quầy để nạp tiền vào tài khoản");
                        }else {
                            String ids = "sf"+createID();
                            String foodID = fastFoods.get(i).getID();
                            String foodName = fastFoods.get(i).getFoodName();
                            String size = fastFoods.get(i).getSize();
                            Double price = fastFoods.get(i).getPrice();
                            String customerName = customers.get(j).getLastName() +" " +customers.get(j).getFirstName();
                            String customerID = customers.get(j).getId();
                            StatisticalFastFood statisticalFastFood = new StatisticalFastFood(ids,foodID,foodName,size,price,customerName,customerID);
                            statisticalFastFoods.add(statisticalFastFood);
                            cinemaFile.writeListSoldFastFood(statisticalFastFoods);

                            customers.get(j).setWallet(customers.get(j).getWallet()-fastFoods.get(i).getPrice());
                            cinemaFile.writeListCustomer(customers);
                            System.out.println("Mua thành công");
                        }
                        break;
                    }
                }
                checkLook = true;
                break;
            }
        }
        if(!checkLook){
            System.out.println("Mã vừa nhập vào không chính xác");
        }
    }   //done
    public void buyDrinks(String id){
        System.out.println("Mua nước uống:");
        for(int i = 0;i<drinks.size();i++){
            System.out.println("Mã nước uống: " + drinks.get(i).getID() +
                    " tên: " + drinks.get(i).getFoodName() +
                    "Kích thước " + drinks.get(i).getVolume() +
                    " Giá tiền: " + drinks.get(i).getPrice());
        }
        System.out.println("Vui lòng chọn mã nước uống");
        String code = scanner.next();
        boolean checkLook = false;
        for(int i = 0;i<drinks.size();i++){
            if(drinks.get(i).getID().equals(code)){
                for(int j = 0;j<customers.size();j++){
                    if(customers.get(j).getId().equals(id)){
                        if(customers.get(j).getWallet()< drinks.get(i).getPrice()){
                            System.out.println("Tài Khoản không đủ tiền, vui lòng đến quầy để nạp tiền vào tài khoản");
                        }else {

                            String ids = "sd"+createID();
                            String drinksID = drinks.get(i).getID();
                            String drinksName = drinks.get(i).getFoodName();
                            String volume = drinks.get(i).getVolume();
                            Double price = drinks.get(i).getPrice();
                            String customerID = customers.get(j).getId();
                            String customerName = customers.get(j).getLastName()+ " " + customers.get(j).getFirstName();

                            StatisticalDrinks statisticalDrink = new StatisticalDrinks(ids,drinksID,drinksName,volume,price,customerID,customerName);
                            System.out.println(statisticalDrinks.size());
                            statisticalDrinks.add(statisticalDrink);
                            cinemaFile.writeListSoldDrink(statisticalDrinks);
                            customers.get(j).setWallet(customers.get(j).getWallet()-fastFoods.get(i).getPrice());
                            cinemaFile.writeListCustomer(customers);
                            System.out.println("Mua thành công");
                        }
                        break;
                    }
                }
                checkLook = true;
                break;
            }
        }
        if(!checkLook){
            System.out.println("Mã vừa nhập vào không chính xác");
        }
    }  //done
    public void showMyCinemaTicket(String id){
        for(int i = 0;i<cinemaTickets.size();i++){
            if(cinemaTickets.get(i).getIDCustomer().equals(id)){
                cinemaTickets.get(i).display();
            }
        }
        System.out.println("Nhập bất kỳ để tiếp tục!");
        String next = scanner.next();
    }   // done
    public void buyMovieTicket(String id){
        System.out.println("Mua vé xem phim:");
        for(int i = 0;i<films.size();i++){
            System.out.println("Mã phim: " + films.get(i).getID() +
                    " tên phim: " + films.get(i).getMovieName() +

                    " Giá tiền: " + films.get(i).getPrice());
        }
        // chọn mã phim
        System.out.println("Vui lòng chọn mã phim:");
        String code = scanner.next();
        // check có mã không
        boolean checkLook = false;
        // duyệt hết mảng phim
        for(int i = 0;i<films.size();i++){
            // nếu có mã phim
            if(films.get(i).getID().equals(code)){

                // duyệt mảng khách hàng xem tài khoản còn tiền không
                for(int j = 0;j<customers.size();j++){
                    // tìm thấy khách hàng
                    if(customers.get(j).getId().equals(id)){
                        // nếu tài khoản nhỏ hơn giá vé thì thôi :v
                        if(customers.get(j).getWallet()< films.get(i).getPrice()){
                            System.out.println("Tài Khoản không đủ tiền, vui lòng đến quầy để nạp tiền vào tài khoản");
                        }else {

                            // nếu tài khoản còn đủ tiền
                            String ID = "m"+createID();  // tạo id
                            String movieName = films.get(i).getMovieName();  // lấy tên phim
                            String IDCustomer = customers.get(j).getId();  // lấy ID khách hàng
                            String customerName = customers.get(j).getLastName()+ " " + customers.get(j).getFirstName(); // lấy tên khách hàng

                            // mã ghế :
                            String seatCode = "";  // khởi tạo mã ghế ngồi
                            // duyệt mảng ghế tìm mã phim xem còn ghế không
                            for(int l = 0;l<movieChairs.size();l++){
                                if(movieChairs.get(l).getIDMovie().equals(films.get(i).getID())){
                                    String [] text = movieChairs.get(l).getSeatCode().split("-");
                                    System.out.println("Số ghế còn trống: ");
                                    for(int m = 1;m<text.length;m++){
                                        if(text[m].equals(" ")){
                                            System.out.print(m+" ");
                                        }
                                    }
                                    System.out.println("Chọn số ghế ngồi: ");
                                    int chooseChair = scanner.nextInt();
                                    seatCode = "Ghế số" + seatCode+chooseChair;
                                    text[chooseChair] ="Registered";
                                    String seat="";
                                    for(int b = 0;b<20;b++){
                                        seat +=  text[b]+ "-";
                                    }
                                    movieChairs.get(l).setSeatCode(seat);
                                    cinemaFile.writeListMovieChar(movieChairs);
                                }
                            }
                            String movieRoom = films.get(i).getIDroom();
                            Double price = films.get(i).getPrice();
                            LocalDate dateShow =films.get(i).getShowDate();
                            LocalTime timeShow = films.get(i).getShowTimeStart();
                            CinemaTickets cinemaTicket = new CinemaTickets(ID,movieName,IDCustomer,customerName,seatCode,movieRoom,price,dateShow,timeShow);
                            cinemaTickets.add(cinemaTicket);
                            cinemaFile.writeListCinemaTicket(cinemaTickets);
                            customers.get(j).setWallet(customers.get(j).getWallet()-films.get(i).getPrice());
                            cinemaFile.writeListCustomer(customers);
                            System.out.println("Mua thành công");
                        }
                        break;
                    }
                }

                checkLook = true;
                break;
            }
        }
        if(!checkLook){
            System.out.println("Mã vừa nhập vào không chính xác");
        }

    }    // done
    public void sellCinemaTicketByEmployee(){
        System.out.println("Bán vé xem phim: ");
        for(int i = 0;i<films.size();i++){
            System.out.println("Mã phim: " + films.get(i).getID() +" Tên Phim: " + films.get(i).getMovieName());
        }
        System.out.println("Nhập mã phim cần bán");
        String code = scanner.next();
        boolean checkCode = false;
        for(int i = 0;i<films.size();i++){
            if(films.get(i).getID().equals(code)){
                System.out.println("Khách hàng có tài khoản chưa ? (y)(n)");
                String choose = scanner.next();
                if(choose.equals("y")){
                    System.out.println("Nhập mã khách hàng: ");
                    String idCustomer =scanner.next();
                    boolean checkIDCustomer = false;

                    for(int j = 0;j<customers.size();j++){
                        if(customers.get(j).getId().equals(idCustomer)){

                            String ID = "m"+createID();
                            String movieName = films.get(i).getMovieName();
                            String IDCustomer = customers.get(j).getId();
                            String customerName = customers.get(j).getLastName()+ " " + customers.get(j).getFirstName();
                            //mã ghế
                            String seatCode = "";
                            for(int l = 0;l<movieChairs.size();l++){
                                if(movieChairs.get(l).getIDMovie().equals(films.get(i).getID())){
                                    String [] text = movieChairs.get(l).getSeatCode().split("-");
                                    System.out.println("Số ghế còn trống: ");
                                    for(int m = 1;m<text.length;m++){
                                        if(text[m].equals(" ")){
                                            System.out.print(m+" ");
                                        }
                                    }
                                    System.out.println("Chọn số ghế ngồi: ");
                                    int chooseChair = scanner.nextInt();
                                    seatCode = "Ghế số" + seatCode+chooseChair;
                                    text[chooseChair] ="Registered";
                                    String seat="";
                                    for(int b = 0;b<20;b++){
                                        seat +=  text[b]+ "-";
                                    }
                                    movieChairs.get(l).setSeatCode(seat);
                                    cinemaFile.writeListMovieChar(movieChairs);
                                }
                            }
                            double price = films.get(i).getPrice();
                            LocalDate dateShow =films.get(i).getShowDate();
                            LocalTime timeShow = films.get(i).getShowTimeStart();
                            String movieRoom = films.get(i).getIDroom();
                            CinemaTickets cinemaTicket = new CinemaTickets(ID,movieName,IDCustomer,customerName,seatCode,movieRoom,price,dateShow,timeShow);
                            cinemaTickets.add(cinemaTicket);
                            cinemaFile.writeListCinemaTicket(cinemaTickets);
                            System.out.println("Bán thành công");
                            checkIDCustomer = true;
                            break;
                        }
                    }
                    if(!checkIDCustomer){
                        System.out.println("Mã ID không tồn tại!");
                    }

                }else if(choose.equals("n")){
                    String ID = "m"+createID();
                    String movieName = films.get(i).getMovieName();
                    String IDCustomer = "customer";
                    String customerName = "customer";
                    String seatCode = "";
                    for(int l = 0;l<movieChairs.size();l++){
                        if(movieChairs.get(l).getIDMovie().equals(films.get(i).getID())){
                            String [] text = movieChairs.get(l).getSeatCode().split("-");
                            System.out.println("Số ghế còn trống: ");
                            for(int m = 1;m<text.length;m++){
                                if(text[m].equals(" ")){
                                    System.out.print(m+" ");
                                }
                            }
                            System.out.println("Chọn số ghế ngồi: ");
                            int chooseChair = scanner.nextInt();
                            seatCode = "Ghế số" + seatCode+chooseChair;
                            text[chooseChair] ="Registered";
                            String seat="";
                            for(int b = 0;b<20;b++){
                                seat +=  text[b]+ "-";
                            }
                            movieChairs.get(l).setSeatCode(seat);
                            cinemaFile.writeListMovieChar(movieChairs);
                        }
                    }
                    double price = films.get(i).getPrice();
                    LocalDate dateShow =films.get(i).getShowDate();
                    LocalTime timeShow = films.get(i).getShowTimeStart();
                    String movieRoom = films.get(i).getIDroom();
                    CinemaTickets cinemaTicket = new CinemaTickets(ID,movieName,IDCustomer,customerName,seatCode,movieRoom,price,dateShow,timeShow);
                    cinemaTickets.add(cinemaTicket);
                    cinemaFile.writeListCinemaTicket(cinemaTickets);
                    System.out.println("Bán thành công!");
                }


                checkCode = true;
                break;
            }
        }
        if(!checkCode){
            System.out.println("Mã vừa nhập không chính xác");
        }
        System.out.println("Nhập ký tự bất kỳ để tiếp tục");
        String next = scanner.next();
    }  // done
    public void sellFoodByEmployee(){
        System.out.println("Bán thức ăn: ");
        for(int i = 0;i<fastFoods.size();i++){
            System.out.println("Mã thức ăn nhanh: " + fastFoods.get(i).getID()
                    +" Tên thức ăn nhanh: " + fastFoods.get(i).getID()
                    +" Kích thước: " +fastFoods.get(i).getSize()
                    +" Giá: "+ fastFoods.get(i).getPrice()
            );
        }
        System.out.println("Nhập mã thức ăn nhanh cần bán");
        String code = scanner.next();
        boolean checkCode = false;
        for(int i = 0;i<films.size();i++){
            if(fastFoods.get(i).getID().equals(code)){
                System.out.println("Khách hàng có tài khoản chưa ? (y)(n)");
                String choose = scanner.next();
                if(choose.equals("y")){
                    System.out.println("Nhập mã khách hàng: ");
                    String idCustomer =scanner.next();
                    boolean checkIDCustomer = false;

                    for(int j = 0;j<customers.size();j++){
                        if(customers.get(j).getId().equals(idCustomer)){

                            String ID = "sf"+createID();
                            String foodID = fastFoods.get(i).getID();
                            String foodName = fastFoods.get(i).getFoodName();
                            String size = fastFoods.get(i).getSize();
                            double price = fastFoods.get(i).getPrice();
                            String customerName = customers.get(j).getLastName() + " " +customers.get(j).getFirstName();
                            String customerID = customers.get(j).getId();
                            StatisticalFastFood statisticalFastFood = new StatisticalFastFood(ID,foodID,foodName,size,price,customerName,customerID);
                            statisticalFastFoods.add(statisticalFastFood);
                            cinemaFile.writeListSoldFastFood(statisticalFastFoods);
                            System.out.println("Bán thành công");
                            checkIDCustomer = true;
                            break;
                        }
                    }
                    if(!checkIDCustomer){
                        System.out.println("Mã ID không tồn tại!");
                    }
                }else if(choose.equals("n")){
                    String ID = "sf"+createID();
                    String foodID = fastFoods.get(i).getID();
                    String foodName = fastFoods.get(i).getFoodName();
                    String size = fastFoods.get(i).getSize();
                    double price = fastFoods.get(i).getPrice();
                    String customerName = "customer";
                    String customerID = "customer";
                    StatisticalFastFood statisticalFastFood = new StatisticalFastFood(ID,foodID,foodName,size,price,customerName,customerID);
                    statisticalFastFoods.add(statisticalFastFood);
                    cinemaFile.writeListSoldFastFood(statisticalFastFoods);
                    System.out.println("Bán thành công!");
                }


                checkCode = true;
                break;
            }
        }
        if(!checkCode){
            System.out.println("Mã vừa nhập không chính xác");
        }
        System.out.println("Nhập ký tự bất kỳ để tiếp tục");
        String next = scanner.next();
    }  // done
    public void sellDrinksByEmployee(){
        System.out.println("Bán nước uống: ");
        for(int i = 0;i<drinks.size();i++){
            System.out.println("Mã nước uống: " + drinks.get(i).getID()
                    +" Tên thức ăn nhanh: " + drinks.get(i).getFoodName()
                    +" Kích thước: " +drinks.get(i).getVolume()
                    +" Giá: "+ drinks.get(i).getPrice()
            );
        }
        System.out.println("Nhập mã thức ăn nhanh cần bán");
        String code = scanner.next();
        boolean checkCode = false;
        for(int i = 0;i<films.size();i++){
            if(drinks.get(i).getID().equals(code)){
                System.out.println("Khách hàng có tài khoản chưa ? (y)(n)");
                String choose = scanner.next();
                if(choose.equals("y")){
                    System.out.println("Nhập mã khách hàng: ");
                    String idCustomer =scanner.next();
                    boolean checkIDCustomer = false;

                    for(int j = 0;j<customers.size();j++){
                        if(customers.get(j).getId().equals(idCustomer)){

                            String ID = "sf"+createID();
                            String foodID = drinks.get(i).getID();
                            String foodName = drinks.get(i).getFoodName();
                            String size = drinks.get(i).getVolume();
                            double price = drinks.get(i).getPrice();
                            String customerName = customers.get(j).getLastName() + " " +customers.get(j).getFirstName();
                            String customerID = customers.get(j).getId();
                            StatisticalDrinks statisticaldrink = new StatisticalDrinks(ID,foodID,foodName,size,price,customerName,customerID);
                            statisticalDrinks.add(statisticaldrink);
                            cinemaFile.writeListSoldDrink(statisticalDrinks);
                            System.out.println("Bán thành công");
                            checkIDCustomer = true;
                            break;
                        }
                    }
                    if(!checkIDCustomer){
                        System.out.println("Mã ID không tồn tại!");
                    }
                }else if(choose.equals("n")){
                    String ID = "sf"+createID();
                    String foodID = drinks.get(i).getID();
                    String foodName = drinks.get(i).getFoodName();
                    String size = drinks.get(i).getVolume();
                    double price = drinks.get(i).getPrice();
                    String customerName = "customer";
                    String customerID = "customer";
                    StatisticalDrinks statisticalDrink = new StatisticalDrinks(ID,foodID,foodName,size,price,customerName,customerID);
                    statisticalDrinks.add(statisticalDrink);
                    cinemaFile.writeListSoldDrink(statisticalDrinks);
                    System.out.println("Bán thành công!");
                }


                checkCode = true;
                break;
            }
        }
        if(!checkCode){
            System.out.println("Mã vừa nhập không chính xác");
        }
        System.out.println("Nhập ký tự bất kỳ để tiếp tục");
        String next = scanner.next();
    } // done
    public void depositMoneyIntoAccount(){
        System.out.println("Nạp tiền vào tài khoản cho khách hàng: ");
        System.out.println("Nhập mã khách hàng: ");
        String code = scanner.next();
        boolean checkID = false;
        for(int i = 0;i<customers.size();i++){
            if(customers.get(i).getId().equals(code)){
                System.out.println("Nhập số tiền cần nạp: ");
                double money = scanner.nextDouble();
                money = Math.abs(money);
                System.out.println("Xác nhận thao tác (y)(n)");
                String submit = scanner.next();
                if(submit.equals("y")){
                    customers.get(i).setWallet(customers.get(i).getWallet()+ money);
                    cinemaFile.writeListCustomer(customers);
                    System.out.println("Nạp tiền thành công");
                }
                checkID  = true;
                break;
            }
        }
        if(!checkID){
            System.out.println("Mã vừa nhập không chính xác");
        }
        System.out.println("Nhập vào bất kỳ để tiếp tục");
        String next = scanner.next();
    }  // done
    public void sellParkingTicketByEmployee(){
        System.out.println("Bán vé gửi xe");
        System.out.println("Khách hàng có tài khoản chưa>? (y)(n)");
        String choose = scanner.next();
        if(choose.equals("y")){
            boolean checkCustomer = false;
            System.out.println("Nhập Mã Khách hàng:");
            String IDCustomer = scanner.next();
            String customerName = null;
            for(int i = 0;i<customers.size();i++){
                if(customers.get(i).getId().equals(IDCustomer)){
                    customerName = customers.get(i).getLastName() +" " + customers.get(i).getFirstName();
                    checkCustomer = true;
                    break;
                }
            }
            if(checkCustomer){
                String id = "p"+createID();
                System.out.println("Nhập loại xe:");
                String vehicleType = scanner.nextLine();
                System.out.println("Nhập biển số xe: ");
                String numberPlate = scanner.next();
                LocalTime timeIn = java.time.LocalTime.now();
                LocalDate datein = java.time.LocalDate.now();
                ParkingTickets parkingTicket = new ParkingTickets(id,vehicleType,numberPlate,IDCustomer,customerName,datein,timeIn);
                parkingTickets.add(parkingTicket);
                cinemaFile.writeListParkingTicket(parkingTickets);
            }else {
                System.out.println("Không tìm thấy mã khách hàng vừa nhập");
            }
        }if(choose.equals("n")){
            String id = "p"+createID();
            System.out.println("Nhập loại xe:");
            String vehicleType = scanner.nextLine();
            System.out.println("Nhập biển số xe: ");
            String numberPlate = scanner.next();
            LocalTime timeIn = java.time.LocalTime.now();
            LocalDate datein = java.time.LocalDate.now();
            String IDCustomer = "customer";
            String customerName ="customer";
            ParkingTickets parkingTicket = new ParkingTickets(id,vehicleType,numberPlate,IDCustomer,customerName,datein,timeIn);
            parkingTickets.add(parkingTicket);
            cinemaFile.writeListParkingTicket(parkingTickets);
        }else {
            System.out.println("Lựa chọn không hợp lệ !");
        }
    } // done



    public void addEmployeeByAdmin(){
        System.out.println("Thêm Nhân Viên: ");
        String id;
        while(true){
            id = "e"+ createID();
            boolean checkID = false;
            for(int i = 0;i<employees.size();i++){
                if(employees.get(i).getId().equals(id)){
                    checkID = true;
                }
            }
            if(!checkID){
                break;
            }
        }
        System.out.println("Nhập họ của nhân viên:");
        String lastName = scanner.nextLine();
        System.out.println("Nhập tên nhân viên: ");
        String firstName = scanner.nextLine();
        System.out.println("Nhập email: ");
        String email = scanner.nextLine();
        System.out.println("Nhập tên đăng nhập");
        String userName = scanner.next();
        System.out.println("Nhập mật khẩu");
        String password = scanner.next();
        String birthday;
        while(true){
            System.out.println("Nhập ngày sinh nhật: (định dạng yyyy-mm-dd)");
            birthday = scanner.next();
            if(birthday.length()<10){
                System.out.println("Sai Định Dạng");
            }else {
                String [] b= birthday.split("");
                if(!b[4].equals("-") && !b[7].equals("-")){
                    System.out.println("Sai định dạng s");
                    System.out.println(b[4]);
                }else {
                    break;
                }
            }
        }

        System.out.println("Nhập chức vụ: (carkeeper/salesman/admin)");
        String position = scanner.next();
        System.out.println("Nhập mức lương:");
        Double salary = scanner.nextDouble();
        String startDate;
        while(true){
            System.out.println("Nhập  ngày bắt đầu làm việc: (định dạng yyyy-mm-dd)");
            startDate = scanner.next();
            if(startDate.length()<10){
                System.out.println("Sai Định Dạng");
            }else {
                String [] b= startDate.split("");
                if(!b[4].equals("-") && !b[7].equals("-")){
                    System.out.println("Sai định dạng s");
                    System.out.println(b[4]);
                }else {
                    break;
                }
            }
        }
        Employee employee = new Employee(id,lastName,firstName,userName,password,LocalDate.parse(birthday),email,position,salary,LocalDate.parse(startDate));
        employees.add(employee);
        cinemaFile.writeListEmployee(employees);
    }   // done
    public void editEmployeeByAdmin(){
        System.out.println("Chỉnh sửa nhân viên:");
        for(int i = 0;i<employees.size();i++){
            System.out.println("Mã nhân viên: " + employees.get(i).getId()
                    +" Tên nhân viên: "+ employees.get(i).getLastName()
                    +" "
                    + employees.get(i).getFirstName());
        }
        System.out.println("Nhập mã nhân viên cần chỉnh sửa: ");
        String ID = scanner.next();
        boolean checkID = false;
        for(int i = 0;i<employees.size();i++){
            if(employees.get(i).getId().equals(ID)){
                System.out.println("Nhập lương: ");
                Double salary = scanner.nextDouble();
                System.out.println("Nhập chức vụ: ");
                String postion = scanner.next();
                System.out.println("Nhập ngày vào làm việc: ");
                String startDate;
                while(true){
                    System.out.println("Nhập  ngày bắt đầu làm việc: (định dạng yyyy-mm-dd)");
                    startDate = scanner.next();
                    if(startDate.length()<10){
                        System.out.println("Sai Định Dạng");
                    }else {
                        String [] b= startDate.split("");
                        if(!b[4].equals("-") && !b[7].equals("-")){
                            System.out.println("Sai định dạng s");
                            System.out.println(b[4]);
                        }else {
                            break;
                        }
                    }
                }

                employees.get(i).setSalary(salary);
                employees.get(i).setPosition(postion);
                employees.get(i).setStartDate(LocalDate.parse(startDate));
                cinemaFile.writeListEmployee(employees);
                System.out.println("Chỉnh sửa thành công");
                checkID = true;
                break;
            }
        }
        if(!checkID){
            System.out.println("Mã nhân viên không chính xác");
        }
    }  // done
    public void deleteEmployeeByAdmin(){
        System.out.println("Xóa Nhân viên");
        for(int i = 0;i<employees.size();i++){
            System.out.println("Mã Nhân viên " + employees.get(i).getId()
                    + " Tên Nhân viên: " + employees.get(i).getLastName()
                    + " "
                    + employees.get(i).getFirstName());
        }
        boolean checkID = false;
        System.out.println("Nhập mã nhân viên cần xóa");
        String ID = scanner.next();
        for(int i = 0;i<employees.size();i++){
            if(employees.get(i).getId().equals(ID)){
                System.out.println("Chọn (y) để xác nhận, chọn (n) để hủy thao tác");
                String choose = scanner.next();
                if(choose.equals("y")){
                    employees.remove(i);
                    cinemaFile.writeListEmployee(employees);
                    System.out.println("Xóa nhân viên thành công");
                }
                checkID = true;
                break;
            }
        }
        if(!checkID){
            System.out.println("Mã vừa nhập không chính xác");
        }
    }  // done
    // employee employee employee employee

    public void addCustomerByEmployee(){
        System.out.println("Thêm khách hàng: ");
        String id;
        while(true){
            id = "c"+ createID();
            boolean checkID = false;
            for(int i = 0;i<customers.size();i++){
                if(customers.get(i).getId().equals(id)){
                    checkID = true;
                }
            }
            if(!checkID){
                break;
            }
        }
        System.out.println("Nhập họ: ");
        String lastName = scanner.nextLine();
        System.out.println("Nhập tên: ");
        String firstName =scanner.nextLine();
        System.out.println("Nhập tên đăng nhập: ");
        String userName = scanner.next();
        System.out.println("Nhập mật khẩu: ");
        String password = scanner.next();
        System.out.println("Nhập email:");
        String email = scanner.next();
        String birthday;
        while(true){
            System.out.println("Nhập ngày sinh nhật: (định dạng yyyy-mm-dd)");
            birthday = scanner.next();
            if(birthday.length()<10){
                System.out.println("Sai Định Dạng");
            }else {
                String [] b= birthday.split("");
                if(!b[4].equals("-") && !b[7].equals("-")){
                    System.out.println("Sai định dạng s");
                    System.out.println(b[4]);
                }else {
                    break;
                }
            }
        }
        int level = 0;
        int exp = 0;
        double wallet = 0;
        Customer customer = new Customer(id,lastName,firstName,userName,password,LocalDate.parse(birthday),email,level,exp,wallet);
        customers.add(customer);
        cinemaFile.writeListCustomer(customers);
        System.out.println("Thêm khách hàng thành công");
    }   // done
    public void deleteCustomerByEmployee(){

        System.out.println("Khách hàng");
        for(int i = 0;i<customers.size();i++){
            System.out.println("Mã Khách hàng " + customers.get(i).getId()
                    + " Tên Khách hàng: " + customers.get(i).getLastName()
                    + " "
                    + customers.get(i).getFirstName());
        }
        boolean checkID = false;
        System.out.println("Nhập mã khách hàng cần xóa");
        String ID = scanner.next();
        for(int i = 0;i<customers.size();i++){
            if(customers.get(i).getId().equals(ID)){
                System.out.println("Chọn (y) để xác nhận, chọn (n) để hủy thao tác");
                String choose = scanner.next();
                if(choose.equals("y")){
                    customers.remove(i);
                    cinemaFile.writeListCustomer(customers);
                    System.out.println("Xóa khách hàng thành công");
                }
                checkID = true;
                break;
            }
        }
        if(!checkID){
            System.out.println("Mã vừa nhập không chính xác");
        }
    }  // done
    // end employee end employee end employee


    // film film film film film film

    public void addFilmByEmployee(){
        String showDate;
        String chooseTime;
        boolean checkRoom = false;
        String showTimeStart;

        while(true){
            System.out.println("Nhập ngày chiếu phim: (định dạng yyyy-mm-dd)");
            showDate = scanner.next();
            if(showDate.length()<10){
                System.out.println("Sai Định Dạng");
            }else {
                String [] b= showDate.split("");
                if(!b[4].equals("-") && !b[7].equals("-")){
                    System.out.println("Sai định dạng s");
                    System.out.println(b[4]);
                }else {
                    break;
                }
            }
        }

        for(int i = 0;i<cinemaRooms.size();i++){
            if(cinemaRooms.get(i).getDate().equals(LocalDate.parse(showDate))){

                checkRoom = true;
            }
        }

        if(checkRoom){
            boolean checkchoose = false;
            String chooseRoom;
            for(int i = 0;i<cinemaRooms.size();i++){
                if(cinemaRooms.get(i).getDate().equals(LocalDate.parse(showDate))){
                    System.out.println("Mã Phòng: " + cinemaRooms.get(i).getID()+" Tên phòng: " + cinemaRooms.get(i).getRoomName());
                }
            }
            System.out.println("Vui lòng chọn mã phòng! ");
            chooseRoom = scanner.next();
            for(int i = 0;i<cinemaRooms.size();i++){
                if(cinemaRooms.get(i).getID().equals(chooseRoom)){
                    System.out.println("Chọn phòng thành công");
                    checkchoose = true;
                    break;
                }
            }
            if(checkchoose){
                System.out.println("Khung giờ hiện có");
               for(int i = 0;i<cinemaRooms.size();i++){
                   if(cinemaRooms.get(i).getID().equals(chooseRoom)){
                       if(cinemaRooms.get(i).getShift1().equals(" ")){
                           System.out.println("(1)Khung giờ 0h - 4h");
                       }
                       if(cinemaRooms.get(i).getShift2().equals(" ")){
                           System.out.println("(2)Khung giờ 4h - 8h");
                       }
                       if(cinemaRooms.get(i).getShift3().equals(" ")){
                           System.out.println("(3)Khung giờ 8h - 12h");
                       }
                       if(cinemaRooms.get(i).getShift4().equals(" ")){
                           System.out.println("(4)Khung giờ 12h - 16h");
                       }
                       if(cinemaRooms.get(i).getShift5().equals(" ")){
                           System.out.println("(5)Khung giờ 16h - 20h");
                       }
                       if(cinemaRooms.get(i).getShift6().equals(" ")){
                           System.out.println("(6)Khung giờ 20h - 24h");
                       }
                       System.out.println("Vui lòng chọn khung giờ (tương ứng các số)");
                       chooseTime = scanner.next();

                       if(Integer.parseInt(chooseTime)>6 || Integer.parseInt(chooseTime)<1){
                           System.out.println("Khung giờ chọn không hợp lệ");
                       }

                    // info film
                       String id;
                       while(true){
                            id = "f"+ createID();
                            boolean checkID = false;
                            for(int j = 0;j<films.size();j++){
                                if(films.get(j).getID().equals(id)){
                                    checkID = true;
                                  }
                            }
                         if(!checkID){
                          break;
                         }
                       }
                       System.out.println("Nhập tên phim: ");
                       String movieName = scanner.nextLine();
                       movieName = scanner.nextLine();
                       System.out.println("Nhập thể loại phim: ");
                       String movieGenre = scanner.nextLine();
                       System.out.println("Nhập thời lượng phim: (phút) ");
                       int movieDuration = scanner.nextInt();

                       System.out.println("Nhập giá vé: ");
                       Double price = scanner.nextDouble();
                       String showTimeEnd;
                       if(Integer.parseInt(chooseTime)<3){
                           showTimeStart = ("0"+Integer.parseInt(chooseTime)*4)+":00:00";

                       }else {
                           showTimeStart = (Integer.parseInt(chooseTime)*4)+":00:00";

                       }
                       if(Integer.parseInt(chooseTime)<2){
                           showTimeEnd = ("0"+(Integer.parseInt(chooseTime)+1)*4) +":00:00";
                       }else {
                           showTimeEnd = ((Integer.parseInt(chooseTime)+1)*4) +":00:00";
                       }

                       String movieRoom = null;
                        for(int a = 0;a<cinemaRooms.size();a++){
                            if(cinemaRooms.get(a).getID().equals(chooseRoom)){
                                movieRoom = cinemaRooms.get(a).getRoomName();
                                break;
                            }
                        }

                       Films film = new Films(id,movieName,movieDuration,movieGenre,price,20,LocalTime.parse(showTimeStart),LocalTime.parse(showTimeEnd),LocalDate.parse(showDate),chooseRoom,movieRoom,Integer.parseInt(chooseTime));
                       films.add(film);
                       cinemaFile.writeListFilm(films);
                       String seatCode= "-";
                       for(int n = 0;n<20;n++){
                           seatCode +=" -";
                       }
                       MovieChair movieChair = new MovieChair(id,seatCode);
                       movieChairs.add(movieChair);
                       cinemaFile.writeListMovieChar(movieChairs);
                       for(int k = 0;k<cinemaRooms.size();k++){
                           if(cinemaRooms.get(k).getID().equals(chooseRoom)){
                               if(chooseTime.equals("1")){
                                   cinemaRooms.get(k).setShift1("Registered");
                               }
                               if(chooseTime.equals("2")){
                                   cinemaRooms.get(k).setShift2("Registered");
                               }
                               if(chooseTime.equals("3")){
                                   cinemaRooms.get(k).setShift3("Registered");
                               }
                               if(chooseTime.equals("4")){
                                   cinemaRooms.get(k).setShift4("Registered");
                               }
                               if(chooseTime.equals("5")){
                                   cinemaRooms.get(k).setShift5("Registered");
                               }
                               if(chooseTime.equals("6")){
                                   cinemaRooms.get(k).setShift6("Registered");
                               }
                               cinemaFile.writeListRoom(cinemaRooms);
                           }
                       }


                   }
               }
            }else {
                System.out.println("Mã phòng không hợp lệ");
            }

        }else {
            System.out.println("Không tìm thấy phòng trong ngày " + showDate);
            System.out.println("Vui lòng thêm phòng chiếu phim mới");
        }


        System.out.println("Nhập vào bất kỳ để tiếp tục!");
        String next = scanner.next();
    }  // done
    public void editFilmByEmployee(){
        System.out.println("Chỉnh sửa phim");
        for(int i = 0;i<films.size();i++){
            System.out.println("Mã phim: " + films.get(i).getID() +" Tên Phim: " + films.get(i).getMovieName());
        }
        System.out.println("Nhập mã phim cần chỉnh sửa: ");
        String ID = scanner.next();
        boolean checkID = false;
        for(int i = 0;i<films.size();i++){
            if(films.get(i).getID().equals(ID)){

                System.out.println("Nhập tên phim mới: ");
                String movieName = scanner.nextLine();
                 movieName = scanner.nextLine();              // do thừa \n nên cần thêm dòng này để không bị bỏ qua

                System.out.println("Nhập thể loại mới: ");
                String movieGenre = scanner.nextLine();
                System.out.println("Nhập thời lượng phim: ");
                int movieDuration = scanner.nextInt();
                System.out.println("Nhập số lượng ghế còn lại: ");
                int seat = scanner.nextInt();
                System.out.println("Nhập giá vé");
                Double price = scanner.nextDouble();
//                String showDate;
//                while(true){
//                    System.out.println("Nhập ngày chiếu phim: (định dạng yyyy-mm-dd)");
//                    showDate = scanner.next();
//                    if(showDate.length()<10){
//                        System.out.println("Sai Định Dạng");
//                    }else {
//                        String [] b= showDate.split("");
//                        if(!b[4].equals("-") && !b[7].equals("-")){
//                            System.out.println("Sai định dạng s");
//                            System.out.println(b[4]);
//                        }else {
//                            break;
//                        }
//                    }
//                }
                String showTimeStart;
                while(true){
                    System.out.println("Nhập giờ bắt đầu chiếu: (định dạng hh:mm:ss)");
                    showTimeStart = scanner.next();
                    if(showTimeStart.length()<8){
                        System.out.println("Sai Định Dạng");
                    }else {
                        String [] b= showTimeStart.split("");
                        if(!b[2].equals(":") && !b[5].equals(":")){
                            System.out.println("Sai định dạng");
                            System.out.println(b[4]);
                        }else {
                            break;
                        }
                    }
                }
                String showTimeEnd;
                while(true){
                    System.out.println("Nhập giờ kết thúc: (định dạng hh:mm:ss)");
                    showTimeEnd = scanner.next();
                    if(showTimeEnd.length()<8){
                        System.out.println("Sai Định Dạng");
                    }else {
                        String [] b= showTimeEnd.split("");
                        if(!b[2].equals(":") && !b[5].equals(":")){
                            System.out.println("Sai định dạng");
                            System.out.println(b[4]);
                        }else {
                            break;
                        }
                    }
                }
                films.get(i).setMovieName(movieName);
                films.get(i).setMovieGenre(movieGenre);
                films.get(i).setMovieDuration(movieDuration);
                films.get(i).setRemaining(seat);
                films.get(i).setShowTime(LocalTime.parse(showTimeStart));
                films.get(i).setShowTimeEnd(LocalTime.parse(showTimeEnd));
//                films.get(i).setShowDate(LocalDate.parse(showDate));
                cinemaFile.writeListFilm(films);
                checkID = true;
                break;
            }
        }
        if(!checkID){
            System.out.println("Không tìm thấy mã vừa nhập");
        }
    }  // done

    public void deleteFilmByEmployee(){
        System.out.println("Xóa phim: ");
        for(int i = 0;i<films.size();i++){
            System.out.println("Mã Phim: " + films.get(i).getID() + " Tên phim: "+ films.get(i).getMovieName());
        }
        System.out.println("Nhập mã phim cần xóa");
        String ID = scanner.next();
        boolean checkID = false;
        for(int i = 0;i<films.size();i++){
            if(films.get(i).getID().equals(ID)){
                System.out.println("Chọn (y) để xác nhận chọn (n) để hủy thao tác");
                String choose = scanner.next();
                if(choose.equals("y")){
                    films.remove(i);
                    cinemaFile.writeListFilm(films);
                    System.out.println("Xóa phim thành công");
                }
                checkID = true;
                break;
            }
        }
        if(!checkID){
            System.out.println("Không tìm thấy mã vừa nhập");
        }
    }  // done
    // end film end film


    public void addFastFoodByEmployee(){
        String id;
        while(true){
            id = "ff"+ createID();
            boolean checkID = false;
            for(int i = 0;i<fastFoods.size();i++){
                if(fastFoods.get(i).getID().equals(id)){
                    checkID = true;
                }
            }
            if(!checkID){
                break;
            }
        }
        scanner.nextLine();
        System.out.println("Nhập tên thức ăn nhanh: ");
        String foodName = scanner.nextLine();

        System.out.println("Nhập kích thước: (small/medium/big) ");
        String size = scanner.nextLine();
        System.out.println("Nhập giá tiền:  ");
        Double price = scanner.nextDouble();
        String productionDate;
        while(true){
            System.out.println("Nhập ngày sản xuất: (định dạng yyyy-mm-dd)");
            productionDate = scanner.next();
            if(productionDate.length()<10){
                System.out.println("Sai Định Dạng");
            }else {
                String [] b= productionDate.split("");
                if(!b[4].equals("-") && !b[7].equals("-")){
                    System.out.println("Sai định dạng s");
                    System.out.println(b[4]);
                }else {
                    break;
                }
            }
        }
        String expDate;
        while(true){
            System.out.println("Nhập hạn sử dụng: (định dạng yyyy-mm-dd)");
            expDate = scanner.next();
            if(expDate.length()<10){
                System.out.println("Sai Định Dạng");
            }else {
                String [] b= expDate.split("");
                if(!b[4].equals("-") && !b[7].equals("-")){
                    System.out.println("Sai định dạng s");
                    System.out.println(b[4]);
                }else {
                    break;
                }
            }
        }
        FastFoods fastFood = new FastFoods(id,foodName,price,size,LocalDate.parse(productionDate),LocalDate.parse(expDate));
        fastFoods.add(fastFood);
        cinemaFile.writeListFastFood(fastFoods);
        System.out.println("Thêm thành công");
        System.out.println("Nhập vào bất kỳ để tiếp tục!");
        String next = scanner.next();
    }  // done
    public void editFastFoodByEmployee(){
        System.out.println("Danh sách thức ăn nhanh!");
        for(int i = 0;i<fastFoods.size();i++){
            System.out.println("Mã thức ăn nhanh: " + fastFoods.get(i).getID()
                    + " Tên thức ăn nhanh: " + fastFoods.get(i).getFoodName()
                    +" Kích thước: " + fastFoods.get(i).getSize()
            );
        }
        System.out.println("Nhập mã thức ăn cần chỉnh sửa: ");
        String code = scanner.next();
        boolean checkID = false;
        for (int i = 0;i<fastFoods.size();i++){
            if(fastFoods.get(i).getID().equals(code)){
                System.out.println("Nhập tên thức ăn nhanh: ");
                String foodName = scanner.nextLine();
                foodName = scanner.nextLine();
                System.out.println("Nhập kích thước: (small/medium/big)");
                String size = scanner.nextLine();
                System.out.println("Nhập giá tiền: ");
                double price = scanner.nextDouble();
                String productionDate;
                while(true){
                    System.out.println("Nhập ngày sản xuất: (định dạng yyyy-mm-dd)");
                    productionDate = scanner.next();
                    if(productionDate.length()<10){
                        System.out.println("Sai Định Dạng");
                    }else {
                        String [] b= productionDate.split("");
                        if(!b[4].equals("-") && !b[7].equals("-")){
                            System.out.println("Sai định dạng s");
                            System.out.println(b[4]);
                        }else {
                            break;
                        }
                    }
                }
                String expDate;
                while(true){
                    System.out.println("Nhập hạn sử dụng: (định dạng yyyy-mm-dd)");
                    expDate = scanner.next();
                    if(expDate.length()<10){
                        System.out.println("Sai Định Dạng");
                    }else {
                        String [] b= expDate.split("");
                        if(!b[4].equals("-") && !b[7].equals("-")){
                            System.out.println("Sai định dạng s");
                            System.out.println(b[4]);
                        }else {
                            break;
                        }
                    }
                }
                fastFoods.get(i).setFoodName(foodName);
                fastFoods.get(i).setSize(size);
                fastFoods.get(i).setPrice(price);
                fastFoods.get(i).setProductionDate(LocalDate.parse(productionDate));
                fastFoods.get(i).setExpirationDate(LocalDate.parse(expDate));
                cinemaFile.writeListFastFood(fastFoods);
                System.out.println("Chỉnh sửa thành công");

                checkID = true;
                break;
            }
        }

        if(!checkID){
            System.out.println("Mã vừa nhập không chính xác");
        }
        System.out.println("Nhập vào một ký tự bất kỳ để tiếp tục");
        String next = scanner.next();
    }  // done
    public void deleteFastFoodByEmployee(){
        for(int i = 0;i<fastFoods.size();i++){
            System.out.println("Mã thức ăn nhanh: " + fastFoods.get(i).getID()
                    + " Tên thức ăn nhanh: " + fastFoods.get(i).getFoodName()
                    +" Kích thước: " + fastFoods.get(i).getSize()
            );
        }
        System.out.println("Nhập mã thức ăn cần xóa: ");
        String code = scanner.next();
        boolean checkID = false;
        for (int i = 0;i<fastFoods.size();i++){
            if(fastFoods.get(i).getID().equals(code)){
                fastFoods.remove(i);
                cinemaFile.writeListFastFood(fastFoods);
                System.out.println("Xóa thành công!");
                checkID = true;
                break;
            }
        }

        if(!checkID){
            System.out.println("Mã vừa nhập không chính xác");
        }
        System.out.println("Nhập vào một ký tự bất kỳ để tiếp tục ");
        String next = scanner.next();
    }  //done

    public void addDrinksByEmployee(){
        String id;
        while(true){
            id = "dr"+ createID();
            boolean checkID = false;
            for(int i = 0;i<drinks.size();i++){
                if(drinks.get(i).getID().equals(id)){
                    checkID = true;
                }
            }
            if(!checkID){
                break;
            }
        }
        scanner.nextLine();
        System.out.println("Nhập tên nước uống: ");
        String foodName = scanner.nextLine();
        System.out.println("Nhập thể tích: (small/medium/big) ");
        String size = scanner.nextLine();
        System.out.println("Nhập giá tiền:  ");
        double price = scanner.nextDouble();
        String productionDate;
        while(true){
            System.out.println("Nhập ngày sản xuất: (định dạng yyyy-mm-dd)");
            productionDate = scanner.next();
            if(productionDate.length()<10){
                System.out.println("Sai Định Dạng");
            }else {
                String [] b= productionDate.split("");
                if(!b[4].equals("-") && !b[7].equals("-")){
                    System.out.println("Sai định dạng s");
                    System.out.println(b[4]);
                }else {
                    break;
                }
            }
        }
        String expDate;
        while(true){
            System.out.println("Nhập hạn sử dụng: (định dạng yyyy-mm-dd)");
            expDate = scanner.next();
            if(expDate.length()<10){
                System.out.println("Sai Định Dạng");
            }else {
                String [] b= expDate.split("");
                if(!b[4].equals("-") && !b[7].equals("-")){
                    System.out.println("Sai định dạng s");
                    System.out.println(b[4]);
                }else {
                    break;
                }
            }
        }
        Drinks drink = new Drinks(id,foodName,price,size,LocalDate.parse(productionDate),LocalDate.parse(expDate));
        drinks.add(drink);

        cinemaFile.writeListDrinks(drinks);
        System.out.println("Thêm thành công");
        System.out.println("Nhập vào bất kỳ để tiếp tục!");
        String next = scanner.next();
    }   // done
    public void editDrinksByEmployee(){
        System.out.println("Danh sách nước uống!");
        for(int i = 0;i<drinks.size();i++){
            System.out.println("Mã nước uống: " + drinks.get(i).getID()
                    + " Tên nước uống: " + drinks.get(i).getFoodName()
                    +" Thể tích: " + drinks.get(i).getVolume()
            );
        }
        System.out.println("Nhập mã nước uống cần chỉnh sửa: ");
        String code = scanner.next();
        boolean checkID = false;
        for (int i = 0;i<drinks.size();i++){
            if(drinks.get(i).getID().equals(code)){
                System.out.println("Nhập tên nước uống: ");
                String drinksName = scanner.nextLine();
                drinksName = scanner.nextLine();
                System.out.println("Nhập kích thước: (small/medium/big)");
                String volume = scanner.nextLine();
                System.out.println("Nhập giá tiền: ");
                double price = scanner.nextDouble();
                String productionDate;
                while(true){
                    System.out.println("Nhập ngày sản xuất: (định dạng yyyy-mm-dd)");
                    productionDate = scanner.next();
                    if(productionDate.length()<10){
                        System.out.println("Sai Định Dạng");
                    }else {
                        String [] b= productionDate.split("");
                        if(!b[4].equals("-") && !b[7].equals("-")){
                            System.out.println("Sai định dạng s");
                            System.out.println(b[4]);
                        }else {
                            break;
                        }
                    }
                }
                String expDate;
                while(true){
                    System.out.println("Nhập hạn sử dụng: (định dạng yyyy-mm-dd)");
                    expDate = scanner.next();
                    if(expDate.length()<10){
                        System.out.println("Sai Định Dạng");
                    }else {
                        String [] b= expDate.split("");
                        if(!b[4].equals("-") && !b[7].equals("-")){
                            System.out.println("Sai định dạng s");
                            System.out.println(b[4]);
                        }else {
                            break;
                        }
                    }
                }
                drinks.get(i).setFoodName(drinksName);
                drinks.get(i).setVolume(volume);
                drinks.get(i).setPrice(price);
                drinks.get(i).setProductionDate(LocalDate.parse(productionDate));
                drinks.get(i).setExpirationDate(LocalDate.parse(expDate));
                cinemaFile.writeListDrinks(drinks);
                System.out.println("Chỉnh sửa thành công");

                checkID = true;
                break;
            }
        }

        if(!checkID){
            System.out.println("Mã vừa nhập không chính xác");
        }
        System.out.println("Nhập vào một ký tự bất kỳ để tiếp tục");
        String next = scanner.next();
    }  //done
    public void deleteDrinksByEmployee(){
        for(int i = 0;i<drinks.size();i++){
            System.out.println("Mã nước uống: " + drinks.get(i).getID()
                    + " Tên nước uống: " + drinks.get(i).getFoodName()
                    +" Thể tích : " + drinks.get(i).getVolume()
            );
        }
        System.out.println("Nhập mã nước uống cần xóa: ");
        String code = scanner.next();
        boolean checkID = false;
        for (int i = 0;i<drinks.size();i++){
            if(drinks.get(i).getID().equals(code)){
                drinks.remove(i);
                cinemaFile.writeListDrinks(drinks);
                System.out.println("Xóa thành công!");
                checkID = true;
                break;
            }
        }

        if(!checkID){
            System.out.println("Mã vừa nhập không chính xác");
        }
        System.out.println("Nhập vào một ký tự để tiếp tục");
        String next = scanner.next();
    } //done

}
