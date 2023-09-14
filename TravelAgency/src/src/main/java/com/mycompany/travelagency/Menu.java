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

        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        dataMenuPanel = new javax.swing.JPanel();
        branchesPanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        adminsPanel = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTable8 = new javax.swing.JTable();
        destinationsPanel = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        driversPanel = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTable7 = new javax.swing.JTable();
        itOfficersPanel = new javax.swing.JPanel();
        jScrollPane15 = new javax.swing.JScrollPane();
        jTable15 = new javax.swing.JTable();
        eventsPanel = new javax.swing.JPanel();
        jScrollPane11 = new javax.swing.JScrollPane();
        jTable11 = new javax.swing.JTable();
        guidesPanel = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable5 = new javax.swing.JTable();
        languagesPanel = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTable6 = new javax.swing.JTable();
        managersPanel = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        jTable9 = new javax.swing.JTable();
        offersPanel = new javax.swing.JPanel();
        jScrollPane13 = new javax.swing.JScrollPane();
        jTable13 = new javax.swing.JTable();
        phonesPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        reservationsPanel = new javax.swing.JPanel();
        jScrollPane12 = new javax.swing.JScrollPane();
        jTable12 = new javax.swing.JTable();
        reservationOffersPanel = new javax.swing.JPanel();
        jScrollPane14 = new javax.swing.JScrollPane();
        jTable14 = new javax.swing.JTable();
        tripsPanel = new javax.swing.JPanel();
        jScrollPane10 = new javax.swing.JScrollPane();
        jTable10 = new javax.swing.JTable();
        workersPanel = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        branchesMenuPanel = new javax.swing.JPanel();
        procedure1Panel = new javax.swing.JPanel();
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

        javax.swing.GroupLayout branchesPanelLayout = new javax.swing.GroupLayout(branchesPanel);
        branchesPanel.setLayout(branchesPanelLayout);
        branchesPanelLayout.setHorizontalGroup(
            branchesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(branchesPanelLayout.createSequentialGroup()
                .addGroup(branchesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(branchesPanelLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1029, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(branchesPanelLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(branchesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton2)
                            .addComponent(jButton1))))
                .addContainerGap(106, Short.MAX_VALUE))
        );
        branchesPanelLayout.setVerticalGroup(
            branchesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(branchesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(jButton1)
                .addGap(41, 41, 41)
                .addComponent(jButton2)
                .addContainerGap(398, Short.MAX_VALUE))
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

        javax.swing.GroupLayout adminsPanelLayout = new javax.swing.GroupLayout(adminsPanel);
        adminsPanel.setLayout(adminsPanelLayout);
        adminsPanelLayout.setHorizontalGroup(
            adminsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(adminsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 1137, Short.MAX_VALUE)
                .addContainerGap())
        );
        adminsPanelLayout.setVerticalGroup(
            adminsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(adminsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(546, Short.MAX_VALUE))
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

        javax.swing.GroupLayout destinationsPanelLayout = new javax.swing.GroupLayout(destinationsPanel);
        destinationsPanel.setLayout(destinationsPanelLayout);
        destinationsPanelLayout.setHorizontalGroup(
            destinationsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(destinationsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1137, Short.MAX_VALUE)
                .addContainerGap())
        );
        destinationsPanelLayout.setVerticalGroup(
            destinationsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(destinationsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(546, Short.MAX_VALUE))
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

        javax.swing.GroupLayout driversPanelLayout = new javax.swing.GroupLayout(driversPanel);
        driversPanel.setLayout(driversPanelLayout);
        driversPanelLayout.setHorizontalGroup(
            driversPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(driversPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 1137, Short.MAX_VALUE)
                .addContainerGap())
        );
        driversPanelLayout.setVerticalGroup(
            driversPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(driversPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(546, Short.MAX_VALUE))
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

        javax.swing.GroupLayout itOfficersPanelLayout = new javax.swing.GroupLayout(itOfficersPanel);
        itOfficersPanel.setLayout(itOfficersPanelLayout);
        itOfficersPanelLayout.setHorizontalGroup(
            itOfficersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(itOfficersPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane15, javax.swing.GroupLayout.DEFAULT_SIZE, 1137, Short.MAX_VALUE)
                .addContainerGap())
        );
        itOfficersPanelLayout.setVerticalGroup(
            itOfficersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(itOfficersPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(546, Short.MAX_VALUE))
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
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane11.setViewportView(jTable11);

        javax.swing.GroupLayout eventsPanelLayout = new javax.swing.GroupLayout(eventsPanel);
        eventsPanel.setLayout(eventsPanelLayout);
        eventsPanelLayout.setHorizontalGroup(
            eventsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(eventsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane11, javax.swing.GroupLayout.DEFAULT_SIZE, 1137, Short.MAX_VALUE)
                .addContainerGap())
        );
        eventsPanelLayout.setVerticalGroup(
            eventsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(eventsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(546, Short.MAX_VALUE))
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

        javax.swing.GroupLayout guidesPanelLayout = new javax.swing.GroupLayout(guidesPanel);
        guidesPanel.setLayout(guidesPanelLayout);
        guidesPanelLayout.setHorizontalGroup(
            guidesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(guidesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 1137, Short.MAX_VALUE)
                .addContainerGap())
        );
        guidesPanelLayout.setVerticalGroup(
            guidesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(guidesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(546, Short.MAX_VALUE))
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

        javax.swing.GroupLayout languagesPanelLayout = new javax.swing.GroupLayout(languagesPanel);
        languagesPanel.setLayout(languagesPanelLayout);
        languagesPanelLayout.setHorizontalGroup(
            languagesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(languagesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 1137, Short.MAX_VALUE)
                .addContainerGap())
        );
        languagesPanelLayout.setVerticalGroup(
            languagesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(languagesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(546, Short.MAX_VALUE))
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

        javax.swing.GroupLayout managersPanelLayout = new javax.swing.GroupLayout(managersPanel);
        managersPanel.setLayout(managersPanelLayout);
        managersPanelLayout.setHorizontalGroup(
            managersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(managersPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 1137, Short.MAX_VALUE)
                .addContainerGap())
        );
        managersPanelLayout.setVerticalGroup(
            managersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(managersPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(546, Short.MAX_VALUE))
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

        javax.swing.GroupLayout offersPanelLayout = new javax.swing.GroupLayout(offersPanel);
        offersPanel.setLayout(offersPanelLayout);
        offersPanelLayout.setHorizontalGroup(
            offersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(offersPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane13, javax.swing.GroupLayout.DEFAULT_SIZE, 1137, Short.MAX_VALUE)
                .addContainerGap())
        );
        offersPanelLayout.setVerticalGroup(
            offersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(offersPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(625, Short.MAX_VALUE))
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

        javax.swing.GroupLayout phonesPanelLayout = new javax.swing.GroupLayout(phonesPanel);
        phonesPanel.setLayout(phonesPanelLayout);
        phonesPanelLayout.setHorizontalGroup(
            phonesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phonesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1137, Short.MAX_VALUE)
                .addContainerGap())
        );
        phonesPanelLayout.setVerticalGroup(
            phonesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phonesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(565, Short.MAX_VALUE))
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

        javax.swing.GroupLayout reservationsPanelLayout = new javax.swing.GroupLayout(reservationsPanel);
        reservationsPanel.setLayout(reservationsPanelLayout);
        reservationsPanelLayout.setHorizontalGroup(
            reservationsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(reservationsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane12, javax.swing.GroupLayout.DEFAULT_SIZE, 1137, Short.MAX_VALUE)
                .addContainerGap())
        );
        reservationsPanelLayout.setVerticalGroup(
            reservationsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(reservationsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(546, Short.MAX_VALUE))
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

        javax.swing.GroupLayout reservationOffersPanelLayout = new javax.swing.GroupLayout(reservationOffersPanel);
        reservationOffersPanel.setLayout(reservationOffersPanelLayout);
        reservationOffersPanelLayout.setHorizontalGroup(
            reservationOffersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(reservationOffersPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane14, javax.swing.GroupLayout.DEFAULT_SIZE, 1137, Short.MAX_VALUE)
                .addContainerGap())
        );
        reservationOffersPanelLayout.setVerticalGroup(
            reservationOffersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(reservationOffersPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(546, Short.MAX_VALUE))
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

        javax.swing.GroupLayout tripsPanelLayout = new javax.swing.GroupLayout(tripsPanel);
        tripsPanel.setLayout(tripsPanelLayout);
        tripsPanelLayout.setHorizontalGroup(
            tripsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tripsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane10, javax.swing.GroupLayout.DEFAULT_SIZE, 1137, Short.MAX_VALUE)
                .addContainerGap())
        );
        tripsPanelLayout.setVerticalGroup(
            tripsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tripsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(546, Short.MAX_VALUE))
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

        javax.swing.GroupLayout workersPanelLayout = new javax.swing.GroupLayout(workersPanel);
        workersPanel.setLayout(workersPanelLayout);
        workersPanelLayout.setHorizontalGroup(
            workersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(workersPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 1137, Short.MAX_VALUE)
                .addContainerGap())
        );
        workersPanelLayout.setVerticalGroup(
            workersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(workersPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 446, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(527, Short.MAX_VALUE))
        );

        dataMenuPanel.add(workersPanel, "card16");

        getContentPane().add(dataMenuPanel, "card2");

        branchesMenuPanel.setLayout(new java.awt.CardLayout());

        javax.swing.GroupLayout procedure1PanelLayout = new javax.swing.GroupLayout(procedure1Panel);
        procedure1Panel.setLayout(procedure1PanelLayout);
        procedure1PanelLayout.setHorizontalGroup(
            procedure1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1149, Short.MAX_VALUE)
        );
        procedure1PanelLayout.setVerticalGroup(
            procedure1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 979, Short.MAX_VALUE)
        );

        branchesMenuPanel.add(procedure1Panel, "card2");

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
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
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
                .addComponent(jScrollPane16, javax.swing.GroupLayout.PREFERRED_SIZE, 760, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(213, Short.MAX_VALUE))
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
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
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
        dataMenuPanel.add(branchesPanel).setVisible(true);
        
        try  {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection( "jdbc:mysql://localhost:3306/travelagency","root","root");
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
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBox1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
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
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JTable jTable5;
    private javax.swing.JTable jTable6;
    private javax.swing.JTable jTable7;
    private javax.swing.JTable jTable8;
    private javax.swing.JTable jTable9;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JPanel languagesPanel;
    private javax.swing.JPanel logsMenuPanel;
    private javax.swing.JPanel managersPanel;
    private javax.swing.JPanel offersMenuPanel;
    private javax.swing.JPanel offersPanel;
    private javax.swing.JPanel phonesPanel;
    private javax.swing.JPanel procedure1Panel;
    private javax.swing.JPanel reservationOffersPanel;
    private javax.swing.JPanel reservationsPanel;
    private javax.swing.JTextField startDateTextField;
    private javax.swing.JPanel tripsPanel;
    private javax.swing.JPanel workersPanel;
    // End of variables declaration//GEN-END:variables
}
