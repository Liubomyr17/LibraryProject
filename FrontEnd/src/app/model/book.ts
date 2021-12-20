import {Publisher} from "./publisher";
import {Author} from "./author";

export interface Book {

  id: Number;
  name: String;
  year: String;
  isbn: String;
  publisher: Publisher;
  authors: Array<Author>; // Authors[];
}
