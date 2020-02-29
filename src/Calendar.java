import java.util.Scanner;
public class Calendar {
    private int[] weekday = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private int[] weekday_leap = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public int getYear(){
        Scanner s = new Scanner(System.in);
        System.out.println("년도를 입력하세요.");
        System.out.print("YEAR > ");
        int year = s.nextInt();
        System.out.println("");

        return year;
    }

    public int getMonth(){
        Scanner s = new Scanner(System.in);
        System.out.println("월을 입력하세요.");
        System.out.print("MONTH > ");
        int month = s.nextInt();
        System.out.println("");

        return month;
    }

    public int getday(int year, int month){
        if((year % 4 == 0 && year % 100 != 0) || year % 400 == 0){
            return weekday_leap[month - 1];
        }
        else{
            return weekday[month - 1];
        }
    }

    public boolean leapyear(int year){
        if((year % 4 == 0 && year % 100 != 0) || year % 400 == 0){
            return true;
        }
        else{
            return false;
        }
    }

    public void printCalendar(int year, int month, int day){
        int syear = 1900;
        int smonth = 1;
        int sday = 1;
        int sweekday = 1; // 1900.1.1 Monday

        int resultweekday;

        System.out.println(year+"년  "+month+"일");
        System.out.println(" 일    월     화    수    목    금    토");
        System.out.println("---------------------------------------");

        int count = 0; //일자 종합
        //연도 계산
        for(int i = syear; i < year; i++){
            if(leapyear(i) == true){
                count = count + 366;
            }
            else{
                count = count + 365;
            }
        }
        //월 계산
        for(int i = smonth; i < month; i++){
            count = count + getday(year, i);
        }
        //일 계산
        //for(int i = sday; i < day; i++){
        //    count = count + day;
        //}

        //요일 계산
        resultweekday = (count + sweekday) % 7;

        //달력출력
        int a = 7 - resultweekday;
        for(int i = 1; i <= resultweekday; i++){
            System.out.print("      ");
        }
        for(int i = 1; i <= a; i++){
            System.out.printf("%3d   ", i);
        }
        System.out.println("");
        for(int i = a+1; i <= day; i++){
            System.out.printf("%3d   ", i);
            if((i+resultweekday) % 7 == 0){
                System.out.printf("\n");
            }
        }

        System.out.println("");
        System.out.println("");
    }
}
