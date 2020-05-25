import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AdminLayoutComponent } from '../layout/admin-layout/admin-layout.component';
import { AdminDashboardComponent } from './admin-dashboard/admin-dashboard.component';
import { UsersComponent } from './users/users.component';
import { PrenotazioniComponent } from './prenotazioni/prenotazioni.component';
import { WorkInProgressComponent } from './work-in-progress/work-in-progress.component';
import { RecensioniComponent } from './recensioni/recensioni.component';
import { ClientiComponent } from './clienti/clienti.component';
import { PiattiComponent } from './piatti/piatti.component';
import { BevandeComponent } from './bevande/bevande.component';
//import { OrdinazioniComponent } from './ordinazioni/ordinazioni.component';

/**
 * Modulo di routing dell'admin. Qui ci sono i percorsi che un admin può seguire:
 * appena fa il login viene caricato nel <router-outlet> di app-component il layout e nel 
 * <router-outlet> del layout (come percorsi "children") vengono visualizzati gli altri 
 * (qui sotto sono indentati).
 * 
 * @author Vittorio Valent
 * 
 * @see AdminLayoutComponent
 * 
 * @see layout
 */
const routes: Routes = [
  { path: 'admin-dashboard', component: AdminLayoutComponent, children:[
    { path: '', component: AdminDashboardComponent},
    { path: 'users', component: UsersComponent},
    { path: 'clienti', component: ClientiComponent},
    { path: 'piatti', component: PiattiComponent},
    { path: 'bevande', component: BevandeComponent},
    { path: 'prenotazioni', component: PrenotazioniComponent},
    { path: 'ordinazioni', component: OrdinazioniComponent},
    { path: 'recensioni', component: RecensioniComponent},
    { path: 'work-in-progress', component: WorkInProgressComponent}
  ]}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AdminRoutingModule { }