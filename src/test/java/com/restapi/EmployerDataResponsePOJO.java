

package com.restapi;

import java.util.LinkedHashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.restapi.EmployeeDetails;



@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"id",
"employee_name",
"employee_salary",
"employee_age"
})

public class EmployerDataResponsePOJO extends EmployeeDetails {

@JsonProperty("id")
private String id;
@JsonProperty("employee_name")
private String employeeName;
@JsonProperty("employee_salary")
private String employeeSalary;
@JsonProperty("employee_age")
private String employeeAge;

@JsonProperty("profile_image")
private String profileimage;


@JsonIgnore
private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

@JsonProperty("id")
public String getId() {
return id;
}

@JsonProperty("id")
public void setId(String id) {
this.id = id;
}

@JsonProperty("employee_name")
public String getEmployeeName() {
return employeeName;
}

@JsonProperty("employee_name")
public void setEmployeeName(String employeeName) {
this.employeeName = employeeName;
}

@JsonProperty("employee_salary")
public String getEmployeeSalary() {
return employeeSalary;
}

@JsonProperty("employee_salary")
public void setEmployeeSalary(String employeeSalary) {
this.employeeSalary = employeeSalary;
}

@JsonProperty("employee_age")
public String getEmployeeAge() {
return employeeAge;
}

@JsonProperty("employee_age")
public void setEmployeeAge(String employeeAge) {
this.employeeAge = employeeAge;
}

@JsonProperty("profile_image")
public void setProfileImagee(String profileimage) {
this.profileimage = profileimage;
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