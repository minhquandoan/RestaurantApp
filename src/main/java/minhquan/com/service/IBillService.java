package minhquan.com.service;

import minhquan.com.entity.impl.bill.Bill;

import java.util.List;

public interface IBillService {
    void addBill(Bill bill);

    void deleteBill(int id);
    Bill getById(int id);
    List<Bill> getList();
}
