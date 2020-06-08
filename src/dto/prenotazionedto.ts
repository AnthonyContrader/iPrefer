
import {ClienteDTO} from './clientedto';

/**
 * Classe DTO di User. DEVE essere uguale (stesso nome classe, stessi attributi e stessi nomi) a
 * quello nel backend. 
 * 
 * @see Usertype
 * 
 * @author Vittorio Valent
 */
export class PrenotazioneDTO {

    id: number;

    dataora: Date;

    tavolo: number;

    clienteId: number;

    cliente: ClienteDTO;
	

}

