package MusicCube.services.band;

import MusicCube.entities.Band;
import MusicCube.repositories.BandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BandServiceImpl implements BandService {

    @Autowired
    private BandRepository bandRepository;

    @Override
    public Optional<Band> getById(int id) {
        return bandRepository.findById(id);
    }
    @Override
    public Iterable<Band> getAll() {
        return bandRepository.findAll();
    }
    @Override
    public Band save(Band band) {
        return bandRepository.save(band);
    }
    @Override
    public void delete(int id) {
        bandRepository.deleteById(id);
    }

    @Override
    public Iterable<Band> getByBandName(String bandName) {
        return bandRepository.findByBandName(bandName);
    }
}