/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.travelagency;
import java.sql.CallableStatement;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Baknis
 */
public class Menu extends javax.swing.JFrame {
    
    /**
     * Creates new form Menu
     */
    public Menu() {
        initComponents();
            
            //here sonoo is database name, root is username and password
            try  {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection( "jdbc:mysql://localhost:3306/travelagency","root","root");
                
                /*Branch*/
                Statement stmt=con.createStatement();
                ResultSet rs=stmt.executeQuery("select * from branch");
                DefaultTableModel tbModel = (DefaultTableModel)jTable2.getModel();
                tbModel.setRowCount(0);
                while(rs.next()){

                    String br_code = String.valueOf(rs.getInt("br_code") );
                    String br_num = String.valueOf( rs.getInt("br_num") );
                    String br_street = rs.getString("br_street");
                    String br_city = rs.getString("br_city");

                    String tbData[] = {br_code, br_num, br_street, br_city};
                    //DefaultTableModel tbModel = (DefaultTableModel)jTable2.getModel();
                    
                    tbModel.addRow(tbData);
                }
                
                /*Phones*/
                stmt=con.createStatement();
                rs=stmt.executeQuery("select * from phones");
                tbModel = (DefaultTableModel)jTable1.getModel();
                tbModel.setRowCount(0);
                while(rs.next()){

                    String ph_br_code = String.valueOf(rs.getInt("ph_br_code") );
                    String ph_number = rs.getString("ph_number");

                    String tbData[] = {ph_br_code, ph_number};
                    
                    tbModel.addRow(tbData);
                }
                
                /*Destination*/
                stmt=con.createStatement();
                rs=stmt.executeQuery("select * from destination");
                tbModel = (DefaultTableModel)jTable3.getModel();
                tbModel.setRowCount(0);
                while(rs.next()){

                    String dst_id = String.valueOf(rs.getInt("dst_id") );
                    String dst_name = rs.getString("dst_name");
                    String dst_descr = rs.getString("dst_descr");
                    String dst_rtype = rs.getString("dst_rtype"); 
                    String dst_language = rs.getString("dst_language");
                    String dst_location = String.valueOf(rs.getInt("dst_location") );
                    String tbData[] = {dst_id, dst_name, dst_descr, dst_rtype, dst_language, dst_location};
                    //DefaultTableModel tbModel = (DefaultTableModel)jTable2.getModel();
                    
                    tbModel.addRow(tbData);
                }
                
                /*Worker*/
                stmt=con.createStatement();
                rs=stmt.executeQuery("select * from worker");
                tbModel = (DefaultTableModel)jTable4.getModel();
                tbModel.setRowCount(0);
                while(rs.next()){
                    
                    String wrk_AT = rs.getString("wrk_AT");
                    String wrk_name = rs.getString("wrk_name");
                    String wrk_lame = rs.getString("wrk_lame");
                    String wrk_salary = String.valueOf(rs.getFloat("wrk_salary") );
                    String wrk_br_code = String.valueOf( rs.getInt("wrk_br_code") );
                    
                    String tbData[] = {wrk_AT,wrk_name, wrk_lame, wrk_salary, wrk_br_code};

                    tbModel.addRow(tbData);
                }
                
                /*Guide*/
                stmt=con.createStatement();
                rs=stmt.executeQuery("select * from guide");
                tbModel = (DefaultTableModel)jTable5.getModel();
                tbModel.setRowCount(0);
                while(rs.next()){

                    String gui_AT = rs.getString("gui_AT");
                    String gui_cv = rs.getString("gui_CV");
                    
                    String tbData[] = {gui_AT, gui_cv};
                    
                    
                    tbModel.addRow(tbData);
                }
                
                /*Languages*/
                stmt=con.createStatement();
                rs=stmt.executeQuery("select * from languages");
                tbModel = (DefaultTableModel)jTable6.getModel();
                tbModel.setRowCount(0);
                while(rs.next()){
                    
                    String lng_gui_AT = rs.getString("lng_gui_AT");
                    String lng_language = rs.getString("lng_language");

                    String tbData[] = {lng_gui_AT, lng_language};
                    
                    tbModel.addRow(tbData);
                }
                
                /*Driver*/
                stmt=con.createStatement();
                rs=stmt.executeQuery("select * from driver");
                tbModel = (DefaultTableModel)jTable7.getModel();
                tbModel.setRowCount(0);
                while(rs.next()){

                    String drv_AT = rs.getString("drv_AT");
                    String drv_license = rs.getString("drv_license");
                    String drv_route = rs.getString("drv_route");
                    String drv_experience = String.valueOf(rs.getInt("drv_experience") );

                    String tbData[] = {drv_AT ,drv_license , drv_route, drv_experience};
                    
                    tbModel.addRow(tbData);
                }
                
                /*Admin*/
                stmt=con.createStatement();
                rs=stmt.executeQuery("select * from admin");
                tbModel = (DefaultTableModel)jTable8.getModel();
                tbModel.setRowCount(0);
                while(rs.next()){

                    String adm_AT = rs.getString("adm_AT");
                    String adm_type = rs.getString("adm_type");
                    String adm_diploma = rs.getString("adm_diploma");

                    String tbData[] = {adm_AT, adm_type, adm_diploma};
                    //DefaultTableModel tbModel = (DefaultTableModel)jTable2.getModel();
                    
                    tbModel.addRow(tbData);
                }
                
                /*Manages*/
                stmt=con.createStatement();
                rs=stmt.executeQuery("select * from manages");
                tbModel = (DefaultTableModel)jTable9.getModel();
                tbModel.setRowCount(0);
                while(rs.next()){
                    
                    String mng_adm_AT = rs.getString("mng_adm_AT");
                    String mng_br_code = String.valueOf(rs.getInt("mng_br_code") );
                    
                    String tbData[] = {mng_adm_AT , mng_br_code};
                    
                    tbModel.addRow(tbData);
                }
                
                /*Trip*/
                stmt=con.createStatement();
                rs=stmt.executeQuery("select * from trip");
                tbModel = (DefaultTableModel)jTable10.getModel();
                tbModel.setRowCount(0);
                while(rs.next()){
                    
                    String tr_id = String.valueOf(rs.getInt("tr_id") );
                    String tr_departure = String.valueOf(rs.getDate("tr_departure") );
                    String tr_return = String.valueOf( rs.getDate("tr_return") );
                    //String tr_departure = rs.getString("tr_departure");
                    //String tr_return = rs.getString("tr_return");      
                    String tr_maxseats = String.valueOf(rs.getInt("tr_maxseats") );
              
                    String tr_cost = String.valueOf(rs.getFloat("tr_cost") );
                    
                    String tr_br_code = String.valueOf(rs.getInt("tr_br_code") );
                    String tr_gui_AT = rs.getString("tr_gui_AT");
                    String tr_drv_AT = rs.getString("tr_drv_AT");

                    String tbData[] = {tr_id , tr_departure, tr_return, tr_maxseats, tr_cost, tr_br_code, tr_gui_AT,tr_drv_AT};
                    
                    tbModel.addRow(tbData);
                }
                
                /*Event*/
                stmt=con.createStatement();
                rs=stmt.executeQuery("select * from event");
                tbModel = (DefaultTableModel)jTable11.getModel();
                tbModel.setRowCount(0);
                while(rs.next()){

                    String ev_tr_id = String.valueOf(rs.getInt("ev_tr_id") );
                    String ev_start = rs.getString("ev_start");
                    String ev_end = rs.getString("ev_end");
                    String ev_descr = rs.getString("ev_descr");

                    String tbData[] = {ev_tr_id, ev_start, ev_end, ev_descr};
                    
                    tbModel.addRow(tbData);
                }
                
                /*Reservation*/
                stmt=con.createStatement();
                rs=stmt.executeQuery("select * from reservation");
                tbModel = (DefaultTableModel)jTable12.getModel();
                tbModel.setRowCount(0);
                while(rs.next()){

                    String res_tr_id = String.valueOf(rs.getInt("res_tr_id") );
                    String res_seatnum = String.valueOf( rs.getInt("res_seatnum") );
                    String res_name = rs.getString("res_name");
                    String res_lname = rs.getString("res_lname");
                    String res_isadult = rs.getString("res_isadult");

                    String tbData[] = {res_tr_id, res_seatnum, res_name,  res_lname,res_isadult};
                    
                    tbModel.addRow(tbData);
                }
                
                /*travelTo*/
//                stmt=con.createStatement();
//                rs=stmt.executeQuery("select * from travelTo");
//                tbModel = (DefaultTableModel)jTable2.getModel();
//                tbModel.setRowCount(0);
//                while(rs.next()){
//
//                    String br_code = String.valueOf(rs.getInt("br_code") );
//                    String br_num = String.valueOf( rs.getInt("br_num") );
//                    String br_street = rs.getString("br_street");
//                    String br_city = rs.getString("br_city");
//
//                    String tbData[] = {br_code, br_num, br_street, br_city};
//                    
//                    tbModel.addRow(tbData);
//                }

                /*Offers*/
                stmt=con.createStatement();
                rs=stmt.executeQuery("select * from offers");
                tbModel = (DefaultTableModel)jTable13.getModel();
                tbModel.setRowCount(0);
                while(rs.next()){
                    
                    String offer_id = String.valueOf( rs.getInt("offer_id") );
                    String offer_startDate = rs.getString("offer_startDate");
                    String offer_endDate = rs.getString("offer_endDate");
                    String cost_per_person = String.valueOf(rs.getFloat("cost_per_person") );
                    String offer_dst_id = String.valueOf( rs.getInt("offer_dst_id") );
                    

                    String tbData[] = {offer_id, offer_startDate, offer_endDate, cost_per_person ,offer_dst_id};
                    
                    tbModel.addRow(tbData);
                }
                
                /*Reservation Offers*/
                stmt=con.createStatement();
                rs=stmt.executeQuery("select * from reservation_offers");
                 tbModel = (DefaultTableModel)jTable14.getModel();
                tbModel.setRowCount(0);
                while(rs.next()){

                    String res_offer_id = String.valueOf(rs.getInt("res_offer_id") );
                    String res_name = rs.getString("res_name");
                    String res_lname = rs.getString("res_lname");
                    String offer_id_trip = String.valueOf( rs.getInt("offer_id_trip") );
                    String res_deposit = String.valueOf( rs.getFloat("res_deposit") );
                    
                    String tbData[] = {res_offer_id, res_name, res_lname, offer_id_trip, res_deposit};
                    
                    tbModel.addRow(tbData);
                }
                /*itOfficer*/
                 stmt=con.createStatement();
                 rs=stmt.executeQuery("select * from itOfficer");
                 tbModel = (DefaultTableModel)jTable15.getModel();
                tbModel.setRowCount(0);
                while(rs.next()){

                    String it_AT = rs.getString("it_AT");
                    String password = rs.getString("password");
                    String start_date = rs.getString("start_date");
                    String end_date = rs.getString("end_date");

                    String tbData[] = {it_AT, password, start_date, end_date};
                    
                    tbModel.addRow(tbData);
                }
                
                /*Log*/
                 stmt=con.createStatement();
                 rs=stmt.executeQuery("select * from log");
                 tbModel = (DefaultTableModel)jTable16.getModel();
                tbModel.setRowCount(0);
                while(rs.next()){

                    String logid = String.valueOf(rs.getInt("logid") );
                    String logdescrc = rs.getString("logdescrc");
                    String log_ID_AT = rs.getString("log_ID_AT");
                    String log_date = rs.getString("log_date");

                    String tbData[] = {logid, logdescrc, log_ID_AT, log_date};
                    
                    tbModel.addRow(tbData);
                }
                con.close();
            }
        catch(Exception e){ System.out.println(e);}  
        
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dataMenuPanel = new javax.swing.JPanel();
        branchesPanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        adminsPanel = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTable8 = new javax.swing.JTable();
        jButton18 = new javax.swing.JButton();
        jButton19 = new javax.swing.JButton();
        jButton20 = new javax.swing.JButton();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jComboBox4 = new javax.swing.JComboBox<>();
        jComboBox5 = new javax.swing.JComboBox<>();
        jTextField21 = new javax.swing.JTextField();
        destinationsPanel = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jTextField10 = new javax.swing.JTextField();
        jTextField11 = new javax.swing.JTextField();
        jTextField12 = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jTextField14 = new javax.swing.JTextField();
        jTextField15 = new javax.swing.JTextField();
        jComboBox20 = new javax.swing.JComboBox<>();
        driversPanel = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTable7 = new javax.swing.JTable();
        jButton21 = new javax.swing.JButton();
        jButton22 = new javax.swing.JButton();
        jButton23 = new javax.swing.JButton();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jComboBox6 = new javax.swing.JComboBox<>();
        jComboBox21 = new javax.swing.JComboBox<>();
        jTextField13 = new javax.swing.JTextField();
        jComboBox22 = new javax.swing.JComboBox<>();
        itOfficersPanel = new javax.swing.JPanel();
        jScrollPane15 = new javax.swing.JScrollPane();
        jTable15 = new javax.swing.JTable();
        jButton42 = new javax.swing.JButton();
        jButton43 = new javax.swing.JButton();
        jButton44 = new javax.swing.JButton();
        jLabel60 = new javax.swing.JLabel();
        jComboBox17 = new javax.swing.JComboBox<>();
        jLabel61 = new javax.swing.JLabel();
        jTextField38 = new javax.swing.JTextField();
        jLabel62 = new javax.swing.JLabel();
        jTextField39 = new javax.swing.JTextField();
        jLabel63 = new javax.swing.JLabel();
        jTextField40 = new javax.swing.JTextField();
        eventsPanel = new javax.swing.JPanel();
        jScrollPane11 = new javax.swing.JScrollPane();
        jTable11 = new javax.swing.JTable();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jTextField17 = new javax.swing.JTextField();
        jTextField18 = new javax.swing.JTextField();
        jTextField19 = new javax.swing.JTextField();
        jComboBox15 = new javax.swing.JComboBox<>();
        guidesPanel = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable5 = new javax.swing.JTable();
        jButton24 = new javax.swing.JButton();
        jButton25 = new javax.swing.JButton();
        jButton26 = new javax.swing.JButton();
        jLabel36 = new javax.swing.JLabel();
        jComboBox7 = new javax.swing.JComboBox<>();
        jLabel37 = new javax.swing.JLabel();
        jTextField24 = new javax.swing.JTextField();
        languagesPanel = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTable6 = new javax.swing.JTable();
        jButton30 = new javax.swing.JButton();
        jButton31 = new javax.swing.JButton();
        jButton32 = new javax.swing.JButton();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jTextField25 = new javax.swing.JTextField();
        jComboBox10 = new javax.swing.JComboBox<>();
        managersPanel = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        jTable9 = new javax.swing.JTable();
        jButton27 = new javax.swing.JButton();
        jButton29 = new javax.swing.JButton();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jComboBox8 = new javax.swing.JComboBox<>();
        jComboBox9 = new javax.swing.JComboBox<>();
        offersPanel = new javax.swing.JPanel();
        jScrollPane13 = new javax.swing.JScrollPane();
        jTable13 = new javax.swing.JTable();
        jButton39 = new javax.swing.JButton();
        jButton40 = new javax.swing.JButton();
        jButton41 = new javax.swing.JButton();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jComboBox16 = new javax.swing.JComboBox<>();
        jTextField16 = new javax.swing.JTextField();
        jTextField35 = new javax.swing.JTextField();
        jTextField36 = new javax.swing.JTextField();
        jTextField37 = new javax.swing.JTextField();
        phonesPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        jLabel27 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<>();
        jLabel28 = new javax.swing.JLabel();
        jTextField20 = new javax.swing.JTextField();
        reservationsPanel = new javax.swing.JPanel();
        jScrollPane12 = new javax.swing.JScrollPane();
        jTable12 = new javax.swing.JTable();
        jButton35 = new javax.swing.JButton();
        jButton37 = new javax.swing.JButton();
        jButton38 = new javax.swing.JButton();
        jLabel50 = new javax.swing.JLabel();
        jComboBox14 = new javax.swing.JComboBox<>();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jTextField31 = new javax.swing.JTextField();
        jTextField32 = new javax.swing.JTextField();
        jTextField33 = new javax.swing.JTextField();
        jComboBox19 = new javax.swing.JComboBox<>();
        reservationOffersPanel = new javax.swing.JPanel();
        jScrollPane14 = new javax.swing.JScrollPane();
        jTable14 = new javax.swing.JTable();
        jButton45 = new javax.swing.JButton();
        jButton46 = new javax.swing.JButton();
        jButton47 = new javax.swing.JButton();
        jLabel64 = new javax.swing.JLabel();
        jTextField41 = new javax.swing.JTextField();
        jLabel65 = new javax.swing.JLabel();
        jTextField42 = new javax.swing.JTextField();
        jLabel66 = new javax.swing.JLabel();
        jTextField43 = new javax.swing.JTextField();
        jLabel67 = new javax.swing.JLabel();
        jComboBox18 = new javax.swing.JComboBox<>();
        jLabel68 = new javax.swing.JLabel();
        jTextField44 = new javax.swing.JTextField();
        tripsPanel = new javax.swing.JPanel();
        jScrollPane10 = new javax.swing.JScrollPane();
        jTable10 = new javax.swing.JTable();
        jButton33 = new javax.swing.JButton();
        jButton34 = new javax.swing.JButton();
        jButton36 = new javax.swing.JButton();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jComboBox11 = new javax.swing.JComboBox<>();
        jComboBox12 = new javax.swing.JComboBox<>();
        jComboBox13 = new javax.swing.JComboBox<>();
        jTextField26 = new javax.swing.JTextField();
        jTextField27 = new javax.swing.JTextField();
        jTextField28 = new javax.swing.JTextField();
        jTextField29 = new javax.swing.JTextField();
        jTextField30 = new javax.swing.JTextField();
        workersPanel = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jTextField9 = new javax.swing.JTextField();
        jComboBox2 = new javax.swing.JComboBox<>();
        travelToPanel = new javax.swing.JPanel();
        jScrollPane23 = new javax.swing.JScrollPane();
        jTable23 = new javax.swing.JTable();
        branchesMenuPanel = new javax.swing.JPanel();
        branchInfoPanel = new javax.swing.JPanel();
        jScrollPane17 = new javax.swing.JScrollPane();
        jTable17 = new javax.swing.JTable();
        jScrollPane18 = new javax.swing.JScrollPane();
        jTable18 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane19 = new javax.swing.JScrollPane();
        jTable19 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane20 = new javax.swing.JScrollPane();
        jTable20 = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        startDateTextField = new javax.swing.JTextField();
        endDateTextField = new javax.swing.JTextField();
        offersMenuPanel = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane21 = new javax.swing.JScrollPane();
        jTable21 = new javax.swing.JTable();
        jScrollPane22 = new javax.swing.JScrollPane();
        jTable22 = new javax.swing.JTable();
        logsMenuPanel = new javax.swing.JPanel();
        jScrollPane16 = new javax.swing.JScrollPane();
        jTable16 = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenuItem13 = new javax.swing.JMenuItem();
        jMenuItem14 = new javax.swing.JMenuItem();
        jMenuItem15 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem17 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem16 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem18 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.CardLayout());

