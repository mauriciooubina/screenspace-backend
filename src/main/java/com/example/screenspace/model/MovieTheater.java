package com.example.screenspace.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import java.math.BigDecimal;
import org.springframework.validation.annotation.Validated;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * MovieTheater
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-05-25T13:49:06.606500-03:00[America/Argentina/Buenos_Aires]")

@Entity
public class MovieTheater   {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @JsonProperty("id")
  private Integer id = null;

  @JsonProperty("cinemaId")
  private Integer cinemaId = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("rows")
  private BigDecimal rows = null;

  @JsonProperty("columns")
  private BigDecimal columns = null;

  @JsonProperty("price")
  private BigDecimal price = null;

  @JsonProperty("temporalyClosed")
  private Boolean temporalyClosed = null;

  public MovieTheater id(Integer id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
   **/
  @Schema(example = "11", required = true, description = "")

    public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public MovieTheater cinemaId(Integer cinemaId) {
    this.cinemaId = cinemaId;
    return this;
  }

  /**
   * Get cinemaId
   * @return cinemaId
   **/
  @Schema(example = "1", required = true, description = "")
      @NotNull

    public Integer getCinemaId() {
    return cinemaId;
  }

  public void setCinemaID(Integer cinemaId) {
    this.cinemaId = cinemaId;
  }

  public MovieTheater name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
   **/
  @Schema(example = "Sala 01 Multiplex Belgrano", required = true, description = "")
      @NotNull

    public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public MovieTheater rows(BigDecimal rows) {
    this.rows = rows;
    return this;
  }

  /**
   * Get rows
   * @return rows
   **/
  @Schema(example = "8", required = true, description = "")
      @NotNull

    @Valid
    public BigDecimal getRows() {
    return rows;
  }

  public void setRows(BigDecimal rows) {
    this.rows = rows;
  }

  public MovieTheater columns(BigDecimal columns) {
    this.columns = columns;
    return this;
  }

  /**
   * Get columns
   * @return columns
   **/
  @Schema(example = "8", required = true, description = "")
      @NotNull

    @Valid
    public BigDecimal getColumns() {
    return columns;
  }

  public void setColumns(BigDecimal columns) {
    this.columns = columns;
  }

  public MovieTheater price(BigDecimal price) {
    this.price = price;
    return this;
  }

  /**
   * Get price
   * @return price
   **/
  @Schema(example = "500", required = true, description = "")
      @NotNull

    @Valid
    public BigDecimal getPrice() {
    return price;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }

  public MovieTheater temporalyClosed(Boolean temporalyClosed) {
    this.temporalyClosed = temporalyClosed;
    return this;
  }

  /**
   * Get temporalyClosed
   * @return temporalyClosed
   **/
  @Schema(example = "false", required = true, description = "")
      @NotNull

    public Boolean isTemporalyClosed() {
    return temporalyClosed;
  }

  public void setTemporalyClosed(Boolean temporalyClosed) {
    this.temporalyClosed = temporalyClosed;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MovieTheater movieTheater = (MovieTheater) o;
    return Objects.equals(this.id, movieTheater.id) &&
        Objects.equals(this.cinemaId, movieTheater.cinemaId) &&
        Objects.equals(this.name, movieTheater.name) &&
        Objects.equals(this.rows, movieTheater.rows) &&
        Objects.equals(this.columns, movieTheater.columns) &&
        Objects.equals(this.price, movieTheater.price) &&
        Objects.equals(this.temporalyClosed, movieTheater.temporalyClosed);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, cinemaId, name, rows, columns, price, temporalyClosed);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MovieTheater {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    cinemaID: ").append(toIndentedString(cinemaId)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    rows: ").append(toIndentedString(rows)).append("\n");
    sb.append("    columns: ").append(toIndentedString(columns)).append("\n");
    sb.append("    price: ").append(toIndentedString(price)).append("\n");
    sb.append("    temporalyClosed: ").append(toIndentedString(temporalyClosed)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
