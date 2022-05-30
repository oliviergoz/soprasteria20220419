import { Directive, ElementRef, Renderer2, OnInit } from '@angular/core';

@Directive({
  selector: '[appDemo]',
})
export class DemoDirective implements OnInit {
  constructor(private renderer: Renderer2, private elementRef: ElementRef) {}

  ngOnInit(): void {
    this.renderer.appendChild(
      this.elementRef.nativeElement,
      this.renderer.createText('hello world')
    );
  }
}
