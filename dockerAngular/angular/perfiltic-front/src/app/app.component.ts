import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthenticationService } from './services/AuthenticationService';
import { User } from './models/User';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'perfiltic-front';
  currentUser: User;

  constructor(private router: Router,
    private authenticationService: AuthenticationService){
      this.authenticationService.currentUser.subscribe(x => this.currentUser = x);
  }

  logout() {
    this.authenticationService.logout();
    this.router.navigate(['/login']);
}
}


