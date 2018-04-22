package ouhk.comps380f.service;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ouhk.comps380f.dao.PhotoRepository;
import ouhk.comps380f.model.Photo;

@Service
public class PhotoServiceImpl implements PhotoService {

    @Resource
    private PhotoRepository photoRepo;

    @Override
    @Transactional
    public Photo getPhoto(long ticketId, String name) {
        return photoRepo.findByTicketIdAndName(ticketId, name);
    }
}
