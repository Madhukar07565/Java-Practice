/**
 * 
 */
package com.madhu.Application;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import com.madhu.Util.HibernateUtil;

/**
 * @author madhukar
 *
 */
public class StudentTest {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Session session = HibernateUtil.getSession();
        List<String> list = new ArrayList<String>();
        list.add("Aclass");
        list.add("Bclass");
        StringBuilder qBuilder = new StringBuilder("select studentId from STUDENT where (studentClass in (:ids)");
        SQLQuery query = session.createSQLQuery(qBuilder.toString());
        query.setParameterList("ids", list);

        for (Object string : query.list()) {
            System.out.println("Ids are " + string.toString());
        }
    }
}
