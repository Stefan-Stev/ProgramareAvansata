package app;

import entity.Album;
import entity.Artist;
import repo.AlbumRepository;
import repo.ArtistRepository;
import util.PersistanceUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class AlbumManager {
    public static void main(String args[])
    {
         EntityManagerFactory factory= PersistanceUtil.createReturn("myalbumsPU");
        EntityManager em=factory.createEntityManager();
        em.getTransaction().begin();
        Artist artist1=new Artist(2,"Dave Mustaine","SUA");
        Album album1=new Album(2,"Dystopia",2,2016);
        ArtistRepository artist=new ArtistRepository();
    AlbumRepository album =new AlbumRepository();
    artist.create(artist1);
    album.create(album1);
    Artist artistId=artist.findByID(1);
        System.out.println(artistId);
    }
}
