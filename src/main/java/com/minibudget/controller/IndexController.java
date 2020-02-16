package com.minibudget.controller;

import spark.*;
import java.util.*;

public class IndexController {

    public static Route serveIndexPage = (Request request, Response response) -> {
        Map<String, Object> map = new HashMap<>();
        return new ModelAndView(map, "/spark/template/freemarker/index.ftl");
    };
}
