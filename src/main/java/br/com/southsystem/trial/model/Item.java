/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.southsystem.trial.model;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 *
 * @author vinif
 */
@Data
@AllArgsConstructor
@Builder(setterPrefix = "set")
public class Item {

    private Long id;
    private BigDecimal quantity;
    private BigDecimal price;

    public BigDecimal getTotal() {
        return quantity.multiply(price);
    }

    public static List<Item> listFromString(String line) {
        return Arrays.asList(line.split(","))
                .stream()
                .map(Item::fromString)
                .collect(Collectors.toList());
    }

    public static Item fromString(String line) {
        String[] splitLine = line.split("-");
        return Item.builder()
                .setId(Long.parseLong(splitLine[0]))
                .setQuantity(new BigDecimal(splitLine[1]))
                .setPrice(new BigDecimal(splitLine[2]))
                .build();
    }
}
