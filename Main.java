import java.util.*;
public class Task{
    String task;
    boolean completed;
    void Task(String t){
        task=t;
        completed=false;
    }
}
public class Main{
    static Scanner sc=new Scanner(System.in);
    public static void addTask(ArrayList<String>tasks){
        System.out.print("Enter the task: ");
        String t=sc.nextLine();
        tasks.add(t);
    }
    public static void deleteTask(ArrayList<String>tasks){
        System.out.print("Enter the completed the task number : ");
        int index=sc.nextInt();
        sc.nextLine();
        if(index<1 || index>tasks.size()){
            System.out.println("Enter an valid task number.");
            deleteTask(tasks);
        }
        else{
            tasks.remove(index-1);
            viewTask(tasks);
        }
    }
    public static void viewTask(ArrayList<String>tasks){
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
    public static void main(String[] args){
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
                addTask(tasks);
            }
            else if(choice==2){
                deleteTask(tasks);
            }
            else if(choice==3){
                viewTask(tasks);
            }
            else if (choice==4){
                System.out.println("Exiting..............");
                System.out.flush();
                break;
            }
            else{
                System.out.println("Enter an valid choice");
            }
        }
        sc.close();
    }
}