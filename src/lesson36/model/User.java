package lesson36.model;

import org.apache.commons.io.IOUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class User  implements Comparable<User> {
    private long id;
    private String userName;
    private String password;
    private String country;
    private UserType userType;


    public User() {
    }

    @Override
    public int compareTo(User o) {
        if(!this.getUserName().equals(o.getUserName())){
            return this.getUserName().compareTo(o.getUserName());
        }
        if(!this.getCountry().equals(o.getCountry())){
            return this.getCountry().compareTo(o.getCountry());
        }
        return 0;
    }

    public User(long id, String userName, String password, String country, UserType userType) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.country = country;
        this.userType = userType;
    }


    public long getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getCountry() {
        return country;
    }

    public UserType getUserType() {
        return userType;
    }

    public boolean canBeRegistred() {
        if (userName != null &&
                password != null &&
                country != null &&
                userType != null)
            return true;
        return false;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", country='" + country + '\'' +
                ", userType=" + userType +
                '}';
    }

    public String toFileFormat(){
        return  id + "," +'\t' + userName + ","+ '\t' + '\t' + password + ","+ '\t' + country + ","+ '\t' + userType ;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (!userName.equals(user.userName)) return false;
       // if (!password.equals(user.password)) return false;
        if (!country.equals(user.country)) return false;
        return userType == user.userType;
    }

    @Override
    public int hashCode() {
        int result = userName.hashCode();
       // result = 31 * result + password.hashCode();
        result = 31 * result + country.hashCode();
        result = 31 * result + userType.hashCode();
        return result;
    }


    public void setId(long id) {
        this.id = id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public User enterDataByKeyboard(){


        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(reader);

        try{
            System.out.print("UserName: ");
            this.userName = br.readLine();


            System.out.print("Password: ");
            this.password = br.readLine();


            System.out.print("Country: ");
            this.country = br.readLine();


            System.out.print("UserType: 1- USER, 2-ADMIN. The default value is USER. ");
            if(Integer.valueOf(br.readLine())==2){
                this.userType = UserType.ADMIN;
            }else{
                this.userType = userType.USER;
            }

        }catch(IOException e){
            System.err.println("Reading from keyboard failed");
        }finally{
            IOUtils.closeQuietly(reader);
            IOUtils.closeQuietly(br);
        }
        return this;
    }



}
