package minhquan.com.db;

import lombok.Getter;
import minhquan.com.entity.impl.bill.Bill;

import java.util.ArrayList;
import java.util.List;

public class BillDB {

    private static List<Bill> storage;

    private static BillDB instance;

    private BillDB() {
        storage = new ArrayList<>();
    }

    public static BillDB getInstance() {
        if (instance == null) {
            instance = new BillDB();
        }
        return instance;
    }

    public List<Bill> getStorage() {
        return storage;
    }
}
