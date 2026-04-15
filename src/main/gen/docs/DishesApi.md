# DishesApi

All URIs are relative to *http://localhost:8000*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**dishesGet**](DishesApi.md#dishesGet) | **GET** /dishes | Get all dishes |
| [**dishesIdIngredientsPut**](DishesApi.md#dishesIdIngredientsPut) | **PUT** /dishes/{id}/ingredients | Update ingredients associated with a dish |


<a id="dishesGet"></a>
# **dishesGet**
> List&lt;Dish&gt; dishesGet()

Get all dishes

Returns list of dishes

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DishesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8000");

    DishesApi apiInstance = new DishesApi(defaultClient);
    try {
      List<Dish> result = apiInstance.dishesGet();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DishesApi#dishesGet");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**List&lt;Dish&gt;**](Dish.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | List of dishes |  -  |

<a id="dishesIdIngredientsPut"></a>
# **dishesIdIngredientsPut**
> Dish dishesIdIngredientsPut(id, dishIngredient)

Update ingredients associated with a dish

Allows associating or dissociating a list of ingredients to the dish identified by id

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DishesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8000");

    DishesApi apiInstance = new DishesApi(defaultClient);
    Integer id = 1; // Integer | Dish identifier
    List<DishIngredient> dishIngredient = Arrays.asList(); // List<DishIngredient> | 
    try {
      Dish result = apiInstance.dishesIdIngredientsPut(id, dishIngredient);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DishesApi#dishesIdIngredientsPut");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **id** | **Integer**| Dish identifier | |
| **dishIngredient** | [**List&lt;DishIngredient&gt;**](DishIngredient.md)|  | |

### Return type

[**Dish**](Dish.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json, text/plain

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Updated dish with its ingredients |  -  |
| **400** | Missing request body |  -  |
| **404** | Dish not found |  -  |

