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
 * Review
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-05-25T13:49:06.606500-03:00[America/Argentina/Buenos_Aires]")

@Entity
public class Review   {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @JsonProperty("id")
  private Integer id = null;

  @JsonProperty("userId")
  private Integer userId = null;

  @JsonProperty("movieId")
  private Integer movieId = null;

  @JsonProperty("rating")
  private BigDecimal rating = null;

  @JsonProperty("opinion")
  private String opinion = null;

  public Review id(Integer id) {
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

  public Review userId(Integer userId) {
    this.userId = userId;
    return this;
  }

  /**
   * Get userId
   * @return userId
   **/
  @Schema(example = "1", required = true, description = "")
      @NotNull

    public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  public Review movieId(Integer movieId) {
    this.movieId = movieId;
    return this;
  }

  /**
   * Get movieId
   * @return movieId
   **/
  @Schema(example = "3", required = true, description = "")
      @NotNull

    public Integer getMovieID() {
    return movieId;
  }

  public void setMovieId(Integer movieId) {
    this.movieId = movieId;
  }

  public Review rating(BigDecimal rating) {
    this.rating = rating;
    return this;
  }

  /**
   * Get rating
   * @return rating
   **/
  @Schema(example = "7", required = true, description = "")
      @NotNull

    @Valid
    public BigDecimal getRating() {
    return rating;
  }

  public void setRating(BigDecimal rating) {
    this.rating = rating;
  }

  public Review opinion(String opinion) {
    this.opinion = opinion;
    return this;
  }

  /**
   * Get opinion
   * @return opinion
   **/
  @Schema(example = "Muy buena la pelicula pero larga", required = true, description = "")
      @NotNull

    public String getOpinion() {
    return opinion;
  }

  public void setOpinion(String opinion) {
    this.opinion = opinion;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Review review = (Review) o;
    return Objects.equals(this.id, review.id) &&
        Objects.equals(this.userId, review.userId) &&
        Objects.equals(this.movieId, review.movieId) &&
        Objects.equals(this.rating, review.rating) &&
        Objects.equals(this.opinion, review.opinion);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, userId, movieId, rating, opinion);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Review {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
    sb.append("    movieID: ").append(toIndentedString(movieId)).append("\n");
    sb.append("    rating: ").append(toIndentedString(rating)).append("\n");
    sb.append("    opinion: ").append(toIndentedString(opinion)).append("\n");
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
