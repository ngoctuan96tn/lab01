package com.example.lab01.mapper;

import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public interface EntityMapper<E, D> {
    D toDTO(E e);
    E toEntity(D d);
    List<D> toDTO(List<E> e);
    List<E> toEntity(List<D> d);

    default Optional<D> toDTO(Optional<E> e) {return e.map(this::toDTO);}
    default Optional<E> toEntity(Optional<D> d) {return d.map(this::toEntity);}

    default Page<D> toDTO(Page<E> e) {
        if (Objects.isNull(e)) {
            return Page.empty();
        } else {
            return e.map(this::toDTO);
        }
    }
    default Page<E> toEntity(Page<D> d){
        if (Objects.isNull(d)) {
            return Page.empty();
        } else {
            return d.map(this::toEntity);
        }
    }


}
