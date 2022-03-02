package test.b;

import java.util.*;

public class ProductService {
	Map<String, Product> products = new HashMap<>();
	
	public ProductService() {
		Product p = new Product("1","맥북프로","apple",1200000,"2022.03.02");
		products.put("1", p);
		
		p = new Product("2","ASUS 비보북","ASUS",1300000,"2022.2.2");
		products.put("2", p);
		
		p = new Product("3","MSI SG 시리즈","MSI",1500000,"2022.3.2");
		products.put("3", p);
		
		p = new Product("4","ASUS SG 시리즈","ASUS",1400000,"2022.1.2");
		products.put("4", p);
		
		p = new Product("5","레노버 시리즈","레노버",1340000,"2022.1.12");
		products.put("5", p);
	}
	
	public List<Product> findAll() {
		return new ArrayList<>(products.values());
	}
	
	public Product find(String id) {
		return products.get(id);
	}

}
