package com.example.lab4grupoa.Repository;

import com.example.lab4grupoa.Dto.ListarMascotasDto;
import com.example.lab4grupoa.Dto.ListarNumMascotas;
import com.example.lab4grupoa.Entity.Mascota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MascotaRepository extends JpaRepository<Mascota, Integer> {
    @Query(value = "select idmascota, nombre, anho, sexo, replace(descripcion,'Perro:','') as 'raza', count(idservicio) as 'servicios'\n" +
            "from mascota m \n" +
            "\tleft join servicio s on (m.idmascota = s.mascota_idmascota)\n" +
            "    left join raza_especie re on (m.raza_especie_idraza = re.idraza)\n" +
            "group by nombre;",nativeQuery = true)
    List<ListarMascotasDto> listarMascotas();


    @Query(value = "select nombre, anho, sexo, replace(descripcion,'Perro:','') as `raza`, count(idservicio) as 'servicios'\n" +
            "from mascota m \n" +
            "\tleft join servicio s on (m.idmascota = s.mascota_idmascota)\n" +
            "    left join raza_especie re on (m.raza_especie_idraza = re.idraza)\n" +
            "group by nombre\n" +
            "having `raza` like %?1% or lower(sexo) like %?1%",nativeQuery = true)
    List<ListarMascotasDto> filtrarMascotas(String searchField);

    @Query(value = "SELECT c.idcuenta,count(c.idcuenta) FROM cuenta c \n" +
            "inner join servicio s on (c.idcuenta=s.cuenta_idcuenta)\n" +
            "inner join mascota m on (s.mascota_idmascota=m.idmascota)\n" +
            "where c.idcuenta=?1",nativeQuery = true)
    List<ListarMascotasDto>listarCantidad();

}