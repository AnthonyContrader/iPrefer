import { element, by, ElementFinder } from 'protractor';

export class EventComponentsPage {
    createButton = element(by.id('jh-create-entity'));
    title = element.all(by.css('jhi-event div h2#page-heading span')).first();

    async clickOnCreateButton() {
        await this.createButton.click();
    }

    async getTitle() {
        return this.title.getAttribute('jhiTranslate');
    }
}

export class EventUpdatePage {
    pageTitle = element(by.id('jhi-event-heading'));
    saveButton = element(by.id('save-entity'));
    cancelButton = element(by.id('cancel-save'));
    eventNameInput = element(by.id('field_eventName'));
    dateTimeInput = element(by.id('field_dateTime'));
    descriptionInput = element(by.id('field_description'));

    async getPageTitle() {
        return this.pageTitle.getAttribute('jhiTranslate');
    }

    async setEventNameInput(eventName) {
        await this.eventNameInput.sendKeys(eventName);
    }

    async getEventNameInput() {
        return this.eventNameInput.getAttribute('value');
    }

    async setDateTimeInput(dateTime) {
        await this.dateTimeInput.sendKeys(dateTime);
    }

    async getDateTimeInput() {
        return this.dateTimeInput.getAttribute('value');
    }

    async setDescriptionInput(description) {
        await this.descriptionInput.sendKeys(description);
    }

    async getDescriptionInput() {
        return this.descriptionInput.getAttribute('value');
    }

    async save() {
        await this.saveButton.click();
    }

    async cancel() {
        await this.cancelButton.click();
    }

    getSaveButton(): ElementFinder {
        return this.saveButton;
    }
}
