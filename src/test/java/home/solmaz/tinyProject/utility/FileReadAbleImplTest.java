package home.solmaz.tinyProject.utility;

import home.solmaz.tinyProject.MainContext;
import org.junit.Before;
import org.junit.Test;


import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

public class FileReadAbleImplTest {

    private ReadAble readable;

    @Before
    public void setUp() throws Exception {
        readable= (ReadAble) MainContext.getBean("fileReadable");
    }

    @Test
    public void readFromSource() {
        System.out.println("----------------------------bill list-------------------------------------------------------");
        Optional<List<String>> billList= readable.readFromSource("src/main/resources/dataAndDesc/01_bill");
        billList.ifPresent( item-> item.forEach(System.out::println));
        System.out.println("--------------------------------company list---------------------------------------------------");
        Optional<List<String>> companyList= readable.readFromSource("src/main/resources/dataAndDesc/02_org");
        companyList.ifPresent( item-> item.forEach(System.out::println));
    }
}