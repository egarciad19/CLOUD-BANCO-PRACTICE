import { Component, OnInit, ViewChild } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatTableDataSource } from '@angular/material/table';
import { MatPaginator } from '@angular/material/paginator';


@Component({
  selector: 'app-gestion-cliente',
  templateUrl: './gestion-cliente.component.html',
  styleUrls: ['./gestion-cliente.component.scss'],
})
export class GestionClienteComponent implements OnInit {

  @ViewChild(MatPaginator) paginator!: MatPaginator;
  formulario: FormGroup;
  dataSource = new MatTableDataSource<any>();
  mostrarTabla: boolean = false;
  displayedColumns: string[] = ['index', 'nombre', 'apellido', 'numeroIdentificacion', 'fechaNacimiento', 'direccion', 'correoElectronico', 'telefono', 'modificar', 'eliminar'];

  constructor(private formBuilder: FormBuilder) {
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
    this.dataSource = new MatTableDataSource<any>();
  }

  onSubmit() {
    if (this.formulario.valid) {
      this.dataSource.data.push(this.formulario.value);
      this.dataSource.data = [...this.dataSource.data];
      this.mostrarTabla = true;
    }
  }

  modificarElemento(element: any) {
    console.log('Modificar elemento:', element);
  }


  eliminarElemento(element: any) {
    console.log('Eliminar elemento:', element);
  }

  ngAfterViewInit() {
    this.dataSource.paginator = this.paginator;
  }
}
