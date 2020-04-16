package repo;
import entity.Album;
import util.PersistanceUtil;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NamedQuery;
import java.util.List;

public class AlbumRepository {
    static EntityManagerFactory emf=  PersistanceUtil.createReturn("myalbumsPU");
    static EntityManager em=emf.createEntityManager();
    public static void create(Album a){
        em.getTransaction().begin();
        em.persist(a);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }


    public static Album findByID(Integer id)
    {
        Album album=em.find(Album.class,id);
        return album;
    }


}
