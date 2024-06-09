import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class ServiciosService {
  private apiUrl = 'http://localhost:8080';
  //private apiUrl = 'https://servicio-banco.azurewebsites.net';

  constructor(private http: HttpClient) { }

  // Obtener todos los clientes
  getClientes(): Observable<any> {
    return this.http.get<any>(`${this.apiUrl}/cliente`);
  }

  // Insertar un nuevo cliente, modificar cliente
  addCliente(cliente: any): Observable<any> {
    return this.http.post<any>(`${this.apiUrl}/cliente`, cliente);
  }


    // Obtener todos los codigos de catalogos
    getCatalogo(): Observable<any> {
      return this.http.get<any>(`${this.apiUrl}/catalogo`);
    }
	

}
