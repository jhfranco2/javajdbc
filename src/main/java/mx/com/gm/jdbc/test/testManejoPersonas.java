package mx.com.gm.jdbc.test;

import java.util.List;

import mx.com.gm.jdbc.datos.PersonaDao;
import mx.com.gm.jdbc.domain.Persona;

public class testManejoPersonas {
    public static void main(String[] args) {
        PersonaDao personaDao = new PersonaDao();

        Persona personaNueva = new Persona("jhon", "enrique", "jbautista@ordenhospitalaria.org");
        personaDao.insertar(personaNueva);

        personaDao.eliminar(8);

        List<Persona> personas = personaDao.selecccionar();
        personas.forEach(persona -> {
            System.out.println("persona " + persona);
        });
    }
}
