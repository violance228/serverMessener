package com.konex.messenger.controller;

import com.google.gson.Gson;
import com.konex.messenger.entity.user.Role;
import com.konex.messenger.entity.user.User;
import com.konex.messenger.exception.PostException;
import com.konex.messenger.service.user.RoleService;
import com.konex.messenger.service.user.UserService;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.SessionScope;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * created by user violence
 * created on 19.10.2018
 * class created for project messenger
 */

@SessionScope
@Controller
public class UserController {
    @RequestMapping(value = "/")
    public
    @ResponseBody
    String root() throws PostException {
//        Document document = documentService.getDocumentById(100L);
//        incomeInvoiceService.post(document);
//        //System.out.println(document);
//        String json = documentHeaderToJson.buildJson(document);
//        System.out.println(json);

        //String json="{\"head\":{\"id\":4,\"delivery_Time\":\"21.03.2018 15:30:12\",\"total_amount\":0.00,\"reg_time\":1520846681002,\"child_docs\":0,\"parent_doc\":0,\"author\":10,\"author_name\":\"Ковалевський Віталій Анатолійович\",\"destination_name\":\"Аптека 1\",\"destination\":1,\"comments\":\"Test\",\"source_name\":\"Склад\",\"source\":16,\"status_name\":\"Створено\",\"status\":1,\"type_name\":\"Прихідна накладна\",\"type\":1,\"document_pn\":\"22222266\"}," +

//        System.out.println(new Date().getTime());
//        String str = "[{\"id\":2,\"documentId\":4,\"goodsId\":650,\"goods_name\":\"Декамевіт таб. в/о №20\",\"count\":10.000,\"income_price\":51.22000,\"outcome_price\":61.35,\"serial\":\"AB181515\",\"shipment_1s_code\":52142,\"expirationDate\":1520200800000},{\"id\":3,\"documentId\":4,\"goodsId\":57,\"goods_name\":\"Декамевіт таб. в/о №20\",\"count\":15.000,\"income_price\":51.22000,\"outcome_price\":61.35,\"serial\":\"AB181555\",\"shipment_1s_code\":52142,\"expirationDate\":1520200800000}]";
//        Gson gsonBodyFrom = new GsonBuilder().registerTypeAdapter(IncomeInvoiceTable.class, invoiceTableDeserializer).create();
//        List<IncomeInvoiceTable> incomeInvoiceTable = gsonBodyFrom.fromJson(str, new TypeToken<List<IncomeInvoiceTable>>(){}.getType());
//        System.out.println(incomeInvoiceTable);
//        Gson gsonRem=new GsonBuilder().registerTypeAdapter(RemnantsRegister.class, new RemnantsRegisterAdapter()).create();
//        Gson gsonShip=new GsonBuilder().registerTypeAdapter(Shipment.class, doc).create();

        return "ROOT ";// + documentToJson.buildJson(map.get("document"));
    }

//    @RequestMapping(value = "/login", method = {RequestMethod.POST, RequestMethod.GET})
//    public
//    @ResponseBody
//    String login(Model model, String error, String logout, HttpServletRequest request) {
//        Map<String, String> result = new HashMap<>();
//        Gson g = new Gson();
//        if (error != null) {
//            model.addAttribute("error", "Логін або пароль не вірні");
//            System.err.println("ACCESS DENIED");
//            System.out.println("=============> LOGIN GET ==== ERROR");
//            result.put("status", "ACCESS_DENIED");
//        }
//
//        if (logout != null) {
////            model.addAttribute("message", "Вихід успішний");
////            System.out.println("=============> LOGIN GET ==== LOGOUT");
////            request.getSession().setAttribute("logoff", true);
////            return "redirect:/home";
//        }
//        String referrer = request.getHeader("Referer");
//        if (referrer != null && !referrer.endsWith("/login") && !referrer.endsWith("/login?error")) {
//            //request.getSession().setAttribute("basket", basketId);
//        }
//        //result.put("JSESSIONID", request.getSession().getId());
//
//        //Cookie for chat
//
//        System.out.println("=============> LOGIN GET");
//        return g.toJson(result);
//    }

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @RequestMapping( value = "/login", method = {RequestMethod.GET, RequestMethod.POST})
    public @ResponseBody String loginGet() {

        return "";
    }

    @RequestMapping( value = "/user/registration", method = RequestMethod.POST)
    public @ResponseBody
    ResponseEntity saveRegistration(@ModelAttribute("user") User user, Model model,
                                    @RequestParam(name = "role") Long roleId) {
        try {
            if (userService.findUserByUsername(user.getUsername()) == null && userService.findUserByMobile(user.getMobile()) == null) {
                Set<Role> roles = new HashSet<>();
                roles.add(roleService.findById(roleId));
                user.setRoles(roles);
                userService.save(user);
                return ResponseEntity.ok("ok");
            } else {
                model.addAttribute("err", "Логін/телефон занятий");
                return ResponseEntity.ok("we wind you phone or username, cant reg");
            }
        }
        catch (Exception e) {
            System.err.println("Err registration");
            model.addAttribute("err", "Логін/телефон занятий");
            return ResponseEntity.ok("fail");
        }
    }
}
