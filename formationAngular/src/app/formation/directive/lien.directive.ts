import { Directive, ElementRef, Renderer2, OnInit } from '@angular/core';

@Directive({
  selector: '[ngLink]',
})
export class LienDirective implements OnInit {
  constructor(private renderer: Renderer2, private el: ElementRef) {}
  ngOnInit(): void {
    this.renderer.addClass(this.el.nativeElement, 'btn');
    this.renderer.addClass(this.el.nativeElement, 'btn-link');
  }
}
