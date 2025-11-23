import { Component, signal } from '@angular/core';
import { Comment, CommentService } from '../../services/comment-service';
import { CommonModule } from '@angular/common';


type CommentWithState = Comment & { showFull: boolean };

@Component({
  selector: 'app-comments',
  imports: [CommonModule],
  templateUrl: './comments.component.html',
  styleUrl: './comments.component.css',
})
export class CommentsComponent {
  // signal pour stocker les comments
  comments = signal<CommentWithState[]>([]);  

  // signal pour gérer le loading
  isLoading = signal(true);
  

  constructor(private commentService: CommentService) {}

  ngOnInit(): void {
    this.loadComments();
  }

  loadComments() {
  this.commentService.getAllComments().subscribe({
    next: (data) => {
      // ajouter showFull à chaque commentaire
      const commentsWithState: CommentWithState[] = data.map(c => ({ ...c, showFull: false }));
      this.comments.set(commentsWithState);
      this.isLoading.set(false);
    },
    error: (err) => {
      console.error(err);
      this.isLoading.set(false);
    }
  });
}


}
