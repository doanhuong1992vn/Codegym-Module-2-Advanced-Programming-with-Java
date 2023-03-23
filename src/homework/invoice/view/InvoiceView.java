package homework.invoice.view;

import homework.invoice.service.InvoiceService;

import java.util.Scanner;

public class InvoiceView {
    private final InvoiceService invoiceService = new InvoiceService();

    public void displayInvoiceScreen() {
        System.out.println("""
                1. Print all invoices
                2. Print invoices by date
                Enter your choice:""");
        Scanner scanner = new Scanner(System.in);
        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice) {
            case 1 -> invoiceService.writeInvoice();
            case 2 -> {
                System.out.println("Enter the date in the format \"dd/MM/yyyy\" :");
                String date = scanner.nextLine();
                invoiceService.writeInvoiceByDate(date);
            }
            default -> {
                System.out.println("Invalid input!");
                displayInvoiceScreen();
            }
        }
    }
}
