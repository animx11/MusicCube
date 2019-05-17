package MusicCube.services.songauthorship;

import MusicCube.entities.Person;
import MusicCube.entities.Song;
import MusicCube.entities.SongAuthorship;

import java.util.Optional;

public interface SongAuthorshipService {

    Optional<SongAuthorship> getById(int id);
    Iterable<SongAuthorship> getAll();
    SongAuthorship save(SongAuthorship songAuthorship);
    void delete(int id);

    Iterable<SongAuthorship> getBySong(Song song);
    Iterable<SongAuthorship> getByAuthor(Person author);

}