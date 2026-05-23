    import java.util.*;
    class Task{
        private String task;
        private boolean completed;
        Task(String task){
            this.task=task;
            this.completed=false;
        }
        String getTask(){
            return task;
        }
        boolean isCompleted(){
            return completed;
        }
        void markCompleted(){
            this.completed=true;
        }
    }
    public class Main{
        static Scanner sc=new Scanner(System.in);
        public static void addTask(ArrayList<Task>tasks){
            System.out.print("Enter the task: ");
            String t=sc.nextLine();
            tasks.add(new Task(t));
        }
        public static void markCompletedTask(ArrayList<Task>tasks){
            try{
                System.out.print("Enter the completed the task number : ");
                int index=sc.nextInt();
                sc.nextLine();
                tasks.get(index-1).markCompleted();;
                
            }
            catch(InputMismatchException e){
                System.out.println("Enter an valid number.");
                sc.nextLine();
            }
            catch(IndexOutOfBoundsException e){
                System.out.println("Enter an valid number.");
            }
        }
        public static void viewTask(ArrayList<Task>tasks){
            if(tasks.isEmpty()){
                System.out.println("The list is Empty.");
            }
            else{
                System.out.println("Tasks: ");
                int count=1;
                for(Task temp:tasks){
                    String status=(temp.isCompleted())?"[Completed]":"[Pending]";
                    System.out.println(count+"."+
                    temp.getTask()+"  "+
                    status);
                    count++;
                }
            }
        }
        public static void main(String[] args){
            ArrayList<Task> tasks=new ArrayList<>();
            while(true){
                System.out.println("choice\n"+
                "1.Add Task\n"+
                "2.Mark as Completed\n"+
                "3.View Task\n"+
                "4.Exit");
                try{
                    int choice=sc.nextInt();
                    sc.nextLine();
                    if(choice==1){
                        addTask(tasks);
                    }
                    else if(choice==2){
                        markCompletedTask(tasks);
                    }
                    else if(choice==3){
                        viewTask(tasks);
                    }
                    else if (choice==4){
                        System.out.println("Exiting..............");
                        break;
                    }
                    else{
                        System.out.println("Enter an valid choice");
                    }
                }
                catch(InputMismatchException e){
                    System.out.println("Enter an valid choice");
                    sc.nextLine();
                    continue;
                }
            }
            sc.close();
        }
    }