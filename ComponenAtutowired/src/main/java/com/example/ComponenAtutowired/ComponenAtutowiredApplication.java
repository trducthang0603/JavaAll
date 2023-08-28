package com.example.ComponenAtutowired;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ComponenAtutowiredApplication {

	public static void main(String[] args) {
		System.out.println("> Truoc khi IoC Container duoc khoi tao");
		ApplicationContext context = SpringApplication.run(ComponenAtutowiredApplication.class, args);
		System.out.println("> Sau khi IoC Container duoc khoi tao");
		// ApplicationContext chính là container, chứa toàn bộ các Bean
		/// Khi chạy xong, lúc này context sẽ chứa các Bean có đánh
		// dấu @Component.
		// Lấy Bean ra bằng cách
		Outfit outfit = context.getBean(Outfit.class);
		// In ra để xem thử nó là gì
		System.out.print("Instance:" + outfit);
		// xài hàm 	wear();
		outfit.wear();
		Girl girl = context.getBean(Girl.class);
		System.out.println("Girl Instance: " + girl);
		System.out.println("Girl Outfit: " + girl.outfit);
		girl.outfit.wear();
		//Spring Boot đã tự tạo ra một Girl và trong quá trình tạo ra đó, nó truyền Outfit vào làm thuộc tính.
		//Singleton
		//Điều đặc biệt là các Bean được quản lý bên trong ApplicationContext đều là singleton.
		// Bạn chắc đã để ý điều này từ các Output ở phía trên.
		//Outfit ở 2 đối tượng trên là một.
		//@Autowired - @Primary - @Qualifier
		//@Autowired đánh dấu cho Spring biết rằng sẽ tự động inject bean tương ứng vào vị trí được đánh dấu.
		//Sau khi tìm thấy một class đánh dấu @Component. thì quá trình inject Bean xảy ra theo cách như sau:
		//
		//Nếu Class không có hàm Constructor hay Setter. Thì sẽ sử dụng Java Reflection để đưa đối tượng vào thuộc tính có đánh dấu @Autowired.
		//Nếu có hàm Constructor thì sẽ inject Bean vào bởi tham số của hàm
		//Nếu có hàm Setter thì sẽ inject Bean vào bởi tham số của hàm
		//Như ví dụ ở trên tôi đã sử dụng cách Java Reflection để inject Bean vào class Girl.
		// Nếu không sử dụng @Autowired thì bạn phải có một Constructor thay thế, hoặc một Setter tương ứng.
		System.out.println("> Truoc khi IoC Container destroy Girl");
		((ConfigurableApplicationContext) context).getBeanFactory().destroyBean(girl);
		System.out.println("> Sau khi IoC Container destroy Girl");
	}

}
