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

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class Course1 implements Initializable {

    @FXML
    private Button add;

    @FXML
    private TableView<C> table;

    @FXML
    private TableColumn<C, String> tnume;
    @FXML
    private TableColumn<C, Integer> not;

    @FXML
    private TableColumn<C, Integer> nu;
    @FXML
    private TableColumn<C, String> n;
    @FXML
    private ImageView backg;

    @FXML
    private Label course;

    @FXML
    private Button delete;

    @FXML
    private Button exit;

    @FXML
    private ImageView image;

    @FXML
    private TextField name;

    @FXML
    private TextField number;

    @FXML
    private TextField namofteacher;

     @FXML
    private TextField TECH_NUM;

    @FXML
    private Button search;


    @FXML
    private Button update;
    @FXML
    private Button refresh;

    @FXML
    void refresh(ActionEvent event) {
        n.setCellValueFactory(new PropertyValueFactory<C,String>("n"));
        nu.setCellValueFactory(new PropertyValueFactory<C,Integer>("nu"));
        not.setCellValueFactory(new PropertyValueFactory<C,Integer>("not"));
        tnume.setCellValueFactory(new PropertyValueFactory<C,String>("tnume"));
        try{
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            String Url = "jdbc:oracle:thin:@localhost:1522:orcl";
            Connection con = DriverManager.getConnection(Url, "HR", "123456");
            con.setAutoCommit(false);
            Statement statement = con.createStatement();
            String sqls="Select COURSE.NAME_CO,COURSE.NU,COURSE.NAME_OF_TEACHER,COURSE.TECH_NUM FROM COURSE";
            ResultSet rs=statement.executeQuery(sqls);
            int i=0;
            list.clear();
            while(rs.next()){
                C OBJ=new C(rs.getString(1),rs.getInt(2),rs.getInt(4),rs.getString(3));
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
    void Add(ActionEvent event) {
        String Name=name.getText();
        Integer Number= Integer.parseInt( number.getText());
        String naft= namofteacher.getText();
        Integer tn=Integer.parseInt(TECH_NUM.getText());
        try {

            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            String url = "jdbc:oracle:thin:@localhost:1522:orcl";
            Connection con = DriverManager.getConnection(url, "HR", "123456");
            con.setAutoCommit(false);
            Statement statement = con.createStatement();
            statement.executeQuery("insert into COURSE (NAME_CO,NU,NAME_OF_TEACHER,TECH_NUM) VALUES ('" + Name + "'," +Number+ ",'" +naft+"'," +tn+")");
            con.commit();
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Message Here...");
            alert.setHeaderText("Course added");
            alert.showAndWait();
        }catch (SQLException e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }

    @FXML
    void Numberofteacher(ActionEvent event) {

    }



    @FXML
    void delete(ActionEvent event) {
        try {
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            String url = "jdbc:oracle:thin:@localhost:1522:orcl";
            Connection con = DriverManager.getConnection(url, "HR", "123456");
            con.setAutoCommit(false);
            Statement statement = con.createStatement();
            String sql="DELETE FROM COURSE WHERE NAME_CO='"+name.getText()+"' AND NU='" +number.getText()+"' AND NAME_OF_TEACHER='"+namofteacher.getText()+"' AND TECH_NUM='"+TECH_NUM.getText()+"'";
            statement.executeQuery(sql);
            con.commit();
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Message Here...");
            alert.setHeaderText("Course deleted");
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
    void name(ActionEvent event) {

    }

    @FXML
    void number(ActionEvent event) {

    }

    @FXML
    void search(ActionEvent event) {
        n.setCellValueFactory(new PropertyValueFactory<C,String>("n"));
        nu.setCellValueFactory(new PropertyValueFactory<C,Integer>("nu"));
        not.setCellValueFactory(new PropertyValueFactory<C,Integer>("not"));
        tnume.setCellValueFactory(new PropertyValueFactory<C,String>("tnume"));
        try{
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            String Url = "jdbc:oracle:thin:@localhost:1522:orcl";
            Connection con = DriverManager.getConnection(Url, "HR", "123456");
            con.setAutoCommit(false);
            Statement statement = con.createStatement();
            String sqls="Select COURSE.NAME_CO,COURSE.NU,COURSE.NAME_OF_TEACHER,COURSE.TECH_NUM FROM COURSE";
            ResultSet rs=statement.executeQuery(sqls);
            int i=0;
            list.clear();
            while(rs.next()){

                String seachtxt=number.getText();
                String nufromdb=Integer.toString(rs.getInt(2));
                if(seachtxt.equals(nufromdb)){
                C OBJ=new C(rs.getString(1),rs.getInt(2),rs.getInt(4),rs.getString(3));
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
            String sql="update COURSE set NAME_CO='" +name.getText()+"',NAME_OF_TEACHER='"+namofteacher.getText()+"',TECH_NUM='"+TECH_NUM.getText()+"'where NU='" +number.getText()+ "'";
            statement.executeQuery(sql);
            con.commit();
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Message Here...");
            alert.setHeaderText("Course updated");
            alert.showAndWait();
        }catch (SQLException e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }
    public ObservableList<C> list= FXCollections.observableArrayList();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        n.setCellValueFactory(new PropertyValueFactory<C,String>("n"));
        nu.setCellValueFactory(new PropertyValueFactory<C,Integer>("nu"));
        not.setCellValueFactory(new PropertyValueFactory<C,Integer>("not"));
        tnume.setCellValueFactory(new PropertyValueFactory<C,String>("tnume"));
        try{
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            String Url = "jdbc:oracle:thin:@localhost:1522:orcl";
            Connection con = DriverManager.getConnection(Url, "HR", "123456");
            con.setAutoCommit(false);
            Statement statement = con.createStatement();
            String sqls="Select COURSE.NAME_CO,COURSE.NU,COURSE.NAME_OF_TEACHER,COURSE.TECH_NUM FROM COURSE";
            ResultSet rs=statement.executeQuery(sqls);
            int i=0;
            list.clear();
            while(rs.next()){
                C OBJ=new C(rs.getString(1),rs.getInt(2),rs.getInt(4),rs.getString(3));
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
