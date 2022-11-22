import { Component, OnInit } from '@angular/core';
import { HttpErrorResponse } from '@angular/common/http';
import { NgForm } from '@angular/forms';
import { ClienteService } from './client.service';
import { Cliente } from './client';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  public clientes: Cliente[];
  public editCliente: Cliente;
  public deleteCliente: Cliente;

  constructor(private clientService: ClienteService){}

  ngOnInit() {
    this.getClientes();
  }

  public getClientes(): void {
    this.clientService.getCliente().subscribe(
      (response: Cliente[]) => {
        this.clientes = response;
        console.log(this.clientes);
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public onAddCliente(addForm: NgForm): void {
    document.getElementById('add-client-form').click();
    this.clientService.addCliente(addForm.value).subscribe(
      (response: Cliente) => {
        console.log(response);
        this.getClientes();
        addForm.reset();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
        addForm.reset();
      }
    );
  }

  public onUpdateCliente(cliente: Cliente): void {
    this.clientService.updateCliente(cliente).subscribe(
      (response: Cliente) => {
        console.log(response);
        this.getClientes();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public onDeleteCliente(clienteId: number): void {
    this.clientService.deleteCliente(clienteId).subscribe(
      (response: void) => {
        console.log(response);
        this.getClientes();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public searchClient(key: string): void {
    console.log(key);
    const results: Cliente[] = [];
    for (const cliente of this.clientes) {
      if (cliente.nombre.toLowerCase().indexOf(key.toLowerCase()) !== -1
      || cliente.apellido.toLowerCase().indexOf(key.toLowerCase()) !== -1
      || cliente.telefono.toLowerCase().indexOf(key.toLowerCase()) !== -1
      || cliente.direccion.toLowerCase().indexOf(key.toLowerCase()) !== -1
      || cliente.fecha_nacimiento.toLowerCase().indexOf(key.toLowerCase()) !== -1
      || cliente.email.toLowerCase().indexOf(key.toLowerCase()) !== -1) {
        results.push(cliente);
      }
    }
    this.clientes = results;
    if (results.length === 0 || !key) {
      this.getClientes();
    }
  }

  public onOpenModal(cliente: Cliente, mode: string): void {
    const container = document.getElementById('main-container');
    const button = document.createElement('button');
    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-toggle', 'modal');
    if (mode === 'add') {
      button.setAttribute('data-target', '#addClienteModal');
    }
    if (mode === 'edit') {
      this.editCliente = cliente;
      button.setAttribute('data-target', '#updateClienteModal');
    }
    if (mode === 'delete') {
      this.deleteCliente = cliente;
      button.setAttribute('data-target', '#deleteClienteModal');
    }
    container.appendChild(button);
    button.click();
  }



}
