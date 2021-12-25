package model;

import controller.CinemaFile;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class StatisticalCinemaTicket implements Statistical{
    public Scanner scanner = new Scanner(System.in);
    List<CinemaTickets> cinemaTickets;
    private CinemaFile cinemaFile;
    public StatisticalCinemaTicket(){
        this.cinemaFile = new CinemaFile();
        this.cinemaTickets = cinemaFile.readCinemaTicketFile();
    }


    @Override
    public void StatisticalDay() {
        System.out.println("Thống kê vé xem phim theo ngày");
        System.out.println("Vui lòng nhập ngày cần xem: ");
        String date;

        while(true){
            System.out.println("Nhập ngày cần thống kê (định dạng yyyy-mm-dd)");
            date = scanner.next();
            if(date.length()<10){
                System.out.println("Sai Định Dạng");
            }else {
                String [] b= date.split("");
                if(!b[4].equals("-") && !b[7].equals("-")){
                    System.out.println("Sai định dạng s");
                    System.out.println(b[4]);
                }else {
                    break;
                }
            }
        }
        int quantity = 0;
        double turnover = 0;
        String seatCode = "";
        for(int i = 0;i<cinemaTickets.size();i++){
            if(cinemaTickets.get(i).getDateShow().equals(LocalDate.parse(date))){
                quantity++;
                turnover = turnover + cinemaTickets.get(i).getPrice();

            }
        }
        System.out.println("Số vé bán được: " + quantity);
        System.out.println("Doanh thu trong ngày: " + turnover);

    }

    @Override
    public void StatisticalMonth() {
        System.out.println("Thống kê vé xem phim theo tháng");

        String month;
        while(true){
            System.out.println("Nhập tháng cần xem thông tin: (mm-yyyy) ");
            month = scanner.next();
            if(month.length()<7){
                System.out.println("Sai Định Dạng");
            }else {
                String [] b= month.split("");
                if(!b[2].equals("-")){
                    System.out.println("Sai định dạng");
                }else {
                    break;
                }
            }
        }
        int quantity = 0;
        double turnover = 0;
        for(int i = 0;i<cinemaTickets.size();i++){
            String temp = cinemaTickets.get(i).getDateShow().toString();
            String [] temp2 = temp.split("-");
            temp = temp2[1]+"-"+temp2[0];
            if(month.equals(temp)){
                quantity++;
                turnover += cinemaTickets.get(i).getPrice();
            }
        }
        System.out.println("Doanh thu trong tháng "+month+" là: "+turnover+" VND");
        System.out.println("Số lượng vé bán ra: " + quantity);
    }

    @Override
    public void StatisticalYear() {
        System.out.println("Thống kê vé xem phim theo năm");
        System.out.println("Nhập năm cần xem");
        String year = scanner.next();
        int quantity = 0;
        double turnover = 0;
        for(int i = 0;i<cinemaTickets.size();i++){
            String temp = cinemaTickets.get(i).getDateShow().toString();
            String [] temp2 = temp.split("-");
            temp = temp2[0];
            if(year.equals(temp)){
                quantity++;
                turnover = turnover + cinemaTickets.get(i).getPrice();
            }
        }
        System.out.println("Doanh thu trong năm " + year+" là: "+ turnover);
        System.out.println("Số lượng vé bán được là : " + quantity);
    }
}
