package com.rto.rtovehicleregistration;

import java.sql.*;

public class LoginSignUp {
    String name;
    String emailid;
    String password;
    Connection con;
    public LoginSignUp(){}
    public LoginSignUp(String name,String emailid,String password){
        this.name=name;
        this.emailid=emailid;
        this.password=password;
    }
    public Connection getConnection() throws ClassNotFoundException{
        try{
            if(con==null){
                Class.forName("com.mysql.cj.jdbc.Driver");
                String url="jdbc:mysql://localhost:3306/rtovehiclemanagement";
                String username="root";
                String password="Ramesh@30";
                con=DriverManager.getConnection(url,username,password);
            }
        }catch(Exception e){
            e.getStackTrace();
        }
        return con;
    }
    public String[] login() throws SQLException{
        String[] result=new String[2];
        result[0]="0";
        result[1]="none";
        if(con==null){
            try {   
                con=getConnection();
            } catch (Exception ex) {
                ex.getStackTrace();
            }
        }
        try{
            PreparedStatement ps=con.prepareStatement("select * from users where name=? and emailid=? and password=?");
            ps.setString(1, name);
            ps.setString(2, emailid);
            ps.setString(3, password);
            ResultSet rs=ps.executeQuery();
            
            if(rs.next()){
                result[0]="1";
                result[1]=name;
                return result;
            }
            else{
                return result;
            }
        }catch(Exception ex){
            ex.getStackTrace();
        }
        return result;
    }
    public String[] signUp(){
        String[] result=new String[2];
        result[0]="0";
        result[1]="none";
        if(con==null){
            try {
                con=getConnection();
            } catch (Exception ex) {
                ex.getStackTrace();
            }
        }
        try{
            PreparedStatement ps=con.prepareStatement("insert into users values(?,?,?)");
            ps.setString(1, name);
            ps.setString(2, emailid);
            ps.setString(3, password);
            int rs=ps.executeUpdate();
            if(rs>0){
                result[0]="1";
                result[1]=name;
                return result;
            }
            else{
                return result;
            }
        }catch(Exception ex){
            ex.getStackTrace();
        }
        return result;
    }
}
