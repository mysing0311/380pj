package ouhk.comps380f.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ouhk.comps380f.model.Photo;

public interface PhotoRepository extends JpaRepository<Photo, Long> {

    public Photo findByPhotoIdAndName(long itemId, String name);
}
