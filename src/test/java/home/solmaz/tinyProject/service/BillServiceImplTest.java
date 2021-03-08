package home.solmaz.tinyProject.service;

import home.solmaz.tinyProject.MainContext;
import home.solmaz.tinyProject.entity.Bill;
import home.solmaz.tinyProject.entity.Company;
import home.solmaz.tinyProject.present.dto.BillDto;
import home.solmaz.tinyProject.present.dto.CompanyPayReportDto;
import home.solmaz.tinyProject.repository.Repo;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;
import static org.junit.Assert.*;

public class BillServiceImplTest {
    private  Repo<Bill> billRepo;
    private  Repo<Company> companyRepo;

    @Before
    public void setUp() throws Exception {
        this.billRepo = (Repo<Bill>) MainContext.getBean("billRepo");
        companyRepo=(Repo<Company>) MainContext.getBean("companyRepo");
    }

    @Test
    public void getBillList() {
        List<BillDto> billDtos=new ArrayList<>();
        BillDto billDto=null;
        List<Bill> bills= billRepo.readData();
        List<Company>companies= companyRepo.readData();
        for(Bill bill:bills){
            for(Company company:companies){
                if(bill.getCompanyType()==company.getType() &&
                        bill.getCompanyCode().equals(company.getCode())){
                    if(!company.isEnable())
                        billDto=new BillDto(bill.getBillId(),bill.getPaymentId(),bill.getAmount(),"invalid company",company.getName()) ;
                    else
                        billDto=new BillDto(bill.getBillId(),bill.getPaymentId(),bill.getAmount(),"",company.getName()) ;

                }
            }
            billDtos.add(billDto);
        }
        billDtos.forEach(System.out::println);
    }

    @Test
    public void findRelationBetweenPaymentIdAndAmount(){
        List<Bill> bills= billRepo.readData();
        bills.forEach(bill -> {
            Assert.assertEquals(bill.getAmount().substring(0,2),bill.getPaymentId().substring(0,2));
            System.out.println("bill amount: "+bill.getAmount()+" bill amount head 2: "+bill.getAmount().substring(0,2));
        });

    }

    @Test
    public  void getCompanyPayReport(){
        List<Bill> bills= billRepo.readData();
        List<Company>companies= companyRepo.readData();
        List<CompanyPayReportDto> companyPayReportDtoList=new ArrayList<>();
        CompanyPayReportDto companyPayReportDto;
        long totalAmount=0;
        int count=0;
        for(Company company:companies){
            for(Bill bill:bills){
                if(bill.getCompanyCode().equals(company.getCode()) && bill.getCompanyType()==company.getType()){
                    totalAmount+=Long.parseLong(bill.getAmount());
                    count++;
                }
            }
            companyPayReportDto=new CompanyPayReportDto(company.getName(),count,totalAmount);
            companyPayReportDtoList.add(companyPayReportDto);
            totalAmount=0;
            count=0;
        }

        companyPayReportDtoList.forEach(System.out::println);

    }

}