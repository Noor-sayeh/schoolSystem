package com.example.school_system;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class Grade implements Initializable {
    @FXML
    private TableView<G> table;
    @FXML
    private Button REFRESH;
    @FXML
    private Button add;
    @FXML
    private TableColumn<G, String> Cname;

    @FXML
    private TableColumn<G, Integer> Grd;

    @FXML
    private TableColumn<G, Integer> Sid;
    @FXML
    private AnchorPane backgr;

    @FXML
    private TextField coursename;

    @FXML
    private Button delete;

    @FXML
    private Button exit;

    @FXML
    private TextField grad;

    @FXML
    private Label grade;

    @FXML
    private Button search;


    @FXML
    private TextField stid;

    @FXML
    private Button update;
    @FXML
    void refresh(ActionEvent event) {
        Sid.setCellValueFactory(new PropertyValueFactory<G,Integer>("Sid"));
        Cname.setCellValueFactory(new PropertyValueFactory<G,String>("Cname"));
        Grd.setCellValueFactory(new PropertyValueFactory<G,Integer>("Grd"));
        try{
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            String Url = "jdbc:oracle:thin:@localhost:1522:orcl";
            Connection con = DriverManager.getConnection(Url, "HR", "123456");
            con.setAutoCommit(false);
            Statement statement = con.createStatement();
            String sqls="Select GRADE.ST_ID,GRADE.GRADE,GRADE.COURSE_NAME FROM GRADE";
            ResultSet rs=statement.executeQuery(sqls);
            int i=0;
            list.clear();
            while(rs.next()){
                G OBJ=new G(rs.getInt(1),rs.getInt(2),rs.getString(3));
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
            String query = "insert into GRADE(ST_ID,GRADE,COURSE_NAME) VALUES('" + stid.getText() + "','" +grad.getText() + "','" +coursename.getText()+ "')";
            statement.executeQuery(query);
            con.commit();
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Message Here...");
            alert.setHeaderText("Grade added");
            alert.showAndWait();
        }catch (SQLException e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }

    @FXML
    void delete(ActionEvent event) {
        try {
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            String url = "jdbc:oracle:thin:@localhost:1522:orcl";
            Connection con = DriverManager.getConnection(url, "HR", "123456");
            con.setAutoCommit(false);
            Statement statement = con.createStatement();
          String sql="DELETE FROM GRADE WHERE ST_ID='"+stid.getText()+"' AND GRADE='" +grad.getText()+"' AND COURSE_NAME='"+coursename.getText()+"'";
            statement.executeQuery(sql);
            con.commit();
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Message Here...");
            alert.setHeaderText("Grade deleted");
            alert.showAndWait();
        }catch (SQLException e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }

    @FXML
    void exit(ActionEvent event) {
        ((Node)(event.getSource())).getScene().getWindow().hide();
    }

    @FXML
    void search(ActionEvent event) {
        Sid.setCellValueFactory(new PropertyValueFactory<G,Integer>("Sid"));
        Cname.setCellValueFactory(new PropertyValueFactory<G,String>("Cname"));
        Grd.setCellValueFactory(new PropertyValueFactory<G,Integer>("Grd"));
        try{
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            String Url = "jdbc:oracle:thin:@localhost:1522:orcl";
            Connection con = DriverManager.getConnection(Url, "HR", "123456");
            con.setAutoCommit(false);
            Statement statement = con.createStatement();
            String sqls="Select GRADE.ST_ID,GRADE.GRADE,GRADE.COURSE_NAME FROM GRADE";
            ResultSet rs=statement.executeQuery(sqls);
            int i=0;
            list.clear();
            while(rs.next()){
                String s=stid.getText();
                String db=Integer.toString(rs.getInt(1));
                if(s.equals(db)){
                G OBJ=new G(rs.getInt(1),rs.getInt(2),rs.getString(3));
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
            String sql="update GRADE set GRADE='" +grad.getText()+"' where ST_ID='" +stid.getText()+"' AND COURSE_NAME='" +coursename.getText() + "'";
            statement.executeQuery(sql);
            con.commit();
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Message Here...");
            alert.setHeaderText("Grade updated");
            alert.showAndWait();
        }catch (SQLException e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }


    public ObservableList<G> list= FXCollections.observableArrayList();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
Sid.setCellValueFactory(new PropertyValueFactory<G,Integer>("Sid"));
        Cname.setCellValueFactory(new PropertyValueFactory<G,String>("Cname"));
        Grd.setCellValueFactory(new PropertyValueFactory<G,Integer>("Grd"));
        try{
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            String Url = "jdbc:oracle:thin:@localhost:1522:orcl";
            Connection con = DriverManager.getConnection(Url, "HR", "123456");
            con.setAutoCommit(false);
            Statement statement = con.createStatement();
            String sqls="Select GRADE.ST_ID,GRADE.GRADE,GRADE.COURSE_NAME FROM GRADE";
            ResultSet rs=statement.executeQuery(sqls);
            int i=0;
            list.clear();
            while(rs.next()){
                G OBJ=new G(rs.getInt(1),rs.getInt(2),rs.getString(3));
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
}
