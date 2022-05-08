package live.sdet;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.microsoft.playwright.APIRequest;
import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.RequestOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Unit test for simple App.
 */
public class AppTest 
{

    Playwright playwright;
    APIRequestContext apiRequestContext;

    @BeforeClass
    public void setUp(){
        playwright = Playwright.create();
        Map<String,String> headers =  new HashMap<>();
        headers.put("Content-Type","application/json");

        apiRequestContext = playwright.request().newContext(new APIRequest.NewContextOptions()
                .setBaseURL("http://localhost:8888")
                .setExtraHTTPHeaders(headers));
    }

    @Test
    public void CRUDCallVerification()
    {

//        // GET
//        Integer responseCode = apiRequestContext.get("/comments").status();
//        Assert.assertEquals(200,responseCode);

        //POST
        Map<String,String> payLoadComment = new HashMap<>();
        payLoadComment.put("body","This is Commnet from PATCH Call");
        payLoadComment.put("postId","1");

//
//        String response = apiRequestContext.post("/comments", RequestOptions.create().setData(payLoadComment)).text();
//        System.out.println(response);
//
//        JsonObject json = new Gson().fromJson(response, JsonObject.class);
//        System.out.println(json.get("body"));
//        System.out.println(json.get("id"));
//        System.out.println(json.get("postId"));
//
//        Assert.assertNotNull(json.get("id"));

        String responsePatch = apiRequestContext.delete("/comments/6", RequestOptions.create().setData(payLoadComment)).text();
        System.out.println(responsePatch);

        JsonObject json1 = new Gson().fromJson(responsePatch, JsonObject.class);
        System.out.println(json1.get("body"));
        System.out.println(json1.get("id"));
        System.out.println(json1.get("postId"));

        Assert.assertNotNull(json1.get("id"));

    }

    @AfterClass
    public void tearDown(){

        apiRequestContext.dispose();
        playwright.close();

    }
}
