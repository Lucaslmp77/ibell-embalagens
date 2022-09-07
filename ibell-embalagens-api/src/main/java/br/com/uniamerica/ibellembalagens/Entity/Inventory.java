package br.com.uniamerica.ibellembalagens.Entity;

public class Inventory extends AbstractEntity {
    private String name;
    private String code;
    private UnitMeasure unitMeasure;
    private float costValue;
    private float saleValue;
    private float theAmount;
    public String observation;

    public Inventory() {}

    public Inventory(String name, String code, UnitMeasure unitMeasure, float costValue, float saleValue, float theAmount) {
        this.name = name;
        this.code = code;
        this.unitMeasure = unitMeasure;
        this.costValue = costValue;
        this.saleValue = saleValue;
        this.theAmount = theAmount;
    }

    public Inventory(String name, String code, UnitMeasure unitMeasure, float costValue, float saleValue, float theAmount, String observation) {
        this.name = name;
        this.code = code;
        this.unitMeasure = unitMeasure;
        this.costValue = costValue;
        this.saleValue = saleValue;
        this.theAmount = theAmount;
        this.observation = observation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public UnitMeasure getUnitMeasure() {
        return unitMeasure;
    }

    public void setUnitMeasure(UnitMeasure unitMeasure) {
        this.unitMeasure = unitMeasure;
    }

    public float getCostValue() {
        return costValue;
    }

    public void setCostValue(float costValue) {
        this.costValue = costValue;
    }

    public float getSaleValue() {
        return saleValue;
    }

    public void setSaleValue(float saleValue) {
        this.saleValue = saleValue;
    }

    public float getTheAmount() {
        return theAmount;
    }

    public void setTheAmount(float theAmount) {
        this.theAmount = theAmount;
    }
}
