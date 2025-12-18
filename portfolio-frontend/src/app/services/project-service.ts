import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from '../../environments/environment';

export interface Project {
  id: number;
  title: string;
  description: string;
  stack: string;
  link: string;
}

@Injectable({
  providedIn: 'root'
})
export class ProjectService {

  //private apiUrl = environment.apiUrl;
  private url = 'assets/data/projects.json';

  constructor(private http: HttpClient) {}

  getAllProjects(): Observable<Project[]> {
    //return this.http.get<Project[]>(`${this.apiUrl}projects`);

    return this.http.get<Project[]>(this.url);
  }
}
