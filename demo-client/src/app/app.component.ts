import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { catchError, map } from 'rxjs/operators';

@Component({
  selector: 'app-root',
  template: `
    <h1>Welcome to {{ title }}!</h1>
  `,
  styles: [],
})
export class AppComponent implements OnInit {
  title = 'demo-client';

  private httpOptions = {
    headers: new HttpHeaders({
      // 'Content-Type': 'application/x-www-form-urlencoded',
      'Content-Type': 'application/json',
    }),
  };
  constructor(private http: HttpClient) {}

  ngOnInit() {
    this.post().subscribe(res => console.log(res));
  }

  post() {
    return this.http
      .post('http://localhost:8080/', null, {
        ...this.httpOptions,
        observe: 'response',
        withCredentials: true,
      })
      .pipe(
        map(response => {
          console.log(document.cookie);
          console.log(response);
          console.log(response && response.headers);
          console.log(response && response.headers && response.headers.keys());
          return response.body;
        }),
        catchError(this.handleError),
      );
  }

  private handleError(error: any): Observable<{}> {
    console.error(error);
    return of({ error });
  }
}
