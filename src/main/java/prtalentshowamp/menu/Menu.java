package prtalentshowamp.menu;

import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import utilidades.UtilidadesES;

public class Menu {
    private static final Logger log = LogManager.getLogger(Menu.class);

    public static final String SALIR = "S";
    OpcionesMenu opcionesMenu;
    UtilidadesES utilidadesES;
    public Menu(OpcionesMenu opcionesMenu, UtilidadesES utilidadesES) {
        this.opcionesMenu = opcionesMenu;
        this.utilidadesES = utilidadesES;
    }

    public void presentaMenu() {
        int indice = 1;
        for (String opcion : opcionesMenu) {
            utilidadesES.mostrarln(indice + " " + opcion);
            indice++;
        }
        utilidadesES.mostrarln(Menu.SALIR + " Salir");

    }

    /**
     * Lee una opción.
     * @param texto Mensaje Que se muestra para leer el dato.
     * @return La opción introducida, como entero.
     * @throws IOException Error de entrada de datos por teclado
     * @throws NumberFormatException nfe Error en formato de dato no numérico
     */
    public String leeOpcMenu(String texto) throws IOException {
        String opc;
        try {
            opc = utilidadesES.pideCadena(texto);
        } catch (IOException e) {
            log.fatal("Error de lectura: ", e);
            throw e;
        }
        return opc;
    }
}
