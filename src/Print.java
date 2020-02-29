import java.util.Scanner;
public class Print {
    Calendar c = new Calendar();
    Scanner s = new Scanner(System.in);

    public void getinformation() {
        int year = 1;
        int month = 1;
        int day = 0;
        int inputday = 1;

        while (year > 0 && (month > 0 && month <13)){
            year = c.getYear();
            if(year > 0) {
                month = c.getMonth();
                if(month < 13 && month > 0) {
                    day = c.getday(year, month);
                    System.out.println("");
                    if (true) {
                        //System.out.println("일을 입력하세요.");
                        //System.out.println("DAYS > ");
                        //inputday = s.nextInt();
                        //System.out.println("");
                        System.out.printf("%d 월은 %d 일까지 있습니다.", month, day);
                        System.out.println("");
                        c.printCalendar(year, month, day);

                    }
                }
                else{
                    System.out.println("bye~");
                }
            }
            else{
                System.out.println("bye~");
            }

        }

    }
}
