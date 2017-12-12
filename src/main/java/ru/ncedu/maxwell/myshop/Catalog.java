package ru.ncedu.maxwell.myshop;

import javax.xml.parsers.*;
import javax.xml.xpath.*;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.HashSet;

/**
 * Created by maxwell on 20.11.2017.
 */
public class Catalog {
    HashSet offers = new HashSet();
    private Document feed;
    private XPath xpath = XPathFactory.newInstance().newXPath();

    public Catalog() {

        try {
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            //feed = builder.parse("src/main/resources/feed.xml");
            feed = builder.parse("classes/feed.xml");
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            System.out.println("Market feed parse error!");
        }


    }

    public void showCatalog() {

        try {
            XPathExpression categories_expression = xpath.compile("//category");
            NodeList categories = (NodeList) categories_expression.evaluate(feed, XPathConstants.NODESET);
            for (int i = 0; i < categories.getLength(); i++) {
                NamedNodeMap attr = categories.item(i).getAttributes();
                int categoryId = Integer.parseInt(attr.getNamedItem("id").getTextContent());
                String categoryName = categories.item(i).getTextContent();
                System.out.println(categoryId + "  " + categoryName);
            }


        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }
    }

    public void showCategory(String id) {
        try {
            XPathExpression offers_expression = xpath.compile("//offer[categoryId=" + id + "]");

            NodeList offers = (NodeList) offers_expression.evaluate(feed, XPathConstants.NODESET);
            for (int i = 0; i < offers.getLength(); i++) {
                String offerId = "??";
                String name = "???";
                String price = "Товар недоступен";
                NamedNodeMap attributes = offers.item(i).getAttributes();
                offerId = attributes.getNamedItem("offerId").getTextContent();
                NodeList offer = offers.item(i).getChildNodes();
                for (int j = 0; j < offer.getLength(); j++) {
                    String name_item = offer.item(j).getNodeName();
                    switch (name_item) {
                        case "name":
                            name = offer.item(j).getTextContent();
                            break;//                }
                        case "price":
                            price = offer.item(j).getTextContent();
                            break;
                    }
                }
                System.out.println(offerId + "  " + name + "  --  " + "$" + price); //todo create Offer object

            }

        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }

    }

    Offer showOffer(String offerId) { //todo take from Array<Offer>
        String name = "???";
        String price = "???";
        String description = "???";
        Offer offer = null;
        try {
            XPathExpression offer_expression = xpath.compile("//offer[@offerId=" + offerId + "]/name");
            Node offer_name = (Node) offer_expression.evaluate(feed, XPathConstants.NODE);
            XPathExpression price_expression = xpath.compile("//offer[@offerId=" + offerId + "]/price");
            Node offer_price = (Node) price_expression.evaluate(feed, XPathConstants.NODE);
            XPathExpression description_expression = xpath.compile("//offer[@offerId=" + offerId + "]/description");
            Node offer_description = (Node) description_expression.evaluate(feed, XPathConstants.NODE);

            name = offer_name.getTextContent();
            price = offer_price.getTextContent();
            description = offer_description.getTextContent();
            offer = new Offer(offerId, name, price, description);
            System.out.println(name + " -- $" + price);
            System.out.println(description);


        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }

        return offer;
    }

}
