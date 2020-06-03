//import {Usertype} from './usertype';

/**
 * Classe DTO di User. DEVE essere uguale (stesso nome classe, stessi attributi e stessi nomi) a
 * quello nel backend. 
 * 
 * @see Usertype
 * 
 * @author Vittorio Valent
 */
export class UserDTO {

   //id: number;

   //username: string;

   //password: string;

   //usertype: Usertype;
   
      activated:boolean;
      authorities:string[];
      createdBy:string;
      createdDate:string;
      email:string;
      firstname:string;
      id:number;
      
        
      imageUrl: string;
      langKey: string;
      lastModifiedBy: string;
      lastModifiedDate: any;
      lastName: string;
      login: string
      
    
}

