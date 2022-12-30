package Vista;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Controlador.RestaurantController;

public class RestaurantView extends JFrame implements Runnable, ActionListener {
    JPanel[] Cocineros = new JPanel[36];
    JPanel[] Clientes = new JPanel[12];
    JButton buttonPause;
    JButton buttonPlay;
    JButton buttonStop;
    JButton buttonStart;
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
        public RestaurantView() {
            this.controller =  controller;
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

            JPanel paneli = new JPanel(new GridBagLayout());
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
//son los chefs
            for (int i = 0; i < 9; i++) {
                c.gridx=1+i;
                c.weightx = 1;
                c.weighty = 0;
                c.fill = GridBagConstraints.BOTH;
                Border blackline = BorderFactory.createLineBorder(Color.black);
                Clientes[i] = new JPanel(new GridBagLayout());
                Clientes[i].setBackground(Color.green);
                Clientes[i].setBorder(blackline);
                paneli.add(Clientes[i],c);
            }
//son los clientes
            for (int i = 0; i < 36; i++) {
                c.gridx=1+i;
                c.weightx = 1;
                c.weighty = 1;
                c.fill = GridBagConstraints.BOTH;
                Border blackline = BorderFactory.createLineBorder(Color.black);
                Cocineros[i] = new JPanel(new GridBagLayout());
                Cocineros[i].setBackground(Color.white);
                Cocineros[i].setBorder(blackline);
                paneli.add(Cocineros[i],c);
            }

            Box.Filler filler2 = new Box.Filler(getMaximumSize(),getMinimumSize(),getPreferredSize());
            c.gridx=37;
            paneli.add(filler2,c);

            pack();
            pans.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
            pans.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

            return pans;
        }


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




    @Override
    public void run() {
            controller.getEstadistiques();

        /*Utilizado para actualizar los paneles de la vista dependiendo de lo que envíe el controlador en sus estadísticas
        y generar cocineros y comensales (sus paneles)*/

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() ==this.buttonPlay) {

            for (int i = 0; i < controller.getRestaurantModel().getCms().size(); i++) {
                controller.getRestaurantModel().getCms().get(i).setPaused(false);

            }
            for (int i = 0; i < controller.getRestaurantModel().getChefs().size(); i++) {
                controller.getRestaurantModel().getChefs().get(i).setPaused(false);

            }
            controller.play();

        }
        //Esto para TODOS los threads del programa = caca TODO (meter condición de pausa en chefs y comensales)
        else if (e.getSource() ==this.buttonPause) {
            for (int i = 0; i < controller.getRestaurantModel().getCms().size(); i++) {
                controller.getRestaurantModel().getCms().get(i).setPaused(true);
            }
            for (int i = 0; i < controller.getRestaurantModel().getChefs().size(); i++) {
                controller.getRestaurantModel().getChefs().get(i).setPaused(true);
            }


        }
        else if (e.getSource() ==this.buttonStop) {
            try {
                controller.getRestaurantModel().stop();
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }

        }
        else if (e.getSource() ==this.buttonStart) { try {
            controller.getRestaurantModel().start();
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }

        }
    }
}
