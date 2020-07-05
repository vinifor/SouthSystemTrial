/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.southsystem.trial.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;
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
public class Vendedor implements Serializable {

    private String CPF;
    private String name;
    private BigDecimal salary;

    public static Vendedor fromString(String line){
        String[] splitLine = line.split("ç");
        return Vendedor.builder()
                .setCPF(splitLine[0])
                .setName(splitLine[1])
                .setSalary(new BigDecimal(splitLine[2]))
                .build();
    }
}
