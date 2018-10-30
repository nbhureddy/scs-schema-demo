package com.example.streamdemo.domain;

@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class InsuranceAvro extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"InsuranceAvro\",\"namespace\":\"com.example.demo\",\"fields\":[{\"name\":\"plan\",\"type\":\"string\"},{\"name\":\"company\",\"type\":\"string\"},{\"name\":\"validFrom\",\"type\":\"string\"},{\"name\":\"age\",\"type\":\"int\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
  @Deprecated public java.lang.String plan;
  @Deprecated public java.lang.String company;
  @Deprecated public java.lang.String validFrom;
  @Deprecated public int age;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>. 
   */
  public InsuranceAvro() {}

  /**
   * All-args constructor.
   */
  public InsuranceAvro(java.lang.String plan, java.lang.String company, java.lang.String validFrom, java.lang.Integer age) {
    this.plan = plan;
    this.company = company;
    this.validFrom = validFrom;
    this.age = age;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call. 
  public java.lang.Object get(int field$) {
    switch (field$) {
      case 0: return plan;
      case 1: return company;
      case 2: return validFrom;
      case 3: return age;
      default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }
  // Used by DatumReader.  Applications should not call. 
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
      case 0: plan = (java.lang.String)value$; break;
      case 1: company = (java.lang.String)value$; break;
      case 2: validFrom = (java.lang.String)value$; break;
      case 3: age = (java.lang.Integer)value$; break;
      default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'plan' field.
   */
  public java.lang.String getPlan() {
    return plan;
  }

  /**
   * Sets the value of the 'plan' field.
   * @param value the value to set.
   */
  public void setPlan(java.lang.String value) {
    this.plan = value;
  }

  /**
   * Gets the value of the 'company' field.
   */
  public java.lang.String getCompany() {
    return company;
  }

  /**
   * Sets the value of the 'company' field.
   * @param value the value to set.
   */
  public void setCompany(java.lang.String value) {
    this.company = value;
  }

  /**
   * Gets the value of the 'validFrom' field.
   */
  public java.lang.String getValidFrom() {
    return validFrom;
  }

  /**
   * Sets the value of the 'validFrom' field.
   * @param value the value to set.
   */
  public void setValidFrom(java.lang.String value) {
    this.validFrom = value;
  }

  /**
   * Gets the value of the 'age' field.
   */
  public java.lang.Integer getAge() {
    return age;
  }

  /**
   * Sets the value of the 'age' field.
   * @param value the value to set.
   */
  public void setAge(java.lang.Integer value) {
    this.age = value;
  }

  /** Creates a new InsuranceAvro RecordBuilder */
  public static InsuranceAvro.Builder newBuilder() {
    return new InsuranceAvro.Builder();
  }

  /** Creates a new InsuranceAvro RecordBuilder by copying an existing Builder */
  public static InsuranceAvro.Builder newBuilder(InsuranceAvro.Builder other) {
    return new InsuranceAvro.Builder(other);
  }

  /** Creates a new InsuranceAvro RecordBuilder by copying an existing InsuranceAvro instance */
  public static InsuranceAvro.Builder newBuilder(InsuranceAvro other) {
    return new InsuranceAvro.Builder(other);
  }

  /**
   * RecordBuilder for InsuranceAvro instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<InsuranceAvro>
      implements org.apache.avro.data.RecordBuilder<InsuranceAvro> {

    private java.lang.String plan;
    private java.lang.String company;
    private java.lang.String validFrom;
    private int age;

    /** Creates a new Builder */
    private Builder() {
      super(InsuranceAvro.SCHEMA$);
    }

    /** Creates a Builder by copying an existing Builder */
    private Builder(InsuranceAvro.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.plan)) {
        this.plan = data().deepCopy(fields()[0].schema(), other.plan);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.company)) {
        this.company = data().deepCopy(fields()[1].schema(), other.company);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.validFrom)) {
        this.validFrom = data().deepCopy(fields()[2].schema(), other.validFrom);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.age)) {
        this.age = data().deepCopy(fields()[3].schema(), other.age);
        fieldSetFlags()[3] = true;
      }
    }

    /** Creates a Builder by copying an existing InsuranceAvro instance */
    private Builder(InsuranceAvro other) {
      super(InsuranceAvro.SCHEMA$);
      if (isValidValue(fields()[0], other.plan)) {
        this.plan = data().deepCopy(fields()[0].schema(), other.plan);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.company)) {
        this.company = data().deepCopy(fields()[1].schema(), other.company);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.validFrom)) {
        this.validFrom = data().deepCopy(fields()[2].schema(), other.validFrom);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.age)) {
        this.age = data().deepCopy(fields()[3].schema(), other.age);
        fieldSetFlags()[3] = true;
      }
    }

    /** Gets the value of the 'plan' field */
    public java.lang.String getPlan() {
      return plan;
    }

    /** Sets the value of the 'plan' field */
    public InsuranceAvro.Builder setPlan(java.lang.String value) {
      validate(fields()[0], value);
      this.plan = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /** Checks whether the 'plan' field has been set */
    public boolean hasPlan() {
      return fieldSetFlags()[0];
    }

    /** Clears the value of the 'plan' field */
    public InsuranceAvro.Builder clearPlan() {
      plan = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /** Gets the value of the 'company' field */
    public java.lang.String getCompany() {
      return company;
    }

    /** Sets the value of the 'company' field */
    public InsuranceAvro.Builder setCompany(java.lang.String value) {
      validate(fields()[1], value);
      this.company = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /** Checks whether the 'company' field has been set */
    public boolean hasCompany() {
      return fieldSetFlags()[1];
    }

    /** Clears the value of the 'company' field */
    public InsuranceAvro.Builder clearCompany() {
      company = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /** Gets the value of the 'validFrom' field */
    public java.lang.String getValidFrom() {
      return validFrom;
    }

    /** Sets the value of the 'validFrom' field */
    public InsuranceAvro.Builder setValidFrom(java.lang.String value) {
      validate(fields()[2], value);
      this.validFrom = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /** Checks whether the 'validFrom' field has been set */
    public boolean hasValidFrom() {
      return fieldSetFlags()[2];
    }

    /** Clears the value of the 'validFrom' field */
    public InsuranceAvro.Builder clearValidFrom() {
      validFrom = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    /** Gets the value of the 'age' field */
    public java.lang.Integer getAge() {
      return age;
    }

    /** Sets the value of the 'age' field */
    public InsuranceAvro.Builder setAge(int value) {
      validate(fields()[3], value);
      this.age = value;
      fieldSetFlags()[3] = true;
      return this;
    }

    /** Checks whether the 'age' field has been set */
    public boolean hasAge() {
      return fieldSetFlags()[3];
    }

    /** Clears the value of the 'age' field */
    public InsuranceAvro.Builder clearAge() {
      fieldSetFlags()[3] = false;
      return this;
    }

    @Override
    public InsuranceAvro build() {
      try {
        InsuranceAvro record = new InsuranceAvro();
        record.plan = fieldSetFlags()[0] ? this.plan : (java.lang.String) defaultValue(fields()[0]);
        record.company = fieldSetFlags()[1] ? this.company : (java.lang.String) defaultValue(fields()[1]);
        record.validFrom = fieldSetFlags()[2] ? this.validFrom : (java.lang.String) defaultValue(fields()[2]);
        record.age = fieldSetFlags()[3] ? this.age : (java.lang.Integer) defaultValue(fields()[3]);
        return record;
      } catch (Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }
}
