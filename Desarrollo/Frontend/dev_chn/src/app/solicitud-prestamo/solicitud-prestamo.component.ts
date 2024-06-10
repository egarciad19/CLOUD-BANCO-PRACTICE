import { Component, OnInit, ViewChild, Input } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatTableDataSource } from '@angular/material/table';
import { MatPaginator } from '@angular/material/paginator';
import { ServiciosService } from '../servicios.service';
import { Cliente, Solicitud } from '../sistema-bancario/interface';
import Swal from 'sweetalert2';
import { Router } from '@angular/router';

@Component({
  selector: 'app-solicitud-prestamo',
  templateUrl: './solicitud-prestamo.component.html',
  styleUrls: ['./solicitud-prestamo.component.scss']
})
export class SolicitudPrestamoComponent implements OnInit {
  @ViewChild(MatPaginator) paginator!: MatPaginator;
  @Input() solicitudes: Solicitud[] = [];
  @Input() clientes: Solicitud[] = [];

  formulario: FormGroup;
  dataSource = new MatTableDataSource<Solicitud>();
  mostrarTabla: boolean = false;
  displayedColumns: string[] = ['index','numeroIdentificacion','nombreCliente','noSolicitud', 'tasaInteres', 'estado', 'cantidadMeses','montoPrestamo','aprobarRechazar' ];


  idSeleccionado: number | null = null;
  element$: any;

  constructor(
    private router: Router,
    private formBuilder: FormBuilder,
    private serviciosService: ServiciosService
  ) {
    this.formulario = this.formBuilder.group({
      numeroIdentificacion: ['', Validators.required],
      cantidadMeses: ['', [Validators.required, Validators.min(1)]],
      montoPrestamo: ['', [Validators.required, Validators.min(0)]],
      tasaInteres: ['', [Validators.required, Validators.min(0), Validators.max(100)]]
    });
  }

  ngOnInit(): void {
    this.actualizarTabla();
  }

  actualizarTabla() {
    this.dataSource.data = this.solicitudes;
    this.mostrarTabla = true;
    this.dataSource.paginator = this.paginator;
  }

  onSubmit() {
    if (this.formulario.valid) {
      const numeroIdentificacion = this.formulario.value.numeroIdentificacion;
      const cliente = this.clientes.find(c => c.numeroIdentificacion === numeroIdentificacion);

      if (cliente) {
        const nuevaSolicitud = this.formulario.value;
        nuevaSolicitud.estado = 6;
        nuevaSolicitud.fechaAdiciono = new Date();
        nuevaSolicitud.fechaModifico = null;
        nuevaSolicitud.idCliente = cliente.idCliente;
        nuevaSolicitud.usuarioAdiciono = 'FERNANDO';
        nuevaSolicitud.usuarioModifico = null;
        console.log("clientes encontrados",nuevaSolicitud);
        this.serviciosService.addSolicitud(nuevaSolicitud).subscribe(
          (respuesta) => {
            console.log('Cliente agregado exitosamente:', respuesta);
            this.actualizarTabla();
            this.formulario.reset();
          },
          (error) => {
            console.error('Error al agregar cliente:', error);
          }
        );
      } else {
        Swal.fire({
          icon: 'error',
          title: 'Cliente no encontrado',
          text: 'Debe ingresar al sistema el cliente antes de proceder.',
        }).then((result) => {
          if (result.isConfirmed) {
          }
        });
      }
    }
  }

 /* capturarDatosFila(element: Solicitud) {
    this.formulario.patchValue(element);
    this.idSeleccionado = element.noSolicitud;
  }*/

    modificarElemento(elemento: any, accion: string) {
      const modificarEstado: any = {};
      modificarEstado.fechaModifico = new Date();
      modificarEstado.usuarioModifico = 'FERNANDO';
      modificarEstado.noSolicitud = elemento.noSolicitud;

      if (accion === 'aprobar') {
        modificarEstado.estado = 4;
      } else if (accion === 'rechazar') {
        modificarEstado.estado = 5;
      } else {
        console.error('Acción no reconocida:', accion);
        return;
      }
      console.log("Solicitud modificada:", modificarEstado);
      this.serviciosService.editEstadoSolicitud(modificarEstado).subscribe(
        response => {
          console.log("Respuesta del servidor:", response);
        },
        error => {
          console.error("Error al modificar la solicitud:", error);
        }
      );
    }


}
