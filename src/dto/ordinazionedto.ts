import {PiattoDTO} from './piattodto'
import {BevandaDTO} from './bevandadto'
import {PrenotazioneDTO} from './prenotazionedto' 


export class OrdinazioneDTO{
    id: number;
    costo_tot: number;
    data_ora: Date;
    Piatto: PiattoDTO;
    Bevanda: BevandaDTO;
    prenotazione: PrenotazioneDTO;

}