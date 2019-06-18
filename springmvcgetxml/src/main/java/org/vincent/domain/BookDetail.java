package org.vincent.domain;



import lombok.Data;
import lombok.ToString;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@Data
@ToString
// @XmlRootElement表示XML文档的根元素
@XmlRootElement(name = "bookDetail")
@XmlAccessorType(XmlAccessType.FIELD)
public class BookDetail implements Serializable {
    @XmlElement(required = true)
    private Integer id;
    @XmlElement(required = true)
    private String name;
    @XmlElement(required = true)
    private String author;
    @XmlElement(required = true)
    private Detail detail;
}
