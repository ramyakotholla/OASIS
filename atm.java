import java.util.*;
class atm{
    static class hist{
        String to,from;
        int balance;
        hist(String t,String f,int b){
            this.to=t;
            this.from=f;
            this.balance=b;
        }
    }    
    String number;
    int bal;
    public atm(String s,int bal){
        this.bal=bal;
        this.number=s;
    }
    public static void main(String[] args){
        //atm a=new atm();
        Scanner sc=new Scanner(System.in);
        atm p1=new atm("234123",100000);
        atm p2=new atm("123123",200000);
        atm p3=new atm("451234",300000);
        ArrayList<atm> list=new ArrayList<>();
        ArrayList<hist> list1=new ArrayList<>();
        list.add(p1);
        list.add(p2);
        list.add(p3);
        int k=0;
        do{            
            System.out.println("1.Transfer\n2.Debit\n3.Credit\n4.Transfer History\n5.Quit\n");
            System.out.print("enter your choice: ");
            k=sc.nextInt();
                        
            switch (k) {
                case 1:{
                    System.out.println("enter account number");
                    String s=sc.next();
                    atm.transfer(s,list,list1);
                    break;
                }
                case 2:{
                    System.out.println("enter account number");
                    String s=sc.next();
                    atm.debit(s,list,list1);
                    break;
                }
                case 3:{
                    System.out.println("enter account number");
                    String s=sc.next();
                    atm.credit(s,list,list1);
                    break;
                }
                case 4:{
                    System.out.println("enter account number");
                    String s=sc.next();
                    atm.history(s,list1);
                    break;
                }
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("please enter a valid number");
                    break;
            }
        }while(k!=5);
    }
    public static void credit(String s,ArrayList<atm> list,ArrayList<hist> list1){
        int f=0;
        for(atm i:list){
            if(s.equals(i.number)){
                f=1;
                Scanner sc=new Scanner(System.in);
                System.out.println("enter amount:");
                int k=sc.nextInt();
                i.bal=i.bal+k;
                System.out.println("Account Balance "+i.bal);
                break;
            }
        }
        if(f==0){
            System.out.println("invalid account number");
            return;
        }        
    }
    public static void debit(String s,ArrayList<atm> list,ArrayList<hist> list1){
        int f=0;
        for(atm i:list){
            if(s.equals(i.number)){
                f=1;
                Scanner sc=new Scanner(System.in);
                System.out.println("entet amount");
                int k=sc.nextInt();
                if(k>i.bal)
                    System.out.println("amount is "+i.bal);
                else
                    i.bal=i.bal-k;
                System.out.println("Account Balance "+i.bal);
                break;
            }
        }
        if(f==0){
            System.out.println("invalid account number");
            return;
        }
       
    }
    public static void transfer(String s,ArrayList<atm> list,ArrayList<hist> list1){
        int f=0;
        for(atm i:list){
            if(s.equals(i.number)){
                f=1;
                Scanner sc=new Scanner(System.in);
                System.out.println("account number to which u want to trasform");
                String s1=sc.next(); 
                int l=0;
                for(atm j:list){
                    if(s1.equals(j.number)){
                        l=1;
                        System.out.println("enter amount");
                        int k=sc.nextInt();
                        j.bal=j.bal+k;
                        i.bal=i.bal-k;
                        System.out.println("account "+i.number+" balance is "+i.bal+"\naccount "+j.number+" balance is "+j.bal);
                        hist h=new hist(s,s1,k);
                        list1.add(h);
                        break;
                    }
                }
                if(l==0){
                    System.out.println("invalid account number");
                    return;
                }                      
                break;
            }
        }
        if(f==0){
            System.out.println("invalid account number");
            return;
        }                
    }
    public static void history(String s,ArrayList<hist> list1){
        for(hist i:list1){
            if(s.equals(i.to)||s.equals(i.from))
                System.out.println("From Account "+i.from+" to "+i.to);
        }
        return;
    }
}