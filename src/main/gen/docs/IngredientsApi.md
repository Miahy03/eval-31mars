# IngredientsApi

All URIs are relative to *http://localhost:8000*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**ingredientsGet**](IngredientsApi.md#ingredientsGet) | **GET** /ingredients | Get all ingredients |
| [**ingredientsIdGet**](IngredientsApi.md#ingredientsIdGet) | **GET** /ingredients/{id} | Get an ingredient by ID |
| [**ingredientsIdStockGet**](IngredientsApi.md#ingredientsIdStockGet) | **GET** /ingredients/{id}/stock | Get stock value of an ingredient at a specific time |


<a id="ingredientsGet"></a>
# **ingredientsGet**
> List&lt;Ingredient&gt; ingredientsGet()

Get all ingredients

Returns list of ingredients

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.IngredientsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8000");

    IngredientsApi apiInstance = new IngredientsApi(defaultClient);
    try {
      List<Ingredient> result = apiInstance.ingredientsGet();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling IngredientsApi#ingredientsGet");
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

[**List&lt;Ingredient&gt;**](Ingredient.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | List of ingredients |  -  |

<a id="ingredientsIdGet"></a>
# **ingredientsIdGet**
> Ingredient ingredientsIdGet(id)

Get an ingredient by ID

Returns an ingredient based on its id

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.IngredientsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8000");

    IngredientsApi apiInstance = new IngredientsApi(defaultClient);
    Integer id = 1; // Integer | Ingredient identifier
    try {
      Ingredient result = apiInstance.ingredientsIdGet(id);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling IngredientsApi#ingredientsIdGet");
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
| **id** | **Integer**| Ingredient identifier | |

### Return type

[**Ingredient**](Ingredient.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, text/plain

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Ingredient found |  -  |
| **404** | Ingredient not found |  -  |

<a id="ingredientsIdStockGet"></a>
# **ingredientsIdStockGet**
> StockValue ingredientsIdStockGet(id, at, unit)

Get stock value of an ingredient at a specific time

Returns the stock value for the ingredient with the provided identifier at the specified time and unit

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.IngredientsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8000");

    IngredientsApi apiInstance = new IngredientsApi(defaultClient);
    Integer id = 1; // Integer | Ingredient identifier
    OffsetDateTime at = OffsetDateTime.parse("2026-06-01T12:00Z"); // OffsetDateTime | Timestamp at which to retrieve the stock value
    UnitType unit = UnitType.fromValue("KG"); // UnitType | Unit of measurement for the stock
    try {
      StockValue result = apiInstance.ingredientsIdStockGet(id, at, unit);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling IngredientsApi#ingredientsIdStockGet");
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
| **id** | **Integer**| Ingredient identifier | |
| **at** | **OffsetDateTime**| Timestamp at which to retrieve the stock value | |
| **unit** | [**UnitType**](.md)| Unit of measurement for the stock | [enum: KG, PCS, L] |

### Return type

[**StockValue**](StockValue.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, text/plain

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Stock value retrieved |  -  |
| **400** | Missing mandatory query parameter |  -  |
| **404** | Ingredient not found |  -  |

