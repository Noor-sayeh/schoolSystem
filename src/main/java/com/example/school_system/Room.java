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

public class Room implements Initializable {
    @FXML
    private TableColumn<R, Integer> ir;
    @FXML
    private TableColumn<R, Integer> sp;
    @FXML
    private TableColumn<R, String> ty;
    @FXML
    private TableView<R> table;

    @FXML
    private Button refresh;
    @FXML
    private Button add;

    @FXML
    private ImageView backgr;

    @FXML
    private Button delete;

    @FXML
    private Button exit;

    @FXML
    private ImageView image;

    @FXML
    private TextField roomid;

    @FXML
    private Button search;

    @FXML
    private TextField space;

    @FXML
    private Label titleroom;

    @FXML
    private TextField type;

    @FXML
    private Button update;
    @FXML
    void refresh(ActionEvent event) {
        sp.setCellValueFactory(new PropertyValueFactory<R, Integer>("sp"));
        ty.setCellValueFactory(new PropertyValueFactory<R, String>("ty"));
        ir.setCellValueFactory(new PropertyValueFactory<R, Integer>("ir"));
        try {
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            String Url = "jdbc:oracle:thin:@localhost:1522:orcl";
            Connection con = DriverManager.getConnection(Url, "HR", "123456");
            con.setAutoCommit(false);
            Statement statement = con.createStatement();
            String sqls = "Select ROOMS.IDR,ROOMS.TYPE,ROOMS.SPACE FROM ROOMS";
            ResultSet rs = statement.executeQuery(sqls);
            int i = 0;
            list.clear();
            while (rs.next()) {
                R OBJ = new R(rs.getString(2), rs.getInt(1), rs.getInt(3));
                list.add(i, OBJ);
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
            statement.executeQuery("insert into ROOM(IDR,TYPE,SPACE) VALUES('" + roomid.getText() + "','" +type.getText() + "','" +space.getText()+ "')");
            con.commit();
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Message Here...");
            alert.setHeaderText("Room data added successfully");
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
            String sql="DELETE FROM ROOM WHERE IDR='"+roomid.getText()+"' AND TYPE='" +type.getText()+"' AND SPACE='"+space.getText()+"'";
            statement.executeQuery(sql);
            con.commit();
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Message Here...");
            alert.setHeaderText("Room data deleted");
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
        sp.setCellValueFactory(new PropertyValueFactory<R, Integer>("sp"));
        ty.setCellValueFactory(new PropertyValueFactory<R, String>("ty"));
        ir.setCellValueFactory(new PropertyValueFactory<R, Integer>("ir"));
        try {
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            String Url = "jdbc:oracle:thin:@localhost:1522:orcl";
            Connection con = DriverManager.getConnection(Url, "HR", "123456");
            con.setAutoCommit(false);
            Statement statement = con.createStatement();
            String sqls = "Select ROOMS.IDR,ROOMS.TYPE,ROOMS.SPACE FROM ROOMS";
            ResultSet rs = statement.executeQuery(sqls);
            int i = 0;
            list.clear();
            while (rs.next()) {
                String s=roomid.getText();
                String db=Integer.toString(rs.getInt(1));
                if(s.equals(db)){
                R OBJ = new R(rs.getString(2), rs.getInt(1), rs.getInt(3));
                list.add(i, OBJ);
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
            String sql="update ROOMS set SPACE='" +space.getText()+"',TYPE='"+type.getText()+"'where IDR='" +roomid.getText()+ "'";
            statement.executeQuery(sql);
            con.commit();
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Message Here...");
            alert.setHeaderText("Room data updated");
            alert.showAndWait();
        }catch (SQLException e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }
    public ObservableList<R> list= FXCollections.observableArrayList();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        sp.setCellValueFactory(new PropertyValueFactory<R, Integer>("sp"));
        ty.setCellValueFactory(new PropertyValueFactory<R, String>("ty"));
        ir.setCellValueFactory(new PropertyValueFactory<R, Integer>("ir"));
        try {
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            String Url = "jdbc:oracle:thin:@localhost:1522:orcl";
            Connection con = DriverManager.getConnection(Url, "HR", "123456");
            con.setAutoCommit(false);
            Statement statement = con.createStatement();
            String sqls = "Select ROOMS.IDR,ROOMS.TYPE,ROOMS.SPACE FROM ROOMS";
            ResultSet rs = statement.executeQuery(sqls);
            int i = 0;
            list.clear();
            while (rs.next()) {
                R OBJ = new R(rs.getString(2), rs.getInt(1), rs.getInt(3));
                list.add(i, OBJ);
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
