/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.southsystem.trial.model;

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
public class Cliente {

    private String CNPJ;
    private String name;
    private String businessArea;
    
    public static Cliente fromString(String line){
        String[] splitLine = line.split("ç");
        return Cliente.builder()
                .setCNPJ(splitLine[0])
                .setName(splitLine[1])
                .setBusinessArea(splitLine[2])
                .build();
    }


}
