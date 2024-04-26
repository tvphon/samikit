package kh.mclass.semitkit.product.model.dto;

public class ProductListDto {
//	이름               널?       유형            
//			---------------- -------- ------------- 
//			PRODUCT_KEY      NOT NULL NUMBER        
//			IMGMAIN1         NOT NULL VARCHAR2(200) 
//			PRODUCT_PRICE    NOT NULL NUMBER        
//			PRODUCT_DISCOUNT NOT NULL NUMBER        
//			PRODUCT_NAME     NOT NULL VARCHAR2(100) 
//			PRODUCT_STOCK    NOT NULL NUMBER        
//			PRODUCT_SELL     NOT NULL NUMBER        
//			PRODUCT_ENROLL   NOT NULL VARCHAR2(30)  
//			CATEGORY_KEY     NOT NULL NUMBER     
	private String productKey;
	private String imgMain1;
	private int productPrice;
	private String productName;
	private String productEnroll;
	@Override
	public String toString() {
		return "ProductListDto [productKey=" + productKey + ", imgMain1=" + imgMain1 + ", productPrice=" + productPrice
				+ ", productName=" + productName + ", productEnroll=" + productEnroll + "]";
	}
	public ProductListDto() {
		super();
	}
	public ProductListDto(String productKey, String imgMain1, int productPrice, String productName,
			String productEnroll) {
		super();
		this.productKey = productKey;
		this.imgMain1 = imgMain1;
		this.productPrice = productPrice;
		this.productName = productName;
		this.productEnroll = productEnroll;
	}
	public String getProductKey() {
		return productKey;
	}
	public String getImgMain1() {
		return imgMain1;
	}
	public int getProductPrice() {
		return productPrice;
	}
	public String getProductName() {
		return productName;
	}
	public String getProductEnroll() {
		return productEnroll;
	}
	
	
	
	
	
}
