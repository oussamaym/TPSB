import { Component, OnInit } from '@angular/core';
import { Student } from '../models/student';
import { HttpClient } from '@angular/common/http';
import { StudentService } from '../services/student.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-student-details',
  templateUrl: './student-details.component.html',
  styleUrl: './student-details.component.css'
})
export class StudentDetailsComponent implements OnInit{
  student: Student | undefined;
 
  constructor(private route: ActivatedRoute,private http:HttpClient,private studentService: StudentService,private router: Router) {}
  ngOnInit(): void {
    var studentId =null;
    studentId= +this.route.snapshot.paramMap.get('id')!;
    this.getStudentById(studentId);
  }
    getStudentById(id: number): void {
      this.studentService.getStudentById(id).subscribe(
        (student: Student) => {
          this.student = student;
        },
        (error) => {
          console.error('Une erreur s\'est produite lors de la récupération des détails de l\'étudiant.', error);
        }
      );
    }
    goBack() {
      
      this.router.navigate(['']); 
  }

}
