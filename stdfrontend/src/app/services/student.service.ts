import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Student } from '../models/student'; 

@Injectable({
  providedIn: 'root'
})
export class StudentService {

  private baseUrl = 'http://localhost:8080/api/etudiants';

  constructor(private http: HttpClient) { }

  // GET: Retrieve all Students
  getAllStudents(): Observable<Student[]> {
    return this.http.get<Student[]>(`${this.baseUrl}`);
  }

  // GET: Retrieve a single Student by ID
  getStudentById(id: number): Observable<Student> {
    return this.http.get<Student>(`${this.baseUrl}/${id}`);
  }

  // POST: Create a new Student
  createStudent(student: Student): Observable<Student> {
    return this.http.post<Student>(`${this.baseUrl}`, student);
  }

  // PUT: Update an existing Student
  updateStudent(student: Student): Observable<any> {
    return this.http.put<any>(`${this.baseUrl}/${student.idEtudiant}`, student);
  }

  // DELETE: Delete a Student by ID
  deleteStudent(id: number): Observable<any> {
    return this.http.delete<any>(`${this.baseUrl}/${id}`);
  }
}
