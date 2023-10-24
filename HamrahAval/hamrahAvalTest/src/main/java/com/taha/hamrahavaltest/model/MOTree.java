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
public class MOTree {
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "MO")
    private List<MO> moList;
}
