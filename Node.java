package hw3;

public class Node {
    public int student_id;
    public String name;
    public double gpa;
    
    Node next;
    Node previous;
    
    // Constructor 1
    public Node(int id, String Name, double Gpa){
        student_id = id; //กำหนดค่าเลขประจำตัวนศ ในกับ node
        name = Name; //กำหนดชื่อนศ ในกับ node
        gpa = Gpa; //กำหนดเกรดให้กับ node
    }
    // Constructor 2
    public Node(String error_msg){
        name = error_msg; //หากรับ string มาแค่ parameter เดียว ให้ assign ข้อความใน ตัวแปร name ซึ่งเป็นกรณีที่เกิด error
    }
    // Constructor 3 (dummy)
    public Node(){
        // You can leave this function blank
    }
    
    public void printIDName(){
        System.out.println("StudentID: " + student_id + " , Name: " + name);
    }

}
