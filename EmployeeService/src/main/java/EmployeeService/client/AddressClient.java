package EmployeeService.client;

import EmployeeService.entity.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Component
public class AddressClient {

    @Autowired
    private RestTemplate restTemplate;

    public void saveAddress(List<Address> addresses, Integer empId){
        addresses.stream().forEach(address -> {
            address.setEmpId(empId);
            HttpHeaders httpHeaders=new HttpHeaders();
            httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
            HttpEntity<Address> addressHttpEntity=new HttpEntity<Address>(address,httpHeaders);
            restTemplate.exchange("http://localhost:8888/add-service/add", HttpMethod.POST,addressHttpEntity,String.class);
        });
    }

//    public Address getAddressByEmployeeId(int empId) {
//        String url = "http://localhost:8888/add-service/getAddressByEmpId/" + empId;
//        return restTemplate.getForObject(url, Address.class);
//    }


//public List<Address> getAddress(int empId) {
//    HttpHeaders headers = new HttpHeaders();
//    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
//    HttpEntity<String> entity = new HttpEntity<String>(headers);
//    String url = "http://localhost:8888/add-service/getAddressByEmpId/" + empId;
//
//    return restTemplate.exchange(
//            url, HttpMethod.GET, entity,  new ParameterizedTypeReference<List<Address>>() {}).getBody();
//}

    public List<Address> getAddress(int empId) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);
        String url = "http://localhost:8888/add-service/getAddressByEmpId/" + empId;

        return handleAddressResponse(url, entity);
    }

    private List<Address> handleAddressResponse(String url, HttpEntity<String> entity) {
        try {
            // Try to parse the response as a list
            return restTemplate.exchange(url, HttpMethod.GET, entity, new ParameterizedTypeReference<List<Address>>() {}).getBody();
        } catch (RestClientException e) {
            // Log the error
            System.err.println("Error fetching address: " + e.getMessage());

            // You could throw a custom exception or handle it gracefully
            // For example, returning an empty list or a default Address list
            return new ArrayList<>();
        }
    }
    }
