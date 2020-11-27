/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acomprin;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import Domain.*;
import datos.Conexion;
import java.sql.Connection;
import datos.*;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author antonio
 */
public class Acomprin {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException, SQLException {

        Connection conexion = null;
        Scanner teclado = new Scanner(System.in);

        // variables
        int opcion = 0;
        boolean salir = false;

        // menu
        while (!salir) {
            menu();
            opcion = teclado.nextInt();
            teclado.nextLine();
            switch (opcion) {
                case 1:
                    insertarwallet();
                    break;
                case 2:
                    selecwallet();
                    break;

                case 3:
                    recargarwallet();

                    break;
                case 4:
                    insertarProducto();
                    break;
                case 5:
                    selecproducto();
                    break;

                case 6:
                    compraproducto();
                    break;

                case 7:
                    devolucion();
                    break;

                case 8:
                    canjearpuntos();
                    break;
                case 9:
                    selectcompra();
                    break;
                case 10:
                    selectdevolucion();
                    break;
                case 11:
                    salir = true;
                    System.out.println("adios ");
                    break;
            }

        }

    }

    public static void menu() {
        System.out.println("1.- Agregar cliente a wallet");
        System.out.println("2.- Consultar wallet");
        System.out.println("3.- Recargar wallet");
        System.out.println("4.- Insertar producto");
        System.out.println("5.- Select producto");
        System.out.println("6.- Comprar producto");
        System.out.println("7.- Devolver producto");
        System.out.println("8.- Canjear puntos");
        System.out.println("9.- Consulta compras");
        System.out.println("10.- Consulta devolucion");
        System.out.println("11-salir");
    }

    public static Date fechaintroducir() throws ParseException {
        Scanner teclado = new Scanner(System.in);
        String dateInString = "";
        // Usaremos el formato de fecha que necesitemos
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        dateInString = teclado.nextLine();

        // crear el objeto de tipo Date
        Date fecha = sdf.parse(dateInString);
        System.out.println(fecha);
        return fecha;

    }

    public static void insertarwallet() throws SQLException, ParseException {
        Connection conexion = null;
        Scanner teclado = new Scanner(System.in);
        String nombre = "";
        String apellidos = "";
        String fechanacimiento;
        String dni = "";
        String email = "";

        try {

            Ewallet nuevawallet = new Ewallet();
            conexion = Conexion.getConnection();

            if (conexion.getAutoCommit()) {
                conexion.setAutoCommit(false);
            }
            EwalletDAO walletdao = new EwalletDAO(conexion);
            System.out.println("introduce nombre");
            nombre = teclado.nextLine();
            System.out.println("introduce apellido");
            apellidos = teclado.nextLine();
            System.out.println("dni");
            dni = teclado.nextLine();
            System.out.println("introduce fechanacimiento - yyyy-MM-dd");
            fechanacimiento = teclado.nextLine();

            //comprobamos si es mayor de 18
            DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate fechaNac = LocalDate.parse(fechanacimiento, fmt);
            LocalDate ahora = LocalDate.now();
            Period periodo = Period.between(fechaNac, ahora);
            System.out.printf("Tu edad es: %s años", periodo.getYears());
            if (periodo.getYears() < 18) {
                System.out.println("lo siento eres menor de edad");
                return;
            }
            // Usaremos el formato de fecha que necesitemos
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            // crear el objeto de tipo Date
            Date fecha = sdf.parse(fechanacimiento);
            System.out.println();
            System.out.println("email");
            email = teclado.nextLine();
            //fecha sql
            java.sql.Date fechasql = new java.sql.Date(fecha.getTime());
            nuevawallet = new Ewallet(nombre, apellidos, dni, fechasql, email, 0, 0);
            walletdao.insertarwallet(nuevawallet);
            System.out.println();
            conexion.commit();
            System.out.println("e ha hecho commit de la transaccion");

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.out.println("entramos al rollback");
            try {
                conexion.rollback();
            } catch (SQLException ex1) {
                ex1.printStackTrace(System.out);
            }
        }
    }

