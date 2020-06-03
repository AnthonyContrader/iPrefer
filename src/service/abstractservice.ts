import { Service } from './service';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';


export abstract class AbstractService<DTO> implements Service<DTO> {

    type: string;
	authorization: string = localStorage.getItem('token');
	headerAuth = new HttpHeaders({
		'Authorization': this.authorization
	});

    constructor(protected http: HttpClient) {
    }

    getAll(): Observable<DTO[]> {
		return this.http.get<DTO[]>('http://localhost:8080/ristoranteapp/api/' + this.type , { headers: this.headerAuth });
		
    }

    read(id: number): Observable<DTO> {
        return this.http.get<DTO>('http://localhost:8080/ristoranteapp/api/' + this.type + '/' + id ,{
			headers: this.headerAuth});
    }

    delete(id: number): Observable<any> {
        return this.http.delete('http://localhost:8080/ristoranteapp/api/' + this.type + '/' + id ,{
			headers: this.headerAuth});
    }

    insert(dto: DTO): Observable<any> {
        return this.http.post('http://localhost:8080/ristoranteapp/api/' + this.type , dto ,{
			headers: this.headerAuth});
    }

    update(dto: DTO): Observable<DTO> {
        return this.http.put<DTO>('http://localhost:8080/ristoranteapp/api/' + this.type , dto ,{
			headers: this.headerAuth});

    }

}