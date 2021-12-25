package controller;

import model.*;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class CinemaFile {
    private String FastFoodsFileName ;
    private String DrinksFileName;
    private String CustomersFileName;
    private String EmployeesFileName;
    private String FilmsFileName;
    private String CinemaTicketsFileName;
    private String ParkingTicketFileName;
    private String SoldFoodFileName;
    private String SoldDrinksFileName;
    private String SoldCinemaTicketFileName;
    private String SoldParkingTicketFileName;
    private String CinemaRoomFileName;
    private String MovieCharFileName;


    public CinemaFile(){
        this.FastFoodsFileName = new File("src/data/fastFood.txt").getAbsolutePath();
        this.DrinksFileName = new File("src/data/drinks.txt").getAbsolutePath();
        this.CustomersFileName = new File("src/data/customer.txt").getAbsolutePath();
        this.EmployeesFileName = new File("src/data/employee.txt").getAbsolutePath();
        this.FilmsFileName = new File("src/data/film.txt").getAbsolutePath();
        this.CinemaTicketsFileName = new File("src/data/cinemaTicket.txt").getAbsolutePath();
        this.ParkingTicketFileName = new File("src/data/parkingTicket.txt").getAbsolutePath();
        this.SoldFoodFileName = new File("src/data/soldFood.txt").getAbsolutePath();
        this.SoldDrinksFileName = new File("src/data/soldDrinks.txt").getAbsolutePath();
        this.SoldCinemaTicketFileName = new File("src/data/soldCinemaTicket.txt").getAbsolutePath();
        this.CinemaRoomFileName = new File("src/data/room.txt").getAbsolutePath();
        this.MovieCharFileName = new File("src/data/movieChar.txt").getAbsolutePath();


    }






    //customer.txt
    public void writeListCustomer(List<Customer> customers){
          try {
              PrintWriter printWriter = new PrintWriter(
                      new FileOutputStream(
                              new File(CustomersFileName),false
                      )
              );

              for (Customer customer : customers) {
                  printWriter.print(customer.getId() +
                          ";" + customer.getLastName() +
                          ";" + customer.getFirstName() +
                          ";" + customer.getUserName() +
                          ";" + customer.getPassword() +
                          ";" + customer.getBirthDay() +
                          ";" + customer.getEmail() +
                          ";" + customer.getLevel() +
                          ";" + customer.getExperience() +
                          ";" + customer.getWallet() +
                          ";;");
                  printWriter.print("\n");
              }
              printWriter.close();

          }catch (Exception e){

          }
    }  // done
    public List<Customer> readCustomer(){
        List<Customer> customers = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(CustomersFileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while(true){
                String line = bufferedReader.readLine();
                if(line == null){
                    break;
                }
                String [] text = line.split(";");
                String ID = text[0];
                String lastName = text[1];
                String firstName = text[2];
                String userName = text[3];
                String password = text[4];
                LocalDate birthDay = LocalDate.parse(text[5]);
                String email = text[6];
                int level = Integer.parseInt(text[7]);
                int experience = Integer.parseInt(text[8]);
                double wallet = Double.parseDouble(text[9]);
                Customer customer = new Customer(ID,lastName,firstName,userName,password,birthDay,email,level,experience,wallet);
                customers.add(customer);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return customers;
    }  // done
    //employee.txt
    public void writeListEmployee(List<Employee> employees)  {
        try {
            PrintWriter printWriter = new PrintWriter(
                    new FileOutputStream(
                            new File(EmployeesFileName),false
                    )
            );
            for (Employee employee : employees) {
                printWriter.println(employee.getId() +
                        ";" + employee.getLastName() +
                        ";" + employee.getFirstName() +
                        ";" + employee.getUserName() +
                        ";" + employee.getPassword() +
                        ";" + employee.getBirthDay() +
                        ";" + employee.getEmail() +
                        ";" + employee.getPosition() +
                        ";" + employee.getSalary() +
                        ";" + employee.getStartDate() +
                        ";");
            }
            printWriter.close();
        }catch (Exception e){

        }


    }  // done
    public List<Employee> readEmployee(){
        List<Employee> employees = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(EmployeesFileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while(true){
                String line = bufferedReader.readLine();
                if(line == null){
                    break;
                }
                String [] text = line.split(";");

                String ID = text[0];
                String lastName = text[1];
                String firstName = text[2];
                String userName = text[3];
                String password = text[4];
                LocalDate birthday = LocalDate.parse(text[5]);
                String email = text[6];
                String position = text[7];
                double salary = Double.parseDouble(text[8]);
                LocalDate startDate = LocalDate.parse(text[9]);
                Employee employee = new Employee(ID,lastName,firstName,userName,password,birthday,email,position,salary,startDate);
                employees.add(employee);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return employees;
    }  //done
    //film.txt
    public void writeListFilm(List<Films>films){
        try {
            PrintWriter printWriter = new PrintWriter(
                    new FileOutputStream(
                            new File(FilmsFileName),false
                    )
            );
            for (Films film : films) {
                printWriter.println(film.getID() +
                        ";" + film.getMovieName() +
                        ";" + film.getMovieDuration() +
                        ";" + film.getMovieGenre() +
                        ";" + film.getPrice() +
                        ";" + film.getRemaining() +
                        ";" + film.getShowTimeStart() +
                        ";" + film.getShowTimeEnd() +
                        ";" + film.getShowDate() +
                        ";" + film.getIDroom() +
                        ";" + film.getMovieRoom() +
                        ";" + film.getShift() +
                        ";");
            }
            printWriter.close();
        }catch (Exception e){

        }
    }  //done
    public List<Films> readFilm(){
        List<Films> films = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(FilmsFileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while(true){
                String line = bufferedReader.readLine();
                if(line == null){
                    break;
                }
                String [] text = line.split(";");

                String ID = text[0];
                String movieName = text[1];
                int movieDuration = Integer.parseInt(text[2]);
                String movieGenre = text[3];
                double price = Double.parseDouble(text[4]);
                int remaining = Integer.parseInt(text[5]);
                LocalTime showTimeStart = LocalTime.parse(text[6]);
                LocalTime showTimeEnd = LocalTime.parse(text[7]);
                LocalDate showDate = LocalDate.parse(text[8]);
                String IDroom = text[9];
                String movieRoom = text[10];
                int shift = Integer.parseInt(text[11]);
                Films film = new Films(ID,movieName,movieDuration,movieGenre,price,remaining,showTimeStart,showTimeEnd,showDate,IDroom,movieRoom,shift);
                films.add(film);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return films;
    }  // done
    //fastFood.txt
    public void writeListFastFood(List<FastFoods> fastFoods){
        try {
            PrintWriter printWriter = new PrintWriter(
                    new FileOutputStream(
                            new File(FastFoodsFileName),false
                    )
            );

            for (FastFoods fastFood : fastFoods) {
                printWriter.print(fastFood.getID() +
                        ";" + fastFood.getFoodName() +
                        ";" + fastFood.getPrice() +
                        ";" + fastFood.getSize() +
                        ";" + fastFood.getProductionDate() +
                        ";" + fastFood.getExpirationDate() +
                        ";;");
                printWriter.print("\n");
            }
            printWriter.close();
        }catch (Exception e){
        }
    }  // done
    public List<FastFoods> readFastFood(){
        List<FastFoods> fastFoods = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(FastFoodsFileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while(true){
                String line = bufferedReader.readLine();
                if(line == null){
                    break;
                }
                String [] text = line.split(";");
                String ID = text[0];
                String foodName = text[1];
                double price = Double.parseDouble(text[2]);
                String size = text[3];
                LocalDate productionDate = LocalDate.parse(text[4]);
                LocalDate expirationDate = LocalDate.parse(text[5]);

                FastFoods fastFood = new FastFoods(ID,foodName,price,size,productionDate,expirationDate);
                fastFoods.add(fastFood);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return fastFoods;
    }  // done
    //drinks.txt
    public void writeListDrinks(List<Drinks> drinks){
        try {
            PrintWriter printWriter = new PrintWriter(
                    new FileOutputStream(
                            new File(DrinksFileName),false
                    )
            );

            for (Drinks drink : drinks) {
                printWriter.print(drink.getID() +
                        ";" + drink.getFoodName() +
                        ";" + drink.getPrice() +
                        ";" + drink.getVolume() +
                        ";" + drink.getProductionDate() +
                        ";" + drink.getExpirationDate() +
                        ";;");
                printWriter.print("\n");
            }
            printWriter.close();
        }catch (Exception e){
        }
    }       // done
    public List<Drinks> readDrinks(){
        List<Drinks> drinks = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(DrinksFileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while(true){
                String line = bufferedReader.readLine();
                if(line == null){
                    break;
                }
                String [] text = line.split(";");

                String ID = text[0];
                String foodName = text[1];
                double price = Double.parseDouble(text[2]);
                String size = text[3];
                LocalDate productionDate = LocalDate.parse(text[4]);
                LocalDate expirationDate = LocalDate.parse(text[5]);

                Drinks drink = new Drinks(ID,foodName,price,size,productionDate,expirationDate);
                drinks.add(drink);

            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return drinks;
    }   // done

    //cinemaTicket.txt
    public void writeListCinemaTicket(List<CinemaTickets> cinemaTickets) {
        try {
            PrintWriter printWriter = new PrintWriter(
                    new FileOutputStream(
                            new File(CinemaTicketsFileName),false
                    )
            );

            for (CinemaTickets cinemaTicket : cinemaTickets) {
                printWriter.print(cinemaTicket.getID() +
                        ";" + cinemaTicket.getMovieName() +
                        ";" + cinemaTicket.getIDCustomer() +
                        ";" + cinemaTicket.getCustomerName() +

                        ";" + cinemaTicket.getSeatCode() +
                        ";" + cinemaTicket.getMovieRoom() +
                        ";" + cinemaTicket.getPrice() +
                        ";" + cinemaTicket.getDateShow() +
                        ";" + cinemaTicket.getTimeShow() +
                        ";" + cinemaTicket.getTimebuy() +
                        ";" + cinemaTicket.getPurchaseDate() +
                        ";;");
                printWriter.print("\n");
            }
            printWriter.close();
        }catch (Exception e){
        }
    }  // done
    public List<CinemaTickets> readCinemaTicketFile(){
        List<CinemaTickets> cinemaTickets = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(CinemaTicketsFileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while(true){
                String line = bufferedReader.readLine();
                if(line == null){
                    break;
                }
                String [] text = line.split(";");
                String ID = text[0];
                String movieName = text[1];
                String IDCustomer = text[2];
                String CustomerName = text[3];
                String seatCode = text[4];
                String movieRoom = text[5];
                double price = Double.parseDouble(text[6]);
                LocalDate dateShow = LocalDate.parse(text[7]);
                LocalTime timeShow = LocalTime.parse(text[8]);
                CinemaTickets cinemaTicket = new CinemaTickets(ID,movieName,IDCustomer,CustomerName,seatCode,movieRoom,price,dateShow,timeShow);
                cinemaTicket.setTimebuy(LocalTime.parse(text[9]));
                cinemaTicket.setPurchaseDate(LocalDate.parse(text[10]));
                cinemaTickets.add(cinemaTicket);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return cinemaTickets;
    }  // done
    // parkingTicket.txt
    public void writeListParkingTicket(List<ParkingTickets> parkingTickets){
        try {
            PrintWriter printWriter = new PrintWriter(
                    new FileOutputStream(
                            new File(ParkingTicketFileName),false
                    )
            );

            for (ParkingTickets parkingTicket : parkingTickets) {
                printWriter.print(parkingTicket.getIdTicket() +
                        ";" + parkingTicket.getVehicleType() +
                        ";" + parkingTicket.getNumberPlate() +
                        ";" + parkingTicket.getCustomerID() +
                        ";" + parkingTicket.getCustomerName() +
                        ";" + parkingTicket.getDateIn() +
                        ";" + parkingTicket.getTimeIn() +
                        ";;");
                printWriter.print("\n");
            }
            printWriter.close();
        }catch (Exception e){
        }
    } // done
    public List<ParkingTickets> readParkingTicket(){
        List<ParkingTickets> parkingTickets = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(ParkingTicketFileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while(true){
                String line = bufferedReader.readLine();
                if(line == null){
                    break;
                }
                String [] text = line.split(";");

                String ID = text[0];
                String vehicleType = text[1];
                String numberPlate = text[2];
                String customerID = text[3];
                String customerName = text[4];
                LocalDate dateIn = LocalDate.parse(text[5]);
                LocalTime timeIn = LocalTime.parse(text[6]);
                ParkingTickets parkingTicket = new ParkingTickets(ID,vehicleType,numberPlate,customerID,customerName,dateIn,timeIn);
                parkingTickets.add(parkingTicket);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return parkingTickets;
    }  // done

    //soldFood.txt
    public void writeListSoldFastFood(List<StatisticalFastFood> statisticalFastFoods){
        try {
            PrintWriter printWriter = new PrintWriter(
                    new FileOutputStream(
                            new File(SoldFoodFileName),false
                    )
            );
            for (StatisticalFastFood statisticalFastFood : statisticalFastFoods) {
                printWriter.print(statisticalFastFood.getID() +
                        ";" + statisticalFastFood.getFoodID() +
                        ";" + statisticalFastFood.getFoodname() +
                        ";" + statisticalFastFood.getSize() +
                        ";" + statisticalFastFood.getPrice() +
                        ";" + statisticalFastFood.getCustomerID() +
                        ";" + statisticalFastFood.getCustomerName() +
                        ";" + statisticalFastFood.getPurchaseDate() +
                        ";" + statisticalFastFood.getTimeDate() +

                        ";;");
                printWriter.print("\n");
            }
            printWriter.close();

        }catch (Exception e){

        }
    }  // done
    public List<StatisticalFastFood> readStatisticalFastFood(){
        List<StatisticalFastFood> statisticalFastFoods = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(SoldFoodFileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while(true){
                String line = bufferedReader.readLine();
                if(line == null){
                    break;
                }

                String [] text = line.split(";");
                String ID = text[0];
                String foodID = text[1];
                String foodName = text[2];
                String size = text[3];
                Double price = Double.parseDouble(text[4]);
                String customerName = text[5];
                String customerID = text[6];
                LocalDate purchaseDate = LocalDate.parse(text[7]);
                LocalTime timeDate = LocalTime.parse(text[8]);
                StatisticalFastFood statisticalFastFood = new StatisticalFastFood(ID,foodID,foodName,size,price,customerName,customerID);
                statisticalFastFood.setTimeDate(timeDate);
                statisticalFastFood.setPurchaseDate(purchaseDate);
                statisticalFastFoods.add(statisticalFastFood);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return statisticalFastFoods;
    } // done

    //soldDrinks.txt
    public void writeListSoldDrink(List<StatisticalDrinks> statisticalDrinks){
        try {
            PrintWriter printWriter = new PrintWriter(
                    new FileOutputStream(
                            new File(SoldDrinksFileName),false
                    )
            );
            for (StatisticalDrinks statisticalDrink : statisticalDrinks) {
                printWriter.print(statisticalDrink.getID() +
                        ";" + statisticalDrink.getDrinksID() +
                        ";" + statisticalDrink.getDrinksName() +


                        ";" + statisticalDrink.getVolume() +
                        ";" + statisticalDrink.getPrice() +
                        ";" + statisticalDrink.getCustomerID() +
                        ";" + statisticalDrink.getCustomerName() +
                        ";" + statisticalDrink.getPurchaseDate() +
                        ";" + statisticalDrink.getTimeDate() +

                        ";;");
                printWriter.print("\n");
            }
            printWriter.close();

        }catch (Exception e){

        }
    }   // done
    public List<StatisticalDrinks> readStatisticalDrinks(){
        List<StatisticalDrinks> statisticalDrinks = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(SoldDrinksFileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while(true){
                String line = bufferedReader.readLine();
                if(line == null){
                    break;
                }
                String [] text = line.split(";");
                String ID = text[0];
                String drinksID = text[1];
                String drinksName = text[2];
                String volume = text[3];
                double price = Double.parseDouble(text[4]);
                String customerID = text[5];
                String customerName = text[6];
                LocalDate purchaseDate = LocalDate.parse(text[7]);
                LocalTime timeDate = LocalTime.parse(text[8]);
                StatisticalDrinks statisticalDrink = new StatisticalDrinks(ID,drinksID,drinksName,volume,price,customerID,customerName);
                statisticalDrink.setPurchaseDate(purchaseDate);
                statisticalDrink.setTimeDate(timeDate);
                statisticalDrinks.add(statisticalDrink);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return statisticalDrinks;
    }  // done

    // movieChar.txt
    public void writeListMovieChar(List<MovieChair> movieChairs){
        try {
            PrintWriter printWriter = new PrintWriter(
                    new FileOutputStream(
                            new File(MovieCharFileName),false
                    )
            );
            for (MovieChair movieChair : movieChairs) {
                printWriter.print(
                        movieChair.getIDMovie() +
                        ";" +movieChair.getSeatCode() +
                        ";;");
                printWriter.print("\n");
            }
            printWriter.close();

        }catch (Exception e){

        }
    }
    public List<MovieChair> readListMovieChar(){
        List<MovieChair> movieChairs = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(MovieCharFileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while(true){
                String line = bufferedReader.readLine();
                if(line == null){
                    break;
                }
                String [] text = line.split(";");
                String IDMovie = text[0];
                String seatCode = text[1];
                MovieChair movieChair = new MovieChair(IDMovie,seatCode);
                movieChairs.add(movieChair);

            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return movieChairs;
    }
    //room.txt
    public void writeListRoom(List<CinemaRoom> cinemaRooms){
        try {
            PrintWriter printWriter = new PrintWriter(
                    new FileOutputStream(
                            new File(CinemaRoomFileName),false
                    )
            );
            for (CinemaRoom cinemaRoom : cinemaRooms) {
                printWriter.print(cinemaRoom.getID() +
                        ";" +cinemaRoom.getRoomName() +
                        ";" + cinemaRoom.getShift1() +
                        ";" + cinemaRoom.getShift2() +
                        ";" + cinemaRoom.getShift3() +
                        ";" + cinemaRoom.getShift4() +
                        ";" + cinemaRoom.getShift5() +
                        ";" + cinemaRoom.getShift6() +
                        ";" + cinemaRoom.getDate() +
                        ";;");
                printWriter.print("\n");
            }
            printWriter.close();

        }catch (Exception e){

        }
    }
    public List<CinemaRoom> readCinemaRoom(){
        List<CinemaRoom> cinemaRooms = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(CinemaRoomFileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while(true){
                String line = bufferedReader.readLine();
                if(line == null){
                    break;
                }
                String [] text = line.split(";");
                String ID = text[0];
                String roomName = text[1];
                String shift1 = text[2];
                String shift2 = text[3];
                String shift3 = text[4];
                String shift4 = text[5];
                String shift5 = text[6];
                String shift6 = text[7];
                LocalDate date = LocalDate.parse(text[8]);
                CinemaRoom cinemaRoom = new CinemaRoom(ID,roomName,shift1,shift2,shift3,shift4,shift5,shift6,date);
                cinemaRooms.add(cinemaRoom);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return cinemaRooms;
    }






}
