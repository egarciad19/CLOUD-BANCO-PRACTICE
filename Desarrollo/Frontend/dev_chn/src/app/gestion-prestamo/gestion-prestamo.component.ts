import { Component, OnInit, ViewChild, Input } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatTableDataSource } from '@angular/material/table';
import { MatPaginator } from '@angular/material/paginator';
import { ServiciosService } from '../servicios.service';
import { Cliente, Prestamo } from '../sistema-bancario/interface';

@Component({
  selector: 'app-gestion-prestamo',
  templateUrl: './gestion-prestamo.component.html',
  styleUrls: ['./gestion-prestamo.component.scss']
})
export class GestionPrestamoComponent implements OnInit {

  @ViewChild(MatPaginator) paginator!: MatPaginator;
  @Input() clientes: Cliente[] = [];

  formulario: FormGroup;
  dataSource = new MatTableDataSource<any>();
  mostrarTabla: boolean = false;
  displayedColumns: string[] = [
    'idPrestamo',
    'noIdentificacion',
    'montoAprobado',
    'fechaAprobacion',
    'cantidadMeses',
    'saldoPendiente',
    'nombreEstado'
  ];


  idSeleccionado: number | null = null;
  element$: any;

  constructor(
    private formBuilder: FormBuilder,
    private serviciosService: ServiciosService
  ) {
    this.formulario = this.formBuilder.group({
      numeroIdentificacion: ['', Validators.required]
    });
  }

  ngOnInit(): void {
    this.actualizarTabla();
  }

  actualizarTabla() {
    this.mostrarTabla = true;
    this.dataSource.paginator = this.paginator;
  }

  buscarCodigoGestion() {
    if (this.formulario.valid) {
      const numeroIdentificacion = this.formulario.value.numeroIdentificacion;
      console.log("id cliente ",numeroIdentificacion)
      this.serviciosService.getPrestamos(numeroIdentificacion).subscribe(
        (data: Prestamo[]) => {
          if (data && data.length > 0) {
            console.log('Datos del préstamo:', data);
            this.dataSource.data = data;
          } else {
            console.log('No se encontraron préstamos con el código:', numeroIdentificacion);
            this.dataSource.data = [];
          }
        },
        (error) => {
          console.error('Error al obtener los préstamos:', error);
          this.dataSource.data = [];
        }
      );
    } else {
      console.error('Formulario no válido');
    }
  }


  capturarDatosFila(element: Cliente) {
    this.formulario.patchValue(element);
    this.idSeleccionado = element.idCliente;
  }

  modificarCliente() {
    if (this.idSeleccionado) {
      const modificarCliente: Cliente = this.formulario.value;
      modificarCliente.estado = 1;
      modificarCliente.fechaAdiciono = null;
      modificarCliente.fechaModifico = new Date();
      modificarCliente.idCliente = this.idSeleccionado;
      modificarCliente.usuarioAdiciono = null;
      modificarCliente.usuarioModifico = 'FERNANDO';

      console.log("Datosssss", this.idSeleccionado, "-", modificarCliente,)
      this.serviciosService.addCliente(modificarCliente).subscribe(
        (respuesta) => {
          console.log('Cliente actualizado correctamente:', respuesta);
          this.actualizarTabla();
        },
        (error) => {
          console.error('Error al actualizar el cliente:', error);
        }
      );
    }
  }

  eliminarElemento() {
    console.log('Eliminar cliente:');
    if (this.idSeleccionado) {
      const modificarCliente: Cliente = this.formulario.value;
      modificarCliente.estado = 2;
      modificarCliente.idCliente = this.idSeleccionado;

      this.serviciosService.addCliente(modificarCliente).subscribe(
        (respuesta) => {
          console.log('Cliente eliminado correctamente:', respuesta);
          this.clientes = this.clientes.filter(cliente => cliente.idCliente !== this.idSeleccionado);
          this.actualizarTabla();
        },
        (error) => {
          console.error('Error al eliminar el cliente:', error);
        }
      );
    }
  }


}
