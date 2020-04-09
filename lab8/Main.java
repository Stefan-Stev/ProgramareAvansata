
package lab8;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        Connection con = Database.getConn("STUDENT","STUDENT");

        ArtistController artist = new ArtistController();
        AlbumController album = new AlbumController();

        artist.create("James HetField", "USA");
        artist.create("Ozzy Osbourne", "England");

        album.create("Master of Puppets", 4, 1985);
        
        artist.findByName("James HetField");
        album.findByArtist(2);
        artist.findByName("Ozzy Osbourne");
        con.close();
    }
}