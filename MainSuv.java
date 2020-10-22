package com.company;

import java.util.Scanner;

/**
 *
 *@author MERT GUNAY
 *@since 10.15.2020
 *@version 1.0
 */

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int suvcommand=0;
        String lightcommand="";
        boolean valid= true;
        boolean valid2= true;

        Suv Truck = new Suv();
        TrafficLight Light = new TrafficLight();

        System.out.println("To move the SUV:\n 0) Exit Program \n 1) Move Forward\n 2) right turn\n" +
                " 3) left turn\n 4) Run Over Ford Pinto");

        //Until user enter input 0, loop going to continue. Each suvcommand has different situation.
        //1. If the SUV is already moving forward, the Move Forward command should generate an error
        //2. The SUV can only turn left if the stop light's current signal is Left-Turn Green
        //3. After each command to the SUV, the stop light's signal reverts back to Green
        //4. The SUV can only Run Over Ford Pinto if its last action was to Move Forward

        while (valid2){
            if (scan.hasNextInt()){
                suvcommand= scan.nextInt(); // Assign the next integer to a variable
                if (suvcommand  >= 0  && suvcommand <= 4){ // Check if integer meets condition
                    valid2=false;
                }else{
                    System.out.println("Please enter a integer between 0 to 4");
                }
            }else{
                System.out.println("Please enter a integer ");
                scan.next();

            }

        }
        while(suvcommand != 0){

            System.out.println("Light is "+Light.getLight()+" if you want to change press Y otherwise press any button.");
            if(scan.next().equals("Y")){
                System.out.println("To change the traffic light:\n 1) Green press G\n 2) Yellow press Y\n" +
                        " 3) Red press R\n 4) Left-Turn Green press L");
                while (valid){
                    if (scan.hasNext()){
                        lightcommand= scan.next();
                        if ( lightcommand.equals("L") || lightcommand.equals("R") || lightcommand.equals("Y") || lightcommand.equals("G")){

                            if(lightcommand.equals("L")){
                                Light.setLight("Left-Turn Green");
                            }else if(lightcommand.equals("R")){
                                Light.setLight("Red");
                            }else if(lightcommand.equals("Y")){
                                Light.setLight("Yellow");
                            }else if(lightcommand.equals("G")){
                                Light.setLight("Green");
                            }
                            valid=false;
                        }else{
                            System.out.println("Please enter a valid value(G,Y,R,L)");
                        }
                    }else{
                        break;
                    }
                }
                valid=true;
            }
            if(suvcommand==1){
                if (Truck.getCommand().equals("move forward")) {
                    System.out.println("Error suv truck already moving forward. Please select a different option.");
                } else {
                    if(Light.getLight().equals("Red") || Light.getLight().equals("Left-Turn Green")){
                        System.out.println("Light is "+Light.getLight()+ " so truck cannot go forward.");

                    }else{
                        Truck.setCommand("move forward");
                        System.out.println("SUV: " + Truck.getCommand()+ "\nTraffic Light:" + Light.getLight());
                        Light.setLight("Green");
                    }

                }

            }else if(suvcommand==3){
                    if(Light.getLight().equals("Left-Turn Green")){
                        Truck.setCommand("Turn Left");
                        System.out.println("SUV: " + Truck.getCommand()+ "\nTraffic Light:" + Light.getLight());
                        Light.setLight("Green");
                    }else{
                        System.out.println("Light is not Left-Turn Green so Truck cannot turn.");
                    }


            }else if(suvcommand==4){

                if (Truck.getCommand().equals("move forward")) {

                    if (Light.getLight().equals("Red") || Light.getLight().equals("Left-Turn Green")) {
                        System.out.println("Light is " + Light.getLight() + " so truck cannot Run Over Ford Pinto");
                    } else {
                        Truck.setCommand("Run Over Ford Pinto");
                        System.out.println("SUV: " + Truck.getCommand() + "\nTraffic Light:" + Light.getLight());
                        Light.setLight("Green");
                    }
                }else{
                    System.out.println("SUV cannot Run Over Ford Pinto because last move not Move Forward");
                }


            }else if(suvcommand==2){

                    if (Light.getLight().equals("Red") || Light.getLight().equals("Left-Turn Green")) {
                        System.out.println("Light is " + Light.getLight() + " so truck cannot turn right");
                    } else {
                        Truck.setCommand("Turn Right");
                        System.out.println("SUV: " + Truck.getCommand() + "\nTraffic Light:" + Light.getLight());
                        Light.setLight("Green");
                    }
            }
            System.out.print("\n\nEnter a new move: ");
            suvcommand = scan.nextInt();
        }
    }
}