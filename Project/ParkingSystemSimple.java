import java.util.Scanner;



public class ParkingSystemSimple {


    public static String vehicles[][] = new String[100][2];


    public static void main(String[] args) {

        System.out.println("**************** Welcome to Car parking System ****************");

        //loop breaks when enter a command in Choosing function
        while (true) {
            Choosing();
        }

    }


    //Main menu
    public static void Choosing() {
        Scanner input = new Scanner(System.in);
        String park = "";
        System.out.println("Choose what you want (enter letter)");
        System.out.println("\t * Park - (p)");
        System.out.println("\t * Take - (t)");
        System.out.println("\t * List - (l)");
        System.out.println("\t * Exit - (e)");
        park = input.nextLine();

        if (park.equals("p") || park.equals("park")) {
            park();
        } else if (park.equals("t") || park.equals("take")) {
            take();
        } else if (park.equals("l") || park.equals("list")) {
            getList();
        } else if (park.equals("e") || park.equals("exit")) {
            System.out.println("\n\n Terminating...");
            System.exit(0);
        } else {
            System.out.println("Wrong input...");
        }
    }

    public static boolean checkNumberFormat(String number) {
        boolean status = false;

        if (number.contains("-") && 8 <= number.length() && number.length() >= 7) {
            status = true;
        } else {
            status = false;
        }
        return status;
    }

    // check duplicates
    public static boolean checkDuplicate(String number) {

        boolean status = false;

        for (int i = 0; i < 100; i++) {
            if ((vehicles[i][0]) != null) {
                if ((vehicles[i][0]).equals(number)) {
                    status = true;
                    break;
                } else {
                    status = false;
                }
            }
        }

        return status;
    }

    //parking function
    public static void park() {
        Scanner input = new Scanner(System.in);
        System.out.println("choosed park..!");
        System.out.print("Enter Vehicle number : ");
        String number = input.nextLine();

        //duplicate Error
        if (checkDuplicate(number)) {
            System.out.println("\n\n***********ERROR*************");
            System.out.println("The vehicle is already parked!");
            System.out.println("******************************\n\n");

        } else {
            System.out.print("Enter Time : ");
            String intime = input.nextLine();
            int id = 0;


            //check time format
            if (intime.contains(".")) {


                //Save data to Array
                for (int i = 0; i < 100; i++) {
                    if ((vehicles[i][0]) == null) {

                        vehicles[i][0] = number;
                        vehicles[i][1] = intime;
                        id = i;
                        break;
                    }

                }

                //Display Token
                System.out.println("\n\n******************************");
                System.out.println("Vehicle Number \t - " + vehicles[id][0]);
                System.out.println("Park time\t - " + vehicles[id][1]);
                System.out.println("*Parking price \nRs.1/- per Minute");
                System.out.println("********* Thank You! ********* \n\n\n");
            } else {
                System.out.println("\n\n***********ERROR*************");
                System.out.println("The time format is wrong!");
                System.out.println("time must include \".\"");
                System.out.println("******************************\n\n");
            }

        }
    }

    //Vehicle takeout function
    public static void take() {
        Scanner input = new Scanner(System.in);
        System.out.println("choosed take..!");
        System.out.print("Enter Vehicle number : ");
        String number = input.nextLine();

        //Check vehicle if available
        if (checkDuplicate(number)) {
            System.out.print("Enter Time : ");
            String outtime = input.nextLine();
            int id = 0;

            //get park time of vehicle number
            for (int i = 0; i < vehicles.length; i++) {
                if (vehicles[i][0].equals(number)) {
                    id = i;
                    break;
                }
            }

            //minutes assign to long variable
            long difference = timetoMinutes(outtime) - timetoMinutes(vehicles[id][1]);

            //Display Ticket
            System.out.println("\n\n********** " + vehicles[id][0] + " **********");
            System.out.println("park in time \t: " + vehicles[id][1]);
            System.out.println("park out time \t: " + outtime);

            //minutes convert to hour again
            int parkinghour = ((int) difference / 60);

            //reminder get using modules for minutes
            int parkingMinutes = (int) (difference % 60);
            System.out.println("park time \t: " + parkinghour + "h " + parkingMinutes + "m");

            //Charge calculation
            int charge = (int) difference * 1;

            System.out.println("parking charge \t: Rs." + charge + ".00");
            System.out.println("******************************\n\n");


            //Delete vehicle
            for (int i = 0; i < 100; i++) {
                if ((vehicles[i][0]).equals(number)) {

                    vehicles[i][0] = null;
                    vehicles[i][1] = null;

                    break;
                }

            }

            //if vehicle not found then show this error
        } else {
            System.out.println("\n\n***********ERROR*************");
            System.out.println("The vehicle not found!");
            System.out.println("******************************\n\n");
        }

    }

    //Check Available vehicle list function
    public static void getList() {
        System.out.println("\n\n******* Parked Vehicle List ********");
        System.out.println("Number\t\t | parked time");
        for (int i = 0; i < vehicles.length; i++) {
            if (vehicles[i][0] != null) {

                System.out.println(vehicles[i][0] + " \t : " + vehicles[i][1]);
            }

        }
        System.out.println("************************************\n\n");
    }

    //String time to minutes convertion
    public static long timetoMinutes(String time) {
        long minutes = 0;

        //check length (Ex : 6.30 and 18.30)
        if (time.length() > 4) {
            int hour = Integer.parseInt(time.substring(0, 2));
            minutes = Integer.parseInt(time.substring(3)) + (hour * 60);

        } else if (time.length() == 4) {
            int hour = Integer.parseInt(time.substring(0, 1));
            minutes = Integer.parseInt(time.substring(2)) + (hour * 60);
        } else {
            System.out.println("Wrong time format : " + time);
        }

        return minutes;
    }
}

