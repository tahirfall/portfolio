import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';

@Component({
  selector: 'app-cv',
  imports: [CommonModule],
  templateUrl: './cv.component.html',
  styleUrl: './cv.component.css',
})
export class CvComponent {
  activeTab: 'en' | 'fr' = 'en'; 

  downloadCV(lang: 'en' | 'fr') {
    const file = lang === 'en'
      ? 'assets/cv_en.pdf'
      : 'assets/cv_fr.pdf';

    window.open(file, '_blank');
  }
}
