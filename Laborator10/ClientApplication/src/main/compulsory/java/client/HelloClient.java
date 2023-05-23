package client;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import service.Hello;
public class HelloClient{
    public static void main(String[] args) throws Exception {
        Registry registry = LocateRegistry.getRegistry("localhost");
        Hello hello = (Hello) registry.lookup("Hello");
        String response = hello.sayHello("World");
        System.out.println(response);
    }
}