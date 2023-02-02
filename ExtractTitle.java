import javax.xml.parsers.DocumentBuilderFactory;  
import javax.xml.parsers.DocumentBuilder;  
import org.w3c.dom.Document;  
import org.w3c.dom.NodeList;  
import org.w3c.dom.Node;  
import org.w3c.dom.Element;  
import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
public class ExtractTitle  
{  
public static void main(String argv[]){  
	ArrayList<String> Titles = new ArrayList<String>();
	String title;
	String urlTitle;
	int count = 0; 
	boolean addToList = true;
	String baseUrl = "https://eutils.ncbi.nlm.nih.gov/entrez/eutils/esearch.fcgi?db=pubmed&term=";
	String Url = "";
	InputStream stream = null;
	
	try{  
		//creating a constructor of file class and parsing an XML file  
		File file = new File("C:/Path/4020a1-datasets.xml");  
		//an instance of factory that gives a document builder  
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();  
		//an instance of builder to parse the specified xml file  
		DocumentBuilder db = dbf.newDocumentBuilder();  
		Document doc = db.parse(file);  
		doc.getDocumentElement().normalize();  
		System.out.println("Root element: " + doc.getDocumentElement().getNodeName());  
		NodeList nodeList = doc.getElementsByTagName("PubmedArticle");  
		// nodeList is not iterable, so we are using for loop  
		for (int itr = 0; itr < nodeList.getLength(); itr++){  
			Node node = nodeList.item(itr);  
			if (node.getNodeType() == Node.ELEMENT_NODE)   
			{  
				Element eElement = (Element) node;
				if(eElement.getElementsByTagName("ArticleTitle").item(0) != null) {
					title = eElement.getElementsByTagName("ArticleTitle").item(0).getTextContent().trim() ;
					//String me= eElement.getElementsByTagName("MedlinePgn").item(0).getTextContent();
					//if(me.equals("1201-3") || me.equals("951-3") || me.equals("183-4") || me.equals("1210-2")) {
						//System.out.println(eElement.getElementsByTagName("Title").item(0).getTextContent().trim());
					//}
					
					if(title.equals("Stimulation of both aerobic glycolysis and Na(+)-K(+)-ATPase activity in skeletal muscle by epinephrine or amylin.")) {
						//System.out.println(eElement.getElementsByTagName("Title").item(0).getTextContent().trim());
					}
					count+=1;
					for(String t:Titles) {
						
						if(t.equals(title)) {
							addToList = false;
							//System.out.println(t);
							break;
						}
						else{
							addToList = true;
							
						}
					}
					if(addToList) {
						urlTitle = title.replaceAll(" ","%20");
						Titles.add(urlTitle);
					}
					
				}
	
				

			} 
			
		}  
		
	}   
	catch (Exception e){  
		e.printStackTrace();  
	}  
	
	
	for(String t:Titles) {
		//if(t.equals("Cheung et al. Respond to \"Are Appearances Deceiving?\"")) {
			//System.out.println(t);
		//}
		//if(t.equals("Stimulation of both aerobic glycolysis and Na(+)-K(+)-ATPase activity in skeletal muscle by epinephrine or amylin.")) {
			//System.out.println(t);
		//}
		//
		//System.out.println(t);
	}
	
	
	//Url = "https://eutils.ncbi.nlm.nih.gov/entrez/eutils/esearch.fcgi?db=pubmed&term=%22Stimulation%20of%20both%20aerobic%20glycolysis%20and%20Na%28%2B%29-K%28%2B%29-ATPase%20activity%20in%20skeletal%20muscle%20by%20epinephrine%20or%20amylin.%22[Title:~0]";
	//System.out.println(count);
	/*
	for(String t:Titles) {
		try{    
			Url = baseUrl + t + "[Title:~0]";
			URL url=new URL(Url);    
			URLConnection urlcon=url.openConnection();    
			stream=urlcon.getInputStream();    
			stream.close();
			}catch(Exception e){System.out.println(e);}    
		
		try{  
			//creating a constructor of file class and parsing an XML file  
			//an instance of factory that gives a document builder  
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();  
			//an instance of builder to parse the specified xml file  
			DocumentBuilder db = dbf.newDocumentBuilder();  
			Document doc = db.parse(stream);  
			doc.getDocumentElement().normalize();  
			System.out.println("Root element: " + doc.getDocumentElement().getNodeName());  
			NodeList nodeList = doc.getElementsByTagName("IdList");  
			// nodeList is not iterable, so we are using for loop  
			for (int itr = 0; itr < nodeList.getLength(); itr++){  
				Node node = nodeList.item(itr);  
				if (node.getNodeType() == Node.ELEMENT_NODE)   
				{  
					Element eElement = (Element) node;
					if(eElement.getElementsByTagName("Id").item(0) != null) {
						title = eElement.getElementsByTagName("Id").item(0).getTextContent().trim() ;
						System.out.println(title);
						
					}

				} 
				
			}  
			
		}   
		catch (Exception e){  
			e.printStackTrace();  
		}  
	}*/
	try{    
		Url = "https://eutils.ncbi.nlm.nih.gov/entrez/eutils/esearch.fcgi?db=pubmed&term=%22Stimulation%20of%20both%20aerobic%20glycolysis%20and%20Na%28%2B%29-K%28%2B%29-ATPase%20activity%20in%20skeletal%20muscle%20by%20epinephrine%20or%20amylin.%22[Title:~0]";
		URL url=new URL(Url);    
		URLConnection urlcon=url.openConnection();    
		stream=urlcon.getInputStream();    
		}catch(Exception e){System.out.println(e);}    
	
	try{  
		//creating a constructor of file class and parsing an XML file  
		//an instance of factory that gives a document builder  
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();  
		//an instance of builder to parse the specified xml file  
		DocumentBuilder db = dbf.newDocumentBuilder();  
		Document doc = db.parse(stream);  
		doc.getDocumentElement().normalize();  
		System.out.println("Root element: " + doc.getDocumentElement().getNodeName());  
		NodeList nodeList = doc.getElementsByTagName("IdList");  
		// nodeList is not iterable, so we are using for loop  
		for (int itr = 0; itr < nodeList.getLength(); itr++){  
			Node node = nodeList.item(itr);  
			if (node.getNodeType() == Node.ELEMENT_NODE)   
			{  
				Element eElement = (Element) node;
				if(eElement.getElementsByTagName("Id").item(0) != null) {
					title = eElement.getElementsByTagName("Id").item(0).getTextContent().trim() ;
					System.out.println(title);
					
				}

			} 
			
		}  
		
	}   
	catch (Exception e){  
		e.printStackTrace();  
	}  
	
}  
}  