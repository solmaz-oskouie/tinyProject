package home.solmaz.tinyProject.repository;

import home.solmaz.tinyProject.entity.Bill;
import home.solmaz.tinyProject.utility.ReadAble;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BillRepo implements Repo<Bill> {
    private final ReadAble readAble;
    private   List<Bill> bills;

    public BillRepo(ReadAble readAble) {
        this.readAble = readAble;
        bills=new ArrayList<>();
    }

    @Override
    public List<Bill> readData() {
        Optional<List<String>> billList= readAble.readFromSource("src/main/resources/dataAndDesc/01_bill");
        billList.ifPresent( list-> {
            list.forEach(item -> {
                String[] str = item.split(",");
                Bill bill=new Bill(str[0],str[1],str[2]);
                bills.add(bill);
            });
        });
        return bills;
    }
}
