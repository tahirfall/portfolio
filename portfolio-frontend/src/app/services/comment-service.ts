import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface Comment {
  id: number;
  userFullName: string;
  position: string;
  commentText: string;
  snapshotUrl: string; 
}

@Injectable({
  providedIn: 'root'
})
export class commentService {

  private apiUrl = 'http://localhost:8081/api/v1/comments';

  constructor(private http: HttpClient) {}

  getAllComments(): Observable<Comment[]> {
    return this.http.get<Comment[]>(this.apiUrl);
  }
}
