package repo;

import entity.Album;
import entity.Artist;
import util.PersistanceUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class ArtistRepository {
    static EntityManagerFactory emf=  PersistanceUtil.createReturn("myalbumsPU");
    static EntityManager em=emf.createEntityManager();
    public static void create(Artist a){
        em.getTransaction().begin();
        em.persist(a);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }


    public static Artist findByID(Integer id)
    {
        Artist artist=em.find(Artist.class,id);
        return artist;
    }
    public static List<Artist> findByName(String name)
    {
        List<Artist> artistList= (List<Artist>) em.createNamedQuery("findByName")
                .setParameter("name",name)
                .getResultList();
        return artistList;
    }
}
