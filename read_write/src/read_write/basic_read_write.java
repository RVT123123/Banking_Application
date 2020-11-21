package read_write;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import entity.*;
import java.text.*;
import java.time.LocalDateTime;
import java.io.*;


public class basic_read_write {
	
		  public static void main(String[] args) throws IOException {
			
		    String filename_ac = "C:\\Users\\Amit Anand\\Desktop\\Lybrate\\account.csv"; //file path of account.csv
		    String filename_at = "C:\\Users\\Amit Anand\\Desktop\\Lybrate\\account_statement.csv"; // file path of statement.csv
		    Scanner in = new Scanner(System.in);
		    int userChoice;
		    boolean quit = false;
		    float balance = 0;
		    do {  
                  System.out.println("1. Check Balance"); // creating menu for user
                  System.out.println("2. ADD New User");
                  System.out.println("3. DEPOSIT");
                  System.out.println("4. WITHDRAW");
                  System.out.print("Your choice, 0 to quit: ");
                  userChoice = in.nextInt();
                  switch (userChoice) 
                  {
                  case 0:
                	  System.out.println("BYE");
                	  System.exit(0);
                  case 1:
                	System.out.println("Enter account number to be searched"); // display balance
          		    Scanner aa = new Scanner(System.in);
          		    int x= aa.nextInt();
          		    int flag = 0;
                	File file_ac = new File(filename_ac);
          		    //File file_at = new File(filename_at);
          		    try {
          				Scanner inputStream = new Scanner(file_ac);
          				String data = inputStream.next();
          				while(inputStream.hasNext())
          				{
          					data = inputStream.next(); // reads a whole line
          					String values[]=data.split(",");
          					String comp = values[0];
          					//System.out.println("comp = \n" + comp);
          					if (comp.equals("" + x)) {
          					System.out.println("Balance is " + values[2]);
          					flag = 1;
          				}          					
          					
          				}
          				
          				if(flag == 0)
          					System.out.println("Account is not found");
          				inputStream.close();
          		    }
          				
          		    catch (FileNotFoundException e) 
          		    {
          				// TODO Auto-generated catch block
          				e.printStackTrace();
          			}
          		  break;
                  case 2:                                                              // add new user
                	int i = 0;               	  
                	File file_ = new File(filename_ac);
        		    try {
        				Scanner inputStream = new Scanner(file_);
        				while(inputStream.hasNext())
        				{
        					String data = inputStream.next(); // reads a whole line
        					String values[]=data.split(",");
        					i +=1;
        				}
        				inputStream.close();
        				} 
        		    catch (FileNotFoundException e) 
        		    {
        				// TODO Auto-generated catch block
        				e.printStackTrace();
        			}
                	  
        		    System.out.println("Enter your name");
        		    Scanner name = new Scanner(System.in);
        		    String na= name.nextLine();
        		    
        		    System.out.println("Enter your initial amount");
        		    Scanner aab = new Scanner(System.in);
        		    int amt= aab.nextInt();
        		    String COMMA_DELIMITER = ",";
        		    List<new_record> new_user = new ArrayList<new_record>(); 
        		    new_user.add(new new_record(i,na,amt));
        		    FileWriter fileWriter = new FileWriter("C:\\Users\\Amit Anand\\Desktop\\Lybrate\\account.csv",true);
                    for( new_record r:new_user ) {
                    	fileWriter.append(String.valueOf(r.getAccount_number()));
                        fileWriter.append(COMMA_DELIMITER);
                        fileWriter.append(r.getName());
                        fileWriter.append(COMMA_DELIMITER);
                        fileWriter.append(String.valueOf(r.getBalance()));
                        fileWriter.append(COMMA_DELIMITER);
                        fileWriter.append("\n");
                        
                    }
                    fileWriter.flush();
                    fileWriter.close();
                    System.out.println("New User Added");
                   break;
                  case 3:
                	  System.out.println("Enter account number");                  // deposit money
            		  aa = new Scanner(System.in);
            		  x = aa.nextInt();
            		  //
            		flag = 0;
                  	file_ac = new File(filename_ac);
            		    try {
            		    	
            				Scanner inputStream = new Scanner(file_ac);
            				String data = inputStream.next();
            				int ind = 1;
            				while(inputStream.hasNext())
            				{
            					data = inputStream.next(); // reads a whole line
            					String values[]=data.split(",");
            					String comp = values[0];
            					ind += 1;
            					if (comp.equals("" + x)) {
            					System.out.println("Account Found\n");
            					String mode_Add = null;
            					
            					int check = 0;
            					while(check == 0 )
            					{
            					System.out.println("Enter the mode 1. online 2.Cash 3.ATM");
                				Scanner mode = new Scanner(System.in);
                				int Choice = mode.nextInt();
            					switch (Choice) {
                    		      
            					case 1 : mode_Add = "online";
            						check = 1;
                    		    	break;
            					case 2 : mode_Add = "cash";
            						check=2;
                    		    	break;
            					case 3 : mode_Add = "atm";
            						check=3;
            						break;
            					default:                    		    	
            						System.out.println("Invalid mode");
            						
                    		    }
            					}
            					System.out.println("selected mode is:" + mode_Add);
            					System.out.println("Please enter amount to be deposited:\n");
            					aab = new Scanner(System.in);
                    		    amt= aab.nextInt();
                    		    int updated_amt = amt + Integer.valueOf(values[2]);
            					System.out.println("Updated Balance is: " + updated_amt);
            					File file = new File("C:\\Users\\Amit Anand\\Desktop\\Lybrate\\account.csv");
            					new CSV(file).set(ind, 3, Integer.toString(updated_amt)).save(file);
            					flag = 1;
            					//updating acount_statement
                    		    int j = 0;               	  
                            	File file_st = new File(filename_at);
                    		    try {
                    				Scanner statement_Stream = new Scanner(file_st);
                    				while(statement_Stream.hasNext())
                    				{
                    					String statement_data = statement_Stream.next(); // reads a whole line
                    					String statement_values[]=statement_data.split(",");
                    					j +=1;
                    				}
                    				statement_Stream.close();
                    				} 
                    		    catch (FileNotFoundException e) 
                    		    {
                    				// TODO Auto-generated catch block
                    				e.printStackTrace();
                    			}
                            	  
                    		    COMMA_DELIMITER = ",";
                    		    DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
                    		    Date date = new Date();
                    		    List<new_transaction> new_txn = new ArrayList<new_transaction>();                     		    
                    		    new_txn.add(new new_transaction(dateFormat.format(date),"Cr",x,amt,updated_amt,mode_Add));
                    		    FileWriter statement_fileWriter = new FileWriter("C:\\Users\\Amit Anand\\Desktop\\Lybrate\\account_statement.csv",true);
                                for( new_transaction p:new_txn ) 
                                {
                                	statement_fileWriter.append(String.valueOf(p.getDt()));
                                	statement_fileWriter.append(COMMA_DELIMITER);
                                	statement_fileWriter.append(p.getAmt_type());
                                	statement_fileWriter.append(COMMA_DELIMITER);
                                	statement_fileWriter.append(String.valueOf(p.getAc_num()));
                                	statement_fileWriter.append(COMMA_DELIMITER);
                                	statement_fileWriter.append(String.valueOf(p.getAmt_st()));
                                	statement_fileWriter.append(COMMA_DELIMITER);
                                	statement_fileWriter.append(String.valueOf(p.getBal_avl()));
                                	statement_fileWriter.append(COMMA_DELIMITER);
                                	statement_fileWriter.append(p.getMd());
                                	statement_fileWriter.append(COMMA_DELIMITER);
                                	statement_fileWriter.append("\n");
                                    
                                }
                                statement_fileWriter.flush();
                                statement_fileWriter.close();
                                System.out.println("Statement is updated");
            					
            					
            				}          					
            					
            				}
            				
            				if(flag == 0)
            					System.out.println("Account is not found");
            				inputStream.close();
            		    }
            		    
            				
            		    catch (FileNotFoundException e) 
            		    {
            				// TODO Auto-generated catch block
            				e.printStackTrace();
            			}
            		    //Withdraw Amount
            		    break;
                  case 4:                     //withdraw money
                	  System.out.println("Enter account number");
            		  aa = new Scanner(System.in);
            		  x = aa.nextInt();
            		  //
            		flag = 0;
                  	file_ac = new File(filename_ac);
            		    try {
            		    	
            				Scanner inputStream = new Scanner(file_ac);
            				String data = inputStream.next();
            				int ind = 1;
            				while(inputStream.hasNext())
            				{
            					data = inputStream.next(); // reads a whole line
            					String values[]=data.split(",");
            					String comp = values[0];
            					ind += 1;
            					if (comp.equals("" + x)) {
            					System.out.println("Account Found\n");
            					String mode_Add = null;
            					String comp_bal = values[2];
            					int k=Integer.parseInt(comp_bal);
            					if (k <= 0) {
                				System.out.println("Insufficient Fund\n");
            					break;
            					}
            					//int check_bal = 0;
            					int check = 0;
            					//while(check_bal == 0)
            					//{
            					while(check == 0 )
            					{
            					System.out.println("Enter the mode 1. online 2.Cash 3.ATM");
                				Scanner mode = new Scanner(System.in);
                				int Choice = mode.nextInt();
            					switch (Choice) {
                    		      
            					case 1 : mode_Add = "online";
            						check = 1;
                    		    	break;
            					case 2 : mode_Add = "cash";
            						check=2;
                    		    	break;
            					case 3 : mode_Add = "atm";
        							check=2;
        							break;
            					default:                    		    	
            						System.out.println("Invalid mode");
            						
                    		    }
            					}
            					System.out.println("selected mode is:" + mode_Add);
            					System.out.println("Please enter amount to be Withdraw:\n");
            					aab = new Scanner(System.in);
                    		    amt= aab.nextInt();
                    		    if (amt == 0)
                    		    {
                    		    	System.out.println("Insufficient Fund\n");
                    		    	flag = 1;
                    		    	break;
                    		    }
                    		    int updated_amt =  Integer.valueOf(values[2]) - amt;
            					System.out.println("Updated Balance is: " + updated_amt);
            					File file = new File("C:\\Users\\Amit Anand\\Desktop\\Lybrate\\account.csv");
            					new CSV(file).set(ind, 3, Integer.toString(updated_amt)).save(file);
            					flag = 1;
            					//updating acount_statement
                    		    int j = 0;               	  
                            	File file_st = new File(filename_at);
                    		    try {
                    				Scanner statement_Stream = new Scanner(file_st);
                    				while(statement_Stream.hasNext())
                    				{
                    					String statement_data = statement_Stream.next(); // reads a whole line
                    					String statement_values[]=statement_data.split(",");
                    					j +=1;
                    				}
                    				statement_Stream.close();
                    				} 
                    		    catch (FileNotFoundException e) 
                    		    {
                    				// TODO Auto-generated catch block
                    				e.printStackTrace();
                    			}
                            	  
                    		    COMMA_DELIMITER = ",";
                    		    DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
                    		    Date date = new Date();
                    		    List<new_transaction> new_txn = new ArrayList<new_transaction>();                     		    
                    		    new_txn.add(new new_transaction(dateFormat.format(date),"Dr",x,amt,updated_amt,mode_Add));
                    		    FileWriter statement_fileWriter = new FileWriter("C:\\Users\\Amit Anand\\Desktop\\Lybrate\\account_statement.csv",true);
                                for( new_transaction p:new_txn ) 
                                {
                                	statement_fileWriter.append(String.valueOf(p.getDt()));
                                	statement_fileWriter.append(COMMA_DELIMITER);
                                	statement_fileWriter.append(p.getAmt_type());
                                	statement_fileWriter.append(COMMA_DELIMITER);
                                	statement_fileWriter.append(String.valueOf(p.getAc_num()));
                                	statement_fileWriter.append(COMMA_DELIMITER);
                                	statement_fileWriter.append(String.valueOf(p.getAmt_st()));
                                	statement_fileWriter.append(COMMA_DELIMITER);
                                	statement_fileWriter.append(String.valueOf(p.getBal_avl()));
                                	statement_fileWriter.append(COMMA_DELIMITER);
                                	statement_fileWriter.append(p.getMd());
                                	statement_fileWriter.append(COMMA_DELIMITER);
                                	statement_fileWriter.append("\n");
                                    
                                }
                                statement_fileWriter.flush();
                                statement_fileWriter.close();
                                System.out.println("Statement is updated");
            					
            					
            				}          					
            					
            				}
            				
            				if(flag == 0)
            					System.out.println("Account not found");
            				inputStream.close();
            		    }
            		    
            				
            		    catch (FileNotFoundException e) 
            		    {
            				// TODO Auto-generated catch block
            				e.printStackTrace();
            			}
                	  break;
                  default:

                      System.out.println("Wrong choice.");

                      break;

                	  
          		    		
          		  }
		    
		    	}while (!quit);
		  }
}
