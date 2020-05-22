import { Component, OnInit } from '@angular/core';
import { ClienteService } from 'src/service/cliente.service';
import { ClienteDTO } from 'src/dto/clientedto';

@Component({
  selector: 'app-clienti',
  templateUrl: './clienti.component.html',
  styleUrls: ['./clienti.component.css']
})
export class ClientiComponent implements OnInit {

  clienti: ClienteDTO[];
  clientetoinsert: ClienteDTO = new ClienteDTO();

  constructor(private service: ClienteService) { }

  ngOnInit() {
    this.getClienti();
  }

  getClienti() {
    this.service.getAll().subscribe(clienti => this.clienti = clienti);
  }

  delete(cliente: ClienteDTO) {
    this.service.delete(cliente.id).subscribe(() => this.getClienti());
  }

  update(cliente: ClienteDTO) {
    this.service.update(cliente).subscribe(() => this.getClienti());
  }

  insert(cliente: ClienteDTO) {
    this.service.insert(cliente).subscribe(() => this.getClienti());
  }

  clear(){
    this.clientetoinsert = new ClienteDTO();
  }
}