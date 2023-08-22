package hw3;

public class SinglyLinkedList {
    Node head;
    String listName;
    
    public SinglyLinkedList(String name){
        listName = name; //กำหนดชื่อที่รับมาให้กับ linkedlist นี้
    }
    
    //ลบ node ที่อยู่ข้างหลังสุดของ list ออกไป
    public void popBack() {
        if (isEmpty()){ //ถ้า linkedlist นี้ว่างจะแสดง ERROR ที่ console
            System.out.println("ERROR"); 
        }else{ //หากมีข้อมูล
            Node current = head; // ให้สร้าง node ที่มีชื่อว่า current มาชี้ที่ node ตัวแรกหรือ head
            while (current != null){ // ลูปจนกว่า current จะเป็น null นั่นหมายถึง วนลูปจนถึงตัวสุดท้าย 
                // แยกกรณีที่เหลือ node ตัวเดียวใน list
                if (current == head && current.next == null){
                    head = null;
                }else if (current.next.next == null){ //หาก next ของ node ตัวต่อไปชี้ไปที่ null แสดงว่า node ตัวนั้นเป็น node สุดท้าย
                    current.next = null; //เซ็ท next ของ node ที่ current ชี้อยู่ให้เป็น null;
                } 
                current = current.next; // เปลี่ยน current ให้ชี้ที่ node ถัดไป
            }
        }
    }
    
    // ลบ node ที่อยู่ข้างหน้าสุดของ list ออกไป
    public void popFront(){
        if (isEmpty()){ //ถ้า linkedlist นี้ว่างจะแสดง ERROR ที่ console
            System.out.println("ERROR"); 
        } else { //หากมีข้อมูล
            head = head.next; //ย้าย head ไปชี้ที่ node ตัวถัดไปได้เลย
        }
    }
    
    //จะ return node ที่อยู่ข้างหน้าสุดของ list
    public Node topFront(){
        if (isEmpty()){ //ถ้า linkedlist นี้ว่างจะแสดง ERROR ที่ console และ return node Empty List!
            System.out.println("ERROR");
            return new Node("Empty List!");
        } else { //หากมีข้อมูล จะ return node ตัวแรก หรือ node ที่ head ชี้อยู่
            return head;
        }
    }
    
    //จะ return node ที่อยู่ข้างหลังสุดของ list
    public Node topBack(){ 
        if (isEmpty()){ //ถ้า linkedlist นี้ว่างจะแสดง ERROR ที่ console และ return node Empty List!
            System.out.println("ERROR");
            return new Node("Empty List!");
        } else {
            Node current = head; // เซ็ท current ให้ไปชี้ที่ node ตัวแรก
            while (current != null){ // วนลูปจนกว่า current จะเป็น null นั่นหมายถึง วนลูปจนถึง node สุดท้าย 
                //ถ้า next ของ node ที่ current ชี้อยู่นั้น ชี้ไปที่ null แสดงว่า node นั้นคือ node สุดท้าย
                if (current.next == null){
                    return current; //return node ตัวสุดท้าย
                } 
                current = current.next;// เปลี่ยน current ให้ชี้ที่ node ถัดไป
            }
            return new Node(); // dummy constructor 3 ถ้าไม่ใส่โปรแกรมจะฟ้อง error
        }
    }
    
    // นำ node มาเติมข้างหน้าสุดของ list
    public void pushFront(Node node){
        if (isEmpty()){
            //ถ้า linkedlist นี้ว่าง จะเซ็ท head มาชี้ที่ node ใหม่เลย  
            head = node;
        } else { //หากมีข้อมูลอยู่แล้ว
            node.next = head; //์เซ็ท next ของ node ใหม่ ให้ไปชี้ node ตัวแรก หรือตัวที่ head ชี้อยู่
            head = node; //ย้าย head มาชี้ที่ node ใหม่
        }
    }
    
    // นำ node ไปต่อท้าย node ที่อยู่หลังสุด
    public void pushBack(Node node) {
        if (isEmpty()){
            //ถ้า linkedlist นี้ว่าง จะเซ็ท head มาชี้ที่ node ใหม่เลย  
            head = node;
        } else { //หากมีข้อมูลอยู่แล้ว
            Node current = head; // เซ็ท current ให้ไปชี้ที่ node ตัวแรก
            while (current != null){ // วนลูปจนกว่า current จะเป็น null นั่นหมายถึง วนลูปจนถึง node สุดท้าย
                //ถ้า next ของ node ที่ current ชี้อยู่นั้น ชี้ไปที่ null แสดงว่า node นั้นคือ node สุดท้าย
                if (current.next == null){
                    current.next = node; //เซ็ท next ของ node สุดท้ายให้ไปชี้ที่ node ใหม่
                    break; //หยุดการทำงานของลูป หากไม่ใช้คำสั่ง break ลูปนี้จะกลายเป็น infinite loop เนื่องจาก current.next ไม่ใช่ null หากมี node ใหม่มาต่อแล้ว
                }
                current = current.next; // เปลี่ยน current ให้ชี้ที่ node ถัดไป
            }
        }
    }

