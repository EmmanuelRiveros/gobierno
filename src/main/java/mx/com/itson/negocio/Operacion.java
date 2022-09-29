/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package mx.com.itson.negocio;

/**
 *
 * @author Emmanuel R, Francisco O
 */
public class Operacion {

    public static void main(String[] args) {
        
    }
    
    /**
     * Método para generar una curp con los datos solicitados
     * @param nombre
     * @param apellido
     * @param dia 
     * @param mes
     * @param anio
     * @param sexo
     * @param estado 
     * @return curp
     */
    
    public String crearCurp (String nombre, String apellido, String dia, String mes, String anio, String sexo, String estado ){
        
        String curp;
        
        // Utiliza el metodo buscarErrores el cual devuelve un string con detalles del error.
        String errorDia = buscarErrores(dia, 2, "día", 31);
        String errorMes = buscarErrores(mes, 2, "mes", 12);
        String errorAnio = buscarErrores(anio, 4, "año", 2022);
        
        // Comprueba si existen errores si no imprime el error en pantalla.
        if (!errorDia.isEmpty()){
            return errorDia;
        }
        if (!errorMes.isEmpty()){
            return errorMes;
        }
        if (!errorAnio.isEmpty()){
            return errorAnio;
        }
       
        // Recorta los espacios que esten por fuera, convierte todos los caracteres a mayúscula y reemplaza los caracteres invalidos
        nombre = nombre.trim().toUpperCase().replace("1", "").replace("2", "").replace("3", "").replace("4", "").replace("5", "").replace("6", "").replace("7", "").replace("8", "").replace("9", "").replace("0", "").replace("¡", "").replace("!", "").replace("¿", "").replace("?", "").replace("á", "A").replace("é", "E").replace("í", "I").replace("ó", "O").replace("ú", "U").replace("Á", "A").replace("É", "E").replace("Í", "I").replace("Ó", "O").replace("Ú", "U").replace(",", "").replace(".", "").replace("(", "").replace(")", "");
        apellido = apellido.trim().toUpperCase().replace("1", "").replace("2", "").replace("3", "").replace("4", "").replace("5", "").replace("6", "").replace("7", "").replace("8", "").replace("9", "").replace("0", "").replace("¡", "").replace("!", "").replace("¿", "").replace("?", "").replace("á", "A").replace("é", "E").replace("í", "I").replace("ó", "O").replace("ú", "U").replace("Á", "A").replace("É", "E").replace("Í", "I").replace("Ó", "O").replace("Ú", "U").replace(",", "").replace(".", "").replace("(", "").replace(")", "");
        
        // Crea un array que contendra dos espacios para dos nombres
        String[] nombres = {"", ""};
        // Si existe un espacio separará e ingresara cada nombre en array nombres si no solamente el primer nombre entrara en array
        if (nombre.contains(" ")){
            nombres = nombre.split(" ");
        }else{
            nombres[0] = nombre;
        }
        
        // Crea dos arrays que contienen cada caracter de cada nombre
        
        char[] nombre1Arr = nombres[0].toCharArray();
        char[] nombre2Arr = nombres[1].toCharArray();
        
        // Crea un array que contendra dos espacios para dos apellidos
        String[] apellidos = {"", ""};
        // Si existe un espacio separará e ingresara cada apellido en array apellidos si no solamente el primer apellido entrara en array
        if (apellido.contains(" ")){
            apellidos = apellido.split(" ");
        }else{
            apellidos[0] = apellido;
        }
        
        // Crea dos arrays que contienen cada caracter de cada apellido
        char[] apellido1Arr = apellidos[0].toCharArray();
        char[] apellido2Arr = apellidos[1].toCharArray();
        
        // Agrega el primer caracter del primer apellido
        curp = "" + apellido1Arr[0];
        
        // Se analiza cada caracter en busqueda de otra vocal que no sea inicial
        for(int i=1; i<(apellido1Arr.length-1); i++){

            if (apellido1Arr[i] == 'A'|| 
                    apellido1Arr[i] == 'E' || 
                    apellido1Arr[i] == 'I' || 
                    apellido1Arr[i] == 'O' || 
                    apellido1Arr[i] == 'U'){
                
                if (curp.length() <= 1){
                    curp = curp + apellido1Arr[i];
                }                
            }
        }
        
        // Si el segundo apellido es no existente se coloca una X si existe se coloca la primera letra del mismo
        if (apellidos[1].equals("")){
            curp = curp + "X";
        } else {
            curp = curp + apellido2Arr[0];
        }
        
        // Busca nombres compuestos para ingresar la primer letra del segundo nombre en dado caso de que sea verdadero
        if (nombres[0].equals("Jose") && nombres[1].equals("Maria") || nombres[0].equals("Maria") && nombres[1].equals("Jose")){
            curp = curp + nombre2Arr[0];
        } else {
            curp = curp + nombre1Arr[0];
        }
        
        // Crea un nuevo array de año
        char[] anioArr = anio.toCharArray();
        
        // Agrega los ultimos dos digitos del año, el mes y el día
        curp = curp + anioArr[2] + anioArr[3] + mes + dia;
        
        curp = switch (sexo) {
            case "Hombre" -> curp + "H";
            case "Mujer" -> curp + "M";
            default -> curp + "X";
        };
        
        // Dependiendo del estado agrega dos letras correspondientes al mismo
        switch (estado){
            case "Aguascalientes" -> curp = curp + "AS";
            case "Baja California" -> curp = curp + "BC";
            case "Baja California Sur" -> curp = curp + "BS";
            case "Campeche" -> curp = curp + "CC";
            case "Coahuila" -> curp = curp + "CL";
            case "Colima" -> curp = curp + "CM";
            case "Chiapas" -> curp = curp + "CS";
            case "Chihuahua" -> curp = curp + "CH";
            case "Distrito Federal" -> curp = curp + "DF";
            case "Durango" -> curp = curp + "DG";
            case "Guanajuato" -> curp = curp + "GT";
            case "Guerrero" -> curp = curp + "GR";
            case "Hidalgo" -> curp = curp + "HG";
            case "Jalisco" -> curp = curp + "JC";
            case "México" -> curp = curp + "MC";
            case "Michoacán" -> curp = curp + "MN";
            case "Morelos" -> curp = curp + "MS";
            case "Nayarit" -> curp = curp + "NT";
            case "Nuevo León" -> curp = curp + "NL";
            case "Oaxaca" -> curp = curp + "OC";
            case "Puebla" -> curp = curp + "PL";
            case "Querétaro" -> curp = curp + "QT";
            case "Quintana Roo" -> curp = curp + "QR";
            case "San Luis Potosí" -> curp = curp + "SP";
            case "Sinaloa" -> curp = curp + "SL";
            case "Sonora" -> curp = curp + "SR";
            case "Tabasco" -> curp = curp + "TC";
            case "Tamaulipas" -> curp = curp + "TS";
            case "Tlaxcala" -> curp = curp + "TL";
            case "Veracruz" -> curp = curp + "VZ";
            case "Yucatán" -> curp = curp + "YN";
            case "Zacatecas" -> curp = curp + "ZS";
            case "Extranjero" -> curp = curp + "NE";
        }
        
        curp = curp + buscarConsonante(apellido1Arr);
        
        if (apellido2Arr.equals("")){
            curp = curp + "X";
        } else{
            curp = curp + buscarConsonante(apellido2Arr);
        }
        
        curp = curp + buscarConsonante(nombre1Arr);
        
        // Se convierte el año tipo string a int para realizar una comparación y dependiendo del resultado agregar un caractér a la curp
        int anioInt = Integer.parseInt(anio);
        
        if (anioInt >= 2000 ){
            curp = curp + "A";
        } else{
            curp = curp + "0";
        }
        
        curp = curp + "1";
        
        return "Tu CURP es: " + curp;
    }
    
