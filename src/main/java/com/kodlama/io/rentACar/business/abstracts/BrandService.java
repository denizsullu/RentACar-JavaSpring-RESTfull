package com.kodlama.io.rentACar.business.abstracts;

import java.util.List;

import com.kodlama.io.rentACar.business.requests.CreateBrandRequest;
import com.kodlama.io.rentACar.business.requests.UpdateBrandRequest;
import com.kodlama.io.rentACar.business.responses.GetAllBrandsResponse;
import com.kodlama.io.rentACar.business.responses.GetByIdResponse;

public interface BrandService {
	List<GetAllBrandsResponse> getAll();
	GetByIdResponse getByIdResponse(int id);
	void add(CreateBrandRequest createBrandRequest);
	void update(UpdateBrandRequest updateBrandRequest);
	void delete(int id);

	
}
