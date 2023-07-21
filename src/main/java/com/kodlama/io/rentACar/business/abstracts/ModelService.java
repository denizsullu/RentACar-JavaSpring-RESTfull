package com.kodlama.io.rentACar.business.abstracts;

import com.kodlama.io.rentACar.business.requests.CreateModelRequest;
import com.kodlama.io.rentACar.business.responses.GetAllBrandsResponse;
import com.kodlama.io.rentACar.business.responses.GetAllModelsResponse;

import java.util.List;

public interface ModelService {
    List<GetAllModelsResponse> getAll();
    void add(CreateModelRequest createModelRequest);
}
