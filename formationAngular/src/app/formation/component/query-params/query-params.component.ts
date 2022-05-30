import { ActivatedRoute, Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-query-params',
  templateUrl: './query-params.component.html',
  styleUrls: ['./query-params.component.css'],
})
export class QueryParamsComponent implements OnInit {
  constructor(private activedRoute: ActivatedRoute, private router: Router) {}

  ngOnInit(): void {
    this.activedRoute.queryParams.subscribe((params) => {
      console.log(params['info']);
    });
  }

  home() {
    this.router.navigate(['/home'], { queryParams: { info: 'retourhome' } });
    // this.router.navigateByUrl('/home');
  }
}
