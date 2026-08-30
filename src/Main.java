public class Main {
    public static void main(String[] args) {
        //Creacion de vehiculos
        Vehiculo[] vehiculos = new Vehiculo[4];
        Carro carro1 = new Carro("ABC123","Toyota","2025",120000,4,"Manual");
        Carro carro2 = new Carro("JFE231","BYD","2025",150000,4,"Automatica");
        Moto moto1 = new Moto("KLB32F","Yamaha","2020",60000,150);
        Moto moto2 = new Moto("PLO12P","Suzuki","2022",71000,200);

        vehiculos[0] = (Vehiculo) carro1;
        vehiculos[1] = (Vehiculo) carro2;
        vehiculos[2] = (Vehiculo) moto1;
        vehiculos[3] = (Vehiculo) moto2;

        //Moto en mantenimienot
        moto2.setEstado(Estado.MANTENIMIENTO);



        //Creacion de clientes y sus licencias
        Licencia l1 = new Licencia("2314123","2027-01-10");
        Licencia l2 = new Licencia("4321334", "2025-02-21");

        Cliente cliente1 = new Cliente("Tomas","3109422132","2314123",l1);
        Cliente cliente2 = new Cliente("Sara","3134572809","4321334",l2);
        Cliente cliente3 = new Cliente("Pablo","3034213214","123132");
        Cliente[] clientes = {cliente1,cliente2,cliente3};



        //Array de dias alquilados(osea los posibles dias de alquilamiento)
        int[] dias = {3,5,7};
        int contadorDias = 0;
        for(int d : dias){
            contadorDias += d;
        }
        System.out.println("Dias totales alquilados: " + contadorDias);



        //Creacion Alquileres
        Alquiler alquiler1 = new Alquiler(dias[0], carro1, cliente1, "2026-08-30");
        Alquiler alquiler2 = new Alquiler(dias[1], moto1, cliente1, "2026-08-30");
        Alquiler[] alquileres = {alquiler1, alquiler2};




        System.out.println("-------------------------------Vehiculos disponibles -------------------------------------------");
        //Vehiculos Disponibles
        int carrosDisponibles = 0;
        int motosDisponibles = 0;

        for(Vehiculo v : vehiculos){
           if (v.estaHabilitado() == true){
               System.out.println(v.toString());
                if(v instanceof Carro){
                    carrosDisponibles+=1;
                }
                else if(v instanceof Moto){
                    motosDisponibles+=1;
                }
           }
        }
        System.out.println("Carros Disponibles: "+ carrosDisponibles);
        System.out.println("Motos Disponibles: "+ motosDisponibles);

        //Clientes con alquileres activos
        System.out.println("-------------------------------------Clientes Activo-------------------------------------------");
        for(Alquiler a : alquileres){
            if(a.getActivo() == true){
                System.out.println(a.getCliente_arrendador().getNombre());

            }
        }



        System.out.println("-------------------------------Devolucion de un vehiculo-------------------------------------------");
        //Devolver un carro y uso de wrapper en double
        try{
            String montoDigitado = "200000";
            double monto = Double.parseDouble(montoDigitado);
            alquiler1.devolverVehiculo(monto);
            System.out.println("Carro devuelto con daños ");
            System.out.println("Cobro por daños: " + alquiler1.getMontoDanos());
            alquiler1.devolverVehiculo(0);
        }
        catch (AlquilerYaCerradoException e){
            System.out.println("-> Error: " + e.getMessage());
        }
        finally {
            System.out.println("Proceso de devolucion acabdo");
        }




        System.out.println("--------------------------------Cliente intenta alquilar sin licencia vigente-------------------------------------------");
        //Uso del throw
        try{
            if(cliente2.estaHabilitado() == false){
                throw new LicenciaVencidaException("El cliente no tiene la licencia vigente.");
            }
            else{
                Alquiler alquiler3 = new Alquiler(dias[2], carro2, cliente2, "2026-08-30");
            }
        }
        catch (LicenciaVencidaException e){
            System.out.println("-> Error: " + e.getMessage());
        }


        System.out.println("--------------------------------------Se revisa si un vehiculo esta disponible-------------------------------------------");
        try{
            if(moto2.estaHabilitado() == false){
                throw new VehiculoNoDisponibleException("El vehiculo no esta disponible");
            }
            else{
                Alquiler alquiler4 = new Alquiler(dias[2], moto2, cliente1, "2026-08-30");
            }
        }
        catch (VehiculoNoDisponibleException e){
            System.out.println("-> Error: " + e.getMessage());
        }


        System.out.println("--------------------------------------Pagos -------------------------------------------");
        //Total a pagar
        if(cliente1.esFrecuente() == true){
            double total = moto1.calcularPago(dias[1],0.1);
            System.out.println("Cliente frecuente, paga con descuento: " + total);
        }
        else{
            double total = moto1.calcularPago(dias[1]);
            System.out.println("Cliente normal, paga: " + total);
        }





        //Uso del resto de exepciones
        System.out.println("-------------------------------------Se revisa si hay clientes repetidos(con el mismo documento)-------------------------------------------");
        try{
            Cliente cliente4 = new Cliente("Jacobo","8320923841","2314123");
            for(Cliente c : clientes){
                if(c.equals(cliente4)){
                    throw new ClienteDuplicadoException("Ya existe un cliente con ese documento registrado");
                }
            }
            System.out.println("Cliente registrado.");
        }
        catch (ClienteDuplicadoException e){
            System.out.println("-> Error: " + e.getMessage());
        }

        //Total de alquileres
        System.out.println("---------------------------- Total de alquileres registrados ---------------------------");
        System.out.println("Total de alquileres: " + Alquiler.getTotal_alquileres());

    }
}
