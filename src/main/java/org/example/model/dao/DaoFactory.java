package org.example.model.dao;

import org.example.db.DB;
import org.example.model.impl.SellerDaoJDBC;

public class DaoFactory {

    public static SellerDao createSellerDao() {
        return new SellerDaoJDBC(DB.getConn());
    }

}
