package com.example.opd.ui.Calculator;

public class CalcFragmentToOneValuesData {
    String mainText;
    String leftText;
    String units;

    public CalcFragmentToOneValuesData(String mainText, String leftText, String units) {
        this.mainText = mainText;
        this.leftText = leftText;
        this.units = units;
    }

    public void setMainText(String mainText) {
        this.mainText = mainText;
    }

    public void setLeftText(String leftText) {
        this.leftText = leftText;
    }

    public void setUnits(String units) {
        this.units = units;
    }

    public String getMainText() {
        return mainText;
    }

    public String getLeftText() {
        return leftText;
    }

    public String getUnits() {
        return units;
    }
}
