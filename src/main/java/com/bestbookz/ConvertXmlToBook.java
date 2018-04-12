package com.bestbookz;

import java.io.StringReader;
import java.util.logging.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class ConvertXmlToBook {
	
	private static Logger LOGGER = Logger.getLogger(ConvertXmlToBook.class.getSimpleName());

	public static Book convertToBook(String xmlRequest) {
		LOGGER.info("xml to transform: " + xmlRequest);
		Book book = null;
        //String xmlVersion = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>";        
        //String fullXml = xmlVersion.concat(xmlRequest);
        
        JAXBContext jaxbContext;
		try {
			jaxbContext = JAXBContext.newInstance(Book.class);
			 Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			 book = (Book)unmarshaller.unmarshal(new StringReader(xmlRequest));
			 LOGGER.info("converted book to string: " + book.toString());
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}        
    	return book;
	}
}
