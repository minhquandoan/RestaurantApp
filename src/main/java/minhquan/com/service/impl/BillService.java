package minhquan.com.service.impl;

import lombok.RequiredArgsConstructor;
import minhquan.com.entity.impl.bill.Bill;
import minhquan.com.repository.IBillRepository;
import minhquan.com.service.IBillService;

import java.util.List;

@RequiredArgsConstructor
public class BillService implements IBillService {
    private final IBillRepository repository;

    @Override
    public void addBill(Bill bill) {
        this.repository.saveItem(bill);
    }

    @Override
    public void deleteBill(int id) {
        this.repository.deleteItem(id);
    }

    @Override
    public Bill getById(int id) {
        return this.repository.getById(id);
    }

    @Override
    public List<Bill> getList() {
        return this.repository.getList();
    }
}
