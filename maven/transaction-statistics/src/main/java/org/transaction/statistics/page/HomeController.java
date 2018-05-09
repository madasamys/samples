package org.transaction.statistics.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @version : 1.x.x.
 * @author: madasamy
 */
@Controller
public class HomeController
{
    @RequestMapping("/")
    @ResponseBody
    public String home()
    {
        return "Welcome to Transaction statistics app";
    }
}
