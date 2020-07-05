/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.southsystem.trial.report;

import br.com.southsystem.trial.model.Cliente;
import br.com.southsystem.trial.model.Venda;
import br.com.southsystem.trial.model.Vendedor;
import br.com.southsystem.trial.utils.Constants;
import com.google.common.io.Files;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 *
 * @author vinif
 */
public class Report {

    private final String fileName;
    private final List<Cliente> clientes = new ArrayList<>();
    private final List<Vendedor> vendedores = new ArrayList<>();
    private final List<Venda> vendas = new ArrayList<>();

    public Report(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }

    public void addCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public void addVendedor(Vendedor vendedor) {
        vendedores.add(vendedor);
    }

    public void addVenda(Venda venda) {
        vendas.add(venda);
    }
    
    private String getOutputFileName(){
        return Files.getNameWithoutExtension(fileName) + ".done.dat";
    }

    private int quantidadeCliente() {
        return clientes.size();
    }

    private int quantidadeVendedor() {
        return vendedores.size();
    }

    private String vendaMaisCara() {
        return vendas.stream()
                .sorted(Comparator.comparing(Venda::getTotal).reversed())
                .findFirst()
                .get()
                .getId();
    }

    private String piorVendedor() {
        vendas.stream()
                .collect(Collectors.groupingBy(
                        Venda::getSalesmanName, Collectors.reducing(
                                BigDecimal.ZERO, Venda::getTotal, BigDecimal::add)))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .findFirst()
                .get()
                .getKey();

        return vendas.stream()
                .collect(Collectors.groupingBy(
                        Venda::getSalesmanName, Collectors.reducing(
                                BigDecimal.ZERO, Venda::getTotal, BigDecimal::add)))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .findFirst()
                .get()
                .getKey();
    }

    public String output() {
        return "Quantidade de clientes: "
                + quantidadeCliente()
                + "\r\nQuantidade de vendedores: "
                + quantidadeVendedor()
                + "\r\nID da venda mais cara: "
                + vendaMaisCara()
                + "\r\nPior vendedor: "
                + piorVendedor();
    }

    public void write() {
        
        try (FileWriter writer = new FileWriter(Constants.OUT_DIRECTOTY_PATH.concat(getOutputFileName()), false)) {
            writer.write(output());
        } catch (IOException ex) {
            Logger.getLogger(Report.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String toString() {
        return "Report{" + "clientes=" + clientes + ", vendedores=" + vendedores + ", vendas=" + vendas + '}';
    }

}
