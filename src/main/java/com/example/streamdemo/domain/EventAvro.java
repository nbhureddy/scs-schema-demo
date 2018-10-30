package com.example.streamdemo.domain;

/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
import org.apache.avro.specific.SpecificData;

@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class EventAvro extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 9147556348843564574L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"EventAvro\",\"namespace\":\"com.example.streamdemo.domain\",\"fields\":[{\"name\":\"name\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"description\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"version\",\"type\":\"int\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
  @Deprecated public java.lang.String name;
  @Deprecated public java.lang.String description;
  @Deprecated public int version;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public EventAvro() {}

  /**
   * All-args constructor.
   * @param name The new value for name
   * @param description The new value for description
   * @param version The new value for version
   */
  public EventAvro(java.lang.String name, java.lang.String description, java.lang.Integer version) {
    this.name = name;
    this.description = description;
    this.version = version;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
      case 0: return name;
      case 1: return description;
      case 2: return version;
      default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
      case 0: name = (java.lang.String)value$; break;
      case 1: description = (java.lang.String)value$; break;
      case 2: version = (java.lang.Integer)value$; break;
      default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'name' field.
   * @return The value of the 'name' field.
   */
  public java.lang.String getName() {
    return name;
  }

  /**
   * Sets the value of the 'name' field.
   * @param value the value to set.
   */
  public void setName(java.lang.String value) {
    this.name = value;
  }

  /**
   * Gets the value of the 'description' field.
   * @return The value of the 'description' field.
   */
  public java.lang.String getDescription() {
    return description;
  }

  /**
   * Sets the value of the 'description' field.
   * @param value the value to set.
   */
  public void setDescription(java.lang.String value) {
    this.description = value;
  }

  /**
   * Gets the value of the 'version' field.
   * @return The value of the 'version' field.
   */
  public java.lang.Integer getVersion() {
    return version;
  }

  /**
   * Sets the value of the 'version' field.
   * @param value the value to set.
   */
  public void setVersion(java.lang.Integer value) {
    this.version = value;
  }

  /**
   * Creates a new EventAvro RecordBuilder.
   * @return A new EventAvro RecordBuilder
   */
  public static com.example.streamdemo.domain.EventAvro.Builder newBuilder() {
    return new com.example.streamdemo.domain.EventAvro.Builder();
  }

  /**
   * Creates a new EventAvro RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new EventAvro RecordBuilder
   */
  public static com.example.streamdemo.domain.EventAvro.Builder newBuilder(com.example.streamdemo.domain.EventAvro.Builder other) {
    return new com.example.streamdemo.domain.EventAvro.Builder(other);
  }

  /**
   * Creates a new EventAvro RecordBuilder by copying an existing EventAvro instance.
   * @param other The existing instance to copy.
   * @return A new EventAvro RecordBuilder
   */
  public static com.example.streamdemo.domain.EventAvro.Builder newBuilder(com.example.streamdemo.domain.EventAvro other) {
    return new com.example.streamdemo.domain.EventAvro.Builder(other);
  }

  /**
   * RecordBuilder for EventAvro instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<EventAvro>
      implements org.apache.avro.data.RecordBuilder<EventAvro> {

    private java.lang.String name;
    private java.lang.String description;
    private int version;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(com.example.streamdemo.domain.EventAvro.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.name)) {
        this.name = data().deepCopy(fields()[0].schema(), other.name);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.description)) {
        this.description = data().deepCopy(fields()[1].schema(), other.description);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.version)) {
        this.version = data().deepCopy(fields()[2].schema(), other.version);
        fieldSetFlags()[2] = true;
      }
    }

    /**
     * Creates a Builder by copying an existing EventAvro instance
     * @param other The existing instance to copy.
     */
    private Builder(com.example.streamdemo.domain.EventAvro other) {
      super(SCHEMA$);
      if (isValidValue(fields()[0], other.name)) {
        this.name = data().deepCopy(fields()[0].schema(), other.name);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.description)) {
        this.description = data().deepCopy(fields()[1].schema(), other.description);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.version)) {
        this.version = data().deepCopy(fields()[2].schema(), other.version);
        fieldSetFlags()[2] = true;
      }
    }

    /**
     * Gets the value of the 'name' field.
     * @return The value.
     */
    public java.lang.String getName() {
      return name;
    }

    /**
     * Sets the value of the 'name' field.
     * @param value The value of 'name'.
     * @return This builder.
     */
    public com.example.streamdemo.domain.EventAvro.Builder setName(java.lang.String value) {
      validate(fields()[0], value);
      this.name = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
     * Checks whether the 'name' field has been set.
     * @return True if the 'name' field has been set, false otherwise.
     */
    public boolean hasName() {
      return fieldSetFlags()[0];
    }


    /**
     * Clears the value of the 'name' field.
     * @return This builder.
     */
    public com.example.streamdemo.domain.EventAvro.Builder clearName() {
      name = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
     * Gets the value of the 'description' field.
     * @return The value.
     */
    public java.lang.String getDescription() {
      return description;
    }

    /**
     * Sets the value of the 'description' field.
     * @param value The value of 'description'.
     * @return This builder.
     */
    public com.example.streamdemo.domain.EventAvro.Builder setDescription(java.lang.String value) {
      validate(fields()[1], value);
      this.description = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
     * Checks whether the 'description' field has been set.
     * @return True if the 'description' field has been set, false otherwise.
     */
    public boolean hasDescription() {
      return fieldSetFlags()[1];
    }


    /**
     * Clears the value of the 'description' field.
     * @return This builder.
     */
    public com.example.streamdemo.domain.EventAvro.Builder clearDescription() {
      description = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
     * Gets the value of the 'version' field.
     * @return The value.
     */
    public java.lang.Integer getVersion() {
      return version;
    }

    /**
     * Sets the value of the 'version' field.
     * @param value The value of 'version'.
     * @return This builder.
     */
    public com.example.streamdemo.domain.EventAvro.Builder setVersion(int value) {
      validate(fields()[2], value);
      this.version = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
     * Checks whether the 'version' field has been set.
     * @return True if the 'version' field has been set, false otherwise.
     */
    public boolean hasVersion() {
      return fieldSetFlags()[2];
    }


    /**
     * Clears the value of the 'version' field.
     * @return This builder.
     */
    public com.example.streamdemo.domain.EventAvro.Builder clearVersion() {
      fieldSetFlags()[2] = false;
      return this;
    }

    @Override
    public EventAvro build() {
      try {
        EventAvro record = new EventAvro();
        record.name = fieldSetFlags()[0] ? this.name : (java.lang.String) defaultValue(fields()[0]);
        record.description = fieldSetFlags()[1] ? this.description : (java.lang.String) defaultValue(fields()[1]);
        record.version = fieldSetFlags()[2] ? this.version : (java.lang.Integer) defaultValue(fields()[2]);
        return record;
      } catch (Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  private static final org.apache.avro.io.DatumWriter
      WRITER$ = new org.apache.avro.specific.SpecificDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
      throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  private static final org.apache.avro.io.DatumReader
      READER$ = new org.apache.avro.specific.SpecificDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
      throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

}
