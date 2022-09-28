package com.example.lab4grupoa.Repository;

import com.example.lab4grupoa.Dto.ListarMascotasDto;
import com.example.lab4grupoa.Dto.ListarServiciosMascotaDto;
import com.example.lab4grupoa.Entity.Servicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServicioRepository extends JpaRepository<Servicio,Integer> {
    @Query(value = "select s.idservicio,m.nombre, c.telefono, s.hora_inicio,s.duracion,s.entrega,r.nombre as 'responsable'\n " +
            "from servicio s left join cuenta c on (s.cuenta_idcuenta=c.idcuenta) left join mascota m\n " +
            "on (m.idmascota=s.mascota_idmascota) left join responsable r on \n " +
            "(r.idresponsable=s.responsable_idresponsable) where idmascota= ?1"
            ,nativeQuery = true)
    List<ListarServiciosMascotaDto> listarServicioMascota(Integer id);


}
