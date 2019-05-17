package MusicCube.controllers;

import MusicCube.entities.Song;
import MusicCube.entities.Instrument;
import MusicCube.services.songinstrument.SongInstrumentService;
import MusicCube.entities.SongInstrument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class SongInstrumentController {

    @Autowired
    private SongInstrumentService songInstrumentService;

    @RequestMapping(value = "/songInstrument{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<SongInstrument> getById(int id) {
        return songInstrumentService.getById(id);
    }

    @RequestMapping(value = "/songInstruments",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<SongInstrument> getAll() {
        return songInstrumentService.getAll();
    }

    // --- Get by Song ---
    @RequestMapping(value = "/songInstruments{song}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<SongInstrument> getBySong(Song song) { return songInstrumentService.getBySong(song); }

    // --- Get by Instrument ---
    @RequestMapping(value = "/songInstruments{instrument}", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<SongInstrument> getByInstrument(Instrument instrument) { return songInstrumentService.getByInstrument(instrument); }


    @RequestMapping(value = "/songInstrument",method = RequestMethod.POST)
    public ResponseEntity<SongInstrument> create(@RequestBody @Valid @NotNull SongInstrument songInstrument) {
        songInstrumentService.save(songInstrument);
        return ResponseEntity.ok().body(songInstrument);
    }

    @RequestMapping(value = "/songInstrument",method = RequestMethod.PUT)
    public ResponseEntity<Void> edit(@RequestBody @Valid @NotNull SongInstrument songInstrument) {
        Optional<SongInstrument> songInstrument1 = songInstrumentService.getById(songInstrument.getId());
        if (Objects.nonNull(songInstrument1)) {
            songInstrumentService.save(songInstrument);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } else return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @ApiIgnore
    @RequestMapping(value = "/songInstruments",method = RequestMethod.DELETE,produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<SongInstrument> redirect(Model model) {
        return songInstrumentService.getAll();
    }

    @RequestMapping(value = "/songInstrument/{id}", method = RequestMethod.DELETE)
    public RedirectView delete(@PathVariable Integer id) {
        songInstrumentService.delete(id);
        return new RedirectView("/api/songInstruments",true);
    }
}