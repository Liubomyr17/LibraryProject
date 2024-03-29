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
  constructor(private http: HttpClient) {}

  public list(): Observable<Publisher[]> {
    return this.http.get<Publisher[]>(`${this.apiServerUrl}/publishers`);
  }
}
