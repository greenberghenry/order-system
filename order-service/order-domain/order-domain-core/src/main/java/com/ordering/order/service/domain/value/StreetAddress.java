package com.ordering.order.service.domain.value;

import java.util.Objects;
import java.util.UUID;

public class StreetAddress {
  private final UUID id;
  private final String street;
  private final String city;
  private final String state;
  private final String zip;

  public StreetAddress(UUID id, String street, String city, String state, String zip) {
    this.id = id;
    this.street = street;
    this.city = city;
    this.state = state;
    this.zip = zip;
  }

  public UUID getId() {
    return id;
  }

  public String getStreet() {
    return street;
  }

  public String getCity() {
    return city;
  }

  public String getState() {
    return state;
  }

  public String getZip() {
    return zip;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    StreetAddress that = (StreetAddress) o;
    return Objects.equals(street, that.street)
        && Objects.equals(city, that.city)
        && Objects.equals(state, that.state)
        && Objects.equals(zip, that.zip);
  }

  @Override
  public int hashCode() {
    return Objects.hash(street, city, state, zip);
  }

  @Override
  public String toString() {
    return "StreetAddress{"
        + "id="
        + id
        + ", street='"
        + street
        + '\''
        + ", city='"
        + city
        + '\''
        + ", state='"
        + state
        + '\''
        + ", zip='"
        + zip
        + '\''
        + '}';
  }
}
