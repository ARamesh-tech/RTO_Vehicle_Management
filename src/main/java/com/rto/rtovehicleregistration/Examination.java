
package com.rto.rtovehicleregistration;

public class Examination extends VehicleLicensing{
    int cbtscore;
    int knowsDriving;
    String name;
    String signature;
    public Examination(int age, String name, String address, String vehicleregno,String signature) {
        super(age, name, address, vehicleregno);
        this.signature=signature;
    }
    
    public boolean giveExam(int cbtscore,int knowsDriving){
        if(cbtscore>=70 && knowsDriving==1){
            return true;
        }else{
            return false;
        }
    }
}
