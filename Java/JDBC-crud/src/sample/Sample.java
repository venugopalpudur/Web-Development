package sample;
import java.util.*;
import java.util.stream.Collectors;

public class Sample {

    public static void main(String[] args) {
        
        int[] serial = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
        String[] StName = {"Ananth", "Bhagath", "Chaya", "Esharath", "Bhagath", "Chaya", "Ananth", "Davanth", "Bhagath", "Ananth", "Bhagath", "Chaya", "Bhagath", "Ananth", "Ananth", "Bhagath", "Ananth", "Chaya", "Ananth", "Chaya"};
        String[] subject = {"Electro Fields", "Electro Fields", "Electro Fields", "Electro Fields", "Electro Fields", "Electro Fields", "Electro Fields", "Electro Fields", "Electro Fields", "Electro Fields", "Electro Fields", "Electro Fields", "Electro Fields", "Computing Techniques", "Electro Fields", "Computing Techniques", "Electro Fields", "Computing Techniques", "Electro Fields", "Electro Fields",};
        String[] assCat = {"test_1", "test_1", "test_1", "test_1", "quiz_1", "lab_1", "project_1", "project_1", "quiz_2", "quiz_1", "lab_1", "project_1", "project_1", "test_1", "quiz_2", "project_1", "lab_1", "quiz_1", "test_2", "test_2"};
        String[] DoS = {"21-Jul-16", "21-Jul-16", "21-Jul-16", "21-Jul-16", "22-Jul-16", "23-Jul-16", "24-Jul-16", "24-Jul-16", "25-Jul-16", "26-Jul-16", "27-Jul-16", "28-Jul-16", "28-Jul-16", "29-Jul-16", "29-Jul-16", "30-Jul-16", "30-Jul-16", "31-Jul-16", "1-Aug-16", "1-Aug-16",};
        int[] points = {100,78,68,87,20,10,100,100,50,100,10,100,100,86,100,100,100,20,100,92};
        
        String[] assCatDist = {"test", "quiz", "lab work", "project"};
        int[] weights = {40, 20, 10, 30}; // while inserting new data check for sum = 100
        
        
        
        
        //-------------------- JDBC-------------------
        jdbc jd = new jdbc();
        try{
           jd.connect(); 
           jd.createTb();
           jd.preloadInserTb(serial,StName, subject, assCat, DoS, points, assCatDist, weights);
           //jd.retrieve();
        }
        catch(Exception e){
            System.out.println(e);
        }
        
        
        
        
        
        
        
        
        List<String> DistCat = new ArrayList<String>();
        DistCat = Arrays.stream(assCatDist).collect(Collectors.toList());
        List<Integer> wts = new ArrayList<Integer>();
        wts=Arrays.stream(weights).boxed().collect(Collectors.toList());
        
        List<info> list = new ArrayList<info>();
        Set<String> subSet = new HashSet<String>(Arrays.asList(subject));
        String[] sub = subSet.toArray(new String[subSet.size()]);
        Set<String> subSet2 = new HashSet<String>(Arrays.asList(StName));
        String[] StuName = subSet2.toArray(new String[subSet2.size()]);
    
        for(int i=0; i<serial.length; i++){
            list.add(new info(serial[i], StName[i], subject[i], assCat[i], DoS[i], points[i]));      
        }
    
        Scanner sc = new Scanner(System.in);
        Scanner sc1 = new Scanner(System.in);
        Scanner inp = new Scanner(System.in);
        String cont="";
        
        //crudOperation crud = new crudOperation(list);
 
        do{                        
            System.out.println("1 - Change Assessment Category\n2 - Add Info\n3 - Delete Info\n4 - Update Info\n5 - Show Info\n6 - Rating by Student Name\n7 - Rating by Subject Name");
            int choise = inp.nextInt();
            switch(choise){
                case 1: 
                        System.out.println("Press\n1 - To Add Category & Weights \n2 - To Delete Category & Weights\n3 - To delete all data");
                         int dd =inp.nextInt();
                         if(dd==1){
                             System.out.println("Add Assignment Category :");
                             String str = sc.next();
                             System.out.println("Add Assignment Category respective weights :");
                             int marks = sc.nextInt();
                             if(jd.insertDist(str,marks)){
                                 System.out.println("Assginment Category details added");
                             }else{
                                 DistCat.add(str);
                                 wts.add(marks); // while inserting new data check for all marks sum = 100
                             }
                         }
                         else if(dd==2){
                             System.out.println("Delete Assignment Category :");
                             String dell = sc.next().toLowerCase();
                             if(jd.deleteDist(dell)){
                                System.out.println("Assignment Category"+dell+" deleted successfully");
                             }
                            
                         }else if(dd==3){
                             if(jd.deleteAssesAll()){
                                System.out.println("Assignment Category List deleted successfully");
                             }
                         }
                         else{
                             System.out.println("Wrong Choice");
                         }
                    break;
                case 2: System.out.print("Enter Serial No :");
                        int sno = inp.nextInt();
                        System.out.print("Enter Student Name :");
                        String sname = sc.next();
                        System.out.print("Enter Subject Name :");
                        String subj = sc.next();
                        System.out.print("Enter Assignment Category Name :");
                        String asscat = sc.next();
                        System.out.print("Enter Date of Submission (dd-mm-yy) :");
                        String dos = sc.next();
                        System.out.print("Enter Points :");
                        int pts = sc.nextInt();
                        while(pts > 100){
                            System.out.println("Points cannot be greater than 100 & Less than 0\nPlease enter again :");
                            pts = sc.nextInt();
                        }
                        while(pts < 0){
                            System.out.println("Points cannot be greater than 100 & Less than 0\nPlease enter again :");
                            pts = sc.nextInt();
                        }
                        if(jd.inserTb(sno, sname, subj, asscat, dos, pts)){
                            System.out.println("Data Added Successfully");
                        }else{
                            System.out.println("Something, went wrong !");
                        }
                    break;
                case 3 : System.out.println("Press\n1 - To Delete all records\n2 - To Delete by ID/Serial No.");
                         int d =inp.nextInt();
                         if(d==1){
                            if(jd.deleteTb()){
                                System.out.println("All Records Deleted Successfully !");
                            }
                            else{
                                System.out.println("Already Deleted, No Records Found !");
                            }
                         }
                         else if(d==2){
                            System.out.println("Enter the Student Serial Number to Delete :");
                            int del = inp.nextInt();
                            if(jd.deleteById(del)){
                                System.out.println("Info Deleted Successfully !");
                            }
                            else{
                                System.out.println("Oops, No details present.");
                            }
                         }else{
                             System.out.println("Wrong Choice");      
                         }
                    break;
                case 4 : System.out.println("Enter the Student Serial Number to Update :");
                         int id = inp.nextInt();
                         if(jd.updateTb(1)){
                             System.out.println("Info Updated Successfully");
                         }else{
                             System.out.println("Update Unsuccessful");
                         }
                    break;
                case 5 : try{jd.displayTb();}catch(Exception e){e.printStackTrace();}
                         //System.out.println(Arrays.toString(assCatDist));
                         //System.out.println(Arrays.toString(weights));
                        System.out.println(retrieve.retrieve());
                    break;
                case 6 : System.out.println("Enter the Student Name to Calculate Rating :");
                         String stname = sc1.nextLine().toLowerCase();
                         
                         if(!retrieve.retrieve().isEmpty()){
                         studentInfo stdi = new studentInfo(stname, sub, assCatDist, retrieve.retrieve(), weights);
                         stdi.display();
                         }else{
                             System.out.println("Not Records Available. Insert the records to calculate.");
                         }
                    break;
                case 7 : System.out.println("Enter the Subject Name to Calculate Rating :");
                         String subname = sc1.nextLine().toLowerCase();
                         if(!retrieve.retrieve().isEmpty()){
                         subjectInfo subi = new subjectInfo(subname, StuName, assCatDist, retrieve.retrieve(), weights);
                         subi.display();
                         }else{
                             System.out.println("Not Records Available. Insert the records to calculate.");
                         }
                    break;
                  }   
            System.out.println("Continue - y/n :");
            cont = sc.next();
        }while(cont.equalsIgnoreCase("y"));
    }
    
}
