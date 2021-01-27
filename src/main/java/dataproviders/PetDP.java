package dataproviders;

import model.Category;
import model.Pet;
import org.testng.annotations.DataProvider;
import utils.FileUtil;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class PetDP {
    FileUtil fileUtil = new FileUtil();

    @DataProvider(name = "creation")
    public Object[][] dataProviderMethod(Method m){
        Pet pet = new Pet();
        Category category = new Category();
        category.setName(fileUtil.getRandomAlphaNumString(8));
        pet.setCategory(category);
        pet.setName(fileUtil.getRandomAlphaNumString(8));
        pet.setStatus("available");
        pet.setPhotoUrls(new ArrayList<>(Collections.singletonList("https://static.t13.cl/images/sizes/1200x675/1542739291-captura-2.jpg")));
        pet.setId(new Random().nextInt(15000));

        return new Object[][]{{pet}};
    }
}
