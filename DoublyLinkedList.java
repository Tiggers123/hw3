package hw3;

public class DoublyLinkedList {
    Node head;
    Node tail;
    String listName;
    
    public DoublyLinkedList(String name){
        listName = name; //กำหนดชื่อที่รับมาให้กับ linkedlist นี้
    }
    
    //ลบ node ที่อยู่ข้างหลังสุดของ list ออกไป
    public void popBack() {
        if (isEmpty()){
            System.out.println("ERROR"); //ถ้า linkedlist นี้ว่างจะแสดง ERROR ที่ console
        }else{
            tail = tail.previous; //ย้าย tail ไปชี้ที่ตัวก่อนหน้า
            if(tail == null){ //หากในกรณีที่ pop จนไม่มี node ใน linkedlist แล้ว node head ก็ควรจะว่างด้วย
                head = null;
            }else{
                tail.next = null; //หาก tail ย้ายมาชี้ที่ตัวก่อนหน้าแล้ว node next นั้นจะต้องชี้ไปที่ null เพื่อไม่ให้ชี้ไปที่ node เก่าที่เราจะ pop
            }
        }
    }
    
    // ลบ node ที่อยู่ข้างหน้าสุดของ list ออกไป
    public void popFront(){
        if (isEmpty()){
            System.out.println("ERROR"); //ถ้า linkedlist นี้ว่างจะแสดง ERROR ที่ console
        }else{
            head = head.next; //ย้าย node head ไปชี้ที่ตัวต่อไป
            if(head != null){ //ตอนนี้ head ชี้ที่ตัวต่อไปแล้ว หาก node ตัวนี้ไม่ใช่ null แสดงว่ามันคือ node และ previous ของ node นี้ยังเชื่อมกับ node ก่อนหน้านี้ที่เราต้องการ pop 
                head.previous = null; //ดังนั้น ต้องทำให้มันเป็น null เพราะตัวก่อนหน้าเรา pop แล้ว แสดงว่าไม่มี node อะไรอยู่ก่อนหน้า
            }
        }
    }
    
    //จะ return node ที่อยู่ข้างหน้าสุดของ list
    public Node topFront(){
        if (isEmpty()){ //ถ้า linkedlist นี้ว่างจะแสดง ERROR ที่ console และ return node Empty List!
            System.out.println("ERROR");
            return new Node("Empty List!");
        } else {
            return head; //ถ้า linkedlist นี้มีข้อมูลจะ return node ของ head ออกไป
        }
    }
    
    //จะ return node ที่อยู่ข้างหลังสุดของ list
    public Node topBack(){
        if (isEmpty()){ //ถ้า linkedlist นี้ว่างจะแสดง ERROR ที่ console และ return node Empty List!
            System.out.println("ERROR");
            return new Node("Empty List!");
        } else {
            return tail; //ถ้า linkedlist นี้มีข้อมูลจะ return node ของ tail ออกไป
        }
    }
    
    // นำ node มาเติมข้างหน้าสุดของ list
    public void pushFront(Node node){
        if (isEmpty()){ //ถ้า linkedlist นี้ว่าง จะเซ็ท head และ tail มาชี้ที่ node ใหม่เลย
            head = node;
            tail = node;
        } else { //หากมีข้อมูลอยู่แล้ว
            node.next = head; //node ที่เราจะ push เข้าไปข้างหน้าสุดนั้น next ของมันจะต้องชี้ไปที่ node ที่ head ชี้อยู่
            head.previous = node; //node ตัวแรกโดยปกติแล้ว previous จะเป็น null ดังนั้นเราเลยจะเปลี่ยนให้มันชี้ไป node ที่จะ push เพราะตอนนี้มีตัวก่อนหน้าแล้ว
            head = node; //ย้าย head มาชี้ที่ node ที่เราต้องการจะ push ก็เป็นอันเสร็จสิ้น
        }
    }
    
