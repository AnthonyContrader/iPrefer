import { PrenotazioneDTO } from './prenotazionedto';
import {UserDTO} from './userdto';


export class RecensioneDTO{
    id: number;
    voto: number;
    testo: String;
    prenotazioneId: number;
    prenotazione: PrenotazioneDTO;
}