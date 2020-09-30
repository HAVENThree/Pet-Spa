import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { DefaultLayoutComponent } from './layouts/default-layout/default-layout.component';
import { AboutUsComponent } from './pages/about-us/about-us.component';
import { CartComponent } from './pages/cart/cart.component';
import { ContactComponent } from './pages/contact/contact.component';
import { HomeComponent } from './pages/home/home.component';
import { ProductComponent } from './pages/product/product.component';
import { ServiceComponent } from './pages/service/service.component';

const routes: Routes = [
  {
    path:'',component: DefaultLayoutComponent,
    children:[
    {path: 'service',component: ServiceComponent},
    {path: 'product',component: ProductComponent},
    {path: '',component: HomeComponent},
    {path: 'aboutUs',component : AboutUsComponent},
    {path: 'contact',component: ContactComponent},
    {path: 'cart',component: CartComponent}
  ]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
