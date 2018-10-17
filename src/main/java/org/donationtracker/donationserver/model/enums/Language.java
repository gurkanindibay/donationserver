package org.donationtracker.donationserver.model.enums;

import java.util.Locale;

public enum Language implements BaseEnum {

  ENGLISH("en", Locale.ENGLISH),

  TURKISH("tr", Locale.forLanguageTag("tr"));

  private final String key;

  private final Locale locale;

  Language(String key, Locale locale) {
    this.key = key;
    this.locale = locale;
  }

  public String getKey() {
    return key;
  }

  public static Language getByCode(String code) {
    for (Language language : Language.values()) {
      if (language.getLocale().getLanguage().equalsIgnoreCase(code)
          || language.getLocale().getDisplayName(Locale.ENGLISH).equalsIgnoreCase(code)) {
        return language;
      }
    }
    return null;
  }

  public Locale getLocale() {
    return locale;
  }
  
  public String getAsLocal(){
	  if (this == Language.ENGLISH){
		  return "English";
	  } else {
		  return "Türkçe";
	  }
  }

@Override
public String getValue() {
	// TODO Auto-generated method stub
	return getAsLocal();
}
  
}