import {PiattoDTO} from './piattodto'
import {BevandaDTO} from './bevandadto'
import {PrenotazioneDTO} from './prenotazionedto' 


export class OrdinazioneDTO{
    id: number;
    costotot: number;
    dataora: Date;
    Piatto: PiattoDTO;
    Bevanda: BevandaDTO;
    prenotazione: PrenotazioneDTO;

}