package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class Controller {
    @FXML Canvas lienzo;
    GraphicsContext context;
    @FXML ColorPicker colorPicker;
    @FXML ComboBox comboOpciones;
    @FXML Slider slider;
    Color colorPincel=Color.BLACK;

    @FXML protected void initialize(){
        context=lienzo.getGraphicsContext2D();
        slider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                pintarDibujos(newValue.intValue());
            }
        });
        comboOpciones.getItems().addAll("cuadricula","Ajedrez","Estrella","Estrella doble");
       /*
        context.setFill(Color.BLUE);
        context.fillRect(10,20,100,50);
        context.setFill(Color.RED);
        context.strokeRect(200,150,200,100);
        context.strokeRect(400,250,200,100);
        context.setFill(Color.GREEN);
        context.fillOval(375,375,50,50);
        context.strokeLine(50,50,lienzo.getWidth()-50,lienzo.getHeight()-50);*/

    }
    public void pintarDibujos (int valor){
        context.setFill(Color.WHITESMOKE);
        context.fillRect(0,0,lienzo.getWidth(),lienzo.getHeight());
        context.setFill(colorPincel);
        System.out.println(valor);
        if(comboOpciones.getSelectionModel().getSelectedIndex()==0){
            //Cuadricula
            for(int x=1;x<valor;x++){
                int  divisiones=(int) lienzo.getWidth()/valor;
                context.strokeLine(0,divisiones*x, lienzo.getWidth(),divisiones*x);//linea horizontal
                context.strokeLine(divisiones*x,0,divisiones*x, lienzo.getWidth());//linea vertical
            }
        }else if(comboOpciones.getSelectionModel().getSelectedIndex()==1) {
            //Ajedrez
            context.fillRect(0,0,lienzo.getWidth(),lienzo.getHeight());
            int cuadros=2*valor;
            for(int x=0;x<=lienzo.getWidth();x+=cuadros){
                for(int y=0;y<=lienzo.getWidth();y+=cuadros){
                    context.clearRect(x,y,valor,valor);
                }
            }
            for(int x=valor;x<=lienzo.getWidth();x+=cuadros){
                for(int y=valor;y<=lienzo.getWidth();y+=cuadros){
                    context.clearRect(x, y, valor, valor);
                }
            }
        }else if(comboOpciones.getSelectionModel().getSelectedIndex()==2) {
            //Estrella
            int mitadAncho=((int)lienzo.getWidth())/2;
            int mitadAlto=((int)lienzo.getHeight())/2;
            context.strokeLine(mitadAncho, 0,mitadAncho,lienzo.getHeight());
            context.strokeLine(0, mitadAlto,lienzo.getWidth(),mitadAlto);
            int divisiones=mitadAncho/valor;
            for(int j=1;j<valor+1;j++){
                context.strokeLine(mitadAncho,divisiones*j,mitadAncho+(divisiones*j),mitadAlto);
                context.strokeLine(mitadAncho,divisiones*j,mitadAncho-(divisiones*j),mitadAlto);
                context.strokeLine(mitadAncho,lienzo.getHeight()-(divisiones*j),
                        mitadAncho-(divisiones*j),mitadAlto);
                context.strokeLine(mitadAncho,lienzo.getHeight()-(divisiones*j),
                        mitadAncho+(divisiones*j),mitadAlto);
                   /*mal
                context.strokeLine(mitadAncho,divisiones*j*2,mitadAncho+(divisiones*j),mitadAlto);
                context.strokeLine(mitadAncho,divisiones*j*2,mitadAncho-(divisiones*j),mitadAlto);
                */

            }

        }else if(comboOpciones.getSelectionModel().getSelectedIndex()==3){
            //Estrella doble
            int mitadAncho=((int)lienzo.getWidth())/2;
            int mitadAlto=((int)lienzo.getHeight())/2;
            context.strokeLine(mitadAncho, 0,mitadAncho,lienzo.getHeight());
            context.strokeLine(0, mitadAlto,lienzo.getWidth(),mitadAlto);
            int divisiones=mitadAncho/valor;
            for(int j=1;j<valor+1;j++) {
                //Estrella1
                context.strokeLine(mitadAncho, divisiones * j, mitadAncho + (divisiones * j), mitadAlto);
                context.strokeLine(mitadAncho, divisiones * j, mitadAncho - (divisiones * j), mitadAlto);
                context.strokeLine(mitadAncho, lienzo.getHeight() - (divisiones * j),
                        mitadAncho - (divisiones * j), mitadAlto);
                context.strokeLine(mitadAncho, lienzo.getHeight() - (divisiones * j),
                        mitadAncho + (divisiones * j), mitadAlto);
                //Estrella2
                context.strokeLine(divisiones*j,divisiones*j,
                        mitadAncho+(divisiones*j),mitadAlto-(divisiones*j));
                context.strokeLine(divisiones*j,divisiones*j,
                        mitadAncho-(divisiones*j),mitadAlto+(divisiones*j));
                context.strokeLine(lienzo.getWidth()-(divisiones*j),lienzo.getHeight()-divisiones*j,
                        mitadAncho+(divisiones*j),mitadAlto-(divisiones*j));
                context.strokeLine(lienzo.getWidth()-(divisiones*j),lienzo.getHeight()-divisiones*j,
                        mitadAncho-(divisiones*j),mitadAlto+(divisiones*j));
            }
        }//y lo demas ya no se pudo:c
    }
    public void cambiarColor(ActionEvent event){
        colorPincel=colorPicker.getValue();
    }
    public void borrar(ActionEvent event){
        context.setFill(Color.WHITESMOKE);
       context.fillRect(0,0,lienzo.getWidth(),lienzo.getHeight());

    }
    public void  arrastrar(MouseEvent event){
        context.setFill(colorPincel);
        context.fillOval(event.getX(),event.getY(),10,10);
    }
}
