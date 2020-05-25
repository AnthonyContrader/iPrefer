import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { AdminRoutingModule } from './admin-routing.module';
import { AdminDashboardComponent } from './admin-dashboard/admin-dashboard.component';
import { UsersComponent } from './users/users.component';
import { PrenotazioniComponent } from './prenotazioni/prenotazioni.component';
import { WorkInProgressComponent } from './work-in-progress/work-in-progress.component';
import { RecensioniComponent } from './recensioni/recensioni.component';
import { ClientiComponent } from './clienti/clienti.component';
import { PiattiComponent } from './piatti/piatti.component';
import { BevandeComponent } from './bevande/bevande.component';
import { OrdinazioniComponent } from './ordinazioni/ordinazioni.component';

/**
 * Modulo dell'admin, qui vengono dichiarate le component che utilizza 
 * l'admin. Questo modulo importa AdminRoutingModule.
 * 
 * @author Vittorio Valent
 * 
 * @see AdminRoutingModule
 */
@NgModule({
  declarations: [AdminDashboardComponent, UsersComponent, WorkInProgressComponent, BevandeComponent, PiattiComponent, ClientiComponent, PrenotazioniComponent, OrdinazioniComponent, RecensioniComponent],
  imports: [
    CommonModule,
    AdminRoutingModule,
    FormsModule
  ]
})
export class AdminModule { }
