package com.rtb.therandomvalue;

import com.rtb.therandomvalue.models.entity.Category;
import com.rtb.therandomvalue.repositories.CategoryRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;

import static com.rtb.therandomvalue.utils.Constants.*;

@SpringBootApplication
public class TheRandomValueApplication {

    private final CategoryRepo categoryRepo;

    public TheRandomValueApplication(CategoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    public static void main(String[] args) {
        SpringApplication.run(TheRandomValueApplication.class, args);
    }

    @Bean
    public RestTemplate getRestTemplate() {

        return new RestTemplate();
    }

    @PostConstruct
    private void insertCategories() {

        String driveLink = "https://drive.google.com/uc?export=view&id=";

        categoryRepo.save(new Category(NUMBERS_AND_ALPHABETS, driveLink + "1GN7dxDH117IAFSiJCIWpWRJAqYNeGq21"));
        categoryRepo.save(new Category(DATES, driveLink + "1dBq0kuUeEfuT9RA8gO_yNZ6ioAI8IuRN"));
        categoryRepo.save(new Category(FOOD_RECIPES, driveLink + "1O52ZpSLO152Ela5kKkmNvlsB60YmDUeq"));
        categoryRepo.save(new Category(IMAGES, driveLink + "1OWowAmsfLBR6XI-41CnhG0qQOFelPNnI"));
        categoryRepo.save(new Category(SHOPPING, driveLink + "1xOSTyam8ULvkmNFyHNcCrgB_b-MyZP96"));
        categoryRepo.save(new Category(GITHUB_REPOSITORIES, driveLink + "1s0Nwxj0kbSQR0crK-rPaisurftpVf1fA"));
        categoryRepo.save(new Category(COLORS, driveLink + "1ZwTT87jKNqjd841o2uBs0DUlfPNy5vCX"));
        categoryRepo.save(new Category(VIDEOS, driveLink + "1740Y2jGSeDorFLhbwJdzx1EqF6aEMS8q"));
        categoryRepo.save(new Category(ARTICLES, driveLink + "166skDkiPSrW2EBr5Ge8urMTm368DRvAt"));
    }
}
