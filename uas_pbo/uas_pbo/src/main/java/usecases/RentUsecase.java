package usecases;

import com.zaxxer.hikari.HikariDataSource;

import entities.RentEntity;
import models.RentModel;
import utils.DBConnectionUtil;

public class RentUsecase {
    private HikariDataSource dataSource;

    private static RentModel rentModel;

    public RentUsecase () {
        dataSource = DBConnectionUtil.geDataSource();
        rentModel = new RentModel(dataSource);
    }

    public void GetRentList(Integer rentid) {
        RentEntity[] rentList = rentModel.ListRent();
        for (RentEntity rent : rentList) {
            System.out.println(rent.getrentId() + " - " + rent.getrentDate() + " - " + rent.getreturnDate()
            + " - " + rent.getmovId() + " - " + rent.getrenter());
        }
    }

    public void NewRent(String rentdate, Integer movid, String renter) {
        RentEntity rentEntity = new RentEntity();
        rentEntity.setrentDate(rentdate);
        rentEntity.setrmovId(movid);
        rentEntity.setrenter(renter);

        rentModel.NewRent(rentEntity);
        System.out.println( "- Input Rent - Succeed! -");
    }

    // public void ReturnRent(Integer rentid, String returndate) {
    //     RentEntity rentEntity = new RentEntity();
    //     rentEntity.setrentId(rentid);
    //     rentEntity.setreturnDate(returndate);
        
    //     rentModel.ReturnRent(rentEntity, rentid, returndate);
    //     System.out.println("- Return Rent - Done! -");
    // }

    //Revisi dari AI
    public void SetReturnRent(Integer rentid, String returndate) {
    RentEntity rentEntity = getrentId(rentid); // Mengambil RentEntity berdasarkan rentid
    
    if (rentEntity != null) {
        rentEntity.setreturnDate(returndate); // Mengatur tanggal pengembalian pada RentEntity
        
        rentModel.ReturnRent(rentEntity, rentid, returndate); // Mengirim RentEntity ke metode ReturnRent dalam rentModel
        System.out.println("- Return Rent - Done! -");
    } else {
        System.out.println("Rent dengan ID tersebut tidak ditemukan");
    }
}

    private RentEntity getrentId(Integer rentid) {
        return null;
    }
}
