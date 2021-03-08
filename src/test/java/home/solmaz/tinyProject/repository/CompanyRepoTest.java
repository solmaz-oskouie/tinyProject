package home.solmaz.tinyProject.repository;

import home.solmaz.tinyProject.MainContext;
import home.solmaz.tinyProject.entity.Company;
import home.solmaz.tinyProject.utility.ReadAble;
import home.solmaz.tinyProject.repository.Repo;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class CompanyRepoTest {

    private Repo<Company> companyRepo;

    @Before
    public void setUp() throws Exception {

        companyRepo= (Repo<Company>) MainContext.getBean("companyRepo");
    }

    @Test
    public void readData() {
        List<Company>companies= companyRepo.readData();
        companies.forEach(System.out::println);

    }
}