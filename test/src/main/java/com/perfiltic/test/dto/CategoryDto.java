package com.perfiltic.test.dto;

import java.util.HashMap;
import java.util.Map;

import javax.validation.constraints.Min;
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
"image",
"parentCategoryId"
})
public class CategoryDto {

@JsonProperty("name")
@NotBlank(message = "name cannot be blank")
@Size(min = 5,message ="name need to have at least 5 characters")
private String name;

@JsonProperty("image")
@NotBlank(message = "image cannot be blank")
@Size(min = 5,message ="image need to have at least 5 characters")
private String image;

@JsonProperty("parentCategoryId")
@NotBlank(message = "parentCategoryId cannot be blank")

private Integer parentCategoryId;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

/**
* No args constructor for use in serialization
*
*/
public CategoryDto() {
}

/**
*
* @param name
* @param image
* @param parentCategoryId
*/
public CategoryDto(String name, String image, Integer parentCategoryId) {
super();
this.name = name;
this.image = image;
this.parentCategoryId = parentCategoryId;
}

@JsonProperty("name")
public String getName() {
return name;
}

@JsonProperty("name")
public void setName(String name) {
this.name = name;
}

@JsonProperty("image")
public String getimage() {
return image;
}

@JsonProperty("image")
public void setimage(String image) {
this.image = image;
}

@JsonProperty("parentCategoryId")
public Integer getParentCategoryId() {
return parentCategoryId;
}

@JsonProperty("parentCategoryId")
public void setParentCategoryId(Integer parentCategoryId) {
this.parentCategoryId = parentCategoryId;
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