import model.Category;
import model.Pet;
import utils.FileUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public abstract class BaseTest {

    FileUtil fileUtil = new FileUtil();

    public Pet createPet(){
        Pet pet = new Pet();
        Category category = new Category();
        category.setName(fileUtil.getRandomAlphaNumString(8));
        pet.setCategory(category);
        pet.setName(fileUtil.getRandomAlphaNumString(8));
        pet.setStatus("available");
        pet.setPhotoUrls(new ArrayList<>(Collections.singletonList("http://www.reportingday.com/wp-content/uploads/2018/06/Cat-Sleeping-Pics.jpg")));
        pet.setId(new Random().nextInt(15000));
        return pet;
    }
}
