package com.mirror.alogeda.commons.infra;

import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.remoting.support.SimpleHttpServerFactoryBean;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;
import com.mirror.alogeda.commons.exceptions.DomainException;

@Configuration
public class JacksonSpringConfig {
    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
    public ObjectMapper objectMapper(){
		ObjectMapper mapper = new ObjectMapper();
		mapper.registerModule(new Hibernate5Module());
		mapper.setDateFormat(new SimpleDateFormat("dd/MM/yyyy"));

		return mapper;
    }

    public DateFormat getDateFormatte() {
    	return new DateFormat() {
    	    static final String FORMAT1 = "dd/MM/yyyy hh:mm:ss";
    	    static final String FORMAT2 = "dd/MM/yyyy";
        	final SimpleDateFormat sdf1 = new SimpleDateFormat(FORMAT1);
    	    final SimpleDateFormat sdf2 = new SimpleDateFormat(FORMAT2);

    	    @Override
    	    public StringBuffer format(Date date, StringBuffer toAppendTo, FieldPosition fieldPosition) {
    	            return sdf1.format(date, toAppendTo, fieldPosition);
    	    }

    	    @Override
    	    public Date parse(String source, ParsePosition pos) {
    	        if (source.length() - pos.getIndex() == FORMAT1.length())
    	            return sdf1.parse(source, pos);
    	        return sdf2.parse(source, pos);
    	    }
    	};
    }
    
}
