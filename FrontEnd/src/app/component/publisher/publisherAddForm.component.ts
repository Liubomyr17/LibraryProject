import {Component} from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import {PublisherService} from "../../service/publisher.services";
import {Publisher} from "../../model/publisher";

@Component({
  selector: 'app-user-form',
  templateUrl: './publisherAddForm.html',
  styleUrls: ['./publisher.component.css']
})
export class PublisherAddFormComponent {

  publisher: Publisher;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private publisherService: PublisherService) {
    this.publisher = new Publisher();
  }

  onSubmit() {
    this.publisherService.save(this.publisher).subscribe(() => this.toPublisherList());
  }

  toPublisherList() {
    this.router.navigate(['/publishers']);
  }
}
