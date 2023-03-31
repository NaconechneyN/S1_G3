package com.bootcamp.spring1.service.generics;

import com.bootcamp.spring1.dto.ValidationDTO;

import java.util.List;

public interface ICrudService <T, ID> {

    T saveEntity(T objectDTO);

    List<T> getAllEntities();

    ValidationDTO deleteEntity(String code);



}
