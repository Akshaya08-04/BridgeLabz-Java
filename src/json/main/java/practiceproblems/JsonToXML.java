package json.practiceproblems;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class JsonToXML {

    public static void main(String[] args) throws Exception {

        ObjectMapper jsonMapper = new ObjectMapper();
        XmlMapper xmlMapper = new XmlMapper();

        String json = "{\"name\":\"Akshaya\",\"age\":22}";

        System.out.println(
                xmlMapper.writeValueAsString(jsonMapper.readTree(json))
        );
    }
}
