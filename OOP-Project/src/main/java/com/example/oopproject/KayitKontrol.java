package com.example.oopproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class KayitKontrol {

    private Stage stage;
    private Parent root;
    private Scene scene;


    @FXML
    public TextField kullaniciAdi;
    public PasswordField sifre;
    public Button kayitButonu;
    public Hyperlink girisPaneliLink;

    public void kayitOl() {
        Connection connection = null;
        PreparedStatement psInsert = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/kullanicilar","root","Solevano12");
            psInsert = connection.prepareStatement("INSERT INTO kullanicilar (kullaniciadi,sifre,bakiye) VALUES (?,?,?)");
            psInsert.setString(1,kullaniciAdi.getText());
            psInsert.setString(2,sifre.getText());
            psInsert.setInt(3,0);
            psInsert.executeUpdate();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Kayıt Başarılı!!!");
            alert.setHeaderText("Sayın " + kullaniciAdi.getText());
            alert.setContentText("Alışveriş Uygulamasına Kayıt Oldunuz...");
            alert.showAndWait();
            kullaniciAdi.clear();
            sifre.clear();
        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    public void girisPaneliniAc(ActionEvent event){
        try {
            root = FXMLLoader.load(getClass().getResource("GirisPaneli.fxml"));
            stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Giriş Paneli");
            stage.show();
        }catch (IOException e){
            e.printStackTrace();
        }



    }



}


