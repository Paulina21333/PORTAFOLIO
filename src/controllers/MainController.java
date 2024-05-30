package controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import tools.area;
import tools.Coordinate;
import tools.serietaylor;
import unidad1.riemann.SumasRiemannEjemplo1;

/**
 * FXML Controller class
 *
 * @author FJMP <frajavimopu@gmail.com>
 */
public class MainController implements Initializable {

    // logic data
    SumasRiemannEjemplo1 riemann = new SumasRiemannEjemplo1();
    Coordinate coor = new Coordinate();

    // FXML GUI
    @FXML
    private Label INTEGRAL;

    @FXML
    private Label LABELfuncionp;

    @FXML
    private Label PORPARTES;

    @FXML
    private Label SUSTITUCION;

    @FXML
    private Button btnCalculo;
    
    @FXML
    private Button btnPUNTO;
    
    @FXML
    private TextField txtX;
    
    @FXML
    private TextField txtY;

    @FXML
    private Button btnUnidad1;

    @FXML
    private Button btnUnidad2;

    @FXML
    private Button btnUnidad3;

    @FXML
    private Button btnUnidad4;

    @FXML
    private Pane paneStatus;

    @FXML
    private Label lblStatus;

    @FXML
    private Label lblStatusMini;

    @FXML
    private Pane paneContentCalculo;

    @FXML
    private Button btnCALCULAR;
    
    @FXML
    private TextField txtVX;
    
    @FXML
    private TextField txtN;
    
    @FXML
    private Label LABELtaylor;
    
    @FXML
    private Pane paneContentUnidad1;
    @FXML
    private Canvas canvasUnidad1;

    @FXML
    private Canvas canvasUnidad3;

    @FXML
    private Pane paneContentUnidad2;

    @FXML
    private Pane paneContentUnidad3;

    @FXML
    private Pane paneContentUnidad4;

    modelou2 modelo = new modelou2();
    area areaCalculator = new area();
    serietaylor serietaylor = new serietaylor();
    // data input unidad 1
    @FXML
    private TextField tfRiemann;
    @FXML
    private Button btnRiemann;

