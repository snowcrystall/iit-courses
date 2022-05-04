/*
 * Xuemin Cheng , course 201 , sec 03 , 2022/03/07
 * 
 * CTAStopApp
 */
package labs.lab5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CTAStopApp {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
		System.out.print("Load file: ");
		String filename = input.nextLine();
		// Load file (if exists)
		CTAStation[] data = readFile(filename);
		// Menu
        if (data != null){
		    menu(input,data);
        }
		input.close();
		System.out.println("Goodbye!");
    }
    public static CTAStation[] readFile(String filename){
        CTAStation[] stations = new CTAStation[10];
		int count = 0;
        
		
		try {
			File f = new File(filename);
			Scanner input = new Scanner(f);
			// skip first line
            input.nextLine();
			// end-of-file loop
			while (input.hasNextLine()) {
				
				String line = input.nextLine();
				String[] values = line.split(",");
                //Name,Latitude,Longitude,Location,Wheelchair,Open
				CTAStation c = new CTAStation(values[0],Double.parseDouble(values[1]),Double.parseDouble(values[2]),values[3], Boolean.parseBoolean(values[4]),Boolean.parseBoolean(values[5]));
					
				if (stations.length == count) {
					stations =  resize(stations, stations.length*2);
				}
					
				stations[count] = c;
				count++;
			}
			
			input.close();
		} catch (FileNotFoundException fnf) {
			System.out.println("File Not Found.");
            return null;
		} catch(Exception e) {
			System.out.println("Error occurred reading in file: " + e.toString());
            return null;
		}
		
		stations = resize(stations, count);
		
		return stations;
    }
    public static CTAStation[] resize(CTAStation[] data, int size) {
		CTAStation[] temp = new CTAStation[size];
		int limit = data.length > size ? size : data.length;
		for (int i=0; i<limit; i++) {
			temp[i] = data[i];
		}
		
		return temp;
	}
    public static void menu(Scanner input,CTAStation[] stations){
        boolean done = false;
		
		do {
			System.out.println("1. Display Station Names");
			System.out.println("2. Display Stations with/without Wheelchair access");
			System.out.println("3. Display Nearest Station");
			System.out.println("4. Exit");
			System.out.print("Choice: ");
			String choice = input.nextLine();
			
			switch (choice) {
				case "1": 
                    displayStationNames(stations);
					break;
				case "2": 
                    displayByWheelchair(input,stations);
					break;
				case "3": 
                    displayNearest(input,stations);
					break;
				case "4": 
					done = true;
					break;
				default:
					System.out.println("I'm sorry, but I didn't understand that.");
			}
		} while (!done);
	
    }
    public static boolean yesNoPrompt(String prompt, Scanner input) {
		
		boolean result = false;
		
        boolean done = false;
        do {
            System.out.print(prompt + " (y/n): ");
            String yn = input.nextLine();
		    switch (yn.toLowerCase()) {
			    case "y":
				    result = true;
                    done = true;
				    break;
			    case "n":
				    result = false;
                    done = true;
				    break;
			    default:
				    System.out.println("That is not y or n. ");
		    }
        }while(!done);
		return result;
	}
    public static void displayStationNames(CTAStation[] stations){
        for(int i = 0; i<stations.length; i++){
            System.out.println(stations[i].getName());
        }
    }
    public static void displayByWheelchair(Scanner input,CTAStation[] stations){
        boolean w = yesNoPrompt("displayByWheelchair " , input);
        boolean nofound = true;
        for(int i = 0; i<stations.length; i++){
            if (stations[i].hasWheelchair() == w){
                nofound = false;
                System.out.println(stations[i].getName());
            }
        }
        if (nofound){
            System.out.println("No stations are found");
        }
        
    }
    public static void displayNearest(Scanner input,CTAStation[] stations){
        
        try{
            //Prompts the user for a latitude and longitude
            System.out.print("Input latitude: ");
            double lat = Double.parseDouble(input.nextLine());
            System.out.print("Input longitude: ");
            double lng = Double.parseDouble(input.nextLine());

            double distance = 0;
            double nearestDistance =0;
            int nearest = 0;
            for(int i = 0; i<stations.length; i++){
            
                distance = stations[i].calsDistance(lat, lng);
                if (i == 0){
                    nearestDistance = distance;
                }else if(nearestDistance > distance){
                    nearestDistance = distance;
                    nearest = i;
                }
            } 
            System.out.println("The nearest station: " + stations[nearest].toString());
        }catch(Exception e){
            System.out.println(e.getMessage()+"  please input again");
        }
        
    }
}
