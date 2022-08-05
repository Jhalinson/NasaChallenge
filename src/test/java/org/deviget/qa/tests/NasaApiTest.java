package org.deviget.qa.tests;

import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.deviget.qa.basetest.BaseTest;
import org.deviget.qa.exceptions.RequestError;
import org.deviget.qa.exceptions.ResponseError;
import org.deviget.qa.factory.SpecBuilder;
import org.deviget.qa.models.Photo;
import org.deviget.qa.models.Photos;
import org.deviget.qa.utils.Configuration;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import static io.restassured.RestAssured.given;

public class NasaApiTest extends BaseTest {

    @Test(testName = "First 10 Mars photos made by Curiosity", description = "Retrieve the first 10 Mars photos made by \"Curiosity\" on 1000 Martian sol.", priority = 0)
    public void retrievingFirst10MarsPhotosFrom1000MartianSolCuriosity() throws RequestError, ResponseError {
        Map<String, String> params = new HashMap<>();
        params.put("sol", Configuration.SOL_VALUE);
        params.put("api_key", Configuration.API_KEY);
        params.put("page", Configuration.PAGE);

        Photos photos = given().spec(SpecBuilder.requestSpecification(params)).expect().defaultParser(Parser.JSON).when().get(Configuration.PATH).then().spec(SpecBuilder.responseSpecification(HttpStatus.SC_OK)).extract().body().as(Photos.class);
        List<Photo> photoList = photos.getPhotos();
        photoList.stream().limit(10).forEach(photo -> System.out.println(photo.toString()));


    }

    @Test(testName = "First 10 Mars photos made by Curiosity on Earth date", description = "Retrieve the first 10 Mars photos made by \"Curiosity\" on Earth date equal to 1000 Martian sol", priority = 1)
    public void retrievingFirstTenMarsPhotosOnEarthDate() throws ResponseError, RequestError {
        Map<String, String> params = new HashMap<>();
        params.put("earth_date", Configuration.EARTH_DATE);
        params.put("api_key", Configuration.API_KEY);
        params.put("page", Configuration.PAGE);

        Photos photos = given().spec(SpecBuilder.requestSpecification(params)).expect().defaultParser(Parser.JSON).when().get(Configuration.PATH).then().spec(SpecBuilder.responseSpecification(HttpStatus.SC_OK)).extract().body().as(Photos.class);
        List<Photo> photoList = photos.getPhotos();
        photoList.stream().filter(s -> s.sol == 1000).limit(10).forEach(photo -> System.out.println(photo.toString()));
    }


    @Test(testName = "Comparing photos made by Curiosity on 1000 sol and on Earth date", description = "Retrieve and compare the first 10 Mars photos made by \"Curiosity\" on 1000 sol and on Earth date equal to 1000 Martian sol", priority = 2)
    public void retrievingAndComparingTheFirstTenMarsPhotos() throws RequestError {
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("sol", "1000");
        queryParams.put("api_key", "DEMO_KEY");
        queryParams.put("page", "1");
        try {
            Photos photos = given().spec(SpecBuilder.requestSpecification(queryParams)).expect().defaultParser(Parser.JSON).when().get(Configuration.PATH).then().extract().body().as(Photos.class);
            List<Photo> photoList = photos.getPhotos();
            Map<String, String> queryParams2 = new HashMap<>();
            queryParams2.put("earth_date", "2015-05-30");
            queryParams2.put("api_key", "DEMO_KEY");
            queryParams2.put("page", "1");

            Photos photos2 = given().spec(SpecBuilder.requestSpecification(queryParams2)).expect().defaultParser(Parser.JSON).when().get(Configuration.PATH).then().extract().body().as(Photos.class);
            List<Photo> photoList2 = photos2.getPhotos();

            for (int i = 0; i <= 10; i++) {
                if (photoList.size() == photoList2.size()) {
                    if (photoList.get(i).toString().equals(photoList2.get(i).toString())) {
                        System.out.println(i + "-> " + photoList.get(i) + "\n" + photoList2.get(i));
                    }
                }
                Assert.assertEquals(photoList.size(), photoList2.size());
            }
            throw new RequestError();
        } catch (RequestError e) {


        }


    }

