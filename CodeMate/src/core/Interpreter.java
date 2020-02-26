package core;
import java.awt.Desktop;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import data.FileData;
import data.MethodData;
import data.MetricData;
import data.TypeData;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

/**
 * Interpreter outputs the processed data into an XML file and a console report.
 * @author Robert Toy
 * 		   Angus Walsh
 *
 */
public class Interpreter 
{
	/**
	 * Variables
	 */
	private List<FileData> fileData;

	/**
	 * Accessors
	 */
	public List<FileData> getFileData(){return fileData;}

	/**
	 * Mutators
	 */
	public void setFileData(List<FileData> fileDataList){this.fileData = fileDataList;}
	
	/**
	 * checkXSL checks if a style sheet exists, if not it creates one.
	 */
	private void checkXSL() {
		File f = new File("/stylesheet/stylesheet.xsl");
		if(f.exists() && !f.isDirectory()) { 
		    //Stylesheet already exists
		} else {
			//Create new stylesheet
			
			System.getProperty("user.dir");
			Path currentRelativePath = Paths.get("");
			new File(currentRelativePath.toAbsolutePath().toString()+"/stylesheet").mkdir();
			try (Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("stylesheet/stylesheet.xsl"), "utf-8"))) {
				writer.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n" + 
						"\r\n" + 
						"<xsl:stylesheet version=\"1.0\"\r\n" + 
						"xmlns:xsl=\"http://www.w3.org/1999/XSL/Transform\">\r\n" + 
						"\r\n" + 
						"<xsl:template match=\"/\">\r\n" + 
						"  <html>\r\n" + 
						"  <head>\r\n" + 
						"  <style>\r\n" + 
						"  h1 {\r\n" + 
						"	color: black;\r\n" + 
						"  }\r\n" + 
						"  </style>\r\n" + 
						"  </head>\r\n" + 
						"  <body>\r\n" + 
						"  <h1 style=\"color:blue\">CodeMate Report</h1>\r\n" + 
						"  \r\n" + 
						"  \r\n" + 
						"  <xsl:for-each select=\"Report/Files/File\">\r\n" + 
						"	<h1 style=\"color:red\"><xsl:value-of select=\"Name\"/></h1>\r\n" + 
						"	<h2 style=\"color:green\">File Metrics:</h2>\r\n" + 
						"	<xsl:for-each select=\"Metrics/Metric\">\r\n" + 
						"		<b>Metric: </b> <xsl:value-of select=\"Name\"/><br/>\r\n" + 
						"		<b>-Value: </b> <xsl:value-of select=\"Value\"/><br/>\r\n" + 
						"		<xsl:if test=\"Recommendation\">\r\n" + 
						"			<b>--Recommendation: </b> <xsl:value-of select=\"Recommendation\"/><br/>\r\n" + 
						"		</xsl:if>\r\n" + 
						"	</xsl:for-each>\r\n" + 
						"  <h2 style=\"color:green\">Type/Method metrics:</h2>\r\n" + 
						"  <xsl:for-each select=\"Types/Type\">	\r\n" + 
						"	<h2 style=\"color:DarkOrange\"><xsl:value-of select=\"TypeType\"/>:</h2>\r\n" + 
						"  	<h3 ><xsl:value-of select=\"TypeName\"/></h3>\r\n" + 
						"  	<xsl:for-each select=\"Metrics/Metric\">\r\n" + 
						"		<b>Metric: </b> <xsl:value-of select=\"Name\"/><br/>\r\n" + 
						"		<b>-Value: </b> <xsl:value-of select=\"Value\"/><br/>\r\n" + 
						"		<xsl:if test=\"Recommendation\">\r\n" + 
						"			<b>--Recommendation: </b> <xsl:value-of select=\"Recommendation\"/><br/>\r\n" + 
						"		</xsl:if>\r\n" + 
						"	</xsl:for-each>\r\n" + 
						"  	\r\n" + 
						"	<h3 style=\"color:Orange\">Methods:</h3>\r\n" + 
						"	  <xsl:for-each select=\"Methods/Method\">		\r\n" + 
						"			<h4><xsl:value-of select=\"MethodName\"/></h4>\r\n" + 
						"			<xsl:for-each select=\"Metrics/Metric\">\r\n" + 
						"				<b>Metric: </b> <xsl:value-of select=\"Name\"/><br/>\r\n" + 
						"				<b>-Value: </b> <xsl:value-of select=\"Value\"/><br/>\r\n" + 
						"				<xsl:if test=\"Recommendation\">\r\n" + 
						"					<b>--Recommendation: </b> <xsl:value-of select=\"Recommendation\"/><br/>\r\n" + 
						"				</xsl:if>\r\n" + 
						"			</xsl:for-each>\r\n" + 
						"		</xsl:for-each>\r\n" + 
						"	  </xsl:for-each>\r\n" + 
						"    </xsl:for-each>\r\n" + 
						"  </body>\r\n" + 
						"  </html>\r\n" + 
						"</xsl:template>\r\n" + 
						"\r\n" + 
						"</xsl:stylesheet>");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * report creates an xml that stores all the results of the calculations.
	 * @return String
	 */
	public String report()
	{
		File f = new File("/reports");
		if(f.exists() && f.isDirectory()) { 
		    //Stylesheet already exists
		} else {
			System.getProperty("user.dir");
			Path currentRelativePath = Paths.get("");
			new File(currentRelativePath.toAbsolutePath().toString()+"/reports").mkdir();
		}
		checkXSL();
		try {
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			// root elements
			Document doc = docBuilder.newDocument();
			Element rootElement = doc.createElement("Report");
			doc.appendChild(rootElement);
			//stylesheet
			Node pi = doc.createProcessingInstruction("xml-stylesheet","type=\"text/xsl\" href=\"../stylesheet/stylesheet.xsl\"");
			doc.insertBefore(pi, rootElement);
			
			// Metrics per file
			Element files = doc.createElement("Files");
			rootElement.appendChild(files);
				
		for (FileData fd: fileData) {
			Element file = doc.createElement("File");
			files.appendChild(file);
			
			Element name = doc.createElement("Name");
			name.appendChild(doc.createTextNode(fd.getName()));
			file.appendChild(name);
			
			Element metrics = doc.createElement("Metrics");
			file.appendChild(metrics);
						
			// Loop over all metrics per file
			for (MetricData m : fd.getMetrics().values()){
				//XML
				Element metric = doc.createElement("Metric");
				metrics.appendChild(metric);
				
				Element mName = doc.createElement("Name");
				mName.appendChild(doc.createTextNode(m.getName()));
				metric.appendChild(mName);
				
				Element value = doc.createElement("Value");
				value.appendChild(doc.createTextNode(Float.toString(m.getValue())));
				metric.appendChild(value);
				
				if(m.getRecommendation() != null) {
					Element recommendation = doc.createElement("Recommendation");
					recommendation.appendChild(doc.createTextNode(m.getRecommendation()));
					metric.appendChild(recommendation);
				}
				
			}
			
			Element types = doc.createElement("Types");
			file.appendChild(types);
			// Loop over all methods per file
			for (TypeData cd: fd.getTypes()) {
				
				Element type = doc.createElement("Type");
				types.appendChild(type);
				
				Element typeType = doc.createElement("TypeType");
				typeType.appendChild(doc.createTextNode(cd.getTypeType()));
				type.appendChild(typeType);
				
				Element typeName = doc.createElement("TypeName");
				typeName.appendChild(doc.createTextNode(cd.getName()));
				type.appendChild(typeName);
				
				Element typeMetrics = doc.createElement("Metrics");
				type.appendChild(typeMetrics);
				
				// Loop over all metrics per Type per file
				for (MetricData m : cd.getMetrics().values()) {
					Element typeMetric = doc.createElement("Metric");
					typeMetrics.appendChild(typeMetric);
					
					Element mName = doc.createElement("Name");
					mName.appendChild(doc.createTextNode(m.getName()));
					typeMetric.appendChild(mName);
					
					Element value = doc.createElement("Value");
					value.appendChild(doc.createTextNode(Float.toString(m.getValue())));
					typeMetric.appendChild(value);
					
					if(m.getRecommendation() != null) {
						Element recommendation = doc.createElement("Recommendation");
						recommendation.appendChild(doc.createTextNode(m.getRecommendation()));
						typeMetric.appendChild(recommendation);
					}													
				}
				
				Element methods = doc.createElement("Methods");
				type.appendChild(methods);				
				
				for (MethodData md : cd.getMethods()) {
					Element method = doc.createElement("Method");
					methods.appendChild(method);
					
					Element methodName = doc.createElement("MethodName");
					methodName.appendChild(doc.createTextNode(md.getName()));
					method.appendChild(methodName);
					
					Element methodMetrics = doc.createElement("Metrics");
					method.appendChild(methodMetrics);
					
					// Loop over all metrics per method per file
					for (MetricData m : md.getMetrics().values()) {
						Element methodMetric = doc.createElement("Metric");
						methodMetrics.appendChild(methodMetric);
						
						Element mName = doc.createElement("Name");
						mName.appendChild(doc.createTextNode(m.getName()));
						methodMetric.appendChild(mName);
						
						Element value = doc.createElement("Value");
						value.appendChild(doc.createTextNode(Float.toString(m.getValue())));
						methodMetric.appendChild(value);
						
						if(m.getRecommendation() != null) {
							Element recommendation = doc.createElement("Recommendation");
							recommendation.appendChild(doc.createTextNode(m.getRecommendation()));
							methodMetric.appendChild(recommendation);
						}						
					}
				}
			}			
		}
		
		//write the content into XML file
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
		DOMSource source = new DOMSource(doc);
		//time stamp for reports
		String timeStamp = new SimpleDateFormat("yyyy-MM-dd--HH-mm-ss'.txt'").format(new Date());
		StreamResult result = new StreamResult(new File("reports/"+timeStamp+"_report.xml"));			
		transformer.transform(source, result);
		System.out.println("File saved!");
		File htmlFile = new File("reports/"+timeStamp+"_report.xml");
		try {
			Desktop.getDesktop().browse(htmlFile.toURI());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	} catch (ParserConfigurationException pce) {
		pce.printStackTrace();
	} catch (TransformerException tfe) {
		tfe.printStackTrace();
	}
		return consoleReport();
	}
	
	/**
	 * consoleReport creates an console output of the results
	 * @return
	 */
	public String consoleReport() {
		String out = "\n";
		for(FileData fd: fileData) {
			//console print
			String filler = "";
			for (int i = 0; i < fd.getName().toCharArray().length; i++) {
				filler += "-";
			}

			out += "\n|-" + filler + "-|\n";
			out += "| " + fd.getName() + " |\n";
			out += "|-" + filler + "-|\n\n";
			out += "|- File Metrics: " + "\n";
			
			// Loop over all metrics per file
			for (MetricData m : fd.getMetrics().values()){
				out += "   " + m.getName() + ": " + m.getValue() + "\n";
				if (m.getRecommendation() != null) {
					out += "   - " + m.getName() + " recommendation: " + m.getRecommendation() + "\n";
				}
			}			

			// Loop over all types per file
			for (TypeData td: fd.getTypes()) {
				out += "\n|-- " + td.getTypeType() + ": " + td.getName() + " (line " + td.getLineNumer() + ")\n";				

				// Loop over all metrics per type
				for (MetricData m : td.getMetrics().values()){
					out += "    " + m.getName() + ": " + m.getValue() + "\n";
					if (m.getRecommendation() != null) {
						out += "    - " + m.getName() + " recommendation: " + m.getRecommendation() + "\n";
					}	
				}
				
				// Loop over all methods per type
				for (MethodData md : td.getMethods()) {
					out += "\n|--- Method: " + md.getName() + " (line " + md.getLineNumer() + ")\n";
					
					// Loop over all metrics per type
					for (MetricData m : md.getMetrics().values()) {
						out += "     " + m.getName() + ": " + m.getValue() + "\n";
						if(m.getRecommendation() != null) {
							out += "     - " + m.getName() + " recommendation: " + m.getRecommendation() + "\n";
						}								
					}
				}
			}			
		}	
		return out;
	}
}
