import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        ArrayList<Empleado> empleados = new ArrayList();
        leerArchivo("datos.csv", empleados);
        empleados.sort((a, b) -> { return 1* Double.compare(a.getSueldo(), b.getSueldo());});
        imprimirDatos(empleados);

    }
    public static void imprimirEmpleadoQueLaLetraJConContains(ArrayList<Empleado> empleados) {
        for (Empleado item : empleados) {
            if(item.getNombre().toLowerCase().contains("j")){
                System.out.println("Nombre: "+ item.getNombre()+ " ,Sueldo: "+ item.getSueldo()+ " ,Fecha pago: "+ item.getFechaPago());
            }
            
          }
    }
    public static void imprimirEmpleadoQueLaLetraJConindexOf(ArrayList<Empleado> empleados) {
        for (Empleado item : empleados) {
            if(item.getNombre().toLowerCase().indexOf("j")>=0){
                System.out.println("Nombre: "+ item.getNombre()+ " ,Sueldo: "+ item.getSueldo()+ " ,Fecha pago: "+ item.getFechaPago());
            }
            
          }
    }
    public static void imprimirEmpleadoConSueldoMayora250(ArrayList<Empleado> empleados) {
        for (Empleado item : empleados) {
            if(item.getSueldo()>250){
                System.out.println("Nombre: "+ item.getNombre()+ " ,Sueldo: "+ item.getSueldo()+ " ,Fecha pago: "+ item.getFechaPago());
            }
            
          }
    }
    public static void imprimirEmpleadosDeMayo2024(ArrayList<Empleado> empleados) {
        for (Empleado item : empleados) {
            LocalDate fechaPago= item.getFechaPago();
            if(fechaPago.getYear()== 2024 && fechaPago.getMonth()== Month.MAY){
                System.out.println("Nombre: "+ item.getNombre()+ " ,Sueldo: "+ item.getSueldo()+ " ,Fecha pago: "+ item.getFechaPago());
            }
            
          }
    }
    public static void imprimirDatos(ArrayList<Empleado> empleados) {
        for (Empleado item : empleados) {
            System.out.println("Nombre: "+ item.getNombre()+ " ,Sueldo: "+ item.getSueldo()+ " ,Fecha pago: "+ item.getFechaPago());
          }
    }

    public static LocalDate convertFecha(String fecha) {
        String[] arrFecha = fecha.split("-");
        int year = Integer.parseInt(arrFecha[0]);
        int mes = Integer.parseInt(arrFecha[1]);
        int dia = Integer.parseInt(arrFecha[2]);
        LocalDate date = LocalDate.of(year, mes, dia);
        return date;
    }

    public static String obtenerPrimeraLetramayus(String str) {
        str= str.trim();
       String l1 = str.substring(0, 1);
       String l1Mayus= l1.toUpperCase();
       String result= str.replaceFirst(l1, l1Mayus);       
       return result;
    }

    public static void procesarDatostxt(String linea, ArrayList<Empleado> empleados) {
        String[] valoresEmpleados = linea.split(";");
        for (String valoresEmpleado1 : valoresEmpleados) {
            String[] valoresEmpleado = valoresEmpleado1.split(",");
            Empleado empleado = new Empleado();
            empleados.add(empleado);
            for (int j = 0; j < valoresEmpleado.length; j++) {
                String valor = valoresEmpleado[j];
                switch (j) {
                    case 0:
                        empleado.setNombre(obtenerPrimeraLetramayus(valor));
                        break;
                    case 1:
                        double sueldo = Double.parseDouble(valor);
                        empleado.setSueldo(sueldo);
                        break;
                    case 2:
                        empleado.setFechaPago(convertFecha(valor));
                        break;
                }
            }
        }
    }

    public static void procesarDatoscsv(String linea, ArrayList<Empleado> empleados) {
        String[] valoresEmpleado = linea.split(";");
        Empleado empleado = new Empleado();
        empleados.add(empleado);
        for (int j = 0; j < valoresEmpleado.length; j++) {
            String valor = valoresEmpleado[j];
            switch (j) {
                case 0:
                    empleado.setNombre(obtenerPrimeraLetramayus(valor));
                    break;
                case 1:
                    double sueldo = Double.parseDouble(valor);
                    empleado.setSueldo(sueldo);
                    break;
                case 2:
                    empleado.setFechaPago(convertFecha(valor.trim()));
                    break;
            }
        }
    }

    public static void leerArchivo(String ruta, ArrayList<Empleado> empleados) {
        try {
            File myObj = new File(ruta);
            Scanner myReader = new Scanner(myObj);
            int index=0;
            while (myReader.hasNextLine()) {
                String linea = myReader.nextLine();
                if(index!=0){
                    procesarDatoscsv(linea, empleados);
                }
               
                index++;
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
