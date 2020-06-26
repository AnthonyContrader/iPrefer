import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import * as moment from 'moment';
import { DATE_TIME_FORMAT } from 'app/shared/constants/input.constants';

import { IEvent } from 'app/shared/model/chatbot/event.model';
import { EventService } from './event.service';

@Component({
    selector: 'jhi-event-update',
    templateUrl: './event-update.component.html'
})
export class EventUpdateComponent implements OnInit {
    private _event: IEvent;
    isSaving: boolean;
    dateTime: string;

    constructor(private eventService: EventService, private activatedRoute: ActivatedRoute) {}

    ngOnInit() {
        this.isSaving = false;
        this.activatedRoute.data.subscribe(({ event }) => {
            this.event = event;
        });
    }

    previousState() {
        window.history.back();
    }

    save() {
        this.isSaving = true;
        this.event.dateTime = moment(this.dateTime, DATE_TIME_FORMAT);
        if (this.event.id !== undefined) {
            this.subscribeToSaveResponse(this.eventService.update(this.event));
        } else {
            this.subscribeToSaveResponse(this.eventService.create(this.event));
        }
    }

    private subscribeToSaveResponse(result: Observable<HttpResponse<IEvent>>) {
        result.subscribe((res: HttpResponse<IEvent>) => this.onSaveSuccess(), (res: HttpErrorResponse) => this.onSaveError());
    }

    private onSaveSuccess() {
        this.isSaving = false;
        this.previousState();
    }

    private onSaveError() {
        this.isSaving = false;
    }
    get event() {
        return this._event;
    }

    set event(event: IEvent) {
        this._event = event;
        this.dateTime = moment(event.dateTime).format(DATE_TIME_FORMAT);
    }
}
