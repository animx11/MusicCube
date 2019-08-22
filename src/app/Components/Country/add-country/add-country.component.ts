import { Component, OnInit } from "@angular/core";
import { Country } from "src/app/Class/Country";
import { CountryService } from 'src/app/Services/country.service';

@Component({
  selector: 'app-add-country',
  templateUrl: './add-country.component.html',
  styleUrls: ['./add-country.component.css']
})
export class AddCountryComponent implements OnInit {


  private country: Country;

  private countryName: string;
  private code: string;

  constructor(private countryService: CountryService) {}

  ngOnInit() {
    this.countryName = "";
    this.code = "";
    this.country = new Country();
  }

  addCountry() {
    if (this.countryName === '' || this.code === '') {
      window.alert('Incomplete input');
    }
    else {
      this.country.setCountryName(this.countryName);
      this.country.setCode(this.code);
      this.countryService.create(this.country).subscribe(
        res => {
          console.log('add-country-component received:');
          console.log(res);
          window.alert('Country added');
        },
        err => {
          /* Trzeba dorobić error handlingi w backu i tutaj */
          console.error(err);
          window.alert('Error occurred');
        }
      )
    }
  }

/*

  addGenre() {
    if (this.genreName === '') {
      window.alert('Incomplete input');
    } else {
      this.genre.setGenreName(this.genreName);
      this.genre.setCreationDate(this.creationTime);
      this.genreService.create(this.genre).subscribe(
        res => {
          console.log('add-genre-component received:');
          console.log(res);
          window.alert('Genre added');
        },
        err => {
          console.error(err);
          window.alert('Error occurred');
        }
      );
    }
  }
  */
}
