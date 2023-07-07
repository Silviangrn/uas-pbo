package entities;

public class MovieEntity {
    private Integer movid;
    private String movnam;
    private String genre;

    public Integer getmovId() {
        return movid;
    } 

    public void setmovId(Integer movid) {
        this.movid = movid;
    }

    public String getmovNam() {
        return movnam;
    } 

    public void setmovnam(String movnam) {
        this.movnam = movnam;
    }

    public String getGenre() {
        return genre;
    } 

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
