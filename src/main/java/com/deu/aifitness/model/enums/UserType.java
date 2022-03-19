package com.deu.aifitness.model.enums;

public enum UserType {
    USER("user"),
    ADMIN("admin"),
    TEACHER("T");

    public final String label;

    public String getLabel(){ return label; }

    private UserType(String label) {
        this.label = label;
    }
}
