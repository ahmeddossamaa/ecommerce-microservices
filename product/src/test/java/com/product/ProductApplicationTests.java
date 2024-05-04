package com.product;

import com.product.models.Product;
import com.product.repositories.ProductRepository;
import com.product.services.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

@SpringBootTest
class ProductApplicationTests {
	@Mock
	private ProductRepository productRepository;
	@InjectMocks
	private ProductService productService;
	private Product carProduct;
	private Product bikeProduct;
	@BeforeEach
	void init() {
		carProduct =new Product();
		carProduct.setId(1);
		carProduct.setName("Car");
		carProduct.setDescription("Car is here");

		bikeProduct=new Product();
		bikeProduct.setId(2);
		bikeProduct.setName("Bike");
		bikeProduct.setDescription("Bike is here");
	}
	@Test
	void testGetProducts_ShouldReturnAllProducts() {
		List<Product> expectedProducts=Arrays.asList(carProduct, bikeProduct);
		when(productRepository.findAll()).thenReturn(expectedProducts);
		List<Product> actualProducts = productService.getProducts();
		assertEquals(expectedProducts, actualProducts);
	}

	@Test
	public void testCreateProduct_ShouldCreateAndSaveProduct() {
		when(productRepository.save(any(Product.class))).thenReturn(carProduct);
		String productName = carProduct.getName();
		Product newProduct= productService.createProduct(productName);
		assertNotNull(newProduct);
		assertThat(newProduct.getName()).isEqualTo("Car");
	}
	@Test
	public void testUpdateProduct_ShouldUpdateAndSaveProduct() {
		//Given
		int productId = 1;
		String updatedName = "Updated Bus";
		String updatedDescription = "This is an updated bus";
		Product expectedProduct = new Product();
		expectedProduct.setId(productId);
		expectedProduct.setName(updatedName);
		expectedProduct.setDescription(updatedDescription);
		//When
		when(productRepository.findById(anyInt())).thenReturn(Optional.of(carProduct));
		when(productRepository.save(any(Product.class))).thenReturn(expectedProduct);
		Product updatedProduct=productService.updateProduct(productId,expectedProduct);
		//Then
		assertNotNull(updatedProduct);
		assertThat(updatedProduct).isEqualTo(expectedProduct);

	}
    @Test
    public void testUpdateProduct_ShouldThrowsExceptionForNonExistingProduct() {
        int productId=1;
		String updatedName = "Updated Bus";
		String updatedDescription = "This is an updated bus";
		Product expectedProduct = new Product();
		expectedProduct.setId(productId);
		expectedProduct.setName(updatedName);
		expectedProduct.setDescription(updatedDescription);
        when(productRepository.findById(anyInt())).thenReturn(Optional.empty());
        Exception exception = assertThrows(
                IllegalArgumentException.class,
                () -> productService.updateProduct(productId,expectedProduct));
        assertEquals(exception.getMessage(), "Product with ID " + productId+ " not found");
    }
	@Test
	public void testDeleteProductById_ShouldDeleteProduct() {
		int productId=1;
		when(productRepository.findById(anyInt())).thenReturn(Optional.of(carProduct));
		doNothing().when(productRepository).deleteById(productId);
		productService.deleteProductById(productId);
		verify(productRepository,times(1)).deleteById(productId);
	}

}

