package minhquan.com.repository;

import minhquan.com.entity.impl.bill.Bill;

import java.util.List;

public interface IBillRepository {
    void saveItem(Bill bill);

    void deleteItem(int id);
    Bill getById(int id);
    List<Bill> getList();
}
