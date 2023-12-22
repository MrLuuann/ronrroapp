/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app;
/*
Se importan las librerias para la conexion, errores y las ventanas emergentes
*/
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Uriel
 */
public class metods extends Thread{
    /*
    Aqui se inicializan las variables para almacenar los datos persistentes, como niveles, id, el arreglo de las palabras, entre otras cosas
    */
    int nivel, ultNivel, nPal = 0; 
    static int puntajePart = 0, IdUsuario, aciertos;
    String[][] palabrasAl = new String[0][0];
    public static boolean selecOpc = false, pInsuf = false;
    int[] arregAl = new int[10];
    
    public void obtenerPalabras(int btn){
        /*
        Este metodo obtiene todas las palabras que pertenecen al nivel seleccionado
        */
        int nCat = 0;
        nivel = btn;
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try
        {
            /*
            Cuenta cuantas categorias hay en este nivel
            */
            cn = conexion.conectar();
            String sql = "SELECT COUNT(*) FROM categorias WHERE id_nivel = " +btn+ ";";
            pst = cn.prepareStatement(sql);                        
            rs = pst.executeQuery();
            rs.next();
            
            nCat = rs.getInt("COUNT(*)");
            
            int[] idsCat = new int[nCat];
            
            /*
            Selecciona todas las categorias de este nivel y las almacena en un arreglo
            */
            String sql2 = "SELECT id_categoria FROM categorias WHERE id_nivel = " +btn+ ";";
            pst = cn.prepareStatement(sql2);                        
            rs = pst.executeQuery();
            for(int i = 0; i < nCat; i++){
                rs.next();
                idsCat[i] = rs.getInt("id_categoria");
                System.out.println(idsCat[i]);
                
            }
            /*
            Aqui cuenta cuantas palabras hay en cada categoria almacenada 
            */
            for(int i = 0; i < nCat; i++){
                String sql4 = "SELECT COUNT(*) FROM palabras WHERE id_categoria = " +idsCat[i]+ ";";
                System.out.println(sql4);
                pst = cn.prepareStatement(sql4);                        
                rs = pst.executeQuery();
                rs.next();
                nPal = nPal+rs.getInt("COUNT(*)");
                System.out.println(nPal);
                if(nPal == 0){
                    JOptionPane.showMessageDialog(null, "No hay palabras en esta categoria :(");
                }else{
                    
                }
            }
            if(nPal < 11){
                JOptionPane.showMessageDialog(null, "No hay palabras suficientes en esta categoria :(");
                niveles niv = new niveles();
                niv.setVisible(true);
                pInsuf = true;
            }
            /*
            Se crea un arreglo del tamaño de todas las palabras contadas para aqui almacenar las palabras del nivel
            */
            String [][] palabras = new String[nPal][5];
            /*
            Depende de cuantas categorias son se hace un ciclo para consultar las palabras de cada una y almacenar las palabras en el arreglo
            */
            if(nCat == 1){
                
                String sql3 = "SELECT palabras.id_palabra, palabras.palabra, palabras.id_categoria, palabrasm.palabra_mal, palabrasm.id_palabra FROM palabras INNER JOIN palabrasm ON palabras.id_palabra = palabrasm.id_palabra WHERE id_categoria=" +idsCat[0]+ ";";
                System.out.println(sql3);
                pst = cn.prepareStatement(sql3);                        
                rs = pst.executeQuery();
                
                for(int i = 0; i < nPal; i++){
                    rs.next();
                    palabras[i][0] = rs.getString("id_palabra");
                    palabras[i][1] = rs.getString("palabra");
                    palabras[i][2] = rs.getString("id_categoria");
                    palabras[i][3] = rs.getString("palabra_mal");
                    palabras[i][4] = rs.getString("id_palabra");
                }
                
                palabrasAl = palabras; 
                
                for(int i = 0; i < nPal; i++){
                    System.out.println(palabras[i][0]);
                    System.out.println(palabras[i][1]);
                    System.out.println(palabras[i][2]);
                    System.out.println(palabras[i][3]);
                    System.out.println(palabras[i][4]);
                }
                
            }else{
                if(nCat == 2){
                    String sql3 = "SELECT palabras.id_palabra, palabras.palabra, palabras.id_categoria, palabrasm.palabra_mal, palabrasm.id_palabra FROM palabras INNER JOIN palabrasm ON palabras.id_palabra = palabrasm.id_palabra WHERE id_categoria=" +idsCat[0]+ " or id_categoria=" +idsCat[1]+ ";";
                    System.out.println(sql3);
                    pst = cn.prepareStatement(sql3);                        
                    rs = pst.executeQuery();

                    for(int i = 0; i < nPal; i++){
                        rs.next();
                        palabras[i][0] = rs.getString("id_palabra");
                        palabras[i][1] = rs.getString("palabra");
                        palabras[i][2] = rs.getString("id_categoria");
                        palabras[i][3] = rs.getString("palabra_mal");
                        palabras[i][4] = rs.getString("id_palabra");
                    }

                    palabrasAl = palabras;
                    
                    for(int i = 0; i < nPal; i++){
                        System.out.println(palabras[i][0]);
                        System.out.println(palabras[i][1]);
                        System.out.println(palabras[i][2]);
                        System.out.println(palabras[i][3]);
                        System.out.println(palabras[i][4]);
                    }
                }else{
                        if(nCat == 3){
                            String sql3 = "SELECT palabras.id_palabra, palabras.palabra, palabras.id_categoria, palabrasm.palabra_mal, palabrasm.id_palabra FROM palabras INNER JOIN palabrasm ON palabras.id_palabra = palabrasm.id_palabra WHERE id_categoria=" +idsCat[0]+ " or id_categoria=" +idsCat[1]+ " or id_categoria=" +idsCat[2]+ ";";
                            System.out.println(sql3);
                            pst = cn.prepareStatement(sql3);                        
                            rs = pst.executeQuery();

                            for(int i = 0; i < nPal; i++){
                                rs.next();
                                palabras[i][0] = rs.getString("id_palabra");
                                palabras[i][1] = rs.getString("palabra");
                                palabras[i][2] = rs.getString("id_categoria");
                                palabras[i][3] = rs.getString("palabra_mal");
                                palabras[i][4] = rs.getString("id_palabra");
                            }
                            
                            palabrasAl = palabras;
                            
                            for(int i = 0; i < nPal; i++){
                                System.out.println(palabras[i][0]);
                                System.out.println(palabras[i][1]);
                                System.out.println(palabras[i][2]);
                                System.out.println(palabras[i][3]);
                                System.out.println(palabras[i][4]);
                            }
                    }else{
                             JOptionPane.showMessageDialog(null, "Este nivel tiene demasiadas categorias :(");
                        }
                }
            }
            
            for(int i = 0; i < 10; i++){
                
            }
        }
        catch(SQLException e)
        {
            
            JOptionPane.showMessageDialog(null,"Error: " +e);
            
        }
        
        finally
        {
            try
            {
                if (rs != null) rs.close();
                
                if (pst != null) pst.close();
                
                if (cn != null) cn.close();
            }
            catch(SQLException e)
            {
                JOptionPane.showMessageDialog(null,e);
            }
        }
        
        
    }
    
