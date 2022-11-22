import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import {Cliente} from './client'
import { environment } from 'src/environments/environment';

@Injectable({providedIn: 'root'})
export class ClienteService {
  private apiServerUrl = environment.apiBaseUrl;

  constructor(private http: HttpClient){}

  public getCliente(): Observable<Cliente[]> {
    return this.http.get<Cliente[]>(`${this.apiServerUrl}/api/client/all`);
  }

  // public getProducto(): Observable<Producto[]> {
  //   return this.http.get<Producto[]>(`${this.apiServerUrl}/producto/all`);
  // }
  // public addProducto(): Observable<Producto[]> {
  //   return this.http.post<Producto[]>(`${this.apiServerUrl}/producto/all`);
  // }
  // public updateProducto(): Observable<Producto[]> {
  //   return this.http.put<Producto[]>(`${this.apiServerUrl}/producto/all`);
  // }
  // public deleteProducto(): Observable<Producto[]> {
  //   return this.http.delete<Producto[]>(`${this.apiServerUrl}/producto/all`);
  // }

  public addCliente(cliente: Cliente): Observable<Cliente> {
    return this.http.post<Cliente>(`${this.apiServerUrl}/api/client/save`, cliente);
  }

  public updateCliente(cliente: Cliente): Observable<Cliente> {
    return this.http.put<Cliente>(`${this.apiServerUrl}/api/client/update`, cliente);
  }

  public deleteCliente(clienteId: number): Observable<void> {
    return this.http.delete<void>(`${this.apiServerUrl}/api/client/${clienteId}`);
  }
}
