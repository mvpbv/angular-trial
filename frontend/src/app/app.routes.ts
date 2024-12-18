import { Routes } from '@angular/router';
import { HealthStatusComponent } from './health-status/health-status.component';
import { HomeComponent } from './home/home.component';
import { FetchComponent } from './fetch/fetch.component';
import { AnalyticsComponent } from './analytics/analytics.component';
import { ProgressComponent } from './progress/progress.component';

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
    }, 
    {
        path: 'fetch',
        component: FetchComponent,
        title: "Fetch",
    },
    {
        path: 'analytics',
        component: AnalyticsComponent,
        title: "Analytics",
    },
    {
        path: 'progress',
        component: ProgressComponent,
        title: "Levels",
    }
    

];

export default routes;
