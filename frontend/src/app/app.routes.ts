import { Routes } from '@angular/router';
import { HealthStatusComponent } from './health-status/health-status.component';
import { HomeComponent } from './home/home.component';
import { FetchComponent } from './fetch/fetch.component';
import { ExplorerComponent } from './explorer/explorer.component';
import { ProgressComponent } from './progress/progress.component';
import { ArticleComponent } from './article/article.component';
import { HotspotsComponent } from './hotspots/hotspots.component';
import { HotspotsCourseComponent } from './hotspots-course/hotspots-course.component';
import { AboutComponent } from './about/about.component';
import { RoadmapComponent } from './roadmap/roadmap.component';
import { CurveComponent } from './curve/curve.component';

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
        path: 'explorer',
        component: ExplorerComponent,
        title: "Explorer",
    },
    {
        path: 'progress',
        component: ProgressComponent,
        title: "Levels",
    },
    {
        path: 'article',
        component: ArticleComponent,
        title: "Article",
    },
    {
        path: 'hotspots',
        component: HotspotsComponent,
        title: "Hotspots Playground",
    },
    {
        path: 'hotspots-course',
        component: HotspotsCourseComponent,
        title: "Hotspots Course",
    },
    {
        path: 'about',
        component: AboutComponent,
        title: "About Us",
    },
    {
        path: 'roadmap',
        component: RoadmapComponent,
        title: "Roadmap",
    },
    {
        path: 'curve',
        component: CurveComponent,
        title: "Curve",
    }
    

];

export default routes;
