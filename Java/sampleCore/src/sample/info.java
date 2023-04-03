package sample;

public class info {
    private int serial;
    private String studentName;
    private String subject;
    private String assigCatg;
    private String Dos;
    private int points;
    
    info(int serial, String st, String sub, String ass, String dos, int pt){
        this.setSerial(serial);
        this.setStudentName(st);
        this.setSubject(sub);
        this.setAssigCatg(ass);
        this.setDos(dos);
        this.setPoints(pt);
    }
    
    public int getSerial() {
        return serial;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getSubject() {
        return subject;
    }

    public String getAssigCatg() {
        return assigCatg;
    }

    public String getDos() {
        return Dos;
    }

    public int getPoints() {
        return points;
    }

    public void setSerial(int serial) {
        this.serial = serial;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setAssigCatg(String assigCatg) {
        this.assigCatg = assigCatg;
    }

    public void setDos(String Dos) {
        this.Dos = Dos;
    }

    public void setPoints(int points) {
        this.points = points;
    }
    @Override
    public String toString(){
        return ("Serial No :"+this.getSerial()+"\t"+"Student Name :"+this.getStudentName()+"\t"+"Subject :"+this.getSubject()+"\t\t"+"AssCat :"+this.getAssigCatg()+"\t"+"DoS :"+this.getDos()+"\t"+"Points :"+this.getPoints());
    }
}
