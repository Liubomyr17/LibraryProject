import {NgModule} from "@angular/core";
import {RouterModule, Routes} from "@angular/router";
import {AuthorComponent} from "./component/author/author.component";
import {BookComponent} from "./component/book/book.component";
import {PublisherComponent} from "./component/publisher/publisher.component";
import {PublisherAddFormComponent} from "./component/publisher/publisherAddForm.component";
import { PublisherUpdateFormComponent} from "./component/publisher/publisherUpdateForm.component";

const routes: Routes = [
  {path: 'authors', component: AuthorComponent},
  {path: 'books', component: BookComponent},
  {path: 'publishers', component: PublisherComponent},
  {path: 'add', component: PublisherAddFormComponent},
  {path: 'publishers/id', component: PublisherComponent},
  {path: 'update', component: PublisherUpdateFormComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
