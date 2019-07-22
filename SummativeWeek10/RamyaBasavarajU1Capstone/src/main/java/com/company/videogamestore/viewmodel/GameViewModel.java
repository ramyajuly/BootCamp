package com.company.videogamestore.viewmodel;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * View for Game
 */
public class GameViewModel {
    private int gameId;
    @NotEmpty(message = "Please supply a value for TITLE")
    private String title;
    @NotEmpty(message = "Please supply a value for ESRB Rating")
    private String esrbRating;
    @NotEmpty(message = "Please supply a value for DESCRIPTION")
    private String description;
    @NotNull(message = "Please supply a value for PRICE")
    private BigDecimal price;
    @NotEmpty(message = "Please supply a value for STUDIO")
    private String studio;
    @NotNull(message = "Please supply a value for QUANTITY")
    private Integer quantity;

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEsrbRating() {
        return esrbRating;
    }

    public void setEsrbRating(String esrbRating) {
        this.esrbRating = esrbRating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameViewModel that = (GameViewModel) o;
        return gameId == that.gameId &&
                title.equals(that.title) &&
                esrbRating.equals(that.esrbRating) &&
                description.equals(that.description) &&
                price.equals(that.price) &&
                studio.equals(that.studio) &&
                quantity.equals(that.quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gameId, title, esrbRating, description, price, studio, quantity);
    }
}
