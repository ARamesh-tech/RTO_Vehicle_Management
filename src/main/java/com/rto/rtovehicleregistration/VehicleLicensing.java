
package com.rto.rtovehicleregistration;

public class VehicleLicensing extends LoginSignUp{
    int age;
    String address;
    String vehicleregno;
    String name;
    boolean examresult;
    
    public VehicleLicensing(int age,String name,String address,String vehicleregno){
        super();
        this.name=name;
        this.age=age;
        this.address=address;
        this.vehicleregno=vehicleregno;
    }
    public boolean provideLicense(String signature,int cbtscore, int knowsDriving){
        Examination e1=new Examination(age,name,address,vehicleregno,signature);  
        if(age<18){
            System.out.println("License not issued to : "+name+" because of underaged\n");
            return false;
        }
        examresult=e1.giveExam(cbtscore,knowsDriving);
        if(examresult){
            System.out.println("License Provided to : "+name+"\n");
            return true;
        }else{
            System.out.println("License not issued to : "+name+"\n");
            return false;
        }
    }
}
