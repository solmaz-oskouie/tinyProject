package home.solmaz.tinyProject.repository;

import home.solmaz.tinyProject.MainContext;
import home.solmaz.tinyProject.entity.Bill;
import home.solmaz.tinyProject.entity.Company;
import home.solmaz.tinyProject.repository.Repo;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class BillRepoTest {

    private Repo<Bill> billRepo;

    @Before
    public void setUp() throws Exception {
        billRepo = (Repo<Bill>) MainContext.getBean("billRepo");
    }

    @Test
    public void readData() {
        List<Bill> bills= billRepo.readData();
        bills.forEach(System.out::println);
        // Assert.assertEquals(12,item.getBillId().length());
    }
    @Test
    public  void getCompanyCode(){
        List<Bill> bills= billRepo.readData();
        bills.forEach(item-> {System.out.println(item+"  company code: "+item.getCompanyCode());
        Assert.assertEquals(3,item.getCompanyCode().length());
        });
    }

    @Test
    public  void getCompanyType(){
        List<Bill> bills= billRepo.readData();
        bills.forEach(item-> {System.out.println(item+"  company type: "+item.getCompanyType());
        });
    }
}