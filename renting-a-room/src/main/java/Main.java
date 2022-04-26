import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

//***** Class Meal *****
class Meal implements Serializable
{
    int itemnumber;
    int quantity;
    float price;

    Meal(int itemnumber,int quantity)
    {
        this.itemnumber=itemnumber;
        this.quantity=quantity;
        switch(itemnumber)
        {
            case 1:price=quantity*70;
                break;
            case 2:price=quantity*80;
                break;
            case 3:price=quantity*40;
                break;
            case 4:price=quantity*20;
                break;
        }
    }
}

//****** Class Meal *******
class OneRoom implements Serializable
{
    String name;
    String contact;
    String gender;
    ArrayList<Meal> meal =new ArrayList<>();


    OneRoom()
    {
        this.name="";
    }
    OneRoom(String name,String contact,String gender)
    {
        this.name=name;
        this.contact=contact;
        this.gender=gender;
    }
}

// ******* Class TwoRooms *******
class TwoRooms extends OneRoom implements Serializable
{
    String name1;
    String contact1;
    String gender1;

    TwoRooms()
    {
        this.name="";
        this.name1="";
    }
    TwoRooms(String name,String contact,String gender,String name1,String contact1,String gender1)
    {
        this.name=name;
        this.contact=contact;
        this.gender=gender;
        this.name1=name1;
        this.contact1=contact1;
        this.gender1=gender1;
    }
}


// ****** Class AlreadyBooked ******
class AlreadyBooked extends Exception
{
    @Override
    public String toString()
    {
        return "This is Already Booked !";
    }
}


//****** Class Customer *******
class Customer implements Serializable
{
    TwoRooms luxury_tworooms[]=new TwoRooms [20]; //Luxury
    TwoRooms deluxe_tworooms[]=new TwoRooms [30]; //Deluxe
    OneRoom luxury_oneroom[]=new OneRoom [20]; //Luxury
    OneRoom deluxe_oneroom[]=new OneRoom [30]; //Deluxe
}

//******* Class Hotel *******
class Hotel
{
    static Customer hotel_ob=new Customer();
    static Scanner sc = new Scanner(System.in);
    static void CustDetails(int i,int rn)
    {
        String name, contact, gender;
        String name1 = null, contact1 = null;
        String gender1="";
        System.out.print("\nEnter customer name: ");
        name = sc.next();
        System.out.print("Enter contact number: ");
        contact=sc.next();
        System.out.print("Enter gender: ");
        gender = sc.next();
        if(i<3)
        {
            System.out.print("Enter second customer name: ");
            name1 = sc.next();
            System.out.print("Enter contact number: ");
            contact1=sc.next();
            System.out.print("Enter gender: ");
            gender1 = sc.next();
        }

        switch (i) {
            case 1:hotel_ob.luxury_tworooms[rn]=new TwoRooms(name,contact,gender,name1,contact1,gender1);
                break;
            case 2:hotel_ob.deluxe_tworooms[rn]=new TwoRooms(name,contact,gender,name1,contact1,gender1);
                break;
            case 3:hotel_ob.luxury_oneroom[rn]=new OneRoom(name,contact,gender);
                break;
            case 4:hotel_ob.deluxe_oneroom[rn]=new OneRoom(name,contact,gender);
                break;
            default:System.out.println("Wrong Choice");
                break;
        }
    }

