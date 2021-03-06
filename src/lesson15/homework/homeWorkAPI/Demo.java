package lesson15.homework.homeWorkAPI;

import java.util.Date;

public class Demo {
    public static void main(String[] args) {
        int[] arrayExample = {10, 32, 1, 87, 3, 98};

        Room[] rooms = roomAraryInit();
        Room[] rooms_rev2 = roomAraryInit_Rev2();

        BookingComAPI bookingComAPI = new BookingComAPI(rooms);
        GoogleAPI googleAPI = new GoogleAPI(rooms);
        TripAdvisorAPI tripAdvisorAPI = new TripAdvisorAPI(rooms_rev2);

        sysoutRoomsArray(rooms);

        System.out.println(" Тестуємо bookingComAPI.findRooms");
        System.out.println("bookingComAPI.findRooms(300, 1, Zvolen, Almada )");
        sysoutRoomsArray(bookingComAPI.findRooms(300, 1, "Zvolen", "Almada"));
        System.out.println(" Передаємо якусь нісенітницію ");
        sysoutRoomsArray(bookingComAPI.findRooms(0,9,"dfd", "sdf"));
        System.out.println(" ");
        System.out.println(" Тестуємо google API повна відповідність кімнати ");
        System.out.println(" googleAPI.findRooms(300, 1, Zvolen, Almada");
        sysoutRoomsArray(googleAPI.findRooms(300, 1, "Zvolen", "Almada"));
        System.out.println(" ");
        System.out.println(" Тестуємо tripAdvisorAPI.findRooms (300, 1, Zvolen, Almada");
        sysoutRoomsArray(tripAdvisorAPI.findRooms(300, 1, "Zvolen", "Almada"));
        System.out.println(" ");

        API[] apis = {bookingComAPI, googleAPI, tripAdvisorAPI};

        Controller controller = new Controller(apis);
        API[] apis1 = controller.getApis();
        System.out.println("~~Заповнюємо масив API  і виводимо значення елементів ~~~");
        sysoutRoomsArray(apis1[0].findRooms(300, 1, "Zvolen", "Almada"));
        sysoutRoomsArray(apis1[1].findRooms(300, 1, "Zvolen", "Almada"));
        sysoutRoomsArray(apis1[2].findRooms(300, 1, "Zvolen", "Almada"));
        System.out.println("~~~Тестуємо controller.requestRooms це має бути масив що складаємться з елементів масивів після виконання послідовно функцій класів googleAPI, tripAdvisorAPI, bookingComAPI~~~~~~~~~~~~");
        sysoutRoomsArray(controller.requestRooms(300, 1, "Zvolen", "Almada"));
        System.out.println("------------ Пробуем сheck виводимо спільні елементи масивів---------------");
        sysoutRoomsArray(controller.check(apis1[0], apis1[2]));

    }

    public static Room[] roomAraryInit() {
        Room[] res = new Room[10];

        Date Date1 = new Date(2018, 05, 05);
        Date Date2 = new Date(2018, 05, 13);
        Date Date3 = new Date(2018, 05, 15);
        Date Date4 = new Date(2018, 05, 8);

        //Room onePersonStandart = new Room()
        res[0] = new Room(1, 400, 2, Date1, "Almada", "Zvolen");
        res[1] = new Room(2, 300, 2, Date2, "Almada", "Zvolen");
        res[2] = new Room(3, 550, 3, Date1, "Almada", "Zvolen");
        res[3] = new Room(4, 300, 1, Date3, "Almada", "Zvolen");
        res[4] = new Room(5, 660, 3, Date1, "Truskavez", "Truskavez");
        res[5] = new Room(6, 300, 2, Date4, "Truskavez", "Truskavez");
        res[6] = new Room(7, 350, 2, Date4, "Truskavez", "Truskavez");
        res[7] = new Room(8, 700, 4, Date1, "Truskavez", "Trusckavez");
        res[8] = new Room(9, 500, 3, Date2, "Sport", "Zaporogje");
        res[9] = new Room(10, 300, 2, Date4, "Sport", "Zaporogje");

        return res;

    }

    public static Room[] roomAraryInit_Rev2() {
        Room[] res = new Room[10];

        Date Date1 = new Date(2018, 05, 05);
        Date Date2 = new Date(2018, 05, 13);
        Date Date3 = new Date(2018, 05, 15);
        Date Date4 = new Date(2018, 05, 8);

        //Room onePersonStandart = new Room()
        res[0] = new Room(1, 400, 2, Date1, "Helth", "Brarislava");
        res[1] = new Room(2, 300, 2, Date2, "Almada", "Zvolen");
        res[2] = new Room(3, 550, 3, Date1, "Almada", "Zvolen");
        res[3] = new Room(4, 300, 1, Date3, "Almada", "Zvolen");
        res[4] = new Room(5, 660, 3, Date1, "Truskavez", "Truskavez");
        res[5] = new Room(6, 300, 2, Date4, "Truskavez", "Truskavez");
        res[6] = new Room(7, 350, 2, Date4, "Truskavez", "Truskavez");
        res[7] = new Room(8, 700, 4, Date1, "Truskavez", "Trusckavez");
        res[8] = new Room(9, 500, 3, Date2, "Sport", "Zaporogje");
        res[9] = new Room(10, 300, 2, Date4, "Bimba", "Moscow");

        return res;

    }

    public static void sysoutRoomsArray(Room[] data) {

        if (data != null) {
            for (Room element : data) {
                if (element != null) element.sysoutRoomsData();
                else System.out.println("null");
            }
        }
    }
}
