package lesson30.HWRev2;

import java.util.*;

public class Demo {
    public static void main(String[] args) {


        FirmDAO firmDAO = new FirmDAO();

        Customer customer1 = new Customer("IBM", "Ukraine", 700);
        Customer customer2 = new Customer("Microsoft", "Russia", 1700);
        Customer customer3 = new Customer("Siemens", "Polska", 3700);
        Customer customer4 = new Customer("Schneider", "Egypt", 1000);
        Customer customer5 = new Customer("Nibulon", "Ukraine", 2000);
        Customer customer6 = new Customer("GazTechApparat", "Russia", 245);

        Customer customer21 = new Customer("BM", "Ukraine", 700);
        Customer customer22 = new Customer("CunGroup", "Russia", 1700);
        Customer customer23 = new Customer("OBRAM", "Polska", 3700);
        Customer customer24 = new Customer("Ovidie", "Egypt", 1000);
        Customer customer25 = new Customer("Elas", "Ukraine", 2000);
        Customer customer26 = new Customer("Energomost", "Russia", 245);

        Customer customer31 = new Customer("BMW", "Germay", 700);
        Customer customer32 = new Customer("Renault", "France", 1700);
        Customer customer33 = new Customer("Opel", "Germany", 3700);
        Customer customer34 = new Customer("Lada", "Russia", 1000);
        Customer customer35 = new Customer("ZAZ", "Ukraine", 2000);
        Customer customer36 = new Customer("Ford", "USA", 245);

        Set<Customer> customers = new TreeSet<>();
        Set<Customer> customers2 = new TreeSet<>();
        Set<Customer> customers3 = new TreeSet<>();

        customers.add(customer1);
        customers.add(customer2);
        customers.add(customer3);
        customers.add(customer4);
        customers.add(customer5);
        customers.add(customer6);

        customers2.add(customer21);
        customers2.add(customer22);
        customers2.add(customer23);
        customers2.add(customer24);
        customers2.add(customer25);
        customers2.add(customer26);

        customers3.add(customer31);
        customers3.add(customer32);
        customers3.add(customer33);
        customers3.add(customer34);
        customers3.add(customer35);
        customers3.add(customer36);

        CustomerDAO customerDAO = new CustomerDAO(customers);

        System.out.println(customerDAO.getCustomersList());

        //Project
        Project project1 = new Project("TernopolPumps",         customer1);
        Project project2 = new Project("KyivstarFreeCooling",   customer2);
        Project project3 = new Project("SimppleProject",        customer3);
        Project project4 = new Project("PashaProject",          customer4);
        Project project5 = new Project("Kp1000",                customer1);
        Project project6 = new Project("GrainDryer",            customer2);
        Project project7 = new Project("ATON",                  customer5);
        Project project8 = new Project("BoilerWater",           customer6);

        Set<Project> projects = new TreeSet<>();

        projects.add(project1);
        projects.add(project2);
        projects.add(project3);
        projects.add(project4);
        projects.add(project5);
        projects.add(project6);
        projects.add(project7);
        projects.add(project8);

        System.out.println(" ~~~ ");
        System.out.println("projects " + projects.toString());
        System.out.println(" ~~~ ");

        ProjectDAO projectDAO = new ProjectDAO(projects);
        System.out.println("Project get all: " + projectDAO.getProjectsList());


        Set<Employee> employees = new TreeSet<>();
        Set<Employee> employees2 = new TreeSet<>();
        Set<Employee> employees3 = new TreeSet<>();
        Set<Employee> employees4 = new TreeSet<>();

        Set<Department> departments = new TreeSet<>();
        Set<Department> departments2 = new TreeSet<>();
        Set<Department> departments3 = new TreeSet<>();

        Department department1 = new Department(DepartmentType.ASU, employees);
        Department department2 = new Department(DepartmentType.SQL_BASE, employees2);
        Department department3 = new Department(DepartmentType.CPP, employees3);
        Department department4 = new Department(DepartmentType.JAVACORE, employees4);

        Department department24 = new Department(DepartmentType.ASU, employees4);
        Department department23 = new Department(DepartmentType.SQL_BASE, employees3);
        Department department22 = new Department(DepartmentType.CPP, employees2);
        Department department21 = new Department(DepartmentType.JAVACORE, employees);

        departments.add(department1);
        departments.add(department2);
        departments.add(department3);
        departments.add(department4);

        departments2.add(department21);
        departments2.add(department22);
        departments2.add(department23);
        departments2.add(department24);

        DepartmentDAO departmentDAO = new DepartmentDAO(departments);
        departmentDAO.save(department21);
        departmentDAO.save(department22);
        departmentDAO.save(department23);
        departmentDAO.save(department24);


        //Employee
        Test<Project> test = new Test<>(projects);

        Employee employee1 = new Employee("Nikolay", "Pervak", new Date(), Position.DEVELOPER, department1, null);
        Employee employee2 = new Employee("Katiya", "Dainega", new Date(), Position.DESIGNER, department1, test.getSection(1, 4));
        Employee employee3 = new Employee("Sviatoslav", "Kononenko", new Date(), Position.TEAM_LEAD, department1, test.getSection(0, 1));
        Employee employee4 = new Employee("Oleksiy", "Saiko", new Date(), Position.ANALYST, department1, test.getSection(3, 6));
        Employee employee5 = new Employee("Ivan", "Kolokolzev", new Date(), Position.DEVELOPER, department1, test.getSection(1, 2));

        Employee employee21 = new Employee("Nikolay", "Petrenko", new Date(), Position.DEVELOPER, department2, test.getSection(0, 3));
        Employee employee22 = new Employee("Katiya", "Pervak", new Date(), Position.DESIGNER, department2, test.getSection(1, 4));
        Employee employee23 = new Employee("Sviatoslav", "Chernenko", new Date(), Position.TEAM_LEAD, department2, test.getSection(2, 5));
        Employee employee24 = new Employee("Oleksiy", "Balaban", new Date(), Position.ANALYST, department2, test.getSection(3, 6));
        Employee employee25 = new Employee("Ivan", "Susanin", new Date(), Position.DEVELOPER, department2, test.getSection(1, 2));

        Employee employee31 = new Employee("Marina", "Petrenko", new Date(), Position.DEVELOPER, department3, test.getSection(0, 3));
        Employee employee32 = new Employee("Arina", "Pervak", new Date(), Position.DESIGNER, department3, test.getSection(1, 4));
        Employee employee33 = new Employee("Vika", "Chernenko", new Date(), Position.TEAM_LEAD, department3, test.getSection(2, 5));
        Employee employee34 = new Employee("Luba", "Balaban", new Date(), Position.ANALYST, department3, test.getSection(3, 6));
        Employee employee35 = new Employee("Sasha", "Susanin", new Date(), Position.DEVELOPER, department3, test.getSection(1, 2));

        Employee employee41 = new Employee("Makar", "Petrenko", new Date(), Position.DEVELOPER, department3, test.getSection(0, 3));
        Employee employee42 = new Employee("Anton", "Pervak", new Date(), Position.DESIGNER, department3, test.getSection(1, 4));
        Employee employee43 = new Employee("Igor", "Chernenko", new Date(), Position.TEAM_LEAD, department3, test.getSection(2, 5));
        Employee employee44 = new Employee("Dima", "Balaban", new Date(), Position.ANALYST, department3, test.getSection(3, 6));
        Employee employee45 = new Employee("Serj", "Susanin", new Date(), Position.DEVELOPER, department3, test.getSection(1, 2));

        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);
        employees.add(employee4);
        employees.add(employee5);

