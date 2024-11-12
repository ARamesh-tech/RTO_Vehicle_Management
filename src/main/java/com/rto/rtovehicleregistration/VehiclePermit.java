package com.rto.rtovehicleregistration;

import java.sql.*;

public class VehiclePermit extends VehicleRegistration{
    String vehicleregno;
    int rf;
    Connection con;

    public boolean isPermitted(String vehicleregno) throws ClassNotFoundException, SQLException {
        LoginSignUp conn = new LoginSignUp("admin", "admin@gmail.com", "root");
        con = conn.getConnection();
        this.vehicleregno = vehicleregno;
        PreparedStatement ps1 = con.prepareStatement("select permitted from vehiclereg where vehicleregno=?");
        ps1.setString(1, vehicleregno);
        ResultSet rs=ps1.executeQuery();
        if(rs.next()){
            if(rs.getInt("permitted")==1){
                return true;
            }else{
                return false;
            }
        }
        return false;
    }

    public void permitVehicle(String vehicleregno,int permit) throws ClassNotFoundException, SQLException {
        LoginSignUp conn = new LoginSignUp("admin", "admin@gmail.com", "root");
        con = conn.getConnection();
        this.vehicleregno = vehicleregno;
        PreparedStatement ps2 = con.prepareStatement("update vehiclereg set permitted=? where vehicleregno=?");
        ps2.setInt(1, permit);
        ps2.setString(2, vehicleregno);
        rf = ps2.executeUpdate();
        if (rf > 0 && permit==1) {
            System.out.println("Successfully Vehicle "+vehicleregno+" is Permitted!");
        }
        if(rf>0 && permit==0){
            System.out.println("Vehicle Permit for "+vehicleregno+" is revoked!");
        }
    }
}
