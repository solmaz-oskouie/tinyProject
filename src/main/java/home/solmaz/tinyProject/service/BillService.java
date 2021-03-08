package home.solmaz.tinyProject.service;

import home.solmaz.tinyProject.entity.Bill;
import home.solmaz.tinyProject.present.dto.BillDto;
import home.solmaz.tinyProject.present.dto.CompanyPayReportDto;

import java.util.List;

public interface BillService {
    List<BillDto> getBillList();
    List<CompanyPayReportDto> getCompanyPayReport();
}
