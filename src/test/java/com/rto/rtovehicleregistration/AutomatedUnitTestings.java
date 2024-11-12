package com.rto.rtovehicleregistration;

import java.sql.SQLException;
import org.junit.Ignore;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class AutomatedUnitTestings {
    
    public AutomatedUnitTestings() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }
    @Test
    public void loginSignUpTest() throws SQLException {
        LoginSignUp l1=new LoginSignUp("admin","admin@gmail.com","root");
        String result1[]=l1.login();
        assertEquals(result1[0],"1");
        System.out.println("Login Test case passed");
    }
    @Test
    public void vehicleRegistrationTest() throws ClassNotFoundException, SQLException{
        VehicleRegistration vr1=new VehicleRegistration("Ramesh","TN74-TM4272","Audi 2024 Sportback 5500000");
        String result2[]=vr1.getDetailsNVerify("XYZ");
        assertEquals(result2[0],"1");
        System.out.println("Vehicle TN74-TM4272 is Verified and the test case is passed");
    }
    @Test
    public void vehiclePermitTest() throws ClassNotFoundException, SQLException{
        VehiclePermit vp1=new VehiclePermit();
        boolean result=vp1.isPermitted("TN74-TM4272");
        assertTrue(result);
        System.out.println("Vehicle TN74-TM4272 is permitted and the test case is passed");
    }
    @Test
    public void vehicleLicensing() throws ClassNotFoundException, SQLException{
        VehicleLicensing vls1=new VehicleLicensing(21,"Ramesh","kanyakumari","TN74-TM4272");
        boolean result=vls1.provideLicense("ARamesh kumaran",81,1);
        assertTrue(result);
        System.out.println("License for Vehicle TN74-TM4272 is issued and the test case is passed");
    }
    @Test
    public void examinationTest() throws ClassNotFoundException, SQLException{
        Examination e1=new Examination(21,"Ramesh","kanyakumari","TN74-TM4272","ARamesh kumaran");
        boolean result=e1.giveExam(92, 1);
        assertTrue(result);
        System.out.println("Ramesh passed the driving examination and the test case is passed");
    }
    @Test
    public void financeTest() throws ClassNotFoundException, SQLException{
        Finance f1=new Finance();
        boolean result=f1.decisionMaking();
        assertFalse(result);
        System.out.println("Test case passed for Finance->decision making method");
    }
}