    // นำ node ไปต่อท้าย node ที่อยู่หลังสุด
    public void pushBack(Node node) {
        if (isEmpty()) { //ถ้า linkedlist นี้ว่าง เราจะเซ็ท head และ tail มาชี้ที่ node ใหม่เลย
            head = node;
            tail = node;
        } else { //หากมีข้อมูลอยู่แล้ว
            tail.next = node; //โดยปกติ node ตัวสุดท้าย next ของมันจะเป็น null แต่ว่า ถ้าเราต้องการ pushback node ใหม่เข้าไป ดังนั้น next ของ node สุดท้ายต้องชี้ไปที่ node ตัวใหม่
            node.previous = tail; //ตัวก่อนหน้าของ node ใหม่ คือตัวสุดท้าย หรือตัวที่ tail ยังชี้อยู่
            tail = node; //ย้าย tail มาชี้ที่ node ใหม่
        }
    }
    
    // return Node ที่มีค่า student_id เท่ากับ id
    public Node findNode(int id){
        if (isEmpty()){ //ถ้า linkedlist นี้ว่างจะ return node นี่มี string Empty List!
            return new Node("Empty List!");
        } else { //หากมีข้อมูลอยู่แล้ว
            // เช็คที่ node สุดท้ายก่อน 
            Node current = tail; // สร้าง node ที่มีชื่อว่า current มาชี้ที่ tail
            if(current.student_id == id) return current; // ถ้า node current มี student_id ที่เราต้องการ ก็ return node นี้เลย ไม่ต้องเสียเวลา loop

            // หาก tail ไม่ใช่ ก็ทำการ loop หาตั้งแต่ node แรกจนกว่าจะเจอ
            current = head; //เซ็ท current ให้เป็น node ตัวแรก
            while(current != null){ // ลูปจนกว่า current จะเป็น null นั่นหมายถึง วนลูปจนถึงตัวสุดท้าย 
                if(current.student_id == id) return current; //ถ้า current คือ node ที่มี student_id ที่เราต้องการ ก็ return node นั้น
                current = current.next; // เปลี่ยน current ให้ชี้ที่ node ถัดไป
            }
            return new Node("Student Not Found!"); //หากหาไม่เจอ ให้ return node ที่มี string Student Not Found!
        }
    }

    //มีหน้าที่หา Node ที่มีค่า student_id เท่ากับ id ใน List เมื่อเจอแล้วให้ลบ Node นั้นออกจาก List และ return Node ที่ลบนั้นออกไปด้วย
    public Node eraseNode(int id){
        if (isEmpty()){ //ถ้า linkedlist นี้ว่างจะ return node นี่มี string Empty List!
            System.out.println("ERROR");
            return new Node("Empty List!");
        } else { //หากมีข้อมูลอยู่แล้ว
            if(head.student_id == id){ // เช็คที่ node แรกก่อน โดยที่ถ้า head คือ node ที่มี student_id ที่เราต้องการจะลบนั้น..
                Node tempNode = head; // สร้าง node ที่มีชื่อว่า tempNode มาชี้ที่ head ไว้ก่อน
                if(head.next != null) head.next.previous = null; // เอาไว้แยกกรณีที่เป็น node แรก โดยที่หาก node ตัวนี้ไม่ใช่ตัวสุดท้าย (head.next ไม่ใช่ null) ก็ให้ เซ็ท previous ของ node ตัวถัดไปให้เป็น null
                head = head.next; // ย้าย head ไปชี้ที่ตัวถัดไป
                return tempNode; // return node ที่เราต้องการลบ
            }else if(tail.student_id == id){ // เช็คที่ node สุดท้าย โดยที่ถ้า tail คือ node ที่มี student_id ที่เราต้องการจะลบนั้น..
                Node tempNode = tail; // สร้าง node ที่มีชื่อว่า tempNode มาชี้ที่ tail ไว้ก่อน
                tail.previous.next = null; //ให้ next ตัวก่อนหน้าเป็น null จากที่ปกติจะชี้มาที่ node ที่เราจะลบ
                tail = tail.previous; //ย้าย tail ไปชี้ที่ตัวก่อนหน้า
                return tempNode; // return node ที่เราต้องการลบ
            }else{//หาก node หัวกับท้ายไม่ใช่ตามที่เราต้องการ ก็ทำการลูปหาตั้งแต่ node ตัวที่ 2 ไปจนกว่าจะเจอ โดยที่..
                Node current = head.next; // สร้าง node ที่มีชื่อว่า current มาชี้ที่ head.next หรือตัวถัดไปจาก head
                while(current != null){ // ลูปจนกว่า current จะเป็น null นั่นหมายถึง วนลูปจนถึงตัวสุดท้าย 
                    if(current.student_id == id){ //หากเจอ node ที่มี student_id ที่เราต้องการจะลบนั้น
                        current.previous.next = current.next; //เปลี่ยน next ของ node ก่อนหน้า current ให้ไปชี้ node ตัวถัดไปของ current
                        current.next.previous = current.previous; //เปลี่ยน previous ของ node ถัดไปจาก current ให้ไปชี้ node ตัวก่อนหน้าของ current
                        return current; // return node ที่เราต้องการลบ ก็คือ node current
                    }
                    current = current.next; // เปลี่ยน current ให้ชี้ที่ node ถัดไป
                }
                return new Node("Student Not Found!"); //หากหาไม่เจอ ให้ return node ที่มี string Student Not Found!
            }
        }
    }
    
