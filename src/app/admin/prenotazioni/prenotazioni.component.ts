import { Component, OnInit } from '@angular/core';
import { PrenotazioneService} from 'src/service/prenotazione.service';
import { Subscriber } from 'rxjs';
import { PrenotazioneDTO } from 'src/dto/prenotazioneDTO';

@Component({
  selector: 'app-prenotazioni',
  templateUrl: './prenotazioni.component.html',
  styleUrls: ['./prenotazioni.component.css']
})
export class PrenotazioniComponent implements OnInit {

  prenotazioni: PrenotazioneDTO[];
  prenotazionetoinsert: PrenotazioneDTO = new PrenotazioneDTO();

  constructor(private service: PrenotazioneService) { }

  ngOnInit() {
    this.getPrenotazioni();
  }

  getPrenotazioni(){
    this.service.getAll().subscribe(prenotazioni => this.prenotazioni = prenotazioni);
  }

  delete(prenotazione: PrenotazioneDTO) {
    this.service.delete(prenotazione.id).subscribe(()=> this.getPrenotazioni());
  }

  update(prenotazione: PrenotazioneDTO) {
    this.service.update(prenotazione).subscribe(() => this.getPrenotazioni());
  }

  insert(prenotazione: PrenotazioneDTO) {
    this.service.insert(prenotazione).subscribe(() => this.getPrenotazioni());
  }

  clear(){
    this.prenotazionetoinsert = new PrenotazioneDTO();
  }
}
