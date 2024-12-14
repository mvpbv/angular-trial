import { Routes } from '@angular/router';
import { HealthStatusComponent } from './health-status/health-status.component';
import { HomeComponent } from './home/home.component';

export const routes: Routes = [
    { 
        path: 'health',
        component: HealthStatusComponent,
        title: "Healthz",
    },
    {
        path: '',
        component: HomeComponent,
        title: "Home",
    }
    

];

export default routes;
