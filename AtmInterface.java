import java.util.Scanner;
class BankAccount{
    String name;
    String password;
    String Account_No, Register_Username;
    float CurrentBalance=100000f;
    String TransactionHistory="";
    int transaction=0;

    //for registration
    public void Register(){
        Scanner sc =new Scanner(System.in);
        System.out.println("***********Welcome to registration process of atm interface**********");
        System.out.println();
        System.out.println("Enter the Account Name");
        this.name=sc.nextLine();
        System.out.println("Enter the Username");
        this.Register_Username=sc.nextLine();
        System.out.println("Enter you account number");
        this.Account_No=sc.nextLine();

        System.out.println("Enter you password");
        this.password=sc.nextLine();
    }

    public void Login(){
        System.out.println("Welcome to Login process of atm interface");
        System.out.println();

        Scanner sc=new Scanner(System.in);
        System.out.println("Enter your username");
        String username=sc.nextLine();
        if(username.equals(Register_Username)){
            System.out.println("Enter your password");
            String pass=sc.nextLine();
            if(pass.equals(password)){
                System.out.println("successfully login");
            }
            // else{
            //     System.out.println("wrong password");
            // }
        }else{
            System.out.println("Wrong username or password");

        }
    }
    public void withdraw(){
        System.out.println("enter amount of money you want to withdraw");
        Scanner sc=new Scanner(System.in);
        float money=sc.nextFloat();
        if(CurrentBalance>=money){
            transaction++;
            CurrentBalance=CurrentBalance-money;
            System.out.println("withdraw successfully" );
            System.out.println("current amount  =" +CurrentBalance );
            String str=money+" Rs current bank amount";
            TransactionHistory=TransactionHistory.concat(str);
            transactionHistory();
        }
        else{
            System.out.println("Not have this much amount to withdraw");
        }

    }

    public void deposit(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the amount you want to deposit");
        float deposit_amount=sc.nextFloat();
        if(deposit_amount<=100000f){
            CurrentBalance=CurrentBalance+deposit_amount;
            transaction++;
        }
        if(deposit_amount<=100000f){
            CurrentBalance=CurrentBalance+deposit_amount;
            transaction++;
            System.out.println("Successfully deposited");
            System.out.println("Current Amount  =" +CurrentBalance );

            String str=deposit_amount+"Rs current bank amount";
            TransactionHistory=TransactionHistory.concat(str);
            transactionHistory();
        }else{
            System.out.println("Out of limit");
        }

    }
    public void transfer(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the amount you want to transfer");
        float transfer_amount=sc.nextFloat();
        if(CurrentBalance>=transfer_amount){
            CurrentBalance=CurrentBalance-transfer_amount;
            System.out.println("You have successfully transfered= "+ transfer_amount);
            System.out.println("Current Amount  =" +CurrentBalance );
            String str=transfer_amount+ "Rs current bank amount";
            TransactionHistory=TransactionHistory.concat(str);
            transactionHistory();
        }else{
            System.out.println("Sorry you don't have sufficient amount");
        }

    }

    public void  transactionHistory(){
        if(transaction==0){
            System.out.println("No exchange of money");
        }else{
            System.out.println(TransactionHistory);
        }
    }
}

public class AtmInterface{
    public static void main(String args[]){
        System.out.println();
        System.out.println("*********************WELCOME TO ATM INTERFACE****************************");
        System.out.println("ENTER:   1.REGISTER    2.EXIT");
        Scanner sc=new Scanner(System.in);
        int input=sc.nextInt();
        if(input==1){
            BankAccount bank=new BankAccount();
            bank.Register();
            while(true){
                System.out.println("Enter:          1.Login         2.Exit");
                System.out.println("Enter the choice:");
                Scanner sc1=new Scanner(System.in);
                int choice=sc1.nextInt();
                if(choice==1){
                    bank.Login();
                        System.out.println("1. withdraw  2.deposit  3.transfer   4.transaction history");
                        System.out.println("Enter the choice");
                        Scanner sc2=new Scanner(System.in);
                        int ch=sc2.nextInt();
                        switch(ch){
                            case 1:
                            bank.withdraw();
                            break;

                            case 2:
                            bank.deposit();
                            break;

                            case 3:
                            bank.transfer();
                            break;

                            default: 
                            System.out.println("there is no such option");
                        }
                    }else{
                        System.exit(0);
                    }
                }
            }else{
                System.exit(0);
            }
        }
    }