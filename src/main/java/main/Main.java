/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import Entidades.Persona;
import Entidades.Ranking;
import Entidades.Skill;
import static main.Main.sessionFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Main {
    
    
    
    static final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
				.configure() // configures settings from hibernate.cfg.xml
				.build();
    static SessionFactory sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
        
    public static void main(String[] args) {
   
                Persona persona = new Persona(0, "Adrian " , "Holguin");
                IngresarPersona(persona);
                
                Ranking ranking = new Ranking (0 ,"BAC");
                IngresarRanking( ranking);
                
                Skill skill = new Skill (0,"BCE");
                IngresarSkill(skill);
                
                
                    
                }
    static void IngresarPersona(Persona persona) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.save(persona);
		
        session.getTransaction().commit();
        session.close();

    }
    static void IngresarRanking(Ranking ranking) {
        
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(ranking);
		
        session.getTransaction().commit();
        session.close();
}
    static void IngresarSkill(Skill skill) {
        
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(skill);
		
        session.getTransaction().commit();
        session.close();
}
    
    
    
}
