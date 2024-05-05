package com.product;
import com.product.dto.ProductRequestDTO;
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
	private Product expectedProduct;
	private ProductRequestDTO carProductDTO;
	private ProductRequestDTO updatedProductDTO;
	@BeforeEach
	void init() {
		carProduct = Product.builder()
				.id(1)
				.name("Car")
				.price(500000.0)
				.description("Car is here")
				.build();
		carProductDTO=ProductRequestDTO.builder()
				.name("Car")
				.price(100000.0)
				.description("Car is here")
				.build();
		bikeProduct=Product.builder()
				.id(2)
				.name("Bike")
				.price(50000.0)
				.description("Bike is here")
				.build();
		 expectedProduct = Product.builder().id(1)
				.name("Updated Bus")
				.description("This is an updated bus")
				.price(500000.0).build();
		updatedProductDTO=ProductRequestDTO.builder()
				.name("Updated Bus")
				.description("This is an updated bus")
				.price(500000.0).build();
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
		Product newProduct= productService.createProduct(carProductDTO);
		assertNotNull(newProduct);
		assertThat(newProduct.getName()).isEqualTo(carProduct.getName());
		assertThat(newProduct.getPrice()).isEqualTo(carProduct.getPrice());
		assertThat(newProduct.getDescription()).isEqualTo(carProduct.getDescription());
	}
	@Test
	public void testUpdateProduct_ShouldUpdateAndSaveProduct() {
		int productId = 1;
		when(productRepository.findById(anyInt())).thenReturn(Optional.of(carProduct));
		when(productRepository.save(any(Product.class))).thenReturn(expectedProduct);
		Product updatedProduct=productService.updateProduct(productId,updatedProductDTO);
		assertNotNull(updatedProduct);
		assertThat(updatedProduct).isEqualTo(expectedProduct);
	}
    @Test
    public void testUpdateProduct_ShouldThrowsExceptionForNonExistingProduct() {
        int productId=1;
        when(productRepository.findById(anyInt())).thenReturn(Optional.empty());
        Exception exception = assertThrows(
                IllegalArgumentException.class,
                () -> productService.updateProduct(productId,updatedProductDTO));
        assertEquals(exception.getMessage(), "Product with ID " +productId+ " not found");
    }
	@Test
	public void testDeleteProductById_ShouldDeleteProduct() {
		int productId=1;
		when(productRepository.findById(anyInt())).thenReturn(Optional.of(carProduct));
		doNothing().when(productRepository).deleteById(productId);
		productService.deleteProduct(productId);
		verify(productRepository,times(1)).deleteById(productId);
	}
}

