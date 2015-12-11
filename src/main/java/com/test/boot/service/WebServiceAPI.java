package com.test.boot.service;

/**
 * Created by Alex on 10.12.2015.
 */
import com.test.boot.logic.PrivKeyGenerator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
/*контролер ресурса*/
@Controller
public class WebServiceAPI {
    @RequestMapping(value = "/generatePrivateKey", method = RequestMethod.GET) //generatePrivateKey - команда для генерации ключей
    public
    @ResponseBody
    String addPrivateKeyAndChaincode(@RequestParam(value = "pass", required = false,
            defaultValue = "b025710dc8338be9bbe9d10d5591d19f658b19d915004667f2ccbc5c40c4f35a") String pass,
                           @RequestParam(value = "chain", required = false,
                                   defaultValue = "4dde8414-bbfd-4e2c-bc25-019d3243f775") String chain) {
        PrivKeyGenerator generator = new PrivKeyGenerator(pass, chain);
        return generator.generatePrivKey();
    }
}
