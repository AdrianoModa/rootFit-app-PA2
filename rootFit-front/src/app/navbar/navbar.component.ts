import { Component, OnInit } from '@angular/core';;
import {Location, LocationStrategy, PathLocationStrategy} from '@angular/common';


@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  private listTitles: any[];
    location: Location;
    private toggleButton: any;
    private sidebarVisible: boolean;

    constructor(location: Location) {
      this.location = location;
          this.sidebarVisible = false;
    }

    ngOnInit(){
     
    }
    sidebarOpen() {
        const toggleButton = this.toggleButton;
        const body = document.getElementsByTagName('body')[0];
        setTimeout(function(){
            toggleButton.classList.add('toggled');
        }, 500);
        body.classList.add('nav-open');

        this.sidebarVisible = true;
    };
    sidebarClose() {
        const body = document.getElementsByTagName('body')[0];
        this.toggleButton.classList.remove('toggled');
        this.sidebarVisible = false;
        body.classList.remove('nav-open');
    };
    sidebarToggle() {
        // const toggleButton = this.toggleButton;
        // const body = document.getElementsByTagName('body')[0];
        if (this.sidebarVisible === false) {
            this.sidebarOpen();
        } else {
            this.sidebarClose();
        }
    };

    // getTitle(){
    //   var titlee = this.location.prepareExternalUrl(this.location.path());
    //   titlee = titlee.split('/').pop();
    //   for(var item = 0; item < this.listTitles.length; item++){
    //       if(this.listTitles[item].path === titlee){
    //           return this.listTitles[item].title;
    //       }
    //   }
    //   return 'Dashboard';
    // }

}
