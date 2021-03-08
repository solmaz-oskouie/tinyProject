package home.solmaz.tinyProject;

import home.solmaz.tinyProject.exception.NotFoundBeanException;
import home.solmaz.tinyProject.repository.BillRepo;
import home.solmaz.tinyProject.repository.CompanyRepo;
import home.solmaz.tinyProject.utility.FileReadAbleImpl;
import home.solmaz.tinyProject.utility.ReadAble;

import java.util.HashMap;
import java.util.Map;

public class MainContext {

    static private Map<String, Object> beanMap=new HashMap<>();

    static {
        beanMap.put("fileReadable",new FileReadAbleImpl());
        beanMap.put("companyRepo",new CompanyRepo((ReadAble) beanMap.get("fileReadable")));
        beanMap.put("billRepo",new BillRepo((ReadAble) beanMap.get("fileReadable")));
    }

    private MainContext() {
    }

    public static Object getBean(String beanName)  {
        if(beanMap.get(beanName) !=null ) {
           return beanMap.get(beanName);

        } else {
            throw new NotFoundBeanException("not found bean: "+beanName);
        }
    }
}
