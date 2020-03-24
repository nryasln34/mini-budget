package com.minibudget.config;

import static spark.Spark.before;
import static spark.Spark.get;
import static spark.Spark.halt;
import static spark.Spark.post;
import static spark.Spark.staticFileLocation;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;

import com.minibudget.model.ExpenseEntity;
import com.minibudget.model.IncomeEntity;
import com.minibudget.model.UsersEntity;
import com.minibudget.service.impl.MiniBudgetService;
import com.minibudget.util.DateUtil;
import org.apache.commons.beanutils.BeanUtils;
import org.eclipse.jetty.util.MultiMap;
import org.eclipse.jetty.util.UrlEncoded;
import org.springframework.util.StringUtils;
import spark.ModelAndView;
import spark.Request;
import spark.template.freemarker.FreeMarkerEngine;

public class WebConfig {

    private static final String USER_SESSION_ID = "user";
    private MiniBudgetService service;
    private static final String INCOME_ID ="income";
    private static final String EXPENSE_ID="expense";


    public WebConfig(MiniBudgetService service) {
        this.service = service;
        staticFileLocation("/public");
        setupRoutes();
    }

    private void setupRoutes() {



        get("/", (req, res) -> {
            UsersEntity user = getAuthenticatedUser(req);
            Map<String, Object> map = new HashMap<>();
            map.put("pageTitle", "Ne Kazandım? Ne Harcadım?");
            map.put("user", user);
            map.put("expenseEnum",ExpenseEnum.values());
            map.put("incomeEnum",IncomeEnum.values());
            return new ModelAndView(map, "income.ftl");
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
            return new ModelAndView(map, "income.ftl");
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
            user = service.checkUser(user);
            if(user != null) {
                addAuthenticatedUser(req, user);
                res.redirect("/");
                halt();
            } else {
                map.put("error", "Giriş hatalı!");
            }
            map.put("email", user.getEmail());
            return new ModelAndView(map, "login.ftl");
        }, new FreeMarkerEngine());

        before("/login", (req, res) -> {
            UsersEntity authUser = getAuthenticatedUser(req);
            if(authUser != null) {
                res.redirect("/");
                halt();
            }
        });

        get("/register", (req, res) -> {
            Map<String, Object> map = new HashMap<>();
            return new ModelAndView(map, "register.ftl");
        }, new FreeMarkerEngine());
        /*
         * Registers the user.
         */
        post("/register", (req, res) -> {
            Map<String, Object> map = new HashMap<>();
            UsersEntity user = new UsersEntity();
            String password2 = "";
            try {
                MultiMap<String> params = new MultiMap<String>();
                UrlEncoded.decodeTo(req.body(), params, "UTF-8");
                password2= params.getString("password2");
                BeanUtils.populate(user, params);
            } catch (Exception e) {
                halt(501);
                return null;
            }
            String error = service.validate(user,password2);
            if(StringUtils.isEmpty(error) && !Objects.isNull(user)) {
                UsersEntity existingUser = service.getUserbyEmail(user.getEmail());
                if(existingUser == null) {
                    service.registerUser(user);
                    res.redirect("/login?r=1");
                    halt();
                } else {
                    error = "The username is already taken";
                }
            }
            map.put("error", error);
            map.put("name", user.getName());
            map.put("surname",user.getSurname());
            map.put("email", user.getEmail());
            map.put("password",user.getPassword());
            return new ModelAndView(map, "register.ftl");
        }, new FreeMarkerEngine());
        /*
         * Checks if the user is already authenticated
         */
        before("/register", (req, res) -> {
            UsersEntity authUser = getAuthenticatedUser(req);
            if(authUser != null) {
                res.redirect("/");
                halt();
            }
        });

        post("/addIncome", (req, res) -> {
            UsersEntity user = getAuthenticatedUser(req);
            MultiMap<String> params = new MultiMap<String>();
            UrlEncoded.decodeTo(req.body(), params, "UTF-8");

            IncomeEntity income = new IncomeEntity();
            BeanUtils.populate(income, params);
            income.setUsersId(user.getId());
            income.setDate(DateUtil.toTimeStamp(new Date()));
            service.addIncome(income);
            res.redirect("/");
            return income;
        });

        before("/addIncome", (req, res) -> {
            UsersEntity authUser = getAuthenticatedUser(req);
            if(authUser == null) {
                res.redirect("/login");
                halt();
            }
        });

        post("/addExpense", (req, res) -> {
            UsersEntity user = getAuthenticatedUser(req);
            MultiMap<String> params = new MultiMap<String>();
            UrlEncoded.decodeTo(req.body(), params, "UTF-8");

            ExpenseEntity expense = new ExpenseEntity();
            BeanUtils.populate(expense, params);
            expense.setUsersId(user.getId());
            expense.setDate(DateUtil.toTimeStamp(new Date()));
            service.addExpense(expense);
            res.redirect("/");
            return expense;
        });

        before("/addExpense", (req, res) -> {
            UsersEntity authUser = getAuthenticatedUser(req);
            if(authUser == null) {
                res.redirect("/login");
                halt();
            }
        });



        get("/logout", (req, res) -> {
            removeAuthenticatedUser(req);
            res.redirect("/public");
            return null;
        });


        get("/allProcess", (req,res) -> {
            UsersEntity user = getAuthenticatedUser(req);
            Map<String, Object> map = new HashMap<>();
            map.put("user", user);

            List<ExpenseEntity> expenses = (List<ExpenseEntity>) service.getAllExpense(user.getId());
            map.put("expenses", expenses);

            List<IncomeEntity> incomes = (List<IncomeEntity>) service.getAllIncome(user.getId());
            map.put("incomes", incomes);

            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            //30 gün önceki tarih
            Date old = new Date();
            old.setMonth(old.getMonth() - 1);
            String oldDateSTR = format.format(old);
            map.put("fromDate",oldDateSTR);
            Date current = new Date();
            String currentDateSTR = format.format(current);
            map.put("toDate",currentDateSTR);
            map.put("totalExpenseAmount",service.getExpenseTotalAmount(expenses));
            map.put("totalIncomeAmount",service.getIncomeTotalAmount(incomes));
            return new ModelAndView(map, "allProcess.ftl");
        }, new FreeMarkerEngine());

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
