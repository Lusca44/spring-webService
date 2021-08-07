package br.com.educandoweb.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.educandoweb.course.entities.Category;
import br.com.educandoweb.course.entities.Order;
import br.com.educandoweb.course.entities.OrderItem;
import br.com.educandoweb.course.entities.Payment;
import br.com.educandoweb.course.entities.Product;
import br.com.educandoweb.course.entities.User;
import br.com.educandoweb.course.entities.enums.OrderStatus;
import br.com.educandoweb.course.repositories.CategoryRepository;
import br.com.educandoweb.course.repositories.OrderItemRepository;
import br.com.educandoweb.course.repositories.OrderRepository;
import br.com.educandoweb.course.repositories.ProductRepository;
import br.com.educandoweb.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private OrderRepository orderRepo;

	@Autowired
	private ProductRepository productRepo;

	@Autowired
	private CategoryRepository categoryRepo;

	@Autowired
	private OrderItemRepository orderItemRepo;

	@Override
	public void run(String... args) throws Exception {

		User u1 = new User("Lucas", "lucas@gmail.com", "95555-5555", "mortadeladefumada1");
		User u2 = new User("Gabriela", "gabriela@gmail.com", "96666-6666", "mortadeladefumada2");

		userRepo.saveAll(Arrays.asList(u1, u2));

		Order o1 = new Order(Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, u1);
		Order o2 = new Order(Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.CANCELED, u2);
		Order o3 = new Order(Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.SHIPPED, u1);

		orderRepo.saveAll(Arrays.asList(o1, o2, o3));

		Category cat1 = new Category("Eletronics");
		Category cat2 = new Category("Books");
		Category cat3 = new Category("Computers");

		categoryRepo.saveAll(Arrays.asList(cat1, cat2, cat3));

		Product p1 = new Product("The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
		Product p2 = new Product("Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
		Product p3 = new Product("Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
		Product p4 = new Product("PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
		Product p5 = new Product("Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");

		p1.getCategories().add(cat2);
		p2.getCategories().add(cat1);
		p2.getCategories().add(cat3);
		p3.getCategories().add(cat3);
		p4.getCategories().add(cat3);
		p5.getCategories().add(cat2);
		
		productRepo.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
		
		OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice());
		OrderItem oi2 = new OrderItem(o1, p3, 1, p3.getPrice());
		OrderItem oi3 = new OrderItem(o2, p3, 2, p3.getPrice());
		OrderItem oi4 = new OrderItem(o3, p5, 2, p5.getPrice());

		orderItemRepo.saveAll(Arrays.asList(oi1,oi2,oi3,oi4));
		
		
		Payment pay1 = new Payment(Instant.parse("2019-06-20T21:53:07Z"), o1);
		
		o1.setPayment(pay1);
		
		orderRepo.save(o1);
		
	}

}
