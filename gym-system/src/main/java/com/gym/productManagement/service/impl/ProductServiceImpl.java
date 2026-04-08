package com.gym.productManagement.service.impl;

import java.util.List;
import com.gym.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gym.productManagement.mapper.ProductMapper;
import com.gym.productManagement.domain.Product;
import com.gym.productManagement.service.IProductService;

/**
 * 商品管理Service业务层处理
 * 
 * @author cqs
 * @date 2026-04-08
 */
@Service
public class ProductServiceImpl implements IProductService 
{
    @Autowired
    private ProductMapper productMapper;

    /**
     * 查询商品管理
     * 
     * @param productId 商品管理主键
     * @return 商品管理
     */
    @Override
    public Product selectProductByProductId(Long productId)
    {
        return productMapper.selectProductByProductId(productId);
    }

    /**
     * 查询商品管理列表
     * 
     * @param product 商品管理
     * @return 商品管理
     */
    @Override
    public List<Product> selectProductList(Product product)
    {
        return productMapper.selectProductList(product);
    }

    /**
     * 新增商品管理
     * 
     * @param product 商品管理
     * @return 结果
     */
    @Override
    public int insertProduct(Product product)
    {
        product.setCreateTime(DateUtils.getNowDate());
        return productMapper.insertProduct(product);
    }

    /**
     * 修改商品管理
     * 
     * @param product 商品管理
     * @return 结果
     */
    @Override
    public int updateProduct(Product product)
    {
        product.setUpdateTime(DateUtils.getNowDate());
        return productMapper.updateProduct(product);
    }

    /**
     * 批量删除商品管理
     * 
     * @param productIds 需要删除的商品管理主键
     * @return 结果
     */
    @Override
    public int deleteProductByProductIds(Long[] productIds)
    {
        return productMapper.deleteProductByProductIds(productIds);
    }

    /**
     * 删除商品管理信息
     * 
     * @param productId 商品管理主键
     * @return 结果
     */
    @Override
    public int deleteProductByProductId(Long productId)
    {
        return productMapper.deleteProductByProductId(productId);
    }
}
