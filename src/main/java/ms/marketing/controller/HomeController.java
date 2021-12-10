/*
파일이름: HomeController.java
기   능: Controller
작 성 자: 201921288 정륜수
작성일자: 2021/11/25 (최종)
* */

//
package ms.marketing.controller;

import ms.marketing.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@Controller
public class HomeController {
    ArrayList<Customer> customers_centeroids;

    public HomeController(){

    }

    @RequestMapping(value = "/")
    public String index(Model model) {
        init();
        model.addAttribute("text", "Spring Page.");
        return "index";
    }

    @RequestMapping(value ="/result")
    public String result(Model model, HttpServletRequest request) throws ParseException {
        String customer_type="";
        String text="";

        // input new customer attribute value
        Customer customer = new Customer();
        customer.setYear_birth(Double.parseDouble(request.getParameter("birth_year")));
        customer.setMarital_status(request.getParameter("marital_status"));
        customer.setEducation(request.getParameter("education"));
        customer.setIncome(Double.parseDouble(request.getParameter("income")));
        customer.setHas_child(request.getParameter("has_child"));

        Date format1 = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("dt_customer"));
        Date format2 = new SimpleDateFormat("yyyy-MM-dd").parse("2021-11-23");
        customer.setSeniority((format2.getTime()-format1.getTime())/86400000);

        customer.setRecency(Double.parseDouble(request.getParameter("recency")));
        double spending =Double.parseDouble(request.getParameter("mnt_wines"))
                +Double.parseDouble(request.getParameter("mnt_fruits"))
                +Double.parseDouble(request.getParameter("mnt_meatProducts"))
                +Double.parseDouble(request.getParameter("mnt_fishProducts"))
                +Double.parseDouble(request.getParameter("mnt_sweetProducts"))
                +Double.parseDouble(request.getParameter("mnt_goldProduct"));
        customer.setSpending(spending);

        customer.setNumDealsPurchases(Double.parseDouble(request.getParameter("numDealsProduct")));
        customer.setNumWebPurchases(Double.parseDouble(request.getParameter("numWebPurchases")));
        customer.setNumCatalogPurchases((Double.parseDouble(request.getParameter("numCatalogePurchases"))));
        customer.setNumStorePurchases(Double.parseDouble(request.getParameter("numStorePurchases")));
        customer.setNumWebVisitsMonth(Double.parseDouble(request.getParameter("numWebVisitsMonth")));
        customer.setComplain(request.getParameter("complain"));
        customer.setResponse(request.getParameter("response"));

        // find nearest centeroid.
        int result = findNearestCenteroid(customer);

