package com.backend.DEVikings.model;

import com.backend.DEVikings.enums.Enum_Roles;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name ="empleados")
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "correo", nullable = false)
    private String correo;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo")
    private Enum_Roles rol;

    @Column(name="image")
    private String image;

    @Column(name="auth0id",unique=true)
    private String auth0id;


//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "empresa_id")
//    private Empresa empresa;

    @ManyToOne
//    @JoinColumn(name = "empresa_id")
    private Empresa empresa;

    @OneToMany(mappedBy = "empleado")
    private List<Transaccion> transacciones;

    @CreationTimestamp
    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;

    @UpdateTimestamp
    @Column(name = "fecha_actualizacion")
    private LocalDateTime fechaActualizacion;
}