    // return Node ที่มีค่า student_id เท่ากับ id
    public Node findNode(int id){
        if (isEmpty()){ //ถ้า linkedlist นี้ว่างจะ return node Empty List!
            return new Node("Empty List!");
        } else { //หากมีข้อมูลอยู่แล้ว
            Node current = head; // เซ็ท current ให้ไปชี้ที่ node ตัวแรก
            while(current != null){ // วนลูปจนกว่า current จะเป็น null นั่นหมายถึง วนลูปจนถึง node สุดท้าย 
                //หาก node ที่ current ชี้อยู่ มีค่า student_id ตรงกับที่เราต้องการ จะ return node นั้น
                if(current.student_id == id) return current;
                current = current.next; // เปลี่ยน current ให้ชี้ที่ node ถัดไป
            }
            // หากจบลูปแล้วไม่มีการหยุดใดๆ แสดงว่าหา node ที่ตรงกับ id ไม่เจอ จะ return node Student Not Found!
            return new Node("Student Not Found!");
        }
    }
    
    //มีหน้าที่หา Node ที่มีค่า student_id เท่ากับ id ใน List เมื่อเจอแล้วให้ลบ Node นั้นออกจาก List และ return Node ที่ลบนั้นออกไปด้วย
    public Node eraseNode(int id){
        if (isEmpty()){ //ถ้า linkedlist นี้ว่างจะแสดง ERROR ที่ console และ return node Empty List!
            System.out.println("ERROR");
            return new Node("Empty List!");
        } else { //หากมีข้อมูลอยู่แล้ว
            Node current = head; // เซ็ท current ให้ไปชี้ที่ node ตัวแรก
            while(current != null){ // วนลูปจนกว่า current จะเป็น null นั่นหมายถึง วนลูปจนถึง node สุดท้าย
                if(current == head && current.student_id == id){
                    //ในกรณีที่ node ตัวแรกเป็น node ที่มี id ตรงตามที่เราต้องการ
                    head = current.next; //ย้าย head ไปชี้ที่ node ต่อไป
                    return current; //และ return node นั้นออกไป
                }else if(current.next == null){
                    //ในกรณีที่ node เป็นตัวสุดท้าย ให้ลูปหยุดการทำงาน
                    break;
                }else if(current.next.student_id == id){ //หาก node ตัวถัดไปจาก node ที่ current ชี้อยู่คือ node ที่เราต้องการจะลบ
                    Node TempNode = current.next; //สร้าง tempnode มาชี้ node นั้นไว้ก่อน
                    current.next = current.next.next;// เซ็ท next ของ current node ให้ไปชี้ตัวถัดไปจาก node ที่เราต้องการจะลบ
                    return TempNode; //return tempnode ซึ่งคือการ return node ที่เราต้องการลบ 
                }
                current = current.next; // เปลี่ยน current ให้ชี้ที่ node ถัดไป
            }
            // หากจบลูปแล้ว แสดงว่าหา node ที่ตรงกับ id ไม่เจอ จะ return node Student Not Found!
            return new Node("Student Not Found!");
        }
    }
    
    // มีหน้าที่นำ node2 ไปแทรกใน list โดยนำไปแทรกด้านหลังของ node1 (ซึ่งมีอยู่ใน list อยู่แล้ว)
    public void addNodeAfter(Node node1, Node node2){
        Node current = head; // เซ็ท current ให้ไปชี้ที่ node ตัวแรก
        while(current != null){ // วนลูปจนกว่า current จะเป็น null นั่นหมายถึง วนลูปจนถึง node สุดท้าย
            if(current.next == null && current == node1){
                //ในกรณีที่ node ตัวสุดท้ายเป็น node 1
                current.next = node2; //เซ็ท next ของ node ตัวสุดท้ายให้ไปชี้ที่ node2
                break; //หยุดการทำงานของลูป
            }else if(current == node1){ //หาก node ใดๆ เท่ากับ node1
                node2.next = current.next; //์เซ็ท next ของ node2 ให้ไปชี้ node ตัวถัดไปจาก node ที่ current ชี้อยู่
                current.next = node2; //เซ็ท next ของ current node ให้ไปชี้ที่ node2
                break; //หยุดการทำงานของลูป
            }else{
                current = current.next; // เปลี่ยน current ให้ชี้ที่ node ถัดไป
            }
        }
    }
    
