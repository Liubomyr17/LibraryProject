import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http'
import { AppRoutingModule } from './app-routing.module';
import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { AuthorComponent } from './component/author/author.component';
import { AuthorService } from './service/author.services';
import { BookComponent } from './component/book/book.component';
import { BookService } from "./service/book.services";
import { PublisherService } from "./service/publisher.services";
import { PublisherComponent } from "./component/publisher/publisher.component";
import { PublisherAddFormComponent } from "./component/publisher/publisherAddForm.component"
import { PublisherUpdateFormComponent} from "./component/publisher/publisherUpdateForm.component";

@NgModule({
  declarations: [
    AppComponent,
    AuthorComponent,
    BookComponent,
    PublisherComponent,
    PublisherAddFormComponent,
    PublisherUpdateFormComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [AuthorService, BookService, PublisherService],
  bootstrap: [AppComponent]
})
export class AppModule { }
