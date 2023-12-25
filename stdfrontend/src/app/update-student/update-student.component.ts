import { Component, OnInit } from '@angular/core';
import { Student } from '../models/student';
import { StudentService } from '../services/student.service';
import { ActivatedRoute, Router } from '@angular/router';
import { identifierName } from '@angular/compiler';

@Component({
  selector: 'app-update-student',
  templateUrl: './update-student.component.html',
  styleUrl: './update-student.component.css'
})
export class UpdateStudentComponent implements OnInit{
  student: Student = new Student(0,"","","");
  constructor(private studentService: StudentService,private route: ActivatedRoute,private router: Router) {
  }
  ngOnInit(): void {
    var studentId: number;
    studentId = this.route.snapshot.params['id'];
    this.getStudentById(studentId);
  }
  onSubmit():void{
    this.studentService.updateStudent(this.student).subscribe(
      (response: any) => {
        console.log(response);
        this.router.navigate(['']);
      },
      (error) => {
        console.error('Post error:', error);
      }
    );
  }
  getStudentById(id: number) :void{
    this.studentService.getStudentById(id).subscribe(data => {
      this.student = data;
    });
  }
}
