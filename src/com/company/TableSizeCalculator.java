package com.company;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class TableSizeCalculator {
    public static void main(String[] args) {

        File dir = new File("C:\\Users\\kumara2\\Desktop\\Mib2test\\Akshay"); //Directory where your file exists

        File[] files = dir.listFiles();

        for (File file : files) {
            if (file.isFile() && file.getName().endsWith(".xml")) { //You can validate file name with extension if needed
                System.out.println("----------------------------");
                System.out.println(file.getName());
                ProcessFile(file);
            }
        }

    }

    private static void ProcessFile(File xmlFile) {
        try {

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);

            doc.getDocumentElement().normalize();

            NodeList nList = doc.getElementsByTagName("Column");

            int sum = 0;
            for (int temp = 0; temp < nList.getLength(); temp++) {


                Node nNode = nList.item(temp);
                if (nNode.getNodeType()
                        == Node.ELEMENT_NODE) {
                    Element tElement = (Element) nNode;

                    sum = sum + Integer.parseInt(tElement
                            .getElementsByTagName("Size")
                            .item(0)
                            .getTextContent());
                }


            }
            System.out.println("Size =" + sum);
            System.out.println("----------------------------");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}