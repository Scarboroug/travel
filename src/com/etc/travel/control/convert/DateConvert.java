package com.etc.travel.control.convert;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;
import org.springframework.format.support.FormattingConversionService;
import org.springframework.format.support.FormattingConversionServiceFactoryBean;

public class DateConvert implements Converter<String,Date>{
	@Override
	public Date convert(String time) {
		Date date = null;
		if(time!=null){
			SimpleDateFormat  sdf = new SimpleDateFormat("yyyy-MM-dd");
			try {
				date = sdf.parse(time);
			} catch (ParseException e) {
				sdf = new SimpleDateFormat("yyyy/MM/dd");
				try {
					date = sdf.parse(time);
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
			}
		}
		return date;
	}

}
