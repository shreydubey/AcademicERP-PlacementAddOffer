import com.example.project.bean.Employees;
import com.example.project.utils.SessionUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


import java.util.Map;

public class Main {

    public static void main(String[] args) {
        //Employees employees = new Employees();
        //employees.setEmployee_id("MT2020157");
        //employees.setFirst_name("Shrey");
        //employees.setLast_name("Dubey");
        //employees.setEmail("shrey.dubey@iiitb.org");
        //employees.setPassword("123456789");
        //employees.setDepartment("Outreach");

        Employees employees1 = new Employees();
        employees1.setEmployee_id("MT2020140");
        employees1.setFirst_name("Parth");
        employees1.setLast_name("Ajmera");
        employees1.setEmail("parth.ajmera@iiitb.org");
        employees1.setPassword("123456789");
        employees1.setDepartment("Accounts");

        Session session = SessionUtil.getSession();
        Transaction tx = session.beginTransaction();
        //session.save(employees);
        session.save(employees1);
        tx.commit();

    }
}