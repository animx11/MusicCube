package musiccube.services.Activity;

import musiccube.entities.Activity;

import java.util.Optional;

public interface ActivityService {

    Optional<Activity> getById(int id);
    Iterable<Activity> getAll();
    Activity save(Activity activity);
    void delete(int id);

    Iterable<Activity> getByArtistId(int artistId);
    Iterable<Activity> getByBandId(int bandId);
    Iterable<Activity> getByArtistIdIsActive(int artistId, boolean active);
    Iterable<Activity> getByBandIdIsActive(int bandId, boolean active);

}