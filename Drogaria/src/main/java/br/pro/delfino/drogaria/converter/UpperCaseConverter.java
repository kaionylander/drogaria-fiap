package br.pro.delfino.drogaria.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

//@FacesConverter: Define que esta classe é um conversor
@FacesConverter("upperCaseConverter")
public class UpperCaseConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {

		value = (value == null) ? null : value.toUpperCase();

		return value;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value == null) {
			return "";
		} else {
			return value.toString();
		}
	}
}