package com.kipcollo.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import com.kipcollo.interfaces.Pen;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class Writer {

    private Pen pen;

    @Autowired
    public Writer(Pen pen) {
        this.pen = pen;
    }

    public void write() {
        pen.write();
    }
    

}
