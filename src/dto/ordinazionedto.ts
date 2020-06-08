import {PiattoDTO} from './piattodto'
import {BevandaDTO} from './bevandadto'
import {PrenotazioneDTO} from './prenotazionedto' 


export class OrdinazioneDTO{
    id: number;
    costotot: number;
    dataora: Date;

    

    piattos: PiattoDTO[];
    bevandas: BevandaDTO[];
    prenotazioneId: number;

    /*piattos : PiattoDTO;
    bevandas: BevandaDTO;*/

    


}