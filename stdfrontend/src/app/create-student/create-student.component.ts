import { Component } from '@angular/core';
import { Student } from '../models/student';
import { StudentService } from '../services/student.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create-student',
  templateUrl: './create-student.component.html',
  styleUrl: './create-student.component.css'
})
export class CreateStudentComponent {
  student: Student = new Student(0,"","","");
  constructor(private studentService: StudentService,private router: Router) {
  }
  onSubmit():void{
    this.studentService.createStudent(this.student).subscribe(
      (response: any) => {
        console.log(response);
        this.router.navigate(['']);
      },
      (error) => {
        console.error('Post error:', error);
      }
    );
  }

}