    /**
     * Método utilizado para comprobar si no hay errores en la introducción de valores númericos
     * @param texto el valor a comprobar
     * @param longitudMax la longitud máxima en carácteres que debe tener el texto
     * @param tipo el tipo de dato que se va a comprobar
     * @param valorMax el valor maximo que debe tener el valor
     * @return 
     */
    
    private String buscarErrores (String texto, int longitudMax, String tipo, int valorMax){
        String error = "";
        char[] textoArr = texto.toCharArray();
        
        if (texto.isBlank()){
            error = "El "+ tipo +" esta vacío";
        }
        
        for(int i=0; i<(textoArr.length); i++){
            if (!Character.isDigit(textoArr[i])){
                error = "El "+ tipo +" introducido no es dígito";
                
            } else if (textoArr.length > longitudMax) {
                error = "El "+ tipo +" debe tener "+ longitudMax +" dígitos máximo";

            } else if (Integer.parseInt(texto) > valorMax){
                error = "El "+ tipo +" supera el valor máximo";
            }
        } 
        
        return error;
        
    }
    
    /**
     * Metódo utilizado para buscar la primer consonante no inicial de cualquier palabra.
     * @param palabra la palabra que se inspeccionara
     * @return consonanteInterna
     */
    
    private char buscarConsonante (char[] palabra){
        boolean encontrada = false;
        char consonanteInterna = 'X';
        
        for(int i=1; i<(palabra.length-1); i++){

            if (palabra[i] == 'B'|| 
                    palabra[i] == 'C' || 
                    palabra[i] == 'D' || 
                    palabra[i] == 'F' || 
                    palabra[i] == 'G' ||
                    palabra[i] == 'H' ||
                    palabra[i] == 'J' ||
                    palabra[i] == 'L' ||
                    palabra[i] == 'M' ||
                    palabra[i] == 'N' ||
                    palabra[i] == 'P' ||
                    palabra[i] == 'Q' ||
                    palabra[i] == 'R' ||
                    palabra[i] == 'S' ||
                    palabra[i] == 'T' ||
                    palabra[i] == 'V' ||
                    palabra[i] == 'X' ||
                    palabra[i] == 'Z' ||
                    palabra[i] == 'W' ||
                    palabra[i] == 'Y'){
                
                if (!encontrada){
                    consonanteInterna = palabra[i];
                    encontrada = true;
                }                
            }
        }
        
        return consonanteInterna;
    }
    
}
