package learning_github;
class something {
    static String method(){
    return "This is something ";
    }
    public static void main(String[] args){
        IntMethod();
    }
    static void IntMethod(){
        int a=0,b=0;
        for(a=0;a<10;a++)
        {
            System.out.println(method()+"  "+b);
            b++;
        }
    }
}