        employees2.add(employee21);
        employees2.add(employee22);
        employees2.add(employee23);
        employees2.add(employee24);
        employees2.add(employee25);

        employees3.add(employee31);
        employees3.add(employee32);
        employees3.add(employee33);
        employees3.add(employee34);
        employees3.add(employee35);

        employees4.add(employee41);
        employees4.add(employee42);
        employees4.add(employee43);
        employees4.add(employee44);
        employees4.add(employee45);

        EmployeeDAO employeeDAO = new EmployeeDAO(employees);
        employeeDAO.save(employee21);
        employeeDAO.save(employee22);
        employeeDAO.save(employee23);
        employeeDAO.save(employee24);
        employeeDAO.save(employee25);

        employeeDAO.save(employee31);
        employeeDAO.save(employee32);
        employeeDAO.save(employee33);
        employeeDAO.save(employee34);
        employeeDAO.save(employee35);

        employeeDAO.save(employee41);
        employeeDAO.save(employee42);
        employeeDAO.save(employee43);
        employeeDAO.save(employee44);
        employeeDAO.save(employee45);

        System.out.println(department2.getEmployees());

        Firm firm1 = new Firm(new Date(), departments, customers);
        Firm firm2 = new Firm(new Date(), departments2, customers2);
        Firm firm3 = new Firm(new Date(), departments3, customers3);

        firmDAO.save(firm1);
        firmDAO.save(firm2);
        firmDAO.save(firm3);


        System.out.println(firm1.getDepartments());

        Iterator<Department> departmentIterator = firm2.getDepartments().iterator();

        while (departmentIterator.hasNext()) {
            System.out.println(departmentIterator.next().getEmployees());
        }

        Controller controller = new Controller(firmDAO, employeeDAO, departmentDAO, projectDAO, customerDAO);
        System.out.println(" --------------------------------------------------------------------------------");
        System.out.println("Project tenopol pumps: " + controller.employeesByProject("TernopolPumps"));
        System.out.println("Boiler Water " + controller.employeesByProject("BoilerWater"));

        System.out.println(" projecsByEmployee --------------------------------------------------------------");

        System.out.println("ProjectsByEmployee " + controller.projectsByEmployee(new Employee("Ivan", "Susanin", new Date(), Position.DEVELOPER, null, null)));
        System.out.println(" ---------------------------------------------------------------------------------");

        System.out.println("EmployeesByDepartmentWithoutProject " + controller.employeesByDepartmentWithoutProject(new Department(DepartmentType.ASU, employees)));

        System.out.println(" ~~~~~~~ ");

        System.out.println("EmployeesWithoutProject " + controller.employeesWithoutProject());

        System.out.println(" ~~~~~~~~~~~~~~~~~~ ");

        System.out.println("employeesByTeamLead " + controller.employeesByTeamLead(employee3));

        System.out.println(" ~~~~~~~~~~~~~~~~~~ ");

        System.out.println("teamLeadsByEmployee " + controller.teamLeadsByEmployee(employee34));

        System.out.println(" ~~~~~~~~~~~~~~~~~~ ");

        System.out.println("employeeByProjectEmployee " + controller.employeesByProjectEmployee(employee35));

        System.out.println( "~~~~~~~~~~~~~~~~~~~~" );

        System.out.println("projects by customer " + controller.projectsByCustomer(customer1));

        System.out.println(" ~~~~~~~~~~~~~~~~~~~~ ");

        System.out.println("employees by customer projects " + controller.employeesByCustomerProjects(customer1));

        System.out.println(" ~~~~~~~~~~~~~~~~~~~~ ");

    }

}
