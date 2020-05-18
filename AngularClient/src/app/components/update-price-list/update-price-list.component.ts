import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { VehiclePriceService } from '../../services/vehicle-price.service'
import Swal from 'sweetalert2';

@Component({
  selector: 'app-update-price-list',
  templateUrl: './update-price-list.component.html',
  styleUrls: ['./update-price-list.component.css']
})
export class UpdatePriceListComponent implements OnInit {

  constructor(private vehiclePriceService: VehiclePriceService, private router: Router) { }

  vehiclePrice: any = {};

  saveDetails() {
    if (this.vehiclePrice.id) {
      this.vehiclePriceService.updateData(this.vehiclePrice.id, this.vehiclePrice).subscribe((data) => {
        Swal.fire('', `Updated Details`, 'success');
        this.router.navigate(['priceList']);
      },
        error => Swal.fire('', `Error: Please Check Your Input`, 'error'))
    } else {
      this.vehiclePriceService.addData(this.vehiclePrice).subscribe((data) => {
        Swal.fire('', `Created New Entry`, 'success');
        this.router.navigate(['priceList']);
      },
        error => Swal.fire('', `Error: Please Check Your Input`, 'error'))
    }
  }

  ngOnInit(): void {
    if (history.state.data) {
      this.vehiclePrice = history.state.data;
    } else {
      this.vehiclePrice = {
        makeName: '',
        modelName: '',
        price: 0.00,
        optionName: '',
        optionPrice: 0.00

      }
    }
  }

}