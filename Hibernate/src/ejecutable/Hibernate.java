/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejecutable;
import org.hibernate.Session;
import pojos.Padres;
import pojos.Hijos;
import pojos.HijosId;

public class Hibernate
{
 public static void main(String[] args) {
 
 Session session = HibernateUtil.getSessionFactory().openSession();
 Padres hijos = (Padres) session.get(Padres.class,1);
 Hijos hijos2 = (Hijos) session.get(Hijos.class,1);
 System.out.println("Esta persona se llama " + hijos.getNombre());
 }
}

