package com.taha.hamrahavaltest.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class MO {
    @JacksonXmlProperty(isAttribute = true)
    private String className;

    @JacksonXmlProperty(isAttribute = true)
    private String fdn;

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "Attr")
    private List<Attr> attrs;
}





