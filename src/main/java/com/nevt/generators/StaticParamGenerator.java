package com.nevt.generators;

import com.nevt.common.Envelope;
import com.nevt.common.Generator;
import com.nevt.data_models.StaticParam;
import org.springframework.stereotype.Component;

@Component
public class StaticParamGenerator extends RandomValueGeneratorAdaptor<StaticParam> implements Generator {
    @Override
    public Envelope generateOne(long dataStationId) {
        Envelope envelope = new Envelope();
        envelope.setDataStationId(1);
        StaticParam staticParam = super.generateCommon(StaticParam.class);
        System.out.println(staticParam);
        return envelope;
    }
}
