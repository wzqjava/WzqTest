package wzq.com.lib;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * author:Created by WangZhiQiang on 2018/11/22.
 */


public class MapDemo2 {


    public static void main(String[] args) {
        Map<String, Employee> staff = new HashMap<String, Employee>();
        staff.put("144-25-5464", new Employee("Amy"));
        staff.put("567-24-2546", new Employee("Harry"));
        staff.put("157-62-7935", new Employee("Gray"));
        staff.put("456-62-5527", new Employee("France"));
        System.out.println(staff);

        staff.remove("567-24-2546");//删除
        System.out.println(staff);

        staff.put("456-62-5527", new Employee("Bob"));//替换
        System.out.println(staff);

        System.out.println(staff.get("157-62-7935"));//查询

        //取得map中所有的key和value
        for (Map.Entry<String, Employee> entry : staff.entrySet()) {
            System.out.println("key:" + entry.getKey());
            System.out.println("value:" + entry.getValue());
        }

        //取得map中所有的key
        Set<String> keys = staff.keySet();
        for (String key : keys) {
            System.out.println(key);
        }

        //取得map中所有的value
        Collection<Employee> values = staff.values();
        for (Employee value : values) {
            System.out.println(value);
        }
    }
}

class Employee {
    public Employee(String n) {
        name = n;
        salary = 0;
    }

    public String toString() {
        return "[name=" + name + ", salary=" + salary + "]";
    }

    private String name;
    private double salary;


}
