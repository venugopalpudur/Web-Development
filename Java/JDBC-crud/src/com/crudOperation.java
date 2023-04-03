package com;
import java.util.*;
import java.util.stream.Collectors;
import sample.info;

public class crudOperation {
    
    List<info> lst;
    Scanner inp = new Scanner(System.in);
    
    crudOperation(List<info> lst){
        this.lst = lst;
    }
    
    public boolean addInfo(info st){
        boolean status = false;
        if(st!=null){
            lst.add(st);
            status = true;
        }
        return status;
    }
    
    public List<info> deleteInfoById(int id){
        boolean status = false;
        int size= lst.size();
        lst = lst.stream().filter(x-> x.getSerial()!=id).collect(Collectors.toList());
        //lst.add(lst);
        if(lst.size()<size){
            status=true;
            size = lst.size();
        }
        return lst;
    }
    
    public boolean updateInfoById(int id){
        boolean status = false;        
        ListIterator<info> it = lst.listIterator();
            while(it.hasNext()){
                info obj =it.next();
                if(obj.getSerial()==id){
                    System.out.print("Enter Student Name :");
                    obj.setStudentName(inp.nextLine());
                    System.out.print("Enter Subject Name :");
                    obj.setSubject(inp.nextLine());
                    System.out.print("Enter Assignment Category Name :");
                    obj.setAssigCatg(inp.nextLine());
                    System.out.print("Enter Date of Submission (dd-mm-yy) :");
                    obj.setDos(inp.nextLine());
                    System.out.print("Enter Points :");
                    int pts=inp.nextInt();;
                    while(pts > 100){
                            System.out.println("Points cannot be greater than 100 & Less than 0\nPlease enter again :");
                            pts = inp.nextInt();
                        }
                    while(pts < 0){
                            System.out.println("Points cannot be greater than 100 & Less than 0\nPlease enter again :");
                            pts = inp.nextInt();
                        }
                    obj.setPoints(pts);
                    status = true;
                }
            }
        return status;
    }
    
    public void showInfo(){
        ListIterator<info> it = lst.listIterator();
        System.out.printf("%-10s %-15s %-25s %-15s %-15s %-10s%n --------------------------------------------------------------------------------------%n", "S.No.","St Name","Subject","Assg. Categ.","DoS","Marks");
        

        while(it.hasNext()){
            info obj = it.next();
            //System.out.println(obj.getSerial()+"\t"+obj.getStudentName()+"\t\t"+obj.getSubject()+"\t\t"+obj.getAssigCatg()+"\t\t"+obj.getDos()+"\t\t"+obj.getPoints());
            System.out.printf("%-10d %-15s %-25s %-15s %-15s %-10d%n", obj.getSerial(),obj.getStudentName(),obj.getSubject(),obj.getAssigCatg(),obj.getDos(),obj.getPoints());
        }
    } 
}
