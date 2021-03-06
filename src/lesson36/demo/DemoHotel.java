package lesson36.demo;

import lesson36.Utils.Utils;
import lesson36.controller.HotelController;

import lesson36.model.Hotel;


import lesson36.repository.UserRepository;



public class DemoHotel {
    public static void main(String[] args) throws Exception {
        Hotel hotel = new Hotel();
        HotelController hotelController = new HotelController();
        UserRepository userRepository = new UserRepository(Utils.pathByUserFile, Utils.koefByUserId, Utils.numberElementInLineUser);
        //System.out.println(user.enterDataByKeyboard().toString());

        String name = Utils.readKeyboardWithScannerString("User: ");
        String password = Utils.readKeyboardWithScannerString("password: ");

        userRepository.login(name, password);

      //   System.out.println(hotelController.addHotel(new Hotel().enterDataByKeyboard()).toString());

      System.out.println(hotelController.deleteHotel(Utils.readKeyboardWithScannerLong("Id:= ")));


       //System.out.println(hotelController.findHotelByName(Utils.readKeyboardWithScannerString("Name :")).toString());

        //   System.out.println(hotelController.findHotelByCity(Utils.readKeyboardWithScannerString("City :")).toString());

        //HotelRepository hotelRepository = new HotelRepository("c:/Temp/Room.txt", 100, 5, null);

        //hotelRepository.validateFormatFile();

    }


}