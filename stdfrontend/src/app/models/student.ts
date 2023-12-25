export class Student {
    idEtudiant: number;
    name: string;
    cin: string;
    level: string;
  
    constructor(idEtudiant: number, name: string, cin: string, level: string) {
      this.idEtudiant = idEtudiant;
      this.name = name;
      this.cin = cin;
      this.level = level;
    }
  }
  