    // มีหน้าที่นำ node2 ไปแทรกใน list โดยนำไปแทรกด้านหลังของ node1 (ซึ่งมีอยู่ใน list อยู่แล้ว)
    public void addNodeAfter(Node node1, Node node2){
        Node current = head; // สร้าง node ที่มีชื่อว่า current มาชี้ที่ head
        while(current != null){ // ลูปจนกว่า current จะเป็น null นั่นหมายถึง วนลูปจนถึงตัวสุดท้าย 
            if(current == node1){ // ถ้า node ที่ current ชี้อยู่เป็น node1
                node2.next = current.next; //เช็ท next ของ node2 ให้ไปชี้ที่ ตัวถัดไปของ current
                node2.previous = current; //เช็ท previous ของ node2 ให้ไปชี้ที่ตัว current เอง
                if(current.next != null){ //เอาไว้แยกกรณีที่ ตัวถัดไปเป็น node สุดท้าย
                    current.next.previous = node2; //หากไม่ใช่ node สุดท้าย แสดงว่ามี node ตัวต่อไปอยู่ ให้ previous ของ node ตัวถัดไปชี้มาที่ node2
                }else{
                    tail = node2; //หากเป็น node สุดท้ายให้ย้าย tail มาชี้ที่ node2
                }
                current.next = node2; //เช็ท next ของ current ให้ไปชี้ที่ node2
                break;//ออกจาก loop
            }else{// ถ้า node ที่ current ชี้อยู่ไม่ใช่ node1
                current = current.next; // เปลี่ยน current ให้ชี้ที่ node ถัดไป
            }
        }
    }
    
