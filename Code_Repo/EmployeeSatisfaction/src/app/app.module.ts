// app.module.ts
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { MatTabsModule } from '@angular/material/tabs';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { SurveyFormComponent } from './survey-form/survey-form.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatProgressBarModule } from '@angular/material/progress-bar';
import { MatSliderModule } from '@angular/material/slider';
import { NgChartsModule } from 'ng2-charts';

@NgModule({
  declarations: [
    AppComponent,
    SurveyFormComponent
    
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    AppRoutingModule,
    MatTabsModule,
    MatInputModule,
    MatButtonModule,
    BrowserAnimationsModule,
    MatProgressBarModule,
    MatSliderModule,
    NgChartsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }