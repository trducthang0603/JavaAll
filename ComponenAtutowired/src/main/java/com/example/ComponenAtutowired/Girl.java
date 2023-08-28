package com.example.ComponenAtutowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

//Bây giờ mình tạo ra một Class Girl và có một thuộc tính là Outfit.
//
//Mình cũng đánh dấu Girl là một @Component. Tức Spring Boot cần tạo ra một instance của Girl để quản lý.
@Component
public class Girl {
    @Autowired
    Outfit outfit;
//    public Girl(Outfit outfit) {
//        this.outfit = outfit;
//    }
    // Spring sẽ inject outfit thông qua Constructor trước
    public Girl() { }
    public Girl(@Qualifier("naked") Outfit outfit) {
        // Spring sẽ inject outfit thông qua Constructor đầu tiên
        // Ngoài ra, nó sẽ tìm Bean có @Qualifier("naked") trong context để ịnject
        this.outfit = outfit;
    }
    //@Primary và @Qualifier là một trong những tính năng bạn nên biết trong Spring để
    // có thể xử lý vấn đề nhiều Bean cùng loại trong một Project.
    //
    // Nếu không tìm thấy Constructor thoả mãn, nó sẽ thông qua setter
    public void setOutfit(Outfit outfit) {
        this.outfit = outfit;
    }
    @PostConstruct
    public void postConstruct(){
        System.out.println("\t>> doi tuong Girl sau khi khoi tao xong se chay ham nay");
    }
    //Bean Life Cycle
    @PreDestroy
    public void preDestroy(){
        System.out.println("\t>> doi tuong Girl truoc khi bi destroy thi chay ham nay");
    }

}
//Tôi đánh dấu thuộc tính Outfit của Girl bởi Annotation @Autowired.
// Điều này nói với Spring Boot hãy tự inject (tiêm) một instance của Outfit vào thuộc tính này khi khởi tạo Girl.

//Spring Boot từ thời điểm chạy lần đầu tới khi shutdown
// thì các Bean nó quản lý sẽ có một vòng đời được biểu diễn như ảnh dưới đây:
//Nhìn có vẻ loằng ngoằng, trong series căn bản này, bạn có lẽ sẽ chỉ cần hiểu như sau:
//
//Khi IoC Container (ApplicationContext) tìm thấy một Bean cần quản lý, nó sẽ khởi tạo bằng Constructor
//inject dependencies vào Bean bằng Setter, và thực hiện các quá trình cài đặt khác vào Bean như setBeanName, setBeanClassLoader, v.v..
//Hàm đánh dấu @PostConstruct được gọi
//Tiền xử lý sau khi @PostConstruct được gọi.
//Bean sẵn sàng để hoạt động
//Nếu IoC Container không quản lý bean nữa hoặc bị shutdown nó sẽ gọi hàm @PreDestroy trong Bean
//Xóa Bean.