import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        ArrayList<String> tasks=new ArrayList<>();
        while(true){
            System.out.println("choice\n"+
            "1.add\n"+
            "2.delete\n"+
            "3.view\n"+
            "4.exit");
            int choice=sc.nextInt();
            sc.nextLine();
            if(choice==1){
                System.out.println("Enter the task");
                String t=sc.nextLine();
                tasks.add(t);
            }
            else if(choice==2){
                System.out.println("Enter the completed the task number");
                int index=sc.nextInt();
                tasks.remove(index-1);
            }
            else if(choice==3){
                if(tasks.isEmpty()){
                    System.out.println("The list is Empty.");
                }
                else{
                    System.out.println("Tasks: ");
                    for(int i=0;i<tasks.size();i++){
                        System.out.println((i+1)+"."+tasks.get(i));
                    }
                }
            }
            else{
                break;
            }
        }
        sc.close();
    }
}