package MusicCube.services.songinstrument;

import MusicCube.entities.Song;
import MusicCube.entities.SongInstrument;
import MusicCube.entities.Instrument;

import java.util.Optional;

public interface SongInstrumentService {

    Optional<SongInstrument> getById(int id);
    Iterable<SongInstrument> getAll();
    SongInstrument save(SongInstrument songInstrument);
    void delete(int id);

    Iterable<SongInstrument> getBySongId(int id);
    Iterable<SongInstrument> getByInstrumentId(int id);

}