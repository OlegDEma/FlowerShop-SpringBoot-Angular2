package com.flower.shop.controller;

import com.flower.shop.entity.*;
import com.flower.shop.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class HomeController {

    private final Logger log = LoggerFactory.getLogger(HomeController.class);
    private ProductService productService;
    private BrandService brandService;
    private ManagerService managerService;
    private CategoryService categoryService;
    private  DeliveryService deliveryService;
    private ModelService modelService;
    private UserService userService;
    private ProductDescriptionService productDescriptionService;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public HomeController( ProductService productService, BrandService brandService, ManagerService managerService, CategoryService categoryService, DeliveryService deliveryService, ModelService modelService, ProductDescriptionService productDescriptionService, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.productService = productService;
        this.brandService = brandService;
        this.managerService = managerService;
        this.categoryService = categoryService;
        this.deliveryService = deliveryService;
        this.modelService = modelService;
        this.productDescriptionService = productDescriptionService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }




    @PostMapping("/sign-up")
    public void signUp(@RequestBody User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userService.addUser(user);
    }


    @PostMapping( "/saveBrand" )
    public Brand saveBrand(@RequestBody Brand brand) {
        System.out.println(brand);
        return brandService.save(brand);
    }

    @PostMapping( "/saveModel" )
    public Model saveModel(@RequestBody Model model) {
        System.out.println(model);
        return modelService.addModel(model);
    }

    @GetMapping("/deleteModel/{id}")
    public Model deleteModel(@PathVariable int id){
        modelService.removeById(id);
        return modelService.findOne(id);
    }

    @GetMapping("/modelList")
    public List<Model> modelList(){
        return modelService.findAll();
    }

    @PostMapping( "/saveDescription" )
    public ProductDescription saveDescription(@RequestBody ProductDescription productDescription) {
        System.out.println(productDescription);
        return productDescriptionService.addProductDescription(productDescription);
    }

    @GetMapping("/deleteDescription/{id}")
    public ProductDescription deleteDescription(@PathVariable int id){
        System.out.println("DELETED");
       productDescriptionService.removeDescriptionById(id);
        return productDescriptionService.findOne(id);
    }

    @GetMapping("/descriptionList")
    public List<ProductDescription> descriptionList(){
        return productDescriptionService.findAll();
    }


    @PostMapping( "/saveDelivery" )
    public Delivery saveDelivery(@RequestBody Delivery delivery) {
        System.out.println(delivery);
        return deliveryService.addDelivery(delivery);
    }

    @PostMapping( "/changeDelivery" )
    public Delivery changeDelivery(@RequestBody Delivery delivery) {
        System.out.println(delivery);
        return deliveryService.addDelivery(delivery);
    }

    @GetMapping("/deleteDelivery/{id}")
    public Delivery deleteDelivery(@PathVariable int id){
        System.out.println("DELETED");
        deliveryService.removeById(id);
        return deliveryService.findOne(id);
    }

    @PostMapping( "/changeBrand" )
    public Brand changeBrand(@RequestBody Brand brand) {
        System.out.println(brand);
        return brandService.save(brand);
    }

    @GetMapping("/brandList")
    public List<Brand> brandList(){
        User user = userService.findOne(1);
        user.setPassword("d09111997");
        this.userService.addUser(user);
        return brandService.findAll();
    }


    @GetMapping("/deleteBrand/{id}")
    public Brand deleteBrand(@PathVariable int id){
        brandService.removeById(id);
        return brandService.findOne(id);
    }

    @GetMapping("/deleteProduct/{id}")
    public Product deleteProduct(@PathVariable int id){
        productService.removeById(id);
        return productService.findOne(id);
    }

    @PostMapping( "/saveProduct" )
    public Product saveProduct(@RequestBody Product  product) {
        return productService.addProduct(product);
    }

    @GetMapping("/productList")
    public List<Product> productList(){
        return productService.findAll();
    }

    @GetMapping("/categoryList")
    public List<Category> categoryList(){
        return categoryService.findAll();
    }

    @PostMapping( "/saveManager" )
    public Manager saveBrand(@RequestBody Manager  manager) {
        return managerService.save(manager);
    }

    @GetMapping("/deleteManager/{id}")
    public Manager deleteManager(@PathVariable int id){
        managerService.removeManager(managerService.findOne(id));
        return managerService.findOne(id);
    }

    @GetMapping("/deliveryList")
    public List<Delivery> deliveryList(){
        return deliveryService.findAll();
    }

    @GetMapping("/managerList")
    public List<Manager> managerList(){
        return managerService.findAll();
    }

    @PostMapping( "/saveCategory" )
    public Category saveCategory(@RequestBody Category  category) {
        return categoryService.save(category);
    }


    @GetMapping("/principal")
    public String principal(Principal principal){
        return principal.getName();
    }

    @PostMapping("/saveImageForProduct")
    public String handleFileUpload(@RequestParam("file") MultipartFile file) {

        productService.saveImage(file);
        return "ok";
    }
}





