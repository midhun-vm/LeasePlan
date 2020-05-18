import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { VehiclePriceService } from '../../services/vehicle-price.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-price-list',
  templateUrl: './price-list.component.html',
  styleUrls: ['./price-list.component.css']
})

export class PriceListComponent implements OnInit {
  constructor(private router: Router, private vehiclePriceService: VehiclePriceService) {
  }
  priceList: any = [];

  deleteVehicle(id) {
    this.vehiclePriceService.deleteById(id).subscribe(data => {
      this.deleteRow(id);
      Swal.fire('', `Deleted Price With Id ${id}`, 'success');
    },
      error => Swal.fire('', `Error: Please Ensure Your Back-End Server Is Running`, 'error'))
  }

  deleteRow(id) {
    for (let row = 0; row < this.priceList.length; ++row) {
      if (this.priceList[row].id === id) {
        this.priceList.splice(row, 1);
        return;
      }
    }
  }

  updateVehicle(price) {
    this.router.navigate(['updatePriceList'], { state: { data: price } });
  }

  ngOnInit(): void {
    this.vehiclePriceService.getAll().subscribe(data => {
      this.priceList = data;
    },
      error => Swal.fire('', `Error: Please Ensure Your Back-End Server Is Running`, 'error'));
  }
}