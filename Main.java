    import java.util.*;
    class Task{
        private int ID;
        private String task;
        private boolean completed;
        Task(int ID,String task){
            this.ID=ID;
            this.task=task;
            this.completed=false;
        }
        int getID(){
            return ID;
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
        static int taskId=1;
        public static void addTask(ArrayList<Task>tasks){
            System.out.print("Enter the task: ");
            String t=sc.nextLine();
            tasks.add(new Task(taskId,t));
            taskId++;
        }
        public static void markCompletedTask(ArrayList<Task>tasks){
            try{
                System.out.print("Enter the completed task ID : ");
                int index=sc.nextInt();
                sc.nextLine();
                boolean found=false;
                for(Task temp:tasks){
                    if(temp.getID()==index){
                        found=true;
                        temp.markCompleted();
                        break;
                    }
                }
                if(!found){
                    System.out.println("Enter an valid Task ID");
                }
            }
            catch(InputMismatchException e){
                System.out.println("Enter an valid number.");
                sc.nextLine();
            }
            /*catch(IndexOutOfBoundsException e){
                System.out.println("Enter an valid number.");
            }*/
        }
        public static void deleteTask(ArrayList<Task>tasks){
            try{
                System.out.println("Enter the task ID to delete: ");
                int index=sc.nextInt();
                sc.nextLine();
                boolean found=false;
                for(Task temp:tasks){
                    if(temp.getID()==index){
                        tasks.remove(temp);
                        found=true;
                        break;
                    }
                }
                if(!found){
                    System.out.println("Enter a valid TaskID");
                }
            }
            catch(InputMismatchException e){
                System.out.println("Enter a valid  Number.");
            }
            /*catch(IndexOutOfBoundsException e){
                System.out.println("Enter a valid Task Number.");
            }*/
        }
        public static void viewTask(ArrayList<Task>tasks){
            if(tasks.isEmpty()){
                System.out.println("The list is Empty.");
            }
            else{
                System.out.println("Tasks: ");
                for(Task temp:tasks){
                    String status=(temp.isCompleted())?"[X]":"[ ]";
                    System.out.println(temp.getID()+". "+
                    status+"  "+
                    temp.getTask());
                }
            }
        }
        public static void main(String[] args){
            ArrayList<Task> tasks=new ArrayList<>();
            while(true){
                System.out.println("choice\n"+
                "1.Add Task\n"+
                "2.Mark as Completed\n"+
                "3.Delete Task\n"+
                "4.View Task\n"+
                "5.Exit");
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
                        deleteTask(tasks);
                    }
                    else if (choice==4){
                        viewTask(tasks);
                    }
                    else if(choice==5){
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