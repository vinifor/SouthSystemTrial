/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.southsystem.trial.reader;

import br.com.southsystem.trial.model.Cliente;
import br.com.southsystem.trial.model.Venda;
import br.com.southsystem.trial.model.Vendedor;
import br.com.southsystem.trial.report.Report;

/**
 *
 * @author vinif
 */
public class DatReader implements ReaderInterface {

    @Override
    public void readline(String line, Report report) {
        switch (line.substring(0, 3)) {
            case "001":
                report.addVendedor(Vendedor.fromString(line.substring(4)));
                break;
            case "002":
                report.addCliente(Cliente.fromString(line.substring(4)));
                break;
            case "003":
                report.addVenda(Venda.fromString(line.substring(4)));
                break;
            default:
                break;
        }
    }
}
