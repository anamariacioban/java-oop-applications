package isp.lab11;

public class ATCClass {


    public void addAircraft(String id){

        System.out.println("Aircraft with id " + id + " added");
    }

    public void sendCommand(String id, ATcCommandClass command){
        System.out.println("Aircraft with id " + id + " received command " + command);
    }

    public void showAircrafts(){
        System.out.println("Display aircrfats.");
    }
}
