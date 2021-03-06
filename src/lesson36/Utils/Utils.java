package lesson36.Utils;


import java.io.*;
import java.util.Date;
import java.util.Scanner;

public class Utils {
    public static final String pathByHotelFile = "c:/Temp/Hotel.txt";
    public static final String pathByRoomFile = "c:/Temp/Room.txt";
    public static final String pathByUserFile = "c:/Temp/User.txt";
    public static final String pathByOrderFile = "c:/Temp/Order.txt";
    public static final int koefByHotelId = 1000;
    public static final int koefByRoomId = 100;
    public static final int koefByUserId = 10;
    public static final int koefByOrderId = 10000;
    public static final int numberElementInLineHotel = 5;
    public static final int numberElementInLineRoom = 7;
    public static final int numberElementInLineUser = 5;
    public static final int numberElementInLineOrder = 6;


    private static Scanner in = new Scanner(System.in);

    public static long readKeyboardWithScannerLong(String prefStr) {
        Scanner scanner = new Scanner(System.in);

        //usinscanner
        System.out.print(prefStr);
        Long lng = in.nextLong();
        return lng;
    }

    public static String readKeyboardWithScannerString(String prefStr) {
        //Scanner scanner = new Scanner(System.in);
        System.out.print(prefStr);
        String str = new String();

        str = in.next();

        return str;

    }

    public static void GetScores() {
        in.close();
    }


    public static String readFromKeyboardString(String prefStr) {


        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(reader);

        String str = new String();
        try {
            System.out.print(prefStr);
            str = br.readLine();


        } catch (IOException e) {
            System.err.println("readFromKeyboardString: Reading from keyboard failed " + prefStr);
        } finally {

            System.out.println("Без осовобождения ресурсов");
        }
        return str;
    }


    public static Date dateMapping(String inputString) throws Exception {
        String[] array = inputString.split("-");
        if (array.length != 3)
            throw new Exception("dateMapping: input data is faild");
        return new Date(Integer.parseInt(array[2]) - 1900, Integer.parseInt(array[1]) - 1, Integer.parseInt(array[0]));
    }


}



