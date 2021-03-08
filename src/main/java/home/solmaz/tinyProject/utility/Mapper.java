package home.solmaz.tinyProject.utility;

import home.solmaz.tinyProject.entity.Bill;
import home.solmaz.tinyProject.entity.Company;
import home.solmaz.tinyProject.present.dto.BillDto;

public class Mapper {

    public BillDto getBillDto(Bill bill, Company company){
        return new  BillDto(bill.getBillId(),bill.getPaymentId(),bill.getAmount(),"",company.getName()) ;
    }
}
