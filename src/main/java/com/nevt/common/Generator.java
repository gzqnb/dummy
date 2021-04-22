package com.nevt.common;

public interface Generator {

//     * @param deviceTypeId 设备类型ID，设备类型为“加氢站电解槽“、“加氢站储气罐”等
//     * @param deviceIndex 设备序号，例如某加氢站有3个电解槽，第2个电解槽的数据改参数值为：2
//     * @param paramTypeId 参数类型ID，参数类型为“加氢站电解槽电流”、“加氢站储气罐压力”等

    /**
     * @param dataStationId 数据源ID，数据源为某个加氢站、某个氢燃料车等
     * @return Envelop
     */
    public Envelope generateOne(long dataStationId);
}
