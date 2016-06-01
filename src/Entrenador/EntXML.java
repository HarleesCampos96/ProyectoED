/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entrenador;


import BaseDatos.DataBase;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
//import org.jdom2.*;

/**
 *
 * @author alexcampos
 */
public class EntXML {
    
    public EntXML() throws ParserConfigurationException, SQLException, ClassNotFoundException, TransformerConfigurationException, TransformerException{
        DataBase data=new DataBase();
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder=docFactory.newDocumentBuilder();
        
        Document doc = (Document) docBuilder.newDocument();
        Element rootElement = doc.createElement("Entrenadores");
        doc.appendChild(rootElement);
        
        ResultSet rs=data.ejecutaQuery("SELECT * FROM entrenador;");
        
        while(rs.next()){
            
            Element entrena = doc.createElement("Entrenador");
            rootElement.appendChild(entrena);
            
            Attr attr = doc.createAttribute("dni");
            attr.setValue(rs.getString(1));
            entrena.setAttributeNode(attr);
            
            Element nombre = doc.createElement("Nombre");
            nombre.appendChild(doc.createTextNode(rs.getString(2)));
            entrena.appendChild(nombre);
            
            Element apellido= doc.createElement("Apellido");
            apellido.appendChild(doc.createTextNode(rs.getString(3)));
            entrena.appendChild(apellido);
            
            Element sueldo=doc.createElement("Sueldo");
            sueldo.appendChild(doc.createTextNode(String.valueOf(rs.getInt(4))));
            entrena.appendChild(sueldo);
            
            Element edad=doc.createElement("Edad");
            edad.appendChild(doc.createTextNode(String.valueOf(rs.getString(5))));
            entrena.appendChild(edad);
        }
        
        TransformerFactory trans= TransformerFactory.newInstance();
        Transformer transformer = trans.newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File("archivo.xml"));
        
        transformer.transform(source, result);
        
        
        
    }
    
}
