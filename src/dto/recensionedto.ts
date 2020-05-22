import { PrenotazioneDTO } from './prenotazionedto';


export class RecensioneDTO{
    id: number;
    voto: number;
    testo: String;
    prenotazione: PrenotazioneDTO;
}