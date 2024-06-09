import { Component, OnInit } from '@angular/core';
import { ServiciosService } from '../servicios.service';

@Component({
  selector: 'app-sistema-bancario',
  templateUrl: './sistema-bancario.component.html',
  styleUrls: ['./sistema-bancario.component.scss']
})
export class SistemaBancarioComponent implements OnInit {

  clientes: any[] = [];
  catalogo: any[] = [];

  constructor(private serviciosService: ServiciosService) { }

  ngOnInit() {
    this.serviciosService.getClientes().subscribe(
      (clientes: any[]) => {
        this.clientes = clientes.filter(cliente => cliente.estado === 1);
        console.log("datos obtenidos ", this.clientes);
        this.serviciosService.getCatalogo().subscribe(
          (catalogo: any[]) => {
            this.catalogo = catalogo;
            console.log("datos obtenidos ", this.catalogo);
            this.clientes.forEach(cliente => {
              const estadoCliente = cliente.estado;
              const itemCatalogo = this.catalogo.find(item => item.codigoDatoCatalogo === estadoCliente);
              if (itemCatalogo) {
                cliente.estado = itemCatalogo.nombre;
              }
            });
          },
          (error) => {
            console.error('Error obtener catalogo', error);
          }
        );
      },
      (error) => {
        console.error('Error obtener clientes', error);
      }
    );
  }


  showGestionCliente: boolean = false;
  showGestionPrestamo: boolean = false;
  showSolicitudPrestamo: boolean = false;
}

