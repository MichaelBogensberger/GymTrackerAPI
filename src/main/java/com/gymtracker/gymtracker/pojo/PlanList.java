package com.gymtracker.gymtracker.pojo;


public class PlanList {

    private Integer plan_id;
    private String type;
    private Integer type_order;

    public PlanList(Integer plan_id, String type, Integer type_order) {
        this.plan_id = plan_id;
        this.type = type;
        this.type_order = type_order;
    }

    public PlanList() {
    }

    public Integer getPlan_id() {
        return plan_id;
    }

    public void setPlan_id(Integer plan_id) {
        this.plan_id = plan_id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getType_order() {
        return type_order;
    }

    public void setType_order(Integer type_order) {
        this.type_order = type_order;
    }
}
