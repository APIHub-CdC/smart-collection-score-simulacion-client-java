package io.SmartCollectionScoreSimulacion.client.model;

import java.io.IOException;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
@JsonAdapter(CatalogoTipoContrato.Adapter.class)
public enum CatalogoTipoContrato {
  
  TC("TC"),
  
  TD("TD"),
  
  CC("CC"),
  
  HB("HB"),
  
  LC("LC");
  private String value;
  CatalogoTipoContrato(String value) {
    this.value = value;
  }
  public String getValue() {
    return value;
  }
  @Override
  public String toString() {
    return String.valueOf(value);
  }
  public static CatalogoTipoContrato fromValue(String text) {
    for (CatalogoTipoContrato b : CatalogoTipoContrato.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    return null;
  }
  public static class Adapter extends TypeAdapter<CatalogoTipoContrato> {
    @Override
    public void write(final JsonWriter jsonWriter, final CatalogoTipoContrato enumeration) throws IOException {
      jsonWriter.value(enumeration.getValue());
    }
    @Override
    public CatalogoTipoContrato read(final JsonReader jsonReader) throws IOException {
      String value = jsonReader.nextString();
      return CatalogoTipoContrato.fromValue(String.valueOf(value));
    }
  }
}