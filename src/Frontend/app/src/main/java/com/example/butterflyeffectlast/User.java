package com.example.butterflyeffectlast;

import java.io.Serializable;

public class User implements Serializable {
 protected String form;

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    public User(String form) {
        this.form = form;
    }
}