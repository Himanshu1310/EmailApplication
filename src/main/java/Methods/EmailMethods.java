package Methods;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Random;
import java.util.Scanner;
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EmailMethods {
    public Scanner s = new Scanner(System.in);
    private String fname;
    private String lname;
    private String dept;
    private String email;
    private String password;
    private int mailCapacity = 500;

    private String alterEmail;
//enter email
    public EmailMethods(String fname, String lname) {
        this.fname = fname;
        this.lname = lname;
        System.out.println("New Employee: " + this.fname + " " + this.lname);
    }
//generate new email
    private String generateEmail() {
        return this.fname.toLowerCase() + "." + this.lname.toLowerCase() + "@" + this.dept.toLowerCase() + ".company.com";
    }
//set department
    private String setDept() {
        System.out.println("Department codes \n1 for Sales \n2 for Development \n3 for Accounting \n0 for none");
        boolean flag = false;
        do {
            System.out.println("Enter Department code: ");
            int choice = s.nextInt();
            switch (choice) {
                case 1:
                    return "Sales";
                case 2:
                    return "Development";
                case 3:
                    return "Accounting";
                case 0:
                    return "None";
                default:
                    System.out.println("Invalid Choice, please choose it again");
            }

        } while (flag);
        return null;
    }
//generate new random password
    private String generatePassword(int length) {
        Random r = new Random();
        String capitalLetters = "[AZ]";
        String smallLetters = "[az]";
        String numbers = "[09]";
        String symbol = "!@#$%^&*()+_";
        String values = capitalLetters + smallLetters + numbers + symbol;
        for (int i = 0; i < length; i++) {
            password = password + values.charAt(r.nextInt(values.length()));
        }
        return password;
    }
// set password
    public void setPassword() {
        boolean flag = false;
        do {
            System.out.println("Do you want to change your password ?");
            char choice = s.next().charAt(0);
            if (choice == 'Y' || choice == 'y')
            {
                flag = true;
                System.out.println("Enter Current Password: ");
                String temp = s.next();
                if (temp.equals(this.password)) {
                    System.out.println("Enter New Password: ");
                    this.password = s.next();
                    System.out.println("Password changed Successfully.");
                } else
                {
                    System.out.println("Incorrect Password !");
                }
            }
            else if (choice == 'N' || choice == 'n') {
                flag = true;
                System.out.println("Password Changed option cancelled.");

            }
            else{
                System.out.println("Enter valid choice");
            }


        }while (!flag);
    }
    // set new mailbox capacity
    public void setMail(){
        System.out.println("Current capacity = " + this.mailCapacity+"mb");
        System.out.println("Enter new mailbox capacity = ");
        this.mailCapacity = s.nextInt();
        System.out.println("Mailbox capacity is successfully changed to "+this.mailCapacity);
    }
}

