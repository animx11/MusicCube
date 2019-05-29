import { Country } from "./Country";

export class Genre {
  id: number;
  private origin: Country;
  private genreName: string;
  private creationDate: Date;

  constructor(obj?: any) {
    this.id = (obj && obj.id) || 0;
    this.origin = (obj && obj.origin) || null;
    this.genreName = (obj && obj.genreName) || "";
    this.creationDate = (obj && obj.creationDate) || null;
  }

  // Getters

  getId(): number {
    return this.id;
  }

  getOrigin(): Country {
    return this.origin;
  }

  getGenreName(): string {
    return this.genreName;
  }

  getCreationDate(): Date {
    return this.creationDate;
  }

  // Setters

  setOrigin(origin: Country) {
    this.origin = origin;
  }

  setGenreName(genreName: string) {
    this.genreName = genreName;
  }

  setCreationDate(creationDate: Date) {
    this.creationDate = creationDate;
  }
}
