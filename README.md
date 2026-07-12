# Car Parking System 🚗

A simple console-based Car Parking Management System built with Java. It allows you to park vehicles, take them out, and view a live list of currently parked vehicles, with automatic parking-fee calculation based on time.

## Features
- **Park a vehicle** – Enter a vehicle number and entry time to check it in
- **Take out a vehicle** – Enter the vehicle number and exit time to check it out
- **List vehicles** – View all currently parked vehicles with their entry times
- **Duplicate check** – Prevents parking the same vehicle number twice
- **Automatic fee calculation** – Charges Rs. 1/- per minute parked
- **Time format validation** – Ensures entry time is in the correct format

## How It Works
1. Run the program — you'll see the main menu.
2. Choose an option by entering a letter:
   - `p` → Park a vehicle
   - `t` → Take out a vehicle
   - `l` → List all parked vehicles
   - `e` → Exit the program
3. Follow the prompts to enter the vehicle number and time (format: `HH.MM`, e.g. `9.30` or `18.45`).
4. On takeout, the system shows the total parked duration and the parking charge.

## Requirements
- Java JDK 8 or above

## How to Run

**Option 1 – Run the pre-built JAR file:**
```bash
java -jar Project/VehicalParkingSystem.jar
```

**Option 2 – Compile and run from source:**
```bash
cd Project
javac ParkingSystemSimple.java
java ParkingSystemSimple
```

## Project Structure
```
CarParkingSystem/
└── Project/
    ├── ParkingSystemSimple.java   # Main source code
    └── VehicalParkingSystem.jar   # Compiled runnable JAR
```

## Sample Output
```
**************** Welcome to Car parking System ****************
Choose what you want (enter letter)
     * Park - (p)
     * Take - (t)
     * List - (l)
     * Exit - (e)
```

## License
This project is open source and free to use.