    // มีหน้าที่นำ node2 ไปแทรกใน list โดยนำไปแทรกด้านหน้าของ node1 (ซึ่งมีอยู่ใน list อยู่แล้ว)
    public void addNodeBefore(Node node1, Node node2){
        Node current = head; // สร้าง node ที่มีชื่อว่า current มาชี้ที่ head
        while(current != null){ // ลูปจนกว่า current จะเป็น null นั่นหมายถึง วนลูปจนถึงตัวสุดท้าย 
            if(current == node1){ // ถ้า node ที่ current ชี้อยู่เป็น node1
                node2.next = current; //เช็ท next ของ node2 ให้ไปชี้ที่ตัว current เอง
                node2.previous = current.previous; //เช็ท previous ของ node2 ให้ไปชี้ที่ตัวก่อนหน้าของ current
                if(current.previous != null){ //เอาไว้แยกกรณีที่ current เป็น node แรก (current.previous จะชี้ไปที่ null)
                    current.previous.next = node2; //หาก current ไม่ใช่ node แรก ให้ next ของ node ตัวก่อนหน้า current ชี้ไปที่ node2
                }else{
                    head = node2; //หาก current เป็น node แรก เราต้องย้าย head ไปชี้ที่ node2 เพื่อให้ node2 เป็นตัวแรกแทน
                }
                current.previous = node2; //เซ็ท previous ของ current ให้ชี้ไปที่ node2
                break; //ออกจากลูป
            }else{ // ถ้า node ที่ current ชี้อยู่ไม่ใช่ node1
                current = current.next; // เปลี่ยน current ให้ชี้ที่ node ถัดไป
            }
        }
    }

    //เอาไว้เช็คว่า list นี้ว่างรึเปล่า โดยเช็คที่ head ว่าชี้ไปที่ null หรือไม่ หากชี้ไปที่ null แสดงว่า list ว่าง
    public boolean isEmpty(){ 
        return head == null; 
    }

    //รวม List สองเส้นด้วยกัน
    public void merge(DoublyLinkedList list){
        tail.next = list.head; //เซ็ท next ของ node สุดท้าย (node ที่ tail ชี้อยู่) ให้ชี้ไปที่ head ของ list ที่เอามาต่อ
        list.head.previous = tail; //เซ็ท previous ของ node ตัวแรกของ list ใหม่ ให้ไปชี้ที่ตัวสุดท้ายของ list เดิม (ตัวที่ tail ชี้อยู่)
        tail = list.tail; //ย้าย tail ไปชี้ที่ตัวสุดท้ายของ list ใหม่
    }
    
    //แสดง list ออก console
    public void printStructure(){ 
        Node current = head; // เซ็ท current ให้ไปชี้ที่ node ตัวแรก
        System.out.print(listName + ": head <-> ");
        while(current != null){ // วนลูปจนกว่า current จะเป็น null นั่นหมายถึง วนลูปจนถึงตัวสุดท้าย 
            System.out.print("{" + current.student_id + "} <-> ");
            current = current.next; // ย้าย current ให้ชี้ที่ node ถัดไป
        }
        System.out.println("tail");
    }
    
    // This may be useful for you for implementing printStructure() << ของอาจารย์ ไม่ลบละกัน กลัว TT
    public void printStructureBackward(){ 
        Node current=tail;
        System.out.print(listName + ": tail <-> ");
        while(current!=null){
            System.out.print("{" + current.student_id + "} <-> ");
            current = current.previous;
        }
        System.out.println("head");
    }
    
    //หาว่า Node ไหนมีนักเรียนที่ได้ GPA สูงที่สุด
    public Node whoGotHighestGPA(){ 
        if (isEmpty()) { //ถ้า linkedlist นี้ว่างจะ return node นี่มี string Empty List!
            return new Node("Empty List!");
        } else {
            //สร้าง current มาชี้ node head
            Node current = head;
            //สร้าง temp node เพื่อมาชี้ node ที่มี gpa เยอะสุด และสร้างตัวแปร tempGpa มาเก็บค่า gpa
            Node tempNode = null;
            double tempGpa = 0;
            while(current != null){ // วนลูปจนกว่า current จะเป็น null นั่นหมายถึง วนลูปจนถึง node สุดท้าย
                if(current.gpa >= tempGpa){ 
                    //หาก gpa ของ current มากกว่าหรือเท่ากับ tempgpa ให้เก็บค่า gpa นั้นไว้ที่ tempGpa และเก็บ node current ใว้ที่ tempnode
                    tempGpa = current.gpa;
                    tempNode = current;
                }
                current = current.next;// ย้าย current ให้ชี้ที่ node ถัดไป
            }
            return tempNode; //return node ที่มี gpa เยอะสุดใน list
        }
    }
}
