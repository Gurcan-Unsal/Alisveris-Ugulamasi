package com.example.oopproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;

public class GirisKontrol {

    private Stage stage;
    private Parent root;
    private Scene scene;

    @FXML
    public TextField kullaniciAdi;
    public TextField sifre;
    public Button girisButonu;
    public Hyperlink kayitPaneliLink;


    public void girisYap(ActionEvent event){

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/kullanicilar","root","Solevano12");
            preparedStatement = connection.prepareStatement("SELECT sifre FROM kullanicilar WHERE kullaniciadi = ?");
            preparedStatement.setString(1,kullaniciAdi.getText());
            resultSet = preparedStatement.executeQuery();

            if(!resultSet.isBeforeFirst()){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Giriş Başarısız...");
                alert.setHeaderText("Böyle Bir Kullanıcı Adı Bulunmuyor...");
                alert.setContentText("Lütfen Uygulamaya Kayıt Olunuz.");
                alert.showAndWait();
                kullaniciAdi.clear();
                sifre.clear();
            }else {
                while (resultSet.next()){
                    String password = resultSet.getString("sifre");
                    if(password.equals(sifre.getText())){
                        try {
                            FileWriter fileWriter = new FileWriter("C:\\Users\\MSI\\IdeaProjects\\OOP-Project\\TempInfo\\TempUsername.txt");
                            fileWriter.write(kullaniciAdi.getText());
                            fileWriter.close();
                        }catch (IOException e){
                            e.printStackTrace();
                        }

                        try {
                            root = FXMLLoader.load(getClass().getResource("Market.fxml"));
                            stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
                            scene = new Scene(root);
                            stage.setScene(scene);
                            stage.setTitle("Market");
                            stage.show();
                        }
                        catch (IOException e){
                            e.printStackTrace();
                        }
                    }
                    else {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Giriş Başarısız...");
                        alert.setHeaderText("Sayın " + kullaniciAdi.getText());
                        alert.setContentText("Şifrenizi Kontrol Ediniz...");
                        alert.showAndWait();
                        kullaniciAdi.clear();
                        sifre.clear();
                    }
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    public void kayitPaneliniAc(ActionEvent event){
        try {
            root = FXMLLoader.load(getClass().getResource("KayitPaneli.fxml"));
            stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Kayıt Paneli");
            stage.show();
        }catch (IOException e){
            e.printStackTrace();
        }
    }


}