    static void bookroom(int i)
    {
        int j;
        int rn;
        System.out.println("\nChoose room number from : ");
        switch (i) {
            case 1:
                for(j=0;j<hotel_ob.luxury_tworooms.length;j++)
                {
                    if(hotel_ob.luxury_tworooms[j]==null)
                    {
                        System.out.print(j+1+",");
                    }
                }
                System.out.print("\nEnter room number: ");
                try{
                    rn=sc.nextInt();
                    rn--;
                    if(hotel_ob.luxury_tworooms[rn]!=null)
                        throw new AlreadyBooked();
                    CustDetails(i,rn);
                }
                catch(Exception e)
                {
                    System.out.println("Invalid Option");
                    return;
                }
                break;

            case 2:
                for(j=0;j<hotel_ob.deluxe_tworooms.length;j++)
                {
                    if(hotel_ob.deluxe_tworooms[j]==null)
                    {
                        System.out.print(j+11+",");
                    }
                }
                System.out.print("\nEnter room number: ");
                try{
                    rn=sc.nextInt();
                    rn=rn-11;
                    if(hotel_ob.deluxe_tworooms[rn]!=null)
                        throw new AlreadyBooked();
                    CustDetails(i,rn);
                }
                catch(Exception e)
                {
                    System.out.println("Invalid Option");
                    return;
                }
                break;

            case 3:
                for(j=0;j<hotel_ob.luxury_oneroom.length;j++)
                {
                    if(hotel_ob.luxury_oneroom[j]==null)
                    {
                        System.out.print(j+31+",");
                    }
                }
                System.out.print("\nEnter room number: ");
                try{
                    rn=sc.nextInt();
                    rn=rn-31;
                    if(hotel_ob.luxury_oneroom[rn]!=null)
                        throw new AlreadyBooked();
                    CustDetails(i,rn);
                }
                catch(Exception e)
                {
                    System.out.println("Invalid Option");
                    return;
                }
                break;
            case 4:
                for(j=0;j<hotel_ob.deluxe_oneroom.length;j++)
                {
                    if(hotel_ob.deluxe_oneroom[j]==null)
                    {
                        System.out.print(j+41+",");
                    }
                }
                System.out.print("\nEnter room number: ");
                try{
                    rn=sc.nextInt();
                    rn=rn-41;
                    if(hotel_ob.deluxe_oneroom[rn]!=null)
                        throw new AlreadyBooked();
                    CustDetails(i,rn);
                }
                catch(Exception e)
                {
                    System.out.println("Invalid Option");
                    return;
                }
                break;
            default:
                System.out.println("Enter valid option");
                break;
        }
        System.out.println("Room Booked");
    }

    static void features(int i)
    {
        switch (i) {
            case 1:System.out.println("Number of double beds : 1\n" +
                    "AC : Yes\n" +
                    "Free breakfast : Yes\n" +
                    "Charge per day:5000 ");
                break;

            case 2:System.out.println("Number of double beds : 1\n" +
                    "AC : No\n" +
                    "Free breakfast : Yes\n" +
                    "Charge per day:4000  ");
                break;

            case 3:System.out.println("Number of single beds : 1\n" +
                    "AC : Yes\n" +
                    "Free breakfast : Yes\n" +
                    "Charge per day:2400  ");
                break;

            case 4:System.out.println("Number of single beds : 1\n" +
                    "AC : No\n" +
                    "Free breakfast : Yes\n" +
                    "Charge per day:1800 ");
                break;

            default:
                System.out.println("Enter valid option");
                break;
        }
    }

    static void availability(int i)
    {
        int j,count=0;
        switch (i) {
            case 1:
                for(j=0;j<10;j++)
                {
                    if(hotel_ob.luxury_tworooms[j]==null)
                        count++;
                }
                break;

            case 2:
                for(j=0;j<hotel_ob.deluxe_tworooms.length;j++)
                {
                    if(hotel_ob.deluxe_tworooms[j]==null)
                        count++;
                }
                break;

            case 3:
                for(j=0;j<hotel_ob.luxury_oneroom.length;j++)
                {
                    if(hotel_ob.luxury_oneroom[j]==null)
                        count++;
                }
                break;

            case 4:
                for(j=0;j<hotel_ob.deluxe_oneroom.length;j++)
                {
                    if(hotel_ob.deluxe_oneroom[j]==null)
                        count++;
                }
                break;

            default:
                System.out.println("Enter valid option");
                break;
        }
        System.out.println("Number of rooms available : "+count);
    }

