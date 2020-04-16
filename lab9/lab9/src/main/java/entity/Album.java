package entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
@Entity
@Table(name = "albums", schema = "myalbums", catalog = "")
public class Album implements Serializable {
    private int id;
    private String name;
    private Integer releaseYear;
   private Integer artistId;

    public Album() {
    }

    public Album(Integer id, String name, Integer artistId, Integer releaseYear){
        this.id=id;
        this.name=name;
      this.artistId=artistId;
        this.releaseYear=releaseYear;
    }

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 100)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "release_year", nullable = true)
    public Integer getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Album album = (Album) o;
        return id == album.id &&
                Objects.equals(name, album.name) &&
                Objects.equals(releaseYear, album.releaseYear);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, releaseYear);
    }
}
