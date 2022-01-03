import { Component, OnInit } from '@angular/core';
import { Publisher} from "../../model/publisher";
import { PublisherService} from "../../service/publisher.services";
import { HttpErrorResponse } from '@angular/common/http';
import { NgForm } from '@angular/forms';
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'publisher',
  templateUrl: './publisher.component.html',
  styleUrls: ['./publisher.component.css']
})
export class PublisherComponent implements OnInit {

  publisher: Publisher;

  public publishers: Publisher[] = [];

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private publisherService: PublisherService) {
    this.publisher = new Publisher();
  }

  ngOnInit(): void {
    this.list();
  }

  public list(): void {
    this.publisherService.list().subscribe(
      (response: Publisher[]) => {
        this.publishers = response;
        console.log(response)
      }
    )
  }

  public create(addForm: NgForm): void {
    // @ts-ignore
    document.getElementById('add-publisher-form').click();
    this.publisherService.save(addForm.value).subscribe(
      (response: Publisher) => {
        console.log(response);
        this.list();
        addForm.reset();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
        addForm.reset();
      }
    );
  }


  public onOpenModal(publisher: Publisher, mode: string): void {
    const container = document.getElementById('main-container');
    const button = document.createElement('button');
    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-toggle', 'modal');
    if (mode === 'add') {
      button.setAttribute('data-target', '#addPublisherModal');
    }
    if (mode === 'edit') {
      // this.editEmployee = employee;
      button.setAttribute('data-target', '#updatePublisherModal');
    }
    if (mode === 'delete') {
      // this.deleteEmployee = employee;
      button.setAttribute('data-target', '#deletePublisherModal');
    }
    if(container != null) container.appendChild(button);
    button.click();

  }
}
