import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
const baseUrl = 'http://localhost:8080/api';

@Injectable({
  providedIn: 'root'
})
export class VehiclePriceService {

  constructor(private http: HttpClient) { }

  getAll() {
    return this.http.get(`${baseUrl}/priceList`);
  }

  deleteById(id) {
    return this.http.delete(`${baseUrl}/priceList/delete/${id}`);
  }

  updateData(vehicleId, vehicleData) {
    return this.http.post(`${baseUrl}/updatePriceList/${vehicleId}`, vehicleData);
  }

  addData(vehicleData) {
    return this.http.post(`${baseUrl}/createPriceList`, vehicleData);
  }
}
