import { Component, signal } from '@angular/core';
import { NavbarComponent } from './components/navbar/navbar.component';
import { AboutComponent } from './components/about/about.component';
import { WorkComponent } from './components/work/work.component';
import { ProjectsComponent} from './components/projects/projects.component';
import { CommentsComponent } from './components/comments/comments.component';
import { ContactComponent } from './components/contact/contact.component';
import { CvComponent } from './components/cv/cv.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [NavbarComponent, AboutComponent, WorkComponent, ProjectsComponent, CommentsComponent, CvComponent, ContactComponent],
  templateUrl: './app.html',
  styleUrls: ['./app.css']
})
export class App {
  protected readonly title = signal('portfolio-frontend');
}