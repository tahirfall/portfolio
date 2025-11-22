import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';

@Component({
  selector: 'app-resume',
  imports: [CommonModule],
  templateUrl: './resume.component.html',
  styleUrl: './resume.component.css',
})
export class ResumeComponent {
  activeTab: 'en' | 'fr' = 'en'; 

  downloadCV(lang: 'en' | 'fr') {
    const file = lang === 'en'
      ? 'assets/resume_en.pdf'
      : 'assets/resume_fr.pdf';

    window.open(file, '_blank');
  }
}
