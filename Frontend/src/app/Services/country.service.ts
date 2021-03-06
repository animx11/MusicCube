import { Injectable } from '@angular/core';
import {Observable} from 'rxjs';
import {Country} from '../Class/Country';
import {HttpClient} from '@angular/common/http';

import { api_url } from '../Utils/API_URL';

const apiUrl = api_url;

@Injectable({
  providedIn: 'root'
})
export class CountryService {

  constructor(private http: HttpClient) { }

  getById(id: number): Observable<any> {
    return this.http.get(`${apiUrl}/country/${id}`);
  }

  getByCountryName(countryName: string): Observable<any> {
    return this.http.get(`${apiUrl}/country/name/${countryName}/`);
  }


  list(): Observable<any> {
    return this.http.get(`${apiUrl}/country`);
  }

  create(country: Country): Observable<any> {
    return this.http.post(`${apiUrl}/admin/country`, country);
  }

  edit(country: Country): Observable<any> {
    return this.http.put(`${apiUrl}/admin/country`, country);
  }

  delete(id: number, countryName: string): Observable<any> {
    return this.http.delete(`${apiUrl}/admin/country/${id}/${countryName}`);
  }
}
