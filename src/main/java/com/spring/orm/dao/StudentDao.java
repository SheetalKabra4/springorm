package com.spring.orm.dao;

import com.spring.orm.entities.Student;
import org.springframework.orm.hibernate5.HibernateTemplate;

import javax.transaction.Transactional;

public class StudentDao {

    private HibernateTemplate hibernateTemplate;

    @Transactional
    public int insert(Student student){
        int result = (Integer) this.hibernateTemplate.save(student);
        return 1;
    }

    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }
}