    static void bill(int rn,int rtype)
    {
        double amount=0;
        String list[]={"Sandwich","Pasta","Noodles","Coke"};
        System.out.println("\n*******");
        System.out.println(" Bill:-");
        System.out.println("*******");

        switch(rtype)
        {
            case 1:
                amount+=5000;
                System.out.println("\nRoom Charge - "+5000);
                System.out.println("\n===============");
                System.out.println("Meal Charges:- ");
                System.out.println("===============");
                System.out.println("Item   Quantity    Price");
                System.out.println("-------------------------");
                for(Meal obb:hotel_ob.luxury_tworooms[rn].meal)
                {
                    amount+=obb.price;
                    String format = "%-10s%-10s%-10s%n";
                    System.out.printf(format,list[obb.itemnumber-1],obb.quantity,obb.price );
                }
                break;

            case 2:amount+=4000;
                System.out.println("Room Charge - "+4000);
                System.out.println("\nMeal Charges:- ");
                System.out.println("===============");
                System.out.println("Item   Quantity    Price");
                System.out.println("-------------------------");
                for(Meal obb:hotel_ob.deluxe_tworooms[rn].meal)
                {
                    amount+=obb.price;
                    String format = "%-10s%-10s%-10s%n";
                    System.out.printf(format,list[obb.itemnumber-1],obb.quantity,obb.price );
                }
                break;

            case 3:amount+=2400;
                System.out.println("Room Charge - "+2400);
                System.out.println("\nMeal Charges:- ");
                System.out.println("===============");
                System.out.println("Item   Quantity    Price");
                System.out.println("-------------------------");
                for(Meal obb:hotel_ob.luxury_oneroom[rn].meal)
                {
                    amount+=obb.price;
                    String format = "%-10s%-10s%-10s%n";
                    System.out.printf(format,list[obb.itemnumber-1],obb.quantity,obb.price );
                }
                break;


            case 4:amount+=1800;
                System.out.println("Room Charge - "+1800);
                System.out.println("\nMeal Charges:- ");
                System.out.println("===============");
                System.out.println("Item   Quantity    Price");
                System.out.println("-------------------------");
                for(Meal obb: hotel_ob.deluxe_oneroom[rn].meal)
                {
                    amount+=obb.price;
                    String format = "%-10s%-10s%-10s%n";
                    System.out.printf(format,list[obb.itemnumber-1],obb.quantity,obb.price );
                }
                break;

            default:
                System.out.println("Invalid");
        }
        System.out.println("\nTotal Amount- "+amount);
    }

    static void deallocate(int rn,int rtype)
    {
        int j;
        char w;
        switch (rtype) {
            case 1:
                if(hotel_ob.luxury_tworooms[rn]!=null)
                    System.out.println("Room used by "+hotel_ob.luxury_tworooms[rn].name);
                else
                {
                    System.out.println("Empty Already");
                    return;
                }
                System.out.println("Do you want to checkout ?(y/n)");
                w=sc.next().charAt(0);
                if(w=='y'||w=='Y')
                {
                    bill(rn,rtype);
                    hotel_ob.luxury_tworooms[rn]=null;
                    System.out.println("Deallocated successfully");
                }
                break;

            case 2:
                if(hotel_ob.deluxe_tworooms[rn]!=null)
                    System.out.println("Room used by "+hotel_ob.deluxe_tworooms[rn].name);
                else
                {
                    System.out.println("Empty Already");
                    return;
                }
                System.out.println(" Do you want to checkout ?(y/n)");
                w=sc.next().charAt(0);
                if(w=='y'||w=='Y')
                {
                    bill(rn,rtype);
                    hotel_ob.deluxe_tworooms[rn]=null;
                    System.out.println("Deallocated successfully");
                }
                break;


            case 3:
                if(hotel_ob.luxury_oneroom[rn]!=null)
                    System.out.println("Room used by "+hotel_ob.luxury_oneroom[rn].name);
                else
                {
                    System.out.println("Empty Already");
                    return;
                }
                System.out.println(" Do you want to checkout ? (y/n)");
                w=sc.next().charAt(0);
                if(w=='y'||w=='Y')
                {
                    bill(rn,rtype);
                    hotel_ob.luxury_oneroom[rn]=null;
                    System.out.println("Deallocated successfully");
                }
                break;


            case 4:
                if(hotel_ob.deluxe_oneroom[rn]!=null)
                    System.out.println("Room used by "+hotel_ob.deluxe_oneroom[rn].name);
                else
                {
                    System.out.println("Empty Already");
                    return;
                }
                System.out.println(" Do you want to checkout ? (y/n)");
                w=sc.next().charAt(0);
                if(w=='y'||w=='Y')
                {
                    bill(rn,rtype);
                    hotel_ob.deluxe_oneroom[rn]=null;
                    System.out.println("Deallocated successfully");
                }
                break;
            default:
                System.out.println("\nEnter valid option : ");
                break;
        }
    }

    static void order(int rn,int rtype)
    {
        int i,q;
        char wish;
        try{
            System.out.println("\n==========\n   " +
                    "Menu:  \n==========\n\n1.Sandwich\t$ 20\n2.Pasta\t\t$ 30\n3.Noodles\t$ 40\n4.Coke\t\t$ 20\n");
            do
            {
                i = sc.nextInt();
                System.out.print("Quantity- ");
                q=sc.nextInt();

                switch(rtype){
                    case 1: hotel_ob.luxury_tworooms[rn].meal.add(new Meal(i,q));
                        break;

                    case 2: hotel_ob.deluxe_tworooms[rn].meal.add(new Meal(i,q));
                        break;

                    case 3: hotel_ob.luxury_oneroom[rn].meal.add(new Meal(i,q));
                        break;

                    case 4: hotel_ob.deluxe_oneroom[rn].meal.add(new Meal(i,q));
                        break;
                }
                System.out.println("Do you want to order anything else ? (y/n)");
                wish=sc.next().charAt(0);
            }while(wish=='y'||wish=='Y');
        }
        catch(NullPointerException e)
        {
            System.out.println("\nRoom not booked");
        }
        catch(Exception e)
        {
            System.out.println("Cannot be done");
        }
    }
}

