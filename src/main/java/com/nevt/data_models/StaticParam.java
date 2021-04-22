package com.nevt.data_models;

import java.util.*;

import lombok.Data;

/**
 *
 */

@Data
public class StaticParam {

    private float vehMass;//整车质量
    private float vehFrontArea ;//迎风面积
    private float vehAirRestCoeff;//风阻系数
    private float vehFricCoeff;//滚动摩擦系数
    private float vehTireRadius;//轮胎半径
    private float vehTransRatio;//电机到轮胎的传动比（变速箱和减速器传动比）
    private short vehBotlTotal;//气瓶数量
    private int[] vehBotlVolm;//气瓶体积
    private String[] vehBotlSpec;//气瓶规格
    private float vehLiBatCapa;//锂离子动力电池容量（Ah）
    private float vehLiBatWork;//锂离子动力电池能量（kWh）
    private float vehFCDCDCPeakPower;//燃料电池DCDC峰值功率
    private float vehFCStackPeakPower;//燃料电池电堆峰值功率
    private float vehMotRatedPower;//电机额定/峰值功率
    private float vehMotPeakPower;//电机峰值功率
    private float vehFCStackCellTotal;//燃料电池电堆单体数量
    private float vehFCCellEffeArea;//燃料电池单体有效面积

}