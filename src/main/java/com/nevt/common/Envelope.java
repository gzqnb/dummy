package com.nevt.common;

import lombok.Data;

import java.io.Serializable;
import java.util.*;

/**
 *
 */
@Data
public class Envelope {

    long dataStationId;
    long deviceTypeId;
    int deviceIndex;
    long paramTypeId;

    Date cTime;
    Date uTime;
    Object content;
}