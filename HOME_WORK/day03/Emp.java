package day03;

import java.util.Date;

/**
 * 定义私有属性:
 * String name;
 * int age;
 * String gender;
 * int salary;
 * Date hiredate;//入职时间
 * 
 * 定义构造方法，以及属性get,set方法.
 * 定义toString方法，格式如:
 *    姓名:张三,年龄:25,性别:男,薪资:5000,入职时间:2006-02-15
 * 
 * 定义equals方法，要求只要名字相同，则认为内容一致。
 * @author Bonnie
 *
 */
public class Emp {
    private String name;
    private int age;
    private String gender;
    private int salary;
    private Date hiredate;
    public Emp(String name, int age, String gender, int salary, Date hiredate) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.salary = salary;
        this.hiredate = hiredate;
    }
    public String getName() {
        return this.name;
    }
    public int getAge() {
        return this.age;
    }
    public String getGender() {
        return this.gender;
    }
    public int getSalary() {
        return this.salary;
    }
    public Date getHiredate() {
        return this.hiredate;
    }
    public String setName(String name) {
        this.name = name;
        return this.name;
    }
    public int setAge(int age) {
        this.age = age;
        return this.age;
    }
    public String setGender(String gender) {
        this.gender = gender;
        return this.gender;
    }
    public int setSalary(int salary) {
        this.salary = salary;
        return this.salary;
    }
    public Date setDate(Date date) {
        this.hiredate = date;
        return this.hiredate;
    }

    @Override
    public String toString() {
        String str = "姓名:" + this.name + "," + "年龄:" + this.age + ","
        + "性别:" + this.gender + "," + "薪资:" + this.salary + "," + "入职时间:" +
                this.hiredate;
        return str;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (obj instanceof Emp) {
            Emp temp = (Emp) obj;
            return this.name == temp.name;
        }
        return false;
    }

    @Override
    public int hashCode() {
        int result = this.name != null ? this.name.hashCode() : 0;
        result = result * 31;
        return result;

    }
}
