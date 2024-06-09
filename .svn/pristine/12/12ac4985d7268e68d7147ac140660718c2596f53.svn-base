import { Component, OnInit, ViewChild, Input } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatTableDataSource } from '@angular/material/table';
import { MatPaginator } from '@angular/material/paginator';
import { ServiciosService } from '../servicios.service';
import { Cliente } from '../sistema-bancario/interface';

@Component({
  selector: 'app-gestion-cliente',
  templateUrl: './gestion-cliente.component.html',
  styleUrls: ['./gestion-cliente.component.scss'],
})
export class GestionClienteComponent implements OnInit {

  @ViewChild(MatPaginator) paginator!: MatPaginator;
  @Input() clientes: Cliente[] = [];

  formulario: FormGroup;
  dataSource = new MatTableDataSource<Cliente>();
  mostrarTabla: boolean = false;
  displayedColumns: string[] = ['index', 'nombre', 'apellido', 'numeroIdentificacion', 'fechaNacimiento', 'direccion', 'correoElectronico', 'telefono', 'estado'];


  idSeleccionado: number | null = null;
  element$: any;

  constructor(
    private formBuilder: FormBuilder,
    private serviciosService: ServiciosService
  ) {
    this.formulario = this.formBuilder.group({
      nombre: ['', Validators.required],
      apellido: ['', Validators.required],
      numeroIdentificacion: ['', Validators.required],
      fechaNacimiento: ['', Validators.required],
      direccion: ['', Validators.required],
      correoElectronico: ['', [Validators.required, Validators.email]],
      telefono: ['', Validators.required]
    });
  }

  ngOnInit(): void {
    this.actualizarTabla();
  }

  actualizarTabla() {
    this.dataSource.data = this.clientes;
    this.mostrarTabla = true;
    this.dataSource.paginator = this.paginator;
  }

  onSubmit() {
    if (this.formulario.valid) {
      const nuevoCliente: Cliente = this.formulario.value;
      nuevoCliente.estado = 1;
      nuevoCliente.fechaAdiciono = new Date();
      nuevoCliente.fechaModifico = null;
      nuevoCliente.idCliente = null;
      nuevoCliente.usuarioAdiciono = 'FERNANDO';
      nuevoCliente.usuarioModifico = null;

      this.serviciosService.addCliente(nuevoCliente).subscribe(
        (respuesta) => {
          console.log('Cliente agregado exitosamente:', respuesta);
          this.actualizarTabla();
          this.formulario.reset();
        },
        (error) => {
          console.error('Error al agregar cliente:', error);
        }
      );
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
