import {NgModule} from "@angular/core";
import {RouterModule, Routes} from "@angular/router";
import {AuthorComponent} from "./component/author/author.component";
import {BookComponent} from "./component/book/book.component";
import {PublisherComponent} from "./component/publisher/publisher.component";

const routes: Routes = [
  {path: 'authors', component: AuthorComponent},
  {path: 'books', component: BookComponent},
  {path: 'publishers', component: PublisherComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