        switch(result){
            case 0:
                customer_type="Welcome";
                text="이 고객 집합은 다른 집합들과 비교했을 때, 서비스 이용을 비교적 최근에 시작했습니다.\n" +
                        "\n" +
                        " 다른 고객들 집합과 비교했을 때 해당 회사 상품들을 가장 적게 소비하고 있습니다.\n";
                break;
            case 1:
                customer_type="Bronze";
                text ="이 고객 집합은 다른 집합들보다 서비스를 이용한 지 오래 되었지만, \n" +
                        "\n" +
                        " 다른 고객들과 비교했을 때, 해당 회사 상품들을 적게 소비하고 있습니다. \n";
                break;
            case 2:
                customer_type="Silver";
                text="이 고객 집합은 다른 집합들과 비교했을 때 서비스 이용을 최근에 시작했지만, \n" +
                        "\n" +
                        "해당 회사 상품들을 많이 소비하고 있습니다. \n" +
                        "\n" +
                        "다른 고객 집합들과 비교했을 때 웹사이트에 접근을 많이 하는 편입니다.\n";
                break;
            case 3:
                customer_type="Gold";
                text="이 고객 집합은 해당 회사 상품들을 가장 많이 소비하고 있고, \n" +
                        "\n" +
                        "다른 고객들과 비교했을 때 서비스에 관심이 많은 듯 합니다.\n" +
                        "\n" +
                        "Sliver 그룹보다 오랫동안 서비스를 사용해 왔습니다.";
                break;
        }
        model.addAttribute("customer_type",customer_type);
        model.addAttribute("text",text);
        return "result";
    }

    public void init(){
        this.customers_centeroids = new ArrayList<Customer>();
        customers_centeroids.add(new Customer("Undergraduate","In couple",32492.6279,
                "No child",3054.093,45.5814,259.5465,1.593,
                2.7558,1.2907, 4.0116,6.314,"NO","YES"));

        customers_centeroids.add(new Customer("Postgraduate" , "Alone", 44999.0227, "Has child",
                3065.7051,   48.459,   380.349,  2.6859,  3.8988, 1.7382,
                4.9354, 6.1187,  "NO", "NO"  ));

        customers_centeroids.add(new Customer("Postgraduate", "In couple", 47554.1931, "Has child",
                3053.4333, 49.6529, 416.8529, 2.8196, 3.9902, 1.8549,
                5.3206, 6.0255,  "NO", "NO"));

        customers_centeroids.add(new Customer("Postgraduate", "In couple",  72532.4855,  "No child",
                3058.648, 49.1103, 1288.4836, 1.0658, 4.7002, 5.5164,
                7.9478, 2.8994, "NO",  "NO"));
    }

    public double normalization(double min_value, double max_value, double value){
        double normalizedValue;
        normalizedValue=(value-min_value)/(max_value-min_value);
        return normalizedValue;
    }

    public double calculateDistance(Customer centeroid, Customer customer){
        double result=0;
        double tmp =0;

        // Education attribute (nominal)
        if(customer.getEducation().equals(centeroid.getEducation())) result+=0;
        else result+=1;

        // Marital_status attribute (nominal)
        if(customer.getMarital_status().equals(centeroid.getMarital_status())) result+=0;
        else result+=1;

        // Income attribute (numeric)
        result+=Math.pow((normalization(1730,666666,centeroid.getIncome())
                -normalization(1730,666666,customer.getIncome())),2);

        // Has_child attribute (nominal)
        if(customer.getHas_child().equals(centeroid.getHas_child())) result+=0;
        else result+=1;

        // Seniority attribute (numeric)
        result+=Math.pow((normalization(2669,3403,centeroid.getSeniority())
                -normalization(2669,3403,customer.getSeniority())),2);

        // Recency attribute (numeric)
        result+=Math.pow((normalization(0,99,centeroid.getRecency())
                -normalization(0,99,customer.getRecency())),2);

        // Spending attribute (numeric)
        result+=Math.pow((normalization(5,2525,centeroid.getSpending())
                -normalization(5,2525,customer.getSpending())),2);

        // NumDealsPurchases attribute (numeric)
        result+=Math.pow((normalization(0,15,centeroid.getNumDealsPurchases())
                -normalization(0,15,customer.getSpending())),2);

        // NumWebPurchases attribute (numeric)
        result+=Math.pow((normalization(0,27,centeroid.getNumWebPurchases())
                -normalization(0,27,customer.getNumWebPurchases())),2);

        // NumCatalogPurchases attribute (numeric)
        result+=Math.pow((normalization(0,28,centeroid.getNumCatalogPurchases())
                -normalization(0,28,customer.getNumCatalogPurchases())),2);

        // NumStorePurchases attribute (numeric)
        result+=Math.pow((normalization(0,13,centeroid.getNumStorePurchases())
                -normalization(0,13,customer.getNumStorePurchases())),2);

        // NumWebVisitsMonth attribute (numeric)
        result+=Math.pow((normalization(0,20,centeroid.getNumWebVisitsMonth())
                -normalization(0,20,customer.getNumWebVisitsMonth())),2);

        // Complain attribute (nominal)
        if(customer.getComplain().equals(centeroid.getComplain())) result+=0;
        else result+=1;

        // Response attribute (nominal)
        if(customer.getResponse().equals(centeroid.getResponse())) result+=0;
        else result+=1;

        return result;
    }

    public int findNearestCenteroid(Customer customer){
        double nearst = calculateDistance(this.customers_centeroids.get(0), customer);
        int nearst_centeroid=0;
        for(int i=0;i<this.customers_centeroids.size();i++){
            double tmp = calculateDistance(this.customers_centeroids.get(i),customer);
            if(tmp<nearst){
                nearst=tmp;
                nearst_centeroid = i;
            }
        }
        return nearst_centeroid;
    }

}