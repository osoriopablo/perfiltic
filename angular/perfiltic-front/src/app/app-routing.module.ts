import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from "./home/home.component";
import { ListComponent } from "./list/list.component";
import { DetailComponent } from "./detail/detail.component";
import { LoginComponent } from './login/login.component';
import { AuthGuard } from './helpers/auth.guard';
import { AdminComponent } from './admin/admin.component';


const routes: Routes = [
  {path : "", component: HomeComponent},
  { path: 'login', component: LoginComponent },
  {path: 'admin', component: AdminComponent, canActivate: [AuthGuard]},
  {path : ":list", component: ListComponent},
  { path: ':list/:id', component: DetailComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
