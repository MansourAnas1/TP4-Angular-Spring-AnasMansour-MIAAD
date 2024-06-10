import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrl: './products.component.css'
})
export class ProductsComponent implements OnInit{
  public products:any;
  public keyword:string="";
  constructor() {
  }
  ngOnInit() {
    this.products=[
      {"id":1,"name":"PC1","price":8900},
      {"id":2,"name":"SmartWatch","price":700},
      {"id":3,"name":"iphone 11","price":4500},
      {"id":4,"name":"PC2","price":8657},
      {"id":5,"name":"SmartWatch2","price":222},
      {"id":6,"name":"iphone 12","price":3421}
    ];
  }

  deleteProduct(p: any) {
    let index =this.products.indexOf(p);
    this.products.splice(index,1);
  }

/*
  search() {
    console.log(this.keyword);
    let result =[];
    for(let p of this.products){
      if(p.name.includes(this.keyword)){
        result.push(p);
      }
    }
    this.products=result;
  }*/
  search(){
    this.products=this.products.filter((p:any)=>p.name.includes(this.keyword));
  }
}
