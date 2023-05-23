package server;
import java.rmi.RemoteException;
import service.Hello;
public class HelloImpl implements Hello {
    public HelloImpl() throws RemoteException {
        super();
    }
    public String sayHello(String name) {
        return "Hello " + name + " !";
    }
}