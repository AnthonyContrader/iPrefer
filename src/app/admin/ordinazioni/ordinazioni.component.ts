import { Component, OnInit } from '@angular/core';
import { OrdinazioneService } from 'src/service/ordinazione.service';
import { OrdinazioneDTO } from 'src/dto/ordinazionedto';
import { PiattoDTO } from 'src/dto/piattodto';
import {PiattoService} from 'src/service/piatto.service';
import {BevandaService} from 'src/service/bevanda.service';
import {PrenotazioneService} from 'src/service/prenotazione.service';
import { BevandaDTO } from 'src/dto/bevandadto';
import { PrenotazioneDTO } from 'src/dto/prenotazionedto';


@Component({
    selector: 'app-ordinazioni',
    templateUrl: './ordinazioni.component.html',
    styleUrls: ['./ordinazioni.component.css']
  })
  export class OrdinazioniComponent implements OnInit{

    ordinazioni: OrdinazioneDTO[];
    ordinazionetoinsert: OrdinazioneDTO = new OrdinazioneDTO();
    piatti: PiattoDTO[];
    bevande: BevandaDTO[];
    prenotazioni: PrenotazioneDTO[];
    
  
    constructor(private service: OrdinazioneService, private service_piatto: PiattoService,private service_bevanda: BevandaService,private service_prenotazione:PrenotazioneService) { }
  
    ngOnInit() {
      this.getOrdinazioni();
      this.getPiatti();
      this.getBevande();
      this.getPrenotazioni();
      this.ordinazionetoinsert = new OrdinazioneDTO();
      this.ordinazionetoinsert.piattos = [new PiattoDTO()];
      this.ordinazionetoinsert.bevandas = [new BevandaDTO()];
    }
  
    getOrdinazioni() {
      this.service.getAll().subscribe(ordinazioni =>{ this.ordinazioni = ordinazioni, console.log(ordinazioni[1].piattos[0])});
    }
    getPiatti(){
      this.service_piatto.getAll().subscribe(piatti => this.piatti = piatti);
    }
    getBevande(){
      this.service_bevanda.getAll().subscribe(bevande => this.bevande = bevande);
    }
    getPrenotazioni(){
      this.service_prenotazione.getAll().subscribe(prenotazioni => this.prenotazioni = prenotazioni);
    }
    delete(ordinazione: OrdinazioneDTO) {
      this.service.delete(ordinazione.id).subscribe(() => this.getOrdinazioni());
    }
  
    update(ordinazione: OrdinazioneDTO) {
      this.service.update(ordinazione).subscribe(() => this.getOrdinazioni());
    }
  
    insert(ordinazione: OrdinazioneDTO) {
      this.service.insert(ordinazione).subscribe(() => this.getOrdinazioni());
    }
  
    clear(){
      this.ordinazionetoinsert = new OrdinazioneDTO();
    }
  }
  