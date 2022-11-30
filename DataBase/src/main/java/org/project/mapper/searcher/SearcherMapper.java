package org.project.mapper.searcher;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.project.dto.searcher.Searcher;
import org.project.dto.searcher.SearcherDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class SearcherMapper {
    private final ModelMapper modelMapper;

    public SearcherDTO toDTO(Searcher searcher) {
        return modelMapper.map(searcher, SearcherDTO.class);
    }

    public List<SearcherDTO> toDTO(List<Searcher> searcherList) {
        return Optional.ofNullable(searcherList)
                .map(list -> list.stream()
                        .map(this::toDTO).collect(Collectors.toList())).orElse(null);
    }

    public List<Searcher> toModel(List<SearcherDTO> searcherDTOList) {
        return Optional.ofNullable(searcherDTOList)
                .map(list -> list.stream()
                        .map(this::toModel).collect(Collectors.toList())).orElse(null);
    }

    public Searcher toModel(SearcherDTO searcherDTO) {
        return modelMapper.map(searcherDTO, Searcher.class);
    }
}
