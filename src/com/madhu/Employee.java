package com.madhu;

import java.util.Comparator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Employee implements Comparator<Employee> {
    private static Logger log = LogManager.getLogger(Employee.class);
    private int empno;
    private String ename;

    public int getEmpno() {
        return empno;
    }

    public void setEmpno(int empno) {
        this.empno = empno;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        log.info("in equals method");
        this.ename = ename;
    }

    @Override
    public int hashCode() {
        return empno;
    }

    @Override
    public boolean equals(Object obj) {
        Employee e = (Employee) obj;
        if (this.empno == e.empno) {
            return true;
        } else

            return false;
    }

    public static void main(String[] args) {
        
        String s = new String();
        System.out.println(s.toString());
        /*Employee e = new Employee();
        e.setEmpno(1);
        e.setEname("madhukar");
        log.info("e object" + e.getEmpno());
        Employee e1 = new Employee();
        e1.setEmpno(1);
        e1.setEname("Kittu");
        log.info("e1 object {}", e1.getEmpno());
        System.out.println("Checking...." + e.equals(e1));
        System.out.println("==== " + (e == e1));
        System.out.println("e hashcode.." + e.hashCode());
        System.out.println("e1 hash code..." + e1.hashCode());*/
    }

    /* (non-Javadoc)
     * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
     */
    @Override
    public int compare(Employee o1, Employee o2) {
        // TODO Auto-generated method stub
        return 0;
    }

}
