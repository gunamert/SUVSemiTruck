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

        int semicommand=0;
        String lightcommand="";
        boolean valid1= true;
        boolean valid2= true;

        Semi Truck = new Semi();
        TrafficLight Light = new TrafficLight();

        System.out.println("To move the Semi-Truck:\n 0) Exit Program \n 1) forward\n 2) right turn\n" +
                " 3) left turn\n 4) jack knife to a stop");
        while (valid2) {
            if (scan.hasNextInt()) {
                semicommand = scan.nextInt(); // Assign the next integer to a variable
                if (semicommand >= 0 && semicommand <= 4) { // Check if integer meets condition
                    valid2 = false;
                } else {
                    System.out.println("Please enter a integer between 0 to 4");
                }
            } else {
                System.out.println("Please enter a integer ");
                scan.next();

            }


            while (semicommand != 0) {

                System.out.println("Light is " + Light.getLight() + " if you want to change press Y otherwise press any button.");
                if (scan.next().equals("Y")) {
                    System.out.println("To change the traffic light:\n 1) Green press G\n 2) Yellow press Y\n" +
                            " 3) Red press R\n 4) Left-Turn Green press L");
                    while (valid1) {
                        if (scan.hasNext()) {
                            lightcommand = scan.next();
                            if (lightcommand.equals("L") || lightcommand.equals("R") || lightcommand.equals("Y") || lightcommand.equals("G")) {

                                if (lightcommand.equals("L")) {
                                    Light.setLight("Left-Turn Green");
                                } else if (lightcommand.equals("R")) {
                                    Light.setLight("Red");
                                } else if (lightcommand.equals("Y")) {
                                    Light.setLight("Yellow");
                                } else if (lightcommand.equals("G")) {
                                    Light.setLight("Green");
                                }
                                valid1 = false;
                            } else {
                                System.out.println("Please enter a valid value(G,Y,R,L)");
                            }
                        } else {
                            break;
                        }
                    }
                    valid1 = true;

                }

                if (semicommand == 1) {
                    if (Truck.getCommand().equals("Move Forward")) {
                        System.out.println("Error semi truck already moving forward. Please select a different option.");
                    } else {
                        if (Light.getLight().equals("Red") || Light.getLight().equals("Left-Turn Green")) {
                            System.out.println("Light is " + Light.getLight() + " so truck cannot go forward.");

                        } else {
                            Truck.setCommand("Move Forward");
                            System.out.println("Semi-Truck: " + Truck.getCommand() + "\nTraffic Light:" + Light.getLight());
                            Light.setLight("Green");
                        }

                    }

                } else if (semicommand == 3) {
                    if (Truck.getCommand().equals("Jack Knife to a Stop")) {
                        System.out.println("Truck cannot turn left because last move was Jack knifing");

                    } else {
                        if (Light.getLight().equals("Left-Turn Green")) {
                            Truck.setCommand("Turn Left");
                            System.out.println("Semi-Truck: " + Truck.getCommand() + "\nTraffic Light:" + Light.getLight());
                            Light.setLight("Green");
                        } else {
                            System.out.println("Light is not Left-Turn Green so Truck cannot turn.");
                        }
                    }

                } else if (semicommand == 4) {
                    if (Truck.getCommand().equals("Jack Knife to a Stop")) {
                        System.out.println("Truck cannot make a twice jack knife");

                    } else {
                        if (Light.getLight().equals("Red") || Light.getLight().equals("Left-Turn Green")) {
                            System.out.println("Light is " + Light.getLight() + " so truck cannot Jack Knife to a Stop");
                        } else {
                            Truck.setCommand("Jack Knife to a Stop");
                            System.out.println("Semi-Truck: " + Truck.getCommand() + "\nTraffic Light:" + Light.getLight());
                            Light.setLight("Green");
                        }
                    }

                } else if (semicommand == 2) {
                    if (Truck.getCommand().equals("Jack Knife to a Stop")) {
                        System.out.println("Truck cannot turn right because last move was Jack knifing");

                    } else {
                        if (Light.getLight().equals("Red") || Light.getLight().equals("Left-Turn Green")) {
                            System.out.println("Light is " + Light.getLight() + " so truck cannot turn right");
                        } else {
                            Truck.setCommand("Turn Right");
                            System.out.println("Semi-Truck: " + Truck.getCommand() + "\nTraffic Light:" + Light.getLight());
                            Light.setLight("Green");
                        }
                    }
                }
                System.out.print("\n\nEnter a new move: ");
                semicommand= scan.nextInt();
            }
        }
    }
}