import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Publisher } from '../model/publisher';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})

export class PublisherService {
  public apiServerUrl = environment.baseUrl;

  constructor(private http: HttpClient) {
  }

  public list(): Observable<Publisher[]> {
    return this.http.get<Publisher[]>(`${this.apiServerUrl}/publishers`);
  }

  public save(publisher: Publisher): Observable<Publisher> {
    return this.http.post<Publisher>(`${this.apiServerUrl}/publishers/add`, publisher);
  }

  public update(publisher: Publisher): Observable<Publisher> {
    return this.http.put<Publisher>(`${this.apiServerUrl}/publishers/update`, publisher);
  }
}
