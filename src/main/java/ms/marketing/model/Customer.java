package ms.marketing.model;

public class Customer {
    private double year_birth;
    private String education;
    private String marital_status;
    private double income;
    private double kidHome;
    private double teenHome;
    private double children;
    private String has_child;
    private double dt_customer;
    private double seniority;
    private double recency;
    private double mntWines;
    private double mntFruits;
    private double mntMeatProducts;
    private double mntFishProducts;
    private double mntSweetProducts;
    private double mntGoldProducts;
    private double spending;
    private double numDealsPurchases;
    private String response;
    private double numWebPurchases;
    private double numCatalogPurchases;
    private double numStorePurchases;
    private double numWebVisitsMonth;
    private String complain;

    public Customer(){

    }
    public Customer(String education, String marital_status, double income, String has_child, double seniority,
                    double recency, double spending, double numDealsPurchases, double numWebPurchases, double numCatalogPurchases,
                    double numStorePurchases, double numWebVisitsMonth, String complain, String response){
        this.education=education;
        this.marital_status=marital_status;
        this.income=income;
        this.has_child=has_child;
        this.seniority=seniority;
        this.recency=recency;
        this.spending=spending;
        this.numDealsPurchases=numDealsPurchases;
        this.numWebPurchases=numWebPurchases;
        this.numCatalogPurchases=numCatalogPurchases;
        this.numStorePurchases=numStorePurchases;
        this.numWebVisitsMonth=numWebVisitsMonth;
        this.complain=complain;
        this.response=response;
    }
    public void setYear_birth(double year_birth) {
        this.year_birth = year_birth;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public void setMarital_status(String marital_status) {
        this.marital_status = marital_status;
    }

    public void setIncome(double income) {
        this.income = income;
    }

    public void setKidHome(double kidHome) {
        this.kidHome = kidHome;
    }

    public void setTeenHome(double teenHome) {
        this.teenHome = teenHome;
    }

    public void setChildren(double children) {
        this.children = children;
    }

    public void setHas_child(String has_child) {
        this.has_child = has_child;
    }

    public void setDt_customer(double dt_customer) {
        this.dt_customer = dt_customer;
    }

    public void setSeniority(double seniority) {
        this.seniority = seniority;
    }

    public void setRecency(double recency) {
        this.recency = recency;
    }

    public void setMntWines(double mntWines) {
        this.mntWines = mntWines;
    }

    public void setMntFruits(double mntFruits) {
        this.mntFruits = mntFruits;
    }

    public void setMntMeatProducts(double mntMeatProducts) {
        this.mntMeatProducts = mntMeatProducts;
    }

    public void setMntFishProducts(double mntFishProducts) {
        this.mntFishProducts = mntFishProducts;
    }

    public void setMntSweetProducts(double mntSweetProducts) {
        this.mntSweetProducts = mntSweetProducts;
    }

    public void setMntGoldProducts(double mntGoldProducts) {
        this.mntGoldProducts = mntGoldProducts;
    }

    public void setSpending(double spending) {
        this.spending = spending;
    }

    public void setNumDealsPurchases(double numDealsPurchases) {
        this.numDealsPurchases = numDealsPurchases;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public void setNumWebPurchases(double numWebPurchases) {
        this.numWebPurchases = numWebPurchases;
    }

    public void setNumCatalogPurchases(double numCatalogPurchases) {
        this.numCatalogPurchases = numCatalogPurchases;
    }

    public void setNumStorePurchases(double numStorePurchases) {
        this.numStorePurchases = numStorePurchases;
    }

    public void setNumWebVisitsMonth(double numWebVisitsMonth) {
        this.numWebVisitsMonth = numWebVisitsMonth;
    }

    public void setComplain(String complain) {
        this.complain = complain;
    }

    public double getYear_birth() {
        return year_birth;
    }

    public String getEducation() {
        return education;
    }

    public String getMarital_status() {
        return marital_status;
    }

    public double getIncome() {
        return income;
    }

    public double getKidHome() {
        return kidHome;
    }

    public double getTeenHome() {
        return teenHome;
    }

    public double getChildren() {
        return children;
    }

    public String getHas_child() {
        return has_child;
    }

    public double getDt_customer() {
        return dt_customer;
    }

    public double getSeniority() {
        return seniority;
    }

    public double getRecency() {
        return recency;
    }

    public double getMntWines() {
        return mntWines;
    }

    public double getMntFruits() {
        return mntFruits;
    }

    public double getMntMeatProducts() {
        return mntMeatProducts;
    }

    public double getMntFishProducts() {
        return mntFishProducts;
    }

    public double getMntSweetProducts() {
        return mntSweetProducts;
    }

    public double getMntGoldProducts() {
        return mntGoldProducts;
    }

    public double getSpending() {
        return spending;
    }

    public double getNumDealsPurchases() {
        return numDealsPurchases;
    }

    public String getResponse() {
        return response;
    }

    public double getNumWebPurchases() {
        return numWebPurchases;
    }

    public double getNumCatalogPurchases() {
        return numCatalogPurchases;
    }

    public double getNumStorePurchases() {
        return numStorePurchases;
    }

    public double getNumWebVisitsMonth() {
        return numWebVisitsMonth;
    }

    public String getComplain() {
        return complain;
    }
}
