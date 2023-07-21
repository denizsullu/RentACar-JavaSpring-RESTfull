package com.kodlama.io.rentACar.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import com.kodlama.io.rentACar.business.rules.BrandBusinessRules;
import org.springframework.stereotype.Service;

import com.kodlama.io.rentACar.business.abstracts.BrandService;
import com.kodlama.io.rentACar.business.requests.CreateBrandRequest;
import com.kodlama.io.rentACar.business.requests.UpdateBrandRequest;
import com.kodlama.io.rentACar.business.responses.GetAllBrandsResponse;
import com.kodlama.io.rentACar.business.responses.GetByIdResponse;
import com.kodlama.io.rentACar.core.utilities.mappers.ModelMapperService;
import com.kodlama.io.rentACar.dataAccess.abstracts.BrandRepository;
import com.kodlama.io.rentACar.entities.concretes.Brand;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BrandManager implements BrandService {
	private BrandRepository brandRepository;
	private ModelMapperService modelMapperService;
	private BrandBusinessRules brandBusinessRules;
	@Override
	public List<GetAllBrandsResponse> getAll() {
		List<Brand> brands = brandRepository.findAll();
		List<GetAllBrandsResponse> brandsResponse = brands.stream()
				.map(brand -> this.modelMapperService.forResponse().map(brand, GetAllBrandsResponse.class))
				.collect(Collectors.toList());
		return brandsResponse;
	}

	@Override
	public void add(CreateBrandRequest createBrandRequest) {
		this.brandBusinessRules.checkIfBrandNameExists(createBrandRequest.getName());
		Brand brand = this.modelMapperService.forRequests().map(createBrandRequest, Brand.class);
		this.brandRepository.save(brand);
	}

	@Override
	public GetByIdResponse getByIdResponse(int id) {
		Brand brand =  this.brandRepository.findById(id).orElseThrow();
		GetByIdResponse response = this.modelMapperService.forResponse().map(brand, GetByIdResponse.class);
		return response;
	}

	@Override
	public void update(UpdateBrandRequest updateBrandRequest) {
		Brand brand = this.modelMapperService.forRequests().map(updateBrandRequest, Brand.class);
		this.brandRepository.save(brand);
		
	}

	@Override
	public void delete(int id) {
		this.brandRepository.deleteById(id);
		
	}
	

}
