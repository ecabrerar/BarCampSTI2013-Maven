package org.ecabrerar.barcampsti.combustible.mic;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentFactory;
import org.dom4j.io.SAXReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class CombustibleParser {

	Logger logger = LoggerFactory.getLogger(CombustibleParser.class);
	
	
	public Combustible parse(InputStream inputStream) throws Exception {
		
		Combustible combustible = new Combustible();
		
		 logger.debug("Creating XML Reader");
		 
		 SAXReader xmlReader = createXmlReader();
			Document doc = xmlReader.read(inputStream );

				
			logger.info( "Parsing XML Response" );

			combustible.setGasolinaPremium(doc.valueOf("/rss/channel/item/gas95"));
			combustible.setGasolinaRegular(doc.valueOf("/rss/channel/item/gas89"));
			combustible.setGasoilPremium(doc.valueOf("/rss/channel/item/gasoilp"));
			combustible.setGasoilRegular(doc.valueOf("/rss/channel/item/gasoilr"));
			combustible.setGlp(doc.valueOf("/rss/channel/item/glp"));
			combustible.setGnv(doc.valueOf("/rss/channel/item/gnv"));
			combustible.setKerosene(doc.valueOf("/rss/channel/item/kerosene"));
			
						
			
		return combustible;
		
	}
	
	private SAXReader createXmlReader() {
		Map<String,String> uris = new HashMap<String,String>();
        uris.put( "y", "http://www.seic.gov.do/rss/combustibles.aspx" );
        
        DocumentFactory factory = new DocumentFactory();
        factory.setXPathNamespaceURIs( uris );
        
		SAXReader xmlReader = new SAXReader();
		xmlReader.setDocumentFactory( factory );
		return xmlReader;
	}
}
