package Vista;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

import Controlador.RestaurantController;
import Otro.*;

public class RestaurantView extends JFrame implements Runnable {
    JPanel[] jPanels = new JPanel[36];

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
            setTitle("Ventana de pruebas");
            //localización de aparición
            setLocationRelativeTo(null);


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

//Borrar el resto de la vista, pero esto se queda (son los clientes)
            for (int i = 0; i < 36; i++) {
                c.gridx=1+i;
                c.weightx = 1;
                c.weighty = 1;
                c.fill = GridBagConstraints.BOTH;
                Border blackline = BorderFactory.createLineBorder(Color.black);
                jPanels[i] = new JPanel(new GridBagLayout());
                jPanels[i].setBackground(Color.white);
                jPanels[i].setBorder(blackline);
                paneli.add(jPanels[i],c);
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


            JButton buttonPause = new JButton("Pausa");
            c.weightx = 1;
            panelInterior.add(buttonPause, c);


            JButton buttonPlay = new JButton("Pausa");
            c.weightx = 1;
            panelInterior.add(buttonPlay, c);

            JButton buttonStop = new JButton("Stop");
            c.weightx = 1;
            panelInterior.add(buttonStop, c);

            c.weighty = 0;
            panelInterior.add(filler, c);

            return panel;
        }




    @Override
    public void run() {
            controller.getEstadistiques();
        //Utilizado para actualizar los paneles de la vista dependiendo de lo que envíe el controlador en sus estadísticas

    }
}
