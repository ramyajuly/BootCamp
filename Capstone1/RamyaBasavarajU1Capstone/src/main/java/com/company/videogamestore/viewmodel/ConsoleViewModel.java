package com.company.videogamestore.viewmodel;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * View for console
 */
public class ConsoleViewModel {
    private int consoleId;
    @NotEmpty(message = "Please supply a value for model")
    private String model;
    @NotEmpty(message = "Please supply a value for manufacturer")
    private String manufacturer;
    private String memoryAmount;
    private String processor;
    @NotNull(message = "Please supply a value for price")
    private BigDecimal price;
    @NotNull(message = "Please supply a value for quantity")
    private Integer quantity;

    public int getConsoleId() {
        return consoleId;
    }

    public void setConsoleId(int consoleId) {
        this.consoleId = consoleId;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getMemoryAmount() {
        return memoryAmount;
    }

    public void setMemoryAmount(String memoryAmount) {
        this.memoryAmount = memoryAmount;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
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
        ConsoleViewModel that = (ConsoleViewModel) o;
        return consoleId == that.consoleId &&
                model.equals(that.model) &&
                manufacturer.equals(that.manufacturer) &&
                Objects.equals(memoryAmount, that.memoryAmount) &&
                Objects.equals(processor, that.processor) &&
                price.equals(that.price) &&
                quantity.equals(that.quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(consoleId, model, manufacturer, memoryAmount, processor, price, quantity);
    }
}
