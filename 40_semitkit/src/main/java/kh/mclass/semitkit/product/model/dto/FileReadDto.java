package kh.mclass.semitkit.product.model.dto;

public class FileReadDto {
//	이름               널?       유형            
//	---------------- -------- ------------- 
//	PRODUCT_KEY      NOT NULL NUMBER        
//	IMGMAIN1         NOT NULL VARCHAR2(200) 
//	PRODUCT_PRICE    NOT NULL NUMBER        
//	PRODUCT_DISCOUNT NOT NULL NUMBER        
//	PRODUCT_NAME     NOT NULL VARCHAR2(100) 
//	PRODUCT_STOCK    NOT NULL NUMBER        
//	PRODUCT_SELL     NOT NULL NUMBER        
//	PRODUCT_ENROLL   NOT NULL VARCHAR2(30)  
//	CATEGORY_KEY     NOT NULL NUMBER   
	private int productKey; 
	private String imgMain1;
	private int productPrice;
	private String productName;
	@Override
	public String toString() {
		return "FileReadDto [productKey=" + productKey + ", imgMain1=" + imgMain1 + ", productPrice=" + productPrice
				+ ", productName=" + productName + "]";
	}
	public FileReadDto(int productKey, String imgMain1, int productPrice, String productName) {
		super();
		this.productKey = productKey;
		this.imgMain1 = imgMain1;
		this.productPrice = productPrice;
		this.productName = productName;
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
	public String getProductName() {
		return productName;
	}
	
	
	

}
