package sample;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

import java.util.Random;

public class Controller {
    @FXML HBox contenedor;
    @FXML AnchorPane padre;
    String[] palabras={"PELOTA","MICROFONO","LIBRO","CUCHARA","SALSA", "CHICHARRON","MOUSE"};
    TextField[] arrayTxt=null;
    int correcto=0;
    int incorrecto=0;

    @FXML protected void initialize(){
        Random random=new Random();
        int aleatorio=random.nextInt(6);
        String palabra=palabras[aleatorio].toLowerCase();
        System.out.println(palabra);
        arrayTxt=new TextField[palabra.length()];
        int ayuda=1;//letras de ayuda

        for (int x=0;x<palabra.length();x++){
            arrayTxt[x]=new TextField();
            arrayTxt[x].setPrefWidth(50);
            arrayTxt[x].setPrefHeight(50);
            arrayTxt[x].setId("txt-"+x+"-"+palabra.charAt(x));
            arrayTxt[x].setOnKeyReleased(new EventHandler<KeyEvent>() {
                @Override
                public void handle(KeyEvent event) {
                    TextField textField=(TextField) event.getTarget();
                    String[] nombre=textField.getId().split("-");
                    System.out.println(nombre[2]);
                    if(nombre[2].equals(textField.getText().toLowerCase())) {
                        System.out.println("CORRECTO "+textField.getId());
                        textField.setDisable(true);
                        correcto++;
                        if (correcto==palabra.length())victoria();
                    }else {
                        System.out.println("INCORRECTO "+textField.getId());
                        textField.setText("");
                        incorrecto++;
                        if (incorrecto==1){
                            pintarCabeza();
                        }else if(incorrecto==2){
                            pintarCuerpo();
                        }else if(incorrecto==3){
                            pintarBrazo1();
                        }else if(incorrecto==4){
                            pintarBrazo2();
                        }else if(incorrecto==5){
                            pintarPierna1();
                        }else if(incorrecto==6){
                            pintarPierna2();
                            textField.setDisable(true);
                            derrota();
                        }
                        //pintarCuerpo();
                    }
                    //System.out.println("asd");
                }
            });
            contenedor.getChildren().add( arrayTxt[x]);
        }
    }
    public  void pintarCabeza() {
        ImageView cabeza = new ImageView(new Image("sample/img/cabeza.png"));
        cabeza.setFitWidth(70);
        cabeza.setFitHeight(70);
        cabeza.setLayoutX(200);
        cabeza.setLayoutY(200);
        padre.getChildren().addAll(cabeza);
    }
    public  void pintarCuerpo() {
        ImageView cuerpo = new ImageView(new Image("sample/img/cuerpo.png"));
        cuerpo.setFitWidth(70);
        cuerpo.setFitHeight(70);
        cuerpo.setLayoutX(205);
        cuerpo.setLayoutY(270);
        padre.getChildren().addAll(cuerpo);
    }
    public  void pintarBrazo1() {
        ImageView brazo1=new ImageView(new Image("sample/img/brazo1.png"));
        brazo1.setFitWidth(70);
        brazo1.setFitHeight(70);
        brazo1.setLayoutX(140);
        brazo1.setLayoutY(270);
        padre.getChildren().addAll(brazo1);
        }
    public  void pintarBrazo2() {
        ImageView brazo2 = new ImageView(new Image("sample/img/brazo2.png"));
        brazo2.setFitWidth(70);
        brazo2.setFitHeight(70);
        brazo2.setLayoutX(270);
        brazo2.setLayoutY(270);
        padre.getChildren().addAll(brazo2);
    }
    public  void pintarPierna1() {
        ImageView pierna1 = new ImageView(new Image("sample/img/pierna1.png"));
        pierna1.setFitWidth(70);
        pierna1.setFitHeight(70);
        pierna1.setLayoutX(180);
        pierna1.setLayoutY(330);
        padre.getChildren().addAll(pierna1);
    }
    public  void pintarPierna2(){
        ImageView pierna2=new ImageView(new Image("sample/img/pierna2.png"));
        pierna2.setFitWidth(70);
        pierna2.setFitHeight(70);
        pierna2.setLayoutX(230);
        pierna2.setLayoutY(330);
        padre.getChildren().addAll(pierna2);
    }
    public  void victoria(){
        ImageView victoria=new ImageView(new Image("sample/img/winer.png"));
        victoria.setFitWidth(500);
        victoria.setFitHeight(300);
        victoria.setLayoutX(0);
        victoria.setLayoutY(10);
        padre.getChildren().addAll(victoria);
    }
    public  void derrota(){
        ImageView derrota=new ImageView(new Image("sample/img/loser.gif"));

        derrota.setFitWidth(300);
        derrota.setFitHeight(125);
        derrota.setLayoutX(109);
        derrota.setLayoutY(20);
        padre.getChildren().addAll(derrota);
    }
}
