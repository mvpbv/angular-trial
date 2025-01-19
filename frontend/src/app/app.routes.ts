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
import { LinksComponent } from './links/links.component';
import {FaqComponent} from './faq/faq.component';
import {MageComponent} from './mages/mage.component';
import {ExerciseNavigatorComponent} from './exercise-navigator/exercise-navigator.component';
import {ResourcesComponent} from './resources/resources.component';
import {RecursionComponent} from './recursion/recursion.component';
import {SignUpComponent} from './sign-up/sign-up.component';

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
      path: 'faq',
      component: FaqComponent,
      title: "FAQ",
    },
  {
    path: 'mages',
    component: MageComponent,
    title: "Exercise",
  },
  {
    path: 'recursion',
    component: RecursionComponent,
    title: "Recursion",
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
    },
    {
        path: 'links',
        component: LinksComponent,
        title: "Links",
    },
  {
    path: 'exercises',
    component: ExerciseNavigatorComponent,
    title: "Exercise Navigator",
  },
  {
    path: 'resources',
    component: ResourcesComponent,
    title: "Resources",
  },
  {
    path: 'sign-up',
    component: SignUpComponent,
    title: "Sign Up",
  }


];

export default routes;