        dataMenuPanel.setLayout(new java.awt.CardLayout());

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "br_code", "br_num", "br_street", "br_city"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable2);

        jButton1.setText("New Branch");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Delete Branch");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel8.setText("br_code");

        jLabel9.setText("br_num");

        jLabel10.setText("br_street");

        jLabel11.setText("br_city");

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });

        jButton5.setText("Change Branch Data");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout branchesPanelLayout = new javax.swing.GroupLayout(branchesPanel);
        branchesPanel.setLayout(branchesPanelLayout);
        branchesPanelLayout.setHorizontalGroup(
            branchesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(branchesPanelLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(branchesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1077, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(branchesPanelLayout.createSequentialGroup()
                        .addGroup(branchesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton2)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton5))
                        .addGap(347, 347, 347)
                        .addGroup(branchesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(branchesPanelLayout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, branchesPanelLayout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField2))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, branchesPanelLayout.createSequentialGroup()
                                .addGroup(branchesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel11))
                                .addGap(18, 18, 18)
                                .addGroup(branchesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField4)
                                    .addComponent(jTextField5))))))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        branchesPanelLayout.setVerticalGroup(
            branchesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(branchesPanelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(branchesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jLabel8)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(branchesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(branchesPanelLayout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(branchesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(50, 50, 50))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, branchesPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5)
                        .addGap(40, 40, 40)))
                .addGroup(branchesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addGap(46, 46, 46)
                .addGroup(branchesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(265, Short.MAX_VALUE))
        );

        dataMenuPanel.add(branchesPanel, "card2");

        jTable8.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "adm_AT", "adm_type", "adm_diploma"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable8.setColumnSelectionAllowed(true);
        jScrollPane8.setViewportView(jTable8);
        jTable8.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        jButton18.setText("New Admin");
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });

        jButton19.setText("Change Admin Data");

        jButton20.setText("Delete Admin");

        jLabel29.setText("adm_AT");

        jLabel30.setText("adm_type");

        jLabel31.setText("adm_diploma");

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBox5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "LOGISTICS", "ADMINISTRATIVE", "ACCOUNTING'" }));

        javax.swing.GroupLayout adminsPanelLayout = new javax.swing.GroupLayout(adminsPanel);
        adminsPanel.setLayout(adminsPanelLayout);
        adminsPanelLayout.setHorizontalGroup(
            adminsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(adminsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 1137, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(adminsPanelLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(adminsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jButton19, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
                    .addComponent(jButton18, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(120, 120, 120)
                .addGroup(adminsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(adminsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel29, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel30, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel31))
                .addGap(41, 41, 41)
                .addGroup(adminsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox5, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField21))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        adminsPanelLayout.setVerticalGroup(
            adminsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(adminsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55)
                .addGroup(adminsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton18)
                    .addComponent(jLabel29)
                    .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(adminsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton19)
                    .addGroup(adminsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel30)
                        .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(40, 40, 40)
                .addGroup(adminsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton20)
                    .addComponent(jLabel31)
                    .addComponent(jTextField21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(343, Short.MAX_VALUE))
        );

        dataMenuPanel.add(adminsPanel, "card3");

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "dst_id", "dst_name", "dst_descr", "dst_rtype", "dst_language", "dst_location"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane3.setViewportView(jTable3);

        jButton9.setText("New destination");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton10.setText("Change destination data");

        jButton11.setText("Delete destination");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jLabel17.setText("dst_id");

        jLabel18.setText("sdt_name");

        jLabel19.setText("dst_descr");

        jLabel20.setText("dst_rtype");

        jLabel21.setText("dst_language");

        jLabel22.setText("dst_location");

        jComboBox20.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "LOCAL ", "ABROAD" }));

        javax.swing.GroupLayout destinationsPanelLayout = new javax.swing.GroupLayout(destinationsPanel);
        destinationsPanel.setLayout(destinationsPanelLayout);
        destinationsPanelLayout.setHorizontalGroup(
            destinationsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(destinationsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1137, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(destinationsPanelLayout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addGroup(destinationsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(198, 198, 198)
                .addGroup(destinationsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17)
                    .addComponent(jLabel18)
                    .addComponent(jLabel19))
                .addGap(41, 41, 41)
                .addGroup(destinationsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField10)
                    .addComponent(jTextField11)
                    .addComponent(jTextField12, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE))
                .addGap(151, 151, 151)
                .addGroup(destinationsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20)
                    .addComponent(jLabel21)
                    .addComponent(jLabel22))
                .addGap(39, 39, 39)
                .addGroup(destinationsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(destinationsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jTextField14)
                        .addComponent(jTextField15, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE))
                    .addComponent(jComboBox20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        destinationsPanelLayout.setVerticalGroup(
            destinationsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(destinationsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(73, 73, 73)
                .addGroup(destinationsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton9)
                    .addComponent(jLabel17)
                    .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20)
                    .addComponent(jComboBox20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addGroup(destinationsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton10)
                    .addGroup(destinationsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel18)
                        .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel21)
                        .addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(45, 45, 45)
                .addGroup(destinationsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton11)
                    .addComponent(jLabel19)
                    .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22)
                    .addComponent(jTextField15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(313, Short.MAX_VALUE))
        );

        dataMenuPanel.add(destinationsPanel, "card4");

        jTable7.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "drv_AT", "drv_license", "drv_route", "drv_experience"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable7.setColumnSelectionAllowed(true);
        jScrollPane7.setViewportView(jTable7);
        jTable7.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        jButton21.setText("New Driver");
        jButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton21ActionPerformed(evt);
            }
        });

        jButton22.setText("Change Driver Data");

        jButton23.setText("Delete Driver");
        jButton23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton23ActionPerformed(evt);
            }
        });

        jLabel32.setText("drv_AT");

        jLabel33.setText("drv_license");

        jLabel34.setText("drv_route");

        jLabel35.setText("drv_experience");

        jComboBox6.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBox21.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A", "B", "C", "D" }));

        jComboBox22.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "LOCAL", "ABROAD" }));

        javax.swing.GroupLayout driversPanelLayout = new javax.swing.GroupLayout(driversPanel);
        driversPanel.setLayout(driversPanelLayout);
        driversPanelLayout.setHorizontalGroup(
            driversPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(driversPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 1137, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(driversPanelLayout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(driversPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton22, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                    .addComponent(jButton23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(115, 115, 115)
                .addGroup(driversPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel32)
                    .addComponent(jLabel33)
                    .addComponent(jLabel34))
                .addGap(40, 40, 40)
                .addGroup(driversPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBox21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(driversPanelLayout.createSequentialGroup()
                        .addGroup(driversPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jComboBox22, javax.swing.GroupLayout.Alignment.LEADING, 0, 171, Short.MAX_VALUE)
                            .addComponent(jComboBox6, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(107, 107, 107)
                        .addComponent(jLabel35)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        driversPanelLayout.setVerticalGroup(
            driversPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(driversPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addGroup(driversPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton21)
                    .addComponent(jLabel32)
                    .addComponent(jLabel35)
                    .addComponent(jComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addGroup(driversPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(driversPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jButton22)
                        .addComponent(jLabel33))
                    .addGroup(driversPanelLayout.createSequentialGroup()
                        .addComponent(jComboBox21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)))
                .addGroup(driversPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(driversPanelLayout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(driversPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton23)
                            .addComponent(jLabel34)))
                    .addGroup(driversPanelLayout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jComboBox22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(327, Short.MAX_VALUE))
        );

        dataMenuPanel.add(driversPanel, "card5");

        jTable15.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "it_AT", "password", "start_date", "end_date"
            }
        ));
        jScrollPane15.setViewportView(jTable15);

        jButton42.setText("New it officer");
        jButton42.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton42ActionPerformed(evt);
            }
        });

        jButton43.setText("Change it officer data");

        jButton44.setText("Delete it officer");
        jButton44.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton44ActionPerformed(evt);
            }
        });

        jLabel60.setText("it_AT");

        jComboBox17.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel61.setText("password");

        jLabel62.setText("start_date");

        jLabel63.setText("end_date");

        javax.swing.GroupLayout itOfficersPanelLayout = new javax.swing.GroupLayout(itOfficersPanel);
        itOfficersPanel.setLayout(itOfficersPanelLayout);
        itOfficersPanelLayout.setHorizontalGroup(
            itOfficersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(itOfficersPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane15, javax.swing.GroupLayout.DEFAULT_SIZE, 1137, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(itOfficersPanelLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(itOfficersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton42, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton43, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                    .addComponent(jButton44, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(139, 139, 139)
                .addGroup(itOfficersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(itOfficersPanelLayout.createSequentialGroup()
                        .addComponent(jLabel61)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField38, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(itOfficersPanelLayout.createSequentialGroup()
                        .addComponent(jLabel60)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(itOfficersPanelLayout.createSequentialGroup()
                        .addComponent(jLabel62)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField39)))
                .addGap(95, 95, 95)
                .addComponent(jLabel63)
                .addGap(18, 18, 18)
                .addComponent(jTextField40, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        itOfficersPanelLayout.setVerticalGroup(
            itOfficersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(itOfficersPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(itOfficersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(itOfficersPanelLayout.createSequentialGroup()
                        .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addGroup(itOfficersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton42)
                            .addComponent(jLabel60)
                            .addComponent(jComboBox17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel63)
                            .addComponent(jTextField40, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36)
                        .addComponent(jButton43))
                    .addGroup(itOfficersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel61)
                        .addComponent(jTextField38, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(50, 50, 50)
                .addGroup(itOfficersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton44)
                    .addComponent(jLabel62)
                    .addComponent(jTextField39, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(356, Short.MAX_VALUE))
        );

        dataMenuPanel.add(itOfficersPanel, "card6");

        jTable11.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ev_tr_id", "ev_start", "ev_end", "ev_descr"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane11.setViewportView(jTable11);

        jButton12.setText("New Event");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jButton13.setText("Change event data");

        jButton14.setText("Delete event data");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        jLabel23.setText("ev_tr_id");

        jLabel24.setText("ev_start");

        jLabel25.setText("ev_end");

        jLabel26.setText("ev_descr");

        jComboBox15.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout eventsPanelLayout = new javax.swing.GroupLayout(eventsPanel);
        eventsPanel.setLayout(eventsPanelLayout);
        eventsPanelLayout.setHorizontalGroup(
            eventsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(eventsPanelLayout.createSequentialGroup()
                .addGroup(eventsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(eventsPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane11, javax.swing.GroupLayout.DEFAULT_SIZE, 1137, Short.MAX_VALUE))
                    .addGroup(eventsPanelLayout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(eventsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jButton14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(103, 103, 103)
                        .addGroup(eventsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel23)
                            .addComponent(jLabel24)
                            .addComponent(jLabel25)
                            .addComponent(jLabel26))
                        .addGap(30, 30, 30)
                        .addGroup(eventsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(eventsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jTextField17)
                                .addComponent(jTextField18, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE))
                            .addComponent(jTextField19, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        eventsPanelLayout.setVerticalGroup(
            eventsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(eventsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addGroup(eventsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton12)
                    .addComponent(jLabel23)
                    .addComponent(jComboBox15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(eventsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton13)
                    .addGroup(eventsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel24)
                        .addComponent(jTextField17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(42, 42, 42)
                .addGroup(eventsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton14)
                    .addComponent(jLabel25)
                    .addComponent(jTextField18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addGroup(eventsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel26)
                    .addComponent(jTextField19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(286, Short.MAX_VALUE))
        );

        dataMenuPanel.add(eventsPanel, "card7");

        jTable5.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "gui_AT", "gui_cv"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane5.setViewportView(jTable5);

        jButton24.setText("New Guide");
        jButton24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton24ActionPerformed(evt);
            }
        });

        jButton25.setText("Change Guide Data");

        jButton26.setText("Delete Guide");
        jButton26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton26ActionPerformed(evt);
            }
        });

        jLabel36.setText("gui_At");

        jComboBox7.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox7ActionPerformed(evt);
            }
        });

        jLabel37.setText("gui_cv");

        javax.swing.GroupLayout guidesPanelLayout = new javax.swing.GroupLayout(guidesPanel);
        guidesPanel.setLayout(guidesPanelLayout);
        guidesPanelLayout.setHorizontalGroup(
            guidesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(guidesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 1137, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(guidesPanelLayout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(guidesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton25, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
                    .addComponent(jButton26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(157, 157, 157)
                .addGroup(guidesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel36)
                    .addComponent(jLabel37))
                .addGap(27, 27, 27)
                .addGroup(guidesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField24, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox7, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        guidesPanelLayout.setVerticalGroup(
            guidesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(guidesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addGroup(guidesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton24)
                    .addComponent(jLabel36)
                    .addComponent(jComboBox7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addComponent(jButton25)
                .addGap(14, 14, 14)
                .addGroup(guidesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel37)
                    .addComponent(jTextField24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addComponent(jButton26)
                .addContainerGap(332, Short.MAX_VALUE))
        );

        dataMenuPanel.add(guidesPanel, "card8");

        jTable6.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "lng_gui_AT", "lng_language"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable6.setColumnSelectionAllowed(true);
        jScrollPane6.setViewportView(jTable6);
        jTable6.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        jButton30.setText("New language");
        jButton30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton30ActionPerformed(evt);
            }
        });

        jButton31.setText("Change language data");

        jButton32.setText("Delete language");
        jButton32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton32ActionPerformed(evt);
            }
        });

        jLabel40.setText("lng_gui_AT");

        jLabel41.setText("lng_language");

        jComboBox10.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout languagesPanelLayout = new javax.swing.GroupLayout(languagesPanel);
        languagesPanel.setLayout(languagesPanelLayout);
        languagesPanelLayout.setHorizontalGroup(
            languagesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(languagesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 1137, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(languagesPanelLayout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addGroup(languagesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jButton30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(167, 167, 167)
                .addGroup(languagesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel41)
                    .addComponent(jLabel40))
                .addGap(73, 73, 73)
                .addGroup(languagesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField25)
                    .addComponent(jComboBox10, 0, 225, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        languagesPanelLayout.setVerticalGroup(
            languagesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(languagesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68)
                .addGroup(languagesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton30)
                    .addComponent(jLabel40)
                    .addComponent(jComboBox10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(69, 69, 69)
                .addGroup(languagesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton31)
                    .addComponent(jLabel41)
                    .addComponent(jTextField25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(68, 68, 68)
                .addComponent(jButton32)
                .addContainerGap(272, Short.MAX_VALUE))
        );

        dataMenuPanel.add(languagesPanel, "card9");

        jTable9.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "mng_adm_AT", "mng_br_code"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane9.setViewportView(jTable9);

        jButton27.setText("New Manager");
        jButton27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton27ActionPerformed(evt);
            }
        });

        jButton29.setText("Delete Manager");
        jButton29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton29ActionPerformed(evt);
            }
        });

        jLabel38.setText("mng_adm_AT");

        jLabel39.setText("mng_br_code");

        jComboBox8.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBox9.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout managersPanelLayout = new javax.swing.GroupLayout(managersPanel);
        managersPanel.setLayout(managersPanelLayout);
        managersPanelLayout.setHorizontalGroup(
            managersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(managersPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 1137, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(managersPanelLayout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(managersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton29)
                    .addGroup(managersPanelLayout.createSequentialGroup()
                        .addComponent(jButton27)
                        .addGap(255, 255, 255)
                        .addGroup(managersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel39)
                            .addComponent(jLabel38))))
                .addGap(36, 36, 36)
                .addGroup(managersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jComboBox8, 0, 161, Short.MAX_VALUE)
                    .addComponent(jComboBox9, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        managersPanelLayout.setVerticalGroup(
            managersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(managersPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64)
                .addGroup(managersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton27)
                    .addComponent(jLabel38)
                    .addComponent(jComboBox8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(managersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(managersPanelLayout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addGroup(managersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel39)
                            .addComponent(jComboBox9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(managersPanelLayout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(jButton29)))
                .addContainerGap(348, Short.MAX_VALUE))
        );

        dataMenuPanel.add(managersPanel, "card10");

        jTable13.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "offer_id", "offer_startDate", "offer_endDate", "cost_per_person", "offer_dst_id"
            }
        ));
        jTable13.setColumnSelectionAllowed(true);
        jScrollPane13.setViewportView(jTable13);
        jTable13.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        jButton39.setText("New Offer");
        jButton39.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton39ActionPerformed(evt);
            }
        });

        jButton40.setText("Change Offer Data");

        jButton41.setText("Delete Offer");
        jButton41.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton41ActionPerformed(evt);
            }
        });

        jLabel55.setText("offer_id");

        jLabel56.setText("offer_startDate");

        jLabel57.setText("offer_endDate");

        jLabel58.setText("cost_per_person");

        jLabel59.setText("offer_dst_id");

        jComboBox16.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout offersPanelLayout = new javax.swing.GroupLayout(offersPanel);
        offersPanel.setLayout(offersPanelLayout);
        offersPanelLayout.setHorizontalGroup(
            offersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(offersPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane13, javax.swing.GroupLayout.DEFAULT_SIZE, 1137, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(offersPanelLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(offersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton40)
                    .addComponent(jButton39, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton41, javax.swing.GroupLayout.Alignment.LEADING))
                .addGap(138, 138, 138)
                .addGroup(offersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(offersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel56, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel55, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel57))
                .addGap(33, 33, 33)
                .addGroup(offersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField16)
                    .addComponent(jTextField35)
                    .addComponent(jTextField36, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE))
                .addGap(84, 84, 84)
                .addGroup(offersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(offersPanelLayout.createSequentialGroup()
                        .addComponent(jLabel59, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addComponent(jComboBox16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(offersPanelLayout.createSequentialGroup()
                        .addComponent(jLabel58, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(jTextField37, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        offersPanelLayout.setVerticalGroup(
            offersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(offersPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addGroup(offersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton39)
                    .addComponent(jLabel55)
                    .addComponent(jLabel58)
                    .addComponent(jTextField16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField37, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(67, 67, 67)
                .addGroup(offersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton40)
                    .addComponent(jLabel56)
                    .addComponent(jLabel59)
                    .addComponent(jComboBox16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60)
                .addGroup(offersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton41)
                    .addGroup(offersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel57)
                        .addComponent(jTextField36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(388, Short.MAX_VALUE))
        );

        dataMenuPanel.add(offersPanel, "card11");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ph_br_code", "ph_number"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton15.setText("New Phone Number");
        jButton15.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                jButton15ComponentResized(evt);
            }
        });
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        jButton16.setText("Change Phone Data");

        jButton17.setText("Delete Phone ");
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });

        jLabel27.setText("ph_br_code");

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel28.setText("ph_number");

        javax.swing.GroupLayout phonesPanelLayout = new javax.swing.GroupLayout(phonesPanel);
        phonesPanel.setLayout(phonesPanelLayout);
        phonesPanelLayout.setHorizontalGroup(
            phonesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phonesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1137, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(phonesPanelLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(phonesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jButton15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(145, 145, 145)
                .addGroup(phonesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(50, 50, 50)
                .addGroup(phonesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField20, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        phonesPanelLayout.setVerticalGroup(
            phonesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phonesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addGroup(phonesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton15)
                    .addComponent(jLabel27)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(54, 54, 54)
                .addGroup(phonesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton16)
                    .addComponent(jLabel28)
                    .addComponent(jTextField20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(54, 54, 54)
                .addComponent(jButton17)
                .addContainerGap(339, Short.MAX_VALUE))
        );

        dataMenuPanel.add(phonesPanel, "card12");

        jTable12.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "res_tr_id", "res_seatnum", "res_name", "res_lname", "res_isadult"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable12.setColumnSelectionAllowed(true);
        jScrollPane12.setViewportView(jTable12);
        jTable12.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        jButton35.setText("New reservation");
        jButton35.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton35ActionPerformed(evt);
            }
        });

        jButton37.setText("Change reservation data");

        jButton38.setText("Delete reservation");
        jButton38.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton38ActionPerformed(evt);
            }
        });

        jLabel50.setText("res_tr_id");

        jComboBox14.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel51.setText("res_seatnum");

        jLabel52.setText("res_name");

        jLabel53.setText("res_lname");

        jLabel54.setText("res_isadult");

        jComboBox19.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ADULT", "MINOR" }));

        javax.swing.GroupLayout reservationsPanelLayout = new javax.swing.GroupLayout(reservationsPanel);
        reservationsPanel.setLayout(reservationsPanelLayout);
        reservationsPanelLayout.setHorizontalGroup(
            reservationsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(reservationsPanelLayout.createSequentialGroup()
                .addGroup(reservationsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(reservationsPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane12, javax.swing.GroupLayout.DEFAULT_SIZE, 1137, Short.MAX_VALUE))
                    .addGroup(reservationsPanelLayout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addGroup(reservationsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton35)
                            .addComponent(jButton37)
                            .addComponent(jButton38))
                        .addGap(113, 113, 113)
                        .addGroup(reservationsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel51)
                            .addComponent(jLabel52))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(reservationsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jComboBox14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField31, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                            .addComponent(jTextField32))
                        .addGap(79, 79, 79)
                        .addGroup(reservationsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel53)
                            .addComponent(jLabel54))
                        .addGap(33, 33, 33)
                        .addGroup(reservationsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField33, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        reservationsPanelLayout.setVerticalGroup(
            reservationsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(reservationsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62)
                .addGroup(reservationsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton35)
                    .addComponent(jLabel50)
                    .addComponent(jComboBox14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel53)
                    .addComponent(jTextField33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53)
                .addGroup(reservationsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton37)
                    .addComponent(jLabel51)
                    .addComponent(jLabel54)
                    .addComponent(jTextField31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(63, 63, 63)
                .addGroup(reservationsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton38)
                    .addGroup(reservationsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel52)
                        .addComponent(jTextField32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(299, Short.MAX_VALUE))
        );

        dataMenuPanel.add(reservationsPanel, "card13");

        jTable14.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "res_offer_id", "res_name", "res_lname", "offer_id_trip", "res_deposit"
            }
        ));
        jTable14.setColumnSelectionAllowed(true);
        jScrollPane14.setViewportView(jTable14);
        jTable14.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        jButton45.setText("New Reservation Offer");
        jButton45.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton45ActionPerformed(evt);
            }
        });

        jButton46.setText("Change Reservation Offer Data");

        jButton47.setText("Delete Reservation Offer");
        jButton47.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton47ActionPerformed(evt);
            }
        });

        jLabel64.setText("res_offer_id");

        jLabel65.setText("res_name");

        jLabel66.setText("res_lname");

        jLabel67.setText("offer_id_trip");

        jComboBox18.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel68.setText("res_deposit");

        javax.swing.GroupLayout reservationOffersPanelLayout = new javax.swing.GroupLayout(reservationOffersPanel);
        reservationOffersPanel.setLayout(reservationOffersPanelLayout);
        reservationOffersPanelLayout.setHorizontalGroup(
            reservationOffersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(reservationOffersPanelLayout.createSequentialGroup()
                .addGroup(reservationOffersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(reservationOffersPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane14, javax.swing.GroupLayout.DEFAULT_SIZE, 1137, Short.MAX_VALUE))
                    .addGroup(reservationOffersPanelLayout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(reservationOffersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(reservationOffersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jButton45, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton46, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jButton47, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(146, 146, 146)
                        .addGroup(reservationOffersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel64)
                            .addComponent(jLabel65)
                            .addComponent(jLabel66))
                        .addGap(18, 18, 18)
                        .addGroup(reservationOffersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField41)
                            .addComponent(jTextField42)
                            .addComponent(jTextField43, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE))
                        .addGap(130, 130, 130)
                        .addGroup(reservationOffersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel67)
                            .addComponent(jLabel68))
                        .addGap(18, 18, 18)
                        .addGroup(reservationOffersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField44, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        reservationOffersPanelLayout.setVerticalGroup(
            reservationOffersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(reservationOffersPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addGroup(reservationOffersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton45)
                    .addComponent(jLabel64)
                    .addComponent(jTextField41, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel67)
                    .addComponent(jComboBox18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(reservationOffersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton46)
                    .addGroup(reservationOffersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel65)
                        .addComponent(jTextField42, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel68)
                        .addComponent(jTextField44, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(reservationOffersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(reservationOffersPanelLayout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addGroup(reservationOffersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton47)
                            .addComponent(jLabel66)))
                    .addGroup(reservationOffersPanelLayout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jTextField43, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(340, Short.MAX_VALUE))
        );

        dataMenuPanel.add(reservationOffersPanel, "card14");

        jTable10.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "tr_id", "tr_departure", "tr_return", "tr_maxseats", "tr_cost", "tr_br_code", "tr_gui_AT", "tr_drv_AT"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable10.setColumnSelectionAllowed(true);
        jScrollPane10.setViewportView(jTable10);
        jTable10.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        jButton33.setText("Change trip data");

        jButton34.setText("Delete trip");
        jButton34.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton34ActionPerformed(evt);
            }
        });

        jButton36.setText("New trip");
        jButton36.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton36ActionPerformed(evt);
            }
        });

        jLabel42.setText("tr_id");

        jLabel43.setText("tr_departure");

        jLabel44.setText("tr_return");

        jLabel45.setText("tr_cost");

        jLabel46.setText("tr_br_code");

        jLabel47.setText("tr_gui_AT");

        jLabel48.setText("tr_maxseats");

        jLabel49.setText("tr_drv_AT");

        jComboBox11.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBox12.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBox13.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jTextField26.setText("jTextField26");

        jTextField27.setText("jTextField27");

        jTextField28.setText("jTextField28");

        jTextField29.setText("jTextField29");

        jTextField30.setText("jTextField30");

        javax.swing.GroupLayout tripsPanelLayout = new javax.swing.GroupLayout(tripsPanel);
        tripsPanel.setLayout(tripsPanelLayout);
        tripsPanelLayout.setHorizontalGroup(
            tripsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tripsPanelLayout.createSequentialGroup()
                .addGroup(tripsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tripsPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane10, javax.swing.GroupLayout.DEFAULT_SIZE, 1137, Short.MAX_VALUE))
                    .addGroup(tripsPanelLayout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addGroup(tripsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(tripsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(tripsPanelLayout.createSequentialGroup()
                                    .addComponent(jButton36, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(106, 106, 106)
                                    .addComponent(jLabel42))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tripsPanelLayout.createSequentialGroup()
                                    .addGroup(tripsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jButton33, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton34, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(tripsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel44, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel43, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35)
                        .addGroup(tripsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(tripsPanelLayout.createSequentialGroup()
                                .addComponent(jTextField29, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel49))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, tripsPanelLayout.createSequentialGroup()
                                .addGroup(tripsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jTextField28, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                                    .addComponent(jTextField27)
                                    .addComponent(jTextField26))
                                .addGap(70, 70, 70)
                                .addGroup(tripsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel45, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel46, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel47, javax.swing.GroupLayout.Alignment.TRAILING))))
                        .addGroup(tripsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(tripsPanelLayout.createSequentialGroup()
                                .addGap(53, 53, 53)
                                .addGroup(tripsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboBox11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBox12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBox13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(tripsPanelLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jTextField30, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        tripsPanelLayout.setVerticalGroup(
            tripsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tripsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tripsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(tripsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel47)
                        .addComponent(jComboBox12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(tripsPanelLayout.createSequentialGroup()
                        .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(85, 85, 85)
                        .addGroup(tripsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton36)
                            .addComponent(jLabel42)
                            .addComponent(jLabel45)
                            .addComponent(jTextField26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)
                        .addGroup(tripsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton33)
                            .addComponent(jLabel43)
                            .addComponent(jLabel46)
                            .addComponent(jComboBox11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(45, 45, 45)
                        .addGroup(tripsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton34)
                            .addGroup(tripsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel44)
                                .addComponent(jTextField28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(53, 53, 53)
                .addGroup(tripsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel48)
                    .addComponent(jLabel49)
                    .addComponent(jComboBox13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(232, Short.MAX_VALUE))
        );

        dataMenuPanel.add(tripsPanel, "card15");

        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "wrk_AT", "wrk_name", "wrk_lame", "wrk_salary", "wrk_br-code"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane4.setViewportView(jTable4);

        jButton6.setText("New Worker");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText("Change Worker Data");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setText("Delete Worker");

        jLabel12.setText("wrk_AT");

        jLabel13.setText("wrk_name");

        jLabel14.setText("wrk_lname");

        jLabel15.setText("wrk_salary");

        jLabel16.setText("wrk_br_code");

        jTextField7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField7ActionPerformed(evt);
            }
        });

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout workersPanelLayout = new javax.swing.GroupLayout(workersPanel);
        workersPanel.setLayout(workersPanelLayout);
        workersPanelLayout.setHorizontalGroup(
            workersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(workersPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 1137, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(workersPanelLayout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(workersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(335, 335, 335)
                .addGroup(workersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(workersPanelLayout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addGap(48, 48, 48)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(workersPanelLayout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addGap(60, 60, 60)
                        .addComponent(jTextField9, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE))
                    .addGroup(workersPanelLayout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addGap(57, 57, 57)
                        .addComponent(jTextField8))
                    .addGroup(workersPanelLayout.createSequentialGroup()
                        .addGroup(workersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(jLabel12))
                        .addGap(60, 60, 60)
                        .addGroup(workersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField6)
                            .addComponent(jTextField7, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        workersPanelLayout.setVerticalGroup(
            workersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(workersPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(workersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(workersPanelLayout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 446, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addComponent(jButton6))
                    .addGroup(workersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel12)
                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(workersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(workersPanelLayout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(jButton7)
                        .addGap(50, 50, 50))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, workersPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(workersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addGroup(workersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(17, 17, 17)))
                .addGroup(workersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton8)
                    .addGroup(workersPanelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(workersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(41, 41, 41)
                .addGroup(workersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(214, Short.MAX_VALUE))
        );

        dataMenuPanel.add(workersPanel, "card16");

        jTable23.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane23.setViewportView(jTable23);

        javax.swing.GroupLayout travelToPanelLayout = new javax.swing.GroupLayout(travelToPanel);
        travelToPanel.setLayout(travelToPanelLayout);
        travelToPanelLayout.setHorizontalGroup(
            travelToPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(travelToPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane23, javax.swing.GroupLayout.PREFERRED_SIZE, 1129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );
        travelToPanelLayout.setVerticalGroup(
            travelToPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(travelToPanelLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jScrollPane23, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(666, Short.MAX_VALUE))
        );

        dataMenuPanel.add(travelToPanel, "card17");

        getContentPane().add(dataMenuPanel, "card2");

        branchesMenuPanel.setLayout(new java.awt.CardLayout());

        jTable17.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "First Name", "Last Name", "Salary"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane17.setViewportView(jTable17);

        jTable18.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Branch Code", "Number", "Street", "City", "admin (FN)", "Last name (LN)", "Num of reservations", "Income"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane18.setViewportView(jTable18);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("Choose branch : ");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBox1MouseClicked(evt);
            }
        });
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Branch Info");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Worker branch info");

        jTable19.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Total salary of workers"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane19.setViewportView(jTable19);

        jLabel4.setText("Start Date");

        jLabel5.setText("End Date");

        jTable20.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "tripCost", "maxSeats", "reservCount", "emptySeats", "drivName", "drivLname", "GuideLname", "GuideNam", "departureDate", "returnDate"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane20.setViewportView(jTable20);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("Available Trips in given days");

        jButton3.setText("Show available trips");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        startDateTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startDateTextFieldActionPerformed(evt);
            }
        });

        endDateTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                endDateTextFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout branchInfoPanelLayout = new javax.swing.GroupLayout(branchInfoPanel);
        branchInfoPanel.setLayout(branchInfoPanelLayout);
        branchInfoPanelLayout.setHorizontalGroup(
            branchInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(branchInfoPanelLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(branchInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addGroup(branchInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane18)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane20)
                        .addGroup(branchInfoPanelLayout.createSequentialGroup()
                            .addGroup(branchInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(branchInfoPanelLayout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addGap(18, 18, 18)
                                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(79, 79, 79)
                                    .addComponent(jLabel4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(startDateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(32, 32, 32)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(endDateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton3))
                                .addComponent(jScrollPane17, javax.swing.GroupLayout.PREFERRED_SIZE, 897, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addComponent(jScrollPane19, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        branchInfoPanelLayout.setVerticalGroup(
            branchInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(branchInfoPanelLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(branchInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(branchInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(branchInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(startDateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(branchInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(endDateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(branchInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane17, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane19, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane18, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane20, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(86, 86, 86))
        );

        branchesMenuPanel.add(branchInfoPanel, "card3");

        getContentPane().add(branchesMenuPanel, "card3");

        jButton4.setText("Show reservations");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setText("Costumer Name:");

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jTable21.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "res_name", "res_lname", "offer_id", "offer_startDate", "offer_endDate", "cost_per_person", "offer_dst_id"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane21.setViewportView(jTable21);

        jTable22.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "offer_id", "offer_startDate", "offer_endDate", "cost_per_person", "offer_dst_id", "count(res_lname)"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane22.setViewportView(jTable22);

        javax.swing.GroupLayout offersMenuPanelLayout = new javax.swing.GroupLayout(offersMenuPanel);
        offersMenuPanel.setLayout(offersMenuPanelLayout);
        offersMenuPanelLayout.setHorizontalGroup(
            offersMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(offersMenuPanelLayout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(offersMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(offersMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(offersMenuPanelLayout.createSequentialGroup()
                            .addComponent(jLabel7)
                            .addGap(18, 18, 18)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane21, javax.swing.GroupLayout.DEFAULT_SIZE, 1018, Short.MAX_VALUE)
                    .addComponent(jScrollPane22))
                .addContainerGap(75, Short.MAX_VALUE))
        );
        offersMenuPanelLayout.setVerticalGroup(
            offersMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(offersMenuPanelLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(offersMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(jButton4)
                .addGap(35, 35, 35)
                .addComponent(jScrollPane21, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addComponent(jScrollPane22, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(314, Short.MAX_VALUE))
        );

        getContentPane().add(offersMenuPanel, "card4");

        jTable16.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "logid", "logdescr", "log_ID_AT", "log_date"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane16.setViewportView(jTable16);

        javax.swing.GroupLayout logsMenuPanelLayout = new javax.swing.GroupLayout(logsMenuPanel);
        logsMenuPanel.setLayout(logsMenuPanelLayout);
        logsMenuPanelLayout.setHorizontalGroup(
            logsMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(logsMenuPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane16, javax.swing.GroupLayout.DEFAULT_SIZE, 1137, Short.MAX_VALUE)
                .addContainerGap())
        );
        logsMenuPanelLayout.setVerticalGroup(
            logsMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(logsMenuPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane16, javax.swing.GroupLayout.PREFERRED_SIZE, 503, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(470, Short.MAX_VALUE))
        );

        getContentPane().add(logsMenuPanel, "card5");

        jMenu1.setText("Data");
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu1MouseClicked(evt);
            }
        });
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });

        jMenuItem2.setText("Admins");
        jMenuItem2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuItem2MouseClicked(evt);
            }
        });
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem1.setText("Branches");
        jMenuItem1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuItem1MouseClicked(evt);
            }
        });
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem3.setText("Destinations");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuItem4.setText("Drivers");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenuItem5.setText("Events");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem5);

        jMenuItem6.setText("Guides");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem6);

        jMenuItem7.setText("It Officers");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem7);

        jMenuItem8.setText("Languages");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem8);

        jMenuItem9.setText("Managers");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem9);

        jMenuItem10.setText("Offers");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem10);

        jMenuItem11.setText("Phones");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem11);

        jMenuItem12.setText("Reservations");
        jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem12ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem12);

        jMenuItem13.setText("Reservation offers");
        jMenuItem13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem13ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem13);

        jMenuItem14.setText("Trips");
        jMenuItem14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem14ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem14);

        jMenuItem15.setText("Workers");
        jMenuItem15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem15ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem15);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Branches");
        jMenu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu2ActionPerformed(evt);
            }
        });

        jMenuItem17.setText("Branch Info ");
        jMenuItem17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem17ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem17);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Offers");
        jMenu3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu3ActionPerformed(evt);
            }
        });

        jMenuItem16.setText("Offers Procedure");
        jMenuItem16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem16ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem16);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("Logs");

        jMenuItem18.setText("Logs data");
        jMenuItem18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem18ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem18);

        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        branchesMenuPanel.setVisible(false);
        logsMenuPanel.setVisible(false);
        offersMenuPanel.setVisible(false);
        dataMenuPanel.setVisible(true);
        dataMenuPanel.removeAll();
        dataMenuPanel.add(adminsPanel).setVisible(true);
        jComboBox4.removeAllItems();
        
        try  {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection( "jdbc:mysql://localhost:3306/travelagency","root","root");
            
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select * from admin");
            DefaultTableModel tbModel = (DefaultTableModel)jTable8.getModel();
            tbModel.setRowCount(0);
            while(rs.next()){

                String adm_AT = rs.getString("adm_AT");
                String adm_type = rs.getString("adm_type");
                String adm_diploma = rs.getString("adm_diploma");

                String tbData[] = {adm_AT, adm_type, adm_diploma};
                //DefaultTableModel tbModel = (DefaultTableModel)jTable2.getModel();

                tbModel.addRow(tbData);
            }
            
            rs=stmt.executeQuery("select distinct wrk_AT from worker");
            while(rs.next()){

                
                String br_code = rs.getString("wrk_AT");
                jComboBox4.addItem(br_code);

            }
            
            con.close();
        }
        catch(Exception e){ System.out.println(e);} 
        
    }//GEN-LAST:event_jMenuItem2ActionPerformed
    
    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        branchesMenuPanel.setVisible(false);
        logsMenuPanel.setVisible(false);
        offersMenuPanel.setVisible(false);
        dataMenuPanel.setVisible(true);
        dataMenuPanel.removeAll();
        dataMenuPanel.add(branchesPanel).setVisible(true);
        
        try  {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection( "jdbc:mysql://localhost:3306/travelagency","root","root");
            
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select * from branch");
            DefaultTableModel tbModel = (DefaultTableModel)jTable2.getModel();
            tbModel.setRowCount(0);
            while(rs.next()){

                String br_code = String.valueOf(rs.getInt("br_code") );
                String br_num = String.valueOf( rs.getInt("br_num") );
                String br_street = rs.getString("br_street");
                String br_city = rs.getString("br_city");

                String tbData[] = {br_code, br_num, br_street, br_city};
                //DefaultTableModel tbModel = (DefaultTableModel)jTable2.getModel();

                tbModel.addRow(tbData);
            }
            
            con.close();
        }
        catch(Exception e){ System.out.println(e);} 
        
    }//GEN-LAST:event_jMenuItem1ActionPerformed
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        if( !jTextField2.getText().equals("") && !jTextField3.getText().equals("") && !jTextField4.getText().equals("") && !jTextField5.getText().equals("") ){
            String br_code = jTextField2.getText();
            String br_num = jTextField3.getText();
            String br_street = jTextField4.getText();
            String br_city = jTextField5.getText();
            
            String insertBranchCommand = "INSERT INTO branch VALUES (" + br_code + "," + br_num +  "," + "'"  + br_street + "','" + br_city  + "'); " ;
            
            try  {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection( "jdbc:mysql://localhost:3306/travelagency","root","root");

                Statement stmt=con.createStatement();
                stmt.executeUpdate(insertBranchCommand);
                
                DefaultTableModel tbModel = (DefaultTableModel)jTable2.getModel();
                String tbData[] = { br_code, br_num, br_street , br_city};
                tbModel.addRow(tbData);
                con.close();
            }
            catch(Exception e){ System.out.println(e);} 
            
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
            
        int selectedRow = jTable2.getSelectedRow();
        String br_code = jTable2.getValueAt(selectedRow, 0).toString();
        System.out.println(br_code);
        String deleteBranchCommand = "delete from branch where br_code= " + br_code + ";"; 
        
        try  {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection( "jdbc:mysql://localhost:3306/travelagency","root","root");

            Statement stmt=con.createStatement();
            stmt.executeUpdate(deleteBranchCommand);

            DefaultTableModel tbModel = (DefaultTableModel)jTable2.getModel();
            
            tbModel.removeRow(selectedRow);
            con.close();
        }
        catch(Exception e){ System.out.println(e);} 
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed
        // TODO add your handling code here:
        
        //dataPanel.add(adminsPanel);
    }//GEN-LAST:event_jMenu1ActionPerformed

    private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseClicked
        // TODO add your handling code here:
        //dataPanel.removeAll();
        
    }//GEN-LAST:event_jMenu1MouseClicked

    private void jMenuItem1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem1MouseClicked
        // TODO add your handling code here:       
    }//GEN-LAST:event_jMenuItem1MouseClicked

    private void jMenuItem2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem2MouseClicked

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        branchesMenuPanel.setVisible(false);
        logsMenuPanel.setVisible(false);
        offersMenuPanel.setVisible(false);
        dataMenuPanel.setVisible(true);
        dataMenuPanel.removeAll();
        dataMenuPanel.add(destinationsPanel).setVisible(true);
        
        try  {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection( "jdbc:mysql://localhost:3306/travelagency","root","root");
        
                Statement stmt=con.createStatement();
                ResultSet rs=stmt.executeQuery("select * from destination");
                DefaultTableModel tbModel = (DefaultTableModel)jTable3.getModel();
                tbModel.setRowCount(0);
                while(rs.next()){

                    String dst_id = String.valueOf(rs.getInt("dst_id") );
                    String dst_name = rs.getString("dst_name");
                    String dst_descr = rs.getString("dst_descr");
                    String dst_rtype = rs.getString("dst_rtype"); 
                    String dst_language = rs.getString("dst_language");
                    String dst_location = String.valueOf(rs.getInt("dst_location") );
                    String tbData[] = {dst_id, dst_name, dst_descr, dst_rtype, dst_language, dst_location};
                    //DefaultTableModel tbModel = (DefaultTableModel)jTable2.getModel();
                    
                    tbModel.addRow(tbData);
                }
                
                con.close();
            }
        catch(Exception e){ System.out.println(e);} 
        
        
        
        
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
        branchesMenuPanel.setVisible(false);
        logsMenuPanel.setVisible(false);
        offersMenuPanel.setVisible(false);
        dataMenuPanel.setVisible(true);
        dataMenuPanel.removeAll();
        dataMenuPanel.add(driversPanel).setVisible(true);
        jComboBox6.removeAllItems();
        
        try  {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection( "jdbc:mysql://localhost:3306/travelagency","root","root");
            
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select * from driver");
            DefaultTableModel tbModel = (DefaultTableModel)jTable7.getModel();
            tbModel.setRowCount(0);
            while(rs.next()){

                String drv_AT = rs.getString("drv_AT");
                String drv_license = rs.getString("drv_license");
                String drv_route = rs.getString("drv_route");
                String drv_experience = String.valueOf(rs.getInt("drv_experience") );

                String tbData[] = {drv_AT ,drv_license , drv_route, drv_experience};

                tbModel.addRow(tbData);
            }
            
            rs=stmt.executeQuery("select distinct wrk_AT from worker");
            while(rs.next()){

                //String br_code = String.valueOf(rs.getInt("br_code") );
                String br_code = rs.getString("wrk_AT");
                jComboBox6.addItem(br_code);

            }
            
            con.close();
        }
        catch(Exception e){ System.out.println(e);} 
        
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:
        branchesMenuPanel.setVisible(false);
        logsMenuPanel.setVisible(false);
        offersMenuPanel.setVisible(false);
        dataMenuPanel.setVisible(true);
        dataMenuPanel.removeAll();
        dataMenuPanel.add(eventsPanel).setVisible(true);
        jComboBox15.removeAllItems();
        
        try  {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection( "jdbc:mysql://localhost:3306/travelagency","root","root");
            
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select * from event");
            DefaultTableModel tbModel = (DefaultTableModel)jTable11.getModel();
            tbModel.setRowCount(0);
            while(rs.next()){

                String ev_tr_id = String.valueOf(rs.getInt("ev_tr_id") );
                String ev_start = rs.getString("ev_start");
                String ev_end = rs.getString("ev_end");
                String ev_descr = rs.getString("ev_descr");

                String tbData[] = {ev_tr_id, ev_start, ev_end, ev_descr};

                tbModel.addRow(tbData);
            }
            
            rs=stmt.executeQuery("select distinct tr_id from trip");
            while(rs.next()){

                String tr_id = rs.getString("tr_id");
                jComboBox15.addItem(tr_id);

            }
            con.close();
        }
        catch(Exception e){ System.out.println(e);} 
        
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        // TODO add your handling code here:
        branchesMenuPanel.setVisible(false);
        logsMenuPanel.setVisible(false);
        offersMenuPanel.setVisible(false);
        dataMenuPanel.setVisible(true);
        dataMenuPanel.removeAll();
        dataMenuPanel.add(guidesPanel).setVisible(true);
        jComboBox7.removeAllItems();
        try  {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection( "jdbc:mysql://localhost:3306/travelagency","root","root");

            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select * from guide");
            DefaultTableModel tbModel = (DefaultTableModel)jTable5.getModel();
            tbModel.setRowCount(0);
            while(rs.next()){

                String gui_AT = rs.getString("gui_AT");
                String gui_cv = rs.getString("gui_CV");

                String tbData[] = {gui_AT, gui_cv};


                tbModel.addRow(tbData);
            }
            
            rs=stmt.executeQuery("select distinct wrk_AT from worker");
            while(rs.next()){

                //String br_code = String.valueOf(rs.getInt("br_code") );
                String wrk_AT = rs.getString("wrk_AT");
                jComboBox7.addItem(wrk_AT);

            }
            
            con.close();
            }
        catch(Exception e){ System.out.println(e);} 
        
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        // TODO add your handling code here:
        branchesMenuPanel.setVisible(false);
        logsMenuPanel.setVisible(false);
        offersMenuPanel.setVisible(false);
        dataMenuPanel.setVisible(true);
        dataMenuPanel.removeAll();
        dataMenuPanel.add(itOfficersPanel).setVisible(true);
        
        jComboBox3.removeAllItems();
        try  {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection( "jdbc:mysql://localhost:3306/travelagency","root","root");
                
                Statement stmt=con.createStatement();
                ResultSet rs=stmt.executeQuery("select * from itOfficer");
                DefaultTableModel tbModel = (DefaultTableModel)jTable15.getModel();
                tbModel.setRowCount(0);
                jComboBox17.removeAllItems();
                
                while(rs.next()){

                    String it_AT = rs.getString("it_AT");
                    String password = rs.getString("password");
                    String start_date = rs.getString("start_date");
                    String end_date = rs.getString("end_date");
                    
                    String tbData[] = { it_AT , password , start_date , end_date };
                    
                    tbModel.addRow(tbData);
                }
                
                rs=stmt.executeQuery("select distinct wrk_AT from worker");
                while(rs.next()){
                    
                    String wrk_AT = rs.getString("wrk_AT");
                    jComboBox17.addItem(wrk_AT);
                    
                }
                
                con.close();
        }
        catch(Exception e){ System.out.println(e);} 
        
    }//GEN-LAST:event_jMenuItem7ActionPerformed
    
    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        // TODO add your handling code here:
        branchesMenuPanel.setVisible(false);
        logsMenuPanel.setVisible(false);
        offersMenuPanel.setVisible(false);
        dataMenuPanel.setVisible(true);
        dataMenuPanel.removeAll();
        dataMenuPanel.add(languagesPanel).setVisible(true);
        jComboBox10.removeAllItems();
        
        try  {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection( "jdbc:mysql://localhost:3306/travelagency","root","root");
        
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select * from languages");
            DefaultTableModel tbModel = (DefaultTableModel)jTable6.getModel();
            tbModel.setRowCount(0);
            while(rs.next()){

                String lng_gui_AT = rs.getString("lng_gui_AT");
                String lng_language = rs.getString("lng_language");

                String tbData[] = {lng_gui_AT, lng_language};

                tbModel.addRow(tbData);
            }
            
            rs=stmt.executeQuery("select DISTINCT gui_AT from guide");
            while(rs.next()){

                //String br_code = String.valueOf(rs.getInt("br_code") );
                String gui_AT = rs.getString("gui_AT");
                jComboBox10.addItem(gui_AT);
                
            }
            
            con.close();
        }
        catch(Exception e){ System.out.println(e);} 
        
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        // TODO add your handling code here:
        branchesMenuPanel.setVisible(false);
        logsMenuPanel.setVisible(false);
        offersMenuPanel.setVisible(false);
        dataMenuPanel.setVisible(true);
        dataMenuPanel.removeAll();
        dataMenuPanel.add(managersPanel).setVisible(true);
        jComboBox8.removeAllItems();
        jComboBox9.removeAllItems();
        
        try  {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection( "jdbc:mysql://localhost:3306/travelagency","root","root");
        
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select * from manages");
            DefaultTableModel tbModel = (DefaultTableModel)jTable9.getModel();
            tbModel.setRowCount(0);
            while(rs.next()){

                String mng_adm_AT = rs.getString("mng_adm_AT");
                String mng_br_code = String.valueOf(rs.getInt("mng_br_code") );

                String tbData[] = {mng_adm_AT , mng_br_code};

                tbModel.addRow(tbData);
            }
            
            rs=stmt.executeQuery("select distinct adm_AT from admin");
            while(rs.next()){

                //String br_code = String.valueOf(rs.getInt("br_code") );
                String br_code = rs.getString("adm_AT");
                jComboBox8.addItem(br_code);

            }
            
            rs=stmt.executeQuery("select br_code from branch");
            while(rs.next()){

                //String br_code = String.valueOf(rs.getInt("br_code") );
                String br_code = rs.getString("br_code");
                jComboBox9.addItem(br_code);

            }
            
            con.close();
        }
        catch(Exception e){ System.out.println(e);} 
        
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        // TODO add your handling code here:
        branchesMenuPanel.setVisible(false);
        logsMenuPanel.setVisible(false);
        offersMenuPanel.setVisible(false);
        dataMenuPanel.setVisible(true);
        dataMenuPanel.removeAll();
        dataMenuPanel.add(offersPanel).setVisible(true);
        jComboBox16.removeAllItems();
        
        try  {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection( "jdbc:mysql://localhost:3306/travelagency","root","root");
            
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select * from offers");
            DefaultTableModel tbModel = (DefaultTableModel)jTable13.getModel();
            tbModel.setRowCount(0);
            while(rs.next()){
                
                String offer_id = String.valueOf( rs.getInt("offer_id") );
                String offer_startDate = rs.getString("offer_startDate");
                String offer_endDate = rs.getString("offer_endDate");
                String cost_per_person = String.valueOf(rs.getFloat("cost_per_person") );
                String offer_dst_id = String.valueOf( rs.getInt("offer_dst_id") );

                String tbData[] = {offer_id, offer_startDate, offer_endDate, cost_per_person ,offer_dst_id};

                tbModel.addRow(tbData);
            }
            
            rs=stmt.executeQuery("select distinct dst_id from destination");
            while(rs.next()){
                
                String dst_id = rs.getString("dst_id");
                jComboBox16.addItem(dst_id);

            }
            con.close();
            }
        catch(Exception e){ System.out.println(e);} 
        
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
        // TODO add your handling code here:
        branchesMenuPanel.setVisible(false);
        logsMenuPanel.setVisible(false);
        offersMenuPanel.setVisible(false);
        dataMenuPanel.setVisible(true);
        dataMenuPanel.removeAll();
        dataMenuPanel.add(phonesPanel).setVisible(true);
        jComboBox3.removeAllItems();
        try  {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection( "jdbc:mysql://localhost:3306/travelagency","root","root");
                
                Statement stmt=con.createStatement();
                ResultSet rs=stmt.executeQuery("select * from phones");
                DefaultTableModel tbModel = (DefaultTableModel)jTable1.getModel();
                tbModel.setRowCount(0);
                while(rs.next()){

                    String ph_br_code = String.valueOf(rs.getInt("ph_br_code") );
                    String ph_number = rs.getString("ph_number");

                    String tbData[] = {ph_br_code, ph_number};
                    
                    tbModel.addRow(tbData);
                }
                
                rs=stmt.executeQuery("select br_code from branch");
                while(rs.next()){
                    
                    //String br_code = String.valueOf(rs.getInt("br_code") );
                    String br_code = rs.getString("br_code");
                    jComboBox3.addItem(br_code);
                    
                }
                
                con.close();
        }
        catch(Exception e){ System.out.println(e);} 
        
        
        
        
        
    }//GEN-LAST:event_jMenuItem11ActionPerformed

    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12ActionPerformed
        // TODO add your handling code here:
        branchesMenuPanel.setVisible(false);
        logsMenuPanel.setVisible(false);
        offersMenuPanel.setVisible(false);
        dataMenuPanel.setVisible(true);
        dataMenuPanel.removeAll();
        dataMenuPanel.add(reservationsPanel).setVisible(true);
        jComboBox14.removeAllItems();
        try  {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection( "jdbc:mysql://localhost:3306/travelagency","root","root");
            
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select * from reservation");
            DefaultTableModel tbModel = (DefaultTableModel)jTable12.getModel();
            tbModel.setRowCount(0);
            while(rs.next()){

                String res_tr_id = String.valueOf(rs.getInt("res_tr_id") );
                String res_seatnum = String.valueOf( rs.getInt("res_seatnum") );
                String res_name = rs.getString("res_name");
                String res_lname = rs.getString("res_lname");
                String res_isadult = rs.getString("res_isadult");

                String tbData[] = {res_tr_id, res_seatnum, res_name,  res_lname,res_isadult};

                tbModel.addRow(tbData);
            }
            
            rs=stmt.executeQuery("select distinct tr_id from trip");
            while(rs.next()){

                String res_tr_id = rs.getString("tr_id");
                jComboBox14.addItem(res_tr_id);
                
            }
         
            con.close();
            }
        catch(Exception e){ System.out.println(e);} 
        
    }//GEN-LAST:event_jMenuItem12ActionPerformed

    private void jMenuItem13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem13ActionPerformed
        // TODO add your handling code here:
        branchesMenuPanel.setVisible(false);
        logsMenuPanel.setVisible(false);
        offersMenuPanel.setVisible(false);
        dataMenuPanel.setVisible(true);
        dataMenuPanel.removeAll();
        dataMenuPanel.add(reservationOffersPanel).setVisible(true);
        jComboBox18.removeAllItems();
        
        try  {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection( "jdbc:mysql://localhost:3306/travelagency","root","root");
        
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select * from reservation_offers");
            DefaultTableModel tbModel = (DefaultTableModel)jTable14.getModel();
            tbModel.setRowCount(0);
            while(rs.next()){

                String res_offer_id = String.valueOf(rs.getInt("res_offer_id") );
                String res_name = rs.getString("res_name");
                String res_lname = rs.getString("res_lname");
                String offer_id_trip = String.valueOf( rs.getInt("offer_id_trip") );
                String res_deposit = String.valueOf( rs.getFloat("res_deposit") );

                String tbData[] = {res_offer_id, res_name, res_lname, offer_id_trip, res_deposit};

                tbModel.addRow(tbData);
            }
            
            rs=stmt.executeQuery("select distinct offer_id from offers");
            while(rs.next()){
                    
                String br_code = rs.getString("offer_id");
                jComboBox18.addItem(br_code);

            }
            
            con.close();
        }
        catch(Exception e){ System.out.println(e);} 
        
    }//GEN-LAST:event_jMenuItem13ActionPerformed

    private void jMenuItem14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem14ActionPerformed
        // TODO add your handling code here:
        branchesMenuPanel.setVisible(false);
        logsMenuPanel.setVisible(false);
        offersMenuPanel.setVisible(false);
        dataMenuPanel.setVisible(true);
        dataMenuPanel.removeAll();
        dataMenuPanel.add(tripsPanel).setVisible(true);
        jComboBox11.removeAllItems();
        jComboBox12.removeAllItems();
        jComboBox13.removeAllItems();
        
        try  {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection( "jdbc:mysql://localhost:3306/travelagency","root","root");

            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select * from trip");
            DefaultTableModel tbModel = (DefaultTableModel)jTable10.getModel();
            tbModel.setRowCount(0);
            while(rs.next()){

                String tr_id = String.valueOf(rs.getInt("tr_id") );
                String tr_departure = String.valueOf(rs.getDate("tr_departure") );
                String tr_return = String.valueOf( rs.getDate("tr_return") );
                //String tr_departure = rs.getString("tr_departure");
                //String tr_return = rs.getString("tr_return");      
                String tr_maxseats = String.valueOf(rs.getInt("tr_maxseats") );

                String tr_cost = String.valueOf(rs.getFloat("tr_cost") );

                String tr_br_code = String.valueOf(rs.getInt("tr_br_code") );
                String tr_gui_AT = rs.getString("tr_gui_AT");
                String tr_drv_AT = rs.getString("tr_drv_AT");

                String tbData[] = {tr_id , tr_departure, tr_return, tr_maxseats, tr_cost, tr_br_code, tr_gui_AT,tr_drv_AT};

                tbModel.addRow(tbData);
            }
            
            rs=stmt.executeQuery("select br_code from branch");
            while(rs.next()){

                String br_code = rs.getString("br_code");
                jComboBox11.addItem(br_code);                    
            }
            
            rs=stmt.executeQuery("select distinct gui_AT from guide");
            while(rs.next()){

                String gui_AT = rs.getString("gui_AT");
                jComboBox12.addItem(gui_AT);

            }
            
            rs=stmt.executeQuery("select drv_AT from driver");
            while(rs.next()){

                String drv_AT = rs.getString("drv_AT");
                jComboBox13.addItem(drv_AT);

            }
            
            con.close();
        }
        catch(Exception e){ System.out.println(e);} 
        
    }//GEN-LAST:event_jMenuItem14ActionPerformed

    private void jMenuItem15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem15ActionPerformed
        // TODO add your handling code here:
        branchesMenuPanel.setVisible(false);
        logsMenuPanel.setVisible(false);
        offersMenuPanel.setVisible(false);
        dataMenuPanel.setVisible(true);
        dataMenuPanel.removeAll();
        dataMenuPanel.add(workersPanel).setVisible(true);
        jComboBox2.removeAllItems();
        
        try  {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection( "jdbc:mysql://localhost:3306/travelagency","root","root");
            
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select * from worker");
            DefaultTableModel tbModel = (DefaultTableModel)jTable4.getModel();
            tbModel.setRowCount(0);
            while(rs.next()){

                String wrk_AT = rs.getString("wrk_AT");
                String wrk_name = rs.getString("wrk_name");
                String wrk_lame = rs.getString("wrk_lame");
                String wrk_salary = String.valueOf(rs.getFloat("wrk_salary") );
                String wrk_br_code = String.valueOf( rs.getInt("wrk_br_code") );

                String tbData[] = {wrk_AT,wrk_name, wrk_lame, wrk_salary, wrk_br_code};

                tbModel.addRow(tbData);
                
            }
            
            rs=stmt.executeQuery("select br_code from branch");
            while(rs.next()){

                //String br_code = String.valueOf(rs.getInt("br_code") );
                String br_code = rs.getString("br_code");
                jComboBox2.addItem(br_code);

            }
            
            con.close();
        }
        catch(Exception e){ System.out.println(e);} 
        
    }//GEN-LAST:event_jMenuItem15ActionPerformed

    private void jMenuItem17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem17ActionPerformed
        // TODO add your handling code here:
        dataMenuPanel.setVisible(false);
        logsMenuPanel.setVisible(false);
        offersMenuPanel.setVisible(false);
        branchesMenuPanel.setVisible(true);
        branchesMenuPanel.removeAll();
        branchesMenuPanel.add(branchInfoPanel).setVisible(true);
        jComboBox1.removeAllItems();
        try  {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection( "jdbc:mysql://localhost:3306/travelagency","root","root");
                
                /*Branch*/
                Statement stmt=con.createStatement();
                ResultSet rs=stmt.executeQuery("select br_code from branch");
                
                //Remove all items from combobox
                
                                
                while(rs.next()){
                    
                    //String br_code = String.valueOf(rs.getInt("br_code") );
                    String br_code = rs.getString("br_code");
                    jComboBox1.addItem(br_code);
                    
                }
                con.close();
        }
        catch(Exception e){ System.out.println(e);}  
        
        
    }//GEN-LAST:event_jMenuItem17ActionPerformed

    private void jMenu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu2ActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jMenu2ActionPerformed
    
    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
        // TODO add your handling code here:
        
        //Because of combobox reset the value is null and we have an exception
        //Use if statement to check when the combobox is not empty
        if(jComboBox1.getSelectedItem() != null){
            
            String selectedItem = jComboBox1.getSelectedItem().toString();
            
        String procedureData = "call branchInfoData(" + selectedItem + ")";
        String procedureTotalSalary = "call branchInfoTotalSalary(" + selectedItem + ")";
        String procedureBrDetails = "call showBranchDetails(" + selectedItem + ")";
        
        try  {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection( "jdbc:mysql://localhost:3306/travelagency","root","root");
                
                Statement stmt=con.createStatement();
                ResultSet rs=stmt.executeQuery( procedureData );
                
                DefaultTableModel tbModelData = (DefaultTableModel)jTable17.getModel();
                tbModelData.setRowCount(0);
                
                DefaultTableModel tbModelSalary = (DefaultTableModel)jTable19.getModel();
                tbModelSalary.setRowCount(0);
                
                DefaultTableModel tbBrDetails = (DefaultTableModel)jTable18.getModel();
                tbBrDetails.setRowCount(0);
                
                //Data Worker
                while(rs.next()){
                    String firstName = rs.getString("First Name");
                    String lastName = rs.getString("Last Name");
                    String salary = String.valueOf(rs.getDouble("Salary") );
                    
                    String tbData[] = {firstName, lastName, salary};
                    
                    tbModelData.addRow(tbData);
                }
                
                //Total Salary
                stmt=con.createStatement();
                rs=stmt.executeQuery( procedureTotalSalary );
                while(rs.next()){
                    String totalSalary = String.valueOf(rs.getDouble("SUM(wrk_salary)") );
                    
                    String tbTotalSalary[] = {totalSalary};
                    
                    tbModelSalary.addRow(tbTotalSalary);
                }
                
                //Branch details
                stmt=con.createStatement();
                rs=stmt.executeQuery( procedureBrDetails );
                while(rs.next()){
                    String code = String.valueOf(rs.getInt("Code") );
                    String number = String.valueOf(rs.getInt("Number") );
                    String street = rs.getString("Street");
                    String city = rs.getString("City");
                    String admin = rs.getString("admin (FN)");
                    String lastName = rs.getString("Last name (LN)");
                    String numOfRes = rs.getString("Num of reservations");
                    String income = rs.getString("Income");
                    
                    String tbTotalSalary[] = {code, number, street, city, admin, lastName, numOfRes, income};
                    
                    tbBrDetails.addRow(tbTotalSalary);
                }
                
            con.close();
        }
        catch(Exception e){ System.out.println(e);} 
        
        }
         
        
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jComboBox1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox1MouseClicked
       
    }//GEN-LAST:event_jComboBox1MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
            String startDate = startDateTextField.getText();
            String endDate = endDateTextField.getText();
            String brCode = jComboBox1.getSelectedItem().toString();
            
            String procedureShowAvailableTrips = "call showAvailableTrips(" + brCode + "," + " \" " + startDate + " \" " + ","  + " \" " + endDate +  " \" " + ")";
            
            try  {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection( "jdbc:mysql://localhost:3306/travelagency","root","root");
                
                //Statement stmt = con.createStatement();
                //ResultSet rs = stmt.executeQuery( procedureShowAvailableTrips );
                
                DefaultTableModel tbModelData = (DefaultTableModel)jTable20.getModel();
                tbModelData.setRowCount(0);
                
                CallableStatement stmt = con.prepareCall(procedureShowAvailableTrips);
                boolean results = stmt.execute();
                while (results) {
                    ResultSet rs = stmt.getResultSet();
                    // process result set
                    
                    while(rs.next()){
                        String tripCost = rs.getString("tripCost");
                        String maxSeats = rs.getString("maxSeats");
                        String reservCount = rs.getString("reservCount");
                        String emptySeats = rs.getString("emptySeats");
                        String drivLname = rs.getString("drivLname");
                        String drivName = rs.getString("drivName");
                        String GuideLname = rs.getString("GuideLname");
                        String GuideName = rs.getString("GuideName");
                        String departureDate = rs.getString("departureDate");
                        String returnDate = rs.getString("returnDate");


                        String tbData[] = {tripCost , maxSeats ,reservCount ,emptySeats ,drivLname ,drivName ,GuideLname , GuideName, departureDate, returnDate};

                        tbModelData.addRow(tbData);
                    }
                    
                    results = stmt.getMoreResults();
                }
  
                con.close();
            }
            catch(Exception e){ System.out.println(e);} 
    }//GEN-LAST:event_jButton3ActionPerformed

    private void startDateTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startDateTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_startDateTextFieldActionPerformed

    private void endDateTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_endDateTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_endDateTextFieldActionPerformed

    private void jMenu3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu3ActionPerformed
        // TODO add your handling code here:       
    }//GEN-LAST:event_jMenu3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        
        String lastName = jTextField1.getText();
        
        String procedureShowAvailableTrips = "call data_last_name(\""  + lastName  +  "\" ) ";
        
        try  {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection( "jdbc:mysql://localhost:3306/travelagency","root","root");
            
            DefaultTableModel tbModelData = (DefaultTableModel)jTable21.getModel();
            tbModelData.setRowCount(0);
            
            DefaultTableModel tbModelData2 = (DefaultTableModel)jTable22.getModel();
            tbModelData2.setRowCount(0);

            CallableStatement stmt = con.prepareCall(procedureShowAvailableTrips);
            boolean results = stmt.execute();
            
            ResultSet rs = stmt.getResultSet();
            
            while(rs.next()){
                String res_name = rs.getString("res_name");
                String res_lname = rs.getString("res_lname");
                String offer_id = rs.getString("offer_id");
                String offer_startDate = rs.getString("offer_startDate");
                String offer_endDate = rs.getString("offer_endDate");
                String cost_per_person = rs.getString("cost_per_person");
                String offer_dst_id = rs.getString("offer_dst_id");
                
                String tbData[] = {res_name , res_lname ,offer_id ,offer_startDate ,offer_endDate ,cost_per_person ,offer_dst_id };

                tbModelData.addRow(tbData);
            }

            results = stmt.getMoreResults();
            
            if(results == true){
                rs = stmt.getResultSet();
                while(rs.next()){
                    String offer_id = rs.getString("offer_id");
                    String offer_startDate = rs.getString("offer_startDate");
                    String offer_endDate = rs.getString("offer_endDate");
                    String cost_per_person = rs.getString("cost_per_person");
                    String offer_dst_id = rs.getString("offer_dst_id");
                    String count_res_lname = rs.getString("count(res_lname)");
                    
                    String tbData[] = {offer_id , offer_startDate ,offer_endDate ,cost_per_person ,offer_dst_id ,count_res_lname };

                    tbModelData2.addRow(tbData);
                }
            }
            
            con.close();
        }
        catch(Exception e){ System.out.println(e);} 
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jMenuItem16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem16ActionPerformed
        // TODO add your handling code here:
         dataMenuPanel.setVisible(false);
        branchesMenuPanel.setVisible(false);
        logsMenuPanel.setVisible(false);
        offersMenuPanel.setVisible(true);
        
        
    }//GEN-LAST:event_jMenuItem16ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        
        int selectedRow = jTable2.getSelectedRow();
        String br_code = jTable2.getValueAt(selectedRow+1, 0).toString();
        
        try  {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection( "jdbc:mysql://localhost:3306/travelagency","root","root");

            Statement stmt=con.createStatement();
            
            
            
            con.close();
        }
        catch(Exception e){ System.out.println(e);} 
        
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        
        if( !jTextField6.getText().equals("") && !jTextField7.getText().equals("") && !jTextField8.getText().equals("") && !jTextField9.getText().equals("") ){
            String wrk_at = jTextField6.getText();
            String wrk_name = jTextField7.getText();
            String wrk_lname = jTextField8.getText();
            String wrk_salary = jTextField9.getText();
            String wrk_br_code = jComboBox2.getSelectedItem().toString();
            
            String insertWorkerCommand = "INSERT INTO worker VALUES ('" + wrk_at + "','" + wrk_name + "','" + wrk_lname + "'," + wrk_salary + "," + wrk_br_code + ");" ; 
            
            try  {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection( "jdbc:mysql://localhost:3306/travelagency","root","root");

                Statement stmt=con.createStatement();
                stmt.executeUpdate(insertWorkerCommand);
                
                DefaultTableModel tbModel = (DefaultTableModel)jTable4.getModel();
                String tbData[] = { wrk_at, wrk_name, wrk_lname , wrk_salary, wrk_br_code };
                tbModel.addRow(tbData);
                con.close();
            }
            catch(Exception e){ System.out.println(e);} 
            
        }
        
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jTextField7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField7ActionPerformed

    private void jComboBox7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox7ActionPerformed

    private void jButton36ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton36ActionPerformed
        // TODO add your handling code here:
        
        if( !jTextField26.getText().equals("") && !jTextField27.getText().equals("") && !jTextField28.getText().equals("") && !jTextField29.getText().equals("") 
                && !jTextField30.getText().equals("") ){
            String tr_id = jTextField26.getText();
            String tr_departure = jTextField27.getText();
            String tr_return = jTextField28.getText();
            String tr_maxseats = jTextField29.getText();
            String tr_cost = jTextField30.getText();
            String tr_br_code = jComboBox11.getSelectedItem().toString();
            String tr_gui_AT = jComboBox12.getSelectedItem().toString();
            String tr_drv_AT = jComboBox13.getSelectedItem().toString();
            
            String insertTripCommand = "INSERT INTO trip VALUES (" + tr_id + ",'" + tr_departure +  "','" + tr_return + "'," + tr_maxseats + "," + tr_cost + "," + tr_br_code + ",'" + tr_gui_AT + "','" + tr_drv_AT + "');" ;
            
            try  {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection( "jdbc:mysql://localhost:3306/travelagency","root","root");

                Statement stmt=con.createStatement();
                stmt.executeUpdate(insertTripCommand);
                
                DefaultTableModel tbModel = (DefaultTableModel)jTable10.getModel();
                String tbData[] = { tr_id , tr_departure , tr_return , tr_maxseats , tr_cost , tr_br_code , tr_gui_AT , tr_drv_AT };
                tbModel.addRow(tbData);
                con.close();
            }
            catch(Exception e){ System.out.println(e);} 
            
        }
        
    }//GEN-LAST:event_jButton36ActionPerformed

    private void jButton39ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton39ActionPerformed
        // TODO add your handling code here:
        
        if( !jTextField16.getText().equals("") && !jTextField35.getText().equals("")  && !jTextField36.getText().equals("")  && !jTextField37.getText().equals("")  ){
            String offer_id = jTextField16.getText();
            String offer_startDate = jTextField35.getText();
            String offer_endDate = jTextField36.getText();
            String cost_per_person = jTextField37.getText();
            String offer_dst_id = jComboBox16.getSelectedItem().toString();
            
            String insertOfferCommand = "INSERT INTO offers VALUES (" + offer_id + ",'" + offer_startDate + "','" + offer_endDate + "'," + cost_per_person + "," + offer_dst_id +");";
            
            try  {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection( "jdbc:mysql://localhost:3306/travelagency","root","root");
                
                Statement stmt=con.createStatement();
                stmt.executeUpdate(insertOfferCommand);
                
                DefaultTableModel tbModel = (DefaultTableModel)jTable13.getModel();
                String tbData[] = { offer_id , offer_startDate , offer_endDate , cost_per_person , offer_dst_id};
                tbModel.addRow(tbData);
                con.close();
            }
            catch(Exception e){ System.out.println(e);} 
            
        }
        
    }//GEN-LAST:event_jButton39ActionPerformed

    private void jButton15ComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jButton15ComponentResized
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton15ComponentResized

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        // TODO add your handling code here:
        if( !jTextField20.getText().equals("") ){
            String phNumber = jTextField20.getText();
            String phBrCode = jComboBox3.getSelectedItem().toString();
            
            String insertPhonesCommand = "INSERT INTO phones VALUES (" + phBrCode + ",'"  + phNumber + "');" ;
            
            try  {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection( "jdbc:mysql://localhost:3306/travelagency","root","root");

                Statement stmt=con.createStatement();
                stmt.executeUpdate(insertPhonesCommand);
                
                DefaultTableModel tbModel = (DefaultTableModel)jTable1.getModel();
                String tbData[] = { phBrCode,phNumber};
                tbModel.addRow(tbData);
                con.close();
            }
            catch(Exception e){ System.out.println(e);} 
            
        }
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        
        if( !jTextField10.getText().equals("") && !jTextField11.getText().equals("") && !jTextField12.getText().equals("") && !jTextField14.getText().equals("") ){
            
            String dst_id = jTextField10.getText();
            String dst_name = jTextField11.getText();
            String dst_descr = jTextField12.getText();
            String dst_rtype = jComboBox20.getSelectedItem().toString();
            String dst_language = jTextField14.getText();
            String dst_location = jTextField15.getText();
            String insertDestinationCommand;
            if( !dst_location.equals("") ){
                insertDestinationCommand = "INSERT INTO destination VALUES (" + dst_id + ",'" + dst_name + "','" + dst_descr + "','" + dst_rtype + "','" + dst_language + "'," + dst_location + ");";
            }
            else{
                insertDestinationCommand = "INSERT INTO destination VALUES (" + dst_id + ",'" + dst_name + "','" + dst_descr + "','" + dst_rtype + "','" + dst_language + "', NULL );";

            }
            
                
            try  {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection( "jdbc:mysql://localhost:3306/travelagency","root","root");

                Statement stmt=con.createStatement();
                stmt.executeUpdate(insertDestinationCommand);
                
                DefaultTableModel tbModel = (DefaultTableModel)jTable3.getModel();
                String tbData[] = new String[6];
                if( !dst_location.equals("") ){
                    tbData = new String[] { dst_id, dst_name, dst_descr, dst_rtype, dst_language, dst_location };
                }
                else{
                    tbData = new String[] { dst_id, dst_name, dst_descr, dst_rtype, dst_language, "NULL" };
                }

                tbModel.addRow(tbData);
                con.close();
            }
            catch(Exception e){ System.out.println(e);} 
            
        }
        
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton24ActionPerformed
        // TODO add your handling code here:
        
        // TODO add your handling code here:
        if( !jTextField24.getText().equals("") ){
            String gui_cv = jTextField24.getText();
            String gui_AT = jComboBox7.getSelectedItem().toString();
            
            String insertGuideCommand = "INSERT INTO guide VALUES ('" + gui_AT + "','" + gui_cv + "'); ";   
            
            try  {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection( "jdbc:mysql://localhost:3306/travelagency","root","root");

                Statement stmt=con.createStatement();
                stmt.executeUpdate(insertGuideCommand);
                
                DefaultTableModel tbModel = (DefaultTableModel)jTable5.getModel();
                String tbData[] = { gui_AT , gui_cv };
                tbModel.addRow(tbData);
                con.close();
            }
            catch(Exception e){ System.out.println(e);} 
            
        }
        
    }//GEN-LAST:event_jButton24ActionPerformed
    
    private void jButton30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton30ActionPerformed
        // TODO add your handling code here:
        
        if( !jTextField25.getText().equals("") ){
            String lng_gui_cv = jTextField25.getText();
            String lng_gui_AT = jComboBox10.getSelectedItem().toString();
            
            String insertLanguageCommand = "INSERT INTO languages VALUES ('" + lng_gui_AT + "','" + lng_gui_cv + "'); ";   
            
            try  {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection( "jdbc:mysql://localhost:3306/travelagency","root","root");

                Statement stmt=con.createStatement();
                stmt.executeUpdate(insertLanguageCommand);
                
                DefaultTableModel tbModel = (DefaultTableModel)jTable6.getModel();
                String tbData[] = { lng_gui_AT , lng_gui_cv };
                tbModel.addRow(tbData);
                con.close();
            }
            catch(Exception e){ System.out.println(e);} 
            
        }
        
    }//GEN-LAST:event_jButton30ActionPerformed

    private void jButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton21ActionPerformed
        // TODO add your handling code here:
        if(  !jTextField13.getText().equals("") ){
            String drv_route = jComboBox22.getSelectedItem().toString();
            String drv_experience = jTextField13.getText();
            String drv_AT = jComboBox6.getSelectedItem().toString();
            String drv_license = jComboBox21.getSelectedItem().toString();
            
            String insertPhonesCommand = "INSERT INTO driver VALUES ('" + drv_AT + "','" + drv_license + "','" + drv_route + "'," + drv_experience + ");";
            
            try  {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection( "jdbc:mysql://localhost:3306/travelagency","root","root");

                Statement stmt=con.createStatement();
                stmt.executeUpdate(insertPhonesCommand);
                
                DefaultTableModel tbModel = (DefaultTableModel)jTable7.getModel();
                String tbData[] = { drv_AT , drv_license , drv_route , drv_experience };
                tbModel.addRow(tbData);
                con.close();
            }
            catch(Exception e){ System.out.println(e);} 
            
        }
    }//GEN-LAST:event_jButton21ActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        // TODO add your handling code here:
        
        if(  !jTextField21.getText().equals("") ){
            
            String adm_AT = jComboBox4.getSelectedItem().toString();
            String adm_type = jComboBox5.getSelectedItem().toString();
            String adm_diploma = jTextField21.getText();
            
            
            String insertAdminCommand = "INSERT INTO admin VALUES ('" + adm_AT + "','" + adm_type + "','" + adm_diploma + "');";
            
            try  {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection( "jdbc:mysql://localhost:3306/travelagency","root","root");

                Statement stmt=con.createStatement();
                stmt.executeUpdate(insertAdminCommand);
                
                DefaultTableModel tbModel = (DefaultTableModel)jTable8.getModel();
                String tbData[] = { adm_AT , adm_type , adm_diploma };
                tbModel.addRow(tbData);
                con.close();
            }
            catch(Exception e){ System.out.println(e);} 
            
        }
        
    }//GEN-LAST:event_jButton18ActionPerformed

    private void jButton29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton29ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton29ActionPerformed

    private void jButton27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton27ActionPerformed
        // TODO add your handling code here:
        
        String mng_adm_AT = jComboBox8.getSelectedItem().toString();
        String mng_br_code = jComboBox9.getSelectedItem().toString();

        String insertManagerCommand = "INSERT INTO manages VALUES ('" + mng_adm_AT + "',"  + mng_br_code + ");" ;

        try  {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection( "jdbc:mysql://localhost:3306/travelagency","root","root");

            Statement stmt=con.createStatement();
            stmt.executeUpdate(insertManagerCommand);

            DefaultTableModel tbModel = (DefaultTableModel)jTable9.getModel();
            String tbData[] = { mng_adm_AT , mng_br_code };
            tbModel.addRow(tbData);
            con.close();
        }
        catch(Exception e){ System.out.println(e);}    
        
    }//GEN-LAST:event_jButton27ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        // TODO add your handling code here:
        
        if( !jTextField17.getText().equals("") && !jTextField18.getText().equals("") && !jTextField19.getText().equals("") ){
            
            String ev_tr_id = jComboBox15.getSelectedItem().toString();
            String ev_start = jTextField17.getText();
            String ev_end = jTextField18.getText();
            String ev_descr = jTextField19.getText();
            
            
            String insertEventCommand = "INSERT INTO event VALUES (" + ev_tr_id + ",'"  + ev_start + "','" + ev_end + "','" + ev_descr + "');" ;
            
            try  {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection( "jdbc:mysql://localhost:3306/travelagency","root","root");

                Statement stmt=con.createStatement();
                stmt.executeUpdate(insertEventCommand);
                
                DefaultTableModel tbModel = (DefaultTableModel)jTable11.getModel();
                String tbData[] = { ev_tr_id , ev_start , ev_end , ev_descr};
                tbModel.addRow(tbData);
                con.close();
            }
            catch(Exception e){ System.out.println(e);} 
            
        }
        
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton35ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton35ActionPerformed
        // TODO add your handling code here:
        
        if( !jTextField31.getText().equals("") && !jTextField32.getText().equals("") && !jTextField33.getText().equals("") ){
            String res_tr_id = jComboBox14.getSelectedItem().toString();
            String res_seatnum = jTextField31.getText();
            String res_name = jTextField32.getText();
            String res_lname = jTextField33.getText();
            String res_isadult = jComboBox19.getSelectedItem().toString();
            
            String insertReservationCommand = "INSERT INTO reservation VALUES (" + res_tr_id + "," + res_seatnum + ",'" + res_name + "','" + res_lname + "','" + res_isadult + "');";
            
            try  {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection( "jdbc:mysql://localhost:3306/travelagency","root","root");

                Statement stmt=con.createStatement();
                stmt.executeUpdate(insertReservationCommand);
                
                DefaultTableModel tbModel = (DefaultTableModel)jTable12.getModel();
                String tbData[] = { res_tr_id , res_seatnum , res_name , res_lname , res_isadult};
                tbModel.addRow(tbData);
                con.close();
            }
            catch(Exception e){ System.out.println(e);} 
            
        }
        
    }//GEN-LAST:event_jButton35ActionPerformed

    private void jButton45ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton45ActionPerformed
        // TODO add your handling code here:
        
        if( !jTextField41.getText().equals("") && !jTextField42.getText().equals("") && !jTextField43.getText().equals("") && !jTextField44.getText().equals("") ){
            String res_offer_id = jTextField20.getText();
            String res_name = jTextField20.getText();
            String res_lname = jTextField20.getText();
            String offer_id_trip = jComboBox3.getSelectedItem().toString();
            String res_deposit = jTextField20.getText();
            
            String insertReservationOfferCommand = "INSERT INTO reservation_offers VALUES (" + res_offer_id + ",'" + res_name + "','" + res_lname + "'," + offer_id_trip + "," + res_deposit + ");";
            
            try  {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection( "jdbc:mysql://localhost:3306/travelagency","root","root");

                Statement stmt=con.createStatement();
                stmt.executeUpdate(insertReservationOfferCommand);
                
                DefaultTableModel tbModel = (DefaultTableModel)jTable14.getModel();
                String tbData[] = { res_offer_id + ",'" + res_name + "','" + res_lname + "'," + offer_id_trip + "," + res_deposit };
                tbModel.addRow(tbData);
                con.close();
            }
            catch(Exception e){ System.out.println(e);} 
            
        }
        
    }//GEN-LAST:event_jButton45ActionPerformed

    private void jButton42ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton42ActionPerformed
        // TODO add your handling code here:
        
        if( !jTextField38.getText().equals("") && !jTextField39.getText().equals("")  ){
            
            String it_AT = jComboBox17.getSelectedItem().toString();
            String password = jTextField38.getText();
            String start_date = jTextField39.getText();
            String end_date = "NULL";
            
            String insertItOfficerCommand = "INSERT INTO itOfficer VALUES ('" + it_AT + "','" + password + "','" + start_date + "'," + end_date + ");" ; 
            
            try  {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection( "jdbc:mysql://localhost:3306/travelagency","root","root");

                Statement stmt=con.createStatement();
                stmt.executeUpdate(insertItOfficerCommand);
                
                DefaultTableModel tbModel = (DefaultTableModel)jTable15.getModel();
                String tbData[] = {  it_AT , password , start_date , end_date};
                tbModel.addRow(tbData);
                con.close();
            }
            catch(Exception e){ System.out.println(e);} 
            
        }
        
    }//GEN-LAST:event_jButton42ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
        
        int selectedRow = jTable3.getSelectedRow();
        String dst_id = jTable3.getValueAt(selectedRow, 0).toString();
        
        String deleteDestinationCommand = "delete from destination where dst_id= " + dst_id + ";"; 
        
        try  {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection( "jdbc:mysql://localhost:3306/travelagency","root","root");

            Statement stmt=con.createStatement();
            stmt.executeUpdate(deleteDestinationCommand);

            DefaultTableModel tbModel = (DefaultTableModel)jTable3.getModel();
            
            tbModel.removeRow(selectedRow);
            con.close();
        }
        catch(Exception e){ System.out.println(e);} 
        
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton23ActionPerformed
        // TODO add your handling code here:
        
        int selectedRow = jTable7.getSelectedRow();
        String drv_AT = jTable7.getValueAt(selectedRow, 0).toString();
        
        String deleteCommand = "delete from driver where drv_AT= '" + drv_AT + "';"; 
        
        try  {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection( "jdbc:mysql://localhost:3306/travelagency","root","root");

            Statement stmt=con.createStatement();
            stmt.executeUpdate(deleteCommand);

            DefaultTableModel tbModel = (DefaultTableModel)jTable7.getModel();
            
            tbModel.removeRow(selectedRow);
            con.close();
        }
        catch(Exception e){ System.out.println(e);} 
        
    }//GEN-LAST:event_jButton23ActionPerformed

    private void jButton44ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton44ActionPerformed
        // TODO add your handling code here:
        
        int selectedRow = jTable15.getSelectedRow();
        String it_AT = jTable15.getValueAt(selectedRow, 0).toString();

        String deleteCommand = "delete from itOfficer where it_AT= '" + it_AT + "';"; 
        
        try  {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection( "jdbc:mysql://localhost:3306/travelagency","root","root");
            
            Statement stmt=con.createStatement();
            stmt.executeUpdate(deleteCommand);

            DefaultTableModel tbModel = (DefaultTableModel)jTable15.getModel();
            
            tbModel.removeRow(selectedRow);
            con.close();
        }
        catch(Exception e){ System.out.println(e);} 
        
    }//GEN-LAST:event_jButton44ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        // TODO add your handling code here:
        
        int selectedRow = jTable11.getSelectedRow();
        String ev_tr_id = jTable11.getValueAt(selectedRow, 0).toString();
        String ev_start = jTable11.getValueAt(selectedRow, 1).toString();
        
        String deleteCommand = "delete from event where ev_tr_id= " + ev_tr_id + " AND ev_start= '" + ev_start + "';"; 
        
        try  {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection( "jdbc:mysql://localhost:3306/travelagency","root","root");
            
            Statement stmt=con.createStatement();
            stmt.executeUpdate(deleteCommand);

            DefaultTableModel tbModel = (DefaultTableModel)jTable11.getModel();
            
            tbModel.removeRow(selectedRow);
            con.close();
        }
        catch(Exception e){ System.out.println(e);} 
        
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton26ActionPerformed
        // TODO add your handling code here:
        
        int selectedRow = jTable5.getSelectedRow();
        String gui_AT = jTable5.getValueAt(selectedRow, 0).toString();
        
            
        String deleteCommand = "delete from guide where gui_AT = '" + gui_AT + "';"; 
        
        try  {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection( "jdbc:mysql://localhost:3306/travelagency","root","root");
            
            Statement stmt=con.createStatement();
            stmt.executeUpdate(deleteCommand);

            DefaultTableModel tbModel = (DefaultTableModel)jTable5.getModel();
            
            tbModel.removeRow(selectedRow);
            con.close();
        }
        catch(Exception e){ System.out.println(e);} 
        
    }//GEN-LAST:event_jButton26ActionPerformed

    private void jButton32ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton32ActionPerformed
        // TODO add your handling code here:
        int selectedRow = jTable6.getSelectedRow();
        String lng_gui_AT = jTable6.getValueAt(selectedRow, 0).toString();
        String lng_language = jTable6.getValueAt(selectedRow, 1).toString();
        
        String deleteCommand = "delete from languages where lng_gui_AT= '" + lng_gui_AT + "' AND lng_language= '" + lng_language + "';"; 
        
        try  {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection( "jdbc:mysql://localhost:3306/travelagency","root","root");
            
            Statement stmt=con.createStatement();
            stmt.executeUpdate(deleteCommand);

            DefaultTableModel tbModel = (DefaultTableModel)jTable6.getModel();
            
            tbModel.removeRow(selectedRow);
            con.close();
        }
        catch(Exception e){ System.out.println(e);} 
    }//GEN-LAST:event_jButton32ActionPerformed

    private void jButton41ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton41ActionPerformed
        // TODO add your handling code here:
        
        int selectedRow = jTable1.getSelectedRow();
        String offer_id = jTable1.getValueAt(selectedRow, 0).toString();
        
        String deleteCommand = "delete from offers where offer_id= " + offer_id + ";"; 
        
        try  {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection( "jdbc:mysql://localhost:3306/travelagency","root","root");
            
            Statement stmt=con.createStatement();
            stmt.executeUpdate(deleteCommand);

            DefaultTableModel tbModel = (DefaultTableModel)jTable13.getModel();
            
            tbModel.removeRow(selectedRow);
            con.close();
        }
        catch(Exception e){ System.out.println(e);} 
        
    }//GEN-LAST:event_jButton41ActionPerformed
    
    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        // TODO add your handling code here:
        
        int selectedRow = jTable1.getSelectedRow();
        String ph_br_code = jTable1.getValueAt(selectedRow, 0).toString();
        String ph_number = jTable1.getValueAt(selectedRow, 1).toString();
        
        String deleteCommand = "delete from phones where ph_br_code= " + ph_br_code + " AND ph_number='"+ ph_number +"';"; 
        
        try  {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection( "jdbc:mysql://localhost:3306/travelagency","root","root");
            
            Statement stmt=con.createStatement();
            stmt.executeUpdate(deleteCommand);

            DefaultTableModel tbModel = (DefaultTableModel)jTable1.getModel();
            
            tbModel.removeRow(selectedRow);
            con.close();
        }
        catch(Exception e){ System.out.println(e);} 
        
        
    }//GEN-LAST:event_jButton17ActionPerformed
    
    private void jButton38ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton38ActionPerformed
        // TODO add your handling code here:
        
        int selectedRow = jTable12.getSelectedRow();
        String res_tr_id = jTable12.getValueAt(selectedRow, 0).toString();
        String res_seatnum = jTable12.getValueAt(selectedRow, 1).toString();
        
        String deleteCommand = "delete from reservation where res_tr_id= " + res_tr_id + " AND res_seatnum="+ res_seatnum +";"; 
        
        try  {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection( "jdbc:mysql://localhost:3306/travelagency","root","root");
            
            Statement stmt=con.createStatement();
            stmt.executeUpdate(deleteCommand);
            
            DefaultTableModel tbModel = (DefaultTableModel)jTable12.getModel();
            
            tbModel.removeRow(selectedRow);
            con.close();
        }
        catch(Exception e){ System.out.println(e);} 
        
    }//GEN-LAST:event_jButton38ActionPerformed

    private void jButton47ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton47ActionPerformed
        // TODO add your handling code here:
        
        int selectedRow = jTable14.getSelectedRow();
        String res_offer_id = jTable14.getValueAt(selectedRow, 0).toString();
        
        
        String deleteCommand = "delete from reservation_offers where res_offer_id= " + res_offer_id +";"; 
        
        try  {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection( "jdbc:mysql://localhost:3306/travelagency","root","root");
            
            Statement stmt=con.createStatement();
            stmt.executeUpdate(deleteCommand);
            
            DefaultTableModel tbModel = (DefaultTableModel)jTable14.getModel();
            
            tbModel.removeRow(selectedRow);
            con.close();
        }
        catch(Exception e){ System.out.println(e);} 
        
    }//GEN-LAST:event_jButton47ActionPerformed

    private void jButton34ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton34ActionPerformed
        // TODO add your handling code here:
        int selectedRow = jTable10.getSelectedRow();
        String tr_id = jTable10.getValueAt(selectedRow, 0).toString();
        
        
        String deleteCommand = "delete from trip where tr_id= " + tr_id +";"; 
        
        try  {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection( "jdbc:mysql://localhost:3306/travelagency","root","root");
            
            Statement stmt=con.createStatement();
            stmt.executeUpdate(deleteCommand);
            
            DefaultTableModel tbModel = (DefaultTableModel)jTable10.getModel();
            
            tbModel.removeRow(selectedRow);
            con.close();
        }
        catch(Exception e){ System.out.println(e);} 
    }//GEN-LAST:event_jButton34ActionPerformed

    private void jMenuItem18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem18ActionPerformed
        // TODO add your handling code here:
        
        branchesMenuPanel.setVisible(false);
        offersMenuPanel.setVisible(false);
        dataMenuPanel.setVisible(false);
        logsMenuPanel.setVisible(true);
        
        
        try  {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection( "jdbc:mysql://localhost:3306/travelagency","root","root");
            
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select * from log");
            DefaultTableModel tbModel = (DefaultTableModel)jTable16.getModel();
            tbModel.setRowCount(0);
            while(rs.next()){

                String logid = rs.getString("logid");
                String logdescrc = rs.getString("logdescrc");
                String log_ID_AT = rs.getString("log_ID_AT");
                String log_date = rs.getString("log_date");

                String tbData[] = {logid , logdescrc , log_ID_AT , log_date };
                
                tbModel.addRow(tbData);
            }
            
            con.close();
        }
        catch(Exception e){ System.out.println(e);} 
        
    }//GEN-LAST:event_jMenuItem18ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel adminsPanel;
    private javax.swing.JPanel branchInfoPanel;
    private javax.swing.JPanel branchesMenuPanel;
    private javax.swing.JPanel branchesPanel;
    private javax.swing.JPanel dataMenuPanel;
    private javax.swing.JPanel destinationsPanel;
    private javax.swing.JPanel driversPanel;
    private javax.swing.JTextField endDateTextField;
    private javax.swing.JPanel eventsPanel;
    private javax.swing.JPanel guidesPanel;
    private javax.swing.JPanel itOfficersPanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton24;
    private javax.swing.JButton jButton25;
    private javax.swing.JButton jButton26;
    private javax.swing.JButton jButton27;
    private javax.swing.JButton jButton29;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton30;
    private javax.swing.JButton jButton31;
    private javax.swing.JButton jButton32;
    private javax.swing.JButton jButton33;
    private javax.swing.JButton jButton34;
    private javax.swing.JButton jButton35;
    private javax.swing.JButton jButton36;
    private javax.swing.JButton jButton37;
    private javax.swing.JButton jButton38;
    private javax.swing.JButton jButton39;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton40;
    private javax.swing.JButton jButton41;
    private javax.swing.JButton jButton42;
    private javax.swing.JButton jButton43;
    private javax.swing.JButton jButton44;
    private javax.swing.JButton jButton45;
    private javax.swing.JButton jButton46;
    private javax.swing.JButton jButton47;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox10;
    private javax.swing.JComboBox<String> jComboBox11;
    private javax.swing.JComboBox<String> jComboBox12;
    private javax.swing.JComboBox<String> jComboBox13;
    private javax.swing.JComboBox<String> jComboBox14;
    private javax.swing.JComboBox<String> jComboBox15;
    private javax.swing.JComboBox<String> jComboBox16;
    private javax.swing.JComboBox<String> jComboBox17;
    private javax.swing.JComboBox<String> jComboBox18;
    private javax.swing.JComboBox<String> jComboBox19;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox20;
    private javax.swing.JComboBox<String> jComboBox21;
    private javax.swing.JComboBox<String> jComboBox22;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JComboBox<String> jComboBox5;
    private javax.swing.JComboBox<String> jComboBox6;
    private javax.swing.JComboBox<String> jComboBox7;
    private javax.swing.JComboBox<String> jComboBox8;
    private javax.swing.JComboBox<String> jComboBox9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem15;
    private javax.swing.JMenuItem jMenuItem16;
    private javax.swing.JMenuItem jMenuItem17;
    private javax.swing.JMenuItem jMenuItem18;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane17;
    private javax.swing.JScrollPane jScrollPane18;
    private javax.swing.JScrollPane jScrollPane19;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane20;
    private javax.swing.JScrollPane jScrollPane21;
    private javax.swing.JScrollPane jScrollPane22;
    private javax.swing.JScrollPane jScrollPane23;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable10;
    private javax.swing.JTable jTable11;
    private javax.swing.JTable jTable12;
    private javax.swing.JTable jTable13;
    private javax.swing.JTable jTable14;
    private javax.swing.JTable jTable15;
    private javax.swing.JTable jTable16;
    private javax.swing.JTable jTable17;
    private javax.swing.JTable jTable18;
    private javax.swing.JTable jTable19;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable20;
    private javax.swing.JTable jTable21;
    private javax.swing.JTable jTable22;
    private javax.swing.JTable jTable23;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JTable jTable5;
    private javax.swing.JTable jTable6;
    private javax.swing.JTable jTable7;
    private javax.swing.JTable jTable8;
    private javax.swing.JTable jTable9;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField15;
    private javax.swing.JTextField jTextField16;
    private javax.swing.JTextField jTextField17;
    private javax.swing.JTextField jTextField18;
    private javax.swing.JTextField jTextField19;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField20;
    private javax.swing.JTextField jTextField21;
    private javax.swing.JTextField jTextField24;
    private javax.swing.JTextField jTextField25;
    private javax.swing.JTextField jTextField26;
    private javax.swing.JTextField jTextField27;
    private javax.swing.JTextField jTextField28;
    private javax.swing.JTextField jTextField29;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField30;
    private javax.swing.JTextField jTextField31;
    private javax.swing.JTextField jTextField32;
    private javax.swing.JTextField jTextField33;
    private javax.swing.JTextField jTextField35;
    private javax.swing.JTextField jTextField36;
    private javax.swing.JTextField jTextField37;
    private javax.swing.JTextField jTextField38;
    private javax.swing.JTextField jTextField39;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField40;
    private javax.swing.JTextField jTextField41;
    private javax.swing.JTextField jTextField42;
    private javax.swing.JTextField jTextField43;
    private javax.swing.JTextField jTextField44;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JPanel languagesPanel;
    private javax.swing.JPanel logsMenuPanel;
    private javax.swing.JPanel managersPanel;
    private javax.swing.JPanel offersMenuPanel;
    private javax.swing.JPanel offersPanel;
    private javax.swing.JPanel phonesPanel;
    private javax.swing.JPanel reservationOffersPanel;
    private javax.swing.JPanel reservationsPanel;
    private javax.swing.JTextField startDateTextField;
    private javax.swing.JPanel travelToPanel;
    private javax.swing.JPanel tripsPanel;
    private javax.swing.JPanel workersPanel;
    // End of variables declaration//GEN-END:variables
}
