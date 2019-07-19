package MusicCube.services.country;

import MusicCube.entities.Country;

import java.util.Optional;

public interface CountryService {

    Optional<Country> getById(int id);
    Iterable<Country> getAll();
    Country save(Country country);
    void delete(int id);

    Iterable<Country> getByCountryName(String countryName);
    Iterable<Country> getByCode(String code);

    Country getOneByCode(String code);

    boolean existsByCountryName(String countryName);
    boolean existsByCode(String countryCode);


}
