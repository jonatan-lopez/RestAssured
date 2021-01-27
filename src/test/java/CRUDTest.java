import dataproviders.PetDP;
import io.restassured.response.Response;
import model.Pet;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import services.PetService;

public class CRUDTest extends BaseTest{
    Pet pet =new Pet();
    PetService petService = new PetService();

    @BeforeTest(groups = { "getpet"})
    public void before(){
        pet=createPet();
        petService.postPet(pet);
    }

    @Test(dataProviderClass = PetDP.class,dataProvider = "creation")
    public void postTest(Pet pet){
        //Post Pet
        Response postResponse =petService.postPet(pet);
        Assert.assertEquals(postResponse.getStatusCode(),200);
        Assert.assertNotNull(postResponse.jsonPath().getObject("", Pet.class));
    }
    @Test(groups = { "getpet"})
    public void getPetTest(){
        Response getResponse = petService.getPet(pet.getId());
        Assert.assertEquals(getResponse.getStatusCode(),200);
        Assert.assertTrue(pet.equals(getResponse.jsonPath().getObject("", Pet.class)), "The response doesn't have the correct pet");
    }
    @Test(groups = { "getpet"})
    public void putPetTest(){
        pet.setName("UpdatePet");
        Assert.assertEquals(petService.putPet(pet).getStatusCode(),200);
        Assert.assertTrue(pet.equals(petService.getPet(pet.getId()).jsonPath().getObject("", Pet.class)), "The response doesn't have the correct pet");
    }
}
