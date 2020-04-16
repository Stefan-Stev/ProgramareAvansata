package entity;

import javax.persistence.*;
import java.util.Objects;
@NamedQuery(name="findByName",query = "Select name from artists where name=:artistName")
@Entity
@Table(name = "artists", schema = "myalbums", catalog = "")
public class Artist  {
    public Artist(Integer id, String name, String country){
        this.id=id;
        this.name=name;
        this.country=country;
    }

    public Artist() {
    }

    private int id;
    private String name;
    private String country;



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
    @Column(name = "country", nullable = true, length = 100)
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Artist artist = (Artist) o;
        return id == artist.id &&
                Objects.equals(name, artist.name) &&
                Objects.equals(country, artist.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, country);
    }
}
