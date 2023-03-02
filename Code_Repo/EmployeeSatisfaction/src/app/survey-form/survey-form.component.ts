// survey-form.component.ts
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { serviceData } from '../survey-model/serviceData';
import { ChartConfiguration, ChartOptions, ChartType } from "chart.js";

@Component({
  selector: 'app-survey-form',
  templateUrl: './survey-form.component.html',
  styleUrls: ['./survey-form.component.css']
})

export class SurveyFormComponent implements OnInit {

  public barChartLegend = true;
  public barChartPlugins = [];

  public barChartData: ChartConfiguration<'bar'>['data'] = {

    labels: [ 'Career Development', 'Compensation & Benefits', 'Work-Life Balance', 'Working Atmosphere', 'Recognition & Feedback'],
    datasets: [
      { data: [ 100, 100, 100, 100, 100], label: 'Satisfaction Index' },
    ]
  };

  public barChartOptions: ChartConfiguration<'bar'>['options'] = {
    responsive: true,
  };

  message = "Rifa";
  form: FormGroup;
  val: number = 0;
  slctedIndex : number = 0;
  cb : serviceData = new serviceData();

  constructor(private fb: FormBuilder, private http: HttpClient) { 
    
    this.form = new FormGroup({
      q1 : new FormControl(null, Validators.required),
      q2 : new FormControl(null, Validators.required),
      q3 : new FormControl(null, Validators.required),
      q4 : new FormControl(null, Validators.required),
      q5 : new FormControl(null, Validators.required),
      q6 : new FormControl(null, Validators.required),
      q7 : new FormControl(null, Validators.required),
      q8 : new FormControl(null, Validators.required),
      q9 : new FormControl(null, Validators.required),
      q10 : new FormControl(null, Validators.required),
      q11 : new FormControl(null, Validators.required),
      q12 : new FormControl(null, Validators.required),
      q13 : new FormControl(null, Validators.required),
      q14 : new FormControl(null, Validators.required),
      q15 : new FormControl(null, Validators.required),
      q16 : new FormControl(null, Validators.required),
      q17 : new FormControl(null, Validators.required),
      q18 : new FormControl(null, Validators.required),
      q19 : new FormControl(null, Validators.required),
      q20 : new FormControl(null, Validators.required),
      q21 : new FormControl(null, Validators.required),
      q22 : new FormControl(null, Validators.required),
      q23 : new FormControl(null, Validators.required),
      q24 : new FormControl(null, Validators.required),
      q25 : new FormControl(null, Validators.required),
      q26 : new FormControl(null, Validators.required),
      q27 : new FormControl(null, Validators.required),
      q28 : new FormControl(null, Validators.required),
      q29 : new FormControl(null, Validators.required),
      q30 : new FormControl(null, Validators.required)
    });
}
  
  ngOnInit() {
    this.val = 0;
  }
  
  onClickSubmit() {
    this.val = 100;
    const svcData = JSON.stringify(this.form.value);
    this.form.disable();

    const url = 'http://localhost:8080/api/saveSurveyData';    
    const options = {
      headers: {
        'Content-Type': 'application/json'
      }
    };    
    this.http.post(url, svcData, options).subscribe(
      (response) => {
        console.log('POST request successful', response);
      },
      (error) => {
        console.log('Error making POST request', error);
      }
    );
  }

  onClickOfTab(tab: any){
    this.slctedIndex = tab.index;
    if(tab.index == 5){
      this.http.get('http://localhost:8080/api/getSurveyData')
      .subscribe((response: any) => {
      this.message = response;
      this.barChartData = {
        labels: [ 'Career Development', 'Compensation & Benefits', 'Work-Life Balance', 'Working Atmosphere', 'Recognition & Feedback'],
        datasets: [
          { data: [ response.careerDevelopmentPercentage, response.compensationBenefitsPercentage, 
            response.recognitionFeedbackPercentage, response.workLifeBalancePercentage, response.workingAtmospherePercentage], label: 'Satisfaction Index' },
        ]
      };
      });
    }

    



  }
  
  onClickNext(){
    this.slctedIndex = this.slctedIndex+1;
  }
}
