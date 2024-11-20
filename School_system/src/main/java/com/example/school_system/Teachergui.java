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
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class Teachergui implements Initializable {

    @FXML
    private Button Add;

    @FXML
    private Button Delete;

    @FXML
    private Button Search;
    @FXML
    private Button refresh;


    @FXML
    private Button UPdate;

    @FXML
    private AnchorPane anchor;

    @FXML
    private AnchorPane apane;

    @FXML
    private BorderPane bpane;

    @FXML
    private Button exit;

    @FXML
    private ImageView image;

    @FXML
    private TextField numofst;

    @FXML
    private Pane pane;

    @FXML
    private StackPane spane;
    @FXML
    private TableColumn<T, String> coursenamee;
    @FXML
    private TableColumn<T, String> namee;
    @FXML
    private TableColumn<T, Integer> stnume;

    @FXML
    private TableView<T> table;

    @FXML
    private TableColumn<T, Integer> numbere;

    @FXML
    private TableColumn<T, String> gmaile;
    @FXML
    private TableColumn<T, String> empssne;
    @FXML
    private TextField tcourse;

    @FXML
    private ImageView teacher;

    @FXML
    private TextField tempssn;

    @FXML
    private TextField tgamil;

    @FXML
    private TextField tname;

    @FXML
    private TextField tnumber;




    @FXML
    void add(ActionEvent event) {
        try {
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            String url = "jdbc:oracle:thin:@localhost:1522:orcl";
            Connection con = DriverManager.getConnection(url, "HR", "123456");
            con.setAutoCommit(false);
            Statement statement = con.createStatement();
            statement.executeQuery("insert into TEACHER(NAME_TE,NUMBER_TE,COURSES,NUM_OF_STUDENT,EMP_SSN,EMAIL) VALUES('" + tname.getText() + "','" +tnumber.getText() + "','" +tcourse.getText()+"','" +numofst.getText() + "','" +tempssn.getText()+"','" +tgamil.getText()+ "')");
            con.commit();
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Message Here...");
            alert.setHeaderText("Teacher added successfully");
            alert.showAndWait();
        }catch (SQLException e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }

    @FXML
    void course(ActionEvent event) {

    }
    @FXML
    void refresh(ActionEvent event) {
        namee.setCellValueFactory(new PropertyValueFactory<T,String>("namee"));
        numbere.setCellValueFactory(new PropertyValueFactory<T,Integer>("numbere"));
        gmaile.setCellValueFactory(new PropertyValueFactory<T, String>("gmaile"));
        coursenamee.setCellValueFactory(new PropertyValueFactory<T,String>("coursenamee"));
        stnume.setCellValueFactory(new PropertyValueFactory<T,Integer>("stnume"));
        empssne.setCellValueFactory(new PropertyValueFactory<T,String>("empssne"));

        try{
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            String Url = "jdbc:oracle:thin:@localhost:1522:orcl";
            Connection con = DriverManager.getConnection(Url, "HR", "123456");
            con.setAutoCommit(false);
            Statement statement = con.createStatement();
            String sqls="Select TEACHER.NAME_TE,TEACHER.NUMBER_TE,TEACHER.EMAIL,TEACHER.NUM_OF_STUDENT,TEACHER.COURSES,TEACHER.EMP_SSN FROM TEACHER";
            ResultSet rs=statement.executeQuery(sqls);
            int i=0;
            list.clear();
            while(rs.next()){
                T OBJ=new T(rs.getString(1),rs.getInt(2),rs.getString(3),rs.getInt(4),rs.getString(5),rs.getString(6));
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
    void delete(ActionEvent event) {
        try {
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            String url = "jdbc:oracle:thin:@localhost:1522:orcl";
            Connection con = DriverManager.getConnection(url, "HR", "123456");
            con.setAutoCommit(false);
            Statement statement = con.createStatement();
            String sql="DELETE FROM TEACHER WHERE NAME_TE='"+tname.getText()+"' AND NUMBER_TE='" +tnumber.getText()+"' AND COURSES='"+tcourse.getText()+"'AND NUM_OF_STUDENT='" +numofst.getText()+"' AND EMP_SSN='"+tempssn.getText()+"' AND EMAIL='"+tgamil.getText()+"'";
            statement.executeQuery(sql);
            con.commit();
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Message Here...");
            alert.setHeaderText("Teacher data deleted");
            alert.showAndWait();
        }catch (SQLException e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }

    @FXML
    void empssn(ActionEvent event) {

    }

    @FXML
    void exit(ActionEvent event) {
        ((Node)(event.getSource())).getScene().getWindow().hide();
    }

    @FXML
    void gmail(ActionEvent event) {

    }

    @FXML
    void name(ActionEvent event) {

    }

    @FXML
    void number(ActionEvent event) {

    }

    @FXML
    void numofstu(ActionEvent event) {

    }

    @FXML
    void search(ActionEvent event) {
        namee.setCellValueFactory(new PropertyValueFactory<T,String>("namee"));
        numbere.setCellValueFactory(new PropertyValueFactory<T,Integer>("numbere"));
        gmaile.setCellValueFactory(new PropertyValueFactory<T, String>("gmaile"));
        coursenamee.setCellValueFactory(new PropertyValueFactory<T,String>("coursenamee"));
        stnume.setCellValueFactory(new PropertyValueFactory<T,Integer>("stnume"));
        empssne.setCellValueFactory(new PropertyValueFactory<T,String>("empssne"));

        try{
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            String Url = "jdbc:oracle:thin:@localhost:1522:orcl";
            Connection con = DriverManager.getConnection(Url, "HR", "123456");
            con.setAutoCommit(false);
            Statement statement = con.createStatement();
            String sqls="Select TEACHER.NAME_TE,TEACHER.NUMBER_TE,TEACHER.EMAIL,TEACHER.NUM_OF_STUDENT,TEACHER.COURSES,TEACHER.EMP_SSN FROM TEACHER";
            ResultSet rs=statement.executeQuery(sqls);
            int i=0;
            list.clear();
            while(rs.next()){
                String s=tnumber.getText();
                String db=Integer.toString(rs.getInt(2));
                if(s.equals(db)){
                T OBJ=new T(rs.getString(1),rs.getInt(2),rs.getString(3),rs.getInt(4),rs.getString(5),rs.getString(6));
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
            String sql="update TEACHER set NAME_TE='" +tname.getText()+"',COURSES='"+tcourse.getText()+"',NUM_OF_STUDENT='"+numofst.getText()+"',EMP_SSN='"+tempssn.getText()+"',EMAIL='"+tgamil.getText()+"'where NUMBER_TE='" +tnumber.getText()+ "'";
            statement.executeQuery(sql);
            con.commit();
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Message Here...");
            alert.setHeaderText("Teacher data updated");
            alert.showAndWait();
        }catch (SQLException e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }
    public ObservableList<T> list= FXCollections.observableArrayList();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        namee.setCellValueFactory(new PropertyValueFactory<T,String>("namee"));
        numbere.setCellValueFactory(new PropertyValueFactory<T,Integer>("numbere"));
        gmaile.setCellValueFactory(new PropertyValueFactory<T, String>("gmaile"));
        coursenamee.setCellValueFactory(new PropertyValueFactory<T,String>("coursenamee"));
        stnume.setCellValueFactory(new PropertyValueFactory<T,Integer>("stnume"));
        empssne.setCellValueFactory(new PropertyValueFactory<T,String>("empssne"));

        try{
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            String Url = "jdbc:oracle:thin:@localhost:1522:orcl";
            Connection con = DriverManager.getConnection(Url, "HR", "123456");
            con.setAutoCommit(false);
            Statement statement = con.createStatement();
            String sqls="Select TEACHER.NAME_TE,TEACHER.NUMBER_TE,TEACHER.EMAIL,TEACHER.NUM_OF_STUDENT,TEACHER.COURSES,TEACHER.EMP_SSN FROM TEACHER";
            ResultSet rs=statement.executeQuery(sqls);
            int i=0;
            list.clear();
            while(rs.next()){
                T OBJ=new T(rs.getString(1),rs.getInt(2),rs.getString(3),rs.getInt(4),rs.getString(5),rs.getString(6));
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
