package presentacion;

import LogicaNegocio.LogicaPelicula;
import entidades.Pelicula;
import java.util.List;

public class Test_Pelicula {
    public static void main(String[] args) {
        LogicaPelicula logicaPelicula = new LogicaPelicula();

        try {
            // 📌 Insertar una nueva película
            Pelicula nuevaPelicula = new Pelicula(0, "El Padrino", "Drama", "R", "Película de mafia clásica.");
            logicaPelicula.insertar(nuevaPelicula);
            System.out.println("✅ Película insertada: " + nuevaPelicula);

            // 📌 Listar todas las películas
            System.out.println("\n📌 Listado de todas las películas:");
            List<Pelicula> lista = logicaPelicula.listarTodos();
            for (Pelicula p : lista) {
                System.out.println(p);
            }

            // 📌 Buscar una película por ID
            int idBuscar = nuevaPelicula.getIdPelicula();
            Pelicula encontrada = logicaPelicula.buscarPorID(idBuscar);
            if (encontrada != null) {
                System.out.println("\n✅ Película encontrada: " + encontrada);
            } else {
                System.out.println("\n⚠️ No se encontró la película con ID " + idBuscar);
            }

            // 📌 Actualizar una película
            if (encontrada != null) {
                encontrada.setSinopsis("Película de mafia con Marlon Brando.");
                logicaPelicula.actualizar(encontrada);
                System.out.println("✅ Película actualizada: " + logicaPelicula.buscarPorID(idBuscar));
            }

            
            // 📌 Eliminar una película
            int idEliminar = nuevaPelicula.getIdPelicula();
            logicaPelicula.eliminar(idEliminar);
            System.out.println("✅ Película con ID " + idEliminar + " eliminada.");
            
        } catch (Exception e) {
            System.err.println("❌ Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
