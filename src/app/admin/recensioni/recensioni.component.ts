import { Component, OnInit } from '@angular/core';
import { RecensioneDTO } from 'src/dto/recensionedto';
import { RecensioneService } from 'src/service/recensione.service';
import { PrenotazioneDTO } from 'src/dto/prenotazionedto';
import { PrenotazioneService } from 'src/service/prenotazione.service';
import { UserDTO } from 'src/dto/userdto';


@Component({
  selector: 'app-recensioni',
  templateUrl: './recensioni.component.html',
  styleUrls: ['./recensioni.component.css']
})
export class RecensioniComponent implements OnInit {

  recensioni: RecensioneDTO[];
  recensionetoinsert: RecensioneDTO = new RecensioneDTO();
  prenotazioni: PrenotazioneDTO[];
  //me: UserDTO;

  constructor(private service: RecensioneService, private prenotazioneService: PrenotazioneService) { }

  ngOnInit() {
    this.getRecensioni();
    //this.me = JSON.parse(localStorage.getItem('currentUser'));
    this.getPrenotazioni();
  }

  getRecensioni(){
    this.service.getAll().subscribe(recensioni => this.recensioni = recensioni);
  }
  getPrenotazioni(){
    this.prenotazioneService.getAll().subscribe(prenotazioni => this.prenotazioni = prenotazioni);
  }

  delete(recensione: RecensioneDTO) {
    this.service.delete(recensione.id).subscribe(() => this.getRecensioni());
  }

  update(recensione: RecensioneDTO) {
    this.service.update(recensione).subscribe(() => this.getRecensioni());
  }

  insert(recensione: RecensioneDTO) {
    this.service.insert(recensione).subscribe(() => this.getRecensioni());
  }

  clear(){
    this.recensionetoinsert = new RecensioneDTO();
  }

}
