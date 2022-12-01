import com.bhavna.bean.Employee;
import com.bhavna.dao.Operations;

public class Main {
    public static void main(String[] args) {
        Operations operations = new Operations();
        operations.fetchData();
        operations.countEmployeeData();
        operations.updateData();

        Employee employee = new Employee(906,"Rajeev",45000,"2022-07-10");
        operations.saveData(employee);
    }
}