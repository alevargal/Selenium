package tech.pages;

public class FourthForm {

    public String summaryDepart = "//td[contains(@class, 'frame_header_info')][1]/b/font";
    public String summaryDepartData = "//td[contains(@class, 'frame_header_info')][2]/b/font";
    public String summaryDepartFlyght = "//tr[3]/td[contains(@class, 'data_left')]/font/b";
    public String summaryDepartClass = "//tr[3]/td[contains(@class, 'data_center_mono')]/font";
    public String summaryDepartPrice = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[2]/td/table/tbody/tr[3]/td[contains(@class, 'data_center')]/font";

    public String summaryReturn = "//td[contains(@class, 'data_left')]/b/font";
    public String summaryReturnData = "//td[contains(@class, 'data_center_mono')]/b/font";
    public String summaryReturnFlyght = "//font/font/font[1]/b";
    public String summaryReturnClass = "//tr[6]/td[contains(@class, 'data_center_mono')]/font";
    public String summaryReturnPrice = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[2]/td/table/tbody/tr[6]/td[contains(@class, 'data_center')]/font";

    public String totalPrice = "//td[contains(@class, 'data_left')][2]/font/b";

    public String firstNameFirstPassengers = "//tr[4]/td/table/tbody/tr[2]/td[1]/input";
    public String lastNameFirstPassengers = "//tr[4]/td/table/tbody/tr[2]/td[2]/input";
    public String maelFirstPassengers = "//tr[4]/td/table/tbody/tr[2]/td[3]/select/option";

    public String firstNameSecondPassengers = "//tr[5]/td/table/tbody/tr[2]/td[1]/input";
    public String lastNameSecondPassengers = "//tr[5]/td/table/tbody/tr[2]/td[2]/input";
    public String maelSecondPassengers = "//tr[5]/td/table/tbody/tr[2]/td[3]/select/option";

    public String creditCardType = "//td[1]/select/option";
    public String creditCardNumber = "//tr[7]/td/table/tbody/tr[2]/td[2]/input";
    public String creditCardMonth = "//tr[7]/td/table/tbody/tr[2]/td[3]/select[1]/option";
    public String creditCardYear = "//select[2]/option";
    public String creditCardFirstName = "//tr[8]/td/table/tbody/tr[2]/td[1]/input";
    public String creditCardMiddle = "//tr[8]/td/table/tbody/tr[2]/td[2]/input";
    public String creditCardLast = "//td[3]/input";

    public String billingAddressAddress = "//tr[10]/td[2]/input";
    public String billingAddressCity = "//tr[12]/td[2]/input";
    public String billingAddressState = "//tr[13]/td[2]/input[1]";
    public String billingAddressCode = "//tr[13]/td[2]/input[2]";
    public String billingAddressContry = "//tr[14]/td[2]/select/option";

    public String deliveryAddressSameAsBillingAddress = "//tr[15]/td[2]/input";
    public String deliveryAddressAddress = "//tr[16]/td[2]/input";
    public String deliveryAddressCity = "//tr[18]/td[2]/input";
    public String deliveryAddressState = "//tr[19]/td[2]/input[1]";
    public String deliveryAddressCode = "//tr[19]/td[2]/input[2]";
    public String deliveryAddressContry = "//tr[20]/td[2]/select/option";

    public String further = "//tr[24]/td/input";

}
