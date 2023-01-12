package Vista;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Random;
import java.util.ArrayList;

import Controlador.RestaurantController;
import Otro.Estatchef;

public class RestaurantView extends JFrame implements Runnable, ActionListener {
    JLabel[] Cocineros = new JLabel[36];
    JLabel[] Clientes = new JLabel[12];
    JButton buttonPause;
    JButton buttonPlay;
    JButton buttonStop;
    JButton buttonStart;
    JPanel paneli;
    //Vista experimental, clientes y cocineros se deben de generar dinámicamente en el thread
    public RestaurantController getController() {
        return controller;
    }

    public void setController(RestaurantController controller) {
        this.controller = controller;
    }

    public RestaurantController controller;
        private static final long serialVersionUID = -6829833718886341887L;
        //Jframe principal
        public RestaurantView(RestaurantController controller) {
            this.controller = controller;
            setTitle("Ventana de pruebas");
            //localización de aparición
            setLocationRelativeTo(null);

            setSize(600,600);
            //Se trabajará con grid bag layout
            setLayout(new GridBagLayout());
            //Al cerrarse que se termine el proceso
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            //se inicializa el método que añade los paneles
            inicializarComponentes();
            this.setVisible(true);
        }

        private void inicializarComponentes() {
            //este objeto sirve para declarar las restricciones del espacio que ocuparán los componentes por defecto de forma compartida
            GridBagConstraints c = new GridBagConstraints();

            //La pantalla principal
            // ----------- CONSTRAINTS COMUNES -----------------
            //fill determina el tamaño que se quiere del componente si se quiere que se expanda de forma vertical horinzontal o ambos como en este caso
            c.fill = GridBagConstraints.BOTH;
            //cada elemento se genera en el elemento y
            c.weighty = 1;








            // ----------- PANEL DE MENÚ -----------------------
            //el menú
            c.weightx = 0;
            getContentPane().add(generarPanelIzquierdo(), c);

            // ------------ PANEL DERECHO ----------------------
            //el espacio en el que se generará la información
            c.weightx = .1;
            getContentPane().add(paneli(), c);



            // ----------- EMPAQUETAR --------------------------
            //Pack es una forma más sencilla de establecer que el espacio requerido por cada componente sea establecido de forma automática, en preferencia a establecerlo manualmente
            pack();
        }
        private JScrollPane paneli(){

            //////////////////////////////////////////////////////////



            //Se define el nuevo panel izquierdo

            //////////////////////////////////////////////////////////////////////////


            Box.Filler filler = new Box.Filler(getMaximumSize(),getMinimumSize(),getPreferredSize());

            paneli = new JPanel(new GridBagLayout());
            GridBagConstraints c = new GridBagConstraints();
            c.gridy=0;
            c.gridx=0;
            c.weighty=0;
            //Background rojo
            paneli.setBackground(Color.red);
            c.gridy=1;
            c.gridx=0;
            c.weighty=1;


            JScrollPane pans = new JScrollPane(paneli);
            c.gridy=3;
            c.gridx=0;
            c.weighty=2;
            paneli.add(filler,c);


            pack();
            pans.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
            pans.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

            Elementos();
            return pans;
        }
        //Mejorar la forma en la que se pintan los cacharros estos para evitar sobrecarga de recursos
    //implementar en paint


