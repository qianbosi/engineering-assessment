import { Component, ViewChild } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import {MatInputModule} from '@angular/material/input';
import {MatFormFieldModule} from '@angular/material/form-field';
import { FormControl, FormGroup, FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import {MatButtonModule} from '@angular/material/button';
import {MatTableDataSource, MatTableModule} from '@angular/material/table';
import { MatPaginator, MatPaginatorModule } from '@angular/material/paginator';

@Component({
  selector: 'app-root',
  standalone: true,
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss',
  imports: [RouterOutlet,MatPaginatorModule, MatTableModule, FormsModule, MatFormFieldModule, MatInputModule, HttpClientModule, MatButtonModule, ReactiveFormsModule],
})
export class AppComponent {
  title = 'FoodFacilityManagementUI';
  searchFood = ''

  public result: any = []
  displayedColumns: string[] = ['facilityType', 'address', 'applicant', 'approved', 'blockLot', 'cnn', 'daysHours', 'expirationDate', 'firePreventionDistricts', 'foodItems',
    'latitude', 'location', 'locationDescription', 'longitude', 'lot', 'neighborhoods', 'noiSent', 'permit', 'policeDistricts', 'priorPermit',
    'received', 'schedule', 'status'
  ];

  foodForm = new FormGroup({
    searchFood: new FormControl('')
    // displayedColumns: string[] = ['facilityType', 'name', 'weight', 'symbol'];
  });

  @ViewChild(MatPaginator)
  paginator!: MatPaginator;

  ngAfterViewInit() {
//     this.result.paginator = this.paginator;
  }
  public constructor(private httpclient: HttpClient) {
  }

  public searchFoodFacility() {
    console.log(`Search value received: searchFood: ${this.foodForm.value.searchFood}`);
    this.httpclient.get(`/foodapi/foodFacility/searchBy?food=${this.foodForm.value.searchFood}`).subscribe({
      next: (d : any) =>{
        console.log(d)
        this.result = new MatTableDataSource(d)
        this.result.paginator = this.paginator
      },
      error: (e) => {
        console.log(e)
      }
    })
  }

}
