package com.perfiltic.test.dto;

import java.util.HashMap;
import java.util.Map;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"name",
"description",
"weigth",
"price",
"categoryId"
})
public class ProductDto {

@JsonProperty("name")
@NotBlank(message = "name cannot be blank")
@Size(min = 5,message ="name need to have at least 5 characters")
private String name;

@JsonProperty("description")
@NotBlank(message = "description cannot be blank")
@Size(min = 5,message ="description need to have at least 5 characters")
private String description;

@JsonProperty("weigth")
private Double weigth;

@JsonProperty("price")
private Double price;

@JsonProperty("categoryId")
private Integer categoryId;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

/**
* No args constructor for use in serialization
*
*/
public ProductDto() {
}

/**
*
* @param weigth
* @param price
* @param name
* @param description
* @param categoryId
*/
public ProductDto(String name, String description, Double weigth, Double price, Integer categoryId) {
super();
this.name = name;
this.description = description;
this.weigth = weigth;
this.price = price;
this.categoryId = categoryId;
}

@JsonProperty("name")
public String getName() {
return name;
}

@JsonProperty("name")
public void setName(String name) {
this.name = name;
}

@JsonProperty("description")
public String getDescription() {
return description;
}

@JsonProperty("description")
public void setDescription(String description) {
this.description = description;
}

@JsonProperty("weigth")
public Double getWeigth() {
return weigth;
}

@JsonProperty("weigth")
public void setWeigth(Double weigth) {
this.weigth = weigth;
}

@JsonProperty("price")
public Double getPrice() {
return price;
}

@JsonProperty("price")
public void setPrice(Double price) {
this.price = price;
}

@JsonProperty("categoryId")
public Integer getCategoryId() {
return categoryId;
}

@JsonProperty("categoryId")
public void setCategoryId(Integer categoryId) {
this.categoryId = categoryId;
}

@JsonAnyGetter
public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

@JsonAnySetter
public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

}