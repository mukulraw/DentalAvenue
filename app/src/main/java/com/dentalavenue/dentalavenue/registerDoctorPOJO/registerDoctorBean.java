package com.dentalavenue.dentalavenue.registerDoctorPOJO;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class registerDoctorBean {

    @SerializedName("register_doctor")
    @Expose
    private List<RegisterDoctor> registerDoctor = null;

    public List<RegisterDoctor> getRegisterDoctor() {
        return registerDoctor;
    }

    public void setRegisterDoctor(List<RegisterDoctor> registerDoctor) {
        this.registerDoctor = registerDoctor;
    }

}
