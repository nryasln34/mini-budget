package com.minibudget.config;

import static spark.Spark.before;
import static spark.Spark.get;
import static spark.Spark.halt;
import static spark.Spark.post;
import static spark.Spark.staticFileLocation;

import java.util.*;

import com.minibudget.model.UsersEntity;
import com.minibudget.service.impl.MiniBudgetService;
import org.apache.commons.beanutils.BeanUtils;
import org.eclipse.jetty.util.MultiMap;
import org.eclipse.jetty.util.UrlEncoded;
import spark.ModelAndView;
import spark.Request;
import spark.template.freemarker.FreeMarkerEngine;

public class WebConfig {

    private static final String USER_SESSION_ID = "user";
    private MiniBudgetService service;


    public WebConfig(MiniBudgetService service) {
        this.service = service;
        staticFileLocation("/public");
        setupRoutes();
    }

    private void setupRoutes() {



        get("/", (req, res) -> {
            UsersEntity user = getAuthenticatedUser(req);
            Map<String, Object> map = new HashMap<>();
            map.put("pageTitle", "Timeline");
            map.put("user", user);

            return new ModelAndView(map, "timeline.ftl");
        }, new FreeMarkerEngine());
        before("/", (req, res) -> {
            UsersEntity user = getAuthenticatedUser(req);
            if(user == null) {
                res.redirect("/public");
                halt();
            }
        });

        get("/public", (req, res) -> {
            UsersEntity user = getAuthenticatedUser(req);
            Map<String, Object> map = new HashMap<>();
            map.put("pageTitle", "Dashboard");
            map.put("user", user);
            return new ModelAndView(map, "timeline.ftl");
        }, new FreeMarkerEngine());

        get("/login", (req, res) -> {
            Map<String, Object> map = new HashMap<>();
            if(req.queryParams("r") != null) {
                map.put("message", "You were successfully registered and can login now");
            }
            return new ModelAndView(map, "login.ftl");
        }, new FreeMarkerEngine());


        post("/login", (req, res) -> {
            Map<String, Object> map = new HashMap<>();
            UsersEntity user = new UsersEntity();
            try {
                MultiMap<String> params = new MultiMap<String>();
                UrlEncoded.decodeTo(req.body(), params, "UTF-8");
                BeanUtils.populate(user, params);
            } catch (Exception e) {
                halt(501);
                return null;
            }
            boolean result = service.checkUser(user);
            if(result) {
                addAuthenticatedUser(req, user);
                res.redirect("/");
                halt();
            } else {
                map.put("error", "Giriş hatalı!");
            }
            map.put("username", user.getName());
            return new ModelAndView(map, "login.ftl");
        }, new FreeMarkerEngine());

        before("/login", (req, res) -> {
            UsersEntity authUser = getAuthenticatedUser(req);
            if(authUser != null) {
                res.redirect("/");
                halt();
            }
        });
    }

    private void addAuthenticatedUser(Request request, UsersEntity u) {
        request.session().attribute(USER_SESSION_ID, u);

    }

    private void removeAuthenticatedUser(Request request) {
        request.session().removeAttribute(USER_SESSION_ID);

    }

    private UsersEntity getAuthenticatedUser(Request request) {
        return request.session().attribute(USER_SESSION_ID);
    }
}
