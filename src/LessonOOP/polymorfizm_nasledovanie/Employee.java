package LessonOOP.polymorfizm_nasledovanie;

public class Employee {
    private String Name;
    private String Country;
    private String Department;
    private int Age;
    private int Salary;

    @Override
    public String toString() {
        return "Employee{" +
                "Name='" + Name + '\'' +
                ", Country='" + Country + '\'' +
                ", Department='" + Department + '\'' +
                ", Age=" + Age +
                ", Salary=" + Salary +
                '}';
    }

    static class BuilderEmployee{
        Employee employee; // не инициализирован

        public BuilderEmployee(){
            employee = new Employee();
        }
        BuilderEmployee withName(String Name){
            employee.Name = Name;
            return this;
        }
        BuilderEmployee withCountry(String Country){
            employee.Country = Country;
            return this;
        }
        BuilderEmployee withDepartment(String Department){
            employee.Department = Department;
            return this;
        }
        BuilderEmployee withAge(int Age){
            employee.Age = Age;
            return this;
        }
        BuilderEmployee withSalary(int Salary){
            employee.Salary = Salary;
            return this;
        }

        Employee build(){
            return employee;
        }
    }
}
