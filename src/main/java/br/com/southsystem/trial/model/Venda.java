/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.southsystem.trial.model;

import java.math.BigDecimal;
import java.util.List;
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
public class Venda {

    private String id;
    private String salesmanName;
    private List<Item> items;

    public BigDecimal getTotal() {
        return items.stream()
                .map(Item::getTotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public static Venda fromString(String line) {
        String[] splitLine = line.split("ç");
        return Venda.builder()
                .setId(splitLine[0])
                .setItems(Item.listFromString(splitLine[1]
                        .replace("[", "")
                        .replace("]", "")))
                .setSalesmanName(splitLine[2])
                .build();
    }
}