    // มีหน้าที่นำ node2 ไปแทรกใน list โดยนำไปแทรกด้านหน้าของ node1 (ซึ่งมีอยู่ใน list อยู่แล้ว)
    public void addNodeBefore(Node node1, Node node2){
        Node current = head; // เซ็ท current ให้ไปชี้ที่ node ตัวแรก
        while(current != null){ // วนลูปจนกว่า current จะเป็น null นั่นหมายถึง วนลูปจนถึง node สุดท้าย
            if(current == head && current == node1){
                //ในกรณีที่ node ตัวแรกเป็น node 1
                node2.next = current; //์เซ็ท next ของ node2 ให้ไปชี้ node ตัวแรก
                head = node2;//ย้าย head มาชี้ที่ node2 แทน
                break;//หยุดการทำงานของลูป
            }else if(current.next == node1){
                //หากตัวถัดไปจาก current node เป็น node1
                node2.next = current.next; //์เซ็ท next ของ node2 ให้ไปชี้ node ตัวถัดไปจาก current node
                current.next = node2; //เซ็ท next ของ current node ให้ไปชี้ที่ node2
                break;//หยุดการทำงานของลูป
            }else{
                current = current.next; // เปลี่ยน current ให้ชี้ที่ node ถัดไป
            }
        }
    }
    
    //เอาไว้เช็คว่า list นี้ว่างรึเปล่า โดยเช็คที่ head ว่าชี้ไปที่ null หรือไม่ หากชี้ไปที่ null แสดงว่า list ว่าง
    public boolean isEmpty(){
        return head == null;
    }

    //รวม List สองเส้นด้วยกัน
    public void merge(SinglyLinkedList list){
        Node current = head; // เซ็ท current ให้ไปชี้ที่ node ตัวแรก
        while (current != null){ // วนลูปจนกว่า current จะเป็น null นั่นหมายถึง วนลูปจนถึง node สุดท้าย
            //ถ้า next ของ node ที่ current ชี้อยู่นั้น ชี้ไปที่ null แสดงว่า node นั้นคือ node สุดท้าย
            if(current.next == null) { 
                current.next = list.head; //เซ็ท next ของ node ตัวสุดท้ายให้ไปชี้ที่ head ของ node ใหม่
                break; //หยุดการทำงานของลูป หากไม่ใช้คำสั่ง break ลูปนี้จะกลายเป็น infinite loop เนื่องจาก current.next ไม่ใช่ null หากมี node ใหม่มาต่อแล้ว
            }
            current = current.next; // เปลี่ยน current ให้ชี้ที่ node ถัดไป
        }
    }
    
    //แสดง list ออก console
    public void printStructure(){ 
        Node current = head; // เซ็ท current ให้ไปชี้ที่ node ตัวแรก
        System.out.print(listName + ": head -> ");
        while(current != null){ // วนลูปจนกว่า current จะเป็น null นั่นหมายถึง วนลูปจนถึง node สุดท้าย
            System.out.print("{" + current.student_id + "} -> ");
            current = current.next; // ย้าย current ให้ชี้ที่ node ถัดไป
        }
        System.out.println("null");
    }
    
    //หาว่า Node ไหนมีนักเรียนที่ได้ GPA สูงที่สุด
    public Node whoGotHighestGPA(){ 
        if (isEmpty()) { 
            //ถ้า linkedlist นี้ว่างจะ return node นี่มี string Empty List!
            return new Node("Empty List!");
        } else {
            //สร้าง current มาชี้ node head
            Node current = head;
            //สร้าง temp node เพื่อมาชี้ node ที่มี gpa เยอะสุด และสร้างตัวแปร tempGpa มาเก็บค่า gpa
            Node tempNode = null;
            double tempGpa = 0;
            while(current != null){ // วนลูปจนกว่า current จะเป็น null นั่นหมายถึง วนลูปจนถึง node สุดท้าย
                //หาก gpa ของ current มากกว่าหรือเท่ากับ tempgpa ให้เก็บค่า gpa นั้นไว้ที่ tempGpa และเก็บ node current ใว้ที่ tempnode
                if(current.gpa >= tempGpa){
                    tempGpa = current.gpa;
                    tempNode = current;
                }
                current = current.next; // ย้าย current ให้ชี้ที่ node ถัดไป
            }
            return tempNode; //return node ที่มี gpa เยอะสุดใน list
        }
    }
}
