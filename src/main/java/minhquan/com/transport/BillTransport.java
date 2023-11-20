package minhquan.com.transport;

import minhquan.com.container.IOCRepository;
import minhquan.com.container.IOCService;
import minhquan.com.entity.Menu;
import minhquan.com.entity.impl.bill.Bill;
import minhquan.com.exception.impl.BadRequestException;
import minhquan.com.service.IBillService;

import java.util.List;
import java.util.Scanner;

public class BillTransport {
    private IBillService service;
    private Scanner sc;

    public BillTransport() {
        service = IOCService.getInstanceBillService(IOCRepository.getInstanceBillRepository());
        this.sc = new Scanner(System.in);
    }

    public void getBillById() {
        System.out.println("====== 1. Get Bill By Id ======");

        System.out.print("Please input Bill Id: ");
        int id = sc.nextInt();

        try {
            Bill bill = service.getById(id);
            System.out.println(bill);
        } catch(BadRequestException exception) {
            System.out.println("Error code: " + exception.getCode());
            System.out.println("Error Description: " + exception.getDescription());
        }
    }

    public void getAllBills() {
        System.out.println("====== 2. Get All Bills ======");

        List<Bill> billList = this.service.getList();
        billList.forEach(System.out::println);
    }

    public void deleteBill() {
        System.out.println("====== 3. Delete Bill By Id ======");

        System.out.print("Bill ID: ");
        int billId = sc.nextInt();
        System.out.println(billId);

        try {
            this.service.deleteBill(billId);
        } catch(BadRequestException exception) {
            System.out.println("Error code: " + exception.getCode());
            System.out.println("Error Description: " + exception.getDescription());
        }
    }
}
