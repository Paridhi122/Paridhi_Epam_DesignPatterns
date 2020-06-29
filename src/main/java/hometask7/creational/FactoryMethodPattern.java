package hometask7.creational;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

abstract class Plan{
    protected double rate;
    abstract void getRate();

    public void calculateBill(int units){
        System.out.println(units*rate);
    }
}

class DomesticPlan extends Plan {

    public void getRate(){
        rate=5.50;
    }
}
class CommercialPlan extends Plan {

    public void getRate() {
        rate = 9.50;
    }
}

class InstitutionalPlan extends Plan {

    public void getRate() {
        rate = 7.50;
    }
}

class GetPlanFactory {

    public Plan getPlan(String planType){
        if(planType == null){
            return null;
        }
        if(planType.equalsIgnoreCase("Domestic")) {
            return new DomesticPlan();
        }
        else if(planType.equalsIgnoreCase("Commercial")){
            return new CommercialPlan();
        }
        else if(planType.equalsIgnoreCase("Institutional")) {
            return new InstitutionalPlan();
        }
        return null;
    }
}

class FactoryMethodPattern {

    public static void main(String[] args)throws IOException {
        GetPlanFactory planFactory = new GetPlanFactory();

        System.out.print("Enter the name of plan: ");
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        String planName=br.readLine();
        System.out.print("Enter the number of units: ");
        int units=Integer.parseInt(br.readLine());

        Plan p = planFactory.getPlan(planName);

        System.out.print("Bill amount for " + planName + " of  " + units + " units is: Rs");
        p.getRate();
        p.calculateBill(units);
    }
}
