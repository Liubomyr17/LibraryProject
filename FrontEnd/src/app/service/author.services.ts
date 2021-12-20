import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Author } from '../model/author';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';

@Injectable({
    providedIn: 'root'
  })
export class AuthorService {

    public apiServerUrl = environment.baseUrl;
    constructor(private http: HttpClient) {}

    public list(): Observable<Author[]> {
    return this.http.get<Author[]>(`${this.apiServerUrl}/authors`);
  }
}


