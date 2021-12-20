import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Book } from '../model/book';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class BookService {

  public apiServerUrl = environment.baseUrl;
  constructor(private http: HttpClient) {}

  public list(): Observable<Book[]> {
    return this.http.get<Book[]>(`${this.apiServerUrl}/books`);
  }
}
