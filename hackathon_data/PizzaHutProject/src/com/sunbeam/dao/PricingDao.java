package com.sunbeam.dao;

import java.util.List;

import com.sunbeam.entity.Pricing;

public interface PricingDao extends AutoCloseable{
	List<Pricing> findSizeByID(int itemId) throws Exception;

}
