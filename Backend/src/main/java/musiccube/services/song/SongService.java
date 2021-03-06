package musiccube.services.song;

import musiccube.entities.Album;
import musiccube.entities.Band;
import musiccube.entities.Song;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface SongService {

    Optional<Song> getById(int id);
    Iterable<Song> getAll();
    Iterable<Song> getAllPaging(Integer pageNr, Integer perPage);
    Song save(Song song);
    void delete(int id);

    Iterable<Song> getByBandId(int id);
    Iterable<Song> getBySongName(String songName);
    Iterable<Song> getByGenreName(String genreName);
    Iterable<Song> getByAlbumName(String albumName);
    boolean existsBySongName(String songName);
    boolean existsByAlbum(Album album);
    boolean existsByBand(Band band);

    List<Song> advanced(Map<String, String> params);
}