    @FXML
    private void handleBtnRiemann(ActionEvent event) {
        int n = 10;
        try {
            n = Integer.parseInt(tfRiemann.getText());
            if (n <= 0) {
                throw new Exception("Solo valores positivos!!!");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            tfRiemann.setText("10");
        }

        riemann.setN(n);
        riemann.calcular();
        updateVistaUnidad1();
    }

    @FXML
    private void handleClicks(ActionEvent event) {
        if (event.getSource() == btnCalculo) {
            lblStatus.setText("Cálculo integral");
            lblStatusMini.setText("/home/calculo");
            paneStatus.setBackground(
                    new Background(
                            new BackgroundFill(
                                    Color.rgb(233, 74, 16),
                                    CornerRadii.EMPTY, Insets.EMPTY)
                    )
            );
            paneContentCalculo.toFront();

        } else if (event.getSource() == btnUnidad1) {
            lblStatus.setText("Unidad 1: Teorema fundamental del cálculo");
            lblStatusMini.setText("/home/unidad1");
            paneStatus.setBackground(
                    new Background(
                            new BackgroundFill(
                                    Color.rgb(11, 90, 119),
                                    CornerRadii.EMPTY, Insets.EMPTY)
                    )
            );

            paneContentUnidad1.toFront();

            updateVistaUnidad1();

        } else if (event.getSource() == btnUnidad2) {
            lblStatus.setText("Unidad 2: Métodos de integración");
            lblStatusMini.setText("/home/unidad2");
            paneStatus.setBackground(
                    new Background(
                            new BackgroundFill(
                                    Color.rgb(196, 170, 253),
                                    CornerRadii.EMPTY, Insets.EMPTY)
                    )
            );
            updatevistaunidad2();
            paneContentUnidad2.toFront();
        } else if (event.getSource() == btnUnidad3) {
            lblStatus.setText("Unidad 3: Aplicaciones de integración");
            lblStatusMini.setText("/home/unidad3");
            updatevistaunidad2();
            paneStatus.setBackground(
                    new Background(
                            new BackgroundFill(
                                    Color.rgb(253, 170, 196),
                                    CornerRadii.EMPTY, Insets.EMPTY)
                    )
            );
            updatevistaunidad3();
            paneContentUnidad3.toFront();
        } else if (event.getSource() == btnUnidad4) {
            lblStatus.setText("Unidad 4: Series");
            lblStatusMini.setText("/home/unidad4");
            paneStatus.setBackground(
                    new Background(
                            new BackgroundFill(
                                    Color.rgb(127, 127, 127),
                                    CornerRadii.EMPTY, Insets.EMPTY)
                    )
            );
            updatevistaunidad4();
            paneContentUnidad4.toFront();
        }
    }

    @FXML
    private void handleBtnDrawRiemann(ActionEvent event) {

    }
    
     @FXML
private void btnCALCULAR(ActionEvent event) {
try {
        
        double X = Double.parseDouble(txtVX.getText());
        int N = Integer.parseInt(txtN.getText());
        
       
        double resultado = serietaylor.taylor(X, N);
        
        LABELtaylor.setText(String.valueOf(resultado));
    } catch (NumberFormatException e) {
        System.out.println("Por favor, ingrese valores válidos para X y N.");
    }
}

    @FXML
private void btnPUNTO(ActionEvent event) {
  try {
        double x = Double.parseDouble(txtX.getText());
        double y = Double.parseDouble(txtY.getText());

        GraphicsContext gc = canvasUnidad3.getGraphicsContext2D();

        // Dibujar el punto en las coordenadas especificadas por el usuario con el nuevo color
        gc.setFill(Color.RED); // Cambiar el color del punto
        gc.fillOval(coor.toScreenX(x) - 2, coor.toScreenY(y) - 2, 4, 4);

    } catch (NumberFormatException e) {
        System.out.println("Por favor, ingrese números válidos para las coordenadas X y Y.");
        updatevistaunidad3();
    }
}
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    private void updateVistaUnidad1() {
        GraphicsContext canva = canvasUnidad1.getGraphicsContext2D();

        // parameters to plot
        int width = 350;
        int height = 350;
        int lineWidth = 3;
        int lineWidthPlot = 1;

        // configure coordinates REAL to SCREEN transformation
        coor.setXMIN(-1);
        coor.setXMAX(20);
        coor.setYMIN(-1);
        coor.setYMAX(200);
        coor.setWIDTH(width);
        coor.setHEIGHT(height);

        // draw plot region
        //canva.setFill(Color.valueOf("#ffffff"));
        canva.setFill(Color.MEDIUMORCHID);
        canva.fillRect(0, 0, width, height);

        canva.setStroke(Color.AZURE);
        canva.setLineWidth(lineWidth);
        canva.strokeRect(0, 0, width, height);

        // draw axis
        canva.setLineWidth(lineWidthPlot);
        canva.strokeLine(
                coor.toScreenX(coor.getXMIN()), coor.toScreenY(0),
                coor.toScreenX(coor.getXMAX()), coor.toScreenY(0)
        );
        canva.strokeLine(
                coor.toScreenX(0), coor.toScreenY(coor.getYMIN()),
                coor.toScreenX(0), coor.toScreenY(coor.getYMAX())
        );

        // compute data
        riemann.calcular();
        riemann.print();
        double x[] = riemann.getX();
        double fw[] = riemann.getFw();

        // plot function
        canva.setStroke(Color.WHITE);
        canva.beginPath();
        canva.moveTo(coor.toScreenX(x[0]), coor.toScreenY(fw[0]));

        for (int i = 1; i < x.length; i++) {
            canva.lineTo(coor.toScreenX(x[i]), coor.toScreenY(fw[i]));
        }
        canva.stroke();

        // add text Area
        canva.strokeText("Suma Riemann: " + riemann.getSuma(),
                width / 2, 50);

        // plot rectangles
        canva.setStroke(Color.BLUE);
        for (int i = 0; i < fw.length - 1; i++) {
            //line vertical
            canva.strokeLine(
                    coor.toScreenX(x[i]), coor.toScreenY(0),
                    coor.toScreenX(x[i]), coor.toScreenY(fw[i])
            );
            //line horizontal
            canva.strokeLine(
                    coor.toScreenX(x[i]), coor.toScreenY(fw[i]),
                    coor.toScreenX(x[i + 1]), coor.toScreenY(fw[i])
            );
        }
        //line vertical
        canva.strokeLine(
                coor.toScreenX(x[fw.length - 1]), coor.toScreenY(0),
                coor.toScreenX(x[fw.length - 1]), coor.toScreenY(fw[fw.length - 1])
        );

        //canva.setStroke(Color.valueOf("#0000ff"));
        //canva.strokeRect(100, 50, 200, 200);               
    }

    private void updatevistaunidad2() {
        LABELfuncionp.setText(modelo.funcionpolinominal());
        INTEGRAL.setText(modelo.integrallogaritmo());
        PORPARTES.setText(modelo.porpartes());
        SUSTITUCION.setText(modelo.sustitucion());
    }

    private void updatevistaunidad3() {
         GraphicsContext canvas = canvasUnidad3.getGraphicsContext2D();

    
    int width = 350;
    int height = 350;

    
    coor.setXMIN(0);
    coor.setXMAX(20);
    coor.setYMIN(0);
    coor.setYMAX(200);
    coor.setWIDTH(width);
    coor.setHEIGHT(height);

    
    canvas.setFill(Color.WHITE);
    canvas.fillRect(0, 0, width, height);

    
    canvas.setStroke(Color.AZURE);
    canvas.setLineWidth(3);
    canvas.strokeLine(coor.toScreenX(coor.getXMIN()), coor.toScreenY(0),
                      coor.toScreenX(coor.getXMAX()), coor.toScreenY(0));
    canvas.strokeLine(coor.toScreenX(0), coor.toScreenY(coor.getYMIN()),
                      coor.toScreenX(0), coor.toScreenY(coor.getYMAX()));

    
    int numPoints = 100; 
    double[] x = new double[numPoints];
    double[] y = new double[numPoints];
    double step = (coor.getXMAX() - coor.getXMIN()) / numPoints;
    for (int i = 0; i < numPoints; i++) {
        x[i] = coor.getXMIN() + i * step;
        y[i] = x[i] * x[i];
       
        canvas.setFill(Color.BLACK);
        canvas.fillOval(coor.toScreenX(x[i]) - 2, coor.toScreenY(y[i]) - 2, 4, 4);
    }

    }
    private void updatevistaunidad4() {
        try {
        
        double X= Double.parseDouble(txtVX.getText());
        int N = Integer.parseInt(txtN.getText());
        
        
        double resultado = serietaylor.taylor(X, N);
        
        
        LABELtaylor.setText(String.valueOf(resultado));
    } catch (NumberFormatException e) {
        
        System.out.println("Por favor, ingrese valores válidos para X y N.");
    }
    }
}
