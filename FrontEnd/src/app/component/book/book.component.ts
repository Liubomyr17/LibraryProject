import { Component, OnInit } from "@angular/core";
import { Book } from "../../model/book"
import { BookService } from "../../service/book.services";

@Component({
  selector: 'book',
  templateUrl: './book.component.html',
  styleUrls: ['./book.component.css']
})
export class BookComponent implements OnInit {

  public books: Book[] = [];

  constructor(private bookService: BookService) {}

  ngOnInit() {
    this.list();
  }

  public list(): void {
    this.bookService.list().subscribe(
      (response: Book[]) => {
        this.books = response;
      }
    )
  }
}
