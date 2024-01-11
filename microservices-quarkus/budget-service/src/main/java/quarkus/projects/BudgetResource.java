package quarkus.projects;

import java.text.DecimalFormat;
import java.util.Random;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("/budgets")
public class BudgetResource {

    private double getRandomNumber() {
        return Double.valueOf(new DecimalFormat("0.00").format( new Random().nextDouble() * 10000));
    }

    private String calculateBudgetStatus() {
        double allocation = getRandomNumber();
        double utilization = getRandomNumber();
        double utilizationPercentage = utilization * 100 / allocation;

        if (utilizationPercentage < 80) 
            return "GREEN";
        else if (utilizationPercentage < 100) 
            return "AMBER";
        else 
            return "RED";
    }

    @GET
    @Path("{projectId}/status")
    public String getBudgetStatusForProjectId(@PathParam("projectId") Long projectId) {
        return calculateBudgetStatus();
    }


}
