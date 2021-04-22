package com.nevt.generators;

import com.nevt.common.Envelope;
import com.nevt.common.Generator;
import com.nevt.data_models.HydrogenFactoryParam;
import org.springframework.stereotype.Component;

/**
 *
 */
@Component
public class HydrogenFactoryGenerator extends RandomValueGeneratorAdaptor<HydrogenFactoryParam> implements Generator {

    /**
     * Default constructor
     */
    public HydrogenFactoryGenerator() {
    }

    @Override
    public Envelope generateOne(long dataStationId) {
        Envelope en = new Envelope();
        en.setDataStationId(dataStationId);
        HydrogenFactoryParam hydrogenFactoryParam = generateCommon(HydrogenFactoryParam.class);
        System.out.println(hydrogenFactoryParam);
        return en;
    }


}