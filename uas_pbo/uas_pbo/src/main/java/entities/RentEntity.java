package entities;

public class RentEntity {
    private Integer rentid;
    private String rentdate;
    private String returndate;
    private Integer movid;
    private String renter;

    //
    public Integer getrentId() {
        return rentid;
    }

    public void setrentId(Integer rentid) {
        this.rentid = rentid;
    }


    public String getrentDate() {
        return rentdate;
    }

    public void setrentDate(String rentdate) {
        this.rentdate = rentdate;
    }

    
    public String getreturnDate() {
        return returndate;
    }

    public void setreturnDate(String returndate) {
        this.returndate = returndate;

    }

    public Integer getmovId() {
        return movid;
    }

    public void setrmovId(Integer movid) {
        this.movid = movid;
    }

    public String getrenter() {
        return renter;
    }

    public void setrenter(String renter) {
        this.renter = renter;

    }



}

