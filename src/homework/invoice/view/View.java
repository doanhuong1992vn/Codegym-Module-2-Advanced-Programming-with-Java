package homework.invoice.view;

public class View {
    public static void main(String[] args) {
        InvoiceView invoiceView = new InvoiceView();
        do {
            try {
                invoiceView.displayInvoiceScreen();
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        } while (true);
    }
}
