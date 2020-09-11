package com.priyanka.archunitexample.customAnnotation;

public class TestAnnotation {

    @MyAnnotation
    String field1;

    String field2;

    @Secured
    public String getField1() {
        return field1;
    }

    @Secured
    public void setField1(String field1) {
        this.field1 = field1;
    }

    public String getField2() {
        return field2;
    }

    public void setField2(String field2) {
        this.field2 = field2;
    }
}
