package com.company.saver;

import com.company.model.Student;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.List;

public class Saver {
    public void save(List<Student> students, String filePath) {
        try {
            // Получение фабрики, чтобы после получить билдер документов.
            DocumentBuilderFactory dBuilderFactory = DocumentBuilderFactory.newInstance();
            // Получили из фабрики билдер, который парсит XML, создает структуру Document в виде иерархического дерева.
            DocumentBuilder dBuilder = dBuilderFactory.newDocumentBuilder();
            Document doc = dBuilder.newDocument();

            Element rootElement = doc.createElement("Students");
            doc.appendChild(rootElement);

            for (Student student : students) {
                Element studentElement = doc.createElement("Student");
                rootElement.appendChild(studentElement);

                Element studName = doc.createElement("Name");
                studName.appendChild(doc.createTextNode(student.getName()));
                studentElement.appendChild(studName);

                Element group = doc.createElement("group");
                group.appendChild(doc.createTextNode(student.getGroup()));
                studentElement.appendChild(group);

                Element first = doc.createElement("firstTerm");
                first.appendChild(doc.createTextNode(String.valueOf(student.getFirstTerm())));
                studentElement.appendChild(first);

                Element second = doc.createElement("SecondTerm");
                second.appendChild(doc.createTextNode(String.valueOf(student.getSecondTerm())));
                studentElement.appendChild(second);

                Element three = doc.createElement("thirdTerm");
                three.appendChild(doc.createTextNode(String.valueOf(student.getThirdTerm())));
                studentElement.appendChild(three);

                Element fourth = doc.createElement("fourthTerm");
                fourth.appendChild(doc.createTextNode(String.valueOf(student.getFourthTerm())));
                studentElement.appendChild(fourth);

                Element five = doc.createElement("fifthTerm");
                five.appendChild(doc.createTextNode(String.valueOf(student.getFiveTerm())));
                studentElement.appendChild(five);

                Element six = doc.createElement("sixthTerm");
                six.appendChild(doc.createTextNode(String.valueOf(student.getSixthTerm())));
                studentElement.appendChild(six);

                Element seven = doc.createElement("seventhTerm");
                seven.appendChild(doc.createTextNode(String.valueOf(student.getFiveTerm())));
                studentElement.appendChild(seven);

                Element eigth = doc.createElement("eighthTerm");
                eigth.appendChild(doc.createTextNode(String.valueOf(student.getEighthTerm())));
                studentElement.appendChild(eigth);

                Element nine = doc.createElement("ninthTerm");
                nine.appendChild(doc.createTextNode(String.valueOf(student.getNinthTerm())));
                studentElement.appendChild(nine);

                Element ten = doc.createElement("tenthTerm");
                ten.appendChild(doc.createTextNode(String.valueOf(student.getTenthTerm())));
                studentElement.appendChild(ten);


            }
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(filePath));
            transformer.transform(source, result);
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
}
