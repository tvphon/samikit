package kh.mclass.semitkit.product.model.dto;

public class ProductDto {
//	--이름               널?       유형            
//			------------------ -------- ------------- 
//			--PRODUCT_KEY      NOT NULL NUMBER        
//			--IMGMAIN1         NOT NULL VARCHAR2(200) 
//			--PRODUCT_PRICE    NOT NULL NUMBER        
//			--PRODUCT_DISCOUNT NOT NULL NUMBER        
//			--PRODUCT_NAME     NOT NULL VARCHAR2(100) 
//			--PRODUCT_STOCK    NOT NULL NUMBER        
//			--PRODUCT_SELL     NOT NULL NUMBER        
//			--CATEGORY_KEY     NOT NULL NUMBER    
	private int productKey;
	private String imgMain1;
	private int productPrice;
	private int productDiscount;
	private String productName;
	private int productStock;
	private int productSell;
	private int categoryKey;
	@Override
	public String toString() {
		return "ProductDto [productKey=" + productKey + ", imgMain1=" + imgMain1 + ", productPrice=" + productPrice
				+ ", productDiscount=" + productDiscount + ", productName=" + productName + ", productStock="
				+ productStock + ", productSell=" + productSell + ", categoryKey=" + categoryKey + "]";
	}
	public ProductDto(int productKey, String imgMain1, int productPrice, int productDiscount, String productName,
			int productStock, int productSell, int categoryKey) {
		super();
		this.productKey = productKey;
		this.imgMain1 = imgMain1;
		this.productPrice = productPrice;
		this.productDiscount = productDiscount;
		this.productName = productName;
		this.productStock = productStock;
		this.productSell = productSell;
		this.categoryKey = categoryKey;
	}
	public int getProductKey() {
		return productKey;
	}
	public String getImgMain1() {
		return imgMain1;
	}
	public int getProductPrice() {
		return productPrice;
	}
	public int getProductDiscount() {
		return productDiscount;
	}
	public String getProductName() {
		return productName;
	}
	public int getProductStock() {
		return productStock;
	}
	public int getProductSell() {
		return productSell;
	}
	public int getCategoryKey() {
		return categoryKey;
	}

	
	
	

}
