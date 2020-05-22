import { Component, OnInit } from '@angular/core';
import { BevandaService } from 'src/service/bevanda.service';
import { BevandaDTO } from 'src/dto/bevandadto';

@Component({
  selector: 'app-bevande',
  templateUrl: './bevande.component.html',
  styleUrls: ['./bevande.component.css']
})
export class BevandeComponent implements OnInit {

  bevande: BevandaDTO[];
  bevandatoinsert: BevandaDTO = new BevandaDTO();
  
  constructor(private service: BevandaService) { }

  ngOnInit() {
    this.getBevande();
  }

  getBevande() {
    this.service.getAll().subscribe(bevande => this.bevande = bevande);
  }

  delete(bevanda: BevandaDTO) {
    this.service.delete(bevanda.id).subscribe(() => this.getBevande());
  }

  update(bevanda: BevandaDTO) {
    this.service.update(bevanda).subscribe(() => this.getBevande());
  }

  insert(bevanda: BevandaDTO) {
    this.service.insert(bevanda).subscribe(() => this.getBevande());
  }

  clear(){
    this.bevandatoinsert = new BevandaDTO();
  }
}
