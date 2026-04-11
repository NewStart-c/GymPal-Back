package com.gym.productManagement.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.gym.common.config.RuoYiConfig;
import com.gym.common.utils.file.FileUploadUtils;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.gym.common.annotation.Log;
import com.gym.common.core.controller.BaseController;
import com.gym.common.core.domain.AjaxResult;
import com.gym.common.enums.BusinessType;
import com.gym.productManagement.domain.Product;
import com.gym.productManagement.service.IProductService;
import com.gym.common.utils.poi.ExcelUtil;
import com.gym.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 商品管理Controller
 * 
 * @author cqs
 * @date 2026-04-08
 */
@RestController
@RequestMapping("/productManagement/product")
public class ProductController extends BaseController
{
    @Autowired
    private IProductService productService;

    /**
     * 商品图片上传
     */
    @PostMapping("/image/upload")
    public AjaxResult uploadImage(@RequestParam("file") MultipartFile file) throws Exception {
        if (!file.isEmpty()) {
            // 上传到 uploadPath 目录下的 product 文件夹
            String fileName = FileUploadUtils.upload(RuoYiConfig.getUploadPath() + "/product", file);

            // 拼接前端可访问 URL：/profile + 文件相对路径
            // 这里 /profile 是若依默认静态资源映射，固定不变，无需配置
            String url = fileName;

            return AjaxResult.success("上传成功", url);
        }
        return AjaxResult.error("上传图片不能为空");
    }

    /**
     * 查询商品管理列表
     */
    @PreAuthorize("@ss.hasPermi('productManagement:product:list')")
    @GetMapping("/list")
    public TableDataInfo list(Product product)
    {
        startPage();
        List<Product> list = productService.selectProductList(product);
        return getDataTable(list);
    }

    /**
     * 导出商品管理列表
     */
    @PreAuthorize("@ss.hasPermi('productManagement:product:export')")
    @Log(title = "商品管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Product product)
    {
        List<Product> list = productService.selectProductList(product);
        ExcelUtil<Product> util = new ExcelUtil<Product>(Product.class);
        util.exportExcel(response, list, "商品管理数据");
    }

    /**
     * 获取商品管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('productManagement:product:query')")
    @GetMapping(value = "/{productId}")
    public AjaxResult getInfo(@PathVariable("productId") Long productId)
    {
        return success(productService.selectProductByProductId(productId));
    }

    /**
     * 新增商品管理
     */
    @PreAuthorize("@ss.hasPermi('productManagement:product:add')")
    @Log(title = "商品管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Product product)
    {
        return toAjax(productService.insertProduct(product));
    }

    /**
     * 修改商品管理
     */
    @PreAuthorize("@ss.hasPermi('productManagement:product:edit')")
    @Log(title = "商品管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Product product)
    {
        return toAjax(productService.updateProduct(product));
    }

    /**
     * 删除商品管理
     */
    @PreAuthorize("@ss.hasPermi('productManagement:product:remove')")
    @Log(title = "商品管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{productIds}")
    public AjaxResult remove(@PathVariable Long[] productIds)
    {
        return toAjax(productService.deleteProductByProductIds(productIds));
    }
}
