import { Moment } from 'moment';

export interface IEvent {
    id?: number;
    eventName?: string;
    dateTime?: Moment;
    description?: string;
}

export class Event implements IEvent {
    constructor(public id?: number, public eventName?: string, public dateTime?: Moment, public description?: string) {}
}
