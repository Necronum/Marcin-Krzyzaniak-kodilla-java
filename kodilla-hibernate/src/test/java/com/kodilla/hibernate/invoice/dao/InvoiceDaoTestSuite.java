package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import java.math.BigDecimal;

@SpringBootTest
public class InvoiceDaoTestSuite {
    @Autowired
    private InvoiceDao invoiceDao;

    @Test
    void testInvoiceDaoSave(){
        //Given
        Product product1 = new Product("Apple");
        Product product2 = new Product("Banana");
        Item item1 = new Item(new BigDecimal(10), 100, new BigDecimal(1000));
        Item item2 = new Item(new BigDecimal(5), 3000, new BigDecimal(1500));
        Item item3 = new Item(new BigDecimal(25), 1000, new BigDecimal(2500));
        Invoice invoice1 = new Invoice("F001");
        Invoice invoice2 = new Invoice("F002");

        item1.setInvoice(invoice2);
        item2.setInvoice(invoice1);
        item3.setInvoice(invoice2);

        item1.setProduct(product1);
        item2.setProduct(product2);
        item3.setProduct(product1);

        product1.getItems().add(item1);
        product1.getItems().add(item3);
        product2.getItems().add(item2);

        invoice1.getItems().add(item2);
        invoice2.getItems().add(item1);
        invoice2.getItems().add(item3);

        //When
        invoiceDao.save(invoice1);
        int invoice1Id = invoice1.getId();
        invoiceDao.save(invoice2);
        int invoice2Id = invoice2.getId();

        //Then
        assertNotEquals(0, invoice1Id);
        assertNotEquals(0, invoice2Id);

        //CleanUp
        try{
            invoiceDao.deleteById(invoice1Id);
            invoiceDao.deleteById(invoice2Id);
        } catch (Exception e){
            //do nothing
        }
    }
}
