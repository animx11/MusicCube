package MusicCube.services.artist;

import MusicCube.entities.Artist;

import java.util.Optional;

public interface ArtistService {

    Optional<Artist> getById(int id);
    Iterable<Artist> getAll();
    Iterable<Artist> getAllPaging(Integer pageNr, Integer perPage);
    Artist save(Artist artist);
    void delete(int id);

    Iterable<Artist> getByStageName(String stageName);
    Iterable<Artist> getByAnything(String input);

    boolean existsArtistByArtistFirstNamesAndLastName(String firstNames, String lastNames);
    boolean existsArtistByStageName(String stageName);

}