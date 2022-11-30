package org.project.service.searcher;

import lombok.RequiredArgsConstructor;
import org.project.dao.custom.searcher.SearcherCustomDAO;
import org.project.dto.searcher.Searcher;
import org.project.model.PassengerProfile;
import org.project.model.UserProfile;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class SearcherServiceImpl implements SearcherService {
    private final SearcherCustomDAO searcherCustomDAO;

    @Override
    public List<UserProfile> findUserProfile(Searcher searcher) {
        return searcherCustomDAO.findUserProfile(searcher);
    }

    @Override
    public List<PassengerProfile> findPassengerProfile(Searcher searcher) {
        return searcherCustomDAO.findPassengerProfile(searcher);
    }
}
