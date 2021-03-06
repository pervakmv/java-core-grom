package lesson11.HomeWork;



public class BookingComAPI implements API {
    private Room[] rooms;

    public BookingComAPI(Room[] rooms) {
        this.rooms = rooms;
    }

    @Override
    public Room[] findRooms(int price, int persons, String city, String hotel) {


        Room[] findRoomsArray = new Room[rooms.length];
        int i = 0;
        for (Room element : rooms) {
            if (element != null) {
                if ((element.getPersons() == persons) &&
                        element.getCityName() == city &&
                        element.getHotelName() == hotel&&
                        element.intAbs((element.getPrice()- price))<=100) {
                    findRoomsArray[i] = element;
                    i++;
                }
            }
        }

        return  rooms!=null ? rooms[0].deleteNullElements(findRoomsArray):null;
    }

    @Override
    public Room[] getAll(){
        return rooms;
    }
}
