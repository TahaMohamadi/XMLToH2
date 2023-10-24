package com.taha.hamrahavaltest.Service;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.taha.hamrahavaltest.entity.AttrEntity;
import com.taha.hamrahavaltest.entity.MOEntity;
import com.taha.hamrahavaltest.entity.MOTreeEntity;
import com.taha.hamrahavaltest.model.Attr;
import com.taha.hamrahavaltest.model.MO;
import com.taha.hamrahavaltest.model.MOTree;
import com.taha.hamrahavaltest.repository.MOTreeRepo;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class XmlToObjectParserService {
    private final MOTreeRepo moTreeRepo;

    public XmlToObjectParserService(MOTreeRepo moTreeRepo) {
        this.moTreeRepo = moTreeRepo;
    }

    public MOTree parseXML(File xmlFile) throws IOException {
        XmlMapper xmlMapper = new XmlMapper();
        return xmlMapper.readValue(xmlFile, MOTree.class);

    }

    public MOTreeEntity mapToEntity(MOTree moTree){
        List<MOEntity> moEntities = new ArrayList<>();
        for (MO mo : moTree.getMoList()
                ) {
            List<AttrEntity> attrEntityList = new ArrayList<>();
            for (Attr attr : mo.getAttrs()
                    ) {
                AttrEntity attrEntity = AttrEntity.builder()
                        .name(attr.getName())
                        .attrValue(attr.getValue())
                        .build();
                attrEntityList.add(attrEntity);
            }
            MOEntity moEntity = MOEntity.builder()
                    .fdn(mo.getFdn())
                    .className(mo.getClassName())
                    .attrs(attrEntityList).build();
            moEntities.add(moEntity);
        }
        MOTreeEntity moTreeEntity = MOTreeEntity.builder()
                .moList(moEntities)
                .build();

        return moTreeEntity;
    }
    public MOTreeEntity saveToDb(MOTreeEntity moTreeEntity){
        return moTreeRepo.save(moTreeEntity);
    }
}