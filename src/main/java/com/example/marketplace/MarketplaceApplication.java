package com.example.marketplace;

import com.example.marketplace.model.*;
import com.example.marketplace.repository.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.sql.Date;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Set;

@SpringBootApplication
public class MarketplaceApplication {
	private static final Logger log = LoggerFactory.getLogger(MarketplaceApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(MarketplaceApplication.class,"bootRun");
	}

//	@Bean
//	public CommandLineRunner demo(UserRepository repository) {
//		return (args) -> {
////			repository.save(new User("Robert","Admin","abcd"));
////			repository.save(new User("Tom","User","1234"));
////			repository.save(new User("Jerry","User","5678"));
////			repository.save(new User("Robert","User","910JQ"));
//			log.info("success");
//
////			 fetch all user in the table
//			log.info("");
//			log.info("User found with findAll():");
//			log.info("-------------------------------");
//			for (User user : repository.findAll()) {
//				log.info(user.toString());
//			}
//			log.info("");
//
//			// fetch an individual user by Username, This method only can return unique result otherwise will post error
//			List<User> user_list3 = repository.findByUsername("Tom");
//			log.info("User found with findByUsername():");
//			log.info("--------------------------------");
//			user_list3.forEach((a)->{log.info(a.toString());});;
//			log.info("");
//
//			// fetch all user by Username
//			List<User> user_list = repository.findAllByUsername("Robert");
//			log.info("User found with findAllByUsername():");
//			log.info("--------------------------------");
//			user_list.forEach((a)->{log.info(a.toString());});
//			log.info("");
//
//
//			// fetch all users by type
//			List<User> user_list1 = repository.findAllByUsertype("User");
//			log.info("User found with findAllByUser_type():");
//			log.info("--------------------------------");
//			user_list1.forEach((a)->{log.info(a.toString());});
//			log.info("");
//
//			// fetch all users by type and useranme
//			List<User> user_list2 = repository.findAllByUsertypeAndUsername("User","Robert");
//			log.info("User found with findAllByUsertypeAndUsername():");
//			log.info("--------------------------------");
//			user_list2.forEach((a)->{log.info(a.toString());});
//			log.info("");
//
//
//
//
//		};
//	}


//	@Bean
//	public CommandLineRunner demo2(ProjectRepository projectrepository,UserRepository userrepository) {
//		return (args) -> {
//
//			projectrepository.save(new Project(6,"Company Project A",new User("Robert","Admin","abcd")));
//			projectrepository.save(new Project(1,"Company Project A",userrepository.findByUserid(1)));
//			projectrepository.save(new Project(2,"Company Project B",userrepository.findByUserid(2)));
//			projectrepository.save(new Project(3,"Company Project C",userrepository.findByUserid(3)));
//			projectrepository.save(new Project(4,"Company Project C",userrepository.findByUserid(1)));
//			log.info(" success");
//
//			//			 fetch all user in the table
//			log.info("");
//			log.info("Project found with findAll():");
//			log.info("-------------------------------");
//			for (Project prject : projectrepository.findAll()) {
//				log.info(prject.toString());
//			}
//			log.info("");
//
//
//			//			 fetch all project in the table by project name
//			log.info("");
//			log.info("Project found with findByprojectnameLike():");
//			log.info("-------------------------------");
//			for (Project prject : projectrepository.findByprojectnameLike("%Project C%")) {
//				log.info(prject.toString());
//			}
//			log.info("");
//
//
//			////			 fetch all prodcut in the table by User_id
//			log.info("");
//			log.info("Project found with findByUserID():");
//			log.info("-------------------------------");
//			for (Project project : projectrepository.findByUser(userrepository.findByUserid(1))) {
//				log.info(project.toString());
//			}
//			log.info("");
//
//
//
//		};
//	}


		@Bean
		public CommandLineRunner demo3(ProductRepository productrepository,TechnicalDetailRepository technicalrepository) {
			return (args) -> {

				//		 Insert Project 1  into the table ans its corresponding technicaldetail,description,producttype
//				log.info("");
//				log.info(" Insert Project 1  into the table ans its corresponding technicaldetail,description,producttype:");
//				log.info("-------------------------------");
//				Product product1 = new Product("PHILIPS","BVOP",null,null,null);
//				TechnicalDetail technicaldetail1 = new TechnicalDetail(5467,21,240,35,null);
//				technicaldetail1.setProduct(product1);
//				product1.setTechnicaldetail(technicaldetail1);
//				Description description1 = new Description("Factory A","T-1600","T Model",product1);
//				product1.setDescription(description1);
//				ProductType producttype1 = new ProductType("Fans","Indoor","Ceiling","fan blade",Date.valueOf("2015-03-31"),product1);
//				product1.setProducttype(producttype1);
//				productrepository.save(product1);
//				log.info("Insertion Success");
//
//				log.info("");
//				log.info(" Insert Project 2  into the table ans its corresponding technicaldetail,description,producttype:");
//				log.info("-------------------------------");
//				Product product2 = new Product("Sumsung","ISO",null,null,null);
//				TechnicalDetail technicaldetail2 = new TechnicalDetail(3000,25,300,20,null);
//				technicaldetail2.setProduct(product2);
//				product2.setTechnicaldetail(technicaldetail2);
//				Description description2 = new Description("Factory B","R2000","R Model",product2);
//				product2.setDescription(description2);
//				ProductType producttype2 = new ProductType("Lignt","Indoor","Floor","light bulb",Date.valueOf("2007-08-09"),product2);
//				product2.setProducttype(producttype2);
//				productrepository.save(product2);
//				log.info("Insertion Success");
//
//				log.info("");
//				log.info(" Insert Project 3  into the table ans its corresponding technicaldetail,description,producttype:");
//				log.info("-------------------------------");
//				Product product3 = new Product("Home Essentials","ISO",null,null,null);
//				TechnicalDetail technicaldetail3 = new TechnicalDetail(2000,30,100,20,null);
//				technicaldetail3.setProduct(product3);
//				product3.setTechnicaldetail(technicaldetail3);
//				Description description3 = new Description("Factory C","T-600","T Model",product3);
//				product3.setDescription(description3);
//				ProductType producttype3 = new ProductType("Clothes Hooks","Indoor","Wall","fan blade",Date.valueOf("2023-08-09"),product3);
//				product3.setProducttype(producttype3);
//				productrepository.save(product3);
//				log.info("Insertion Success");




			};}

