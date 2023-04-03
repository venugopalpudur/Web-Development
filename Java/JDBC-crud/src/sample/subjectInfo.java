package sample;

import java.util.*;
import java.util.stream.Collectors;

public class subjectInfo {
    
    String subName;
    String[] StuName;
    String[] assCatDist;
    List<info> list;
    List<info> lst = new ArrayList<info>();
    int[] weights;
//    Map<String, Integer> catego;
//    Iterator<String> itr = catego.keySet().iterator();
    
    subjectInfo(String subName, String[] StuName, String[] assCatDist, List<info> list, int[] weights){
        this.subName = subName;
        this.StuName = StuName;
        this.assCatDist = assCatDist;
        this.list = list;
        this.weights = weights;
        //this.catego = catego;
    }
    
    public void display(){
        double score=0.0;
        double TotalScore=0.0;
       
        System.out.println("---------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%-20s", "St. Name");
        //for(int l=0; l<catego.size(); l++){
        for(int l=0; l<assCatDist.length; l++){
        System.out.printf(" %-10s %-10s", assCatDist[l], "");        
        }
        System.out.printf(" %-10s", "Total");
        System.out.println();
        System.out.println("---------------------------------------------------------------------------------------------------------------------------");
        for(int j=0; j<StuName.length; j++){     
            //System.out.print(StuName[j]+"\t");
            System.out.printf("%-10s %-10s",StuName[j], "");
            //for(int i=0; i<catego.size(); i++){ 
            for(int i=0; i<assCatDist.length; i++){ 
                String st = StuName[j];                
                String assess = assCatDist[i].substring(0,3);
                
                
                lst = list.stream().filter(m-> m.getStudentName().equals(st) && m.getSubject().toLowerCase().equals(subName) && m.getAssigCatg().substring(0, 3).equals(assess)).collect(Collectors.toList());                   
                info[] myArr = lst.toArray(new info[lst.size()]);
                for(int m=0; m<lst.size(); m++){
                    score+=((weights[i]*myArr[m].getPoints())/(double)lst.size())/100.0;
                }
                //System.out.print(assCatDist[i]+" : "+score+"\t");
                System.out.printf("%-10f %-10s", score, "");
                TotalScore+=score;
                score=0.0;
            }
            System.out.print(TotalScore);
            TotalScore=0.0;
            System.out.println();
            System.out.println("---------------------------------------------------------------------------------------------------------------------------");
        }
    }
}
