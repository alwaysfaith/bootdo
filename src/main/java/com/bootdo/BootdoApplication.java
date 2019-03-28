package com.bootdo;

import com.bootdo.common.dao.TaskDao;
import com.bootdo.system.domain.BasicHouseOrderDO;
import com.bootdo.system.domain.orderData;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * @author ECHO
 */
@EnableAutoConfiguration(exclude = {
        org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class
})
@EnableTransactionManagement
@ServletComponentScan
@MapperScan("com.bootdo.*.dao")
@SpringBootApplication
@EnableCaching
@Controller
public class BootdoApplication {
    public static void main(String[] args) {
        SpringApplication.run(BootdoApplication.class, args);
        System.out.println("ヾ(◍°∇°◍)ﾉﾞ    bootdo启动成功      ヾ(◍°∇°◍)ﾉﾞ\n" +
                " ______                    _   ______            \n" +
                "|_   _ \\                  / |_|_   _ `.          \n" +
                "  | |_) |   .--.    .--. `| |-' | | `. \\  .--.   \n" +
                "  |  __'. / .'`\\ \\/ .'`\\ \\| |   | |  | |/ .'`\\ \\ \n" +
                " _| |__) || \\__. || \\__. || |, _| |_.' /| \\__. | \n" +
                "|_______/  '.__.'  '.__.' \\__/|______.'  '.__.'  ");
    }

    @Autowired
    TaskDao  taskDao;

    @GetMapping("/blog/insert")
    public void insertData() {
        // 解析books.xml文件
        // 创建SAXReader的对象reader
        SAXReader reader = new SAXReader();
        List<BasicHouseOrderDO> orderDOS = new ArrayList<>();
        try {
            // 通过reader对象的read方法加载books.xml文件,获取docuemnt对象。
            Document document = reader.read(new File("src/main/resources/books2.xml"));
            // 通过document对象获取根节点bookstore
            Element bookStore = document.getRootElement();
            // 通过element对象的elementIterator方法获取迭代器
            Iterator it = bookStore.elementIterator();
            // 遍历迭代器，获取根节点中的信息（书籍）
            while (it.hasNext()) {

                BasicHouseOrderDO orderDO = new BasicHouseOrderDO();
                System.out.println("=====开始遍历某一本书=====");
                Element book = (Element) it.next();
                // 获取book的属性名以及 属性值
                List<Attribute> bookAttrs = book.attributes();
                for (Attribute attr : bookAttrs) {
                    if (attr.getName().equalsIgnoreCase("orderid")) {
                        orderDO.setId(Long.valueOf(attr.getValue()));
                        orderDO.setOrderNo(Long.valueOf(attr.getValue()));
                    }
                    if (attr.getName().equalsIgnoreCase("j_contact")) {
                        orderDO.setSenderPerson(attr.getValue());
                    }
                    if (attr.getName().equalsIgnoreCase("j_contact")) {
                        orderDO.setSenderPerson(attr.getValue());
                    }
                    if (attr.getName().equalsIgnoreCase("j_tel")) {
                        orderDO.setSenderPersonTel(attr.getValue());
                    }

                    if (attr.getName().equalsIgnoreCase("j_address")) {
                        orderDO.setSenderPersonAddress(attr.getValue());
                    }

                    if (attr.getName().equalsIgnoreCase("d_contact")) {
                        orderDO.setRecPerson(attr.getValue());
                    }

                    if (attr.getName().equalsIgnoreCase("d_tel")) {
                        orderDO.setRecPersonTel(attr.getValue());
                    }

                    if (attr.getName().equalsIgnoreCase("d_address")) {
                        orderDO.setRecPersonAddress(attr.getValue());
                    }

                    if (attr.getName().equalsIgnoreCase("pay_method")) {
                        orderDO.setPaymentMethod(Integer.valueOf(attr.getValue()));
                    }

                    if (attr.getName().equalsIgnoreCase("remark")) {
                        orderDO.setRemark(attr.getValue());
                    }

                    if (attr.getName().equalsIgnoreCase("sendstarttime")) {

                        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        Date formatDate = null;
                        try {
                            formatDate = dateFormat.parse(attr.getValue());
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        orderDO.setTakePartTime(formatDate);
                    }

                    orderDO.setCreateTime(new Date());

                    if (attr.getName().equalsIgnoreCase("express_type")) {
                        orderDO.setProductType(Integer.valueOf(attr.getValue()));
                    }

                    System.out.println("属性名：" + attr.getName() + "--属性值："
                            + attr.getValue());
                }
                Iterator itt = book.elementIterator();
                while (itt.hasNext()) {
                    Element bookChild = (Element) itt.next();
                    if (bookChild.getName().equalsIgnoreCase("Cargo")) {
                        List<Attribute> attributes = bookChild.attributes();
                        for (Attribute attr : attributes) {

                            System.out.println("属性名：" + attr.getName() + "--属性值："
                                    + attr.getValue());

                            //	'1'##物品类型"1","门店调货物品" "2","顾客调货物品" "3","退回总仓衣物""4","文件类物品""5","陈列品""6","物料物品"
                            if (attr.getName().equalsIgnoreCase("name")) {

                                if (attr.getValue().equalsIgnoreCase("门店调货物品")) {
                                    orderDO.setProductType(1);
                                }
                                if (attr.getValue().equalsIgnoreCase("顾客调货物品")) {
                                    orderDO.setProductType(2);
                                }
                                if (attr.getValue().equalsIgnoreCase("退回总仓衣物")) {
                                    orderDO.setProductType(3);
                                }
                                if (attr.getValue().equalsIgnoreCase("文件类物品")) {
                                    orderDO.setProductType(4);
                                }
                                if (attr.getValue().equalsIgnoreCase("陈列品")) {
                                    orderDO.setProductType(5);
                                }
                                if (attr.getValue().equalsIgnoreCase("物料物品")) {
                                    orderDO.setProductType(6);
                                }
                            }
                        }
                    }

                    if (bookChild.getName().equalsIgnoreCase("Extra")) {
                        List<Attribute> attributes = bookChild.attributes();
                        for (Attribute attr : attributes) {
                            if (attr.getName().equalsIgnoreCase("e1")) {
                                orderDO.setSenderStoreCode(attr.getValue());
                            }
                            if (attr.getName().equalsIgnoreCase("e2")) {
                                if (attr.getValue().equalsIgnoreCase("个人")) {
                                    orderDO.setRecStoreType(0);
                                }
                                if (attr.getValue().equalsIgnoreCase("卖场")) {
                                    orderDO.setRecStoreType(1);
                                }
                                if (attr.getValue().equalsIgnoreCase("公司")) {
                                    orderDO.setRecStoreType(2);
                                }
                            }
                        }
                    }
                    System.out.println("节点名：" + bookChild.getName() + "--节点值：" + bookChild.getStringValue());
                }
                orderDOS.add(orderDO);
//            System.out.println("=====结束遍历某一本书=====");
            }
            System.out.println(orderDOS);
            List<orderData> data = taskDao.queryOrderData();
            for (BasicHouseOrderDO orderDO : orderDOS) {
                data.forEach(r->{
                    if(r.getOrderNo().equalsIgnoreCase(String.valueOf(orderDO.getOrderNo()))){
                        orderDO.setMailno(r.getMailNo());
                    }
                });
            }

        System.out.println(orderDOS);
            orderDOS.forEach(u->{
                int saveOrderData = taskDao.saveOrderData(u);
                System.out.println(saveOrderData);
            });
        } catch (DocumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }


}
