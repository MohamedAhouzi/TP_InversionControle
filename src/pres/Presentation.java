package pres;

import dao.DaoImpl;
import dao.IDao;
import metier.IMetier;
import metier.MetierImpl;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Presentation {
    public static void main(String[] args) throws Exception {
        /*
        * Injection des depandances
        * par instantiation statique =>new
        * */
        /*
        DaoImpl dao=new DaoImpl();
        MetierImpl metier=new MetierImpl();
        metier.setDao(dao);
        System.out.println(metier.calcul());*/

        /*
        * injection des dependances
        * */
      //  try {


        /*
        Injection des depandances avec instantiation dynamique
        */
            Scanner scanner=new Scanner(new File("config.txt"));

            String daoClassName=scanner.next();
            Class cDao=Class.forName(daoClassName);
            IDao dao=(IDao) cDao.newInstance();

             System.out.println(dao.getData());

             String metierClassName=scanner.next();
            Class cMetier=Class.forName(metierClassName);
            IMetier metier=(IMetier) cMetier.newInstance();
            Method m=cMetier.getMethod("setDao",IDao.class);
            m.invoke(metier,dao);
        System.out.println(metier.calcul());




            //System.out.println(daoClassName);
        //  }catch (FileNotFoundException | ClassNotFoundException | InstantiationException | IllegalAccessException e){
           // e.printStackTrace();
        }

    }

