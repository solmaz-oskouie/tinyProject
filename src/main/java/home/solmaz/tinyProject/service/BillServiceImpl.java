package home.solmaz.tinyProject.service;

import home.solmaz.tinyProject.MainContext;
import home.solmaz.tinyProject.entity.Bill;
import home.solmaz.tinyProject.entity.Company;
import home.solmaz.tinyProject.present.dto.BillDto;
import home.solmaz.tinyProject.present.dto.CompanyPayReportDto;
import home.solmaz.tinyProject.repository.Repo;

import java.util.ArrayList;
import java.util.List;

public class BillServiceImpl implements BillService {
    private final Repo<Bill> billRepo;
    private final Repo<Company> companyRepo;

    public BillServiceImpl() {
        this.billRepo = (Repo<Bill>) MainContext.getBean("billRepo");
        companyRepo=(Repo<Company>) MainContext.getBean("companyRepo");
    }

    @Override
    public List<BillDto> getBillList() {
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
        return billDtos;
    }

    @Override
    public List<CompanyPayReportDto> getCompanyPayReport() {
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

        return companyPayReportDtoList;
    }


}