    public static void selecwallet() throws SQLException, ParseException {
        Connection conexion = null;
        try {
            conexion = Conexion.getConnection();
            if (conexion.getAutoCommit()) {
                conexion.setAutoCommit(false);
            }
            //recorro la lista para sacartodos los ewallet introducidos
            EwalletDAO walletdao = new EwalletDAO(conexion);
            List<Ewallet> walletlista = walletdao.seleccionarwallet();
            walletlista.forEach(Ewallet -> {
                System.out.println("ewallet = " + Ewallet);
            });

            conexion.commit();
            System.out.println("e ha hecho commit de la transaccion");

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.out.println("entramos al rollback");
            try {
                conexion.rollback();
            } catch (SQLException ex1) {
                ex1.printStackTrace(System.out);
            }
        }
    }

    //2.	El cliente sólo puede hacer una recarga de saldo en euros entre el día 1 y 5 de cada mes. 
    public static void recargarwallet() throws SQLException, ParseException {
        Connection conexion = null;
        Scanner teclado = new Scanner(System.in);
        java.util.Date fechaactual = new Date();
        System.out.println("lo siento solo podras recargar del 1 al 5");
        // if (fechaactual.getTime() > 1 & fechaactual.getTime() < 5) {
        try {

            conexion = Conexion.getConnection();

            if (conexion.getAutoCommit()) {
                conexion.setAutoCommit(false);
            }
            //recorro la lista para sacartodos los ewallet introducidos
            EwalletDAO walletdao = new EwalletDAO(conexion);
            List<Ewallet> ewalletlista = walletdao.seleccionarwallet();
            ewalletlista.forEach(Ewallet -> {
                System.out.println("ewallet = " + Ewallet.toString());
            });

            System.out.println("selecciona cliente ewallet");
            int idwallet = teclado.nextInt();

            //comprueba si existe el cliente wallet y me quedo con su id
            boolean idexiste = false;
            int idcomprueba = 0;
            int cantidadrecargar = 0;
            for (Ewallet aux : ewalletlista) {
                idcomprueba = aux.getIdwallet();

                if (aux.getIdwallet() == idwallet) {
                    idexiste = true;
                    System.out.println(aux.toString());
                    System.out.println("introduce la cantidad a recargar");
                    cantidadrecargar = teclado.nextInt();
                    aux.setSaldoeuros(cantidadrecargar);
                    walletdao.actualizarwallet(aux);
                    break;
                }

            }
            conexion.commit();
            System.out.println("se ha hecho commit de la transaccion");

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.out.println("entramos al rollback");
            try {
                conexion.rollback();
            } catch (SQLException ex1) {
                ex1.printStackTrace(System.out);
            }
        }
        // }

    }

    public static void insertarProducto() throws SQLException, ParseException {
        Connection conexion = null;
        Scanner teclado = new Scanner(System.in);

        try {

            Producto productonuevo = new Producto();
            conexion = Conexion.getConnection();

            if (conexion.getAutoCommit()) {
                conexion.setAutoCommit(false);
            }
            ProductoDAO productodao = new ProductoDAO(conexion);
            System.out.println("introduce nombre producto");
            String nombre = teclado.nextLine();
            System.out.println("introduce precio prodcuto");
            int precioproducto = teclado.nextInt();
            System.out.println("puntos producto");
            int puntosproducto = teclado.nextInt();
            productonuevo = new Producto(nombre, precioproducto, puntosproducto);
            productodao.insertarproducto(productonuevo);
            conexion.commit();
            System.out.println("e ha hecho commit de la transaccion");

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.out.println("entramos al rollback");
            try {
                conexion.rollback();
            } catch (SQLException ex1) {
                ex1.printStackTrace(System.out);
            }
        }
    }

    public static void selecproducto() throws SQLException, ParseException {
        Connection conexion = null;
        Scanner teclado = new Scanner(System.in);

        try {

            conexion = Conexion.getConnection();

            if (conexion.getAutoCommit()) {
                conexion.setAutoCommit(false);
            }
            //recorro la lista para sacartodos los ewallet introducidos
            ProductoDAO productodao = new ProductoDAO(conexion);
            List<Producto> productoslistas = productodao.seleccionarproducto();
            productoslistas.forEach(Producto -> {
                System.out.println("ewallet = " + Producto);
            });
            conexion.commit();
            System.out.println("e ha hecho commit de la transaccion");

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.out.println("entramos al rollback");
            try {
                conexion.rollback();
            } catch (SQLException ex1) {
                ex1.printStackTrace(System.out);
            }
        }
    }

