package minhquan.com.repository.impl;

import lombok.RequiredArgsConstructor;
import minhquan.com.db.BillDB;
import minhquan.com.entity.impl.bill.Bill;
import minhquan.com.exception.ErrorType;
import minhquan.com.exception.impl.BadRequestException;
import minhquan.com.repository.IBillRepository;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
public class BillRepository implements IBillRepository {
    private final BillDB billDB;

    @Override
    public void saveItem(Bill bill) {
        bill.setId(this.billDB.getStorage().size() + 1);
        bill.setOrderedTime(LocalDateTime.now());

        this.billDB.getStorage().add(bill);
    }

    @Override
    public void deleteItem(int id) {
        for (Bill bill : this.billDB.getStorage()) {
            if (bill.getId() == id) {
                this.billDB.getStorage().remove(bill);
                return;
            }
        }
        throw new BadRequestException(ErrorType.BAD_REQUEST_EXCEPTION.getErrorCode(), "Can not find any bill with id: " + id);
    }

    @Override
    public Bill getById(int id) {
        for (Bill bill : this.billDB.getStorage()) {
            if (bill.getId() == id) {
                return bill;
            }
        }
        throw new BadRequestException(ErrorType.BAD_REQUEST_EXCEPTION.getErrorCode(), "Can not find any bill with id: " + id);
    }

    @Override
    public List<Bill> getList() {
        return this.billDB.getStorage();
    }
}
