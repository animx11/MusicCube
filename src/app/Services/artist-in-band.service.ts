import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { ArtistInBand } from '../Class/ArtistInBand';

import { api_url } from '../Utils/API_URL';

const apiUrl = api_url;

@Injectable({
  providedIn: 'root',
})
export class ArtistInBandService {
  constructor(private http: HttpClient) {}

  getById(id: number): Observable<any> {
    return this.http.get(`${apiUrl}/artistInBand{id}?id=${id}`);
  }
  list(): Observable<any> {
    return this.http.get(`${apiUrl}/artistInBands`);
  }
  getByArtistId(id: number): Observable<any> {
    return this.http.get(`${apiUrl}/artistInBands{artist}?artistId=${id}`);
  }
  getByBandId(id: number): Observable<any> {
    return this.http.get(`${apiUrl}/artistInBands{band}?bandId=${id}`);
  }
  getByArtistIdIsActive(id: number, active: boolean): Observable<any> {
    return this.http.get(`${apiUrl}/artistInBands{artist,active}?artistId=${id}&active=${active}`);
  }
  getByBandIdIsActive(id: number, active: boolean): Observable<any> {
    return this.http.get(`${apiUrl}/artistInBands{band,active}?bandId=${id}&active=${active}`);
  }



  create(artistInBand: ArtistInBand): Observable<any> {
    return this.http.post(`${apiUrl}/artistInBand`, artistInBand);
  }

  edit(artistInBand: ArtistInBand): Observable<any> {
    return this.http.put(`${apiUrl}/artistInBand`, artistInBand);
  }

  delete(id: number): Observable<any> {
    return this.http.delete(`${apiUrl}/artistInBand/${id}`);
  }
}