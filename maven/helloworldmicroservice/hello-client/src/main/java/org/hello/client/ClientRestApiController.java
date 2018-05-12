package org.hello.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class ClientRestApiController
{
    @Autowired
    DiscoveryClient client;
    RestTemplate restTemplate = new RestTemplate();

    @RequestMapping(name = "/", method = RequestMethod.GET)
    public String hello()
    {
        List<ServiceInstance> instances = client.getInstances("hello-service");
        ServiceInstance instance = instances.stream().findFirst()
                .orElseThrow(() -> new RuntimeException("not found"));
        String url = String.format("%s/hello", instance.getUri());
        return restTemplate.getForObject(url, String.class);
    }
}
