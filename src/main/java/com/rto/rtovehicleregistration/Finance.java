
package com.rto.rtovehicleregistration;

import java.sql.*;


public class Finance extends VehicleRegistration{  
    double balance;
    LoginSignUp conn=new LoginSignUp("admin","admin@gmail.com","root");
    Connection con=conn.getConnection();
        
    public Finance() throws ClassNotFoundException, SQLException {
        PreparedStatement ps=con.prepareStatement("select * from finance");
        ResultSet rs=ps.executeQuery();
        if(rs.next()){
            this.balance=rs.getDouble("balance");
        }
    }

    public int poolFunds(double amount) throws SQLException {
        if (amount > 0) {
            balance += amount;
            PreparedStatement ps1=con.prepareStatement("update finance set balance=?");
            ps1.setDouble(1,balance);
            int rs=ps1.executeUpdate();
            if(rs>0){
                System.out.println("Funds pooled successfully, New balance: Rs" + balance);
                return 1;
            }
        } else {
            System.out.println("Amount must be greater than zero");
            return 0;
        }
        return 0;
    }

    public void economicDevelopment(double cost) throws SQLException {
        if (cost > 0 && balance >= cost) {
            balance -= cost;
            PreparedStatement ps2=con.prepareStatement("update finance set balance=?");
            ps2.setDouble(1,balance);
            int rs=ps2.executeUpdate();
            System.out.println("Economic development project funded. Cost: Rs" + cost + ", Remaining balance: Rs" + balance);
        } 
        else if (cost <= 0) {
            System.out.println("Cost must be greater than zero");
        }else {
            System.out.println("Insufficient funds for economic development, Current balance: Rs" + balance);
        }
    }
    public boolean decisionMaking() {
        if (balance > 500000) {
            System.out.println("Sufficient funds available, Proceed with advanced development projects");
            return true;
        } else if (balance > 100000) {
            System.out.println("Moderate funds available, Focus on essential projects");
            return true;
        } else {
            System.out.println("Low funds available, Consider pooling more funds before proceeding with new projects");
            return false;
        }
    }
}
