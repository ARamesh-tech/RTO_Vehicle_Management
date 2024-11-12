package com.rto.rtovehicleregistration;

import java.sql.*;

public class VehicleRegistration {
    String owner;
    String vehicleregno;
    String vehicledetails;
    Connection con;
    public VehicleRegistration(String owner,String vehicleregno,String vehicledetails){
        this.owner=owner;
        this.vehicleregno=vehicleregno;
        this.vehicledetails=vehicledetails;
    }
    public int registerVehicle() throws ClassNotFoundException, SQLException{
        LoginSignUp conn=new LoginSignUp("admin","admin@gmail.com","root");
        con=conn.getConnection();
        PreparedStatement ps=con.prepareStatement("insert into vehiclereg(owner,vehicleregno,vehicledetails) values(?,?,?)");
        ps.setString(1,owner);
        ps.setString(2,vehicleregno);
        ps.setString(3,vehicledetails);
        int rs=ps.executeUpdate();
        if(rs>0){
            return 1;
        }
        return 0;
    }
    public String[] getDetailsNVerify(String regno) throws ClassNotFoundException, SQLException{
        String vehicleDetails[]=new String[4];
        vehicleDetails[0]="0";
        vehicleDetails[1]="0";
        vehicleDetails[2]="0";
        vehicleDetails[3]="0";
        LoginSignUp conn=new LoginSignUp("admin","admin@gmail.com","root");
        con=conn.getConnection();
        PreparedStatement ps=con.prepareStatement("select * from vehiclereg where vehicleregno=?");
        ps.setString(1,regno);
        ResultSet rs=ps.executeQuery();
        if(rs.next()){
           vehicleDetails[0]="1";
           vehicleDetails[1]=rs.getString("owner");
           vehicleDetails[2]=rs.getString("vehicleregno");
           vehicleDetails[3]=rs.getString("vehicledetails");
           return vehicleDetails;
        }
        return vehicleDetails;
    }
}
