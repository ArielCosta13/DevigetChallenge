package com.deviget.automation.pages;

import org.testng.Reporter;

public class BasePage {

    protected void updateAndReportStatusPageAction(String newStatus) {
        System.out.println("Page Action | " + newStatus );
    }

    protected void updateAndReportStatusPageInformation(String newStatus) {
        System.out.println("Page Information | " + newStatus );
    }

    protected void updateAndReportStatusPageWarning(String newStatus) {
        System.out.println("WARNING: " + newStatus );
    }
}
