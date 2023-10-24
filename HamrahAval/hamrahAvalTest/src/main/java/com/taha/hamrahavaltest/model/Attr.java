package com.taha.hamrahavaltest.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Attr {
    @JacksonXmlProperty(isAttribute = true, localName = "name")
    private String name;

    @JacksonXmlText
    private String value;

}

