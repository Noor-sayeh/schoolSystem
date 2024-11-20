package com.example.school_system;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import oracle.sql.DATE;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class Student implements Initializable {
    @FXML
    private Button refresh;
    @FXML
    private TableColumn<ST, String> NAME;

    @FXML
    private TableColumn<ST, String> pname;

    @FXML
    private TableColumn<ST, Integer> pnumber;

    @FXML
    private TableColumn<ST, Integer> rid;


    @FXML
    private TableColumn<ST, String> addres;
    @FXML
    private TableColumn<ST, DATE> bth;
    @FXML
    private TableColumn<ST,String> gend;

    @FXML
    private TableColumn<ST, String> gmail;
    @FXML
    private TableColumn<ST, String> mss;
    @FXML
    private TableColumn<ST, Integer> idd;
    @FXML
    private Button add;

    @FXML
    private TextField address;

    @FXML
    private ImageView backg;

    @FXML
    private AnchorPane backgr;

    @FXML
    private TextField birthdate;

    @FXML
    private Button delete;

    @FXML
    private TextField email;

    @FXML
    private Button exit;

    @FXML
    private TextField gender;

    @FXML
    private TextField id;

    @FXML
    private ImageView image;

    @FXML
    private TextField massn;

    @FXML
    private TextField name;

    @FXML
    private TextField parentname;

    @FXML
    private TextField parentnumber;

    @FXML
    private TextField roomid;

    @FXML
    private TableView<ST> table;
    @FXML
    private Button search;

    @FXML
    private Label stlabel;

    @FXML
    private Button update;

    @FXML
    void ID(ActionEvent event) {

    }
    @FXML
    void refresh(ActionEvent event) {
        NAME.setCellValueFactory(new PropertyValueFactory<ST,String>("NAME"));
        idd.setCellValueFactory(new PropertyValueFactory<ST,Integer>("id"));
        bth.setCellValueFactory(new PropertyValueFactory<ST,DATE>("bth"));
        gend.setCellValueFactory(new PropertyValueFactory<ST,String>("gender"));
        pname.setCellValueFactory(new PropertyValueFactory<ST,String>("pname"));
        pnumber.setCellValueFactory(new PropertyValueFactory<ST,Integer>("pnumber"));
        rid.setCellValueFactory(new PropertyValueFactory<ST,Integer>("rid"));
        mss.setCellValueFactory(new PropertyValueFactory<ST,String>("mss"));
        gmail.setCellValueFactory(new PropertyValueFactory<ST,String>("gmail"));
        addres.setCellValueFactory(new PropertyValueFactory<ST,String>("address"));
        try{
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            String Url = "jdbc:oracle:thin:@localhost:1522:orcl";
            Connection con = DriverManager.getConnection(Url, "HR", "123456");
            con.setAutoCommit(false);
            Statement statement = con.createStatement();
            String sqls="Select STUDENTS.NAME_ST,STUDENTS.IDS,STUDENTS.BIRTHDATE,STUDENTS.GENDER,STUDENTS.PARENT_NAME,STUDENTS.PARANT_NUMBER,STUDENTS.ID_ROOM,STUDENTS.M_SSN,STUDENTS.EMAIL,STUDENTS.ADDRESS FROM STUDENTS";
            ResultSet rs=statement.executeQuery(sqls);
            int i=0;
            list.clear();
            while(rs.next()){
                ST OBJ=new ST(rs.getString(1),rs.getInt(2),rs.getDate(3),rs.getString(4),rs.getString(5),rs.getInt(6),rs.getInt(7),rs.getString(8),rs.getString(9),rs.getString(10));
                list.add(i,OBJ);
                i++;
            }
            table.setItems(list);
            con.commit();
            con.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @FXML
    void add(ActionEvent event) {
        try {
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            String url = "jdbc:oracle:thin:@localhost:1522:orcl";
            Connection con = DriverManager.getConnection(url, "HR", "123456");
            con.setAutoCommit(false);
            Statement statement = con.createStatement();
            statement.executeQuery("insert into students(NAME_ST,IDS,BIRTHDATE,GENDER,PARENT_NAME,PARANT_NUMBER,EMAIL,ADDRESS,M_SSN,ID_ROOM) VALUES('" + name.getText() + "','" +id.getText() + "','" +birthdate.getText()+"','" +gender.getText() +"','" +parentname.getText() +"','" +parentnumber.getText()+"','" +email.getText()+"','" +address.getText()+"','" +massn.getText() +"','" +roomid.getText() +    "')");
            con.commit();
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Message Here...");
            alert.setHeaderText("Student added successfully");
            alert.showAndWait();
        }catch (SQLException e) {
           System.out.println(e);
           e.printStackTrace();
    }}

    @FXML
    void address(ActionEvent event) {

    }

    @FXML
    void birth(ActionEvent event) {

    }

    @FXML
    void delete(ActionEvent event) {
        try {
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            String url = "jdbc:oracle:thin:@localhost:1522:orcl";
            Connection con = DriverManager.getConnection(url, "HR", "123456");
            con.setAutoCommit(false);
            Statement statement = con.createStatement();
            String sql="DELETE FROM STUDENTS WHERE NAME_ST='"+name.getText()+"' AND IDS='" +id.getText()+"' AND BIRTHDATE='"+birthdate.getText()+"'AND GENDER='" +gender.getText()+"' AND PARENT_NAME='"+parentname.getText()+"'AND PARANT_NUMBER='"+parentnumber.getText()+"'AND EMAIL='" +email.getText()+"' AND ADDRESS='"+address.getText()+"'AND M_SSN='"+massn.getText()+"'AND ID_ROOM='"+roomid.getText()+"'";
            statement.executeQuery(sql);
            con.commit();
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Message Here...");
            alert.setHeaderText("Student data deleted");
            alert.showAndWait();
        }catch (SQLException e) {
            System.out.println(e);
            e.printStackTrace();
        }

    }

    @FXML
    void email(ActionEvent event) {

    }

    @FXML
    void exit(ActionEvent event) {

        ((Node)(event.getSource())).getScene().getWindow().hide();
            }


    public ObservableList<ST> list= FXCollections.observableArrayList();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        NAME.setCellValueFactory(new PropertyValueFactory<ST,String>("NAME"));
        idd.setCellValueFactory(new PropertyValueFactory<ST,Integer>("id"));
        bth.setCellValueFactory(new PropertyValueFactory<ST,DATE>("bth"));
        gend.setCellValueFactory(new PropertyValueFactory<ST,String>("gender"));
        pname.setCellValueFactory(new PropertyValueFactory<ST,String>("pname"));
        pnumber.setCellValueFactory(new PropertyValueFactory<ST,Integer>("pnumber"));
        rid.setCellValueFactory(new PropertyValueFactory<ST,Integer>("rid"));
        mss.setCellValueFactory(new PropertyValueFactory<ST,String>("mss"));
        gmail.setCellValueFactory(new PropertyValueFactory<ST,String>("gmail"));
        addres.setCellValueFactory(new PropertyValueFactory<ST,String>("address"));
        try{
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            String Url = "jdbc:oracle:thin:@localhost:1522:orcl";
            Connection con = DriverManager.getConnection(Url, "HR", "123456");
            con.setAutoCommit(false);
            Statement statement = con.createStatement();
            String sqls="Select STUDENTS.NAME_ST,STUDENTS.IDS,STUDENTS.BIRTHDATE,STUDENTS.GENDER,STUDENTS.PARENT_NAME,STUDENTS.PARANT_NUMBER,STUDENTS.ID_ROOM,STUDENTS.M_SSN,STUDENTS.EMAIL,STUDENTS.ADDRESS FROM STUDENTS";
            ResultSet rs=statement.executeQuery(sqls);
            int i=0;
            list.clear();
            while(rs.next()){
                ST OBJ=new ST(rs.getString(1),rs.getInt(2),rs.getDate(3),rs.getString(4),rs.getString(5),rs.getInt(6),rs.getInt(7),rs.getString(8),rs.getString(9),rs.getString(10));
                list.add(i,OBJ);
                i++;
            }
            table.setItems(list);
            con.commit();
            con.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @FXML
    void gender(ActionEvent event) {

    }

    @FXML
    void mssn(ActionEvent event) {

    }

    @FXML
    void name(ActionEvent event) {

    }

    @FXML
    void pname(ActionEvent event) {

    }

    @FXML
    void pnaumber(ActionEvent event) {

    }

    @FXML
    void roomid(ActionEvent event) {

    }

    @FXML
    void search(ActionEvent event) {

        NAME.setCellValueFactory(new PropertyValueFactory<ST,String>("NAME"));
        idd.setCellValueFactory(new PropertyValueFactory<ST,Integer>("id"));
        bth.setCellValueFactory(new PropertyValueFactory<ST,DATE>("bth"));
        gend.setCellValueFactory(new PropertyValueFactory<ST,String>("gender"));
        pname.setCellValueFactory(new PropertyValueFactory<ST,String>("pname"));
        pnumber.setCellValueFactory(new PropertyValueFactory<ST,Integer>("pnumber"));
        rid.setCellValueFactory(new PropertyValueFactory<ST,Integer>("rid"));
        mss.setCellValueFactory(new PropertyValueFactory<ST,String>("mss"));
        gmail.setCellValueFactory(new PropertyValueFactory<ST,String>("gmail"));
        addres.setCellValueFactory(new PropertyValueFactory<ST,String>("address"));
        try{
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            String Url = "jdbc:oracle:thin:@localhost:1522:orcl";
            Connection con = DriverManager.getConnection(Url, "HR", "123456");
            con.setAutoCommit(false);
            Statement statement = con.createStatement();
            String sqls="Select STUDENTS.NAME_ST,STUDENTS.IDS,STUDENTS.BIRTHDATE,STUDENTS.GENDER,STUDENTS.PARENT_NAME,STUDENTS.PARANT_NUMBER,STUDENTS.ID_ROOM,STUDENTS.M_SSN,STUDENTS.EMAIL,STUDENTS.ADDRESS FROM STUDENTS";
            ResultSet rs=statement.executeQuery(sqls);
            int i=0;
            list.clear();
            while(rs.next()){
                String s=id.getText();
                String db=Integer.toString(rs.getInt(2));
                if(s.equals(db)){
                ST OBJ=new ST(rs.getString(1),rs.getInt(2),rs.getDate(3),rs.getString(4),rs.getString(5),rs.getInt(6),rs.getInt(7),rs.getString(8),rs.getString(9),rs.getString(10));
                list.add(i,OBJ);
                i++;
            }}
            table.setItems(list);
            con.commit();
            con.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



    @FXML
    void update(ActionEvent event) {

        try {
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            String url = "jdbc:oracle:thin:@localhost:1522:orcl";
            Connection con = DriverManager.getConnection(url, "HR", "123456");
            con.setAutoCommit(false);
            Statement statement = con.createStatement();
            String sql="update STUDENTS set NAME_ST='" +name.getText()+"',BIRTHDATE='"+birthdate.getText()+"',GENDER='"+gender.getText()+"',PARENT_NAME='"+parentname.getText()+"',PARANT_NUMBER='"+parentnumber.getText()+"',EMAIL='"+email.getText()+"',ADDRESS='"+address.getText()+"',M_SSN='"+massn.getText()+"',ID_ROOM='"+roomid.getText()+"'where IDS='" +id.getText()+ "'";
            statement.executeQuery(sql);
            con.commit();
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Message Here...");
            alert.setHeaderText("Student data updated successfully");
            alert.showAndWait();
        }catch (SQLException e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }

}
