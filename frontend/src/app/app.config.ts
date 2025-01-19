import { ApplicationConfig, provideZoneChangeDetection } from '@angular/core';
import { provideRouter } from '@angular/router';
import { routes } from './app.routes';
import { provideHttpClient } from '@angular/common/http';
import {provideHighlightOptions} from 'ngx-highlightjs';

export const appConfig: ApplicationConfig = {
  providers: [provideZoneChangeDetection({ eventCoalescing: true }),
     provideRouter(routes),
     provideHttpClient(),
     provideHighlightOptions({
       coreLibraryLoader: () => import('highlight.js/lib/core'),
       lineNumbersLoader: () => import('ngx-highlightjs/line-numbers'),
       languages: {
         python: () => import('highlight.js/lib/languages/python'),
       },
       themePath: 'assets/highlightjs/styles/monokai-sublime.css',
     })
    ],
};
