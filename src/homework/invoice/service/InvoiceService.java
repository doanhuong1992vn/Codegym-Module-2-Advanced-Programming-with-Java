package homework.invoice.service;

import homework.invoice.entity.Invoice;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class InvoiceService {
    private static final List<Invoice> invoiceList;

    static {
        invoiceList = new ArrayList<>();
        try {
            invoiceList.add(new Invoice("Hưởng", "Điện thoại", 30000, "19/03/2023"));
            invoiceList.add(new Invoice("Minh", "Quần lửng", 200, "19/03/2023"));
            invoiceList.add(new Invoice("Dâm Lê", "Mặt nạ dâm", 300, "19/03/2023"));
            invoiceList.add(new Invoice("Thái", "Quần đùi", 40, "20/03/2023"));
            invoiceList.add(new Invoice("Phước", "Áo hoa 3D", 500, "20/03/2023"));
            invoiceList.add(new Invoice("Khánh", "Toy silicon", 8000, "20/03/2023"));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public void writeInvoice() {
        File file = new File("D:\\Codegym\\Codegym-Module-2-Advanced-Programming-with-Java\\src\\homework\\invoice\\file\\invoice.txt");
        try (FileWriter fileWriter = new FileWriter(file);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {

            bufferedWriter.write("Tên người mua\tTên sản phẩm\tGiá\t\t\tNgày mua hàng\n");
            for (Invoice invoice : invoiceList) {
                bufferedWriter.write(invoice.toString());
            }
            System.out.println("Invoice has been printed. Please check file \"invoice.txt\"");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public void writeInvoiceByDate(String date) {
        File file = new File("invoice\\invoice.txt");
        try (FileWriter fileWriter = new FileWriter(file);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {

            bufferedWriter.write("Tên người mua\tTên sản phẩm\tGiá\t\t\tNgày mua hàng\n");
            Date inputDate = new SimpleDateFormat("dd/MM/yyyy").parse(date);
            System.out.println(inputDate);
            long millisTimeOfInputDate = inputDate.getTime();
            System.out.println(millisTimeOfInputDate);
            boolean flag = false;
            for (Invoice invoice : invoiceList) {
                if (invoice.getMillisTimeOfPurchaseDate() == millisTimeOfInputDate) {
                    bufferedWriter.write(invoice.getNameOfCustomer() + "\t\t\t"
                            + invoice.getNameOfProduct() + "\t\t"
                            + invoice.getPrice() + "\t\t"
                            + invoice.getPurchaseDate() + "\n");
                    flag = true;
                }
            }
            if (flag) {
                System.out.println("Invoice has been printed. Please check file \"invoice.txt\"");
            } else {
                System.out.println("No invoice on " + date);
                bufferedWriter.write("No invoice on " + date);
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