			@Bean
			public CommandLineRunner demo4(ProjectProductRepository projectproductrepository,ProjectRepository projectrepository, ProductRepository productrepository) {
				return (args) -> {
//					log.info("Insertion 6 relations");
//					log.info("-------------------------------");
//					Project project1 =projectrepository.findByProjectid(1);
//					Project project2 =projectrepository.findByProjectid(2);
//					Project project3 =projectrepository.findByProjectid(3);
//
//					Product product1 =productrepository.findByProductid(1);
//					Product product2 = productrepository.findByProductid(2);
//					Product product3 = productrepository.findByProductid(3);
//
//					ProjectProduct projectproduct1 = new ProjectProduct(1,project1,product1);
//					projectproductrepository.save(projectproduct1);
//					ProjectProduct projectproduct2 = new ProjectProduct(2,project1,product2);
//					projectproductrepository.save(projectproduct2);
//					ProjectProduct projectproduct3 = new ProjectProduct(3,project1,product3);
//					projectproductrepository.save(projectproduct3);
//					ProjectProduct projectproduct4 = new ProjectProduct(4,project2,product2);
//					projectproductrepository.save(projectproduct4);
//					ProjectProduct projectproduct5 = new ProjectProduct(5,project2,product3);
//					projectproductrepository.save(projectproduct5);
//
//					ProjectProduct projectproduct6 = new ProjectProduct(6,project3,product1);
//					projectproductrepository.save(projectproduct6);
//					log.info("Insertion Success");
//
//					log.info("");
//					log.info(" Search related projects  by product ID");
//					log.info("-------------------------------");
//					List<ProjectProduct>  projectproductlist= projectproductrepository.findByProduct(product1);
//					for(ProjectProduct projectproduct:projectproductlist){
//						Project project = projectproduct.getProject();
//						log.info(project.toString());
//					}
//					log.info("");
//
//					log.info("");
//					log.info(" Search related products  by project ID");
//					log.info("-------------------------------");
//					List<ProjectProduct>  projectproductlist1= projectproductrepository.findByProject(project1);
//					for(ProjectProduct projectproduct:projectproductlist1){
//						Product product = projectproduct.getProduct();
//						log.info(product.toString());
//					}
//					log.info("");
				};
	}
//
//
//	@Bean
//	public CommandLineRunner demo5(ProductRepository productrepository,DescriptionRepository descriptionrepository) {
//		return (args) -> {
//
//
//			log.info("");
//			log.info(" Search related products  by brand name");
//			log.info("-------------------------------");
//			List<Product> productlist1= productrepository.findByProductbrand("PHILIPS");
//			for(Product product:productlist1){
//				log.info(product.toString());
//			}
//			log.info("");
//
//			log.info("");
//			log.info(" Search related products  by certification");
//			log.info("-------------------------------");
//			List<Product> productlist2= productrepository.findByCertification("BVOP");
//			for(Product product:productlist2){
//				log.info(product.toString());
//			}
//			log.info("");
//
//
//			log.info("");
//			log.info(" Search related products  by description");
//			log.info("-------------------------------");
//			List<Description>  descriptionslist= descriptionrepository.findByModelLike("%T Model%");
//			for(Description description:descriptionslist){
//				Product product = productrepository.findByDescription(description);
//				log.info(product.toString());
//			}
//			log.info("");
//
//		};
//	}

    @Bean
    public CommandLineRunner demo6(ApplicationContext ctx,ProductRepository productrepository) {
        return (args) -> {
            System.out.println("Let's inspect the beans provided by Spring Boot:");
//            System.out.println(productrepository.findBySearch("T model"));

//            String[] beanNames = ctx.getBeanDefinitionNames();
//            Arrays.sort(beanNames);
//            for (String beanName : beanNames) {
//                System.out.println(beanName);
//            }




        };
    }




}