    public void avances(int IdUser){
        /*
        Este metodo obtiene los avances del usuario para almacenarlos y futuramente actualizarlos
        */
        IdUsuario = IdUser;
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try{
            cn = conexion.conectar();
            
            String sql2 = "SELECT aciertos, id_nivel FROM avances WHERE id_usuario ='" +IdUser+ "';";
            pst = cn.prepareStatement(sql2);
            rs = pst.executeQuery();
            rs.next();
            /*
            Estos avances se almacenan en las variables globales
            */
            System.out.println(rs.getInt("aciertos"));
            System.out.println(rs.getInt("id_nivel"));
            aciertos = rs.getInt("aciertos");
            ultNivel = rs.getInt("id_nivel");
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error: " +e);
        }
        finally{
            try{
                if (rs != null) rs.close();
                if (pst != null) pst.close();
                if (cn != null) cn.close();
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }
    
    @Override
    public synchronized void run(){
        /*
        Este es el metodo del hilo, el cual hace que aparezca una ventana por cada palabra y compruebe si el usuario eligio la correcta
        */
        if(pInsuf == false){
            String palab1, palab2;
            int i = 0, p, pBuena;
            /*
            Resetea el valor de esta partida a 0 y manda a llamar el metodo de numeros aleatorios para que no siempre se muestren las mismas palabras
            */
            puntajePart = 0;
            getNumAl();
            /*
            Este ciclo comprueba que se muestren solo 10 ventanas
            */
            while(i < 10){
                Ejercicios ej = new Ejercicios();
                ej.setVisible(true);
                p = arregAl[i];
                /*
                Aqui se genera un numero aleatorio entre 1 y 2, el cual hace que la palabraba buena no siempre sea la primera
                */
                pBuena = (int) (Math.random() * 2) + 1;
                /*
                Este condicional cambia el orden dependiendo el numero aleatorio
                */
                if(pBuena == 1){
                    palab1 = palabrasAl[p][1];
                    palab2 = palabrasAl[p][3];
                }else{
                    palab2 = palabrasAl[p][1];
                    palab1 = palabrasAl[p][3];
                }
                ej.setDat("Nivel " +nivel, palab1, palab2, pBuena);
                System.out.println("Se crea ventana " +i);
                /*
                Aqui se duerme el hilo 3s y vuelve a combrobar si el usuario ya presiono un boton para crear la siguiente ventana
                */
                try{
                    while(selecOpc == false){
                        System.out.println(selecOpc);
                        wait(3000);
                    }
                }catch(InterruptedException ex){
                    System.out.println(ex);
                }
                /*
                Se aumenta el conteo de las ventanas creadas y se reinicia la variable que comprueba que el usuario selecciono un boton
                */
                i++;
                selecOpc = false;
            }
            /*
            Una vez terminado la generacion de palabras, se manda a llamar la ventana que muesta los puntajes y al metodo que actualiza la informacion en la bse de datos
            */
            Resultados r = new Resultados();
            int score = aciertos + puntajePart;
            r.setInfo(puntajePart, 10-puntajePart, nivel, score);
            r.setVisible(true);
            upAvances();
        }
    }
    
    public synchronized void selecBtn(){
        /*
        Este metodo lo que hace es comprobar si el usuario ha seleccionado un boton o no y notificarselo al hilo
        */
        selecOpc = true;
        System.out.println(selecOpc);
        notifyAll();
        
    }
    
    public void getNumAl(){
        /*
        Este metodo es el que manda a llamar al metodo de generar numeros aleatorios y los alamacena en un arreglo para usarlo despues
        */
        int i = 0, nGen, reps = 0;
        while(i < 10){
            nGen = gen();
            for(int a = 0; a < 10; a++){
                /*
                Aqui comprueba que el numero generado no se repita
                */
                if(arregAl[a] == nGen){
                    System.out.println(arregAl[a]);
                    reps = reps +1;
                }
                
            }
            /*
            Aqui guarda el numero y aumenta el contador
            */
            if(reps < 1 ){
                arregAl[i] = nGen;
                i++;
            }  
            reps = 0;
            
        }
        System.out.println("Arreglo final");
        for(int c = 0; c < 10; c++){
            System.out.println(arregAl[c]);
        }
    }
    
    public int gen(){
        /*
        Este metodo genera un numero en el rango de las palabras existentes
        */
        int numero;
        numero = (int) (Math.random() * nPal-1) + 1;
        return numero;
    }
    
    public void addPunto(){
        /*
        Este metodo añade un acierto al puntaje de la partida
        */
        puntajePart = puntajePart + 1;
    }
    
    public void upAvances(){
        /*
        Este metodo actualiza la informacion del usuario 
        */
        aciertos = aciertos + puntajePart;
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try{
            cn = conexion.conectar();
            /*
            Ejecuta la actualizacion dependiendo el id del usuario que este jugando
            */
            String sql = "UPDATE avances SET aciertos = " +aciertos+ " WHERE id_usuario = " +IdUsuario+ ";";
            pst = cn.prepareStatement(sql);
            pst.executeUpdate();
            
            String sql2 = "UPDATE avances SET id_nivel = " +nivel+ " WHERE id_usuario = " +IdUsuario+ ";";
            pst = cn.prepareStatement(sql2);
            pst.executeUpdate();
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error al hacer la consulta" +e);
        }
        finally{
            try{
                if (rs != null) rs.close();
                if (pst != null) pst.close();
                if (cn != null) cn.close();
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }
    
}
