package com.example.oopproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
import java.util.Scanner;

public class MarketKontrol implements Initializable{

    private String dosyaIcerigi = "";

    private Stage stage;
    private Parent root;
    private Scene scene;

    @FXML
    public Button kiyafetButonu;
    public Button elektronikButonu;
    public Button yiyecekButonu;
    public Button bakiyeButonu;
    public Hyperlink cikisLink;
    public Label bakiyeLabel;
    public TextField bakiyeTextField;

    public AnchorPane kiyafetPane;
    public ImageView ayakKabiResim;
    public ImageView tshirtResim;
    public ImageView sapkaResim;
    public ImageView kazakResim;
    public ImageView pantolonResim;
    public ImageView atkiResim;
    public Label ayakkabiLabel;
    public Label tshirtLabel;
    public Label sapkaLabel;
    public Label kazakLabel;
    public Label pantolonLabel;
    public Label atkiLabel;
    public Button ayakkabiButon;
    public Button tshirtButon;
    public Button sapkaButon;
    public Button kazakButon;
    public Button pantolonButon;
    public Button atkiButon;

    public AnchorPane elektronikPane;
    public ImageView bilgisayarResim;
    public ImageView telefonResim;
    public ImageView televizyonResim;
    public ImageView camasirMakinesiResim;
    public ImageView buzdolabiResim;
    public ImageView tostMakinesiResim;
    public Label bilgisayarLabel;
    public Label telefonLabel;
    public Label televizyonLabel;
    public Label camasirMakinesiLabel;
    public Label buzdolabiLabel;
    public Label tostMakinesiLabel;
    public Button bilgisayarButon;
    public Button telefonButon;
    public Button televizyonButon;
    public Button camasirMakinesiButon;
    public Button buzdolabiButon;
    public Button tostMakinesiButon;

    public AnchorPane yiyecekPane;
    public ImageView biftekResim;
    public ImageView tacoResim;
    public ImageView kizartmaResim;
    public ImageView kolaResim;
    public ImageView pastaResim;
    public ImageView dondurmaResim;
    public Label biftekLabel;
    public Label tacoLabel;
    public Label kizartmaLabel;
    public Label kolaLabel;
    public Label pastaLabel;
    public Label dondurmaLabel;
    public Button biftekButon;
    public Button tacoButon;
    public Button kizartmaButon;
    public Button kolaButon;
    public Button pastaButon;
    public Button dondurmaButon;

