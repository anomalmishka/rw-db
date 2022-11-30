package org.project.service.searcher;

import org.project.dto.searcher.Searcher;
import org.project.model.PassengerProfile;
import org.project.model.UserProfile;

import java.util.List;

public interface SearcherService {
    List<UserProfile> findUserProfile(Searcher searcher);
    List<PassengerProfile> findPassengerProfile(Searcher searcher);
}

