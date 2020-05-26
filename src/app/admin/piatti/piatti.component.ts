import { Component, OnInit } from '@angular/core';
import { PiattoService } from 'src/service/piatto.service';
import { PiattoDTO } from 'src/dto/piattodto';


@Component({
  selector: 'app-piatti',
  templateUrl: './piatti.component.html',
  styleUrls: ['./piatti.component.css']
})
export class PiattiComponent implements OnInit {

  piatto: PiattoDTO[];
  piattotoinsert: PiattoDTO = new PiattoDTO();

  constructor(private service: PiattoService) { }

  ngOnInit() {
    this.getPiatto();
  }

  getPiatto() {
    this.service.getAll().subscribe(piatto => this.piatto = piatto);
  }

  delete(piatto: PiattoDTO) {
    this.service.delete(piatto.id).subscribe(() => this.getPiatto());
  }

  update(piatto: PiattoDTO) {
    this.service.update(piatto).subscribe(() => this.getPiatto());
  }

  insert(piatto: PiattoDTO) {
    this.service.insert(piatto).subscribe(() => this.getPiatto());
  }

  clear(){
    this.piattotoinsert = new PiattoDTO();
  }


}