    @Override
    public void initialize(URL url,ResourceBundle resourceBundle) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            File file = new File("C:\\Users\\MSI\\IdeaProjects\\OOP-Project\\TempInfo\\TempUsername.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()){
                dosyaIcerigi = dosyaIcerigi.concat(scanner.nextLine());
            }
        }catch (IOException e){
            e.printStackTrace();
        }

        try {
            int bakiye;
            connection = DriverManager.getConnection("jdbc:mysql://localhost/kullanicilar","root","Solevano12");
            preparedStatement = connection.prepareStatement("SELECT kullaniciadi,bakiye FROM kullanicilar");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String kullanici = resultSet.getString("kullaniciadi");
                if(kullanici.equals(dosyaIcerigi)){
                    bakiye = resultSet.getInt("bakiye");
                    bakiyeLabel.setText(String.valueOf(bakiye));
                }
            }

        }catch (SQLException e){
            e.printStackTrace();
        }

        //KIYAFETLER
        File sneakers = new File("C:\\Users\\MSI\\IdeaProjects\\OOP-Project\\Pic\\Kıyafetler\\sneakers.png");
        Image sneakersImage = new Image(sneakers.toURI().toString());
        ayakKabiResim.setImage(sneakersImage);

        File tshirt = new File("C:\\Users\\MSI\\IdeaProjects\\OOP-Project\\Pic\\Kıyafetler\\tshirt.png");
        Image tshirtImage = new Image(tshirt.toURI().toString());
        tshirtResim.setImage(tshirtImage);

        File hat = new File("C:\\Users\\MSI\\IdeaProjects\\OOP-Project\\Pic\\Kıyafetler\\hat.png");
        Image hatImage = new Image(hat.toURI().toString());
        sapkaResim.setImage(hatImage);

        File sweater = new File("C:\\Users\\MSI\\IdeaProjects\\OOP-Project\\Pic\\Kıyafetler\\sweater.png");
        Image sweaterImage = new Image(sweater.toURI().toString());
        kazakResim.setImage(sweaterImage);

        File trousers = new File("C:\\Users\\MSI\\IdeaProjects\\OOP-Project\\Pic\\Kıyafetler\\trousers.png");
        Image trousersImage = new Image(trousers.toURI().toString());
        pantolonResim.setImage(trousersImage);

        File scarf = new File("C:\\Users\\MSI\\IdeaProjects\\OOP-Project\\Pic\\Kıyafetler\\scarf.png");
        Image scarfImage = new Image(scarf.toURI().toString());
        atkiResim.setImage(scarfImage);

        //Elektronikler
        File laptop = new File("C:\\Users\\MSI\\IdeaProjects\\OOP-Project\\Pic\\Elektronik Eşyalar\\computer.png");
        Image laptopImage = new Image(laptop.toURI().toString());
        bilgisayarResim.setImage(laptopImage);

        File phone = new File("C:\\Users\\MSI\\IdeaProjects\\OOP-Project\\Pic\\Elektronik Eşyalar\\phone.png");
        Image phoneImage = new Image(phone.toURI().toString());
        telefonResim.setImage(phoneImage);

        File television = new File("C:\\Users\\MSI\\IdeaProjects\\OOP-Project\\Pic\\Elektronik Eşyalar\\television.png");
        Image televisionImage = new Image(television.toURI().toString());
        televizyonResim.setImage(televisionImage);

        File washer = new File("C:\\Users\\MSI\\IdeaProjects\\OOP-Project\\Pic\\Elektronik Eşyalar\\washer.png");
        Image washerImage = new Image(washer.toURI().toString());
        camasirMakinesiResim.setImage(washerImage);

        File fridge = new File("C:\\Users\\MSI\\IdeaProjects\\OOP-Project\\Pic\\Elektronik Eşyalar\\fridge.png");
        Image fridgeImage = new Image(fridge.toURI().toString());
        buzdolabiResim.setImage(fridgeImage);

        File toastMachine = new File("C:\\Users\\MSI\\IdeaProjects\\OOP-Project\\Pic\\Elektronik Eşyalar\\toastmachine.png");
        Image toastMachineImage = new Image(toastMachine.toURI().toString());
        tostMakinesiResim.setImage(toastMachineImage);

        //Yiyecek-İçecekler
        File steak = new File("C:\\Users\\MSI\\IdeaProjects\\OOP-Project\\Pic\\Yiyecekler\\steak.png");
        Image steakImage = new Image(steak.toURI().toString());
        biftekResim.setImage(steakImage);

        File taco = new File("C:\\Users\\MSI\\IdeaProjects\\OOP-Project\\Pic\\Yiyecekler\\taco.png");
        Image tacoImage = new Image(taco.toURI().toString());
        tacoResim.setImage(tacoImage);

        File fries = new File("C:\\Users\\MSI\\IdeaProjects\\OOP-Project\\Pic\\Yiyecekler\\fries.png");
        Image friesImage = new Image(fries.toURI().toString());
        kizartmaResim.setImage(friesImage);

        File coke = new File("C:\\Users\\MSI\\IdeaProjects\\OOP-Project\\Pic\\Yiyecekler\\coke.png");
        Image cokeImage = new Image(coke.toURI().toString());
        kolaResim.setImage(cokeImage);

        File cake = new File("C:\\Users\\MSI\\IdeaProjects\\OOP-Project\\Pic\\Yiyecekler\\cake.png");
        Image cakeImage = new Image(cake.toURI().toString());
        pastaResim.setImage(cakeImage);

        File iceCream = new File("C:\\Users\\MSI\\IdeaProjects\\OOP-Project\\Pic\\Yiyecekler\\icecream.png");
        Image iceCreamImage = new Image(iceCream.toURI().toString());
        dondurmaResim.setImage(iceCreamImage);


    }

    public void cikisYap(ActionEvent event){
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

    public void kiyafetleriGoster(){
        elektronikPane.setVisible(false);
        yiyecekPane.setVisible(false);
        kiyafetPane.setVisible(true);
    }

    public void elektronikleriGoster(){
        kiyafetPane.setVisible(false);
        yiyecekPane.setVisible(false);
        elektronikPane.setVisible(true);
    }

    public void yiyecekleriGoster(){
        kiyafetPane.setVisible(false);
        elektronikPane.setVisible(false);
        yiyecekPane.setVisible(true);
    }

    public void bakiyeYukle(){

        int bakiye = Integer.valueOf(bakiyeLabel.getText());
        bakiye += Integer.valueOf(bakiyeTextField.getText());

        Connection connection = null;
        PreparedStatement psUpdate = null;
        PreparedStatement psSelect = null;
        ResultSet resultSet = null;

        if(Integer.valueOf(bakiyeTextField.getText()) > 0){
            try {
                connection = DriverManager.getConnection("jdbc:mysql://localhost/kullanicilar","root","Solevano12");
                psUpdate = connection.prepareStatement("UPDATE kullanicilar SET bakiye = ? WHERE kullaniciadi = ?");
                psUpdate.setInt(1,bakiye);
                psUpdate.setString(2,dosyaIcerigi);
                psUpdate.execute();

                psSelect = connection.prepareStatement("SELECT kullaniciadi,bakiye FROM kullanicilar");
                resultSet = psSelect.executeQuery();
                while (resultSet.next()){
                    String kullanici = resultSet.getString("kullaniciadi");
                    int geciciBakiye;
                    if(kullanici.equals(dosyaIcerigi)){
                        geciciBakiye = resultSet.getInt("bakiye");
                        bakiyeLabel.setText(String.valueOf(geciciBakiye));
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Yükleme Başarılı!!!");
                        alert.setHeaderText("Sayın " + dosyaIcerigi);
                        alert.setContentText("Hesabınıza " + bakiyeTextField.getText() + " TL Yüklenmiştir...");
                        alert.showAndWait();
                    }
                }
            }catch (SQLException e) {
                e.printStackTrace();
            }
        }
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Yükleme Başarısız!");
            alert.setHeaderText("Sayın " + dosyaIcerigi);
            alert.setContentText("Lütfen Pozitif Bir Sayı Giriniz...");
            alert.showAndWait();
        }
        bakiyeTextField.clear();
    }

    public void ayakkabiAl(){

        Ayakkabi ayakkabi = new Ayakkabi(100);

        if(Integer.valueOf(bakiyeLabel.getText()) >= ayakkabi.fiyat)
        {
            int bakiye = Integer.valueOf(bakiyeLabel.getText());
            bakiye -= ayakkabi.fiyat;

            Connection connection = null;
            PreparedStatement psUpdate = null;
            PreparedStatement psSelect = null;
            ResultSet resultSet = null;
            try {
                connection = DriverManager.getConnection("jdbc:mysql://localhost/kullanicilar","root","Solevano12");
                psUpdate = connection.prepareStatement("UPDATE kullanicilar SET bakiye = ? WHERE kullaniciadi = ?");
                psUpdate.setInt(1,bakiye);
                psUpdate.setString(2,dosyaIcerigi);
                psUpdate.execute();
                psSelect = connection.prepareStatement("SELECT kullaniciadi,bakiye FROM kullanicilar");
                resultSet = psSelect.executeQuery();
                while (resultSet.next()){
                    String kullanici = resultSet.getString("kullaniciadi");
                    int geciciBakiye;
                    if(kullanici.equals(dosyaIcerigi)){
                        geciciBakiye = resultSet.getInt("bakiye");
                        bakiyeLabel.setText(String.valueOf(geciciBakiye));
                    }
                }
            }catch (SQLException e) {
                e.printStackTrace();
            }
        }
        else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Alışveriş Başarısız...");
            alert.setHeaderText("Yetersiz Bakiye!!!");
            alert.setContentText("Hesabınıza Para Yüklemesi Yapınız...");
            alert.showAndWait();
        }

    }

    public void tshirtAl(){

        TShirt tShirt = new TShirt(75);

        if(Integer.valueOf(bakiyeLabel.getText()) >= tShirt.fiyat)
        {
            int bakiye = Integer.valueOf(bakiyeLabel.getText());
            bakiye -= tShirt.fiyat;

            Connection connection = null;
            PreparedStatement psUpdate = null;
            PreparedStatement psSelect = null;
            ResultSet resultSet = null;
            try {
                connection = DriverManager.getConnection("jdbc:mysql://localhost/kullanicilar","root","Solevano12");
                psUpdate = connection.prepareStatement("UPDATE kullanicilar SET bakiye = ? WHERE kullaniciadi = ?");
                psUpdate.setInt(1,bakiye);
                psUpdate.setString(2,dosyaIcerigi);
                psUpdate.execute();
                psSelect = connection.prepareStatement("SELECT kullaniciadi,bakiye FROM kullanicilar");
                resultSet = psSelect.executeQuery();
                while (resultSet.next()){
                    String kullanici = resultSet.getString("kullaniciadi");
                    int geciciBakiye;
                    if(kullanici.equals(dosyaIcerigi)){
                        geciciBakiye = resultSet.getInt("bakiye");
                        bakiyeLabel.setText(String.valueOf(geciciBakiye));
                    }
                }
            }catch (SQLException e) {
                e.printStackTrace();
            }
        }
        else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Alışveriş Başarısız...");
            alert.setHeaderText("Yetersiz Bakiye!!!");
            alert.setContentText("Hesabınıza Para Yüklemesi Yapınız...");
            alert.showAndWait();
        }

    }

    public void sapkaAl(){

        Sapka sapka = new Sapka(10);

        if(Integer.valueOf(bakiyeLabel.getText()) >= sapka.fiyat)
        {
            int bakiye = Integer.valueOf(bakiyeLabel.getText());
            bakiye -= sapka.fiyat;

            Connection connection = null;
            PreparedStatement psUpdate = null;
            PreparedStatement psSelect = null;
            ResultSet resultSet = null;
            try {
                connection = DriverManager.getConnection("jdbc:mysql://localhost/kullanicilar","root","Solevano12");
                psUpdate = connection.prepareStatement("UPDATE kullanicilar SET bakiye = ? WHERE kullaniciadi = ?");
                psUpdate.setInt(1,bakiye);
                psUpdate.setString(2,dosyaIcerigi);
                psUpdate.execute();
                psSelect = connection.prepareStatement("SELECT kullaniciadi,bakiye FROM kullanicilar");
                resultSet = psSelect.executeQuery();
                while (resultSet.next()){
                    String kullanici = resultSet.getString("kullaniciadi");
                    int geciciBakiye;
                    if(kullanici.equals(dosyaIcerigi)){
                        geciciBakiye = resultSet.getInt("bakiye");
                        bakiyeLabel.setText(String.valueOf(geciciBakiye));
                    }
                }
            }catch (SQLException e) {
                e.printStackTrace();
            }
        }
        else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Alışveriş Başarısız...");
            alert.setHeaderText("Yetersiz Bakiye!!!");
            alert.setContentText("Hesabınıza Para Yüklemesi Yapınız...");
            alert.showAndWait();
        }

    }

    public void kazakAl(){

        Kazak kazak = new Kazak(50);

        if(Integer.valueOf(bakiyeLabel.getText()) >= kazak.fiyat)
        {
            int bakiye = Integer.valueOf(bakiyeLabel.getText());
            bakiye -= kazak.fiyat;

            Connection connection = null;
            PreparedStatement psUpdate = null;
            PreparedStatement psSelect = null;
            ResultSet resultSet = null;
            try {
                connection = DriverManager.getConnection("jdbc:mysql://localhost/kullanicilar","root","Solevano12");
                psUpdate = connection.prepareStatement("UPDATE kullanicilar SET bakiye = ? WHERE kullaniciadi = ?");
                psUpdate.setInt(1,bakiye);
                psUpdate.setString(2,dosyaIcerigi);
                psUpdate.execute();
                psSelect = connection.prepareStatement("SELECT kullaniciadi,bakiye FROM kullanicilar");
                resultSet = psSelect.executeQuery();
                while (resultSet.next()){
                    String kullanici = resultSet.getString("kullaniciadi");
                    int geciciBakiye;
                    if(kullanici.equals(dosyaIcerigi)){
                        geciciBakiye = resultSet.getInt("bakiye");
                        bakiyeLabel.setText(String.valueOf(geciciBakiye));
                    }
                }
            }catch (SQLException e) {
                e.printStackTrace();
            }
        }
        else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Alışveriş Başarısız...");
            alert.setHeaderText("Yetersiz Bakiye!!!");
            alert.setContentText("Hesabınıza Para Yüklemesi Yapınız...");
            alert.showAndWait();
        }

    }

    public void pantolonAl(){

        Pantolon pantolon = new Pantolon(80);

        if(Integer.valueOf(bakiyeLabel.getText()) >= pantolon.fiyat)
        {
            int bakiye = Integer.valueOf(bakiyeLabel.getText());
            bakiye -= pantolon.fiyat;

            Connection connection = null;
            PreparedStatement psUpdate = null;
            PreparedStatement psSelect = null;
            ResultSet resultSet = null;
            try {
                connection = DriverManager.getConnection("jdbc:mysql://localhost/kullanicilar","root","Solevano12");
                psUpdate = connection.prepareStatement("UPDATE kullanicilar SET bakiye = ? WHERE kullaniciadi = ?");
                psUpdate.setInt(1,bakiye);
                psUpdate.setString(2,dosyaIcerigi);
                psUpdate.execute();
                psSelect = connection.prepareStatement("SELECT kullaniciadi,bakiye FROM kullanicilar");
                resultSet = psSelect.executeQuery();
                while (resultSet.next()){
                    String kullanici = resultSet.getString("kullaniciadi");
                    int geciciBakiye;
                    if(kullanici.equals(dosyaIcerigi)){
                        geciciBakiye = resultSet.getInt("bakiye");
                        bakiyeLabel.setText(String.valueOf(geciciBakiye));
                    }
                }
            }catch (SQLException e) {
                e.printStackTrace();
            }
        }
        else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Alışveriş Başarısız...");
            alert.setHeaderText("Yetersiz Bakiye!!!");
            alert.setContentText("Hesabınıza Para Yüklemesi Yapınız...");
            alert.showAndWait();
        }

    }

    public void atkiAl(){

        Atki atki = new Atki(5);

        if(Integer.valueOf(bakiyeLabel.getText()) >= atki.fiyat)
        {
            int bakiye = Integer.valueOf(bakiyeLabel.getText());
            bakiye -= atki.fiyat;

            Connection connection = null;
            PreparedStatement psUpdate = null;
            PreparedStatement psSelect = null;
            ResultSet resultSet = null;
            try {
                connection = DriverManager.getConnection("jdbc:mysql://localhost/kullanicilar","root","Solevano12");
                psUpdate = connection.prepareStatement("UPDATE kullanicilar SET bakiye = ? WHERE kullaniciadi = ?");
                psUpdate.setInt(1,bakiye);
                psUpdate.setString(2,dosyaIcerigi);
                psUpdate.execute();
                psSelect = connection.prepareStatement("SELECT kullaniciadi,bakiye FROM kullanicilar");
                resultSet = psSelect.executeQuery();
                while (resultSet.next()){
                    String kullanici = resultSet.getString("kullaniciadi");
                    int geciciBakiye;
                    if(kullanici.equals(dosyaIcerigi)){
                        geciciBakiye = resultSet.getInt("bakiye");
                        bakiyeLabel.setText(String.valueOf(geciciBakiye));
                    }
                }
            }catch (SQLException e) {
                e.printStackTrace();
            }
        }
        else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Alışveriş Başarısız...");
            alert.setHeaderText("Yetersiz Bakiye!!!");
            alert.setContentText("Hesabınıza Para Yüklemesi Yapınız...");
            alert.showAndWait();
        }

    }

    public void bilgisayarAl(){

        Bilgisayar bilgisayar = new Bilgisayar(2000);

        if(Integer.valueOf(bakiyeLabel.getText()) >= bilgisayar.fiyat)
        {
            int bakiye = Integer.valueOf(bakiyeLabel.getText());
            bakiye -= bilgisayar.fiyat;

            Connection connection = null;
            PreparedStatement psUpdate = null;
            PreparedStatement psSelect = null;
            ResultSet resultSet = null;
            try {
                connection = DriverManager.getConnection("jdbc:mysql://localhost/kullanicilar","root","Solevano12");
                psUpdate = connection.prepareStatement("UPDATE kullanicilar SET bakiye = ? WHERE kullaniciadi = ?");
                psUpdate.setInt(1,bakiye);
                psUpdate.setString(2,dosyaIcerigi);
                psUpdate.execute();
                psSelect = connection.prepareStatement("SELECT kullaniciadi,bakiye FROM kullanicilar");
                resultSet = psSelect.executeQuery();
                while (resultSet.next()){
                    String kullanici = resultSet.getString("kullaniciadi");
                    int geciciBakiye;
                    if(kullanici.equals(dosyaIcerigi)){
                        geciciBakiye = resultSet.getInt("bakiye");
                        bakiyeLabel.setText(String.valueOf(geciciBakiye));
                    }
                }
            }catch (SQLException e) {
                e.printStackTrace();
            }
        }
        else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Alışveriş Başarısız...");
            alert.setHeaderText("Yetersiz Bakiye!!!");
            alert.setContentText("Hesabınıza Para Yüklemesi Yapınız...");
            alert.showAndWait();
        }

    }

    public void telefonAl(){

        Telefon telefon = new Telefon(1000);

        if(Integer.valueOf(bakiyeLabel.getText()) >= telefon.fiyat)
        {
            int bakiye = Integer.valueOf(bakiyeLabel.getText());
            bakiye -= telefon.fiyat;

            Connection connection = null;
            PreparedStatement psUpdate = null;
            PreparedStatement psSelect = null;
            ResultSet resultSet = null;
            try {
                connection = DriverManager.getConnection("jdbc:mysql://localhost/kullanicilar","root","Solevano12");
                psUpdate = connection.prepareStatement("UPDATE kullanicilar SET bakiye = ? WHERE kullaniciadi = ?");
                psUpdate.setInt(1,bakiye);
                psUpdate.setString(2,dosyaIcerigi);
                psUpdate.execute();
                psSelect = connection.prepareStatement("SELECT kullaniciadi,bakiye FROM kullanicilar");
                resultSet = psSelect.executeQuery();
                while (resultSet.next()){
                    String kullanici = resultSet.getString("kullaniciadi");
                    int geciciBakiye;
                    if(kullanici.equals(dosyaIcerigi)){
                        geciciBakiye = resultSet.getInt("bakiye");
                        bakiyeLabel.setText(String.valueOf(geciciBakiye));
                    }
                }
            }catch (SQLException e) {
                e.printStackTrace();
            }
        }
        else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Alışveriş Başarısız...");
            alert.setHeaderText("Yetersiz Bakiye!!!");
            alert.setContentText("Hesabınıza Para Yüklemesi Yapınız...");
            alert.showAndWait();
        }

    }

    public void televizyonAl(){

        Televizyon televizyon = new Televizyon(1250);

        if(Integer.valueOf(bakiyeLabel.getText()) >= televizyon.fiyat)
        {
            int bakiye = Integer.valueOf(bakiyeLabel.getText());
            bakiye -= televizyon.fiyat;

            Connection connection = null;
            PreparedStatement psUpdate = null;
            PreparedStatement psSelect = null;
            ResultSet resultSet = null;
            try {
                connection = DriverManager.getConnection("jdbc:mysql://localhost/kullanicilar","root","Solevano12");
                psUpdate = connection.prepareStatement("UPDATE kullanicilar SET bakiye = ? WHERE kullaniciadi = ?");
                psUpdate.setInt(1,bakiye);
                psUpdate.setString(2,dosyaIcerigi);
                psUpdate.execute();
                psSelect = connection.prepareStatement("SELECT kullaniciadi,bakiye FROM kullanicilar");
                resultSet = psSelect.executeQuery();
                while (resultSet.next()){
                    String kullanici = resultSet.getString("kullaniciadi");
                    int geciciBakiye;
                    if(kullanici.equals(dosyaIcerigi)){
                        geciciBakiye = resultSet.getInt("bakiye");
                        bakiyeLabel.setText(String.valueOf(geciciBakiye));
                    }
                }
            }catch (SQLException e) {
                e.printStackTrace();
            }
        }
        else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Alışveriş Başarısız...");
            alert.setHeaderText("Yetersiz Bakiye!!!");
            alert.setContentText("Hesabınıza Para Yüklemesi Yapınız...");
            alert.showAndWait();
        }

    }

    public void camasirMakinesiAl(){

        CamasirMakinesi camasirMakinesi = new CamasirMakinesi(500);

        if(Integer.valueOf(bakiyeLabel.getText()) >= camasirMakinesi.fiyat)
        {
            int bakiye = Integer.valueOf(bakiyeLabel.getText());
            bakiye -= camasirMakinesi.fiyat;

            Connection connection = null;
            PreparedStatement psUpdate = null;
            PreparedStatement psSelect = null;
            ResultSet resultSet = null;
            try {
                connection = DriverManager.getConnection("jdbc:mysql://localhost/kullanicilar","root","Solevano12");
                psUpdate = connection.prepareStatement("UPDATE kullanicilar SET bakiye = ? WHERE kullaniciadi = ?");
                psUpdate.setInt(1,bakiye);
                psUpdate.setString(2,dosyaIcerigi);
                psUpdate.execute();
                psSelect = connection.prepareStatement("SELECT kullaniciadi,bakiye FROM kullanicilar");
                resultSet = psSelect.executeQuery();
                while (resultSet.next()){
                    String kullanici = resultSet.getString("kullaniciadi");
                    int geciciBakiye;
                    if(kullanici.equals(dosyaIcerigi)){
                        geciciBakiye = resultSet.getInt("bakiye");
                        bakiyeLabel.setText(String.valueOf(geciciBakiye));
                    }
                }
            }catch (SQLException e) {
                e.printStackTrace();
            }
        }
        else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Alışveriş Başarısız...");
            alert.setHeaderText("Yetersiz Bakiye!!!");
            alert.setContentText("Hesabınıza Para Yüklemesi Yapınız...");
            alert.showAndWait();
        }

    }

    public void buzdolabiAl(){

        BuzDolabi buzDolabi = new BuzDolabi(750);

        if(Integer.valueOf(bakiyeLabel.getText()) >= buzDolabi.fiyat)
        {
            int bakiye = Integer.valueOf(bakiyeLabel.getText());
            bakiye -= buzDolabi.fiyat;

            Connection connection = null;
            PreparedStatement psUpdate = null;
            PreparedStatement psSelect = null;
            ResultSet resultSet = null;
            try {
                connection = DriverManager.getConnection("jdbc:mysql://localhost/kullanicilar","root","Solevano12");
                psUpdate = connection.prepareStatement("UPDATE kullanicilar SET bakiye = ? WHERE kullaniciadi = ?");
                psUpdate.setInt(1,bakiye);
                psUpdate.setString(2,dosyaIcerigi);
                psUpdate.execute();
                psSelect = connection.prepareStatement("SELECT kullaniciadi,bakiye FROM kullanicilar");
                resultSet = psSelect.executeQuery();
                while (resultSet.next()){
                    String kullanici = resultSet.getString("kullaniciadi");
                    int geciciBakiye;
                    if(kullanici.equals(dosyaIcerigi)){
                        geciciBakiye = resultSet.getInt("bakiye");
                        bakiyeLabel.setText(String.valueOf(geciciBakiye));
                    }
                }
            }catch (SQLException e) {
                e.printStackTrace();
            }
        }
        else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Alışveriş Başarısız...");
            alert.setHeaderText("Yetersiz Bakiye!!!");
            alert.setContentText("Hesabınıza Para Yüklemesi Yapınız...");
            alert.showAndWait();
        }

    }

    public void tostMakinesiAl(){

        TostMakinesi tostMakinesi = new TostMakinesi(100);

        if(Integer.valueOf(bakiyeLabel.getText()) >= tostMakinesi.fiyat)
        {
            int bakiye = Integer.valueOf(bakiyeLabel.getText());
            bakiye -= tostMakinesi.fiyat;

            Connection connection = null;
            PreparedStatement psUpdate = null;
            PreparedStatement psSelect = null;
            ResultSet resultSet = null;
            try {
                connection = DriverManager.getConnection("jdbc:mysql://localhost/kullanicilar","root","Solevano12");
                psUpdate = connection.prepareStatement("UPDATE kullanicilar SET bakiye = ? WHERE kullaniciadi = ?");
                psUpdate.setInt(1,bakiye);
                psUpdate.setString(2,dosyaIcerigi);
                psUpdate.execute();
                psSelect = connection.prepareStatement("SELECT kullaniciadi,bakiye FROM kullanicilar");
                resultSet = psSelect.executeQuery();
                while (resultSet.next()){
                    String kullanici = resultSet.getString("kullaniciadi");
                    int geciciBakiye;
                    if(kullanici.equals(dosyaIcerigi)){
                        geciciBakiye = resultSet.getInt("bakiye");
                        bakiyeLabel.setText(String.valueOf(geciciBakiye));
                    }
                }
            }catch (SQLException e) {
                e.printStackTrace();
            }
        }
        else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Alışveriş Başarısız...");
            alert.setHeaderText("Yetersiz Bakiye!!!");
            alert.setContentText("Hesabınıza Para Yüklemesi Yapınız...");
            alert.showAndWait();
        }

    }

    public void biftekAl(){

        Biftek biftek = new Biftek(75);

        if(Integer.valueOf(bakiyeLabel.getText()) >= biftek.fiyat)
        {
            int bakiye = Integer.valueOf(bakiyeLabel.getText());
            bakiye -= biftek.fiyat;

            Connection connection = null;
            PreparedStatement psUpdate = null;
            PreparedStatement psSelect = null;
            ResultSet resultSet = null;
            try {
                connection = DriverManager.getConnection("jdbc:mysql://localhost/kullanicilar","root","Solevano12");
                psUpdate = connection.prepareStatement("UPDATE kullanicilar SET bakiye = ? WHERE kullaniciadi = ?");
                psUpdate.setInt(1,bakiye);
                psUpdate.setString(2,dosyaIcerigi);
                psUpdate.execute();
                psSelect = connection.prepareStatement("SELECT kullaniciadi,bakiye FROM kullanicilar");
                resultSet = psSelect.executeQuery();
                while (resultSet.next()){
                    String kullanici = resultSet.getString("kullaniciadi");
                    int geciciBakiye;
                    if(kullanici.equals(dosyaIcerigi)){
                        geciciBakiye = resultSet.getInt("bakiye");
                        bakiyeLabel.setText(String.valueOf(geciciBakiye));
                    }
                }
            }catch (SQLException e) {
                e.printStackTrace();
            }
        }
        else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Alışveriş Başarısız...");
            alert.setHeaderText("Yetersiz Bakiye!!!");
            alert.setContentText("Hesabınıza Para Yüklemesi Yapınız...");
            alert.showAndWait();
        }

    }

    public void tacoAl(){

        Taco taco = new Taco(50);

        if(Integer.valueOf(bakiyeLabel.getText()) >= taco.fiyat)
        {
            int bakiye = Integer.valueOf(bakiyeLabel.getText());
            bakiye -= taco.fiyat;

            Connection connection = null;
            PreparedStatement psUpdate = null;
            PreparedStatement psSelect = null;
            ResultSet resultSet = null;
            try {
                connection = DriverManager.getConnection("jdbc:mysql://localhost/kullanicilar","root","Solevano12");
                psUpdate = connection.prepareStatement("UPDATE kullanicilar SET bakiye = ? WHERE kullaniciadi = ?");
                psUpdate.setInt(1,bakiye);
                psUpdate.setString(2,dosyaIcerigi);
                psUpdate.execute();
                psSelect = connection.prepareStatement("SELECT kullaniciadi,bakiye FROM kullanicilar");
                resultSet = psSelect.executeQuery();
                while (resultSet.next()){
                    String kullanici = resultSet.getString("kullaniciadi");
                    int geciciBakiye;
                    if(kullanici.equals(dosyaIcerigi)){
                        geciciBakiye = resultSet.getInt("bakiye");
                        bakiyeLabel.setText(String.valueOf(geciciBakiye));
                    }
                }
            }catch (SQLException e) {
                e.printStackTrace();
            }
        }
        else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Alışveriş Başarısız...");
            alert.setHeaderText("Yetersiz Bakiye!!!");
            alert.setContentText("Hesabınıza Para Yüklemesi Yapınız...");
            alert.showAndWait();
        }

    }

    public void kizartmaAl(){

        Kizartma kizartma = new Kizartma(10);

        if(Integer.valueOf(bakiyeLabel.getText()) >= kizartma.fiyat)
        {
            int bakiye = Integer.valueOf(bakiyeLabel.getText());
            bakiye -= kizartma.fiyat;

            Connection connection = null;
            PreparedStatement psUpdate = null;
            PreparedStatement psSelect = null;
            ResultSet resultSet = null;
            try {
                connection = DriverManager.getConnection("jdbc:mysql://localhost/kullanicilar","root","Solevano12");
                psUpdate = connection.prepareStatement("UPDATE kullanicilar SET bakiye = ? WHERE kullaniciadi = ?");
                psUpdate.setInt(1,bakiye);
                psUpdate.setString(2,dosyaIcerigi);
                psUpdate.execute();
                psSelect = connection.prepareStatement("SELECT kullaniciadi,bakiye FROM kullanicilar");
                resultSet = psSelect.executeQuery();
                while (resultSet.next()){
                    String kullanici = resultSet.getString("kullaniciadi");
                    int geciciBakiye;
                    if(kullanici.equals(dosyaIcerigi)){
                        geciciBakiye = resultSet.getInt("bakiye");
                        bakiyeLabel.setText(String.valueOf(geciciBakiye));
                    }
                }
            }catch (SQLException e) {
                e.printStackTrace();
            }
        }
        else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Alışveriş Başarısız...");
            alert.setHeaderText("Yetersiz Bakiye!!!");
            alert.setContentText("Hesabınıza Para Yüklemesi Yapınız...");
            alert.showAndWait();
        }

    }

    public void kolaAl(){

        Kola kola = new Kola(3);

        if(Integer.valueOf(bakiyeLabel.getText()) >= kola.fiyat)
        {
            int bakiye = Integer.valueOf(bakiyeLabel.getText());
            bakiye -= kola.fiyat;

            Connection connection = null;
            PreparedStatement psUpdate = null;
            PreparedStatement psSelect = null;
            ResultSet resultSet = null;
            try {
                connection = DriverManager.getConnection("jdbc:mysql://localhost/kullanicilar","root","Solevano12");
                psUpdate = connection.prepareStatement("UPDATE kullanicilar SET bakiye = ? WHERE kullaniciadi = ?");
                psUpdate.setInt(1,bakiye);
                psUpdate.setString(2,dosyaIcerigi);
                psUpdate.execute();
                psSelect = connection.prepareStatement("SELECT kullaniciadi,bakiye FROM kullanicilar");
                resultSet = psSelect.executeQuery();
                while (resultSet.next()){
                    String kullanici = resultSet.getString("kullaniciadi");
                    int geciciBakiye;
                    if(kullanici.equals(dosyaIcerigi)){
                        geciciBakiye = resultSet.getInt("bakiye");
                        bakiyeLabel.setText(String.valueOf(geciciBakiye));
                    }
                }
            }catch (SQLException e) {
                e.printStackTrace();
            }
        }
        else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Alışveriş Başarısız...");
            alert.setHeaderText("Yetersiz Bakiye!!!");
            alert.setContentText("Hesabınıza Para Yüklemesi Yapınız...");
            alert.showAndWait();
        }

    }

    public void pastaAl(){

        Pasta pasta = new Pasta(10);

        if(Integer.valueOf(bakiyeLabel.getText()) >= pasta.fiyat)
        {
            int bakiye = Integer.valueOf(bakiyeLabel.getText());
            bakiye -= pasta.fiyat;

            Connection connection = null;
            PreparedStatement psUpdate = null;
            PreparedStatement psSelect = null;
            ResultSet resultSet = null;
            try {
                connection = DriverManager.getConnection("jdbc:mysql://localhost/kullanicilar","root","Solevano12");
                psUpdate = connection.prepareStatement("UPDATE kullanicilar SET bakiye = ? WHERE kullaniciadi = ?");
                psUpdate.setInt(1,bakiye);
                psUpdate.setString(2,dosyaIcerigi);
                psUpdate.execute();
                psSelect = connection.prepareStatement("SELECT kullaniciadi,bakiye FROM kullanicilar");
                resultSet = psSelect.executeQuery();
                while (resultSet.next()){
                    String kullanici = resultSet.getString("kullaniciadi");
                    int geciciBakiye;
                    if(kullanici.equals(dosyaIcerigi)){
                        geciciBakiye = resultSet.getInt("bakiye");
                        bakiyeLabel.setText(String.valueOf(geciciBakiye));
                    }
                }
            }catch (SQLException e) {
                e.printStackTrace();
            }
        }
        else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Alışveriş Başarısız...");
            alert.setHeaderText("Yetersiz Bakiye!!!");
            alert.setContentText("Hesabınıza Para Yüklemesi Yapınız...");
            alert.showAndWait();
        }

    }

    public void dondurmaAl(){

        Dondurma dondurma = new Dondurma(5);

        if(Integer.valueOf(bakiyeLabel.getText()) >= dondurma.fiyat)
        {
            int bakiye = Integer.valueOf(bakiyeLabel.getText());
            bakiye -= dondurma.fiyat;

            Connection connection = null;
            PreparedStatement psUpdate = null;
            PreparedStatement psSelect = null;
            ResultSet resultSet = null;
            try {
                connection = DriverManager.getConnection("jdbc:mysql://localhost/kullanicilar","root","Solevano12");
                psUpdate = connection.prepareStatement("UPDATE kullanicilar SET bakiye = ? WHERE kullaniciadi = ?");
                psUpdate.setInt(1,bakiye);
                psUpdate.setString(2,dosyaIcerigi);
                psUpdate.execute();
                psSelect = connection.prepareStatement("SELECT kullaniciadi,bakiye FROM kullanicilar");
                resultSet = psSelect.executeQuery();
                while (resultSet.next()){
                    String kullanici = resultSet.getString("kullaniciadi");
                    int geciciBakiye;
                    if(kullanici.equals(dosyaIcerigi)){
                        geciciBakiye = resultSet.getInt("bakiye");
                        bakiyeLabel.setText(String.valueOf(geciciBakiye));
                    }
                }
            }catch (SQLException e) {
                e.printStackTrace();
            }
        }
        else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Alışveriş Başarısız...");
            alert.setHeaderText("Yetersiz Bakiye!!!");
            alert.setContentText("Hesabınıza Para Yüklemesi Yapınız...");
            alert.showAndWait();
        }

    }

}
