import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;
import java.util.Vector;
import java.util.function.Consumer;

class NewClass{
    private static String name="rajesh arjun Ravi Arjun Arvind Naveen Ankur Ankush Shubham";
    public static ArrayList<String> arr=new ArrayList<>();
    public static LinkedList<String> ll=new LinkedList<>();
    public static Vector<String> vec=new Vector<>();
    public static Stack<String> stk=new Stack<>();
    public static void arraylist() {
        arr.addAll(Arrays.asList(name.split(" ")));
        System.out.print("Arraylist with string starting with 'r'.-->");
        for(int i=0;i<arr.size();i++)
        {
            if(arr.get(i).substring(0,1).toLowerCase().equals("r"))
                System.out.print(arr.get(i)+" ");
        }
        System.out.println();
    }
    public static void linkedlist(){
        ll.addAll(Arrays.asList(name.split(" ")));
        System.out.print("Linkedlist with string starting without 'a'.-->");
        for(int i=0;i<ll.size();i++)
        {
            if(ll.get(i).substring(0,1).toLowerCase().equals("a"));
            else System.out.print(ll.get(i)+" ");
        }
        System.out.println();
    }
    public static void Vector(){
        vec.addAll(Arrays.asList(name.split(" ")));
        System.out.print("All vector String--> ");
        vec.forEach(s -> {
            System.out.print(s+" ");
        });
        System.out.println();
    }
    public static void stack(){
        for(String s:name.split(" "))
        {
            stk.push(s);
        }
        int i=0;
        System.out.print("Stack Element-> ");
        while(i++<=stk.size())
        {
        System.out.print(stk.pop()+" ");
        }
        System.out.println();
    }
    public static void main(String[] args){
        arraylist();
        linkedlist();
        Vector();
        stack();
    }
}
