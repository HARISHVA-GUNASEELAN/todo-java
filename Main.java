    import java.util.*;
    import java.io.*;
    class Task{
        private int ID;
        private String task;
        private boolean completed;
        Task(int ID,String task){
            this.ID=ID;
            this.task=task;
            this.completed=false;
        }
        Task(int ID,String task,boolean completed){
            this.ID=ID;
            this.task=task;
            this.completed=completed;
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
        static final String FILE_NAME="task.txt";
        public static void addTask(ArrayList<Task>tasks){
            System.out.print("Enter the task: ");
            String t=sc.nextLine();
            tasks.add(new Task(taskId,t));
            taskId++;
            saveTask(tasks);
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
                        saveTask(tasks);
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
                        saveTask(tasks);
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
        public static void saveTask(ArrayList<Task> tasks){
            try{
                BufferedWriter writer=new BufferedWriter(new FileWriter(FILE_NAME));
                for(Task temp:tasks){
                    writer.write(
                        temp.getID()+"|"+
                        temp.getTask()+"|"+
                        temp.isCompleted()+"|"
                    );
                    writer.write("\n");
                }
                writer.close();
            }
            catch(IOException e){
                System.out.println("Error occured while saving.");
            }
        }
        public static void loadTask(ArrayList<Task> tasks){
            File file=new File(FILE_NAME);
            if(!file.exists()){
                return;
            }
            try{
                BufferedReader reader=new BufferedReader(new FileReader(FILE_NAME));
                String line;
                while((line=reader.readLine())!=null){
                    String[] parts=line.split("\\|");
                    int id=Integer.parseInt(parts[0]);
                    String task=parts[1];
                    boolean completed=Boolean.parseBoolean(parts[2]);
                    tasks.add(new Task(id,task,completed));

                    if(id>=taskId){
                        taskId=id+1;
                    }
                }

            }
            catch(IOException e){
                System.out.println("Their is an error in loaading a file");
            }
        }
        public static void main(String[] args){
            ArrayList<Task> tasks=new ArrayList<>();
            loadTask(tasks);
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