package sample;

import java.util.*;
import java.util.stream.Collectors;

public class studentInfo {
    
    String name;
    String[] sub;
    String[] assCatDist;
    List<info> list;
    List<info> lists = new ArrayList<info>();
    int[] weights;
    
    studentInfo(String name, String[] sub, String[] assCatDist, List<info> list, int[] weights){
        this.name = name;
        this.sub = sub;
        this.assCatDist = assCatDist;
        this.list = list;
        this.weights = weights;
    }
    
    public void display(){
        double score=0.0;
        double TotalScore=0.0;

        System.out.println("---------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%-30s", "Sub Name");
        for(int l=0; l<assCatDist.length; l++){
        System.out.printf(" %-10s %-10s", assCatDist[l], "");        
        }
        System.out.printf(" %-10s", "Total");
        System.out.println();
        System.out.println("---------------------------------------------------------------------------------------------------------------------------");

        for(int j=0; j<sub.length; j++){
            //System.out.print(sub[j]+"\t");
            System.out.printf("%-20s %-10s",sub[j], "");
            for(int i=0; i<assCatDist.length; i++){
        
                String st = sub[j];
                String assess = assCatDist[i].substring(0,3);  //--------------------------change start and end index for assessment cat name less than 3
                lists = list.stream().filter(x-> x.getStudentName().toLowerCase().equals(name) && x.getSubject().equals(st) && x.getAssigCatg().substring(0, 3).equals(assess)).collect(Collectors.toList());   
                info[] myArr = lists.toArray(new info[lists.size()]);
                for(int m=0; m<lists.size(); m++){
                    score+=((weights[i]*myArr[m].getPoints())/(double)lists.size())/100.0;
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
