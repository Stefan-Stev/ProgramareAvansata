package util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistanceUtil {
    private static EntityManagerFactory factory;

    private PersistanceUtil() {
    }

        public static EntityManagerFactory createReturn (String s)
        {
            if(factory==null)
            {EntityManagerFactory factory= Persistence.createEntityManagerFactory(s);}
            return factory;
        }

}
