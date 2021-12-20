import { Component, OnInit } from "@angular/core";
import { Publisher } from "../../model/publisher"
import { PublisherService } from "../../service/publisher.services";

@Component({
  selector: 'publisher',
  templateUrl: './publisher.component.html',
  styleUrls: ['./publisher.component.css']
})
export class PublisherComponent implements OnInit {

  public publishers: Publisher[] = [];

  constructor(private publisherService: PublisherService) {}

  ngOnInit() {
    this.list();
  }

  public list(): void {
    this.publisherService.list().subscribe(
      (response: Publisher[]) => {
        this.publishers = response;
      }
    )
  }
}