    public static void compraproducto() throws SQLException, ParseException {
        Connection conexion = null;
        Scanner teclado = new Scanner(System.in);

        try {

            conexion = Conexion.getConnection();

            if (conexion.getAutoCommit()) {
                conexion.setAutoCommit(false);
            }
            //recorro la lista para sacartodos los ewallet introducidos
            ProductoDAO productodao = new ProductoDAO(conexion);
            List<Producto> productoslistas = productodao.seleccionarproducto();
            productoslistas.forEach(Producto -> {
                System.out.println("Productos = " + Producto);
            });
            System.out.println("---------------------------EWALLET----------------------");

            //recorro la lista para sacartodos los ewallet introducidos
            EwalletDAO walletdao = new EwalletDAO(conexion);
            List<Ewallet> ewalletlista = walletdao.seleccionarwallet();
            ewalletlista.forEach(Ewallet -> {
                System.out.println("ewallet = " + Ewallet.toString());
            });
            System.out.println("selecciona cliente ewallet");
            int idwallet = teclado.nextInt();
            teclado.nextLine();
            //variables
            int idcomprueba = 0;
            int saldoeuroswallet = 0;
            int puntoswallet = 0;
         
            Ewallet get1 = null;
            for (int i = 0; i < ewalletlista.size(); i++) {

                if (idwallet == ewalletlista.get(i).getIdwallet()) {
                    //
                    get1 = ewalletlista.get(i);
                    System.out.println(get1.toString());
                }

            }
            saldoeuroswallet = get1.getSaldoeuros();
            puntoswallet = get1.getSaldopuntos();

            //producto
            System.out.println("selecciona producto");
            int idproducto = teclado.nextInt();

            //compruebo datos del productos
            int eurosproducto = 0;
            int puntosproducto = 0;

            Producto getpro = null;
            for (int i = 0; i < productoslistas.size(); i++) {

                if (idproducto == productoslistas.get(i).getIdproducto()) {
                    getpro = productoslistas.get(i);
                    System.out.println(getpro.toString());

                }

            }
            eurosproducto = getpro.getPrecioproducto();
            puntoswallet = getpro.getPuntosproducto();

            System.out.println("euroswallet " + saldoeuroswallet);
            System.out.println("eeuroproducto " + eurosproducto);
            System.out.println("puntosrpoducto " + puntosproducto);
            System.out.println("puntoswallet " + puntoswallet);
            //resto el saldoprecio y puntossaldo 
            int resultadoeuros = saldoeuroswallet - eurosproducto;
            System.out.println("resultado euros" + resultadoeuros);

            int resultadopuntos = puntoswallet + puntosproducto;
            System.out.println("resultado puntos" + resultadopuntos);

            //si saldoeuros es mejor que preciodel producto no hace la operacion
            if (saldoeuroswallet < eurosproducto) {
                System.out.println("no tiene  saldo suficiente para la compra");

            } else {
                //resto el el precioproducto al saldoeuroswallet
                get1.setSaldoeuros(resultadoeuros);
                get1.setSaldopuntos(resultadopuntos);
                walletdao.actualizarwallet(get1);
                //fecha java
                java.util.Date fecha = new Date();
                //paso fechajava a fecha sql
                java.sql.Date sqlfecha = new java.sql.Date(fecha.getTime());
                //inserto compra
                CompraDAO compradao = new CompraDAO(conexion);
                Compra nuevacompra = new Compra(idcomprueba, sqlfecha, idwallet, idproducto);
                compradao.insertarcompra(nuevacompra);
                conexion.commit();
                System.out.println("e ha hecho commit de la transaccion");
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.out.println("entramos al rollback");
            try {
                conexion.rollback();
            } catch (SQLException ex1) {
                ex1.printStackTrace(System.out);
            }
        }
    }

    public static void devolucion() {

        Connection conexion = null;
        Scanner teclado = new Scanner(System.in);
        //variales
        int comprueba = 0;
        int compruebapro = 0;
        int compruebacom = 0;

        try {

            Devolucion nuevadevolucion = new Devolucion();
            conexion = Conexion.getConnection();

            if (conexion.getAutoCommit()) {
                conexion.setAutoCommit(false);
            }
            //recorro la lista para sacar todos los datos necesarios de  ewallet 
            EwalletDAO walletdao = new EwalletDAO(conexion);
            List<Ewallet> walletlista = walletdao.seleccionarwallet();
            //recorro la lista para sacar todos los datos necesarios de los compra 
            CompraDAO compradao = new CompraDAO(conexion);
            List<Compra> compralistas = compradao.seleccionarcompra();
            //recorro la lista para sacar todos los datos necesarios de devolucion
            DevolucionDAO devoluciondao = new DevolucionDAO(conexion);
            List<Devolucion> devolucionlista = devoluciondao.seleccionardevolucion();
            //recorro la lista para sacar todos los datos necesarios de producto
            ProductoDAO productodao = new ProductoDAO(conexion);
            List<Producto> productoslistas = productodao.seleccionarproducto();

         
            compralistas.forEach(Compra -> {
                System.out.println("compra = " + Compra);
            });
            //variable para sacar la compra especifica
            int id = 0;
            System.out.println("Que compra quieres devolver");
            int compra = teclado.nextInt();
            System.out.println("Compra Selecionada");
            System.out.println("Producto de la compra");
            Compra getcompra = null;
            for (int i = 0; i < compralistas.size(); i++) {
                if (compra == compralistas.get(i).getIdcompra()) {
                    //guardo la posicon del producto sleccionado
                    getcompra = compralistas.get(i);
                    //idproducto = compralistas.get(i).getIdproducto();
                    id = compralistas.get(i).getIdwallet();
                    //muestra el cliente

                    System.out.println(getcompra.toString());
                }

            }
            //saca sus las id de compra
            int idproducto = getcompra.getIdproducto();
             id = getcompra.getIdwallet();

            System.out.println(idproducto);
            int precioproducto = 0;
            int puntosproducto = 0;
            int idpro = 0;
            Producto getpro = null;
            for (int i = 0; i < productoslistas.size(); i++) {

                if (idproducto == productoslistas.get(i).getIdproducto()) {
                    getpro = productoslistas.get(i);
                   System.out.println(getpro.toString());
                }
                
            }
            precioproducto = getpro.getPrecioproducto();
            puntosproducto = getpro.getPuntosproducto();
            System.out.println("puntosproducto" + puntosproducto);
            System.out.println("precioproducto" + precioproducto);
            
            int euroswallet =0;
            int puntoswallet =0;
            Ewallet getwallet = null;
            for(int i=0; i< walletlista.size(); i++ ){
                if(id ==  walletlista.get(i).getIdwallet()){
                    //guardo la lista
                    getwallet = walletlista.get(i);
                    System.out.println(getwallet.toString());
                }
            }
            
            euroswallet = getwallet.getSaldoeuros();
            puntoswallet = getwallet.getSaldopuntos();
            System.out.println("euroswallet" + euroswallet);
            System.out.println("puntoswallet" + puntoswallet);
//       
//           
          
         
          
            int resultadoeuros = precioproducto + euroswallet;
            int resultadopuntos = puntosproducto + puntoswallet;
            getwallet.setSaldoeuros(resultadoeuros);
            getwallet.setSaldopuntos(resultadopuntos);
            walletdao.actualizarwallet(getwallet);
            //fecha java
            java.util.Date fecha = new Date();
            //paso fechajava a fecha sql
            java.sql.Date sqlfecha = new java.sql.Date(fecha.getTime());
            //inserto devolucion
            Devolucion nuevadevo = new Devolucion(sqlfecha,getwallet.getIdwallet(), getpro.getIdproducto());
            devoluciondao.insertardevolucion(nuevadevo);
            //eliminio compra
           // Compra eliminocompra = new Compra(getcompra.getIdcompra());
            compradao.borrarcompra(getcompra);

            conexion.commit();
            System.out.println("se ha hecho commit de la transaccion");
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.out.println("entramos al rollback");
            try {
                conexion.rollback();
            } catch (SQLException ex1) {
                ex1.printStackTrace(System.out);
            }
        }
    }

    public static void canjearpuntos() {
        Connection conexion = null;
        Scanner teclado = new Scanner(System.in);

        try {

            conexion = Conexion.getConnection();

            if (conexion.getAutoCommit()) {
                conexion.setAutoCommit(false);
            }
            //recorro la lista para sacartodos los ewallet introducidos
            ProductoDAO productodao = new ProductoDAO(conexion);
            List<Producto> productoslistas = productodao.seleccionarproducto();
            productoslistas.forEach(Producto -> {
                System.out.println("Productos = " + Producto);
            });
            System.out.println("---------------------------EWALLET----------------------");

            //recorro la lista para sacartodos los ewallet introducidos
            EwalletDAO walletdao = new EwalletDAO(conexion);
            List<Ewallet> ewalletlista = walletdao.seleccionarwallet();
            ewalletlista.forEach(Ewallet -> {
                System.out.println("ewallet = " + Ewallet.toString());
            });
            System.out.println("selecciona cliente ewallet");
            int idwallet = teclado.nextInt();

            int idcomprueba = 0;

            int puntoswallet = 0;

            Ewallet walletaux = null;
            for (Ewallet aux : ewalletlista) {
                idcomprueba = aux.getIdwallet();

                puntoswallet = aux.getSaldopuntos();
                //si existe y meguarda los valores y sale con el break;
                if (idcomprueba == idwallet) {
                    //guardopuntos wallet
                    puntoswallet = aux.getSaldopuntos();
                    //comprobar si es menos es correcto
                    walletaux = ewalletlista.get(idwallet - 1);
                    System.out.println(aux.toString());

                    break;
                }

            }

            //producto
            System.out.println("selecciona producto");
            int idproducto = teclado.nextInt();

            //compruebo datos del productos
            int auxpro;
            Producto auxiliar;

            int puntosproducto = 0;
            int eurosproducto = 0;
            for (Producto aux : productoslistas) {
                auxpro = aux.getIdproducto();
                if (aux.getIdproducto() == idproducto) {
                    //guardo puntos productos
                    puntosproducto = aux.getPuntosproducto();
                    eurosproducto = aux.getPrecioproducto();
                    System.out.println(aux.toString());

                }
            }

            System.out.println("puntoswallet " + puntoswallet);
            System.out.println("puntospoducto " + puntosproducto);
            System.out.println("euros productos " + eurosproducto);

            int resultadopuntos = puntosproducto - puntoswallet;
            System.out.println(" resultadopuntos  " + resultadopuntos);

            //entra ala condicion si no tiene mas de 5 euros y suficientes puntos para canjear
            if (eurosproducto >= 5 && puntoswallet >= puntosproducto) {

                //resto el el precioproducto al saldoeuroswallet
                walletaux.setSaldopuntos(resultadopuntos);
                walletdao.actualizarwallet(walletaux);
                //fecha java
                java.util.Date fecha = new Date();
                //paso fechajava a fecha sql
                java.sql.Date sqlfecha = new java.sql.Date(fecha.getTime());
                //inserto compra
                CompraDAO compradao = new CompraDAO(conexion);
                Compra nuevacompra = new Compra(idcomprueba, sqlfecha, idwallet, idproducto);
                compradao.insertarcompra(nuevacompra);
                conexion.commit();
                System.out.println("se ha hecho commit de la transaccion");

            } else {
                System.out.println("no tienes suficiente saldo");
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.out.println("entramos al rollback");
            try {
                conexion.rollback();
            } catch (SQLException ex1) {
                ex1.printStackTrace(System.out);
            }
        }
    }

    public static void selectcompra() {
        Connection conexion = null;
        try {
            conexion = Conexion.getConnection();
            if (conexion.getAutoCommit()) {
                conexion.setAutoCommit(false);
            }
            //recorro la lista para sacartodos los compra introducidos
            CompraDAO compradao = new CompraDAO(conexion);
            List<Compra> compralista = compradao.seleccionarcompra();
            for (Compra compra : compralista) {
                System.out.println(compra);
            }
            conexion.commit();
            System.out.println("se ha hecho commit de la transaccion");

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.out.println("entramos al rollback");
            try {
                conexion.rollback();
            } catch (SQLException ex1) {
                ex1.printStackTrace(System.out);
            }
        }

    }

    public static void selectdevolucion() throws SQLException, ParseException {
        Connection conexion = null;
        try {
            conexion = Conexion.getConnection();
            if (conexion.getAutoCommit()) {
                conexion.setAutoCommit(false);
            }
            //recorro la lista para sacartodos los ewallet introducidos
            DevolucionDAO devoluciondao = new DevolucionDAO(conexion);
            List<Devolucion> devolista = devoluciondao.seleccionardevolucion();
            devolista.forEach(Devolucion -> {
                System.out.println("ewallet = " + Devolucion);
            });

            conexion.commit();
            System.out.println("e ha hecho commit de la transaccion");

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.out.println("entramos al rollback");
            try {
                conexion.rollback();
            } catch (SQLException ex1) {
                ex1.printStackTrace(System.out);
            }
        }
    }
}
