import { Component, effect, OnInit, signal } from '@angular/core';
import { Project, ProjectService } from '../../services/project-service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-projects',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './projects.component.html',
  styleUrls: ['./projects.component.css'],
})
export class ProjectsComponent implements OnInit {

  // signal pour stocker les projets
  projects = signal<Project[]>([]);  

  // signal pour gérer le loading
  isLoading = signal(true);

  constructor(private projectService: ProjectService) {}

  ngOnInit(): void {
    this.loadProjects();
  }

  loadProjects() {
    this.projectService.getAllProjects().subscribe({
      next: (data) => {
        this.projects.set(data);     // assigner les projets via signal
        this.isLoading.set(false);   // mettre fin au loading
      },
      error: (err) => {
        console.error(err);
        this.isLoading.set(false);
      }
    });
  }

}