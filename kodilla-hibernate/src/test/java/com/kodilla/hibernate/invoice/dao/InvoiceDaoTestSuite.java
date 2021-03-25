package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class InvoiceDaoTestSuite {
    @Autowired
    private InvoiceDao invoiceDao;
    @Test
    void testInvoiceDaoSave(){
        //Given
        Product product1 = new Product("tv");

        Item item1 = new Item(product1, new BigDecimal(1000),2,new BigDecimal(500));
        Item item2 = new Item(product1, new BigDecimal(700),2,new BigDecimal(500));
        Item item3 = new Item(product1, new BigDecimal(50),2,new BigDecimal(40));
        Item item4 = new Item(product1, new BigDecimal(20),2,new BigDecimal(10));
        List<Item> itemList = new ArrayList<>();
        itemList.add(item1);
        itemList.add(item2);
        itemList.add(item3);
        itemList.add(item4);
        Invoice invoice = new Invoice("1",itemList);
        item1.setInvoice(invoice);
        item2.setInvoice(invoice);
        item3.setInvoice(invoice);
        item4.setInvoice(invoice);
        product1.setItems(itemList);

        //When
        invoiceDao.save(invoice);
        int id = invoice.getId();
        //Then
        Assertions.assertEquals("1", invoice.getNumber() );
        Assertions.assertEquals(4, invoice.getItems().size() );

        //CleanUp
        invoiceDao.deleteById(id);
    }

}