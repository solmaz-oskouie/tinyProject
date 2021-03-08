package home.solmaz.tinyProject.repository;

import home.solmaz.tinyProject.entity.Company;
import home.solmaz.tinyProject.utility.ReadAble;
import home.solmaz.tinyProject.repository.Repo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CompanyRepo implements Repo<Company> {
    private final ReadAble readAble;
    private   List<Company> companies;

    public CompanyRepo(ReadAble readAble) {
        this.readAble = readAble;
        companies=new ArrayList<>();
    }

    @Override
    public List<Company> readData() {
        Optional<List<String>> companyList= readAble.readFromSource("src/main/resources/dataAndDesc/02_org");
        companyList.ifPresent( list-> {
            list.forEach(item -> {
                String[] str = item.split(",");
                boolean enable = Integer.parseInt(str[1]) == 0 ? false : true;
                Company company=new Company(str[0].charAt(0),enable,str[2],str[3],str[4]);
                companies.add(company);
            });
        });
        return companies;
    }
}
