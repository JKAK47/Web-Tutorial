package org.vincent.domain;

import lombok.Data;
import lombok.ToString;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author PengRong
 * @package org.vincent.domain
 * @ClassName Detail.java
 * @date 2019/6/18 - 7:32
 * @ProjectName Web-Tutorial
 * @Description: TODO
 */
@Data
@ToString
@XmlRootElement(name = "detail")
@XmlAccessorType(XmlAccessType.FIELD)
public class Detail {
    @XmlElement(required = true)
    private String isbn;
    @XmlElement(required = true)
    private String publisherDate;


}
