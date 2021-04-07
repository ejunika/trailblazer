package com.trailblazer.api.core.rest.services.impl;

import java.util.List;

import javax.ws.rs.core.Response;

import com.trailblazer.api.core.entities.AbstractEntity;
import com.trailblazer.api.core.rest.services.CommonService;

public class CommonServiceImpl<E extends AbstractEntity> implements CommonService<AbstractEntity> {

	@Override
	public Response get(Integer offset, Integer limit, List<Byte> rsl) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response post(AbstractEntity entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response get(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response delete(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response put(Long id, AbstractEntity entity) {
		// TODO Auto-generated method stub
		return null;
	}

}
