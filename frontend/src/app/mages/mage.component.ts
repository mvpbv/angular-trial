import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-mages',
  imports: [],
  templateUrl: './mage.component.html',
  styleUrl: './mage.component.css'
})
export class MageComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
    (window as any).hljs.hightlightAll();
  }
  copyAllCode(): void {
    const codeBlock = document.querySelector('code');
    if (codeBlock) {
      const text = codeBlock.textContent || '';
      navigator.clipboard.writeText(text).then(() => {
        console.log('Code copied to clipboard');
      }).catch(err => {
        console.error('Failed to copy code to clipboard', err);
      })
    }

  }

}
