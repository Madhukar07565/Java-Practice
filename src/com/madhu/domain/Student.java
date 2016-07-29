/**
 * 
 */
package com.madhu.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author madhukar
 *
 */
@Entity
@Table(name = "STUDENT")
public class Student {

    @Id
    @Column
    private int studentId;

    @Column
    private String studentname;

    @Column
    private String studentClass;

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentname() {
        return studentname;
    }

    public void setStudentname(String studentname) {
        this.studentname = studentname;
    }

    public String getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(String studentClass) {
        this.studentClass = studentClass;
    }

}