    @Test(testName = "Validating the amount of pictures that each Curiosity camera took on 1000 Mars", description = "Validate that the amounts of pictures that each \"Curiosity\" camera took on 1000 Mars sol is not greater than 10 times the amount taken by other cameras on the same date.", priority = 3)
    public void validatingTheAmountOfPicturesByCamera() throws RequestError, ResponseError {
        int counter =0;
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("sol", Configuration.SOL_VALUE);
        queryParams.put("earth_date", Configuration.EARTH_DATE);
        queryParams.put("api_key", Configuration.API_KEY);


        Photos photosOpportunity = given().spec(SpecBuilder.requestSpecification(queryParams)).expect().defaultParser(Parser.JSON).when().get(Configuration.OPPORTUNITY_PATH).then().spec(SpecBuilder.responseSpecification(HttpStatus.SC_OK)).extract().body().as(Photos.class);
        List<Photo> photoOpportunity = photosOpportunity.getPhotos();
        int photoOpportunitySize = photoOpportunity.size();
        photoOpportunity.stream().forEach(x -> System.out.println(x));

        Photos photosSpirit = given().spec(SpecBuilder.requestSpecification(queryParams)).expect().defaultParser(Parser.JSON).when().get(Configuration.SPIRIT_PATH).then().spec(SpecBuilder.responseSpecification(HttpStatus.SC_OK)).extract().body().as(Photos.class);
        List<Photo> photoSpirit = photosSpirit.getPhotos();
        int photoSpiritSize = photoSpirit.size();
        photoSpirit.stream().forEach(x -> System.out.println(x));

        Photos photosCuriosity = given().spec(SpecBuilder.requestSpecification(queryParams)).expect().defaultParser(Parser.JSON).when().get(Configuration.SPIRIT_PATH).then().spec(SpecBuilder.responseSpecification(HttpStatus.SC_OK)).extract().body().as(Photos.class);
        List<Photo> photoCuriosity = photosCuriosity.getPhotos();
        int photoCuriositySize = photoCuriosity.size();
        photoSpirit.stream().forEach(x -> System.out.println(x));

        String[] cameras = {"fhaz", "rhaz", "mast", "chemcam", "mahli", "mardi", "navcam"};
        Map<String, String> queryParams1 = new HashMap<>();
        for (int i = 0; i < cameras.length; i++) {
            String cameraNames = cameras[i];
            queryParams1.put("sol", Configuration.SOL_VALUE);
            queryParams1.put("camera", cameraNames);
            queryParams1.put("earth_date", Configuration.EARTH_DATE);
            queryParams1.put("api_key", Configuration.API_KEY);


            Photos photoCuriosityByCamera
                    = given().spec(SpecBuilder.requestSpecification(queryParams1)).expect().defaultParser(Parser.JSON).when().get(Configuration.PATH).then().spec(SpecBuilder.responseSpecification(HttpStatus.SC_OK)).extract().body().as(Photos.class);
            List<Photo> photosCuriosityByCamera = photoCuriosityByCamera.getPhotos();
            int photosCuriosityByCameraSize = photosCuriosityByCamera.size();

            int totalOtherPhotos = photoOpportunitySize + photoSpiritSize + photoCuriositySize;
            int comparePhotosSize = (totalOtherPhotos - photosCuriosityByCameraSize) * 10;
            if (photosCuriosityByCameraSize < comparePhotosSize) {
                counter++;
                System.out.println("The amounts of pictures for " + photoCuriosityByCamera.getPhotos().toString() + "+" +counter+ "+ camera is not greater than 10 times the amount taken by other cameras on the same date.");
            } else {
                System.out.println("The amounts of pictures for " + photoCuriosityByCamera.getPhotos().toString() + " camera is greater than 10 times the amount taken by other cameras on the same date.");
            }

        }
    }
}