// ****** Class Write ******
class Write implements Runnable
{
    Customer hotel_ob;
    Write(Customer hotel_ob)
    {
        this.hotel_ob=hotel_ob;
    }
    @Override
    public void run() {
        try{
            FileOutputStream fout =new FileOutputStream("backup");
            ObjectOutputStream oos =new ObjectOutputStream(fout);
            oos.writeObject(hotel_ob);
        }
        catch(Exception e)
        {
            System.out.println("Oops, something wrong..Please check it again and try again! "+e);
        }

    }

}

public class Main {
    public static void main(String[] args){

        try
        {
            File f = new File("backup");
            if(f.exists())
            {
                FileInputStream fin=new FileInputStream(f);
                ObjectInputStream ois=new ObjectInputStream(fin);
                Hotel.hotel_ob=(Customer)ois.readObject();
            }
            Scanner sc = new Scanner(System.in);
            int ch,ch2;
            char wish;
            x:
            do{

                System.out.println("\nEnter your choice :\n" +
                        "1.Display room details\n" +
                        "2.Display room availability \n" +
                        "3.Book\n" +
                        "4.Order food\n" +
                        "5.Checkout\n" +
                        "6.Exit\n");
                ch = sc.nextInt();
                switch(ch){
                    case 1: System.out.println("\nChoose room type :\n" +
                            "1.Luxury Two Rooms \n" +
                            "2.Deluxe Two Rooms \n" +
                            "3.Luxury One Room \n" +
                            "4.Deluxe One Room\n");
                        ch2 = sc.nextInt();
                        Hotel.features(ch2);
                        break;

                    case 2:System.out.println("\nChoose room type :\n" +
                            "1.Luxury Two Rooms \n" +
                            "2.Deluxe Two Rooms \n" +
                            "3.Luxury One Room\n" +
                            "4.Deluxe One Room\n");
                        ch2 = sc.nextInt();
                        Hotel.availability(ch2);
                        break;

                    case 3:System.out.println("\nChoose room type :\n" +
                            "1.Luxury Two Rooms \n" +
                            "2.Deluxe Double Room \n" +
                            "3.Luxury Single Room\n" +
                            "4.Deluxe Single Room\n");
                        ch2 = sc.nextInt();
                        Hotel.bookroom(ch2);
                        break;


                    case 4:
                        System.out.print("Room Number -");
                        ch2 = sc.nextInt();

                        if(ch2>60)
                            System.out.println("Room doesn't exist");

                        else if(ch2>40)
                            Hotel.order(ch2-41,4);

                        else if(ch2>30)
                            Hotel.order(ch2-31,3);
                        else if(ch2>10)
                            Hotel.order(ch2-11,2);
                        else if(ch2>0)
                            Hotel.order(ch2-1,1);
                        else
                            System.out.println("Room doesn't exist");
                        break;


                    case 5:
                        System.out.print("Room Number -");
                        ch2 = sc.nextInt();
                        if(ch2>60)
                            System.out.println("Room doesn't exist");
                        else if(ch2>40)
                            Hotel.deallocate(ch2-41,4);
                        else if(ch2>30)
                            Hotel.deallocate(ch2-31,3);
                        else if(ch2>10)
                            Hotel.deallocate(ch2-11,2);
                        else if(ch2>0)
                            Hotel.deallocate(ch2-1,1);
                        else
                            System.out.println("Room doesn't exist");
                        break;

                    case 6:break x;

                }

                System.out.println("\nContinue : (y/n)");
                wish=sc.next().charAt(0);
                if(!(wish=='y'||wish=='Y'||wish=='n'||wish=='N'))
                {
                    System.out.println("Invalid Option");
                    System.out.println("\nContinue : (y/n)");
                    wish=sc.next().charAt(0);
                }

            }while(wish=='y'||wish=='Y');

            Thread t=new Thread(new Write(Hotel.hotel_ob));
            t.start();
        }
        catch(Exception e)
        {
            System.out.println("Not a valid input");
        }
    }
}


