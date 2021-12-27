import {Component, OnInit} from "@angular/core";
import {Author} from "../../model/author"
import {AuthorService} from "../../service/author.services";

@Component({
  selector: 'author',
  templateUrl: './author.component.html',
  styleUrls: ['./author.component.css']
})
export class AuthorComponent implements OnInit {

  public authors: Author[] = [];

  constructor(private authorService: AuthorService) {
  }

  ngOnInit() {
    this.list();
  }

  public list(): void {
    this.authorService.list().subscribe(
      (response: Author[]) => {
        this.authors = response;
      }
    )
  }
}
