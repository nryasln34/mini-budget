package com.minibudget.config;

import static spark.Spark.before;
import static spark.Spark.get;
import static spark.Spark.halt;
import static spark.Spark.post;
import static spark.Spark.staticFileLocation;

import java.util.*;

import com.minibudget.model.User;
import com.minibudget.service.impl.MiniBudgetService;
import org.apache.commons.beanutils.BeanUtils;
import org.eclipse.jetty.util.MultiMap;
import org.eclipse.jetty.util.UrlEncoded;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import spark.ModelAndView;
import spark.Request;
import spark.template.freemarker.FreeMarkerEngine;
import spark.utils.StringUtils;

import javax.persistence.EntityManager;

public class WebConfig {

    private static final String USER_SESSION_ID = "user";
    private MiniBudgetService service;
    private SessionFactory sf;


    public WebConfig(MiniBudgetService service, SessionFactory sf) {
        this.service = service;
        this.sf = sf;
        staticFileLocation("/public");
        setupRoutes();
    }

    private void setupRoutes() {



        get("/", (req, res) -> {
            User user = getAuthenticatedUser(req);
            Map<String, Object> map = new HashMap<>();
            map.put("pageTitle", "Timeline");
            map.put("user", user);

            return new ModelAndView(map, "timeline.ftl");
        }, new FreeMarkerEngine());
        before("/", (req, res) -> {
            User user = getAuthenticatedUser(req);
            if(user == null) {
                res.redirect("/public");
                halt();
            }
        });

        get("/public", (req, res) -> {
            User user = getAuthenticatedUser(req);
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
            User user = new User();
            try {
                MultiMap<String> params = new MultiMap<String>();
                UrlEncoded.decodeTo(req.body(), params, "UTF-8");
                BeanUtils.populate(user, params);
            } catch (Exception e) {
                halt(501);
                return null;
            }
            EntityManager session = sf.createEntityManager();
            User user2 = session.find(User.class, user.getUserName());
            if(user2 != null)
            //boolean result = service.checkUser(user);
            if(user2 != null) {
                addAuthenticatedUser(req, user);
                res.redirect("/");
                halt();
            } else {
                map.put("error", "Giriş hatalı!");
            }
            map.put("username", user.getUserName());
            return new ModelAndView(map, "login.ftl");
        }, new FreeMarkerEngine());

        before("/login", (req, res) -> {
            User authUser = getAuthenticatedUser(req);
            if(authUser != null) {
                res.redirect("/");
                halt();
            }
        });
    }

    private void addAuthenticatedUser(Request request, User u) {
        request.session().attribute(USER_SESSION_ID, u);

    }

    private void removeAuthenticatedUser(Request request) {
        request.session().removeAttribute(USER_SESSION_ID);

    }

    private User getAuthenticatedUser(Request request) {
        return request.session().attribute(USER_SESSION_ID);
    }
}
