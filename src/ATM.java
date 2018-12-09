import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
public class ATM {
	private  ArrayList<ArrayList<String>> database;
	private  Scanner input;
	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		ATM myATM = new ATM();
		myATM.startATM();
	}
	
	
	
	public void startATM() throws FileNotFoundException, IOException {
		database = Database.readFile();
		input = new Scanner(System.in);
		mainMenu();
		
		
	}
	
	public void mainMenu() throws FileNotFoundException, IOException{
		String option;
		do {
			System.out.println("To open an account: type '1'. \nTo login: type '2'. \nTo quit: type '3'.");
			option = input.nextLine();
			if (Integer.parseInt(option) == 1) {
				openAccount();
			}
			if (Integer.parseInt(option) == 2) {
				verifyLogin();
			}
		} while (Integer.parseInt(option) != 3);
		Database.writeFile(database);
	}
	
	public void openAccount() { //create account
		int size = database.size();
		ArrayList<String> nAccount = new ArrayList<String>() ;
		for (int x = 0; x < 12; x++){
			nAccount.add(x, "");
		}
		nAccount.set(2, "0.             ");
		nAccount.set(11, "Y");
		nAccount.set(0, "" + (1+Integer.parseInt(database.get(size-1).get(0))));	
		System.out.println("Your account number is " + nAccount.get(0));
		
		boolean done = false;
		String nPin;
		do {
			try{
				System.out.println("Enter a valid new pin with 4 characters");
				nPin = input.nextLine();
				Integer.parseInt(nPin);
				if (nPin.length() == 4){
					done = true;
					nAccount.set(1, nPin);
				}else {
					System.out.println("Invalid input");
				}
			} catch(NumberFormatException e){
				System.out.println("Invalid input");
			}
		}while(!done);

		String lName;
		done = false;
		do{
			try{
				System.out.println("Enter your last name up to 20 characters:");
				lName = input.nextLine();
				if (lName.length() <= 20){
					String buffer = "";
					for (int i = 0; i < 20 - lName.length(); i++){
						buffer = buffer + " ";
					}
					nAccount.set(3, "" + lName + buffer);
					done = true;
				}else {
					System.out.println("Invalid input");
				}
			} catch(NumberFormatException e){
				System.out.println("Invalid input");
			}
		}while (done == false);
		
		String fName;
		done = false;
		do{
			try{
				System.out.println("Enter your first name up to 15 characters:");
				fName = input.nextLine();
				if (fName.length() <= 20){
					String buffer = "";
					for (int i = 0; i < 15 - fName.length(); i++){
						buffer = buffer + " ";
					}
					nAccount.set(4, "" + fName + buffer);
					done = true;
				}else {
					System.out.println("Invalid input");
				}
			} catch(NumberFormatException e){
				System.out.println("Invalid input");
			}
		}while (done == false);
		
		String date;
		int dateValue = -1;
		done = false;
		do{
			try{
				System.out.println("Enter a valid date of birth in the format YYYYMMDD");
				date = input.nextLine();
				dateValue = Integer.parseInt(date);
				if (dateValue > 0 && date.length() == 8 && Integer.parseInt(date.substring(0, 4)) > 0 && Integer.parseInt(date.substring(4, 6)) > 0 && Integer.parseInt(date.substring(4, 6)) <= 12 && Integer.parseInt(date.substring(6, 8)) > 0 && Integer.parseInt(date.substring(6, 8)) <= 31){
					done = true;
					nAccount.set(5, date);
				}else {
					System.out.println("Invalid input");
				}
			} catch(NumberFormatException e){
				System.out.println("Invalid input");
			}
		}while (done == false);
		
		String number;
		done = false;
		do{
			try{
				System.out.println("Enter a valid phone number with 10 characters");
				number = input.nextLine();
				Long.parseLong(number);
				if (number.length() == 10){
					done = true;
					nAccount.set(6, number);
				}else {
					System.out.println("Invalid input");
				}
			} catch(NumberFormatException e){
				System.out.println("Invalid input");
			}
		}while (done == false);
		
		String address;
		done = false;
		do{
			try{
				System.out.println("Enter a valid street address with up to 30 characters");
				address = input.nextLine();
				if (address.length() <= 30){
					String buffer = "";
					for (int i = 0; i < 30 - address.length(); i++){
						buffer = buffer + " ";
					}
					done = true;
					nAccount.set(7, address + buffer);
				}else {
					System.out.println("Invalid input");
				}
			} catch(NumberFormatException e){
				System.out.println("Invalid input");
			}
		}while (done == false);
		
		String city;
		done = false;
		do{
			try{
				System.out.println("Enter a valid city with up to 30 characters");
				city = input.nextLine();
				if (city.length() <= 30){
					String buffer = "";
					for (int i = 0; i < 30 - city.length(); i++){
						buffer = buffer + " ";
					}
					done = true;
					nAccount.set(8, city + buffer);
				}else {
					System.out.println("Invalid input");
				}
			} catch(NumberFormatException e){
				System.out.println("Invalid input");
			}
		}while (done == false);
		
		String state;
		String[] states = {
				"AK",
				"AL",
				"AZ",
				"AR",
				"CA",
				"CO",
				"CT",
				"DE",
				"FL",
				"GA",
				"HI",
				"ID",
				"IL",
				"IN",
				"IA",
				"KS",
				"KY",
				"LA",
				"ME",
				"MD",
				"MA",
				"MI",
				"MN",
				"MS",
				"MO",
				"MT",
				"NE",
				"NV",
				"NH",
				"NJ",
				"NM",
				"NY",
				"NC",
				"ND",
				"OH",
				"OK",
				"OR",
				"PA",
				"RI",
				"SC",
				"SD",
				"TN",
				"TX",
				"UT",
				"VT",
				"VA",
				"WA",
				"WV",
				"WI",
				"WY"};
		boolean inStates = false;
		done = false;
		do{
			try{
				System.out.println("Enter a valid 2 letter state code using capital letters");
				state = input.nextLine();
				for (int i = 0; i < 50; i++){
					if (state.equals(states[i])){
						inStates = true;
					}
				}
				if (state.length() == 2 && inStates){
					done = true;
					nAccount.set(9, state);
				}else {
					System.out.println("Invalid input");
				}
			} catch(NumberFormatException e){
				System.out.println("Invalid input");
			}
		}while (done == false);
		
		String postal;
		done = false;
		do{
			try{
				System.out.println("Enter a valid postal code with 5 characters");
				postal = input.nextLine();
				Integer.parseInt(postal);
				if (postal.length() == 5){
					done = true;
					nAccount.set(10, postal);
				}else {
					System.out.println("Invalid input");
				}
			} catch(NumberFormatException e){
				System.out.println("Invalid input");
			}
		}while (done == false);
		database.add(nAccount);
	}
	
	public void verifyLogin(){
		System.out.println("Enter your account number:");
		String accountNumber = input.nextLine();
		System.out.println("Enter your pin:");
		String pin = input.nextLine();
		int account = matchRecords(accountNumber, pin);
		if (account >= 0) {
			login(account);
		} else if(account == -1) {
			System.out.println("Access denied that account is closed");
		} else if (account == -2) {
			System.out.println("Access denied wrong account number and/or pin");
		}
		
	}
	
	public void login(int account){
		String option;
		do {
			System.out.println("To deposit funds: type '1'. \nTo withdraw funds: type '2'. \nTo transfer funds: type '3'. \nTo view balance: type '4'. \nTo view personal information: type '5'. \nTo update personal information: type '6'. \nTo close account: type '7'. \nTo logout: type 8");
			option = input.nextLine();
			if (Integer.parseInt(option) == 1) {
				deposit(account); // done
			}
			if (Integer.parseInt(option) == 2) {
				withdraw(account); // done
			}
			if (Integer.parseInt(option) == 3) {
				transfer(account); // done
			}
			if (Integer.parseInt(option) == 4) {
				checkBalance(account); // done
			}
			if (Integer.parseInt(option) == 5) {
				viewPersonalInfo(account); // done
			}
			if (Integer.parseInt(option) == 6) {
				updatePersonalInfo(account);
			}
			if (Integer.parseInt(option) == 7) {
				closeAccount(account);
			}
		} while (Integer.parseInt(option) != 8);
		
	}
	
	public int matchRecords(String accountNumber, String pin){ // returns -2 if not found, -1 if closed, i to specify which record
		int recordsNum = database.size();
		int match = -2;
		for (int i = 0; i < recordsNum; i++){
			if (database.get(i).get(0).equals(accountNumber) && database.get(i).get(1).equals(pin)) {
				match = i;
				if (database.get(i).get(11).equals("N")){
					match = -1;
				}
			}
		}
		return match;
	}
	
	public void deposit(int account){
		
		String deposit;
		double depositValue = -1;
		boolean done = false;
		do{
			try{
				System.out.println("Enter a valid deposit amount greater than 0:");
				deposit = input.nextLine();
				depositValue = Double.parseDouble(deposit);
				if (depositValue > 0){
					done = true;
				}else {
					System.out.println("Invalid input");
				}
			} catch(NumberFormatException e){
				System.out.println("Invalid input");
			}
		}while (done == false);
		double balance = Double.parseDouble(database.get(account).get(2));
		balance = balance + depositValue;
		String buffer = "";
		for (int i = 0; i < 15 - (""+balance).length(); i++){
			buffer = buffer + " ";
		}
		database.get(account).set(2, "" + balance + buffer);
		System.out.println("" + depositValue + " dollar(s) have been added to your account");
		String exit = "0";
		do {
			System.out.println("Type 1 to return to your account screen");
			exit = input.nextLine();
		}while(!exit.equals("1"));
	}
	
	public void withdraw(int account){
		String withdraw;
		double withdrawValue = -1;
		boolean done = false;
		do{
			try{
				System.out.println("Enter a valid withdrawl amount greater than 0 but less than your balance:");
				withdraw = input.nextLine();
				withdrawValue = Double.parseDouble(withdraw);
				if (withdrawValue > 0 && withdrawValue <= Double.parseDouble(database.get(account).get(2))){
					done = true;
				}else {
					System.out.println("Invalid input");
				}
			} catch(NumberFormatException e){
				System.out.println("Invalid input");
			}
		}while (done == false);
		double balance = Double.parseDouble(database.get(account).get(2));
		balance = balance - withdrawValue;
		String buffer = "";
		for (int i = 0; i < 15 - (""+balance).length(); i++){
			buffer = buffer + " ";
		}
		database.get(account).set(2, "" + balance + buffer);
		System.out.println("" + withdrawValue + " dollar(s) have been withdrawn from your account");
		String exit = "0";
		do {
			System.out.println("Type 1 to return to your account screen");
			exit = input.nextLine();
		}while(!exit.equals("1"));
	}
	
	public void transfer(int sAccount){
		boolean done = false;
		String rAccountRaw;
		int rAccount;
		do {
			System.out.println("Enter a valid account number to tranfer to, or enter '-1' to escape");
			rAccountRaw = input.nextLine();
			int recordsNum = database.size();
			rAccount = -2;
			for (int i = 0; i < recordsNum; i++){
				if (database.get(i).get(0).equals(rAccountRaw)) {
					rAccount = i;
					done = true;
					if (database.get(i).get(11).equals("N")){
						rAccount = -1;
						System.out.println("That account is closed");
						done = false;
					}
				}
			}
		}while (done == false && !rAccountRaw.equals("-1"));
		if (rAccountRaw.equals("-1")){
			return;
		}else{
			String withdraw;
			double withdrawValue = -1;
			boolean done2 = false;
			do{
				try{
					System.out.println("Enter a valid transfer amount greater than 0 but less than your balance:");
					withdraw = input.nextLine();
					withdrawValue = Double.parseDouble(withdraw);
					if (withdrawValue > 0 && withdrawValue <= Double.parseDouble(database.get(sAccount).get(2))){
						done2 = true;
					}else {
						System.out.println("Invalid input");
					}
				} catch(NumberFormatException e){
					System.out.println("Invalid input");
				}
			}while (done2 == false);
			double balance1 = Double.parseDouble(database.get(sAccount).get(2));
			balance1 = balance1 - withdrawValue;
			String buffer = "";
			for (int i = 0; i < 15 - (""+balance1).length(); i++){
				buffer = buffer + " ";
			}
			database.get(sAccount).set(2, "" + balance1 + buffer);
			double balance2 = Double.parseDouble(database.get(rAccount).get(2));
			balance2 = balance2 + withdrawValue;
			buffer = "";
			for (int i = 0; i < 15 - (""+balance2).length(); i++){
				buffer = buffer + " ";
			}
			database.get(rAccount).set(2, "" + balance2 + buffer);
			System.out.println("" + withdrawValue + " dollar(s) have been withdrawn from your account and deposited to account #" + rAccountRaw);
			String exit = "0";
			do {
				System.out.println("Type 1 to return to your account screen");
				exit = input.nextLine();
			}while(!exit.equals("1"));
		}
	}
	
	public void checkBalance(int account) {
		System.out.println("You have " + Double.parseDouble(database.get(account).get(2)) + " dollar(s) in your account");
		String exit = "0";
		do {
			System.out.println("Type 1 to return to your account screen");
			exit = input.nextLine();
		}while(!exit.equals("1"));
	}
	
	public void viewPersonalInfo(int account){
		System.out.print("Your last name is: ");
		System.out.println(database.get(account).get(3));
		System.out.print("Your first name is: ");
		System.out.println(database.get(account).get(4));
		System.out.print("Your date of birth is: ");
		System.out.println(database.get(account).get(5).substring(4,6) + "/" + database.get(account).get(5).substring(6,8) + "/" + database.get(account).get(5).substring(0,4));
		System.out.print("Your phone number is: ");
		System.out.println(database.get(account).get(6));
		System.out.print("Your street address is: ");
		System.out.println(database.get(account).get(7));
		System.out.print("Your city is: ");
		System.out.println(database.get(account).get(8));
		System.out.print("Your state is: ");
		System.out.println(database.get(account).get(9));
		System.out.print("Your postal code is: ");
		System.out.println(database.get(account).get(10));
		System.out.print("Your account status is: ");
		System.out.println(database.get(account).get(11));
		String exit = "0";
		do {
			System.out.println("Type 1 to return to your account screen");
			exit = input.nextLine();
		}while(!exit.equals("1"));
	}
	
	public void updatePersonalInfo(int account){
		String option;
		do {
			System.out.println("To update phone number: type '1'. \nTo update  street address: type '2'. \nTo update city: type '3'. \nTo update state: type '4'. \nTo update postal code: type '5'. \nTo update PIN: type '6'\nTo exit: type '0'");
			option = input.nextLine();
			if (Integer.parseInt(option) == 1) {
				String number;
				boolean done = false;
				do{
					try{
						System.out.println("Enter a valid phone number with 10 characters");
						number = input.nextLine();
						Long.parseLong(number);
						if (number.length() == 10){
							done = true;
							database.get(account).set(6, number);
						}else {
							System.out.println("Invalid input");
						}
					} catch(NumberFormatException e){
						System.out.println("Invalid input");
					}
				}while (done == false);
			}
			if (Integer.parseInt(option) == 2) {
				String address;
				boolean done = false;
				do{
					try{
						System.out.println("Enter a valid street address with up to 30 characters");
						address = input.nextLine();
						if (address.length() <= 30){
							String buffer = "";
							for (int i = 0; i < 30 - address.length(); i++){
								buffer = buffer + " ";
							}
							done = true;
							database.get(account).set(7, address + buffer);
						}else {
							System.out.println("Invalid input");
						}
					} catch(NumberFormatException e){
						System.out.println("Invalid input");
					}
				}while (done == false);
			}
			if (Integer.parseInt(option) == 3) {
				String city;
				boolean done = false;
				do{
					try{
						System.out.println("Enter a valid city with up to 30 characters");
						city = input.nextLine();
						if (city.length() <= 30){
							String buffer = "";
							for (int i = 0; i < 30 - city.length(); i++){
								buffer = buffer + " ";
							}
							done = true;
							database.get(account).set(8, city + buffer);
						}else {
							System.out.println("Invalid input");
						}
					} catch(NumberFormatException e){
						System.out.println("Invalid input");
					}
				}while (done == false);
			}
			if (Integer.parseInt(option) == 4) {  // check for valid state codes
				String state;
				String[] states = {
						"AK",
						"AL",
						"AZ",
						"AR",
						"CA",
						"CO",
						"CT",
						"DE",
						"FL",
						"GA",
						"HI",
						"ID",
						"IL",
						"IN",
						"IA",
						"KS",
						"KY",
						"LA",
						"ME",
						"MD",
						"MA",
						"MI",
						"MN",
						"MS",
						"MO",
						"MT",
						"NE",
						"NV",
						"NH",
						"NJ",
						"NM",
						"NY",
						"NC",
						"ND",
						"OH",
						"OK",
						"OR",
						"PA",
						"RI",
						"SC",
						"SD",
						"TN",
						"TX",
						"UT",
						"VT",
						"VA",
						"WA",
						"WV",
						"WI",
						"WY"};
				boolean inStates = false;
				boolean done = false;
				do{
					try{
						System.out.println("Enter a valid 2 letter state code in capital letters");
						state = input.nextLine();
						for (int i = 0; i < 50; i++){
							if (state.equals(states[i])){
								inStates = true;
							}
						}
						if (state.length() == 2 && inStates){
							done = true;
							database.get(account).set(9, state);
						}else {
							System.out.println("Invalid input");
						}
					} catch(NumberFormatException e){
						System.out.println("Invalid input");
					}
				}while (done == false);
			}
			if (Integer.parseInt(option) == 5) {
				String postal;
				boolean done = false;
				do{
					try{
						System.out.println("Enter a valid postal code with 5 characters");
						postal = input.nextLine();
						Integer.parseInt(postal);
						if (postal.length() == 5){
							done = true;
							database.get(account).set(10, postal);
						}else {
							System.out.println("Invalid input");
						}
					} catch(NumberFormatException e){
						System.out.println("Invalid input");
					}
				}while (done == false);
			}
			if (Integer.parseInt(option) == 6) {
				String nPin;
				String oPin;
				boolean done = false;
				do{
					try{
						System.out.println("Enter your old pin");
						oPin = input.nextLine();
						Integer.parseInt(oPin);
						if (oPin.length() == 4){
							if (matchRecords(database.get(account).get(0), oPin) >= 0) {
								try{
									System.out.println("Enter a valid new pin with 4 characters");
									nPin = input.nextLine();
									Integer.parseInt(nPin);
									if (nPin.length() == 4){
										done = true;
										database.get(account).set(1, nPin);
									}else {
										System.out.println("Invalid input");
									}
								} catch(NumberFormatException e){
									System.out.println("Invalid input");
								}
							}
						}else {
							System.out.println("Invalid input");
						}
					} catch(NumberFormatException e){
						System.out.println("Invalid input");
					}
				}while (done == false);
			}
		} while (Integer.parseInt(option) != 0);
	}
	
	public void closeAccount(int account) {
		String option;
		boolean done = false;
		do {
			System.out.println("Are you sure you want to close your account. THIS WILL BE PERMANANT: type 1 for yes and 2 for no");;
			option = input.nextLine();
			if (Integer.parseInt(option) == 1) {
				database.get(account).set(11, "N");
				done = true;
			}
		} while (Integer.parseInt(option) != 2 && done == false);
		
		
	}
	
	public void recordToBankAccount(int account){
		
	}
	
	public void bankAccountToRecord(int account){
		
	}
}