        private JScrollPane generarPanelIzquierdo() {
            //Panel es el espacio en el que se colocarán los elementos
            JPanel panelInterior = new JPanel(new GridBagLayout());
            //El scroll
            JScrollPane panel = new JScrollPane(panelInterior);

            //restricciones
            GridBagConstraints c = new GridBagConstraints();
            //filler es un objeto invisible que sirve para rellenar espacio y así determinar la posición de otros objetos
            Box.Filler filler = new Box.Filler(getMinimumSize(), getPreferredSize(), getMaximumSize());

            JButton[] botones = new JButton[7];

            //el scrollbar aparece verticalmente pero no horizontalmente
            panel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
            panel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

            //en estas dimensiones
            panel.setMinimumSize(new Dimension(130, 200));


            //Color Jpanel
            panelInterior.setBackground(Color.BLUE);


            c.fill = GridBagConstraints.BOTH;
            //margenes
            c.insets = new Insets(5, 10, 5, 20);
            c.gridx = 0;




            buttonPause = new JButton("Pausa");
            c.weightx = 1;
            panelInterior.add(buttonPause, c);
            buttonPause.addActionListener(this);

             buttonPlay = new JButton("Play");
            c.weightx = 1;
            panelInterior.add(buttonPlay, c);
            buttonPlay.addActionListener(this);

            buttonStop = new JButton("Stop");
            c.weightx = 1;
            panelInterior.add(buttonStop, c);
            buttonStop.addActionListener(this);


            buttonStart = new JButton("Start");
            c.weightx = 1;
            panelInterior.add(buttonStart, c);
            buttonStart.addActionListener(this);


            c.weighty = 0;
            panelInterior.add(filler, c);

            return panel;
        }

//implementar paint
public void Elementos(){
    GridBagConstraints c = new GridBagConstraints();
    for (int i = 0; i < controller.getRestaurantModel().getCms().size(); i++) {
        c.gridx=1+i;
        c.weightx = 1;
        c.gridwidth=1;
        c.fill = GridBagConstraints.BOTH;
        ImageIcon cliente=new ImageIcon("src/Imagenes/Clientes/cliente.png");
        Clientes[i] = new JLabel(cliente);
        Clientes[i].setPreferredSize(new Dimension(10,1));
        paneli.add(Clientes[i],c);

    }
//son los clientes
    for (int i = 0; i < controller.getRestaurantModel().getChefs().size(); i++) {
        c.gridx=controller.getRestaurantModel().getCms().size()+1+i;
        c.weightx =1;
        c.gridwidth=1;
        c.fill = GridBagConstraints.BOTH;
        Cocineros[i] = new JLabel(new ImageIcon("src/Imagenes/Cocineros/cocinero.png"));
        Cocineros[i].setPreferredSize(new Dimension(10,1));
        paneli.add(Cocineros[i],c);
    }
    Box.Filler filler2 = new Box.Filler(getMaximumSize(),getMinimumSize(),getPreferredSize());
    c.gridx=37;
    paneli.add(filler2,c);
}


public void Pintar(){



    for (int i = 0; i < controller.getRestaurantModel().getCms().size(); i++) {
            try {
                switch (controller.getRestaurantModel().getCms().get(i).getStatuscm().ordinal()) {
                    case 0:
                        Clientes[i].setIcon((new ImageIcon("src/Imagenes/Clientes/tertuliando.png")));
                        break;
                    case 1:
                        Clientes[i].setIcon((new ImageIcon("src/Imagenes/Clientes/comiendo.png")));
                        break;
                    case 2:
                        Clientes[i].setIcon((new ImageIcon("src/Imagenes/Clientes/recogiendo.png")));
                        break;

                }
            }
            catch (Exception e){

            }
        }
    for (int i = 0; i < controller.getRestaurantModel().getChefs().size(); i++) {

            try {

                switch (controller.getRestaurantModel().getChefs().get(i).getEstatchef().ordinal()) {
                    case 0:
                        Cocineros[i].setIcon((new ImageIcon("src/Imagenes/Cocineros/cocinando.png")));
                        break;
                    case 1:
                        Cocineros[i].setIcon((new ImageIcon("src/Imagenes/Cocineros/descanso.png")));
                        break;
                    case 2:
                        Cocineros[i].setIcon((new ImageIcon("src/Imagenes/Cocineros/entregando.png")));
                        break;

                }


            }
            catch (Exception e){

            }

    }

    repaint();
}





    @Override
    public void paint(Graphics g) {
        super.paint(g);
        //son los chefs
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Pintar();

    }

    @Override
    public void run() {
while (true){
   Pintar();
}

        /*Utilizado para actualizar los paneles de la vista dependiendo de lo que envíe el controlador en sus estadísticas
        y generar cocineros y comensales (sus paneles)*/

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() ==this.buttonPlay) {

            controller.getRestaurantModel().getRl().setPaused(false);

            controller.play();

        }
        else if (e.getSource() ==this.buttonPause) {

            controller.getRestaurantModel().getRl().setPaused(true);

        }
        else if (e.getSource() ==this.buttonStop) {
            controller.stop();

        }
        else if (e.getSource() ==this.buttonStart) { try {

            controller.getRestaurantModel().start();
            Thread thread1 = new Thread(this);
            thread1.start();
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }

        }
    }
}
